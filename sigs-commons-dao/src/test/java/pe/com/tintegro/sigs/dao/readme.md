En este paquete se colocan los test unitarios de cada interface de la capa de acceso a datos.

Por ejemplo los test unitarios de la capa de acceso a datos correspondientes a la entidad de dominio **Categoria** serían:

```[java]
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class CategoriaDAOTest
{
	@Autowired
   private CategoriaDAO categoriaDAO;
	
	@Test
	public void obtenerCategoriasTest()
	{
		try
		{
			ObtieneCategoriasRequest request = new ObtieneCategoriasRequest();
			ObtieneCategoriasResponse categoriasResponse = categoriaDAO.obtenerCategorias( request );
			
			categoriasResponse.getCategoriaList().forEach( categoria -> { System.out.println( categoria.getNombre() ); } );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void obtenerCategoriaPorIDTest()
	{
		int categoriaID = 1;
		
		ObtieneCategoriaRequest categoriaRequest;
		ObtieneCategoriaResponse categoriaResponse;
		
		try
		{
			categoriaRequest = new ObtieneCategoriaRequest();
			categoriaRequest.setCategoriaID( categoriaID );
			categoriaResponse = categoriaDAO.obtenerCategoriaPorID( categoriaRequest );
			Assert.assertNotNull( categoriaResponse );
			System.out.println( categoriaResponse.getCategoria().getNombre() );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

``` 