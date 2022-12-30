package es.cifpcm;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class impPersistenciaVidic implements Persistencia{

    public static List<Farmacia> sucursales = new ArrayList<Farmacia>();
    Gson gson = new Gson();
    public String fileName = ("VidicDaliborka_farmacias.json");
    @Override
    public boolean openJSON(){

        URL resource = getClass().getClassLoader().getResource(fileName);
        File fileDone = new File(resource.getFile());
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
    public  List<Farmacia> buscararea2(List<Farmacia> sucursales, Farmacia sucursalCerca) {

        float coordUxCerca = sucursalCerca.getUTM_X();
        float coordUyCerca = sucursalCerca.getUTM_Y();
        float coordMaxUx = coordUxCerca + 1600f;
        float coordMinUx = coordUxCerca - 1600f;
        float coordMaxUy = coordUyCerca + 16000f;
        float coordMinUy = coordUyCerca - 16000f;

        List<Farmacia> searchFinal = new ArrayList<>();

        for (Farmacia sucursal : sucursales) {

            if (sucursal.getUTM_X()<=coordMaxUx && sucursal.getUTM_X()>=coordMinUx) {
                if (sucursal.getUTM_Y()<=coordMaxUy && sucursal.getUTM_Y()>=coordMinUy) {

                    searchFinal.add(sucursal);

                }
            }
        }
        return searchFinal;
    }

    @Override
    public List<Farmacia> list() {

        return sucursales;

    }
}
