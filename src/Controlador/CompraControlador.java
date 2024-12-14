
package Controlador;

import Dao.ClienteDAO;
import Dao.CompraDAO;
import Modelo.Compra;
import PatronFactory.CompraFactory;
import PatronesObserver.Observer;
import PatronesObserver.SistemaNotificacion;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompraControlador {
    private PagoControlador pagoControlador;
    private CompraDAO compraDAO;
    private ClienteDAO clienteDAO;
    private List<Observer> observadores = new ArrayList<>(); 
    private SistemaNotificacion sistemaNotificacion;  // Notificación de cambios


    public CompraControlador () {
        this.pagoControlador = new PagoControlador();
        this.compraDAO = new CompraDAO();
        this.clienteDAO = new ClienteDAO();
        this.sistemaNotificacion = new SistemaNotificacion();
    }

    public int insertarCompra(int idCliente, Date fecha, String nombreCliente, String descripcionInmueble, double monto) {
        Compra compra = CompraFactory.crearCompraSinIdCompra(idCliente, fecha, nombreCliente, descripcionInmueble, monto);
        return compraDAO.insertarID(compra);
    }

    public void actualizarCompra(Date fecha,String nombreCliente, String descripcionInmueble, double monto) {
        Compra compra = CompraFactory.crearCompra(fecha, nombreCliente, descripcionInmueble, monto);
        compraDAO.actualizar(compra);
    }

    public void eliminarCompra(int idCompra) {
        compraDAO.eliminar(idCompra);
    }

    public Compra obtenerCompra(int idCompra) {
        return compraDAO.obtenerPorId(idCompra);
    }

    public List<Compra> obtenerTodasLasCompras() {
        return compraDAO.obtenerTodas();
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

    
    //para entrar a la vista gestion de compra
    public void entrarVista(){
        notificarObservadores("Entrando a Gestión de Compras...");
    }
    
    //mensaje de salir de la vista
    public void notificarSalida() {
        notificarObservadores("Saliendo de Gestion de Compras...");
    }

    //mensaje de actualizar compra
    public void actualizarCompra() {
        notificarObservadores("Compra actualizado con éxito.");
    }
    
    public void RegistraCompraYactualizaEstadoInmueble(){
        notificarObservadores("Compra registrada y estado del inmueble actualizado.");
    }
    
       public void errorActualizarInmueble(){
        notificarObservadores("Compra registrada, pero no se pudo actualizar el estado del inmueble.");
    }
    
    public void errorRegistrarCompra(){
        notificarObservadores("Error al registrar la compra. Intente de nuevo.");
    }
    
    public void editar(){
        notificarObservadores("Por favor, selccione una fila para editar.");
    }
    public void errorActualizarBD(){
        notificarObservadores("Error al actualizar compra en la base de datos");
    }
    public void filaActualizar(){
        notificarObservadores("Seleccione una fila para actualizar");
    }
    public void errorActualizar(){
        notificarObservadores("Error al actualizar compra");
    }
}

