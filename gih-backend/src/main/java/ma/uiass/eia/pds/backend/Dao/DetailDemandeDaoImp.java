package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Demande;
import ma.uiass.eia.pds.backend.Entite.DetailDemande;
import ma.uiass.eia.pds.backend.HibernateUtility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class DetailDemandeDaoImp implements IDetailDemandeDao{
    private EntityManager em;
    public DetailDemandeDaoImp() {
        em = HibernateUtility.getEntityManger();
    }
    @Override
    public void add(DetailDemande detailDemande) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.persist(detailDemande);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DetailDemande o) {
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
    public List<DetailDemande> getAll() {
        TypedQuery<DetailDemande> query = em.createQuery("SELECT l FROM DetailDemande l ", DetailDemande.class);
        return query.getResultList();
    }

    @Override
    public DetailDemande findById(int id) {
        EntityTransaction et = null;
        DetailDemande d = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            d= em.find(DetailDemande.class, id);

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
    public void update(DetailDemande d, Demande dem) {
        EntityTransaction et = null;
        d.setDemande(dem);
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

    @Override
    public DetailDemande findByCode(String code) {
        TypedQuery<DetailDemande> query = em.createQuery("FROM DetailDemande WHERE codeDetail = :nom", DetailDemande.class);
        query.setParameter("nom", code);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }
}
