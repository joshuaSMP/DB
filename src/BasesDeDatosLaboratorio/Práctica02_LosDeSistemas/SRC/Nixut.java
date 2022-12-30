import java.util.Scanner;

public class Nixut{

  private Cliente[] clientes= new Cliente[30];
  private Proveedor[] proveedores = new Proveedor[25];
  public Producto[] productos = new Producto[12];
  private ClienteArchivo archivoCliente = new ClienteArchivo();
  private ProveedorArchivo archivoProveedor = new ProveedorArchivo();
  private ProductoArchivo archivoProducto = new ProductoArchivo();
  
  public void carga(){
    try{
    clientes= archivoCliente.leeClientes();
    proveedores = archivoProveedor.leeProveedores();
    productos = archivoProducto.leeProducto();
    }catch(ArchivoNoExiste e){
          System.out.println("Archivo no existente");
    }
  }
  
  public void guarda(){
    archivoCliente.escribeCliente(clientes);
    archivoProveedor.escribeProveedor(proveedores);
    archivoProducto.escribeProducto(productos);
  }

  public Cliente buscaCliente(String correo, String contrasena){

    for(Cliente auxiliar : clientes){
      if(auxiliar.getCorreo().equals(correo) && auxiliar.getContrasena().equals(contrasena))
        return auxiliar;
    }
    return null;
  }

  public String imprimeProductos(){
    String aux = "";
    for(int i =0; i<productos.length ; i++){
      if(productos[i] == null)
        break;

      int num = i+1;
      aux += ""+ num + ". " +productos[i] + "\n";
    }
    return aux;
  }

  public void agregaProductos(Producto productoNuevo){
    for(int i = 0; i<productos.length ; i++){
      if(productos[i] == null){
        productos[i]=productoNuevo;
        break;
      }
    }
  }

  public void agregaCliente(Cliente clienteNuevo){
    for(int i=0; i<clientes.length; i++){
      if (clientes[i]==null){
        clientes[i]=clienteNuevo;
        break;
      }
    }
  }

  public void agregaProveedor(Proveedor proveedorNuevo){
    for(int i=0; i<proveedores.length; i++){
      if (proveedores[i]==null){
        proveedores[i]=proveedorNuevo;
        break;
      }
    }
  }

  public Proveedor buscaProveedor(String rfc){
    for(int i=0; i<proveedores.length; i++){
      if(proveedores[i].getRfc().equals(rfc))
        return proveedores[i];
    }
    return null;
  }

