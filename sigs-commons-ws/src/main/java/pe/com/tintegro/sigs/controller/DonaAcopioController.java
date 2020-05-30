package pe.com.tintegro.sigs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.apache.log4j.Logger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ObtenerPuntosAcopioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerPuntosAcopioResponse;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.DonaAcopioService;

@RestController
@RequestMapping("/donaAcopio")
@Api(value = "DonaAcopio")
@CrossOrigin(origins="*")
public class DonaAcopioController {

	private static final Logger LOG = Logger.getLogger(DonaAcopioController.class);
	
	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;
	
	@Autowired
	private DonaAcopioService donaAcopioService;
	
	
	@RequestMapping(value="/obtener-puntos-acopio",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener categorias", notes = "Obtiene todas las categorias", response = ObtenerPuntosAcopioResponse.class)
	public ObtenerPuntosAcopioResponse obtenerCategorias() {
		ObtenerPuntosAcopioRequest request = new ObtenerPuntosAcopioRequest();
		ObtenerPuntosAcopioResponse response = new ObtenerPuntosAcopioResponse();
	
		try {
			response = donaAcopioService.obtenerPuntosAcopio(request);
			response.setEstado(ResponseEstado.OK);
			if(response.getDonaAcopioList().size() == 0){
				response.setMensaje("No encuentra la lista de puntos de acopio.");
			}
			else{
				response.setMensaje("Puntos de acopio encontrados.");
			}
			
		} catch (Exception e) {
			String mensajeError = "Ocurrió un error al obtener los puntos de acopio.";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
		}
		return response;
	}
}
