import 'dart:convert';

import 'package:hackaton/src/Model/donaAcopio_model.dart';
import 'package:http/http.dart' as http;
import 'package:http_parser/http_parser.dart' as http;

class DonaAcopioProvider{

  final String _url = "http://35.202.115.59/dona2/donaAcopio";

  Future<List<DonaAcopioList>> cargarProductos() async {
    final url = '$_url/obtener-puntos-acopio';
    final resp = await http.get(url);

    final Map<String, dynamic> decodedData = json.decode(resp.body);
    List<dynamic> data = decodedData["donaAcopioList"];
    final List<DonaAcopioList> productos = new List();

    if(decodedData == null ) return [];

    for(final id in data){
      final prodTemp = DonaAcopioList.fromJson(id);        

      

      productos.add(prodTemp);
    }

    return productos;
  }
}

