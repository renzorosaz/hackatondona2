import 'package:hackaton/src/Model/persona_model.dart';
import 'dart:convert';
import 'package:http/http.dart' as http;

class PersonalProvider{

    final String _url = "https://dona2-832e8.firebaseio.com/";


    Future<List<PersonaModel>> cargarProductos() async {
    final url = '$_url/persona/asdasd.json';
    final resp = await http.get(url);

    final Map<String, dynamic> decodedData = json.decode(resp.body);
    final List<PersonaModel> productos = new List();

    if(decodedData == null ) return [];

    decodedData.forEach((id, prod) { 
      final prodTemp = PersonaModel.fromJson(prod);

      productos.add(prodTemp);

    });

    print(productos);

    return productos;

  }
}