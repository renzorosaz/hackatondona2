En este paquete van todas las interfaces de accesso a datos.

Por ejemplo esta es una interfaz de acceso a datos correspondiente a la entidad de dominio **Categoría**.

```[java]
public interface CategoriaDAO
{
	public ObtieneCategoriasResponse obtenerCategorias( ObtieneCategoriasRequest request ) throws Exception;
	
	public ObtieneCategoriaResponse obtenerCategoriaPorID( ObtieneCategoriaRequest request ) throws Exception;
	
	public InsertaCategoriaResponse insertarCategoria( InsertaCategoriaRequest request ) throws Exception;
	
	public ActualizaCategoriaResponse actualizarCategoria( ActualizaCategoriaRequest request ) throws Exception;
	
	public EliminaCategoriaResponse eliminarCategoria( EliminaCategoriaRequest request ) throws Exception;
}
```

