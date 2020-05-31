import 'package:flutter/material.dart';
import 'package:curved_navigation_bar/curved_navigation_bar.dart';
import 'package:hackaton/src/pages/donacion_page.dart';
import 'package:hackaton/src/pages/menu_page.dart';
import 'package:hackaton/src/pages/perfil_page.dart';

void main() => runApp(MaterialApp(home: BottomNavBar()));

class BottomNavBar extends StatefulWidget {
  @override
  _BottomNavBarState createState() => _BottomNavBarState();
}

class _BottomNavBarState extends State<BottomNavBar> {

  

  final PerfilPage _perfil= new PerfilPage();
  final MenuPage _menu= new MenuPage();
  final DonacionPage _donacion= new DonacionPage();
  
  Widget _showPage= new PerfilPage();

  Widget _pageChoosen(int page){
    switch(page){
      case 0:
      return _menu;
      break;
      case 1:
      return _donacion;
      break;
      case 2:
      return _perfil;
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
            Icon(Icons.add_location, size: 30),
            Icon(Icons.favorite, size: 30),
            Icon(Icons.perm_identity, size: 30),
          ],
          color: Colors.white54,
          buttonBackgroundColor: Colors.white70,
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