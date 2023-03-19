package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Chambre;
import ma.uiass.eia.pds.backend.Entite.Espace;
import ma.uiass.eia.pds.backend.HibernateUtility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ChambreDaoImp implements IChambreDao {
    private EntityManager em;
    public ChambreDaoImp() {em = HibernateUtility.getEntityManger();}


    public void add(Chambre s) {
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




    public void delete(Chambre o) {
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
    public List<Chambre> getAll() {
        return null;
    }


    public Chambre findById(int id) {
        EntityTransaction et = null;
        Chambre s = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            s= em.find(Chambre.class, id);
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
    public List<Chambre> getAllChambre() {
        TypedQuery<Chambre> query = em.createQuery("SELECT c FROM Chambre c", Chambre.class);
        return query.getResultList();
    }
    public List<Chambre> getService(String nom) {
        TypedQuery<Chambre> query = em.createQuery("SELECT es FROM Chambre es where nomService="+nom, Chambre.class);
        return query.getResultList();
    }
}
