
package Modelo;

import java.util.Date;


public class Compra {
    private int idCompra;
    private int idCliente;
    private Date fecha;
    private String nombreCliente;
    private String descripcionInmueble;
    private double monto;
    
    public Compra(){
        
    }
    //con id compra y cliente
    public Compra(int idCompra, int idCliente, Date fecha, String nombreCliente, String descripcionInmueble, double monto) {
        this.idCompra = idCompra;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.descripcionInmueble = descripcionInmueble;
        this.monto = monto;
    }
    //sin id compra
    public Compra(int idCliente, Date fecha, String nombreCliente, String descripcionInmueble, double monto) {
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.descripcionInmueble = descripcionInmueble;
        this.monto = monto;
    }
    
    
    //sin id compra y cliente
    public Compra(Date fecha, String nombreCliente, String descripcionInmueble, double monto) {
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.descripcionInmueble = descripcionInmueble;
        this.monto = monto;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDescripcionInmueble() {
        return descripcionInmueble;
    }

    public void setDescripcionInmueble(String descripcionInmueble) {
        this.descripcionInmueble = descripcionInmueble;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }   
}
