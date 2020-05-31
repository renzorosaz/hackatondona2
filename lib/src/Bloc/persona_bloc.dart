

import 'package:hackaton/models/producto_model.dart';
import 'package:hackaton/src/Provider/persona_provider.dart';
import 'package:rxdart/rxdart.dart';

class PersonaBloc{

   final _personaController = new BehaviorSubject<List<ProductoModel>>();
   final _cargandoController = new BehaviorSubject<bool>();

    final _personaProvider = PersonaProvider();

     Stream<List<ProductoModel>> get productosStream => _personaController.stream;
      Stream<bool> get cargando => _cargandoController.stream;
      
      Future<String> cargarPersona(String codigo) async{

     /*      _cargandoController.sink.add(true);
      await _personaProvider..cargarPersona(codigo);
      _cargandoController.sink.add(false); */

      }
}