import org.json.JSONObject;

public class Evento {
    private String nombre;
    private int anio;
    private boolean ganada;

    public Evento(String nombre, int anio, boolean ganada) {
        this.nombre = nombre;
        this.anio = anio;
        this.ganada = ganada;
    }

    public Evento(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isGanada() {
        return ganada;
    }

    public void setGanada(boolean ganada) {
        this.ganada = ganada;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nombre='" + nombre + '\'' +
                ", anio=" + anio +
                ", ganada=" + ganada +
                '}';
    }

    public JSONObject toJson(){
        JSONObject obj = new JSONObject();
        obj.put("nombre", nombre);
        obj.put("anio", anio);
        obj.put("ganada", ganada);
        return obj;
    }
}

