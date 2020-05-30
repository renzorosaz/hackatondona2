En este paquete se colocan todos los mappers (archivos xml) que implementan las llamadas a las funciones en la base de datos (Se parte del hecho de que el repositorio de datos es una Base de Datos Relacional). Para el ejemplo se está invocando funciones de una base de datos implementada bajo PostgreSQL.

```[xml]

<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
		
<mapper namespace="pe.com.tintegro.sigs.mapper.CategoriaMapper">
	<resultMap id="categoriaResultMap" type = "pe.com.tintegro.sigs.entidad.Categoria">
		<result property = "categoriaID" column = "category_id"/>
		<result property = "nombre" column = "category_name"/>
	</resultMap>
	
	<select id = "obtenerCategorias" resultMap = "categoriaResultMap">
		SELECT * FROM system.fn_get_categories()
	</select>
	
	<select id = "obtenerCategoriaPorID" resultMap = "categoriaResultMap">
		SELECT * FROM system.fn_get_categories_by_id( #{ categoryID } );
	</select>
	
	<select id = "insertarCategoria" resultType = "java.lang.Integer">
		SELECT * FROM system.fn_insert_category( #{ nombre } )
	</select>
	
	<select id = "actualizarCategoria" resultType = "java.lang.Integer">
		SELECT * FROM system.fn_update_category( #{ categoriaID }, #{ nombre } );
	</select>
	
	<select id = "eliminarCategoria" resultType = "java.lang.Integer">
		SELECT * FROM system.fn_delete_category( #{ categoriaID } );
	</select>	
</mapper>	
	

```