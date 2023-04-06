package ma.uiass.eia.pds.backend.Dao;


import ma.uiass.eia.pds.backend.Entite.EtatLit;
import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.backend.HibernateUtility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class LitDaoImp implements ILitDao{
    private EntityManager em;


    public LitDaoImp() {
        em = HibernateUtility.getEntityManger();
    }
    @Override
    public void add(Lit lit) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.persist(lit);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Lit lit) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.remove(lit);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Lit> getAll() {
        TypedQuery<Lit> query = em.createQuery("SELECT l FROM Lit l ", Lit.class);
        return query.getResultList();
    }

    @Override
    public Lit findById(int id) {
        EntityTransaction et = null;
        Lit l = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            l= em.find(Lit.class, id);

        }
        catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return l;
    }
    public void update(Lit l, EtatLit etat) {
        EntityTransaction et = null;
        l.setEtat(etat);
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.merge(l);
            et.commit();
        }catch(Exception e){
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    public Lit findbyCode(String code) {
        TypedQuery<Lit> query = em.createQuery("FROM Lit l WHERE l.code = :code", Lit.class);
        query.setParameter("code", code);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
}

