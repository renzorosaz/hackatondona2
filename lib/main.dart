import 'package:flutter/material.dart';
import 'package:hackaton/src/pages/donacion_page.dart';
import 'package:hackaton/src/pages/menu_page.dart';
import 'package:hackaton/src/pages/perfil_page.dart';

void main() async => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyApp createState() => _MyApp();
}
//prueba
class _MyApp extends State<MyApp>{

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title:'Prueba Hackaton',
      initialRoute: 'perfil',
      routes: {
        'perfil' : (BuildContext context) => PerfilPage(),
        'registro' : (BuildContext context) => DonacionPage(),
        'menu' : (BuildContext context) => MenuPage(),
      },
    );

  }
}
