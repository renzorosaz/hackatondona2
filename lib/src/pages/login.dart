import 'package:flutter/material.dart';

class LoginPage extends StatefulWidget {

  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  String email="";

  String pass="";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: <Widget>[
          _loginForm(context),
        ],
      ),
    );
  }

  Widget _loginForm(BuildContext context) {

    final size=MediaQuery.of(context).size;    

    return SingleChildScrollView(
      child: Column(
        children: <Widget>[
          SafeArea(
            child: Container(
              height: 180.0,
            ),
          ),

          Container(
            width: size.width * 0.80,
            padding: EdgeInsets.symmetric(vertical: 50.0),
            margin: EdgeInsets.symmetric(vertical: 20.0),
            decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.circular(5.0),
              boxShadow: <BoxShadow>[
                BoxShadow(
                  color: Colors.black26,
                  blurRadius: 3.0,
                  offset: Offset(0.0, 5.0),
                  spreadRadius: 3.0
                )
              ]
            ),
            child: Column(
              children: <Widget>[
                Text('Ingreso', style: TextStyle(fontSize: 20.0),),
                SizedBox(height: 40.0,),
                _crearEmail(),
                SizedBox(height: 20,),
                _crearPassword(),
                SizedBox(height: 20,),
                _crearBoton(context),
              ],
            ),
          ),
          Text('¿Olvido la contraseña?'),
          SizedBox(height: 100.0,)
        ],
      ),
    );    

  }

  Widget _crearEmail() {
    return Container(
      padding: EdgeInsets.symmetric(horizontal: 20.0),
      child: TextFormField(
        keyboardType: TextInputType.emailAddress,
        decoration: InputDecoration(
          icon: Icon(Icons.alternate_email, color: Colors.deepPurple,),
          hintText: 'ejemplo@correo.com',
          labelText: 'Correo electronico',
        ),
        onSaved: (value) => email=value,
      ),
    );
  }

  Widget _crearPassword() {

    
  return Container(
    padding: EdgeInsets.symmetric(horizontal: 20.0),      
    child: TextFormField(
        obscureText: true,
        decoration: InputDecoration(
          icon: Icon(Icons.security, color: Colors.deepPurple,),
          hintText: 'Contraseña',
          labelText: 'Constraseña',
        ),
        onSaved: (value) => pass=value,
      ),
  );
}

    Widget _crearBoton(BuildContext context){
    
    return RaisedButton(
      child: Container(
        padding: EdgeInsets.symmetric(horizontal: 80.0, vertical: 15.0),
        child: Text('Ingresar'),
      ),
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(5.0),
      ),
      elevation: 0.0,
      color: Colors.deepPurple,
      textColor: Colors.white,
      onPressed: () {
        if(email=="user@gmail.com" && pass=="123"){
          Navigator.pushNamed(context, 'menu');
        }
        else if(email=="org@gmail.com" || pass=="123"){
          Navigator.pushNamed(context, 'listar_donaciones_org');
        }else{
          return;
        }
      },
    );
    }
}