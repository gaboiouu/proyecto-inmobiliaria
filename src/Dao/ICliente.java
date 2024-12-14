
package Dao;

import Modelo.Cliente;
import java.util.List;

public interface ICliente {
    void insertar(Cliente cliente);
    void actualizar(Cliente cliente);
    void eliminar(int idCliente);
    Cliente obtener(int idCliente);
    List<Cliente> obtenerTodos();
    List<String> obtenerNombresClientes();
   int obtenerIdClientePorNombre(String nombreCliente);
}

