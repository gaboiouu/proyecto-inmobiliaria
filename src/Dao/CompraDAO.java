
package Dao;

import Modelo.Compra;
import PatronSingleton.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO implements ICompra{
    private Connection connection;

    // Constructor de la clase DAO
    public CompraDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    // Insertar una compra
    @Override
    public void insertar(Compra compra) {
        String query = "INSERT INTO compra (id_cliente, fecha, nombre_cliente, descripcion_inmueble, monto) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, compra.getIdCliente());
            stmt.setDate(2, new java.sql.Date(compra.getFecha().getTime()));
            stmt.setString(3, compra.getNombreCliente());
            stmt.setString(4, compra.getDescripcionInmueble());
            stmt.setDouble(5, compra.getMonto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    

    @Override
    public Compra obtenerPorId(int idCompra) {
        Compra compra = null;
        String query = "SELECT * FROM compra WHERE id_compra = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idCompra);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("id_compra"));
                compra.setIdCliente(rs.getInt("id_cliente"));
                compra.setFecha(rs.getDate("fecha"));
                compra.setNombreCliente(rs.getString("nombre_cliente"));
                compra.setDescripcionInmueble(rs.getString("descripcion_inmueble"));
                compra.setMonto(rs.getDouble("monto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compra;
    }

    @Override
    public List<Compra> obtenerTodas() {
        List<Compra> compras = new ArrayList<>();
        String query = "SELECT * FROM compra";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(rs.getInt("id_compra"));
                compra.setIdCliente(rs.getInt("id_cliente"));
                compra.setFecha(rs.getDate("fecha"));
                compra.setNombreCliente(rs.getString("nombre_cliente"));
                compra.setDescripcionInmueble(rs.getString("descripcion_inmueble"));
                compra.setMonto(rs.getDouble("monto"));
                compras.add(compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compras;
    }

    @Override
    public void actualizar(Compra compra) {
        String query = "UPDATE compra SET id_cliente = ?, fecha = ?, nombre_cliente = ?, descripcion_inmueble = ?, monto = ? WHERE id_compra = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, compra.getIdCliente());
            stmt.setDate(2, new java.sql.Date(compra.getFecha().getTime()));
            stmt.setString(3, compra.getNombreCliente());
            stmt.setString(4, compra.getDescripcionInmueble());
            stmt.setDouble(5, compra.getMonto());
            stmt.setInt(6, compra.getIdCompra());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int idCompra) {
        String query = "DELETE FROM compra WHERE id_compra = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idCompra);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int insertarID(Compra compra) {
    String query = "INSERT INTO compra (id_cliente, fecha, nombre_cliente, descripcion_inmueble, monto) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        stmt.setInt(1, compra.getIdCliente());
        stmt.setDate(2, new java.sql.Date(compra.getFecha().getTime()));
        stmt.setString(3, compra.getNombreCliente());
        stmt.setString(4, compra.getDescripcionInmueble());
        stmt.setDouble(5, compra.getMonto());
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1; // Devuelve -1 si la inserción falla
}
}

