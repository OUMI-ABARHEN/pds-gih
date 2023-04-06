package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Demande;
import ma.uiass.eia.pds.backend.Entite.EtatDemande;
import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.backend.HibernateUtility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NonUniqueResultException;
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

    @Override
    public Demande findByCode(String codeD) {
        TypedQuery<Demande> query = em.createQuery("FROM Demande WHERE codeDemande = :nom", Demande.class);
        query.setParameter("nom", codeD);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }

    @Override
    public List<Demande> findByServie(int id) {
        TypedQuery<Demande> query = em.createQuery("FROM Demande WHERE service_id = :nom", Demande.class);
        query.setParameter("nom", id);
        try {
            return query.getResultList();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }

    @Override
    public void updateEtat(Demande d, EtatDemande etat) {
        EntityTransaction et = null;
        d.setEtat(etat);
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.merge(d);
            et.commit();
        }catch(Exception e){
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

}
