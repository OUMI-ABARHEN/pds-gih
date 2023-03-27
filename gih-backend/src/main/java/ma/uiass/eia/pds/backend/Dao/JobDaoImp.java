package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Job;
import ma.uiass.eia.pds.backend.HibernateUtility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class JobDaoImp implements IJobDao{
    private EntityManager em;
    private EntityTransaction et;
    public JobDaoImp() {em = HibernateUtility.getEntityManger();
        EntityTransaction et =em.getTransaction();}
    @Override
    public void add(Job job) {
        EntityTransaction et =em.getTransaction();
        try {
            // et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            em.persist(job);
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
    public void delete(Job o) {
        EntityTransaction et =em.getTransaction();
        try {
            //et = em.getTransaction();
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
    public List<Job> getAll() {
        TypedQuery<Job> query = em.createQuery("SELECT j FROM Job j", Job.class);
        return query.getResultList();

    }


    @Override
    public Job findById(int id) {

        //EntityTransaction et = null;
        Job b = null;
        try {
            et = em.getTransaction();
            if (!et.isActive()) {
                et.begin();
            }
            b= em.find(Job.class, id);
        }
        catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return b;
    }
}
