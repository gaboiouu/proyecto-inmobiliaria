
package Controlador;

import Dao.VendedorDAO;
import Modelo.Vendedor;
import PatronFactory.VendedorFactory;
import PatronesObserver.Observer;
import PatronesObserver.SistemaNotificacion;
import java.util.ArrayList;
import java.util.List;

public class VendedorControlador {
    private VendedorDAO vendedorDAO;
    private List<Observer> observadores = new ArrayList<>();
     private SistemaNotificacion sistemaNotificacion;
    
    /**
     * Constructor que recibe la instancia del DAO.
     * @param vendedorDAO Instancia de VendedorDAO
     */
    public VendedorControlador() {
        this.vendedorDAO = new VendedorDAO();
    }
    
    public void insertarVendedor(String nombre, String apellido, String dni, String correo, String telefono) {
        // Crear el vendedor usando la fábrica
        Vendedor vendedor = VendedorFactory.crearVendedor(nombre, apellido, dni, correo, telefono);
        vendedorDAO.insertar(vendedor);
    }

    public void actualizarVendedor(int idVendedor, String nombre, String apellido, String dni, String correo, String telefono) {
        // Crear el vendedor usando la fábrica
        Vendedor vendedor = VendedorFactory.crearVendedorConId(idVendedor, nombre, apellido, dni, correo, telefono);
        vendedorDAO.actualizar(vendedor);
    }

    public void eliminarVendedor(int idVendedor) {
        vendedorDAO.eliminar(idVendedor);
    }

    public Vendedor obtenerPorID(int idVendedor) {
        return vendedorDAO.obtenerPorId(idVendedor);
    }

    public List<Vendedor> obtenerVendedor() {
        return vendedorDAO.obtenerTodos();
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
    public void notificarSalida() {
        notificarObservadores("Saliendo de Gestion de Compras...");
    }
}

