package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.ObtenerDonadosRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerPuntosAcopioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerDonadosResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerPuntosAcopioResponse;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.DonadosService;

@RestController
@RequestMapping("/donados")
@Api(value = "Donados")
@CrossOrigin(origins="*")
public class DonadosController {
	
private static final Logger LOG = Logger.getLogger(DonadosController.class);
	
	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;
	
	@Autowired
	private DonadosService donadosService;
	
	@RequestMapping(value="/obtener-donados",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener donados", notes = "Obtiene todos los donados", response = ObtenerDonadosResponse.class)
	public ObtenerDonadosResponse obtenerDonados() {
		ObtenerDonadosRequest request = new ObtenerDonadosRequest();
		ObtenerDonadosResponse response = new ObtenerDonadosResponse();
	
		try {
			response = donadosService.obtenerDonados(request);
			response.setEstado(ResponseEstado.OK);
			if(response.getDonadosList().size() == 0){
				response.setMensaje("No encuentra la lista de donados.");
			}
			else{
				response.setMensaje("Puntos de donados encontrados.");
			}
			
		} catch (Exception e) {
			String mensajeError = "Ocurrió un error al obtener los donados.";
			String codigoError = ResponseHelper.obtenerCodigoErrorPorFecha(apiProperties.getNombre());
			response.setEstado(ResponseEstado.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
		}
		return response;
	}
}