import java.util.ArrayList;
import java.util.List;
/**
 * Clase que modela el comportamiento de una Categoria
 * @author Cortés Macias Gretel Penelope
 * @author García Landa Brenda Yareli
 * @author Manjarrez Angeles Valeria
 * @author Montaño Pérez Joshua Said
 * @author Mora Abonce Samantha
 */
public class Categoria{
  private String nombre;
  private ArrayList <String> productos;
  private String descripcion;

  public Categoria(){
    this.nombre = "";
    this.descripcion = "";
    this.productos = null;
  }

  public Categoria(String nombre, String descripcion){
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.productos = new ArrayList <String> ();
  }
  /**
	 * Permite acceder al nombre de la categoría
	 * @return el nombre de la categoría
	 */
  public String getNombre(){
    return this.nombre;
  }

  /**
	 * Permite acceder al nombre de la descripcion
	 * @return el nombre de la descripcion
	 */
  public String getDescripcion(){
    return descripcion;
  }

  /**
	 * Permite acceder a la cantidad de productos en la categoría
	 * @return la cantidad de productos en la categoría
	 */
  public int getCantidadProductos(){
    return productos.size();
  }

  /**
	 * Modifica el nombre de la categoría
	 * @return el nuevo nombre de la categoría
	 */
  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  /**
   * Modifica la descripcion de la categoría
   * @return la nueva descripcion de la categoría
   */
  public void setDescripcion(String descripcion){
    this.descripcion = descripcion;
  }

  /**
   * Método agregarProducto, método en donde se agrega un nuevo
   * elemento a la lista de categorias
   * @param productoPorAgregar, el elemento que se va a agregar
   */
  public void agregarProducto(String productoPorAgregar){
    productos.add(productoPorAgregar);
  }

  /**
   * Método buscarProducto, método en donde se busca un
   * elemento en la lista de categorias
   * @param productoPorAgregar, regresa true si el elemento
   * se encuentra en la lista, false en otro caso
   */
  public boolean buscarProducto(String productoPorBuscar){
    boolean contiene = productos.contains(productoPorBuscar);
    if(contiene)
      return true;
    else
      return false;
  }

  /**
   * Método borrarProducto, método en donde se elimina un
   * elemento de la lista de categorías
   * @param productoPorBorrar, el elemento que se va a
   * eliminar de la lista de categorías
   */
  public void borrarProducto(String productoPorBorrar){
    productos.remove(productoPorBorrar);
  }

  /**
   * Método toString, método en donde se da la información
   * de la categoría
   * @return String, la cadena que contiene la descripción de
   * la categoría
   */
  @Override
  public String toString(){
    return this.getNombre().toLowerCase();
  }

}