  public void menuCliente(Scanner usuario){
    System.out.println("¿Qué desea hacer?" + "\n1. Crear cuenta." + "\n2. Ingresar a mi cuenta");
    int opcionCliente;
    while(true){
                    if(!usuario.hasNextInt()){
                      System.out.println("\n" + "La opcion debe ser un NUMERO");
                      usuario.nextLine();
                      usuario.next();
                      continue;
                    }
                    opcionCliente = usuario.nextInt();
                    if(opcionCliente != 1 && opcionCliente !=2){
                      System.out.println("\n" + "Elige un indice valido");
                      usuario.nextLine();
                      usuario.next();
                      continue;
                    }
                    break;
                  }
    switch(opcionCliente){
      //caso 1 cuando crean una cuenta.
      case 1:
      System.out.println("---------------------------DATOS PRIMORDIALES---------------------------------"+"\n");
      System.out.println("-Ingrese su nombre:");
      String nombre = usuario.next();
      System.out.println("-Ingrese apellido paterno:");
      String apellidoP = usuario.next();
      System.out.println("-Ingrese apellido materno:");
      String apellidoM = usuario.next();
      System.out.println("-Ingrese CURP:");
      String curp = usuario.next().toUpperCase();
      System.out.println("------------------------------------DATOS DE DOMICILIO--------------------------------------"+"\n");
      System.out.println("-Ingrese el nombre de la calle:");
      String calle = usuario.next();
      System.out.println("-Ingrese el numero de direccion:");
      String direccion = usuario.next();
      usuario.next();
      System.out.println("-Ingrese su municipio:");
      String municipio = usuario.next();
      System.out.println("-Ingrese el codigo postal:");
      String codigoPostal=usuario.next();
      System.out.println("-Ingrese el estado:");
      String estado = usuario.next();
      System.out.println("-------------------------------------DATOS PERSONALES-------------------------------" +"\n");
      System.out.println("-Ingrese el genero:");
      System.out.println("Femenino = F \n Masculino = M \n PROCURE SOLO ESCRIBIR M O F ");
      char genero = usuario.next().toUpperCase().charAt(0);
       while (genero != 'M' && genero != 'F' ){
        System.out.println("Opcion no valida, elige alguna de las opciones M O F");
        genero = usuario.next().toUpperCase().charAt(0);
      }
      System.out.println("-Ingrese fecha de nacimiento:");
      String fechaDeNacimiento = usuario.nextLine();
      usuario.next();
      System.out.println("-Ingrese correo electronico:");
      String correo1 = usuario.next();
      System.out.println("-Ingrese su contraseña:");
      String contrasena1 = usuario.next();
      System.out.println("Escoja su metodo de pago: " + "\n 1. Tarjeta" + "\n 2. PayPal " + "\n 3. Efectivo(pago en tiendas de autoservicio)");
      int opcionPago;
      while(true){
                    if(!usuario.hasNextInt()){
                      System.out.println("\n" + "La opcion debe ser un NUMERO");
                      usuario.nextLine();
                      usuario.next();
                      continue;
                    }
                    opcionPago = usuario.nextInt();
                    if(opcionPago < 1 || opcionPago > 3){
                      System.out.println("\n" + "Elige un indice valido");
                      usuario.nextLine();
                      usuario.next();
                      continue;
                    }
                    break;
                  }
      String metodoPago = " ";
        switch(opcionPago){
          case 1: metodoPago = "Tarjeta";
          break;
          case 2: metodoPago = "PayPal";
          break;
          case 3:metodoPago = "Efectivo";
          break;
        }

      Cliente clienteNuevo = new Cliente(nombre, apellidoP, apellidoM, curp, calle, direccion, municipio, codigoPostal, estado, genero, fechaDeNacimiento, correo1, contrasena1, metodoPago, 0);
      agregaCliente(clienteNuevo);
      guarda();

      return;

      //caso 2 cuando ya tienen cuenta.
      case 2:
      System.out.println("Ingrese correo: ");
      String correo = usuario.nextLine();
      usuario.next();

      System.out.println("Ingrese contraseña:");
      String contrasena = usuario.nextLine();
      usuario.next();

      if(buscaCliente(correo,contrasena)!=null){

      System.out.println("¿Qué desea hacer?" + "\n1. Modificar cuenta." + "\n2. Eliminar cuenta");
        int opcionCliente1;
        while(true){
                    if(!usuario.hasNextInt()){
                      System.out.println("\n" + "La opcion debe ser un NUMERO");
                      usuario.nextLine();
                      continue;
                    }
                    opcionCliente1= usuario.nextInt();
                    if(opcionCliente1 != 1 || opcionCliente != 2){
                      System.out.println("\n" + "Elige un indice valido");
                      usuario.nextLine();
                      continue;
                    }
                    break;
                  }
        switch(opcionCliente1){

          //caso 1 modificar datos
          case 1:
            System.out.println("¿Qué desea modificar?" + "\n1. Nombre" + "\n2. Apellido Paterno" + "\n3. Apellido Materno" + "\n4. CURP" + "\n5. Calle" + "\n6. Direccion" + "\n7. Municipio " + "\n8. Codigo Postal" + "\n 9. Estado " + "\n10. Fecha de nacimiento" + "\n11. Correo" + "\n12. Contrasena" + "\n13. Metodo de Pago");
            int opcionModificaCliente;
            while(true){
                    if(!usuario.hasNextInt()){
                      System.out.println("\n" + "La opcion debe ser un NUMERO");
                      usuario.nextLine();
                      continue;
                    }
                    opcionModificaCliente= usuario.nextInt();
                    if(opcionModificaCliente < 1|| opcionModificaCliente > 13){
                      System.out.println("\n" + "Elige un indice valido");
                      usuario.nextLine();
                      continue;
                    }
                    break;
                  }
            switch(opcionModificaCliente){
              case 1: System.out.println("Escriba el nuevo nombre");
              String nombreN= usuario.nextLine();
              usuario.next();
              buscaCliente(correo,contrasena).setNombre(nombreN);
              break;
              case 2: System.out.println("Escriba el nuevo apellido paterno");
              String apellidoPN= usuario.nextLine();
              usuario.next();
              buscaCliente(correo,contrasena).setApellidoP(apellidoPN);
              break;
              case 3: System.out.println("Escriba el nuevo apellido materno");
              String apellidoMN= usuario.nextLine();
              usuario.next();
              buscaCliente(correo,contrasena).setApellidoM(apellidoMN);
              break;
              case 4: System.out.println("Escriba el nuevo CURP");
              String curpN= usuario.nextLine();
              usuario.next();
              buscaCliente(correo,contrasena).setCURP(curpN);
              break;
              case 5: System.out.println("Escriba la nueva calle");
              String calleN= usuario.nextLine();
              usuario.next();
              buscaCliente(correo,contrasena).setCalle(calleN);
              break;
              case 6: System.out.println("Escriba la nueva direccion");
              String direccionN = usuario.nextLine();
              usuario.next();
              buscaCliente(correo,contrasena).setNumeroDeDireccion(direccionN);
              break;
              case 7: System.out.println("EScriba el nuevo municipio");
              String municipioN= usuario.nextLine();
              usuario.next();
              buscaCliente(correo,contrasena).setMunicipio(municipioN);
              break;
              case 8: System.out.println("Escriba el nuevo codigo postal");
              String codigoPostalN = usuario.nextLine();
              usuario.next();
              buscaCliente(correo,contrasena).setCodigoPostal(codigoPostalN);
              break;
              case 9: System.out.println("Escriba el nuevo estado");
              String estadoN= usuario.nextLine();
              usuario.next();
              buscaCliente(correo,contrasena).setEstado(estadoN);
              break;
              case 10: System.out.println("Escriba la nueva fecha de nacimiento");
              String fechaDeNacimientoN = usuario.nextLine();
              usuario.next();
              buscaCliente(correo,contrasena).setFechaDeNacimiento(fechaDeNacimientoN);
              break;
              case 11: System.out.println("Escriba el nuevo correo");
              String correoN = usuario.nextLine();
              usuario.next();
              buscaCliente(correo,contrasena).setCorreo(correoN);
              break;
              case 12: System.out.println("Escriba la nueva contrasena");
              String contrasenaN=usuario.nextLine();
              usuario.next();
              buscaCliente(correo,contrasena).setContrasena(contrasenaN);
              break;
              case 13: System.out.println("Seleccione su nuevo metodo de Pago"+ "\n 1. Tarjeta" + "\n 2. PayPal " + "\n 3. Efectivo(pago en tiendas de autoservicio)");
              int opcionPagoN;
              while(true){
                    if(!usuario.hasNextInt()){
                      System.out.println("\n" + "La opcion debe ser un NUMERO");
                      usuario.nextLine();
                      continue;
                    }
                    usuario.next();
                    opcionPagoN= usuario.nextInt();
                    if(opcionPagoN < 1 || opcionPagoN > 3 ){
                      System.out.println("\n" + "Elige un indice valido");
                      usuario.nextLine();
                      continue;
                    }
                    break;
                  }
              usuario.next();
                    switch(opcionPagoN){
                      case 1:buscaCliente(correo,contrasena).setMetodoDePago("Tarjeta");
                      break;
                      case 2:buscaCliente(correo,contrasena).setMetodoDePago("PayPal");
                      break;
                      case 3:buscaCliente(correo,contrasena).setMetodoDePago("Efectivo");
                      break;
                    }
              break;
            }
             System.out.println("**El cliente quedo como: " + buscaCliente(correo,contrasena));

          //caso 2 elimina cliente
          case 2:
          //buscaCliente(correo,contrasena) = null;
        }
      }else{
        System.out.println("La contrasena o el correo no son validos, verifique sus datos");
      }
    }
  }

