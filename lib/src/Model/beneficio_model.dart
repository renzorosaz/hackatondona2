// To parse this JSON data, do
//
//     final client = clientFromJson(jsonString);

import 'dart:convert';

BeneficioModel beneficioFromJson(String str) => BeneficioModel.fromJson(json.decode(str));

String beneficioToJson(BeneficioModel data) => json.encode(data.toJson());

class BeneficioModel {
    String id;
    String descripcion;
    String foto;
    String nombre;
    int puntos;
    String vencimiento;
    String empresa;    

    BeneficioModel({
        this.id,
        this.descripcion,
        this.foto,
        this.nombre,
        this.puntos,
        this.vencimiento,
        this.empresa,

    });

    factory BeneficioModel.fromJson(Map<String, dynamic> json) => BeneficioModel(
        id: json["id"],
        descripcion: json["descripcion"],
        foto: json["foto"],
        nombre: json["nombre"],
        puntos: json["puntos"],
        vencimiento: json["vencimiento"],
        empresa: json["empresa"],
        
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "descripcion": descripcion,
        "foto": foto,
        "nombre": nombre,
        "puntos": puntos,
        "vencimiento": vencimiento,
        "empresa": empresa,

    };
}
