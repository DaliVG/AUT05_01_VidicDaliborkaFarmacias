package es.cifpcm;

import java.util.List;

public interface Persistencia {
    boolean openJSON();

    List<Farmacia> buscararea2(List<Farmacia> sucursales, Farmacia sucursal);

    List<Farmacia> list();


}
