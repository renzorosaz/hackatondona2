En este paquete se colocan todas las implementaciones de las interfaces de los servicios del proyecto.

Por ejemplo esta clase albergaría las implementaciones de los servicios de la entidad de dominio **Categoria** 

```[java]

@Service( "categoryService" )
public class CategoriaServiceImpl implements CategoriaService
{
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Override
	public ObtieneCategoriasResponse obtenerCategorias( ObtieneCategoriasRequest request ) throws Exception
	{
		return categoriaDAO.obtenerCategorias( request );
	}

	@Override
	public ObtieneCategoriaResponse obtenerCategoriaPorID( ObtieneCategoriaRequest request ) throws Exception
	{
		return categoriaDAO.obtenerCategoriaPorID( request );
	}

	@Override
	public InsertaCategoriaResponse insertarCategoria( InsertaCategoriaRequest request ) throws Exception
	{
		return categoriaDAO.insertarCategoria( request );
	}

	@Override
	public ActualizaCategoriaResponse actualizarCategoria( ActualizaCategoriaRequest request ) throws Exception
	{
		ActualizaCategoriaResponse response = new ActualizaCategoriaResponse();
		
		response = categoriaDAO.actualizarCategoria( request );
		
		if( response.getActualizado() == 0 )
		{
			response.setEstado( ResponseAPI.ERROR_NEGOCIO );
			response.setMensaje( "Categoría no encontrada." );
		}
		else
		{
			response.setEstado( ResponseAPI.OK );
			response.setMensaje( "Categoría actualizada correctamente." );
		}
		
		return response;
	}

	@Override
	public EliminaCategoriaResponse eliminarCategoria( EliminaCategoriaRequest request ) throws Exception
	{
		return categoriaDAO.eliminarCategoria( request );
	}
}

```