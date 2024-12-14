
package Controlador;

import Dao.InmuebleDAO;
import Modelo.Inmueble;
import PatronDecorator.Decorador;
import PatronDecorator.InmuebleBase;
import PatronDecorator.InmuebleConCochera;
import PatronDecorator.InmuebleConTerraza;
import PatronFactory.InmuebleFactory;
import PatronesObserver.Observer;
import PatronesObserver.SistemaNotificacion;
import java.util.ArrayList;
import java.util.List;

public class InmuebleControlador {
    private InmuebleDAO inmuebleDAO;
    private List<Observer> observadores = new ArrayList<>(); 
    private SistemaNotificacion sistemaNotificacion;  // Notificación de cambios

    public InmuebleControlador() {
        this.inmuebleDAO = new InmuebleDAO();
        this.sistemaNotificacion = new SistemaNotificacion();
    }

    
    // Método para insertar un nuevo inmueble con posibles decoradores
    public void insertarInmueble(double precio, String descripcion, String estado, String tipoInmueble, String ubicacion, boolean tieneCochera, boolean tieneTerraza) {
        // Crear el objeto Inmueble usando el Factory
        Inmueble inmueble = InmuebleFactory.crearInmuebleSinId(precio, descripcion, estado, tipoInmueble, ubicacion);

        // Aplicar decoradores según los parámetros
        Decorador inmuebleDecorado = new InmuebleBase(inmueble.getDescripcion(), inmueble.getPrecio());
        if (tieneCochera) {
            inmuebleDecorado = new InmuebleConCochera(inmuebleDecorado);
        }
        if (tieneTerraza) {
            inmuebleDecorado = new InmuebleConTerraza(inmuebleDecorado);
        }

        // Actualizar el inmueble con los valores decorados
        inmueble.setDescripcion(inmuebleDecorado.obtenerDescripcion());
        inmueble.setPrecio(inmuebleDecorado.obtenerPrecio());
        // Insertar el inmueble decorado en la base de datos
        inmuebleDAO.insertar(inmueble);

    }
    // Método para actualizar un inmueble
    public void actualizarInmueble(int idInmueble, double precio, String descripcion, String estado, String tipoInmueble, String ubicacion, boolean tieneCochera, boolean tieneTerraza) {
        // Usamos el Factory para crear el objeto Inmueble
        Inmueble inmueble = InmuebleFactory.crearInmueble(idInmueble, precio, descripcion, estado, tipoInmueble, ubicacion);
        // Actualizar el inmueble en la base de datos
        inmuebleDAO.actualizar(inmueble);
    }

    // Método para eliminar un inmueble por su ID
    public void eliminarInmueble(int idInmueble) {
        inmuebleDAO.eliminar(idInmueble);
    }

    // Método para obtener un inmueble por su ID
    public Inmueble obtenerInmueble(int idInmueble) {
        return inmuebleDAO.obtener(idInmueble);
    }

    // Método para obtener todos los inmuebles
    public List<Inmueble> obtenerTodosLosInmuebles() {
        return inmuebleDAO.obtenerTodos();
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
        notificarObservadores("Entrando a Gestión de Inmuebles...");
    }
    
    public void registrarInmueble() {
        notificarObservadores("Inmueble registrado con éxito.");
    }
    public void errorRegistrarInmueble() {
        notificarObservadores("Error al registrar Inmueble.");
    }

    public void actualizarInmueble() {
        notificarObservadores("Imueble actualizado con éxito.");
    }
     public void filaActualizar(){
        notificarObservadores("Seleccione una fila para actualizar");
    }
     public void errorActualizar(){
        notificarObservadores("Error al actualizar inmueble");
    }  
    public void eliminarInmueble() {
        notificarObservadores("Inmueble eliminado con éxito.");
    }
    
    public void notificarInmueble() {
        notificarObservadores("Saliendo de Gestión de Inmuebles...");
    }
    public void editar(){
        notificarObservadores("Por favor, selccione una fila para editar.");
    }
    public void errorEliminarBD(){
        notificarObservadores("Error al eliminar inmueble en la base de datos");
    }
    public void errorEliminar(){
        notificarObservadores("Error al eliminar inmueble");
    }  
}