package negocio.repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import negocio.entities.Cliente;

public class ClienteR extends GenericR<Cliente> implements I_ClienteRepository{
    
    private EntityManager em;
    public ClienteR(EntityManager em) {
        super(em, Cliente.class);
        this.em = em;
    }
    
    @Override
    public Cliente getById(int codigo){
        Query query=em.createNamedQuery("Clientes.findByCodigo");
        query.setParameter("codigo", codigo);
        return (query.getResultList().isEmpty())?null:(Cliente)query.getSingleResult();
    }

    @Override
    public List<Cliente> getLikeNombre(String nombre) {
        Query query = em.createNamedQuery("Clientes.findLikeNombre");
        query.setParameter("nombre", "%"+nombre+"%");
        return query.getResultList();
    }

    @Override
    public List<Cliente> getByApellido(String apellido) {
        Query query = em.createNamedQuery("Clientes.findByApellido");
        query.setParameter("apellido", apellido);
        return query.getResultList();
    }

    @Override
    public List<Cliente> getLikeApellido(String apellido) {
        Query query = em.createNamedQuery("Clientes.findLikeApellido");
        query.setParameter("apellido", "%"+apellido+"%");
        return query.getResultList();
    }

    @Override
    public List<Cliente> getLikeApellidoNombre(String apellido, String nombre) {
        Query query = em.createNamedQuery("Clientes.findLikeApellidoNombre");
        query.setParameter("nombre", "%"+nombre+"%");
        query.setParameter("apellido", "%"+apellido+"%");
        return query.getResultList();
    }

    @Override
    public Cliente getByCuit(String cuit) {
        Query query = em.createNamedQuery("Clientes.findByCuit");
        query.setParameter("cuit", cuit);
        return (query.getResultList().isEmpty())?null:(Cliente)query.getSingleResult();
    }
    
}
