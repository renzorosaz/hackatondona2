import 'dart:math';

import 'package:flutter/material.dart';

class PerfilPage extends StatelessWidget {
  const PerfilPage({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Text('PERFIL'),
      ),
      body: Stack(
        children: <Widget>[
          _fondoApp(),

          SingleChildScrollView(
            child: Column(
              children: <Widget>[
                _infoPerfil(),
                _infoCoins(context),
                _infoMedallas(context) 
              ],
            ),
          )

        ],

      ),
      bottomNavigationBar: _bottomNavigatorBar(context)
    );
  }

  Widget _fondoApp(){

    final gradiente = Container(
      width:double.infinity,
      height: double.infinity,
      decoration: BoxDecoration(
        gradient: LinearGradient(
          begin: FractionalOffset(0.0, 0.6),
          end:FractionalOffset(0.0, 1.0),
          colors: [
            Color.fromRGBO(76, 186, 237, 1.0),
            Color.fromRGBO(126, 202, 237, 1.0),
          ]
          )
      ),
    );

      final cajaCeleste=Transform.rotate(
        angle: -pi/4.0,

        child:Container(
          height: 360.0,
          width: 360.0,
          decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(80.0),
            gradient: LinearGradient(
              colors: [
                Color.fromRGBO(91, 236, 236, 1.0),
                Color.fromRGBO(159, 236, 236, 1.0),
              ]
            )
          ),
        )
     );


    return Stack(
      children: <Widget>[
        gradiente,
        Positioned(
          top:-100.0,
          child: cajaCeleste
          )
      ],
    );

  }

  Widget _infoPerfil(){
  
    return SafeArea(
        child: Container(          
          height: 180.0,
          padding: EdgeInsets.all(10.0),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: <Widget>[

              Center(
                child: Card(
                     child: Image.asset('assets/beba.jpg', height: 180.0, ),
                    elevation: 50.0,
                    shape: CircleBorder(),
                    clipBehavior: Clip.antiAlias,
                  ),
               
              ),

               Text('Josefina Flutter',style: TextStyle(color:Colors.white,fontSize:25.0,fontWeight: FontWeight.bold),),
            ],
          ),
        )
    );
  }

  Widget _infoCoins(BuildContext context){
  
    return SafeArea(      
          child: Container(
          padding: EdgeInsets.all(20.0),
          child: Row(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
           _crearBotonRedondeadoDona(context, Colors.pinkAccent[700],'DonaCoins'),
         
          ],
        ),
      ),
    );
  }

   Widget _infoMedallas(BuildContext context){
  
    return Table(
      
       children: [
         TableRow(
           children: [
             _crearBotonRedondeadoMedallas(Colors.pinkAccent[700],Icons.person,'Perfil'),
             _crearBotonRedondeadoMedallas(Colors.redAccent,Icons.business,'Donaciones')

           ]
         ),
         TableRow(
           children: [
             _crearBotonRedondeadoMedallas(Colors.tealAccent,Icons.store_mall_directory,'Promociones'),
             _crearBotonRedondeadoMedallas(Colors.lightGreenAccent,Icons.supervisor_account,'Municipios y ONGs')
           ]
         ),         
       ],
     );
  }



  Widget _crearBotonRedondeadoDona(BuildContext context,Color color, String texto){

      final size= MediaQuery.of(context).size;
    
     return ClipRect(        
         child: Container(
           height: size.height * 0.20,
           width: size.width * 0.9,
           decoration: BoxDecoration(
             color: Color.fromRGBO(62, 66, 107, 0.7),
             borderRadius: BorderRadius.circular(20.0)
           ),  
           child: Column(
             mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: <Widget>[
                 Text('DonaCoins',style: TextStyle(color:Colors.white,fontSize:30.0,fontWeight: FontWeight.bold),),
                 Text('200 DonaCoins',style: TextStyle(color:Colors.white,fontSize:30.0,fontWeight: FontWeight.bold),)
                 
              ],
           ),

         ),
         

     /*   ), */
     );

   }

  Widget _crearBotonRedondeadoMedallas(Color color, IconData icono, String texto){


     return ClipRect(
        /* child: BackdropFilter( */
         /* filter: ImageFilter.blur( sigmaX:10.0, sigmaY:10.0), */
         child: Container(
           height: 180.0,
           margin: EdgeInsets.all(15.0),
           decoration: BoxDecoration(
             color: Color.fromRGBO(62, 66, 107, 0.7),
             borderRadius: BorderRadius.circular(20.0)
           ),
           child: Column(
             mainAxisAlignment: MainAxisAlignment.spaceAround,
             children: <Widget>[
               SizedBox(height: 5.0),
               CircleAvatar(
                 backgroundColor: color,
                 radius: 55.0,
                 child: Icon( icono, color: Colors.white, size: 50.0),
               ),
               Text(texto,style: TextStyle( color: color )),
               SizedBox(height: 5.0)
             ],
           ),
         ),
     /*   ), */
     );

   }

 

   
   
  Widget _bottomNavigatorBar(BuildContext context){

    return new Theme(
      data: Theme.of(context).copyWith(
         canvasColor: Color.fromRGBO(76, 186, 237, 1.0) ,
         primaryColor: Colors.grey,
         textTheme: Theme.of(context).textTheme.copyWith(
           caption:TextStyle(color: Color.fromRGBO(116, 117, 152, 1.0))
         )
      ),
      child: BottomNavigationBar(

        items:[
          BottomNavigationBarItem(
            icon:Icon(Icons.dehaze,size:35.0),
            title: Container(),
          ),
          BottomNavigationBarItem(
            icon:Icon(Icons.add_shopping_cart,size:35.0),
             title: Container(),
          ),
          BottomNavigationBarItem(
            icon:Icon(Icons.mood,size:35.0),
             title: Container(),
          )
        ] ,
      ),
    );

  }

}