package es.cifpcm;

import java.util.List;

public interface Persistencia {
    boolean openJSON();

    List<Farmacia> list();
}
