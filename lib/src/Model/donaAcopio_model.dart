import 'dart:convert';

DonaAcopioModel clientFromJson(String str) => DonaAcopioModel.fromJson(json.decode(str));

String clientToJson(DonaAcopioModel data) => json.encode(data.toJson());

class DonaAcopioModel {
    int estado;
    String mensaje;
    dynamic codigoError;
    dynamic status;
    dynamic confirmacion;
    List<DonaAcopioList> donaAcopioList;

    DonaAcopioModel({
        this.estado,
        this.mensaje,
        this.codigoError,
        this.status,
        this.confirmacion,
        this.donaAcopioList,
    });

    factory DonaAcopioModel.fromJson(Map<String, dynamic> json) => DonaAcopioModel(
        estado: json["estado"],
        mensaje: json["mensaje"],
        codigoError: json["codigoError"],
        status: json["status"],
        confirmacion: json["confirmacion"],
        donaAcopioList: List<DonaAcopioList>.from(json["donaAcopioList"].map((x) => DonaAcopioList.fromJson(x))),
    );

    Map<String, dynamic> toJson() => {
        "estado": estado,
        "mensaje": mensaje,
        "codigoError": codigoError,
        "status": status,
        "confirmacion": confirmacion,
        "donaAcopioList": List<dynamic>.from(donaAcopioList.map((x) => x.toJson())),
    };
}

class DonaAcopioList {
    int idDonacionAcopio;
    String latitud;
    String longitud;
    String nombre;
    String descripcion;
    String direccion;
    bool habilitado;

    DonaAcopioList({
        this.idDonacionAcopio,
        this.latitud,
        this.longitud,
        this.nombre,
        this.descripcion,
        this.direccion,
        this.habilitado,
    });

    factory DonaAcopioList.fromJson(Map<String, dynamic> json) => DonaAcopioList(
        idDonacionAcopio: json["idDonacionAcopio"],
        latitud: json["latitud"],
        longitud: json["longitud"],
        nombre: json["nombre"],
        descripcion: json["descripcion"],
        direccion: json["direccion"],
        habilitado: json["habilitado"],
    );

    Map<String, dynamic> toJson() => {
        "idDonacionAcopio": idDonacionAcopio,
        "latitud": latitud,
        "longitud": longitud,
        "nombre": nombre,
        "descripcion": descripcion,
        "direccion": direccion,
        "habilitado": habilitado,
    };
}