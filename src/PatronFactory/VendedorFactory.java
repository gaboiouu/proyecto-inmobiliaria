/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronFactory;

import Modelo.Vendedor;

/**
 *
 * @author Usuario
 */
public class VendedorFactory {
    // Método para crear un vendedor sin ID (Nuevo)
    public static Vendedor crearVendedor(String nombre, String apellido, String dni, String correo, String telefono) {
        return new Vendedor(nombre, apellido, dni, correo, telefono);
    }

    // Método para crear un vendedor con ID (cuando ya existe en la base de datos)
    public static Vendedor crearVendedorConId(int id_vendedor, String nombre, String apellido, String dni, String correo, String telefono) {
        return new Vendedor(id_vendedor, nombre, apellido, dni, correo, telefono);
    }
}
