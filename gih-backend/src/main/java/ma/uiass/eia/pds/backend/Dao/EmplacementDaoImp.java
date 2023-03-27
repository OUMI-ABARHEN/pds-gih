package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Emplacement;
import ma.uiass.eia.pds.backend.Entite.Job;
import ma.uiass.eia.pds.backend.HibernateUtility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmplacementDaoImp implements IEmplacementDap{
    private EntityManager em;
    public EmplacementDaoImp() {em = HibernateUtility.getEntityManger();}
    @Override
    public void add(Emplacement emplacement) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.persist(emplacement);
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
    public void delete(Emplacement o) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
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
    public List<Emplacement> getAll() {
        TypedQuery<Emplacement> query = em.createQuery("SELECT e FROM Emplacement e", Emplacement.class);
        return query.getResultList();
    }

    @Override
    public Emplacement findById(int id) {
        EntityTransaction et = null;
        Emplacement emplacement = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            emplacement = em.find(Emplacement.class, id);
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return emplacement;
    }

    @Override
    public Emplacement findByCode(String code) {
        TypedQuery<Emplacement> query = em.createQuery("Select e FROM Emplacement e WHERE e.codeEmplacement = :code", Emplacement.class);
        query.setParameter("nom", code);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
}
