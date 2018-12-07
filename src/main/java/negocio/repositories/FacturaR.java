package negocio.repositories;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import negocio.entities.Factura;

public class FacturaR extends GenericR<Factura> implements I_FacturaRepository{
    
    private EntityManager em;
    
    public FacturaR(EntityManager em) {
        super(em, Factura.class);
        this.em = em;
    }
    
    @Override
    public Factura getById(int numero){
        Query query = em.createNamedQuery("Factura.findByNumero");
        query.setParameter("numero", numero);
        return (query.getResultList().isEmpty()) ? null : (Factura)query.getSingleResult();
    }

    @Override
    public List<Factura> getByLetra(Character letra) {
        Query query = em.createNamedQuery("Factura.findByLetra");
        query.setParameter("letra", letra);
        return query.getResultList();
    }

    @Override
    public List<Factura> getByMonto(Double monto) {
        Query query = em.createNamedQuery("Factura.findByNumero");
        query.setParameter("monto", monto);
        return query.getResultList();
    }

    @Override
    public List<Factura> getByFecha(Date fecha) {
        Query query = em.createNamedQuery("Factura.findByFecha");
        query.setParameter("fecha", fecha);
        return query.getResultList();
    }
    
}
