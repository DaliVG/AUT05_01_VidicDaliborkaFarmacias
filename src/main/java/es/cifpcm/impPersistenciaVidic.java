package es.cifpcm;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class impPersistenciaVidic implements Persistencia{

    public static List<Farmacia> sucursales = new ArrayList<Farmacia>();
    Gson gson = new Gson();
    public String fileName = ("VidicDaliborka_farmacias.json");
    @Override
    public boolean openJSON(){

        File fileDone = new File(System.getProperty("java.io.tmpdir")+fileName);
            try {
                FileReader fileReader = new FileReader(fileDone);
                Type type = new TypeToken<List<Farmacia>>(){}.getType();
                sucursales = gson.fromJson(fileReader, type);
                fileReader.close();
            } catch (FileNotFoundException e){
                System.err.println("No se ha encontrado un fichero.");
                return false;
            } catch (IOException e) {
                System.err.println("Error en cerrado del fichero");
                return false;
            }

        return true;
    }

    @Override
    public List<Farmacia> list() {

        return sucursales;

    }
}
