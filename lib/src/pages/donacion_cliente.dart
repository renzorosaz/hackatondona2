import 'dart:io';

import 'package:flutter/material.dart';
import 'package:hackaton/src/Model/donacion_model.dart';
import 'package:hackaton/src/Provider/donacion_provider.dart';
import 'package:image_picker/image_picker.dart';

class DonacionClientePage extends StatefulWidget {
  @override
  _DonacionClientePageState createState() => _DonacionClientePageState();
}

class _DonacionClientePageState extends State<DonacionClientePage> {

  final formKey=GlobalKey<FormState>();
  final scaffoldKey=GlobalKey<ScaffoldState>();

  final donacionProvider = DonacionProvider();

  DonacionModel donacion= new DonacionModel();
  bool _guardando = false;
  File foto;
  int dona=20;
  final productosProvider = new DonacionProvider();  


  @override
  Widget build(BuildContext context) {

    final DonacionModel prodData = ModalRoute.of(context).settings.arguments;
    if(prodData!=null){
      donacion=prodData;
    }

    return Scaffold(
      key: scaffoldKey,
      appBar: AppBar(
        title: Text('Nueva Donacion'),
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.camera_alt),
            onPressed: _tomarFoto,
          ),
          IconButton(
            icon: Icon(Icons.image),
            onPressed: _seleccionarFoto,
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
                _mostrarFoto(),
                SizedBox(height: 20.0,),
                _crearDescrip(),
                _crearDonac(),
                _crearBoton(),
              ],
            ),
          ),
        ),
      ),
    );
  }
  _tomarFoto() {
    _procesarImagen(ImageSource.camera);
  }

   _seleccionarFoto() async{
    
   _procesarImagen(ImageSource.gallery);

  }
  
   Widget _crearDescrip(){

    return TextFormField(
      textCapitalization: TextCapitalization.sentences,
      decoration: InputDecoration(
        labelText: 'Producto'
      ),
      onSaved: (value)=> donacion.descripcion =value,
      validator: (value){
          if(value.length <3){
            return 'Ingrese el nombre del producto';
          }else{
            return null;
          }
      },
    );

  }

   Widget _crearDonac(){

    return TextFormField(
      initialValue: dona.toString(),
      textCapitalization: TextCapitalization.sentences,
      decoration: InputDecoration(
        labelText: 'Donacion'
      ),/* 
      onSaved: (value)=> donacion. =value, */
      /* validator: (value){
          if(value.length <2){
            return 'Ingresar donacoins';
          }else{
            return null;
          }
      }, */
    );

  }
  _procesarImagen(ImageSource origen) async {
    foto = await ImagePicker.pickImage(
      source: origen
    );

    if(foto!=null){
      donacion.foto=null;
    } 

    setState(() {});    
  }

  Widget _mostrarFoto() {
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
      donacion.foto = await productosProvider.subirImagen(foto);
    }
    donacion.idUsuario="URP123";
    donacion.fecha=DateTime.now().toString();
    donacion.idOrganizacion=1.toString();
    donacion.estado="enviado";
    donacionProvider.crearDonacion(donacion);

Navigator.of(context).pushNamedAndRemoveUntil('perfil', (Route<dynamic> route) => false);
  }
}

