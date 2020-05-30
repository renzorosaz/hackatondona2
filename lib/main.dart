import 'package:flutter/material.dart';
import 'package:hackaton/src/pages/login_page.dart';
import 'package:hackaton/src/pages/menu_page.dart';
import 'package:hackaton/src/pages/perfil_page.dart';
import 'package:hackaton/src/pages/registro_page.dart';

void main() async => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyApp createState() => _MyApp();
}

class _MyApp extends State<MyApp>{

  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title:'Prueba Hackaton',
      initialRoute: 'perfil',
      routes: {
        'login' : (BuildContext context) => LoginPage(),
        'registro' : (BuildContext context) => RegistroPage(),
        'menu' : (BuildContext context) => MenuPage(),
        'perfil' : (BuildContext context) => PerfilPage(),
      },
    );

  }
}
