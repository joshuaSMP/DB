/**
 * Clase que permite escribir y leer a Clientes sobre un archivo CSV
 * @author Samantha Mora Abonce
 * @author Gretel Penelope Cortes Macias
 * @author Valeria Fernanda Manjarrez Angeles
 * @author Brenda Yareli Garcia Landa
 * @author Joshua Said Montaño Pérez
 * @version 17/10/2021
 */
public class ClienteArchivo extends LeeryEscribir {
    /**
     * Constructor por omision que crea el archivo Operador.csv
     */
    public ClienteArchivo(){
        super("Clientes.csv");
    }

    /**
     * Metodo que prepara el arreglo de Clientes para que pueda ser guardado
     * @param cliente - El arreglo del cliente
     */
    public void escribeCliente(Cliente cliente[]){
        String lineaCliente = "";
        for(Cliente o : cliente){
            lineaCliente += o + "\n";
        }
        super.escribeArchivo(lineaCliente);
    }

    /**
     * Metodo que convierte un arreglo de String a un arreglo de Clientes
     * @return clientes  -- El arreglo de clientes
     * @throws ArchivoNoexiste -- Se lanza la excepcion cuando el archivo no existe
     */
    public Cliente[] leeClientes() throws ArchivoNoExiste{
        String lineas[] = super.leeArchivo();
        Cliente clientes[] = new Cliente[lineas.length];
        for(int i = 0; i < clientes.length ; i++){
            if(!lineas[i].equals("null")){
                clientes[i] = this.parseaCliente(lineas[i]);
            }
        }
        return clientes;
    }

    /**
     * Metodo que recibe una cadena y parsea los datos para crear a un Cliente
     * @param cadenaCliente -- la cadena paresear
     * @return el objeto con los datos de la cadena
     */
    private Cliente parseaCliente(String cadenaCliente){
        String linea[] = cadenaCliente.trim().split(",");
        String nombre = linea[0];
        String apellidoP = linea[1];
        String apellidoM = linea[2];
        String curp = linea[3];
        String calle = linea[4];
        String numeroDireccion = linea[5];
        String municipio = linea[6];
        String codigoPostal = linea[7];
        String estado = linea[8];
        String genero1 = linea[9];
        char genero = genero1.charAt(0);
        String fechaNacimiento = linea[10];
        String correo = linea[11];
        String contrasena = linea[12];
        String metodoDePago = linea[13];
        String puntosAcumulados1 = linea[14];
        int puntosAcumulados = Integer.parseInt(puntosAcumulados1);

        return new Cliente(nombre, apellidoM, apellidoP, curp, calle, numeroDireccion, municipio,
        codigoPostal, estado, genero, fechaNacimiento, correo, contrasena, metodoDePago, puntosAcumulados);
    }
}
