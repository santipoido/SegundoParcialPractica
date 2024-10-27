public class PersonajeNoEncontradoExcepcion extends RuntimeException {
    String nombrePersonaje;

    public PersonajeNoEncontradoExcepcion(String nombrePersonaje) {
        super("Personaje: "+nombrePersonaje+" no encontrado");
        this.nombrePersonaje = nombrePersonaje;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }
}
