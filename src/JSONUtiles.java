import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;

public class JSONUtiles {

    public JSONUtiles(){}
    public static void uploadJSON(JSONArray jsonArray, String archive){
        try{
            BufferedWriter salida = new BufferedWriter(new FileWriter(archive+".json"));
            salida.write(jsonArray.toString());
            salida.flush();
            salida.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void uploadJSON(JSONObject jsonObject, String archive){
        try{
            BufferedWriter salida = new BufferedWriter(new FileWriter(archive+".json"));
            salida.write(jsonObject.toString());
            salida.flush();
            salida.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String downloadJSON(String archive){
        StringBuilder contenido = new StringBuilder();
        String lectura= "";
        try
        {
            BufferedReader entrada = new BufferedReader(new FileReader(archive+".json"));
            while((lectura = entrada.readLine())!=null){
                contenido.append(lectura);
            }
            entrada.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        return contenido.toString();
    }

    public static ArrayList<Personajes> JSONtoObject(String rta){
        ArrayList<Personajes> listaPersonajes = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(rta);
            JSONArray jsonArray = jsonObject.getJSONArray("personajes");

            for (int i = 0; i < jsonArray.length(); i++) {
                //Creo al personaje
                JSONObject jsonPersonaje = jsonArray.getJSONObject(i);
                String nombre = jsonPersonaje.getString("nombre");
                int edad = jsonPersonaje.getInt("edad");
                boolean jedi = jsonPersonaje.getBoolean("jedi");
                String planeta_nacimiento = jsonPersonaje.getString("planeta_nacimiento");

                //Creo al Maestro
                JSONObject jsonMaestro = jsonPersonaje.getJSONObject("maestro");
                String nombreMaestro = jsonMaestro.getString("nombre");
                boolean es_jedi = jsonMaestro.getBoolean("es_jedi");
                JSONArray jsonArrayHabilidadesMaestro = jsonMaestro.getJSONArray("habilidades");
                ArrayList<String> listaHabilidades = new ArrayList<>();
                for (int j = 0; j < jsonArrayHabilidadesMaestro.length(); j++) {
                    listaHabilidades.add(jsonArrayHabilidadesMaestro.getString(j)); // Ajusta la clave
                }
                Maestro maestroLeido = new Maestro(nombreMaestro, es_jedi, listaHabilidades);


                //Creo a los amigos
                JSONArray jsonArrayAmigos = jsonPersonaje.getJSONArray("amigos");
                ArrayList<Amigo> listaAmigos = new ArrayList<>();
                for (int j = 0; j < jsonArrayAmigos.length(); j++) {
                    JSONObject jsonAmigo = jsonArrayAmigos.getJSONObject(j);
                    String nombreAmigo = jsonAmigo.getString("nombre");
                    boolean piloto = jsonAmigo.getBoolean("piloto");

                    Nave nave = null;
                    if (!jsonAmigo.isNull("nave")) {
                        JSONObject jsonObjectNave = jsonAmigo.getJSONObject("nave");
                        String nombreNave = jsonObjectNave.getString("nombre");
                        String modeloNave = jsonObjectNave.getString("modelo");
                        nave = new Nave(nombreNave, modeloNave);
                    }

                    Amigo amigo = new Amigo(nombreAmigo, piloto, nave);
                    listaAmigos.add(amigo);
                }

                //Creo a los eventos
                JSONArray jsonArrayEventos = jsonPersonaje.getJSONArray("eventos");
                ArrayList<Evento> listaEventos = new ArrayList<>();
                for (int j = 0; j < jsonArrayEventos.length(); j++) {
                    JSONObject jsonEvento = jsonArrayEventos.getJSONObject(j);
                    String nombreEvento = jsonEvento.getString("nombre");
                    int anio = jsonEvento.getInt("anio");
                    boolean ganada = jsonEvento.getBoolean("ganada");
                    Evento evento = new Evento(nombreEvento, anio, ganada);
                    listaEventos.add(evento);
                }

                Personajes personaje = new Personajes(nombre, edad, jedi, planeta_nacimiento, maestroLeido, listaAmigos, listaEventos);
                listaPersonajes.add(personaje);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    return listaPersonajes;
    }

}
