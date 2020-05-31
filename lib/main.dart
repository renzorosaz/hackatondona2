import 'package:flutter/material.dart';
import 'package:hackaton/src/pages/donacion_page.dart';
import 'package:hackaton/src/pages/menu_page.dart';
<<<<<<< HEAD
import 'package:hackaton/src/pages/perfil_page.dart';
=======
>>>>>>> 2024af9382f0de2030147e16021b176856028767

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
        'perfil' : (BuildContext context) => PerfilPage(),
        'registro' : (BuildContext context) => DonacionPage(),
        'menu' : (BuildContext context) => MenuPage(),
      },
    );

  }
}
