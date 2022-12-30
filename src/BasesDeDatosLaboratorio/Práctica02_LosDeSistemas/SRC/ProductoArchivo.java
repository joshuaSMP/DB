/**
 *Clase que permite escribir y leer a Producto sobre un archivo CSV
 * @author Samantha Mora Abonce
 * @version 16/10/2021
 */
public class ProductoArchivo extends LeeryEscribir{

    /**
     * Constructor por omision que crea el archivo Producto.csv
     */
    public ProductoArchivo(){
	     super("Producto.csv");
    }

    /**
     * Método que prepara el arreglo de Producto para que puede ser guardado
     * @param producto -- El arreglo de productos
     */
    public void escribeProducto(Producto producto[]) {
	     String linea = "";
	      for(Producto p : producto){
		        linea += p + "\n";
	      }
	       super.escribeArchivo(linea);
	  }

    public Producto[] leeProducto() throws ArchivoNoExiste{
        String lineas[] = super.leeArchivo();
        Producto productos[] = new Producto[lineas.length];
        for(int i = 0; i < productos.length ; i++){
            if(!lineas[i].equals("null")){
                productos[i] = this.parseaProducto(lineas[i]);
            }
        }
        return productos;
    }


    /**
     * Metodo que recibe una cadena y parsea los datos para crear a un producto
     * @param cadenaproducto -- la cadena paresear
     * @return el objeto con los datos de la cadena
     */
    private Producto parseaProducto(String cadenaproducto){
        Categoria categoriaAux= null;
        String linea[] = cadenaproducto.trim().split(",");
        String codigo = linea[0];
        String precio = linea[1];
        int precioAux= Integer.parseInt(precio);
        String unidades = linea[2];
        int unidadesAux= Integer.parseInt(unidades);
        String descripcion = linea[3];
        String descuentoActivo= linea[4];
        int descuentoAux= Integer.parseInt(descuentoActivo);
        String categoria = linea[5];

        return new Producto(codigo,precioAux,unidadesAux,descripcion,descuentoAux,categoria);
    }




}
