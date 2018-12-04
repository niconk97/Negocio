package negocio.repositories;

import java.util.List;
import negocio.entities.Articulo;

public interface I_ArticuloRepository {
    List<Articulo>getLikeDescripcion(String descripcion);
    List<Articulo>getByDescripcion(String descripcion);
    List<Articulo>getLikeStock(Integer stock);
}
