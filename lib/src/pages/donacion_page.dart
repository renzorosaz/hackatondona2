import 'dart:io';

import 'package:flutter/material.dart';
import 'package:hackaton/models/producto_model.dart';
import 'package:image_picker/image_picker.dart';
import 'package:hackaton/utils/utils.dart' as utils;


class DonacionPage extends StatefulWidget {
  DonacionPage({Key key}) : super(key: key);

  @override
  _DonacionPageState createState() => _DonacionPageState();
}

class _DonacionPageState extends State<DonacionPage> {


   ProductoModel producto = new ProductoModel();

  bool _guardando = false;
  File foto;
  int puntos= 20;
  
  @override
  Widget build(BuildContext context) {

    return Scaffold(
     /*  key: scafooldKey, */
      appBar: AppBar(
        title:Text('Donacion'),
        actions: <Widget>[
          IconButton(
            icon: Icon(Icons.photo_size_select_actual),
            onPressed: _seleccionarFoto,
            ),
            IconButton(
            icon: Icon(Icons.camera_alt),
            onPressed: _tomarFoto,
            ),
        ],
      ),
      body: SingleChildScrollView(
        child: Container(
          padding: EdgeInsets.all(15.0),
          child: Form(
          /*   key: formKey, */
            child: Column(
              children: <Widget>[   
                _crearCodigoD(),             
                _crearDescripcion(),
                
                _mostrarFoto(),
                _mostrarPuntos(),
                _crearBoton()
              ],
            ),
           
          ),
        ),
      ),
    );
  }


 Widget  _crearBoton(){
     
        return RaisedButton.icon(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(20.0)
          ),
            color: Colors.blueAccent,
            textColor: Colors.white,
            icon: Icon(Icons.save),
            label: Text('Guardar'),
            onPressed:(  _guardando) ? null : _submit,
        );  
  }

  void _submit() async{


     /*  if(!formKey.currentState.validate()) return;
      
      formKey.currentState.save();

      

      if(foto != null){
        
        producto.fotoUrl = await productosBloc.subirFoto(foto);
      }


      setState(() { _guardando =true;  });

      if(producto.id ==null){
        productosBloc.agregarProducto(producto);
      }else{
        productosBloc.editarProducto(producto);
      }
      

    mostrarSnackbar('Registro Guardado'); */
    
    Navigator.of(context).pushNamedAndRemoveUntil('perfil', (Route<dynamic> route) => false);
  }

   Widget _mostrarPuntos(){

     return TextFormField(
      /*  initialValue: producto.valor.toString(), */
       keyboardType: TextInputType.numberWithOptions(decimal:true),
       initialValue: puntos.toString(),
      textCapitalization: TextCapitalization.sentences,
      decoration: InputDecoration(
        labelText: 'Puntos',
      ),
      /* onSaved: (value)=> producto.valor =double.parse(value), */
      
    );
  }


  Widget _crearCodigoD(){

    return TextFormField(/* 
      initialValue: producto.titulo, */
      textCapitalization: TextCapitalization.sentences,
      decoration: InputDecoration(
        labelText: 'Codigo de Donación'
      ),
     /*  onSaved: (value)=> producto.titulo =value, */
      validator: (value){
          if(value.length <3){
            return 'Ingrese la descripción de la donación';
          }else{
            return null;
          }
      },
    );

  }

   Widget _crearDescripcion(){

    return TextFormField(/* 
      initialValue: producto.titulo, */
      textCapitalization: TextCapitalization.sentences,
      decoration: InputDecoration(
        labelText: 'Descripcion'
      ),
     /*  onSaved: (value)=> producto.titulo =value, */
      validator: (value){
          if(value.length <3){
            return 'Ingrese la descripción de la donación';
          }else{
            return null;
          }
      },
    );

  }

  _mostrarFoto(){
          if (producto.fotoUrl != null) {
      
            return Container(

              padding: EdgeInsets.symmetric(vertical:20.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.stretch,
                children: <Widget>[
                  Text('Foto de al Donación'),
                  FadeInImage(
                    image: NetworkImage(producto.fotoUrl),                 
                    placeholder: AssetImage('carga.gif'),
                    height: 150.0,
                    fit: BoxFit.cover,
                  ),
                ],
              ),
            );
      
          } else {
      
            if( foto != null ){
              return Image.file(
                foto,
                fit: BoxFit.cover,
                height: 150.0,
              );
            }
            return Image.asset('assets/original.png');
          }
  }

  _seleccionarFoto() async{
    
   _procesarImagen(ImageSource.gallery);

  }

  _tomarFoto() async {

    _procesarImagen(ImageSource.camera);
  }


  _procesarImagen(ImageSource origen) async{

       foto = await ImagePicker.pickImage(
      
         source: origen

        );

      if(foto != null){
          producto.fotoUrl = null;
     }

   setState(() {});
   
  }
}