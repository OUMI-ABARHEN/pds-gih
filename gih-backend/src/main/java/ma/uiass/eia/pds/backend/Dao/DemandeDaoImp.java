package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Demande;
import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.backend.HibernateUtility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DemandeDaoImp implements IDemandeDao{
    private EntityManager em;
    public DemandeDaoImp() {
        em = HibernateUtility.getEntityManger();
    }
    @Override
    public void add(Demande demande) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.persist(demande);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Demande o) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.remove(o);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public List<Demande> getAll() {
        TypedQuery<Demande> query = em.createQuery("SELECT l FROM Demande l ", Demande.class);
        return query.getResultList();
    }

    @Override
    public Demande findById(int id) {
        EntityTransaction et = null;
        Demande d = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            d= em.find(Demande.class, id);

        }
        catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return d;
    }
}
