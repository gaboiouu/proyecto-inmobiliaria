
package Dao;

import Modelo.Vendedor;
import java.util.List;

public interface IVendedor {
    void insertar(Vendedor vendedor);  
    Vendedor obtenerPorId(int idVendedor); 
    List<Vendedor> obtenerTodos(); 
    void actualizar(Vendedor vendedor);
    void eliminar(int idVendedor); 
}

