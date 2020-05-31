import 'package:flutter/material.dart';
import 'package:hackaton/src/Model/donacion_model.dart';
import 'package:hackaton/src/Provider/donacion_provider.dart';

class DonacionMuniPage extends StatelessWidget {

    final donacionesProvider = new DonacionProvider();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Home')
      ),
        body: _crearListado(),
    );
  }

  Widget _crearListado() {
    return FutureBuilder(
      future: donacionesProvider.cargarDonaciones(),      
      builder: (BuildContext context, AsyncSnapshot<List<DonacionModel>> snapshot) {
        if(snapshot.hasData){
          
          final donaciones = snapshot.data;

          return ListView.builder(
            itemCount: donaciones.length,
            itemBuilder: (context, i) => _crearItem(donaciones[i], context),
          );

        } else {
          return Center(child: CircularProgressIndicator());
        }
      },
    );    
  }

   Widget _crearItem(DonacionModel donaciones, BuildContext context) {
    return Dismissible(
      key: UniqueKey(),
      background: Container(
        color: Colors.red,
      ),
      child: Card(
        child: Column(
          children: <Widget>[
            ( donaciones.foto == null )
              ? Image(image:AssetImage('assets/no-image.png'))
              : FadeInImage(
                image: NetworkImage(donaciones.foto),
                placeholder: AssetImage('assets/jar-loading.gif'),
                width: double.infinity,
                fit: BoxFit.cover,
              ),
            ListTile(
              title: Text('${donaciones.idUsuario}'),
              subtitle: Text(donaciones.fecha),
              onTap: () => Navigator.pushNamed(context, 'donacion_org', arguments: donaciones),

            ),
          ],
        ),
      )
    );
  }
}