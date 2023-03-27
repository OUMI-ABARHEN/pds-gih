package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Espace;
import ma.uiass.eia.pds.backend.Entite.Salle;
import ma.uiass.eia.pds.backend.HibernateUtility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class SalleDaoImp implements ISalleDao {
    private EntityManager em;
    public SalleDaoImp() {em = HibernateUtility.getEntityManger();}

    @Override
    public void add(Salle s) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if(!et.isActive()) {
                et.begin();
            }
            em.persist(s);
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
    public void delete(Salle o) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if(!et.isActive()) {
                et.begin();
            }
            em.remove(em.contains(o) ? o : em.merge(o));
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Salle> getAll() {
        return null;
    }


    @Override
    public Salle findById(int id) {
        EntityTransaction et = null;
        Salle s = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            s= em.find(Salle.class, id);
        }
        catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return s;

    }
    @Override
    public List<Salle> getAllSalle() {
        TypedQuery<Salle> query = em.createQuery("SELECT es FROM Salle es", Salle.class);
        return query.getResultList();
    }

    @Override
    public List<Salle> getService(String nom) {
        TypedQuery<Salle> query = em.createQuery("SELECT es FROM Salle es where nomService="+nom, Salle.class);
        return query.getResultList();
    }

    @Override
    public Espace findByCode(String code) {
        return null;
    }


}