  public void menuProveedor(Scanner usuario){
     System.out.println("¿Qué desea hacer?" + "\n1. Crear cuenta de Proveedor." + "2. Ingresar a mi cuenta");
     int opcion;
     while(true){
                    if(!usuario.hasNextInt()){
                      System.out.println("\n" + "La opcion debe ser un NUMERO");
                      usuario.nextLine();
                      continue;
                    }
                    opcion= usuario.nextInt();
                    if(opcion !=1 || opcion != 2){
                      System.out.println("\n" + "Elige un indice valido");
                      usuario.nextLine();
                      continue;
                    }
                    break;
                  }
     switch(opcion){

      //caso 1 no esta registrado

      case 1:
      System.out.println("-Ingrese su razón social: ");
      String razonSocial= usuario.nextLine();
      usuario.next();
      System.out.println("-Ingrese su rfc: ");
      String rfc= usuario.nextLine();
      usuario.next();
      System.out.println("-Ingrese su calle:");
      String calle = usuario.nextLine();
      usuario.next();
      System.out.println("-Ingrese su numero de direccion:");
      String numDireccion= usuario.nextLine();
      usuario.next();
      System.out.println("-Ingrese su municipio:");
      String municipio = usuario.nextLine();
      usuario.next();
      System.out.println("-Ingrese su codigo postal:");
      String codigoPostal= usuario.nextLine();
      usuario.next();
      System.out.println("-Ingrese su estado: ");
      String estado = usuario.nextLine();
      usuario.next();
      System.out.println("                   IMPORTANTE: Agregar mas de un numero de telefono porque siempre deben de tener un medio de contacto disponible.                  ");
      System.out.println("Ingrese su telefono celular: ");
      String celular = usuario.nextLine();
      usuario.next();
      System.out.println("-Ingrese su telefono fijo ");
      String telFijo= usuario.nextLine();
      usuario.next();

      Proveedor proveedorNuevo = new Proveedor(razonSocial, rfc, calle, numDireccion, municipio, codigoPostal, estado, celular, telFijo);
      agregaProveedor(proveedorNuevo);
      break;

      //caso 2 si esta registrado

      case 2:
      System.out.println("-Ingrese su rfc: ");
      String rfcU= usuario.nextLine();
      usuario.next();

      if(buscaProveedor(rfcU)!=null){
        System.out.println("¿Que desea modificar?" + "\n1. Razon Social" + "\n2. RFC" + "\n3.Calle" + "\n4. Numero de Direccion" + "\n5. Municipio" + "\n6.Codigo Postal" + "\n7.Estado" + "\n8.Telefono Celular" + "\n9.Telefono fijo");
        int opcionPM;
        while(true){
                    if(!usuario.hasNextInt()){
                      System.out.println("\n" + "La opcion debe ser un NUMERO");
                      usuario.nextLine();
                      continue;
                    }
                    opcionPM= usuario.nextInt();
                    if(opcionPM < 1 || opcionPM > 9){
                      System.out.println("\n" + "Elige un indice valido");
                      usuario.nextLine();
                      continue;
                    }
                    break;
                  }
        switch(opcionPM){
          case 1:  System.out.println("-Ingrese su nueva razon social: ");
          String razonSocialN= usuario.nextLine();
          usuario.next();
          buscaProveedor(rfcU).setRazonSocial(razonSocialN);
          break;
          case 2:  System.out.println("-Ingrese su nuevo rfc: ");
          String rfcN=usuario.nextLine();
          usuario.next();
          buscaProveedor(rfcU).setRfc(rfcN);
          break;
          case 3:  System.out.println("-Ingrese su nueva calle: ");
          String calleN= usuario.nextLine();
          usuario.next();
          buscaProveedor(rfcU).setCalle(calleN);
          break;
          case 4:  System.out.println("-Ingrese su nuevo numero de direccion: ");
          String numDireccionN = usuario.nextLine();
          usuario.next();
          buscaProveedor(rfcU).setNumeroDireccion(numDireccionN);
          break;
          case 5:  System.out.println("-Ingrese su nuevo municipio: ");
          String municipioN= usuario.nextLine();
          usuario.next();
          buscaProveedor(rfcU).setMunicipio(municipioN);
          break;
          case 6:  System.out.println("-Ingrese su nuevo codigo postal: ");
          String codigoPostalN= usuario.nextLine();
          usuario.next();
          buscaProveedor(rfcU).setCodigoPostal(codigoPostalN);
          break;
          case 7:  System.out.println("-Ingrese su nuevo estado: ");
          String estadoN= usuario.nextLine();
          usuario.next();
          buscaProveedor(rfcU).setEstado(estadoN);
          break;
          case 8:  System.out.println("-Ingrese su nuevo telefono celular: ");
          String celularN= usuario.nextLine();
          usuario.next();
          buscaProveedor(rfcU).setTelefonoCelular(celularN);
          break;
          case 9:  System.out.println("-Ingrese su nuevo telefono fijo: ");
          String telFijoN= usuario.nextLine();
          usuario.next();
          buscaProveedor(rfcU).setTelefonoFijo(telFijoN);
          break;
        }
        System.out.println("El proveedor quedo: " + buscaProveedor(rfcU));
      }else{
         System.out.println("   El RFC no se ha encontrado. ");
      }

     }
  }

