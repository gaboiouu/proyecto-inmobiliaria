
package Controlador;

import Dao.PagoDAO;
import Modelo.Pago;
import PatronFactory.PagoFactory;
import PatronesObserver.Observer;
import PatronesObserver.SistemaNotificacion;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class PagoControlador {
     private PagoDAO pagoDAO;
     private List<Observer> observadores = new ArrayList<>();
     private SistemaNotificacion sistemaNotificacion;

    public PagoControlador () {
        this.pagoDAO = new PagoDAO();
        this.sistemaNotificacion = new SistemaNotificacion();
    }

     public void insertarPago(int idCompra, double total, Date fecha) {
        // Usando el Factory para crear un objeto Pago
        Pago pago = PagoFactory.crearPago(idCompra, total, fecha);
        pagoDAO.insertar(pago);

    }

    public void actualizarPago(int idPago, int idCompra, double total, Date fecha) {
        // Usando el Factory para crear un objeto Pago
        Pago pago = PagoFactory.crearPagoConId(idPago, idCompra, total, fecha );
        pagoDAO.actualizar(pago);

    }

    public void eliminarPago(int idPago) {
        pagoDAO.eliminar(idPago);

    }

    public Pago obtenerPago(int idPago) {
        return pagoDAO.obtenerPorId(idPago);
    }

    public List<Pago> obtenerPagosPorCompra(int idCompra) {
        return pagoDAO.obtenerPorCompra(idCompra);
    }
    public void agregarObservador(Observer observador) {
        observadores.add(observador);
    }

    private void notificarObservadores(String mensaje) {
        for (Observer observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
    
    public void entrarVista(){
        notificarObservadores("Entrando a Gestión de Pagos");    
    }
    
    public void notificarSalida() {
        notificarObservadores("Saliendo de Gestion de Pagos...");
    }      
}