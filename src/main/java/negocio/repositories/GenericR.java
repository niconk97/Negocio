package negocio.repositories;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
public class GenericR<E> implements I_GenericRepository<E>{
    private EntityManager em;
    private Class clazz;
    public GenericR(EntityManager em, Class clazz) { 
        this.em = em; 
        this.clazz = clazz;
    }
    @Override public void save(E e) {
        EntityTransaction t=em.getTransaction();
        try {
            t.begin();
            em.persist(e);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }
    }
    @Override public void update(E e) {
        EntityTransaction t=em.getTransaction();
        try {
            t.begin();
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }
    }
    @Override public void remove(E e) {
        EntityTransaction t=em.getTransaction();
        try {
            t.begin();
            em.remove(e);
            t.commit();
        } catch (Exception ex) {
            t.rollback();
        }    
    }
    @Override public List<E> getAll() {
        return em.createNamedQuery(clazz.getSimpleName()+".findAll").getResultList();
    }
    @Override public E getById(int id) {
        Query query=em.createNamedQuery(clazz.getSimpleName()+".findById");
        query.setParameter("id", id);
        return (query.getResultList().isEmpty())?null:(E)query.getSingleResult();
    }
}