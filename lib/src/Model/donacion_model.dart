// To parse this JSON data, do
//
//     final client = clientFromJson(jsonString);

import 'dart:convert';

DonacionModel donacionFromJson(String str) => DonacionModel.fromJson(json.decode(str));

String donacionToJson(DonacionModel data) => json.encode(data.toJson());

class DonacionModel {
    String descripcion;
    String fecha;
    String foto;
    String id;
    String idUsuario;
    String idOrganizacion;
    int puntos;
    String fotoOrg;
    String estado;
    
    

    DonacionModel({
        this.descripcion,
        this.fecha,
        this.foto,
        this.id,
        this.idUsuario,
        this.idOrganizacion,
        this.puntos,
        this.fotoOrg,
        this.estado,
        
    });

    factory DonacionModel.fromJson(Map<String, dynamic> json) => DonacionModel(
        descripcion: json["descripcion"],
        fecha: json["fecha"],
        foto: json["foto"],
        id: json["id"],
        idUsuario: json["idUsuario"],
        idOrganizacion: json["id_organizacion"],
        puntos: json["puntos"],
        fotoOrg: json["foto_org"],
        estado: json["estado"],

    );

    Map<String, dynamic> toJson() => {
        "descripcion": descripcion,
        "fecha": fecha,
        "foto": foto,
        "id": id,
        "idUsuario": idUsuario,
        "id_organizacion": idOrganizacion,
        "puntos": puntos,
        "foto_org": fotoOrg,
        "estado": estado,
        
    };
}
