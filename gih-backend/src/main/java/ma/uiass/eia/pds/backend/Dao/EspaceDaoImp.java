package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Espace;
import ma.uiass.eia.pds.backend.Entite.Service;
import ma.uiass.eia.pds.backend.HibernateUtility.HibernateUtility;

import javax.persistence.*;
import java.util.List;

public class EspaceDaoImp implements IEspaceDao<Espace> {

    private EntityManager em;
    public EspaceDaoImp() {em = HibernateUtility.getEntityManger();}

    public void add(Espace espace) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if(!et.isActive()) {
                et.begin();
            }
            em.persist(espace);
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
    public void delete(Espace o) {
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
    public List<Espace> getAll() {
        TypedQuery<Espace> query = em.createQuery("SELECT es FROM Chambre es", Espace.class);
        return query.getResultList();
    }

    @Override
    public Espace findById(int id) {
        EntityTransaction et = null;
        Espace es = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            es= em.find(Espace.class, id);
        }
        catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return es;

    }
    public Espace findByName(String nom) {
        EntityTransaction et = null;
        Espace es = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            es= em.find(Espace.class, nom);
        }
        catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return es;

    }


    public List<Espace> getService(String nom) {
        TypedQuery<Espace> query = em.createQuery("SELECT es FROM Espace es where service="+nom, Espace.class);
        return query.getResultList();
    }

    @Override
    public Espace findByCode(String code) {
        TypedQuery<Espace> query = em.createQuery("FROM Espace WHERE code = :code", Espace.class);
        query.setParameter("code", code);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
