
import 'package:flutter/material.dart';

class PerfilPage extends StatelessWidget {

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: Text('PERFIL'),
      ),
      body: Stack(
        children: <Widget>[ 
             SingleChildScrollView(
            child: Column(
              children: <Widget>[
                Column(
                  children: <Widget>[
                    _infoPerfil(context),
                     _infoDetalle(context),
                    _infoMedallas(context)
                  ],
                ),
              ],
            ),
          )

        ],

      ),
      bottomNavigationBar: _bottomNavigatorBar(context)
    );
  }

 

  Widget _infoPerfil(BuildContext context){

    return SafeArea(
        child:  Container(
         padding: EdgeInsets.all(15.0),
        margin: EdgeInsets.symmetric(horizontal: 15.0,vertical: 20.0),

          child: Column(
        children: <Widget>[
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: <Widget>[
              Column(       
                crossAxisAlignment: CrossAxisAlignment.start,
                children: <Widget>[
                  Image.asset('assets/dona.jpg', height: 100.0),
                ],
              ),
              Column(
                mainAxisAlignment: MainAxisAlignment.end,
                crossAxisAlignment: CrossAxisAlignment.end,

                    children: <Widget>[
                    Text('Robiño Poliño',style: TextStyle(color:Colors.black,fontSize:15.0,fontWeight: FontWeight.bold),),   
                    Divider(), 
                   Text('200 Donacoins',style: TextStyle(color:Colors.lightBlue[300],fontSize:13.0,fontWeight: FontWeight.w600),),
                   Text('Código: sehi3939 ',style: TextStyle(color:Colors.black,fontSize:13.0,fontWeight: FontWeight.w600),),
                  
                ],
              ),
            ],
          )
        ],
      ),
        )
    );
  
  }

  Widget _infoCoins(BuildContext context){
    
    return SafeArea(      
          child: Container(
            
            padding: EdgeInsets.all(20.0),
           margin: EdgeInsets.symmetric(horizontal: 20.0,vertical: 20.0),
           
           child: Column(   
                    mainAxisAlignment: MainAxisAlignment.end,           
                    children: <Widget>[
                    Text('Robiño Poliño',style: TextStyle(color:Colors.black,fontSize:20.0,fontWeight: FontWeight.bold),),   
                    Divider(),        
                   Text('200 Donacoins',style: TextStyle(color:Colors.lightBlue[300],fontSize:20.0,fontWeight: FontWeight.w600),),
                   Text('Código: sehi3939 ',style: TextStyle(color:Colors.black,fontSize:20.0,fontWeight: FontWeight.w600),),
                      
                ],
              ),            
          ),
    );
  }

  Widget _infoDetalle(BuildContext context){

    return Container(
      padding: EdgeInsets.all(15.0),
      margin: EdgeInsets.symmetric(horizontal: 15.0,vertical: 20.0),
      
      
      child: Column(       
        children: <Widget>[
          Row(
            
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            
            children: <Widget>[
              Column(       
                crossAxisAlignment: CrossAxisAlignment.start,         
                children: <Widget>[
                  Text('Puntos Ganados',style: TextStyle(color:Colors.black,fontSize:20.0,fontWeight: FontWeight.w300),), 
                  Text('Puntos Verificados',style: TextStyle(color:Colors.black,fontSize:20.0,fontWeight: FontWeight.w300),),
                  Text('Puntos Canjeados',style: TextStyle(color:Colors.black,fontSize:20.0,fontWeight: FontWeight.w300),),
                  Text('Mis Donacoins',style: TextStyle(color:Colors.black,fontSize:20.0,fontWeight: FontWeight.w300),),
                  Text('1 donacion= 20 puntos verificados',style: TextStyle(color:Colors.black,fontSize:10.0,fontWeight: FontWeight.w300),),
                  
                ],
              ),
              Column(
                crossAxisAlignment: CrossAxisAlignment.end,  
                children: <Widget>[
                  Text('100',style: TextStyle(color:Colors.black,fontSize:20.0,fontWeight: FontWeight.w300),), 
                  Text('70',style: TextStyle(color:Colors.black,fontSize:20.0,fontWeight: FontWeight.w300),), 
                  Text('20',style: TextStyle(color:Colors.black,fontSize:20.0,fontWeight: FontWeight.w300),), 
                  Text('3.5 ',style: TextStyle(color:Colors.black,fontSize:20.0,fontWeight: FontWeight.w300),), 
                  
                ],
              ),
            ],
          )
        ],
      ),
    );
  }

   Widget _infoMedallas(BuildContext context){
  
    
    final size= MediaQuery.of(context).size;
    
    return SafeArea(      
          child: Container(
            
              padding: EdgeInsets.all(15.0),
              margin: EdgeInsets.symmetric(horizontal: 15.0,vertical: 20.0),
            
            child: Column(    
                  mainAxisAlignment: MainAxisAlignment.spaceAround,
                   crossAxisAlignment: CrossAxisAlignment.start,
                    children: <Widget>[
                    Text('Progreso en Donaciones',style: TextStyle(color:Colors.black,fontSize:20.0,fontWeight: FontWeight.w300),),
                        
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: <Widget>[
                        
                         _crearBotonRedondeadoMedallas(Colors.lightBlueAccent,Icons.flash_auto,'1 DONAS'),
                         _crearBotonRedondeadoMedallas(Colors.lightBlueAccent[50],Icons.flash_auto,'5 DONAS'),
                         _crearBotonRedondeadoMedallas(Colors.lightBlueAccent[100],Icons.flash_auto,' 10 DONAS'),
                      ],                      
                    ),
                      Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: <Widget>[
                         _crearBotonRedondeadoMedallas(Colors.lightBlueAccent[150],Icons.flash_auto,'25 DONAS'),
                         _crearBotonRedondeadoMedallas(Colors.lightBlueAccent[200],Icons.flash_auto,'50 DONAS'),
                         _crearBotonRedondeadoMedallas(Colors.lightBlueAccent[250],Icons.flash_auto,'100 DONAS'),
                      ],                      
                    ),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: <Widget>[
                         _crearBotonRedondeadoMedallas(Colors.lightBlueAccent[300],Icons.flash_auto,'200 DONAS'),
                         _crearBotonRedondeadoMedallas(Colors.lightBlueAccent[400],Icons.flash_auto,'500 DONAS'),
                         _crearBotonRedondeadoMedallas(Colors.lightBlueAccent[50],Icons.flash_auto,'1000 DONAS'),
                      ],                      
                    ),
                                 
                ],
              ),
          ),
    );


    
  }


  Widget _crearBotonRedondeadoMedallas(Color color, IconData icono, String texto){

     return ClipRect(
        /* /* child: BackdropFilter( */
         /* filter: ImageFilter.blur( sigmaX:10.0, sigmaY:10.0), */ */
         child: Container(
           height: 120.0,
           width: 100.0,           
           child: Column(
             mainAxisAlignment: MainAxisAlignment.spaceAround,
             children: <Widget>[
               SizedBox(height: 15.0),              
               CircleAvatar(
                 backgroundColor: color,
                 radius: 20.0,
                 child: Icon( icono, color: Colors.white, size: 20.0),
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
         primaryColor: Colors.white,
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