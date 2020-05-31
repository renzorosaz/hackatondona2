import 'package:flutter/material.dart';


import 'package:hackaton/src/pages/donacion_page.dart';
import 'package:hackaton/src/pages/login_page.dart';
import 'package:hackaton/src/pages/menu_page.dart';
import 'package:hackaton/src/pages/nab_page.dart';
import 'package:hackaton/src/pages/perfil_page.dart';
import 'package:hackaton/src/preferencias_usuario/preferencias_usuarios.dart';

 
void main() async {
  
    WidgetsFlutterBinding.ensureInitialized();
    final prefs= new PreferenciasUsuario();
    await prefs.initPrefs();

runApp(MyApp());

}
 
class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
        
      
    return  MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Material App',
      initialRoute:'nab',
      routes: {
        'login' : (BuildContext context) => LoginPage(),
        'nab' : (BuildContext context) => BottomNavBar(),
        'perfil' : (BuildContext context) => PerfilPage(),
        'menu' : (BuildContext context) => MenuPage(),
        'producto' : (BuildContext context) => DonacionPage()
      },
      theme: ThemeData(
        primaryColor: Colors.deepPurple,
      ),

    );

  }
}