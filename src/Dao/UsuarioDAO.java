
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import PatronSingleton.DatabaseConnection;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO() {
        // Obtiene la conexión de la base de datos utilizando la clase DatabaseConnection
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean autenticar(String nombreUsuario, String contraseña) {
        // SQL para verificar las credenciales
        String query = "SELECT * FROM administrador WHERE usuario = ? AND contraseña = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Establecemos los parámetros de la consulta
            stmt.setString(1, nombreUsuario);
            stmt.setString(2, contraseña); // En un caso real, deberías usar hashing para la contraseña

            // Ejecutamos la consulta
            ResultSet rs = stmt.executeQuery();

            // Si encontramos un usuario que coincida, la autenticación es exitosa
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
