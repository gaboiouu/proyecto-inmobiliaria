
package Dao;

import Modelo.Inmueble;
import java.util.List;


public interface IInmueble {
    void insertar(Inmueble inmueble);
    void actualizar(Inmueble inmueble);
    void eliminar(int idInmueble);
    Inmueble obtener(int idInmueble);
    List<Inmueble> obtenerTodos();
     List<String> obtenerDescripcionesInmuebles(); 
     double obtenerPrecioPorDescripcion(String descripcion);
}
