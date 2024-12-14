
package Dao;

import Modelo.Inmueble;
import PatronSingleton.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InmuebleDAO implements IInmueble{
    private Connection connection;

    public InmuebleDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void insertar(Inmueble inmueble) {
        String query = "INSERT INTO Inmueble (precio, descripcion, estado, tipo_inmueble, ubicacion) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, inmueble.getPrecio());
            stmt.setString(2, inmueble.getDescripcion());
            stmt.setString(3, inmueble.getEstado());
            stmt.setString(4, inmueble.getTipoInmueble());
            stmt.setString(5, inmueble.getUbicacion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Inmueble inmueble) {
        String query = "UPDATE Inmueble SET precio = ?, descripcion = ?, estado = ?, tipo_inmueble = ?, ubicacion = ? WHERE id_inmueble = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, inmueble.getPrecio());
            stmt.setString(2, inmueble.getDescripcion());
            stmt.setString(3, inmueble.getEstado());
            stmt.setString(4, inmueble.getTipoInmueble());
            stmt.setString(5, inmueble.getUbicacion());
            stmt.setInt(6, inmueble.getIdInmueble());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int idInmueble) {
        String query = "DELETE FROM Inmueble WHERE id_inmueble = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idInmueble);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Inmueble obtener(int idInmueble) {
        Inmueble inmueble = null;
        String query = "SELECT * FROM Inmueble WHERE id_inmueble = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idInmueble);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                inmueble = new Inmueble(
                    rs.getInt("id_inmueble"),
                    rs.getDouble("precio"),
                    rs.getString("descripcion"),
                    rs.getString("estado"),
                    rs.getString("tipo_inmueble"),
                    rs.getString("ubicacion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inmueble;
    }

    @Override
    public List<Inmueble> obtenerTodos() {
        List<Inmueble> inmuebles = new ArrayList<>();
        String query = "SELECT * FROM Inmueble";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Inmueble inmueble = new Inmueble(
                    rs.getInt("id_inmueble"),
                    rs.getDouble("precio"),
                    rs.getString("descripcion"),
                    rs.getString("estado"),
                    rs.getString("tipo_inmueble"),
                    rs.getString("ubicacion")
                );
                inmuebles.add(inmueble);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inmuebles;
    }
    
    
    public List<String> obtenerDescripcionesInmuebles() {
        List<String> descripcionesInmuebles = new ArrayList<>();
        String query = "SELECT descripcion FROM Inmueble WHERE estado = 'Disponible'";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                descripcionesInmuebles.add(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return descripcionesInmuebles;
    }
    
    
    @Override
    public double obtenerPrecioPorDescripcion(String descripcion) {
        double precio = 0.0;
        String query = "SELECT precio FROM Inmueble WHERE descripcion = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, descripcion);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                precio = rs.getDouble("precio");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return precio;
    }
    
    public boolean actualizarEstadoInmueble(String descripcionInmueble, String nuevoEstado) {
        String query = "UPDATE Inmueble SET estado = ? WHERE descripcion = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nuevoEstado);
            statement.setString(2, descripcionInmueble);
            return statement.executeUpdate() > 0; // Devuelve true si se actualizó
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}