/**
 * Clase que representa al Cliente de una Tienda Virtual
 * @author Samantha Mora Abonce
 * @author Gretel Penelope Cortes Macias
 * @author Valeria Fernanda Manjarrez Angeles
 * @author Brenda Yareli Garcia Landa
 * @author Joshua Said Montaño Pérez
 * @version 17/10/2021
 */
public class Cliente {

	/**Atributos de la clase Cliente */
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private String curp;
	private String calle;
	private String numeroDeDireccion;
	private String municipio;
	private String codigoPostal;
	private String estado;
	private char genero;
	private String fechaNacimiento;
	private String correo;
	private String contrasena;
	private String metodoDePago;
	private int puntosAcumulados;

	/**Constructor por omision de la clase Cliente*/
	public Cliente (){
		this.nombre = " ";
		this.apellidoP = " ";
		this.apellidoM = " ";
		this.curp = " ";
		this.calle = " ";
		this.numeroDeDireccion = " ";
		this.municipio = " ";
		this.codigoPostal = " ";
		this.estado = " ";
		this.genero = ' ';
		this.fechaNacimiento = " ";
		this.correo = " ";
		this.contrasena = " ";
		this.metodoDePago = " ";
		this.puntosAcumulados = 0 ;

	}



	/**Constructor de la clase Cliente que recibe parametros:
	 * @param nombre
	 * @param apellidoP
	 * @param apellidoM
	 * @param curp
	 * @param calle
	 * @param numeroDeDireccion
	 * @param municipio
	 * @param codigoPostal
	 * @param estado
	 * @param genero
	 * @param fechaDeNacimiento
	 * @param correo
	 * @param contrasena
	 * @param metodoDePago
	 * @param puntosAcumulados
	 */

	public Cliente (String nombre, String apellidoP,String apellidoM, String curp,String calle, String numeroDeDireccion, String municipio, String codigoPostal, String estado, char genero,String fechaNacimiento,String correo,String contrasena, String metodoDePago, int puntosAcumulados){

		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.curp = curp;
		this.calle = calle;
		this.numeroDeDireccion = numeroDeDireccion;
		this.municipio = municipio;
		this.codigoPostal = codigoPostal;
		this.estado = estado;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.contrasena = contrasena;
		this.metodoDePago = metodoDePago;
		this.puntosAcumulados = puntosAcumulados;
	}



	/**Metodo Observador que regresa el nombre del cliente
	 * @return nombre
	 * */
	public String getNombre(){
		return this.nombre;
	}

	/**Metodo Observador que regresa el apellido paterno del clientes
	 * @return apellidoP
	 * */
	public String getApellidoP(){
		return this.apellidoP;
	}

	/**Metodo Observador que regresa el apellido materno del clientes
	 * @return apellidoM
	 * */
	public String getApellidoM(){
		return this.apellidoM;
	}

	/**Metodo Observador que regresa el curp del cliente
	 * @return curp
	 * */
	public String getCURP(){
		return this.curp;
	}

	/**Metodo Observador que regresa la calle del cliente
	 * @return calle
	 * */
	public String getCalle(){
		return this.calle;
	}
	/**Metodo Observador que regresa el numero de la direccion el cliente
	 * @return numeroDeDireccion */
	public String getNumeroDireccion(){
		return this.numeroDeDireccion;
	}

	/**Metodo Observador que regresa el municipio del cliente
	 * @return municipio */
	public String getMunicipio(){
		return this.municipio;
	}

	/**Metodo Observador que regresa el codigo postal del cliente
	 * @return codigoPostal */
	public String getCodigoPostal(){
		return this.codigoPostal;
	}

	/**Metodo Observador que regresa el estado del cliente
	 * @return estado
	 * */
	public String getEstado(){
		return this.estado;
	}

	/**Metodo Observador que regresa el genero del cliente
	 * @return genero
	 * */
	public char getGenero(){
		return this.genero;
	}

	/**Metodo Observador que regresa la fecha de nacimiento del cliente
	 * @return fechaNacimiento
	 * */
	public String getFechaNacimiento(){
		return this.fechaNacimiento;
	}

	/**Metodo Observador que regresa el correo del cliente
	 * @return correo*/
	public String getCorreo(){
		return this.correo;
	}

