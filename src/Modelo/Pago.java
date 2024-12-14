
package Modelo;

import java.util.Date;


public class Pago {
    private int idPago;
    private int idCompra;
    private Date fecha;
    private double total;
    
    public Pago(){
        
    }

    public Pago(int idPago, int idCompra, double total, Date fecha ) {
        this.idPago = idPago;
        this.idCompra = idCompra;
        this.total = total;
        this.fecha = fecha;
    }
    
    // Constructor con los campos idCompra, monto, y fecha
    public Pago(int idCompra, double total, Date fecha) {
        this.idCompra = idCompra;
        this.total = total;
        this.fecha = fecha;
    }


    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

