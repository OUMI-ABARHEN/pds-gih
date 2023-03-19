package ma.uiass.eia.pds.backend.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ma.uiass.eia.pds.backend.Entite.Identifiant;
import ma.uiass.eia.pds.backend.HibernateUtility.HibernateUtility;
import javax.persistence.TypedQuery;
import java.util.List;

public class IdentifiantDaoImp implements IIdentifiantDao{
    private EntityManager em;
    public IdentifiantDaoImp() {
        em = HibernateUtility.getEntityManger();
    }
    @Override
    public void add(Identifiant identifiant) {
        EntityTransaction et =em.getTransaction();
        try {
            //et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.persist(identifiant);
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
    public void delete(Identifiant identifiant) {
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.remove(em.contains(identifiant) ? identifiant : em.merge(identifiant));
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public List<Identifiant> getAll() {
        TypedQuery<Identifiant> query = em.createQuery("SELECT i FROM Identifiant i", Identifiant.class);
        return query.getResultList();
    }

    @Override
    public Identifiant findById(int id) {
        EntityTransaction et = null;
        Identifiant i = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            i= em.find(Identifiant.class, id);

        }
        catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public void update(Identifiant i, String pass) {
        EntityTransaction et = null;
        i.setPassword(pass);
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.merge(i);
            et.commit();
        }catch(Exception e){
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
    }
}
