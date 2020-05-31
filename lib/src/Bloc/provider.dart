import 'package:flutter/material.dart';
import 'package:hackaton/src/Bloc/persona_bloc.dart';

import 'login_bloc.dart';
export 'login_bloc.dart';


class Provider extends InheritedWidget{

  final loginBloc = LoginBloc();
  final _personaBloc = PersonaBloc(); 




  static Provider _instancia;
  factory Provider({Key key, Widget child}){

      if(_instancia == null){
        _instancia= new Provider._internal(key:key, child: child,);
      }

      
      return _instancia;

  }

    Provider._internal({Key key, Widget child})
  : super(key:key,child:child); 

  

 /*  Provider({Key key, Widget child})
  : super(key:key,child:child); */

  @override
  bool updateShouldNotify(InheritedWidget oldWidget) => true;

  static LoginBloc of ( BuildContext context ){
   return context.dependOnInheritedWidgetOfExactType<Provider>().loginBloc;
  }

  static PersonaBloc personaBloc ( BuildContext context ){
   return context.dependOnInheritedWidgetOfExactType<Provider>()._personaBloc;
  }

}