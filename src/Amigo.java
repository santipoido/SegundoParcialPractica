import org.json.JSONObject;

public class Amigo {
    private String nombre;
    private boolean piloto;
    private Nave nave;

    public Amigo(String nombre, boolean piloto, Nave nave) {
        this.nombre = nombre;
        this.piloto = piloto;
        this.nave = nave;
    }

    public Amigo(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isPiloto() {
        return piloto;
    }

    public void setPiloto(boolean piloto) {
        this.piloto = piloto;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    @Override
    public String toString() {
        if (nave != null) {
            return "Nombre: "+nombre + " " + ", Piloto?: "+piloto + " " + "," +nave;
        }else{
            return "Nombre: "+nombre + " " + ", Piloto?: "+piloto + " " + ",No posee nave";
        }
    }


    public JSONObject toJson(){
        JSONObject obj = new JSONObject();
        obj.put("nombre", nombre);
        obj.put("piloto", piloto);
        obj.put("nave", nave.toString());
        return obj;
    }
}
