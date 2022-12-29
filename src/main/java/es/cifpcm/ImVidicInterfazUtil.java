package es.cifpcm;

import java.util.List;

import static es.cifpcm.Funciones.*;

public class ImVidicInterfazUtil implements VidicInterfazUtil{

    @Override
    public  List<Farmacia> buscararea2(List<Farmacia> sucursales, Farmacia sucursal) {

        List<Farmacia> searchfinal = null;

        try {
            searchfinal = BuscarCercaFarmacia(sucursales, sucursal);

        } catch (Exception e){

            System.out.println("Error en la búsqueda");

        }

        return searchfinal;
    }

}
