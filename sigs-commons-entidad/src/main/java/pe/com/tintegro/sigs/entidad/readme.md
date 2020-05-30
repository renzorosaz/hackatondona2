En este paquete van todas las entidades del dominio correspondiente.

Por ejemplo si tenemos la entidad **Categoría**.

```[java]
public class Categoria implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int categoriaID;
	private String nombre;

	public int getCategoriaID()
	{
		return categoriaID;
	}

	public void setCategoriaID(int categoriaID)
	{
		this.categoriaID = categoriaID;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
}

```