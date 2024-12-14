
package Dao;

import Modelo.Cliente;
import PatronSingleton.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements ICliente {

     // Variable de instancia para la conexión
    private Connection connection;

    // Constructor de la clase DAO
    public ClienteDAO() {
        this.connection = DatabaseConnection.getConnection(); // Conexión obtenida desde el Singleton
    }

    @Override
    public void insertar(Cliente cliente) {
        String query = "INSERT INTO cliente (nombre, apellido, direccion, correo, dni, genero, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getCorreo());
            stmt.setString(5, cliente.getDni());
            stmt.setString(6, cliente.getGenero());
            stmt.setString(7, cliente.getTelefono());
            stmt.executeUpdate();         
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Cliente cliente) {
        String query = "UPDATE Cliente SET nombre = ?, apellido = ?, direccion = ?, correo = ?, dni = ?, genero = ?, telefono = ? WHERE id_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getCorreo());
            stmt.setString(5, cliente.getDni());
            stmt.setString(6, cliente.getGenero());
            stmt.setString(7, cliente.getTelefono());
            stmt.setInt(8, cliente.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int idCliente) {
        String query = "DELETE FROM cliente WHERE id_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente obtener(int idCliente) {
        Cliente cliente = null;
        String query = "SELECT * FROM cliente WHERE id_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("direccion"),
                    rs.getString("correo"),
                    rs.getString("dni"),
                    rs.getString("genero"),
                    rs.getString("telefono")
                );
                cliente.setIdCliente(rs.getInt("id_cliente"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM cliente";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("direccion"),
                    rs.getString("correo"),
                    rs.getString("dni"),
                    rs.getString("genero"),
                    rs.getString("telefono")
                );
                cliente.setIdCliente(rs.getInt("id_cliente"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public List<String> obtenerNombresClientes() {
        List<String> nombresClientes = new ArrayList<>();
        String query = "SELECT nombre FROM Cliente";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                nombresClientes.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombresClientes;
    }

    public int obtenerIdClientePorNombre(String nombreCliente) {
        String query = "SELECT id_cliente FROM cliente WHERE nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nombreCliente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_cliente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; 
    }

}