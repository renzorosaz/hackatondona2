En este paquete se colocan todas interfaces java que corresponden a los mappers (archivos xml).  

```[java]

public interface CategoriaMapper
{
	public List<Categoria> obtenerCategorias();

	public List<Categoria> obtenerCategoriaPorID( @Param( "categoryID" ) int categoryId );
	
	public List<Integer> insertarCategoria( @Param( "nombre" ) String nombre );
	
	public List<Integer> actualizarCategoria( @Param( "categoriaID" ) int categoriaID, @Param( "nombre" ) String nombre );
	
	public List<Integer> eliminarCategoria( @Param( "categoriaID" ) int categoriaID );
}

```