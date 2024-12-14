
package PatronDecorator;

public class InmuebleBase implements Decorador {
    private double precio;
    private String descripcion;

    public InmuebleBase(String descripcion, double precio) {
        this.precio = precio;
        this.descripcion = descripcion;
    }
    
    @Override

    public String obtenerDescripcion() {
        return descripcion;
    }
    public double obtenerPrecio() {
        return precio;
    }

}

