import 'dart:convert';

import 'package:hackaton/src/Model/beneficio_model.dart';
import 'package:http/http.dart' as http;

class BeneficioProvider {

  final String _url = "https://dona2-832e8.firebaseio.com";

  Future<bool> crearBeneficio(BeneficioModel beneficio) async {
    final url = '$_url/beneficio.json';

    final resp = await http.post(url, body: beneficioToJson(beneficio));

    final decodedData = json.decode(resp.body);

    print(decodedData);

    return true;
  }

  Future<List<BeneficioModel>> cargarBeneficios() async {
    final url = '$_url/beneficio.json';
    final resp = await http.get(url);

    final Map<String, dynamic> decodedData = json.decode(resp.body);
    final List<BeneficioModel> productos = new List();

    if(decodedData == null ) return [];

    decodedData.forEach((id, prod) { 
      final prodTemp = BeneficioModel.fromJson(prod);
      prodTemp.id=id;

      productos.add(prodTemp);

    });

    print(productos);

    return productos;

  }

    Future<bool> editarBeneficio(BeneficioModel producto) async {
    final url = '$_url/Productos/${producto.id}.json';

    final resp = await http.put(url, body: beneficioToJson(producto));

    final decodedData = json.decode(resp.body);

    print(decodedData);

    return true;
  }
}