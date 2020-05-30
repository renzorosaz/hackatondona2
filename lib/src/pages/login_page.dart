import 'package:flutter/material.dart';

class LoginPage extends StatelessWidget {

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      body:Stack(
        children: <Widget>[
          _logo(),
          _crearFondo(context),
          _loginForm(context),
        ],
      )
    );
  }
  
  Widget _logo(){
   return
       Container(
         decoration: BoxDecoration(
            color: Colors.transparent,
            image: DecorationImage(
              fit: BoxFit.fill,
              image: AssetImage(
                'assets/dona.jpg',
              ),
            ),
          ),
          height: 350.0,
       );     
    
  }
  Widget _loginForm(BuildContext context){

    final size= MediaQuery.of(context).size;

    return SingleChildScrollView(
      child: Column(
        children: <Widget>[
          
          SafeArea(
            child: Container(
              height: 180.0,
            ),
          ),
          
          Container(
            width:  size.width * 0.85 ,
            margin: EdgeInsets.symmetric(vertical: 70.0),
            padding: EdgeInsets.symmetric(vertical: 50.0),
            decoration: BoxDecoration(
              color:Colors.white,
              borderRadius: BorderRadius.circular(5.0),
              boxShadow: <BoxShadow>[
                BoxShadow(
                  color: Colors.black26,
                  blurRadius: 3.0,
                  offset: Offset(0.0 ,5.0),
                  spreadRadius:3.0
                )
              ]
              
            ),
            child: Column(
              children: <Widget>[
                Text('Ingreso', style : TextStyle(fontSize: 20.0)),
                SizedBox(height: 60.0),
                _crearEmail(),
                 SizedBox(height: 30.0),
                 _crearPassword(), 
                 SizedBox(height: 30.0),
                 _crearBoton(context),
              ],
            ),
            
          ),

          FlatButton(
            child: Text('Crear una nueva cuenta'),
            onPressed: ()=> Navigator.pushReplacementNamed(context, 'registro'),

            ),
          SizedBox(height:100.0)
        ],
      ),
    );
  }

  Widget _crearEmail(){

    /* return  StreamBuilder(/ */
      /* stream: bloc.emailStream , */ 
      /* builder: (BuildContext context, AsyncSnapshot snapshot){ */
        return Container(      
        padding: EdgeInsets.symmetric(horizontal:20.0),

       child: TextField(
          keyboardType: TextInputType.emailAddress,
          decoration: InputDecoration(
            icon: Icon(Icons.alternate_email, color: Colors.blue[300]),
            hintText: 'ejemplo@correo.com',
            labelText: 'Correo electronico',
            /* counterText: snapshot.data,
            errorText: snapshot.error */
          ),
          /* onChanged:(value) => bloc.changeEmail(value) , */
       ),
     /*  ); */
      /* }, */
    );

  }

  Widget _crearPassword(){

    /* return StreamBuilder(
      stream: bloc.passwordStream ,
      builder: (BuildContext context, AsyncSnapshot snapshot){ */

          

          return Container(
        padding: EdgeInsets.symmetric(horizontal:20.0),
        child: TextField(
          obscureText: true,
          decoration: InputDecoration(
            icon: Icon(Icons.lock, color: Colors.blue[300]),
            labelText: 'Contraseña',
             /* counterText: snapshot.data,
             errorText: snapshot.error */
          ),
          /* onChanged: bloc.changePassword, */
        ),
      );
     /*  },
    ); */
    

  }

  Widget _crearBoton(BuildContext context){

   /*  return StreamBuilder(
      stream: bloc.formValidStream,
      builder: (BuildContext context, AsyncSnapshot snapshot){ */

          return RaisedButton(
             child: Container(
            padding: EdgeInsets.symmetric(horizontal:80.0, vertical:15.0),
            child: Text('Ingresar'),
            ),
            shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(5.0)
           ),
           elevation: 0.0,
           color:Colors.blue[200],
           textColor: Colors.white,
           onPressed: /* snapshot.hasData ? ()=> _login(context,bloc) */
           ()=> _login(context)
          );
/* 
      },
    ); */
  }

  _login(BuildContext context) async {
    
      
  /*  Map info = await  usuarioProvider.login(bloc.email, bloc.password);
      
        print(info['ok']);
    
        if(info['ok']) {    
         Navigator.pushReplacementNamed(context, 'home');
        }else{
          mostrarAlerta( context, info['mensaje'] );
        } */

        Navigator.pushReplacementNamed(context, 'menu');
  }

  Widget _crearFondo(BuildContext context){
  
    
   return Stack(children: <Widget>[

        Container(
          decoration: BoxDecoration(
            color: Colors.transparent,
            image: DecorationImage(
              fit: BoxFit.fill,
              image: AssetImage(
                'assets/donacion.jpg',
              ),
            ),
          ),
          height: 350.0,
        ),
        
         Container(
          height: 350.0,
          decoration: BoxDecoration(
              color: Colors.white,
              gradient: LinearGradient(
                begin: FractionalOffset.topCenter,
                end: FractionalOffset.bottomCenter,
              colors: [
                
                    Colors.grey.withOpacity(0.0),
                    Colors.blue[100],
                  ],
                  stops: [0.1, 1.0]
              )
              
              ),
        ),
        Align(
          alignment: Alignment.topCenter,
             child: Container(
             margin: EdgeInsets.symmetric(vertical: 180.0),
             decoration: BoxDecoration(               
                color: Colors.transparent,
                image: DecorationImage(
                  fit: BoxFit.fill,
                  image: AssetImage(
                    'assets/dona.jpg',
                  ),
                ),
                boxShadow: <BoxShadow>[
                BoxShadow(
                  color: Colors.black26,
                  blurRadius: 3.0,
                  offset: Offset(0.0 ,5.0),
                  spreadRadius:3.0
                )
              ]
              ),
              height: 90.0,
              width: 90.0,
       ),
        ),
      ]); 

  }    


}