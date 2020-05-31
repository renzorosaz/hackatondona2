import 'dart:io';

import 'package:flutter/material.dart';
import 'package:hackaton/src/Model/donacion_model.dart';
import 'package:hackaton/src/Provider/donacion_provider.dart';
import 'package:image_picker/image_picker.dart';

class DonacionOrgPage extends StatefulWidget {
  @override
  _DonacionOrgPageState createState() => _DonacionOrgPageState();
}

class _DonacionOrgPageState extends State<DonacionOrgPage> {

  final formKey=GlobalKey<FormState>();
  final scaffoldKey=GlobalKey<ScaffoldState>();

  DonacionModel donacion= new DonacionModel();
  bool _guardando = false;
  File foto;

  final donaProvider = new DonacionProvider();  

  @override
  Widget build(BuildContext context) {
    final DonacionModel prodData = ModalRoute.of(context).settings.arguments;
    if(prodData!=null){
      donacion=prodData;
    }

    return Scaffold(
      key: scaffoldKey,
      appBar: AppBar(
        title: Text('Validar Donacion'),
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.camera_alt),
            onPressed: _tomarFoto,
          )          
        ],
      ),
      body: SingleChildScrollView(
        child: Container(
          padding: EdgeInsets.all(15.0),
          child: Form(
            key: formKey,
            child: Column(
              children: <Widget>[
                Text("${donacion.idUsuario}", style: TextStyle(fontSize: 40), textAlign: TextAlign.left,),
                Text("${donacion.fecha}", style: TextStyle(fontSize: 20), textAlign: TextAlign.left,),                
                _mostrarFoto(),
                _mostrarFoto2(),
                _crearNombre(),
                _crearPrecio(),
                _crearBoton(),                
              ],
            ),
          ),
        ),
      ),
    );
  }

    Widget _mostrarFoto(){
    if(donacion.foto != null){
      return FadeInImage(
        image: NetworkImage(donacion.foto),
        placeholder: AssetImage('assets/jar-loading.gif'),
        height: 300.0,
        fit: BoxFit.contain,
      );
    } else {
      return Image(
        image: AssetImage( foto?.path ?? 'assets/no-image.png'),
        height: 300.0,
        fit: BoxFit.cover,
      );
    }
  }

      Widget _mostrarFoto2(){
    if(donacion.fotoOrg != null){
      return FadeInImage(
        image: NetworkImage(donacion.fotoOrg),
        placeholder: AssetImage('assets/jar-loading.gif'),
        height: 300.0,
        fit: BoxFit.contain,
      );
    } else {
      return Image(
        image: AssetImage( foto?.path ?? 'assets/no-image.png'),
        height: 300.0,
        fit: BoxFit.cover,
      );
    }
  }

    Widget _crearPrecio() {
    return TextFormField(
      keyboardType: TextInputType.numberWithOptions(decimal: true),
      decoration: InputDecoration(
        labelText: 'Producto'
      ),
      onSaved: (value) => donacion.puntos = int.parse(value),
    );
  }

    Widget _crearNombre() {
    return TextFormField(      
      textCapitalization: TextCapitalization.sentences,
      maxLines: 5,
      decoration: InputDecoration(
        labelText: 'Descripcion'
      ),
      onSaved: (value) => donacion.descripcion = value,      
      validator: (value) {
        if(value.length < 3){
          return 'Ingrese descripcion';
        } else {
          return null;
        }
      },
    );
  }

  void _tomarFoto() async {

    _procesarImagen(ImageSource.camera);

  }

    _procesarImagen(ImageSource origen) async {
    foto = await ImagePicker.pickImage(
      source: origen
    );

    if(foto!=null){
      donacion.fotoOrg=null;
    }

    setState(() {});    
  }

  Widget _crearBoton() {
    return RaisedButton.icon(
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(20.0)
      ),
      color: Colors.green,
      textColor: Colors.white,
      label: Text('Enviar'),
      icon: Icon(Icons.send),
      onPressed: (_guardando) ? null : _submit,
    );    
  }
  void _submit() async {

    if(!formKey.currentState.validate()) return;

    formKey.currentState.save();

    setState(() {  _guardando=true;  });

    if(foto!=null){
      donacion.fotoOrg = await donaProvider.subirImagen(foto);
    }
      donacion.estado="validado";
      donaProvider.editarDonacion(donacion);


    Navigator.pushNamed(context, 'menu');

  }  
}