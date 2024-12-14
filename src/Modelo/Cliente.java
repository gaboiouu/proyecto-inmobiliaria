
package Modelo;


public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String dni;
    private String genero;
    private String telefono;
    
    public Cliente() {
    }
    
    //Constructor coin id
    public Cliente(int idCliente, String nombre, String apellido, String direccion, String correo, String dni, String genero, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.dni = dni;
        this.genero = genero;
        this.telefono = telefono;
    }
    // Constructor sin ID (para insertar)
    public Cliente(String nombre, String apellido, String direccion, String correo, String dni, String genero, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.dni = dni;
        this.genero = genero;
        this.telefono = telefono;
    }
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
