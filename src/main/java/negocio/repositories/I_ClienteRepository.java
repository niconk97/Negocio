package negocio.repositories;

import java.util.List;
import negocio.entities.Cliente;

public interface I_ClienteRepository {
    List<Cliente>getLikeNombre(String nombre);
    List<Cliente>getByApellido(String apellido);
    List<Cliente>getLikeApellido(String apellido);
    List<Cliente>getLikeApellidoNombre(String apellido,String nombre);
    Cliente getByCuit(String cuit);
}
