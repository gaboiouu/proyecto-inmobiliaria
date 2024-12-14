/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronFactory;

import Modelo.Pago;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class PagoFactory {
    // Método Factory para crear una instancia de Pago
    public static Pago crearPago(int idCompra, double total, Date fecha) {
        return new Pago(idCompra, total, fecha);
    }
    
    // Si necesitas crear un Pago con ID (por ejemplo, al obtenerlo de la base de datos)
    public static Pago crearPagoConId(int idPago, int idCompra, double total, Date fecha) {
        return new Pago(idPago, idCompra, total, fecha);
    }
}
