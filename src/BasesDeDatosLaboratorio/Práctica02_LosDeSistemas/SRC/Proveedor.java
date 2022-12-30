/**
 * Clase que representa al proveedor del Sistema de uan Tienda en linea
 * @author Samantha Mora Abonce
 * @author Gretel Penelope Cortes Macias
 * @author Valeria Fernanda Manjarrez Angeles
 * @author Brenda Yareli Garcia Landa
 * @author Joshua Said Montaño Pérez
 * @version 17/10/2021
 */
public class Proveedor{

    private String razonSocial;
    private String rfc;
    private String calle;
    private String numeroDireccion;
    private String municipio;
    private String codigoPostal;
    private String estado;
    private String telefonoCelular;
    private String telefonoFijo;
    /**
     * Constructor por omision
     */
    public Proveedor(){
        this.razonSocial = "";
        this.rfc = "";
        this.calle = "";
        this.numeroDireccion = "";
        this.municipio = "";
        this.codigoPostal = "";
        this.estado = "";
        this.telefonoCelular = "";
        this.telefonoFijo = "";
    }
    /**
     * Constructor con parametros que genera el proveedor
     * @param razonSocial - razon social del proveedor
     * @param rfc - Registro Federal de Contribuyentes del proveedor
     * @param calle - calle del proveedor
     * @param numero - numero del proveedor
     * @param municipio - municipio del proveedor
     * @param codigoPostal - codigo Postal del proveedor
     * @param estado - estado del proveedor
     * @param telefonoCelular - telefonoCelular del proveedor
     * @param telefonoFijo - telefonoFijo de la casa del proveedor
     */
    public Proveedor(String razonSocial,String rfc, String calle, String numeroDireccion, String municipio, String codigoPostal,
    String estado ,String telefonoCelular, String telefonoFijo){
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.calle = calle;
        this.numeroDireccion = numeroDireccion;
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.telefonoCelular = telefonoCelular;
        this.telefonoFijo = telefonoFijo;

    }

    /**
     * Metodo getRazonSocial que obtiene la Razon Social del proveedor
     * @return razonSocial del proveedor
     */
    public String getRazonSocial(){
        return razonSocial;
    }

    /**
     * Metodo setRazonSocial que define la nueva razon Social del proveedor
     * @param razonSocial -- El nuevo Razon Socil del proveedor
     */
    public void setRazonSocial(String razonSocial){
        this.razonSocial = razonSocial;
    }

    /**
     * Metodo getRfc que obtiene el Registro Federal de Contribuyentes del proveedor
     * @return rfc del proveedor
     */
    public String getRfc(){
        return rfc;
    }

    /**
     * Metodo setRfc que define el nuevo Rfc del proveedor
     * @param rfc -- El nuevo rfc del proveedor
     */
    public void setRfc (String rfc){
        this.rfc = rfc;
    }

    /**
     * Metodo getCalle que obtiene la calle del proveedor
     * @return calle del proveedor
     */
    public String getCalle(){
        return calle;
    }

     /**
     * Metodo setCalle que define la nueva Calle del proveedor
     * @param calle -- La nueva calle del proveedor
     */
    public void setCalle(String calle){
        this.calle = calle;
    }

    /**
     * Metodo getNumeroDireccion que obtiene la calle del proveedor
     * @return numeroDireccion del proveedor
     */
    public String getNumeroDireccio(){
        return numeroDireccion;
    }

     /**
     * Metodo setNumeroDireccion que define el nuevo numero del proveedor
     * @param numeroDireccion -- El nuevo numero direccion del proveedor
     */
    public void setNumeroDireccion(String numeroDireccion){
        this.numeroDireccion = numeroDireccion;
    }

    /**
     * Metodo getMunicipio que obtiene la calle del proveedor
     * @return municipio del proveedor
     */
    public String getMunicipio(){
        return municipio;
    }

     /**
     * Metodo setMunicipio que define la nueva municipio del proveedor
     * @param municipio -- EL nuevo municipio del proveedor
     */
    public void setMunicipio (String municipio){
        this.municipio = municipio;
    }

    /**
     * Metodo getCodigoPostal que obtiene la calle del proveedor
     * @return codigo Postal del proveedor
     */
    public String getCodigoPostal(){
        return codigoPostal;
    }

     /**
     * Metodo setCodigoPostal que define el nuevo codigo postal del proveedor
     * @param codigoPostal -- El nuevo codigo postal del proveedor
     */
    public void setCodigoPostal(String codigoPostal){
        this.codigoPostal = codigoPostal;
    }

    /**
     * Metodo getEstado que obtien el estado del proveedor
     * @return estado del proveedor
     */
    public String getEstado(){
        return estado;
    }

    /**
     * Metodo setEstado que define el nuevo estado del proveedor
     * @param estado del proveedor
     */
    public void setEstado(String estado){
        this.estado = estado;
    }
     /**
     * Metodo getTelefonoCelular que obtiene la calle del proveedor
     * @return telefonoCelular del proveedor
     */
    public String getTelefonoCelular(){
        return telefonoCelular;
    }

    /**
     * Metodo setTelefonoCelular que define el nuevo telefonoCelular del proveedor
     * @param telefonoCelular -- El nuevo telefonoFijo del proveedor
     */
    public void setTelefonoCelular(String telefonoCelular){
        this.telefonoCelular = telefonoCelular;
    }

     /**
     * Metodo getTelefonoFijo que obtiene la calle del proveedor
     * @return telefonoFijo del proveedor
     */
    public String getTelefonoFijo(){
        return telefonoFijo;
    }

     /**
     * Metodo setTelefonoFijo que define la nueva telefono de casa del proveedor
     * @param telefonoFijo -- El nuevo telefono de casa del proveedor
     */
    public void setTelefonoFijo(String telefonoFijo){
        this.telefonoFijo = telefonoFijo;
    }

    /**
     * Metodo ToString de proveedor
     * @return
     */
    @Override
    public String toString(){
        return this.razonSocial + "," + this.rfc + "," + this.calle + "," + this.numeroDireccion + "," +
        this.municipio + "," + this.codigoPostal + "," +  this.telefonoCelular + "," +  this.telefonoFijo;
    }

}
