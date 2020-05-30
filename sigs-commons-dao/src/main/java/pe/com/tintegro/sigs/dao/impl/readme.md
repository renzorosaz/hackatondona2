En este paquete van todas las implementaciones de las interfaces de accesso a datos.

Por ejemplo esta es la implementación de la interfaz de acceso a datos correspondiente a la entidad de dominio **Categoría**.

```[java]
@Repository( "categoriaDAO" )
@Transactional
public class CategoriaDAOImpl implements CategoriaDAO
{
	@Autowired
	private CategoriaMapper categoriaMapper;
	
	@Override
	public ObtieneCategoriasResponse obtenerCategorias( ObtieneCategoriasRequest request ) throws Exception
	{
		ObtieneCategoriasResponse response = new ObtieneCategoriasResponse();
		
		List<Categoria> categorias = categoriaMapper.obtenerCategorias();
		
		response.setCategorias( categorias );
		
		return response;
	}

	@Override
	public ObtieneCategoriaResponse obtenerCategoriaPorID( ObtieneCategoriaRequest request ) throws Exception
	{
		ObtieneCategoriaResponse response = new ObtieneCategoriaResponse();
		
		Categoria categoria = categoriaMapper.obtenerCategoriaPorID( request.getCategoriaID() ).get( 0 ); 
		
		response.setCategoria( categoria );
		
		return response;
	}

	@Override
	public InsertaCategoriaResponse insertarCategoria( InsertaCategoriaRequest request ) throws Exception
	{
		InsertaCategoriaResponse response = new InsertaCategoriaResponse();
		
		int insertado = categoriaMapper.insertarCategoria( request.getCategoria().getNombre() ).get( 0 );
		response.setInsertado( insertado );
		
		return response;
	}

	@Override
	public ActualizaCategoriaResponse actualizarCategoria( ActualizaCategoriaRequest request ) throws Exception
	{
		ActualizaCategoriaResponse response = new ActualizaCategoriaResponse();
		
		int actualizado = categoriaMapper.actualizarCategoria( request.getCategoria().getCategoriaID(), request.getCategoria().getNombre() ).get( 0 );
		response.setActualizado( actualizado );
		
		return response;
	}

	@Override
	public EliminaCategoriaResponse eliminarCategoria( EliminaCategoriaRequest request ) throws Exception
	{
		EliminaCategoriaResponse response = new EliminaCategoriaResponse();
		
		int eliminado = categoriaMapper.eliminarCategoria( request.getCategoriaID() ).get( 0 );
		
		response.setEliminado( eliminado );
		
		return response;
	}
}

```

