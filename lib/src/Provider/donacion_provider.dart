
import 'dart:convert';
import 'dart:io';

import 'package:hackaton/src/Model/donacion_model.dart';
import 'package:http/http.dart' as http;
import 'package:http_parser/http_parser.dart';
import 'package:mime_type/mime_type.dart';

class DonacionProvider {

  final String _url = "https://dona2-832e8.firebaseio.com/";

  Future<bool> crearDonacion(DonacionModel donacion) async {
    final url = '$_url/donacion.json';

    final resp = await http.post(url, body: donacionToJson(donacion));

    final decodedData = json.decode(resp.body);

    print(decodedData);

    return true;
  }

  Future<List<DonacionModel>> cargarDonaciones() async {
    final url = '$_url/donacion.json';
    final resp = await http.get(url);

    final Map<String, dynamic> decodedData = json.decode(resp.body);
    final List<DonacionModel> donaciones = new List();

    if(decodedData == null ) return [];

    decodedData.forEach((id, prod) { 
      final prodTemp = DonacionModel.fromJson(prod);
      prodTemp.id=id;

      donaciones.add(prodTemp);

    });

    print(donaciones);

    return donaciones;

  }

    Future<bool> editarDonacion(DonacionModel donacion) async {
    final url = '$_url/donacion/${donacion.id}.json';

    final resp = await http.put(url, body: donacionToJson(donacion));

    final decodedData = json.decode(resp.body);

    print(decodedData);

    return true;
  }

  Future<String> subirImagen(File imagen) async {
    final url = Uri.parse('https://api.cloudinary.com/v1_1/db2nwllfm/image/upload?upload_preset=phn9eeku');
    final mimeType = mime(imagen.path).split('/'); //image/jpeg

    final imageUploadRequest = http.MultipartRequest(
      'POST',
      url
    );

    final file = await http.MultipartFile.fromPath(
      'file',
      imagen.path,
      contentType: MediaType(mimeType[0], mimeType[1])
      );

      imageUploadRequest.files.add(file);

      final streamResponse = await imageUploadRequest.send();
      final resp = await http.Response.fromStream(streamResponse);

      if(resp.statusCode != 200 && resp.statusCode != 201){
        print('algo salio mal');
        print(resp.body);
        return null;
      }

      final respData = json.decode(resp.body);

      print(respData);

      return respData['secure_url'];

  }
}