  public void menuProductos(Scanner usuario){ 
    System.out.println("¿Eres cliente o proveedor? \n1. Cliente \n2. Proveedor");
    int menuProducto;
    while(true){
                    if(!usuario.hasNextInt()){
                      System.out.println("\n" + "La opcion debe ser un NUMERO");
                      usuario.nextLine();
                      continue;
                    }
                    menuProducto= usuario.nextInt();
                    if(menuProducto<1 ||menuProducto>3){
                      System.out.println("\n" + "Elige un indice valido");
                      usuario.nextLine();
                      continue;
                    }
                    break;
                  }

    switch(menuProducto){
      //es cliente
    case 1:
      System.out.println("Te mostramos los productos que tenemos disponibles:" + "\n" +imprimeProductos());
      System.out.println("¿Qué producto deseas adquirir?");
      int opcionCliente;
      while(true){
                    if(!usuario.hasNextInt()){
                      System.out.println("\n" + "La opcion debe ser un NUMERO");
                      usuario.nextLine();
                      continue;
                    }
                    opcionCliente= usuario.nextInt();
                    if(opcionCliente<1 ||opcionCliente>12){
                      System.out.println("\n" + "Elige un indice valido");
                      usuario.nextLine();
                      continue;
                    }
                    break;
                  }
      int disponibilidad = productos[opcionCliente-1].getUnidadesDisponibles()-1;
      productos[opcionCliente-1].setUnidadesDisponibles(disponibilidad);
      System.out.println("El producto seleccionado fue: " +  productos[opcionCliente-1] );
     break;
     //es proveedor
     case 2: 
     break;
   }
  }

