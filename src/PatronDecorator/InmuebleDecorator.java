
package PatronDecorator;
 //Es abstracta porque no tiene lógica propia.
//Contiene una referencia al "componente decorado" (inmuebleDecorado).
//Implementa la interfaz Inmueble para que los decoradores tengan el mismo 
//comportamiento que InmuebleConcreto.
public abstract class InmuebleDecorator implements Decorador{
    protected Decorador inmuebleDecorado;

    public InmuebleDecorator(Decorador inmuebleDecorado) {
        this.inmuebleDecorado = inmuebleDecorado;
    }
    
    @Override
    public String obtenerDescripcion() {
        return inmuebleDecorado.obtenerDescripcion();
    }

    @Override
    public double obtenerPrecio() {
        return inmuebleDecorado.obtenerPrecio();
    }
}
