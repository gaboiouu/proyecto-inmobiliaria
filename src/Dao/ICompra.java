
package Dao;

import Modelo.Compra;
import java.util.List;

public interface ICompra {
    void insertar(Compra compra);
    Compra obtenerPorId(int idCompra);
    List<Compra> obtenerTodas();
    void actualizar(Compra compra);
    void eliminar(int idCompra);

}
