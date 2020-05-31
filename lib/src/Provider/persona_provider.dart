import 'dart:convert';
import 'dart:io';


import 'package:hackaton/src/Model/persona_model.dart';
import 'package:hackaton/src/preferencias_usuario/preferencias_usuarios.dart';
import 'package:http/http.dart' as http;


class PersonaProvider{

  final String _url='https//dona2-832e8.firebaseio.com';
  final _prefs = new PreferenciasUsuario();

  
Future<PersonaClass> cargarPersona(int codigo) async{

  int codigo= 123;
    final url = '$_url/persona/asdasd.json';
     final resp= await http.get(url);
  
      final respData = json.decode(resp.body);
      print(respData);
      
      return respData['codigo'] ;
  }
  
  

}