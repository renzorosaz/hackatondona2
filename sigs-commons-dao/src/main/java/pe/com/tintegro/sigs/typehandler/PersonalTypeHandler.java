///**
// * 
// */
//package pe.com.tintegro.sigs.typehandler;
//
//import java.sql.CallableStatement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.ibatis.type.BaseTypeHandler;
//import org.apache.ibatis.type.JdbcType;
//import org.apache.ibatis.type.MappedTypes;
//
//import pe.com.tintegro.sigs.entidad.Personal;
//import pe.com.tintegro.sigs.entidad.general.Item;
//
///**
// * @author daniel - 26 set. 2017
// *
// */
//@MappedTypes(value = Personal.class)
//@SuppressWarnings("rawtypes")
//public class PersonalTypeHandler extends BaseTypeHandler<Personal>
//{
//	private static final Map<Enum, String> MAP_ATTRIBUTE_TO_COLUMN;
//
//	private static enum PERSONAL_VALUES { ID_PERSONAL, CODIGO_PERSONAL, APE_PATERNO, APE_MATERNO, NOMBRE, FE_NACIMIENTO,
//												     MAX_HORAS_NORMALES, MAX_HORAS_EXTRAS, MAX_HORAS_EXTRA_DIA, TIPO_STAFF, EMAIL,
//												     RUC, CUPOS_ADICIONALES, CODIGO_UBIGEO, ID_SEXO, NO_SEXO, ID_ESTADO_CIVIL, NO_ESTADO_CIVIL,
//												     ID_TIPO_DOCUMENTO_IDENTIDAD, NO_TIPO_DOCUMENTO_IDENTIDAD, ID_GRUPO_OCUPACIONAL, NO_GRUPO_OCUPACIONAL }
//	
//	static
//	{
//		Map<Enum, String> map = new HashMap<>();
//
//		map.put(PERSONAL_VALUES.ID_PERSONAL, "id_personal");
//		map.put(PERSONAL_VALUES.CODIGO_PERSONAL, "codigo_personal");
//		map.put(PERSONAL_VALUES.APE_PATERNO, "apellido_paterno_personal");
//		map.put(PERSONAL_VALUES.APE_MATERNO, "apellido_materno_personal");
//		map.put(PERSONAL_VALUES.NOMBRE, "nombre_personal");
//		map.put(PERSONAL_VALUES.FE_NACIMIENTO, "fe_nacimiento");
//		map.put(PERSONAL_VALUES.MAX_HORAS_NORMALES, "max_horas_normales");
//		map.put(PERSONAL_VALUES.MAX_HORAS_EXTRAS, "max_horas_extras");
//		map.put(PERSONAL_VALUES.MAX_HORAS_EXTRA_DIA, "max_horas_extras_dia");
//		map.put(PERSONAL_VALUES.TIPO_STAFF, "tipo_staff");
//		map.put(PERSONAL_VALUES.EMAIL, "email");
//		map.put(PERSONAL_VALUES.RUC, "ruc");
//		map.put(PERSONAL_VALUES.CUPOS_ADICIONALES, "cupos_adicionales");
//		map.put(PERSONAL_VALUES.CODIGO_UBIGEO, "codigo_ubigeo");
//		map.put(PERSONAL_VALUES.ID_SEXO, "id_sexo");
//		map.put(PERSONAL_VALUES.NO_SEXO, "no_sexo");
//		map.put(PERSONAL_VALUES.ID_ESTADO_CIVIL, "id_estado_civil");
//		map.put(PERSONAL_VALUES.NO_ESTADO_CIVIL, "no_estado_civil");
//		map.put(PERSONAL_VALUES.ID_TIPO_DOCUMENTO_IDENTIDAD, "id_tipo_documento_identidad");
//		map.put(PERSONAL_VALUES.NO_TIPO_DOCUMENTO_IDENTIDAD, "no_tipo_documento_identidad");
//		map.put(PERSONAL_VALUES.ID_GRUPO_OCUPACIONAL, "id_grupo_ocupacional");
//		map.put(PERSONAL_VALUES.NO_GRUPO_OCUPACIONAL, "no_grupo_ocupacional");
//
//		MAP_ATTRIBUTE_TO_COLUMN = Collections.unmodifiableMap(map);
//	}
//
//	@Override
//	public Personal getNullableResult(ResultSet resultSet, String arg1) throws SQLException
//	{
//		Personal personal = new Personal();
//		
//		Item item = null;
//		
//		personal.setIdPersonal( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_PERSONAL ) ) );
//		personal.setCodigoPersonal( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.CODIGO_PERSONAL ) ) );
//		personal.setApePaterno( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.APE_PATERNO ) ) );
//		personal.setApeMaterno( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.APE_MATERNO ) ) );
//		personal.setNombre( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NOMBRE ) ) );
//		personal.setFeNacimiento( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.FE_NACIMIENTO ) ) );
//		personal.setMaxHorasExtras( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.MAX_HORAS_EXTRAS ) ) );
//		personal.setMaxHorasNormales( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.MAX_HORAS_NORMALES ) ) );
//		personal.setMaxHorasExtrasDia( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.MAX_HORAS_EXTRA_DIA ) ) );
//		personal.setTipoStaff( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.TIPO_STAFF ) ) );
//		personal.setEmail( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.EMAIL ) ) );
//		personal.setRuc( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.RUC ) ) );
//		personal.setCuposAdicionales( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.CUPOS_ADICIONALES ) ) );
//		personal.setCodigoUbigeo( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.CODIGO_UBIGEO ) ) );
//		
//		item = new Item();
//		item.setID( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_SEXO ) ) );
//		item.setValor( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NO_SEXO ) ) );
//		personal.setSexo( item );
//		
//		item = new Item();
//		item.setID( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_ESTADO_CIVIL ) ) );
//		item.setValor( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NO_ESTADO_CIVIL ) ) );
//		personal.setEstadoCivil( item );
//
//		item = new Item();
//		item.setID( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_TIPO_DOCUMENTO_IDENTIDAD ) ) );
//		item.setValor( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NO_TIPO_DOCUMENTO_IDENTIDAD ) ) );
//		personal.setTipoDocumentoIdentidad( item );
//		
//		item = new Item();
//		item.setID( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_GRUPO_OCUPACIONAL ) ) );
//		item.setValor( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NO_GRUPO_OCUPACIONAL ) ) );
//		personal.setGrupoOcupacional( item );
//		
//		return personal;
//	}
//
//	@Override
//	public Personal getNullableResult(ResultSet resultSet, int arg1) throws SQLException
//	{
//		Personal personal = new Personal();
//		
//		Item item = null;
//		
//		personal.setIdPersonal( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_PERSONAL ) ) );
//		personal.setCodigoPersonal( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.CODIGO_PERSONAL ) ) );
//		personal.setApePaterno( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.APE_PATERNO ) ) );
//		personal.setApeMaterno( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.APE_MATERNO ) ) );
//		personal.setNombre( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NOMBRE ) ) );
//		personal.setFeNacimiento( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.FE_NACIMIENTO ) ) );
//		personal.setMaxHorasExtras( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.MAX_HORAS_EXTRAS ) ) );
//		personal.setMaxHorasNormales( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.MAX_HORAS_NORMALES ) ) );
//		personal.setMaxHorasExtrasDia( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.MAX_HORAS_EXTRA_DIA ) ) );
//		personal.setTipoStaff( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.TIPO_STAFF ) ) );
//		personal.setEmail( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.EMAIL ) ) );
//		personal.setRuc( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.RUC ) ) );
//		personal.setCuposAdicionales( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.CUPOS_ADICIONALES ) ) );
//		personal.setCodigoUbigeo( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.CODIGO_UBIGEO ) ) );
//		
//		item = new Item();
//		item.setID( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_SEXO ) ) );
//		item.setValor( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NO_SEXO ) ) );
//		personal.setSexo( item );
//		
//		item = new Item();
//		item.setID( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_ESTADO_CIVIL ) ) );
//		item.setValor( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NO_ESTADO_CIVIL ) ) );
//		personal.setEstadoCivil( item );
//
//		item = new Item();
//		item.setID( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_TIPO_DOCUMENTO_IDENTIDAD ) ) );
//		item.setValor( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NO_TIPO_DOCUMENTO_IDENTIDAD ) ) );
//		personal.setTipoDocumentoIdentidad( item );
//		
//		item = new Item();
//		item.setID( resultSet.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_GRUPO_OCUPACIONAL ) ) );
//		item.setValor( resultSet.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NO_GRUPO_OCUPACIONAL ) ) );
//		personal.setGrupoOcupacional( item );
//		
//		return personal;
//	}
//
//	@Override
//	public Personal getNullableResult(CallableStatement cs, int arg1) throws SQLException
//	{
//		Personal personal = new Personal();
//		
//		Item item = null;
//		
//		personal.setIdPersonal( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_PERSONAL ) ) );
//		personal.setCodigoPersonal( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.CODIGO_PERSONAL ) ) );
//		personal.setApePaterno( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.APE_PATERNO ) ) );
//		personal.setApeMaterno( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.APE_MATERNO ) ) );
//		personal.setNombre( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NOMBRE ) ) );
//		personal.setFeNacimiento( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.FE_NACIMIENTO ) ) );
//		personal.setMaxHorasExtras( cs.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.MAX_HORAS_EXTRAS ) ) );
//		personal.setMaxHorasNormales( cs.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.MAX_HORAS_NORMALES ) ) );
//		personal.setMaxHorasExtrasDia( cs.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.MAX_HORAS_EXTRA_DIA ) ) );
//		personal.setTipoStaff( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.TIPO_STAFF ) ) );
//		personal.setEmail( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.EMAIL ) ) );
//		personal.setRuc( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.RUC ) ) );
//		personal.setCuposAdicionales( cs.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.CUPOS_ADICIONALES ) ) );
//		personal.setCodigoUbigeo( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.CODIGO_UBIGEO ) ) );
//		
//		item = new Item();
//		item.setID( cs.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_SEXO ) ) );
//		item.setValor( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NO_SEXO ) ) );
//		personal.setSexo( item );
//		
//		item = new Item();
//		item.setID( cs.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_ESTADO_CIVIL ) ) );
//		item.setValor( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NO_ESTADO_CIVIL ) ) );
//		personal.setEstadoCivil( item );
//
//		item = new Item();
//		item.setID( cs.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_TIPO_DOCUMENTO_IDENTIDAD ) ) );
//		item.setValor( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NO_TIPO_DOCUMENTO_IDENTIDAD ) ) );
//		personal.setTipoDocumentoIdentidad( item );
//		
//		item = new Item();
//		item.setID( cs.getInt( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.ID_GRUPO_OCUPACIONAL ) ) );
//		item.setValor( cs.getString( MAP_ATTRIBUTE_TO_COLUMN.get( PERSONAL_VALUES.NO_GRUPO_OCUPACIONAL ) ) );
//		personal.setGrupoOcupacional( item );
//		
//		return personal;
//	}
//
//	@Override
//	public void setNonNullParameter(PreparedStatement arg0, int arg1, Personal arg2, JdbcType arg3) throws SQLException
//	{
//
//	}
//}
