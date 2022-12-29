package es.cifpcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static es.cifpcm.Funciones.*;

public class VidicGutierrezDaliborkaFarmacias {
    public static List<Farmacia> sucursales = new ArrayList<Farmacia>();
    public static Persistencia pst = new impPersistenciaVidic();
    public static VidicInterfazUtil viu = new ImVidicInterfazUtil();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        pst.openJSON();
    }
}