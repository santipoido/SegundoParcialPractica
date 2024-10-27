import org.json.JSONObject;

import java.util.ArrayList;

public class Maestro {
    private String nombre;
    private boolean es_jedi;
    private ArrayList<String> habilidades;

    public Maestro(String nombre, boolean es_jedi) {
        this.nombre = nombre;
        this.es_jedi = es_jedi;
        this.habilidades = new ArrayList<>();
    }

    public Maestro(){}

    public Maestro(String nombre, boolean es_jedi, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.es_jedi = es_jedi;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEs_jedi() {
        return es_jedi;
    }

    public void setEs_jedi(boolean es_jedi) {
        this.es_jedi = es_jedi;
    }

    @Override
    public String toString() {
        return "Maestro{" +
                "nombre='" + nombre + '\'' +
                ", es_jedi=" + es_jedi +
                ", habilidades=" + habilidades.toString() +
                '}';
    }

    public JSONObject toJson(){
        JSONObject obj = new JSONObject();
        obj.put("nombre", nombre);
        obj.put("es_jedi", es_jedi);
        obj.put("habilidades", habilidades);
        return obj;
    }
}
