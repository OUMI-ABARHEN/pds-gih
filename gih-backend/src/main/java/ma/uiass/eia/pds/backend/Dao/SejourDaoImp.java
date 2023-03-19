package ma.uiass.eia.pds.backend.Dao;


import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.backend.Entite.Sejour;
import ma.uiass.eia.pds.backend.HibernateUtility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class SejourDaoImp implements ISejourDao{
    private EntityManager em;
    public SejourDaoImp() {
        em = HibernateUtility.getEntityManger();
    }
    @Override
    public void add(Sejour sejour) {
        EntityTransaction et =em.getTransaction();
        try {
            //et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.persist(sejour);
            et.commit();
        }
        catch (Exception e) {
            if(et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Sejour o) {
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
    public List<Sejour> getAll() {
        TypedQuery<Sejour> query = em.createQuery("SELECT s FROM Sejour s ", Sejour.class);
        return query.getResultList();
    }

    @Override
    public Sejour findById(int id) {
        EntityTransaction et = null;
        Sejour l = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            l= em.find(Sejour.class, id);

        }
        catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return l;
    }
}

