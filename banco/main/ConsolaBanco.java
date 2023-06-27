package banco.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import banco.modelos.Cliente;
import banco.modelos.Gestor;
import banco.modelos.Mensaje;
import banco.modelos.Transferencia;
import banco.util.Utiles;

public class ConsolaBanco {

	private void cerrarScanner() {
		System.out.print("Hasta luego Maricarmen");
	    teclado.close();
	}

	
	 	private List<Gestor> gestores;
	    private List<Cliente> clientes;
	    private List<Mensaje> mensajes;
	    private List<Transferencia> transferencias;
	    private Integer siguienteIdGestor;
	    private Integer siguienteIdCliente;
	    private Integer siguienteIdMensaje;
	    private Integer siguienteIdTransferencia;
	    private Scanner teclado;

    ConsolaBanco() {
    	 this.gestores = new ArrayList<>();
         this.clientes = new ArrayList<>();
         this.mensajes = new ArrayList<>();
         this.transferencias = new ArrayList<>();
         this.siguienteIdGestor = 1;
         this.siguienteIdCliente = 1;
         this.siguienteIdMensaje = 1;
         this.siguienteIdTransferencia = 1;
         this.teclado = new Scanner(System.in);
    }

    private void mostrarMenu() {
        System.out.println("\n1. Insertar gestor");
        System.out.println("2. Insertar gestores de prueba");
        System.out.println("3. Consultar gestor");
        System.out.println("4. Ver todos los gestores");
        System.out.println("5. Actualizar gestor");
        System.out.println("6. Eliminar un gestor");
        System.out.println("7. Insertar cliente");
        System.out.println("8. Consultar cliente");
        System.out.println("9. Ver todos los clientes");
        System.out.println("10. Actualizar cliente");
        System.out.println("11. Eliminar un cliente");
        System.out.println("12. Consultar un mensaje");
        System.out.println("13. Ver todos los mensajes");
        System.out.println("14. Enviar un mensaje");
        System.out.println("15. Consultar una transferencia");
        System.out.println("16. Consultar todas las transferencias");
        System.out.println("17. Enviar una transferencia");
        System.out.println("18. Login y registro");
        System.out.println("0. Salir\n");
    }

    private void insertarGestor() {
        System.out.print("Nombre: ");
        String nombre = teclado.next();
        System.out.print("Email: ");
        String email = teclado.next();
        System.out.print("Contraseña: ");
        String pass = teclado.next();
        System.out.print("Oficina: ");
        String oficina = teclado.next();
        Gestor nuevoGestor = new Gestor(siguienteIdGestor, nombre, pass, email, oficina);
        gestores.add(nuevoGestor);
        siguienteIdGestor++;
        System.out.println("Gestor creado con éxito.");
    }

    private void generarGestor() {
        System.out.print("Número de gestores: ");
        int numeroGestores = teclado.nextInt();
        for (int i = 0; i < numeroGestores; i++) {
            String usuario = Utiles.nombreAleatorio();
            String correo = Utiles.correoAleatorio();
            Gestor gestor = new Gestor(siguienteIdGestor, usuario, "", correo, "Valencia");
            gestores.add(gestor);
            siguienteIdGestor++;
        }
    }

    private void consultarGestor() {
        System.out.print("Id del gestor a consultar: ");
        int idGestor = teclado.nextInt();
        Gestor gestorResultado = buscarGestorPorId(idGestor);
        if (gestorResultado != null) {
            System.out.println(gestorResultado);
        } else {
            System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
        }
    }

    private Gestor buscarGestorPorId(Integer idGestor) {
        Gestor gestorResultado = null;
        for (int i = 0; i < gestores.size(); i++) {
            Gestor gestor = gestores.get(i);
            if (gestor.getId() == idGestor) {
                gestorResultado = gestor;
                return gestorResultado;
            }
        }
        return null;
    }

    private void verGestor() {
        if (gestores.isEmpty()) {
            System.out.println("Todavía no hay gestores.");
        }
        gestores.forEach(gestor -> {
            System.out.println(gestor);
        });
    }

