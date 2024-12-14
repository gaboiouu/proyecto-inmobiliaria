
package Dao;

import Modelo.Pago;
import PatronSingleton.DatabaseConnection;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO implements IPago{
    private Connection connection;

    public PagoDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void insertar(Pago pago) {
        String query = "INSERT INTO pago (id_compra, total , fecha) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pago.getIdCompra());
            stmt.setBigDecimal(2, BigDecimal.valueOf(pago.getTotal()));
            stmt.setDate(3, new java.sql.Date(pago.getFecha().getTime()));           
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pago obtenerPorId(int idPago) {
        String query = "SELECT * FROM Pago WHERE id_pago = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPago);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Pago(
                    rs.getInt("id_pago"),
                    rs.getInt("id_compra"), 
                    rs.getDouble("total"),
                    rs.getDate("fecha")                         
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Pago> obtenerPorCompra(int idCompra) {
        List<Pago> pagos = new ArrayList<>();
        String query = "SELECT * FROM Pago WHERE id_compra = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idCompra);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pago pago = new Pago(
                    rs.getInt("id_pago"),
                    rs.getInt("id_compra"),          
                    rs.getDouble("total"),
                    rs.getDate("fecha")
                );
                pagos.add(pago);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagos;
    }

    @Override
    public void actualizar(Pago pago) {
        String query = "UPDATE Pago SET id_compra = ?, fecha = ?, total = ? WHERE id_pago = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, pago.getIdCompra());
            stmt.setDate(2, new java.sql.Date(pago.getFecha().getTime()));
            stmt.setDouble(3, pago.getTotal());
            stmt.setInt(4, pago.getIdPago());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int idPago) {
        String query = "DELETE FROM Pago WHERE id_pago = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idPago);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