  public static void main(String [] args){
    Nixut tienda = new Nixut();
    tienda.carga();
    Categoria belleza = new Categoria("Belleza", "Productos para lucir espectacular");
    Categoria higiene = new Categoria("Higiene personal", "Productos para el cuidado del cuerpo");
    Categoria tecnologia = new Categoria("Tecnologia", "Productos electrónicos para cualquier necesidad");
    Categoria limpieza = new Categoria("Limpieza del Hogar", "Productos para tener un hogar impecable");

    /*Producto producto1 = new Producto("LCM455", 500, 4, "Labial Color Carmin Mate MAC Labial color carmin que te dejara un acabado mate", 15, "Belleza");
    Producto producto2 = new Producto("MPN560", 500, 6, "Mascara de pestanas Una mascara de pestañas duradera y que aporta vitamina E ", 12, "Belleza");
    Producto producto3 = new Producto("PSM654", 689, 7, "Paleta de Sombras MAC Paleta con colores calidos", 10, "Belleza");
    Producto producto4 = new Producto("SP3017", 70, 22, "Shampoo Pantene Para reparación de puntas abiertas", 15, "Higiene personal");
    Producto producto5 = new Producto("PDC128", 35, 15, "Pasta dental Colgate Para una sonrisa de comercial", 12, "Higiene personal");
    Producto producto6 = new Producto("CDC551", 25, 12, "Cepillo de diente Colgate Cepillo con cerdas suaves", 13, "Higiene personal");
    Producto producto7 = new Producto("PSC075", 30000, 6, "Pantalla Samsung Curva 75' Pantalla Curva para que no se vean los pixeles", 20, "Tecnologia");
    Producto producto8 = new Producto("SIPM13", 35000, 4, "SmarthPhone iPhone 13 Pro Max 64GB El mejor iPhone del mercado", 2, "Tecnologia");
    Producto producto9 = new Producto("TH0172", 22000, 8, "Tableta Huawei 17' La mejor tableta para el regreso a clases", 15, "Tecnologia");
    Producto producto10 = new Producto("CCL073", 20, 20, "Cloro Cloralex 1l Elimina 99.9% de virus y bacterias", 20, "Limpieza del Hogar");
    Producto producto11 = new Producto("LFA674", 45, 14, "Limpiador líquido Fabuloso Fragancia concentrada intensa y duradera", 15, "Limpieza del Hogar");
    Producto producto12 = new Producto("HLB124", 30, 17, "Harpic limpiador de Baños Quita marcas de sarro en el baño", 17, "Limpieza del Hogar");

    tienda.agregaProductos(producto1);
    tienda.agregaProductos(producto2);
    tienda.agregaProductos(producto3);
    tienda.agregaProductos(producto4);
    tienda.agregaProductos(producto5);
    tienda.agregaProductos(producto6);
    tienda.agregaProductos(producto7);
    tienda.agregaProductos(producto8);
    tienda.agregaProductos(producto9);
    tienda.agregaProductos(producto10);
    tienda.agregaProductos(producto11);
    tienda.agregaProductos(producto12);*/

    Scanner sc = new Scanner(System.in);
    int opcion;
    do{
    System.out.println("¡¡¡Bienvenido a Nixut!!!\n 1. Cliente \n 2. Proveedor \n 3. Productos \n 4. Categorias \n 5. Salir" );
    System.out.println("Seleccione una opcion: ");
    while(true){
                    if(!sc.hasNextInt()){
                      System.out.println("\n" + "La opcion debe ser un NUMERO");
                      sc.nextLine();
                      continue;
                    }
                    opcion= sc.nextInt();
                    if(opcion<1 || opcion>5){
                      System.out.println("\n" + "Elige un indice valido");
                      sc.nextLine();
                      continue;
                    }
                    break;
                  }
    switch(opcion){
      case 1: tienda.menuCliente(sc);
      break;
      case 2: tienda.menuProveedor(sc);
      break;
      case 3: tienda.menuProductos(sc);
      break;
      case 4:

      for(int i = 0; i<tienda.productos.length; i++){
        if( tienda.productos[i].getCategoria().equals("Belleza"))
          belleza.agregarProducto(tienda.productos[i].getCodigoProducto());
        if( tienda.productos[i].getCategoria().equals("Tecnologia"))
          tecnologia.agregarProducto(tienda.productos[i].getCodigoProducto());
        if( tienda.productos[i].getCategoria().equals("Limpieza del Hogar"))
          limpieza.agregarProducto(tienda.productos[i].getCodigoProducto());
        if( tienda.productos[i].getCategoria().equals("Higiene personal"))
          higiene.agregarProducto(tienda.productos[i].getCodigoProducto());
      }
      System.out.println("Estas son las categorias que hay " + "\n 1.Belleza: Productos para lucir espectacular"+ " Cantidad de tipos productos: "+ belleza.getCantidadProductos()+
                                                                        "\n 2.Higiene personal: Productos para el cuidado del cuerpo"+ " Cantidad de tipos productos: "+ higiene.getCantidadProductos()+
                                                                        "\n 3.Tecnología: Productos electrónicos para cualquier necesidad "+ " Cantidad de tipos productos: "+ tecnologia.getCantidadProductos()+
                                                                        "\n 4.Limpieza del Hogar: Productos para tener un hogar impecable"+" Cantidad de tipos productos: "+ limpieza.getCantidadProductos());
      case 5: tienda.guarda();
      break;
      }
    }while (opcion!=5);
  }
}