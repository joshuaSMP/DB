/**
 * Clase que modela los Productos de la tienda en línea Nixut
 * @author Samantha Mora Abonce
 * @version 16/10/2021
 */
public class Producto{
    private String codigoProducto;
    private int precio;
    private int unidadesDisponibles;
    private String descripcion;
    private int descuentoActivo;
    private String categoria;
    /**
     * Constructor por omisión
     */
    public Producto() {
        this.codigoProducto = "a00000";
        this.precio = 0;
        this.unidadesDisponibles = 0;
        this.descripcion = "";
        this.descuentoActivo = 0;
        //this.categoria
    }

    /**
     * Constructor por parámetros que genera un Producto
     * @param codigo -- Código único del producto.
     * @param precio -- Precio del producto.
     * @param unidades -- Número de unidades disponibles.
     * @param descripcion -- Descripción completa del producto.
     * @param descuentoActivo -- Número del 0 al 100.
     */

    public Producto(String codigo, int precio, int unidades, String descripcion, int descuentoActivo, String categoria) {
        this.codigoProducto = codigo;
        this.precio = precio;
        this.unidadesDisponibles = unidades;
        this.descripcion = descripcion;
        this.descuentoActivo = descuentoActivo;
        this.categoria = categoria;
    }

    /**
    * Método getCodigoProducto que obtiene el código del Producto.
    * @return codigoProducto -- El código del Producto.
    */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * Método setCodigoProducto que define el nuevo código del Producto.
     * @param codigoProducto -- El nuevo código del Producto.
     */
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * Método getPrecio que obtiene el precio del Producto.
     * @return precio -- El precio del Producto.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Método setPrecio que define el nuevo precio del Producto.
     * @param precio -- Precio nuevo del Producto.
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Método getUnidadesDisponibles que obtiene el número de unidades en el inventario.
     * @return unidadesDisponibles -- El inventario de un producto.
     */
    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    /**
     * Método setUnidadesDisponibles que define el número de unidades en inventario.
     * @param unidadesDisponibles  -- Nuevo número de unidades disponibles.
     */
    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getCategoria() {
        return categoria;
    }

    /**
     * Método getDescripción que obtiene la descripción completa del Producto.
     * @return descripcion -- La descripción del Producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método setDescripcion que actualiza la descripción del Producto.
     * @param descripcion -- La descripción del Producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Método getDescuentoActivo que obtiene el descuento activo del Producto.
     * @return descuentoActivo -- Porcentaje de descuento.
     */
    public int getDescuentoActivo() {
        return descuentoActivo;
    }

    /**
     * Método setDescuentoActivo que define el descuento activo del Producto.
     * @param descuentoActivo -- El nuevo porcentaje de descuento activo.
     */
    public void setDescuentoActivo(int descuentoActivo) {
        this.descuentoActivo =  descuentoActivo;
    }


    /**
     * Método toString de Producto
     * @return representación en cadena del Producto,
     * para agregar al CVS.
     */
    @Override
    public String toString() {
        return this.codigoProducto + "," + this.precio + "," + this.unidadesDisponibles + "," + this.descripcion +","+ this.descuentoActivo + "," + this.categoria;
    }


}
