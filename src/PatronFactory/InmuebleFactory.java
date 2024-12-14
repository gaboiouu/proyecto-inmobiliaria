/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronFactory;

import Modelo.Inmueble;

/**
 *
 * @author Usuario
 */
public class InmuebleFactory {
    // Método para crear un inmueble con los atributos proporcionados
    public static Inmueble crearInmueble(int idInmueble, double precio, String descripcion, String estado, String tipoInmueble, String ubicacion) {
        // Aquí se crea y devuelve el objeto Inmueble
        return new Inmueble(idInmueble, precio, descripcion, estado, tipoInmueble, ubicacion);
    }
    // Método para crear un Inmueble sin ID (para inserción)
    public static Inmueble crearInmuebleSinId(double precio, String descripcion, String estado, String tipoInmueble, String ubicacion) {
        return new Inmueble(precio, descripcion, estado, tipoInmueble, ubicacion);
    }
}
