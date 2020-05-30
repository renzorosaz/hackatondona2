En este paquete se colocan todas las interfaces de los servicios del proyecto.

Por ejemplo esta clase albergaría las interfaces de los servicios de la entidad de dominio **Categoria** 

```[java]

public interface CategoriaService
{
	public ObtieneCategoriasResponse obtenerCategorias( ObtieneCategoriasRequest request ) throws Exception;

	public ObtieneCategoriaResponse obtenerCategoriaPorID( ObtieneCategoriaRequest request ) throws Exception;

	public InsertaCategoriaResponse insertarCategoria( InsertaCategoriaRequest request ) throws Exception;

	public ActualizaCategoriaResponse actualizarCategoria(ActualizaCategoriaRequest request) throws Exception;

	public EliminaCategoriaResponse eliminarCategoria( EliminaCategoriaRequest request ) throws Exception;
}

```