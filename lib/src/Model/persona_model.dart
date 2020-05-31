// To parse this JSON data, do
//
//     final persona = personaFromJson(jsonString);

import 'dart:convert';

Persona personaFromJson(String str) => Persona.fromJson(json.decode(str));

String personaToJson(Persona data) => json.encode(data.toJson());

class Persona {
    PersonaClass persona;

    Persona({
        this.persona,
    });

    factory Persona.fromJson(Map<String, dynamic> json) => Persona(
        persona: PersonaClass.fromJson(json["persona"]),
    );

    Map<String, dynamic> toJson() => {
        "persona": persona.toJson(),
    };
}

class PersonaClass {
    String apellidoMaterno;
    String apellidoPaterno;
    int codigo;
    String direccion;
    bool esDonador;
    String nombre;
    String usuario;

    PersonaClass({
        this.apellidoMaterno,
        this.apellidoPaterno,
        this.codigo,
        this.direccion,
        this.esDonador,
        this.nombre,
        this.usuario,
    });

    factory PersonaClass.fromJson(Map<String, dynamic> json) => PersonaClass(
        apellidoMaterno: json["apellido_materno"],
        apellidoPaterno: json["apellido_paterno"],
        codigo: json["codigo"],
        direccion: json["direccion"],
        esDonador: json["esDonador"],
        nombre: json["nombre"],
        usuario: json["usuario"],
    );

    Map<String, dynamic> toJson() => {
        "apellido_materno": apellidoMaterno,
        "apellido_paterno": apellidoPaterno,
        "codigo": codigo,
        "direccion": direccion,
        "esDonador": esDonador,
        "nombre": nombre,
        "usuario": usuario,
    };
}
