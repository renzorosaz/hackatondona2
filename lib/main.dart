import 'package:flutter/material.dart';
import 'package:curved_navigation_bar/curved_navigation_bar.dart';
import 'package:hackaton/src/pages/beneficio_detalle_page.dart';

import 'package:hackaton/src/pages/beneficio_page.dart';
import 'package:hackaton/src/pages/donacion_cliente.dart';

import 'package:hackaton/src/pages/menu_page.dart';
import 'package:hackaton/src/pages/perfil_page.dart';
import 'package:hackaton/src/pages_organizacion/listar_donacion_muni_page.dart';
import 'package:hackaton/src/pages_organizacion/registrar_donacion_page.dart';

void main() => runApp(MaterialApp(home: BottomNavBar()));

class BottomNavBar extends StatefulWidget {
  @override
  _BottomNavBarState createState() => _BottomNavBarState();
}

class _BottomNavBarState extends State<BottomNavBar> {
  

  final PerfilPage _perfil= new PerfilPage();
  final MenuPage _menu= new MenuPage();
  final BeneficioPage _beneficio= new BeneficioPage();
  final DonacionClientePage _donacli = new DonacionClientePage();
  final DonacionMuniPage _donamuni = new DonacionMuniPage();
  final DonacionOrgPage _donaorg = new DonacionOrgPage();
  
  Widget _showPage= new PerfilPage();

  Widget _pageChoosen(int page){
    switch(page){
      case 0:
      return _perfil;
      break;
      case 1:
      return _menu;
      break;
      case 2:
      return _beneficio;
      break;      
      case 3:
      return _donacli;
      break;   
      case 4:
      return _donamuni;
      break; 
      case 5:
      return _donaorg;
      break;    
      default:
      return new Container(
        child: new Center(
          child: new Text(
            'No page Found'
          ),
        ),
      );
    }
  }

  GlobalKey _bottomNavigationKey = GlobalKey();


  @override
  Widget build(BuildContext context) {
    return Scaffold(
        
        bottomNavigationBar: CurvedNavigationBar(
          key: _bottomNavigationKey,
          index: 0,
          height: 50.0,
          items: <Widget>[
            Icon(Icons.perm_identity, size: 30),
            Icon(Icons.location_on, size: 30),
            Icon(Icons.card_giftcard, size: 30),
            Icon(Icons.pan_tool, size: 30),
            Icon(Icons.category, size: 30),
            Icon(Icons.check_box, size: 30),
          ],
          color: Colors.blue,
          buttonBackgroundColor: Colors.blueAccent,
          backgroundColor: Colors.black.withOpacity(0.5),
          animationCurve: Curves.easeInOut,          
          animationDuration: Duration(milliseconds: 600),
          onTap: (int tappedIndex) {
            setState(() {
              _showPage = _pageChoosen(tappedIndex);
            });
          },
        ),
        body: Container(
          child: Center(
            child: _showPage
          ),
        ));
  }
}