package es.cifpcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Funciones {
    public static List<Farmacia> BuscarCercaFarmacia (List < Farmacia > sucursales, Farmacia sucursalCerca) {

        float coordUxCerca = sucursalCerca.UTM_X;
        float coordUyCerca = sucursalCerca.UTM_Y;
        float coordMaxUx = coordUxCerca + 1600f;
        float coordMinUx = coordUxCerca - 1600f;
        float coordMaxUy = coordUyCerca + 16000f;
        float coordMinUy = coordUyCerca - 16000f;

        List<Farmacia> searchFinal = null;

        for (Farmacia sucursal : sucursales) {

            if (sucursal.UTM_X<=coordMaxUx && sucursal.UTM_X>=coordMinUx) {
                if (sucursal.UTM_Y<=coordMaxUy && sucursal.UTM_Y>=coordMinUy) {

                    searchFinal.add(sucursal);

                }
            }
        }
        return searchFinal;
    }

    public static void MostradoFarmacias (List < Farmacia > sucursales) {

        if (sucursales.size()==0){
            System.out.println("La lista está vacia.");
        }
        else{
            for (Farmacia sucursal : sucursales
            ) {
                System.out.println("Nombre: " + sucursal.NOMBRE + " Tlfno: " + sucursal.TELEFONO + " Coordenadas: Ux " + sucursal.UTM_X + " Uy " + sucursal.UTM_Y + " web: " + sucursal.WEB);
            }
        }

    }
}

