
package Controlador;

import Dao.ClienteDAO;
import Modelo.Cliente;
import PatronFactory.ClienteFactory;
import PatronesObserver.Observer;
import PatronesObserver.SistemaNotificacion;
import java.util.ArrayList;
import java.util.List;

public class ClienteControlador {
    private ClienteDAO clienteDAO;
    private List<Observer> observadores = new ArrayList<>(); 
    private SistemaNotificacion sistemaNotificacion;  // Notificación de cambios

    public ClienteControlador(){
        this.clienteDAO = new ClienteDAO();
        this.sistemaNotificacion = new SistemaNotificacion();
    }

     public void insertarCliente(String nombre, String apellido, String direccion, String correo, String dni, String genero, String telefono) {
        // Crear el cliente usando la fábrica
        Cliente cliente = ClienteFactory.crearClienteSinId(nombre, apellido, direccion, correo, dni, genero, telefono);
        clienteDAO.insertar(cliente);
    }

    public void actualizarCliente(int idCliente, String nombre, String apellido, String direccion, String correo, String dni, String genero, String telefono) {
        // Crear el cliente usando la fábrica
        Cliente cliente = ClienteFactory.crearCliente(idCliente, nombre, apellido, direccion, correo, dni, genero, telefono);
        clienteDAO.actualizar(cliente);
        
    }

    public void eliminarCliente(int idCliente) {
        clienteDAO.eliminar(idCliente);
        //Notificamos a los  observadores
    }

    public Cliente obtenerCliente(int idCliente) {
        return clienteDAO.obtener(idCliente);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteDAO.obtenerTodos();
    }
    
    // Métodos para agregar y notificar a los observadores
    public void agregarObservador(Observer observador) {
        observadores.add(observador);
    }

    private void notificarObservadores(String mensaje) {
        for (Observer observador : observadores) {
            observador.actualizar(mensaje);
        }
    }   
    public void entrarVista(){
        notificarObservadores("Entrando a Gestión Clientes...");
    }

    public void registrarCliente() {
        notificarObservadores("Cliente registrado con éxito.");
    }

    public void actualizarCliente() {
        notificarObservadores("Cliente actualizado con éxito.");
    }

    public void eliminarCliente() {
        notificarObservadores("Cliente eliminado con éxito.");
    }
    
    
    public void notificarSalida() {
        notificarObservadores("Saliendo de Gestion Clientes...");
    }
    
    public void errorRegistrar(){
        notificarObservadores("Error al registrar Cliente.");
    }
    
    public void editarCliente(){
        notificarObservadores("Seleccione una fila para editar");
    }
    
    public void filaActualizar(){
        notificarObservadores("Seleccione una fila para actualizar");
    }
    public void errorActualizar(){
        notificarObservadores("Error al actualizar cliente");
    }
}