    private void actualizarGestor() {
        System.out.print("Id del gestor a actualizar: ");
        Integer idGestor = teclado.nextInt();
        Gestor gestorResultado = buscarGestorPorId(idGestor);
        if (gestorResultado != null) {
            System.out.println(gestorResultado);
            System.out.println("[n] Nombre");
            System.out.println("[e] Email");
            System.out.println("[c] Contraseña");
            System.out.println("[o] Oficina");
            System.out.println("[x] Cancelar");
            System.out.print("Campo a actualizar: ");
            char opcionActualizar = teclado.next().charAt(0);
            switch (opcionActualizar) {
                case 'n':
                    System.out.print("Nombre: ");
                    String nombre = teclado.next();
                    gestorResultado.setUsuario(nombre);
                    break;
                case 'e':
                    System.out.print("Email: ");
                    String email = teclado.next();
                    gestorResultado.setCorreo(email);
                    break;
                case 'c':
                    System.out.print("Contraseña: ");
                    String pass = teclado.next();
                    gestorResultado.setPassword(pass);
                    break;
                case 'o':
                    System.out.print("Oficina: ");
                    String oficina = teclado.next();
                    gestorResultado.setOficina(oficina);
                    break;
                case 'x':
                    System.out.print("Cancelando actualización...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            if (opcionActualizar != 'x') {
                System.out.println("Se actualizó el gestor con el id " + idGestor);
            }
        } else {
            System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
        }
    }

    private void eliminarGestor() {
        System.out.print("Id del gestor a eliminar: ");
        Integer idGestor = teclado.nextInt();
        Gestor gestorResultado = buscarGestorPorId(idGestor);
        if (gestorResultado != null) {
            gestores.remove(gestorResultado);
            System.out.println("Se eliminó el gestor con el id " + idGestor);
        } else {
            System.out.println("No se pudo encontrar un gestor con el id " + idGestor);
        }
    }

    private void insertarCliente() {
        System.out.print("Nombre: ");
        String nombre = teclado.next();
        System.out.print("Contraseña: ");
        String pass = teclado.next();
        System.out.print("Email: ");
        String email = teclado.next();        
        System.out.print("El saldo es de: ");
        Double saldo = teclado.nextDouble();
        System.out.print("Id de gestor: ");
        Integer numeroDeGestor = teclado.nextInt();
        Cliente nuevoCliente = new Cliente(siguienteIdCliente, nombre, pass, email, saldo, numeroDeGestor);
        clientes.add(nuevoCliente);
        siguienteIdCliente++;
        System.out.println("Cliente creado con éxito.");
    }


    private void consultarCliente() {
        System.out.print("Id del cliente a consultar: ");
        int idCliente = teclado.nextInt();
        Cliente clienteResultado = buscarClientePorId(idCliente);
        if (clienteResultado != null) {
            System.out.println(clienteResultado);
        } else {
            System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
        }
    }

    private Cliente buscarClientePorId(Integer idCliente) {
        Cliente clienteResultado = null;
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getId() == idCliente) {
                clienteResultado = cliente;
                return clienteResultado;
            }
        }
        return null;
    }

    private void verClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Todavía no hay clientes.");
        }
        clientes.forEach(cliente -> {
            System.out.println(cliente);
        });
    }

    private void actualizarCliente() {
        System.out.print("Id del cliente a actualizar: ");
        Integer idCliente = teclado.nextInt();
        Cliente clienteResultado = buscarClientePorId(idCliente);
        if (clienteResultado != null) {
            System.out.println(clienteResultado);
            System.out.println("[n] Nombre");
            System.out.println("[e] Email");
            System.out.println("[c] Contraseña");
            System.out.println("[nc] Número de cuenta");
            System.out.println("[x] Cancelar");
            System.out.print("Campo a actualizar: ");
            char opcionActualizar = teclado.next().charAt(0);
            switch (opcionActualizar) {
                case 'n':
                    System.out.print("Nombre: ");
                    String nombre = teclado.next();
                    clienteResultado.setUsuario(nombre);
                    break;
                case 'e':
                    System.out.print("Email: ");
                    String email = teclado.next();
                    clienteResultado.setCorreo(email);
                    break;
                case 'c':
                    System.out.print("Contraseña: ");
                    String pass = teclado.next();
                    clienteResultado.setPassword(pass);
                    break;
                case 'x':
                    System.out.print("Cancelando actualización...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            if (opcionActualizar != 'x') {
                System.out.println("Se actualizó el cliente con el id " + idCliente);
            }
        } else {
            System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
        }
    }

    private void eliminarCliente() {
        System.out.print("Id del cliente a eliminar: ");
        Integer idCliente = teclado.nextInt();
        Cliente clienteResultado = buscarClientePorId(idCliente);
        if (clienteResultado != null) {
            clientes.remove(clienteResultado);
            System.out.println("Se eliminó el cliente con el id " + idCliente);
        } else {
            System.out.println("No se pudo encontrar un cliente con el id " + idCliente);
        }
    }
    
    private Mensaje buscarMensajesPorId(Integer idMensajes) {
        Mensaje mensajesResultado = null;
        for (int i = 0; i < mensajes.size(); i++) {
            Mensaje mensaje = mensajes.get(i);
            if (mensaje.getId() == idMensajes) {
                mensajesResultado = mensaje;
                return mensajesResultado;
            }
        }
        return null;
    }
    
    private Transferencia buscarTransferenciaPorId(Integer idTransferencias) {
    	Transferencia transferenciasResultado = null;
        for (int i = 0; i < transferencias.size(); i++) {
        	Transferencia transferencia = transferencias.get(i);
            if (transferencia.getId() == idTransferencias) {
            	transferenciasResultado = transferencia;
                return transferenciasResultado;
            }
        }
        return null;
    }
    
    private void consultarMensaje() {
        System.out.print("Id del mensaje a consultar: ");
        int idMensaje = teclado.nextInt();
        Mensaje mensajeResultado = buscarMensajesPorId(idMensaje);
        if (mensajeResultado != null) {
            System.out.println(mensajeResultado);
        } else {
            System.out.println("No se pudo encontrar un mensaje con el id " + idMensaje);
        }
    
    }

    private void verTodosMensajes() {
        if (mensajes.isEmpty()) {
            System.out.println("Todavía no hay mensajes.");
        }
        mensajes.forEach(mensaje -> {
            System.out.println(mensaje);
        });
    }

    private void enviarMensaje() {
        System.out.print("Id del remitente: ");
        int idOrigen = teclado.nextInt();
        Cliente remitente = buscarClientePorId(idOrigen);
        if (remitente == null) {
            System.out.println("No se pudo encontrar un cliente con el id " + idOrigen);
            return;
        }

        System.out.print("Id del destinatario: ");
        int idDestino = teclado.nextInt();
        Cliente destinatario = buscarClientePorId(idDestino);
        if (destinatario == null) {
            System.out.println("No se pudo encontrar un cliente con el id " + idDestino);
            return;
        }

        System.out.print("Mensaje: ");
        String concepto = teclado.next();
        Date fecha = new Date();
        Mensaje nuevoMensaje = new Mensaje(siguienteIdMensaje, idOrigen, idDestino, concepto, fecha);
        mensajes.add(nuevoMensaje);
        siguienteIdMensaje++;
        System.out.println("Mensaje enviado con éxito.");
    }

    private void consultarTransferencia() {
        System.out.print("Id de la transferencia a consultar: ");
        int idTransferencia = teclado.nextInt();
        Transferencia transferenciaResultado = buscarTransferenciaPorId2(idTransferencia);
        if (transferenciaResultado != null) {
            System.out.println(transferenciaResultado);
        } else {
            System.out.println("No se pudo encontrar una transferencia con el id " + idTransferencia);
        }
    }

    private Transferencia buscarTransferenciaPorId2(Integer idTransferencia) {
        Transferencia transferenciaResultado = null;
        for (Transferencia transferencia : transferencias) {
            if (transferencia.getId() == idTransferencia) {
                transferenciaResultado = transferencia;
                return transferenciaResultado;
            }
        }
        return null;
    }

    private void verTodasTransferencias() {
        if (transferencias.isEmpty()) {
            System.out.println("Todavía no hay transferencias.");
        }
        transferencias.forEach(transferencia -> {
            System.out.println(transferencia);
        });
    }

    private void enviarTransferencia() {
        System.out.print("Id del remitente: ");
        int idOrigen = teclado.nextInt();
        Cliente remitente = buscarClientePorId(idOrigen);
        if (remitente == null) {
            System.out.println("No se pudo encontrar un cliente con el id " + idOrigen);
            return;
        }

        System.out.print("Id del destinatario: ");
        int idBeneficiario = teclado.nextInt();
        Cliente destinatario = buscarClientePorId(idBeneficiario);
        if (destinatario == null) {
            System.out.println("No se pudo encontrar un cliente con el id " + idBeneficiario);
            return;
        }

        System.out.print("Monto: ");
        Integer importe = teclado.nextInt();
        System.out.print("Descripción: ");
        String concepto = teclado.next();
        Date fecha = new Date();

        Transferencia nuevaTransferencia = new Transferencia(siguienteIdTransferencia, idOrigen, idBeneficiario, importe, concepto, fecha);
        transferencias.add(nuevaTransferencia);
        siguienteIdTransferencia++;
        System.out.println("Transferencia enviada con éxito.");
    }


    private void loginYRegistro() {
        System.out.print("ID gestor: ");
        int idGestor = teclado.nextInt();
        System.out.print("Constraseña: ");
        String pass = teclado.next();
        Gestor gestor = buscarGestorPorId(idGestor);
        if (gestor != null) {
        	if(gestor.getPassword().equals(pass)) {
        		System.out.print("Login correcto ");
        	}else {
        		System.out.print("Login incorrecto ");
        	}}else {
        		System.out.print("El usuario no existe ");
        	}
        }
    




    private void iniciar() {
        int opcion = -1;
        do {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 0:
                	cerrarScanner();
                    break;
                case 1:
                    insertarGestor();
                    break;
                case 2:
                    generarGestor();
                    break;
                case 3:
                    consultarGestor();
                    break;
                case 4:
                    verGestor();
                    break;
                case 5:
                    actualizarGestor();
                    break;
                case 6:
                    eliminarGestor();
                    break;
                case 7:
                    insertarCliente();
                    break;
                case 8:
                    consultarCliente();
                    break;
                case 9:
                    verClientes();
                    break;
                case 10:
                    actualizarCliente();
                    break;
                case 11:
                    eliminarCliente();
                    break;
                case 12:
                    consultarMensaje();
                    break;
                case 13:
                    verTodosMensajes();
                    break;
                case 14:
                    enviarMensaje();
                    break;
                case 15:
                    consultarTransferencia();
                    break;
                case 16:
                    verTodasTransferencias();
                    break;
                case 17:
                    enviarTransferencia();
                    break;
                case 18:
                    loginYRegistro();
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static void main(String[] args) {
        ConsolaBanco consola = new ConsolaBanco();
        consola.iniciar();
    }
}
