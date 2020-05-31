package pe.com.tintegro.sigs.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.tintegro.sigs.constants.ResponseEstado;
import pe.com.tintegro.sigs.dto.request.InsertarCheckDonacionRequest;
import pe.com.tintegro.sigs.dto.response.InsertarCheckDonacionResponse;
import pe.com.tintegro.sigs.helpers.ResponseHelper;
import pe.com.tintegro.sigs.properties.APIProperties;
import pe.com.tintegro.sigs.service.CheckDonacionService;

@RestController
@RequestMapping("/checkDonacion")
@Api(value = "CheckDonacion")
@CrossOrigin(origins="*")
public class CheckDonacionController {

private static final Logger LOG = Logger.getLogger(CheckDonacionController.class);
	
	@Autowired
	private HttpServletRequest servletRequest;

	@Autowired
	private APIProperties apiProperties;
	
	@Autowired
	private CheckDonacionService checkDonacionService;
	
	@RequestMapping(value = "/insertar-check-donacion", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Inserta check donacion", notes = "Inserta check donacion", response = InsertarCheckDonacionResponse.class)
	public InsertarCheckDonacionResponse insertProducto(@RequestBody InsertarCheckDonacionRequest request){
		InsertarCheckDonacionResponse response = new InsertarCheckDonacionResponse();
		
		try {
			response = checkDonacionService.insertarCheckDonacion(request);
			
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
}
