import org.json.JSONObject;

import java.util.ArrayList;

public class Personajes {
    private String nombre;
    private int edad;
    private boolean jedi;
    private String planeta_nacimiento;
    private Maestro maestro;
    private ArrayList<Amigo> amigos;
    private ArrayList<Evento> eventos;

    public Personajes(String nombre, int edad, boolean jedi, String planeta_nacimiento, Maestro maestro) {
        this.nombre = nombre;
        this.edad = edad;
        this.jedi = jedi;
        this.planeta_nacimiento = planeta_nacimiento;
        this.maestro = maestro;
        this.amigos = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    public Personajes(String nombre, int edad, boolean jedi, String planeta_nacimiento, Maestro maestro, ArrayList<Amigo> amigos, ArrayList<Evento> eventos) {
        this.nombre = nombre;
        this.edad = edad;
        this.jedi = jedi;
        this.planeta_nacimiento = planeta_nacimiento;
        this.maestro = maestro;
        this.amigos = amigos;
        this.eventos = eventos;
    }

    public Personajes(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isJedi() {
        return jedi;
    }

    public void setJedi(boolean jedi) {
        this.jedi = jedi;
    }

    public String getPlaneta_nacimiento() {
        return planeta_nacimiento;
    }

    public void setPlaneta_nacimiento(String planeta_nacimiento) {
        this.planeta_nacimiento = planeta_nacimiento;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", jedi=" + jedi +
                ", planeta_nacimiento='" + planeta_nacimiento + '\'' +
                ", maestro=" + maestro.toString() +
                ", amigos=" + amigos.toString() +
                ", eventos=" + eventos.toString() +
                '}';
    }

    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("nombre", nombre);
        json.put("edad", edad);
        json.put("jedi", jedi);
        json.put("planeta_nacimiento", planeta_nacimiento);
        json.put("maestro", maestro.toString());
        json.put("amigos", amigos.toString());
        json.put("eventos", eventos.toString());
        return json;
    }
}
