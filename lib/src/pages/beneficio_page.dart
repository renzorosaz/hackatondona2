import 'package:flutter/material.dart';
import 'package:hackaton/src/Model/beneficio_model.dart';
import 'package:hackaton/src/Provider/beneficio_provider.dart';
import 'package:hackaton/src/pages/beneficio_detalle_page.dart';

class BeneficioPage extends StatelessWidget {

  final beneficioProvider = new BeneficioProvider();

    BeneficioModel beneficio= new BeneficioModel();
  bool _guardando = false;
  final productosProvider = new BeneficioModel();  

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        
        title: Text('Beneficios')
      ),
        body: _crearListado(),
    );
  }

  Widget _crearListado() {

    return FutureBuilder(
      future: beneficioProvider.cargarBeneficios(),
      builder: (BuildContext context, AsyncSnapshot<List<BeneficioModel>> snapshot) {
        if(snapshot.hasData){
          
          final beneficio = snapshot.data;

          return ListView.builder(
            itemCount: beneficio.length,
            itemBuilder: (context, i) => _crearItem(beneficio[i], context),
          );

        } else {
          return Center(child: CircularProgressIndicator());
        }
      },
    );

  }

  _crearItem(BeneficioModel beneficio, BuildContext context) {
    return Dismissible(
      key: UniqueKey(),
      background: Container(
        color: Colors.red,
      ),
      child: Card(
        child: Column(
          children: <Widget>[
            ( beneficio.foto == null )
              ? Image(image:AssetImage('assets/no-image.png'))
              : FadeInImage(
                image: NetworkImage(beneficio.foto),
                placeholder: AssetImage('assets/jar-loading.gif'),
                width: double.infinity,
                fit: BoxFit.cover,
              ),
            ListTile(
              title: Text('${beneficio.nombre} - ${beneficio.empresa} '),
              subtitle: Text(beneficio.puntos.toString() + " DonaCoins"),
              /*  onTap: () {Navigator.pushNamed(
                 context,
                  arguments: beneficio,
                );
               } */
               onTap: (){Navigator.push(
                 context,
                  MaterialPageRoute(
                  builder: (context) => BeneficioDetallePage(),
                  ),
                );
               }
                              
            ),
            Text("${beneficio.descripcion}", style: TextStyle(fontSize: 20), textAlign: TextAlign.left,),
                SizedBox(height: 5.0,),
                Text("DonaCoins: ${beneficio.puntos}", style: TextStyle(fontSize: 20), textAlign: TextAlign.left,),
                SizedBox(height: 5.0,),
                Text("Vencimiento: ${beneficio.vencimiento}", style: TextStyle(fontSize: 20), textAlign: TextAlign.left,),
                SizedBox(height: 5.0,),
                _crearBoton(),
          ],
        ),
      )
    );    
  }

  Widget _crearBoton() {
    return RaisedButton.icon(      
      shape: RoundedRectangleBorder(        
        borderRadius: BorderRadius.circular(10.0)
      ),
      color: Colors.green,
      textColor: Colors.white,
      label: Text('Comprar'),
      icon: Icon(Icons.monetization_on),
      onPressed: (_guardando) ? null : _submit,
    );
  }

  void _submit() async {
    

  }
}