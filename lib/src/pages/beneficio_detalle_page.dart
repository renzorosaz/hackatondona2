import 'package:flutter/material.dart';
import 'package:hackaton/src/Model/beneficio_model.dart';


class BeneficioDetallePage extends StatefulWidget {
  @override
  _BeneficioDetallePageState createState() => _BeneficioDetallePageState();
}

class _BeneficioDetallePageState extends State<BeneficioDetallePage> {

  final formKey=GlobalKey<FormState>();
  final scaffoldKey=GlobalKey<ScaffoldState>();

  BeneficioModel beneficio= new BeneficioModel();
  bool _guardando = false;
  final productosProvider = new BeneficioModel();  

  @override
  Widget build(BuildContext context) {

    final BeneficioModel benfData = ModalRoute.of(context).settings.arguments;    


    if(benfData!=null){
      beneficio=benfData;
    }

    return Scaffold(
      key: scaffoldKey,
      appBar: AppBar(
        title: Text('Producto'),
      ),
      body: SingleChildScrollView(
        child: Container(
          padding: EdgeInsets.all(15.0),
          child: Form(
            key: formKey,
            child: Column(
              children: <Widget>[
                _mostrarFoto(),
                Text("${beneficio.nombre} - ${beneficio.empresa}", style: TextStyle(fontSize: 40), textAlign: TextAlign.center,),
                SizedBox(height: 5.0,),
                Text("${beneficio.descripcion}", style: TextStyle(fontSize: 20), textAlign: TextAlign.left,),
                SizedBox(height: 5.0,),
                Text("DonaCoins: ${beneficio.puntos}", style: TextStyle(fontSize: 20), textAlign: TextAlign.left,),
                SizedBox(height: 5.0,),
                Text("Vencimiento: ${beneficio.vencimiento}", style: TextStyle(fontSize: 20), textAlign: TextAlign.left,),
                SizedBox(height: 5.0,),
                _crearBoton(),
              ],
            ),
          ),
        ),
      ),
      
    );
  }

  Widget _mostrarFoto(){
    if(beneficio.foto != null){
      return FadeInImage(
        image: NetworkImage(beneficio.foto),
        placeholder: AssetImage('assets/jar-loading.gif'),
        height: 300.0,
        fit: BoxFit.contain,
      );
    } else {
      return Image(
        image: AssetImage('assets/no-image.png'),
        height: 300.0,
        fit: BoxFit.cover,
      );
    }
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