
package PatronesObserver;

import java.util.ArrayList;
import java.util.List;


public class SistemaNotificacion {
    private List<Observer> observadores = new ArrayList<>();

    // Agregar un observador
    public void agregarObservador(Observer observador) {
        observadores.add(observador);
    }

    // Eliminar un observador
    public void eliminarObservador(Observer observador) {
        observadores.remove(observador);
    }


     // Notificar a todos los observadores
    public void notificarObservadores(String mensaje) {
        for (Observer observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
}
