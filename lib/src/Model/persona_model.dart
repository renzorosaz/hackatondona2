import 'dart:convert';

PersonaModel clientFromJson(String str) => PersonaModel.fromJson(json.decode(str));

String clientToJson(PersonaModel data) => json.encode(data.toJson());

class PersonaModel {
    String apellidoMaterno;
    String apellidoPaterno;
    String codigo;
    int contrasea;
    String direccion;
    bool esDonador;
    String nombre;
    int puntos;
    String usuario;

    PersonaModel({
        this.apellidoMaterno,
        this.apellidoPaterno,
        this.codigo,
        this.contrasea,
        this.direccion,
        this.esDonador,
        this.nombre,
        this.puntos,
        this.usuario,
    });

    factory PersonaModel.fromJson(Map<String, dynamic> json) => PersonaModel(
        apellidoMaterno: json["apellido_materno"],
        apellidoPaterno: json["apellido_paterno"],
        codigo: json["codigo"],
        contrasea: json["contraseña"],
        direccion: json["direccion"],
        esDonador: json["esDonador"],
        nombre: json["nombre"],
        puntos: json["puntos"],
        usuario: json["usuario"],
    );

    Map<String, dynamic> toJson() => {
        "apellido_materno": apellidoMaterno,
        "apellido_paterno": apellidoPaterno,
        "codigo": codigo,
        "contraseña": contrasea,
        "direccion": direccion,
        "esDonador": esDonador,
        "nombre": nombre,
        "puntos": puntos,
        "usuario": usuario,
    };
}
