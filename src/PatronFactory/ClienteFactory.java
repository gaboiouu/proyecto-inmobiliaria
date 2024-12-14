/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PatronFactory;

import Modelo.Cliente;

/**
 *
 * @author Usuario
 */
public class ClienteFactory {
     // Método para crear un Cliente con todos los atributos
    public static Cliente crearCliente(int idCliente, String nombre, String apellido, String direccion, String correo, String dni, String genero, String telefono) {
        return new Cliente(idCliente, nombre, apellido, direccion, correo, dni, genero, telefono);
    }

    // Método para crear un Cliente sin ID (para inserción)
    public static Cliente crearClienteSinId(String nombre, String apellido, String direccion, String correo, String dni, String genero, String telefono) {
        return new Cliente(nombre, apellido, direccion, correo, dni, genero, telefono);
    }

}
