import org.json.JSONObject;

public class Nave {
    private String nombre;
    private String modelo;

    public Nave(String nombre, String modelo) {
        this.nombre = nombre;
        this.modelo = modelo;
    }

    public Nave(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    public JSONObject toJson(){
        JSONObject obj = new JSONObject();
        obj.put("nombre", nombre);
        obj.put("modelo", modelo);
        return obj;
    }
}
