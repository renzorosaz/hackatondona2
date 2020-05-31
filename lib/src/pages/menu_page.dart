
import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong/latlong.dart' as d;

class MenuPage extends StatelessWidget {

  const MenuPage({Key key}) : super(key: key);
  

  @override
  Widget build(BuildContext context) {


      return Scaffold(
        body: FlutterMap(
          options: MapOptions(
            center: d.LatLng(-12.169050, -76.972275),
              zoom: 13.0,
            ),
          layers:<LayerOptions>[
            _crearMapa(),      
            _crearMarcadores(),
          ], 
        ),
     
    );
  }

  _crearMapa() {

    return TileLayerOptions(
      urlTemplate: 'https://api.mapbox.com/v4/'
      '{id}/{z}/{x}/{y}@2x.png?access_token={accessToken}',
      additionalOptions: {
        'accessToken': 'pk.eyJ1Ijoia2xlcml0aCIsImEiOiJjanY2MjF4NGIwMG9nM3lvMnN3ZDM1dWE5In0.0SfmUpbW6UFj7ZnRdRyNAw',
        'id': 'mapbox.streets' 
        // streets, dark, light, outdoors, satellite
      }
    );
  }


  _crearMarcadores() {


    return MarkerLayerOptions(      
      markers: <Marker>[        
        Marker(          
          width: 100.0,
          height: 100.0,
          point:  d.LatLng(double.parse('-12.167860') , double.parse(' -76.978123')),
          builder: ( context ) => Container(
            child: IconButton( 
              icon: Icon(Icons.location_on), 
              iconSize: 70.0,
              color: Theme.of(context).primaryColor,
              onPressed: (){
                showModalBottomSheet(                  
                  context: context, 
                  builder: (builder){
                    return Container(
                      child: Form(
                        child: ListView(
                          children: <Widget>[
                            FadeInImage(
                              image: NetworkImage('https://lh3.googleusercontent.com/p/AF1QipM4FQkwKMIBFvSQcGOuuQVLyuIOQd8_ydyaWQ_A=s1600-w1024'),
                              placeholder: AssetImage('assets/jar-loading.gif'),
                              height: 300.0,
                              fit: BoxFit.cover,
                            ),
                            Text('Metro Miotta', textAlign: TextAlign.start, style: TextStyle(fontSize: 20),),
                            SizedBox(height: 5,),
                            Text('Av los alamos 141, a la altura de puente alipio'),
                            SizedBox(height: 5,),
                          ],
                        ),
                      ),
                    );
                  }
                );
              },
            ),            
          )
        ),

        Marker(          
          width: 100.0,
          height: 100.0,
          point:  d.LatLng(double.parse('-12.147551') , double.parse(' -76.981335')),
          builder: ( context ) => Container(
            child: IconButton( 
              icon: Icon(Icons.location_on), 
              iconSize: 70.0,
              color: Theme.of(context).primaryColor,
              onPressed: (){
                showModalBottomSheet(                  
                  context: context, 
                  builder: (builder){
                    return Container(
                      child: Form(
                        child: ListView(
                          children: <Widget>[
                            FadeInImage(
                              image: NetworkImage('https://lh3.googleusercontent.com/p/AF1QipNzB0SgDbF2J3V6DqDEefCYdLPvALxRO1JC_XHp=s1600-w1024'),
                              placeholder: AssetImage('assets/jar-loading.gif'),
                              height: 300.0,
                              fit: BoxFit.cover,
                            ),
                            Text('Real Plaza Atocongo', textAlign: TextAlign.start, style: TextStyle(fontSize: 20),),
                            SizedBox(height: 5,),
                            Text('Carretera Central, panamericana Sur Jose Galvez 245'),
                            SizedBox(height: 5,),
                          ],
                        ),
                      ),
                    );
                  }
                );
              },
            ),            
          )
        ),

        Marker(          
          width: 100.0,
          height: 100.0,
          point:  d.LatLng(double.parse('-12.168558') , double.parse('-76.982938')),
          builder: ( context ) => Container(
            child: IconButton( 
              icon: Icon(Icons.location_on), 
              iconSize: 70.0,
              color: Theme.of(context).primaryColor,
              onPressed: (){
                showModalBottomSheet(                  
                  context: context, 
                  builder: (builder){
                    return Container(
                      child: Form(
                        child: ListView(
                          children: <Widget>[
                            FadeInImage(
                              image: NetworkImage('https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTZJLreyaQCFT5ZoJZUBK88mUENNKmdu2BeWFvYCY5IkT-3umjm&usqp=CAU'),
                              placeholder: AssetImage('assets/jar-loading.gif'),
                              height: 300.0,
                              fit: BoxFit.cover,
                            ),
                            Text('Loza deportiva N°3 Residencial Inclan', textAlign: TextAlign.start, style: TextStyle(fontSize: 20,),),
                            SizedBox(height: 5,),
                            Text('Av los andes de Colon 32, a 3 cuadras del hospital solidaridad'),
                            SizedBox(height: 5,),
                          ],
                        ),
                      ),
                    );
                  }
                );
              },
            ),            
          )
        ),
        
      ]
    );
  }

}