En este paquete se colocan los test unitarios de cada interface de la capa de servicios.

Por ejemplo los test unitarios de la capa de servicios correspondientes a la entidad de dominio **Categoria** serían:

```[java]
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationContextDAOConfig.class } )
public class CategoriaServiceTest
{
	@Autowired
	private CategoriaService categoriaService;
	
	@Test
	public void obtenerCategoriasTest()
	{
		ObtieneCategoriasRequest request = new ObtieneCategoriasRequest();
		
		try
		{
			ObtieneCategoriasResponse categorias = categoriaService.obtenerCategorias( request );
			categorias.getCategoriaList().forEach( categoria -> { System.out.println( categoria.getNombre() ); } );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void obtenerCategoriaPorIDTest()
	{
		int categoriaID = 2;
		
		ObtieneCategoriaRequest request = new ObtieneCategoriaRequest();
		
		try
		{
			request.setCategoriaID( categoriaID );
			ObtieneCategoriaResponse categoria = categoriaService.obtenerCategoriaPorID( request );
			Assert.assertNotNull( categoria );
			System.out.println( categoria.getCategoria().getNombre() );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
``` 