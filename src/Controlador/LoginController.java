/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.UsuarioDAO;

/**
 *
 * @author Usuario
 */
public class LoginController {
     private UsuarioDAO usuarioDAO;

    public LoginController() {
        usuarioDAO = new UsuarioDAO(); // Inicializa el DAO
    }

    // Método para autenticar al usuario
    public boolean login(String nombreUsuario, String contraseña) {
        return usuarioDAO.autenticar(nombreUsuario, contraseña);
    }
}
