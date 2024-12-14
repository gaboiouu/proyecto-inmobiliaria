
package Dao;

import Modelo.Pago;
import java.util.List;

public interface IPago {
    void insertar(Pago pago);  
    Pago obtenerPorId(int idPago); 
    List<Pago> obtenerPorCompra(int idCompra); 
    void actualizar(Pago pago);  
    void eliminar(int idPago); 
}
