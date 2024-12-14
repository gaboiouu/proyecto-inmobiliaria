
package Modelo;


public class Inmueble {
    
    private int idInmueble;
    private double precio;
    private String descripcion;
    private String estado;
    private String tipoInmueble;
    private String ubicacion;
    
    public Inmueble(){
        
    }
    
    //constructor con id
    public Inmueble(int idInmueble, double precio, String descripcion, String estado, String tipoInmueble, String ubicacion) {
        this.idInmueble = idInmueble;
        this.precio = precio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipoInmueble = tipoInmueble;
        this.ubicacion = ubicacion;
    }
    
    //constructor sin id
    public Inmueble(double precio, String descripcion, String estado, String tipoInmueble, String ubicacion) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipoInmueble = tipoInmueble;
        this.ubicacion = ubicacion;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
