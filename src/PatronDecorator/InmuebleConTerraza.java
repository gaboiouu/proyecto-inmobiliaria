
package PatronDecorator;

public class InmuebleConTerraza extends InmuebleDecorator {
    
    public InmuebleConTerraza(Decorador inmuebleDecorado) {
        super(inmuebleDecorado);
    }
    @Override
    public String obtenerDescripcion() {
        // Agrega la descripción de la piscina
        return super.obtenerDescripcion() + ", con Terraza";
    }

    @Override
    public double obtenerPrecio() {
        // Aumenta el precio por la terraza
        return super.obtenerPrecio() + 25000; // 25,000 por la terraza
    }

    
}
