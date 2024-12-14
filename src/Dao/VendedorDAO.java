
package Dao;

import Modelo.Vendedor;
import PatronSingleton.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO implements IVendedor{
    private Connection connection;

    public VendedorDAO() {
        this.connection = DatabaseConnection.getConnection();
    }
    
    
    @Override
    public void insertar(Vendedor vendedor) {
        String query = "INSERT INTO Vendedor (nombre, apellido, dni, telefono, correo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, vendedor.getNombre());
            stmt.setString(2, vendedor.getApellido());
            stmt.setString(3, vendedor.getDni());
            stmt.setString(4, vendedor.getTelefono());
            stmt.setString(5, vendedor.getCorreo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vendedor obtenerPorId(int idVendedor) {
        String query = "SELECT * FROM Vendedor WHERE id_vendedor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idVendedor);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Vendedor(
                    rs.getInt("id_vendedor"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("dni")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vendedor> obtenerTodos() {
        List<Vendedor> vendedores = new ArrayList<>();
        String query = "SELECT * FROM Vendedor";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vendedor vendedor = new Vendedor(
                    rs.getInt("id_vendedor"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono"),
                    rs.getString("correo"),
                    rs.getString("dni")
                );
                vendedores.add(vendedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendedores;
    }

    @Override
    public void actualizar(Vendedor vendedor) {
        String query = "UPDATE Vendedor SET nombre = ?, apellido = ?, telefono = ?, correo = ? WHERE id_vendedor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, vendedor.getNombre());
            stmt.setString(2, vendedor.getApellido());
            stmt.setString(3, vendedor.getTelefono());
            stmt.setString(4, vendedor.getCorreo());
            stmt.setInt(5, vendedor.getId_vendedor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int idVendedor) {
        String query = "DELETE FROM Vendedor WHERE id_vendedor = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idVendedor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    

