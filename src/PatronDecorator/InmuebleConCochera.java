
package PatronDecorator;


public class InmuebleConCochera extends InmuebleDecorator{
    public InmuebleConCochera(Decorador inmuebleDecorado) {
        super(inmuebleDecorado);//pasa el componenete a la clase padre que es
    }
    
    @Override
    public String obtenerDescripcion() {
        // Agrega la descripción de cochera
        return inmuebleDecorado.obtenerDescripcion() + ", con Cochera";
    }

    @Override
    public double obtenerPrecio() {
        // Aumenta el precio por cochera
        return inmuebleDecorado.obtenerPrecio() + 15000; // 15,000 por cochera
    }

}