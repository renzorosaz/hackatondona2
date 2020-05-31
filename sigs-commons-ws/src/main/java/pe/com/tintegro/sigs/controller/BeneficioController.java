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
import pe.com.tintegro.sigs.dto.request.ObtenerBeneficioRequest;
import pe.com.tintegro.sigs.dto.request.ObtenerPuntosAcopioRequest;
import pe.com.tintegro.sigs.dto.response.ObtenerBeneficiosResponse;
import pe.com.tintegro.sigs.dto.response.ObtenerPuntosAcopioResponse;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.BeneficioService;

@RestController
@RequestMapping("/beneficio")
@Api(value = "Beneficio")
@CrossOrigin(origins="*")
public class BeneficioController {
	
private static final Logger LOG = Logger.getLogger(BeneficioController.class);
	
	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;
	
	@Autowired
	private BeneficioService beneficioService;
	
	@RequestMapping(value="/obtener-beneficio",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener beneficio", notes = "Obtiene todos los beneficio", response = ObtenerBeneficiosResponse.class)
	public ObtenerBeneficiosResponse obtenerBeneficio() {
		ObtenerBeneficioRequest request = new ObtenerBeneficioRequest();
		ObtenerBeneficiosResponse response = new ObtenerBeneficiosResponse();
	
		try {
			response = beneficioService.obtenerBeneficio(request);
			response.setEstado(ResponseEstado.OK);
			if(response.getBeneficioList().size() == 0){
				response.setMensaje("No encuentra la lista de beneficios.");
			}
			else{
				response.setMensaje("Beneficios encontrados.");
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
