
package PatronSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/inmobiliaria?useSSL=false&serverTimezone=UTC"; // url con el nombre de la base de datos
    private static final String USER = "root"; // el usuario por defecto
    private static final String PASSWORD = ""; // contraseña
    private static Connection connection = null;

    // Constructor privado para evitar la creación de instancias fuera de la clase
    public DatabaseConnection (){}
    
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) { // Verifica si la conexión es nula o está cerrada
                synchronized (DatabaseConnection.class) {
            if (connection == null || connection.isClosed()) { // Doble verificación dentro del bloque sincronizado
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                }
            }
        }
            } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver JDBC: " + e.getMessage());
            e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
                e.printStackTrace();
            } finally {
                connection = null; // Asegúrate de que la referencia sea eliminada
            }
        }
    }
}