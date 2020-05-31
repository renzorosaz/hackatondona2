package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.InicioSesionRequest;
import pe.com.tintegro.sigs.dto.request.InsertarUsuarioRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerUsuarioInfoRequest;
import pe.com.tintegro.sigs.dto.response.InicioSesionResponse;
import pe.com.tintegro.sigs.dto.response.InsertarUsuarioResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerUsuarioInfoResponse;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@Api(value = "Usuario")
@CrossOrigin(origins="*")
public class UsuarioController {
	
private static final Logger LOG = Logger.getLogger(UsuarioController.class);
	
	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/insertar-usuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Inserta usuario", notes = "Inserta usuario", response = InsertarUsuarioResponse.class)
	public InsertarUsuarioResponse insertUsuario(@RequestBody InsertarUsuarioRequest request){
		InsertarUsuarioResponse response = new InsertarUsuarioResponse();
		
		try {
			response = usuarioService.insertarUsuario(request);
			
			System.out.println(response.getEstado());
			response.setMensaje(response.getConfirmacion().getMensaje());
			
		}catch (Exception e) {
			
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setCodigoError(codigoError);
			
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/inicio-sesion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Inicio Sesion", notes = "Inicio Sesion", response = InicioSesionResponse.class)
	public InicioSesionResponse inicioSesion(@RequestBody InicioSesionRequest request){
		InicioSesionResponse response = new InicioSesionResponse();
		
		try {
			response = usuarioService.inicioSesion(request);
			
			System.out.println(response.getEstado());
			response.setMensaje(response.getConfirmacion().getMensaje());
			
		}catch (Exception e) {
			
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_NEGOCIO);
			response.setCodigoError(codigoError);
			
			LOG.error(codigoError, e);
		}
		return response;
	}
	
	@RequestMapping(value = "/obtener-info-usuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener info usuario por id", notes = "Obtener info usuario por id", response = ObtenerUsuarioInfoResponse.class)
	public ObtenerUsuarioInfoResponse obtenerUsuarioInfo(
			Integer idUsuario) {
		ObtenerUsuarioInfoRequest request = new ObtenerUsuarioInfoRequest();
		ObtenerUsuarioInfoResponse response = new ObtenerUsuarioInfoResponse();
		
		request.setIdUsuario(idUsuario);

		
		try {
			response = usuarioService.obtenerUsuarioInfo(request);
			response.setEstado(ResponseEstado.OK);
			if(response.getUsuario() == null){
				response.setMensaje("No se encontro producto.");
			}
			else{
				response.setMensaje("Usuario encontrado.");
			}
		} catch (Exception e) {
			String mensajeError = "Ocurrió un error al obtener el usuario.";
			String codigoError = ResponseHelper
					.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
		}

		return response;
	}

}
