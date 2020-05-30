En este paquete se colocan todas los servicios web del API RESTful.

Por ejemplo, estas serían las implementaciones de los servicios web correspondientes a la entidad de dominio **Categoría**.

```[java]

@RestController
@RequestMapping("/categorias")
@Api( value = "Categoria" )
public class CategoriaController
{
	private static final Logger LOG = Logger.getLogger(CategoriaController.class);

	@Autowired
	private HttpServletRequest servletRequest;
	
	@Autowired
	private APIProperties apiProperties;

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@ResponseStatus( value = HttpStatus.OK )
	@ApiOperation( value = "Obtener categorías", notes = "Obtiene la lista de todas las categorías.", response = ObtieneCategoriasResponse.class )
	public ObtieneCategoriasResponse obtenerCategorias( @RequestHeader( "codUsuario" ) String codUsuario, @RequestHeader( "idIPRESS" ) String idIPRESS )
	{
		ObtieneCategoriasRequest request = new ObtieneCategoriasRequest();
		ObtieneCategoriasResponse response = new ObtieneCategoriasResponse();
		
		try
		{
			response = categoriaService.obtenerCategorias( RequestHelper.agregarHeaders( servletRequest, request ) );
			response.setEstado(ResponseAPI.OK);
			response.setMensaje("Categorías obtenidas correctamente.");
		}
		catch (Exception e)
		{
			String mensajeError = "Ocurrió un error al obtener las categorías.";
			String codigoError = ResponseAPI.getCodigoErrorByDate( apiProperties.getNombre() );
			response.setEstado(ResponseAPI.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
		}

		return response;
	}

	@RequestMapping(value = "/{categoriaID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation( value = "Obtener categoría por ID", notes = "Obtiene una única categoría identificada por su ID", response = ObtieneCategoriaResponse.class )
	public ObtieneCategoriaResponse obtenerCategoriaPorID( @RequestHeader( "codUsuario" ) String codUsuario, @RequestHeader( "idIPRESS" ) String idIPRESS, @PathVariable("categoriaID") int categoriaID )
	{
		ObtieneCategoriaRequest request = new ObtieneCategoriaRequest();
		ObtieneCategoriaResponse response = new ObtieneCategoriaResponse();
		
		try
		{
			request.setCategoriaID( categoriaID );
			
			response = categoriaService.obtenerCategoriaPorID( RequestHelper.agregarHeaders( servletRequest, request ) );
			response.setEstado(ResponseAPI.OK);
			response.setMensaje("Categoría obtenida correctamente.");
		}
		catch (Exception e)
		{
			String mensajeError = "Ocurrió un error al obtener la categoría.";
			String codigoError = ResponseAPI.getCodigoErrorByDate( apiProperties.getNombre() );
			response.setEstado(ResponseAPI.ERROR_APLICACION);
			response.setCodigoError(codigoError);
			response.setMensaje(mensajeError);
			LOG.error(codigoError, e);
		}

		return response;
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation( value = "Insertar categoría", notes = "Insertar una categoría en el repositorio de datos", response = InsertaCategoriaResponse.class )
	public InsertaCategoriaResponse insertarCategoria( @RequestHeader( "codUsuario" ) String codUsuario, @RequestHeader( "idIPRESS" ) String idIPRESS, @RequestBody InsertaCategoriaRequest request )
	{
		InsertaCategoriaResponse response = new InsertaCategoriaResponse();
		
		try
		{
			response = categoriaService.insertarCategoria( RequestHelper.agregarHeaders( servletRequest, request ) );
			response.setEstado( ResponseAPI.OK );
			response.setMensaje( "Categoría insertada correctamente." );
		}
		catch (Exception e)
		{
			String mensajeError = "Ocurrió un error al insertar la categoría.";
			String codigoError = ResponseAPI.getCodigoErrorByDate( apiProperties.getNombre() );
			response.setEstado( ResponseAPI.ERROR_APLICACION );
			response.setCodigoError( codigoError );
			response.setMensaje( mensajeError );
			LOG.error( codigoError, e );
		}
		
		return response;
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation( value = "Actualizar categoría", notes = "Actualiza una categoría que se encuentra en el repositorio de datos.", response = ActualizaCategoriaResponse.class )
	public ActualizaCategoriaResponse actualizarCategoria( @RequestHeader( "codUsuario" ) String codUsuario, @RequestHeader( "idIPRESS" ) String idIPRESS, @RequestBody ActualizaCategoriaRequest request )
	{
		ActualizaCategoriaResponse response = new ActualizaCategoriaResponse();
		
		try
		{
			response = categoriaService.actualizarCategoria( RequestHelper.agregarHeaders( servletRequest, request ) );
		}
		catch (Exception e)
		{
			String mensajeError = "Ocurrió un error al actualizar la categoría.";
			String codigoError = ResponseAPI.getCodigoErrorByDate( apiProperties.getNombre() );
			response.setEstado( ResponseAPI.ERROR_APLICACION );
			response.setCodigoError( codigoError );
			response.setMensaje( mensajeError );
			LOG.error( codigoError, e );
		}
		
		return response;
	}

	@RequestMapping(value = "/{categoriaID}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation( value = "Eliminar Categoría", notes = "Elimina una categoría del repositorio de datos.", response = EliminaCategoriaResponse.class )
	public EliminaCategoriaResponse eliminarCategoria( @RequestHeader( "codUsuario" ) String codUsuario, @RequestHeader( "idIPRESS" ) String idIPRESS, @PathVariable int categoriaID )
	{
		EliminaCategoriaRequest request = new EliminaCategoriaRequest();
		EliminaCategoriaResponse response = new EliminaCategoriaResponse();
		
		try
		{
			request.setCategoriaID( categoriaID );
			
			response = categoriaService.eliminarCategoria( RequestHelper.agregarHeaders( servletRequest, request ) );
			response.setEstado( ResponseAPI.OK );
			response.setMensaje( "Categoría eliminada correctamente." );
		}
		catch (Exception e)
		{
			String mensajeError = "Ocurrió un error al eliminar la categoría.";
			String codigoError = ResponseAPI.getCodigoErrorByDate( apiProperties.getNombre() );
			response.setEstado( ResponseAPI.ERROR_APLICACION );
			response.setCodigoError( codigoError );
			response.setMensaje( mensajeError );
			LOG.error( codigoError, e );
		}
		
		return response;
	}
}


```