/**
 * Clase que permite escribir y leer a proveedores sobre un archivo CSV
 * @author Samantha Mora Abonce
 * @author Gretel Penelope Cortes Macias
 * @author Valeria Fernanda Manjarrez Angeles
 * @author Brenda Yareli Garcia Landa
 * @author Joshua Said Montaño Pérez
 * @version 17/10/2021
 */
public class ProveedorArchivo extends LeeryEscribir {
    /**
     * Constructor por omision que crea el archivo Operador.csv
     */
    public ProveedorArchivo(){
        super("Proveedor.csv");
    }

    /**
     * Metodo que prepara el arreglo de proveedores para que pueda ser guardado
     * @param proveedor - El arreglo del proveedor
     */
    public void escribeProveedor(Proveedor proveedor[]){
        String lineaproveedor = "";
        for(Proveedor o : proveedor){
            lineaproveedor += o + "\n";
        }
        super.escribeArchivo(lineaproveedor);
    }

    /**
     * Metodo que convierte un arreglo de String a un arreglo de proveedores
     * @return proveedores  -- El arreglo de proveedores
     * @throws ArchivoNoexiste -- Se lanza la excepcion cuando el archivo no existe
     */
    public Proveedor[] leeProveedores() throws ArchivoNoExiste{
        String lineas[] = super.leeArchivo();
        Proveedor proveedores[] = new Proveedor[lineas.length];
        for(int i = 0; i < proveedores.length ; i++){
            if(!lineas[i].equals("null")){
                proveedores[i] = this.parseaproveedor(lineas[i]);
            }
        }
        return proveedores;
    }

    /**
     * Metodo que recibe una cadena y parsea los datos para crear a un proveedor
     * @param cadenaproveedor -- la cadena paresear
     * @return el objeto con los datos de la cadena
     */
    private Proveedor parseaproveedor(String cadenaproveedor){
        String linea[] = cadenaproveedor.trim().split(",");
        String razonSocial = linea[0];
        String rfc = linea[1];
        String calle = linea[2];
        String numeroDireccion = linea[3];
        String municipio = linea[4];
        String codigoPostal = linea[5];
        String estado = linea[6];
        String telefonoCelular = linea[7];
        String telefonoFijo = linea[8];
        return new Proveedor(razonSocial, rfc, calle, numeroDireccion, municipio, codigoPostal, estado
        , telefonoCelular, telefonoFijo);
    }
}