	/**Metodo Observador que regresa la contrasena del cliente
	 * @return contrasena*/
	public String getContrasena(){
		return  this.contrasena;
	}

	/**Metodo Observador que regresa el metodo de pago
	 * @return metodoDePago*/
	public String getMetodoDePago(){
		return this.metodoDePago;
	}

	/**Metodo Observador que regresa los puntos acumulados del cliente
	 * @return puntosAcumulados
	 * */
	public int getPuntosAcumulados(){
		return this.puntosAcumulados;
	}

	/**Metodo Modificador que cambia el nombre del cliente
	 * @param nombreActual
	 * */
	public void setNombre(String nombreActual){
		this.nombre = nombreActual;
	}

	/**Metodo Modificador que cambia el apellido del cliente
	 * @param apellidoPActual
	 * */
	public void setApellidoP(String apellidoPActual){
		this.apellidoP = apellidoPActual;
	}

	/**Metodo Modificador que cambia el apellido materno del cliente
	 * @param apellidoMActual
	 * */
	public void setApellidoM(String apellidoMActual){
		this.apellidoM = apellidoMActual;
	}

	/**Metodo Modificador que cambia el curp del cliente
	 * @param curpActual
	 * */
	public void setCURP(String curpActual){
		this.curp = curpActual;
	}

	/**Metodo Modificador que cambia la calle del cliente
	 * @param calleActual
	 * */
	public void setCalle(String calleActual){
		this.calle = calleActual;
	}

	/**Metodo Modificador que cambia el numero de direccion del cliente
	 * @param numeroDeDireccionActual*/
	public void setNumeroDeDireccion(String numeroDeDireccionActual){
		this.numeroDeDireccion = numeroDeDireccionActual;
	}
	/**Metodo Modificador que cambia el municipio del cliente
	 * @param municipioActual*/
	public void setMunicipio( String municipioActual){
		this.municipio = municipioActual;
	}

	/**Metodo Modificador que cambia el codigo postal el cliente
	 * @param codigoPostalActual
	 * */
	public void setCodigoPostal(String codigoPostalActual){
		this.codigoPostal = codigoPostalActual;
	}

	/**Metodo Modificador que cambia el estado del cliente
	 * @param estadoActual*/
	public void setEstado(String estadoActual){
		this.estado = estadoActual;
	}

	/**Metodo Modificador que cambia el genero del cliente
	 * @param generoActual */
	public void setGenero(char generoActual){
		this.genero = generoActual;
	}

	/**Metodo Modificador que cambia la fecha de nacimiento del cliente
	 * @param fechaNacimientoActual
	 * */
	public void setFechaDeNacimiento(String fechaNacimientoActual){
		this.fechaNacimiento = fechaNacimientoActual;
	}

	/**Metodo Modificador que cambia el correo del cliente
	 * @param correoActual
	 * */
	public void setCorreo(String correoActual){
		this.correo = correoActual;
	}

	/**Metodo Modificador que cambia la contrasena del cliente
	 * @param contrasenaActual*/
	public void setContrasena(String contrasenaActual){
		this.contrasena = contrasenaActual;
	}

	/**Metodo Modificador que cambia el metodo de pago del cliente
	 * @param metodoDePagoActual
	 * */
	public void setMetodoDePago(String metodoDePagoActual){
		this.metodoDePago = metodoDePagoActual;
	}

	/**Metodo Modificador que cambia puntos acumulados del cliente
	 * @param puntosAcumuladosActuales*/
	public void setPuntosAcumulados(int puntosAcumuladosActuales){
		this.puntosAcumulados = puntosAcumuladosActuales;
	}


	/**Metodo toString que nos regresa la cadena con los atributos del cliente
	 * @return cadena del cliente
	 * */
	public String toString(){
		return this.nombre+ "," + this.apellidoP +","+ this.apellidoM + "," + this.curp +
		 "," + this.calle + "," + this.numeroDeDireccion + "," + this.municipio + "," +
		 this.codigoPostal + "," + this.estado + "," + this.genero + "," + this.fechaNacimiento
		 + "," + this.correo + "," + this.contrasena + "," + this.metodoDePago
		 + "," + this.puntosAcumulados;
	}






}
