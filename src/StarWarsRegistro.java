import java.util.ArrayList;
import java.util.List;

public class StarWarsRegistro<T extends Personajes> {
    private List<T> lista;

    public StarWarsRegistro() {
        this.lista = new ArrayList<T>();
    }

    public int buscarPorNombre (String nombre){
        int pos = -1;
        for (int i=0; i<lista.size(); i++){
            if (lista.get(i).getNombre().equalsIgnoreCase(nombre)){
                pos = i;
            }
        }
        return pos;
    }

    public boolean agregarPersonaje (T personaje){
        int pos = buscarPorNombre(personaje.getNombre());
        if (pos == -1){
            lista.add(personaje);
            return true;
        }
        return false;
    }

    public T obtenerPersonajePorNombre (String nombre) throws PersonajeNoEncontradoExcepcion {
        int pos = buscarPorNombre(nombre);
        if (pos != -1){
            return lista.get(pos);
        }else{
            throw new PersonajeNoEncontradoExcepcion(nombre);
        }
    }

    public boolean eliminarPersonaje (T personaje){
        int pos = buscarPorNombre(personaje.getNombre());
        if (pos != -1){
            lista.remove(pos);
            return true;
        }
        return false;
    }

    public String listarPersonajes(){
        StringBuilder rta = new StringBuilder();
        for (int i=0; i<lista.size(); i++){
            rta.append(lista.get(i).toString());
            rta.append("\n");
        }
        return rta.toString();
    }

    public String limpiar(){
        lista.clear();
        return "Lista borrada correctamente!";
    }
}
