package negocio.repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import negocio.entities.Articulo;

public class ArticuloR extends GenericR<Articulo> implements I_ArticuloRepository{
    private EntityManager em;

    public ArticuloR(EntityManager em) {
        super(em, Articulo.class);
        this.em = em;
    }

    @Override
    public List<Articulo> getLikeDescripcion(String descripcion) {
        Query query = em.createNamedQuery("Articulo.findLikeDescripcion");
        query.setParameter("descripcion", "%"+descripcion+"%");
        return query.getResultList();
    }

    @Override
    public List<Articulo> getByDescripcion(String descripcion) {
        Query query = em.createNamedQuery("Articulo.findByDescripcion");
        query.setParameter("descripcion", descripcion);
        return query.getResultList();
    }

    @Override
    public List<Articulo> getLikeStock(Integer stock) {
        Query query = em.createNamedQuery("Articulo.findLikeStock");
        query.setParameter("stock", "%"+stock+"%");
        return query.getResultList();
    }
    
}
