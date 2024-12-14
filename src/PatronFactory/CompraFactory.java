/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronFactory;

import Modelo.Compra;
import java.util.Date;

/**
 *
 * @author Usuario
 */

public  class CompraFactory {
    // Método para crear una Compra con todos los atributos, incluyendo id
    public static Compra crearCompraSinIdCompra(int idCliente, Date fecha, String nombreCliente,  String descripcionInmueble, double monto) {
        return new Compra(idCliente, fecha, nombreCliente, descripcionInmueble, monto);
    }

    public static Compra crearCompra(Date fecha, String nombreCliente, String descripcionInmueble, double monto) {
        Compra compra = new Compra(fecha, nombreCliente, descripcionInmueble, monto);
        return compra;
    }
}
