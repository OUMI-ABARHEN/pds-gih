package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Service;

import javax.persistence.*;
import java.util.List;

public class ServiceDaoImp implements IServiceDao {


    private EntityManager em;
    private EntityTransaction tr;


    public ServiceDaoImp() {

        EntityManagerFactory factory=Persistence.createEntityManagerFactory("gih-backend");
        em=factory.createEntityManager();
        tr=em.getTransaction();


    }


    @Override
    public void add(Service t) {
        // TODO Auto-generated method stub
        try {
            tr.begin();
            em.persist(t);
            tr.commit();

        }
        catch(Exception e) {
            tr.rollback();
            System.out.println(e);

        }
    }
    @Override
    public void delete(Service t) {
        // TODO Auto-generated method stub
        try {
            tr.begin();
            Service entity = em.find(Service.class,t);
            if (entity != null) { // vérifier que l'objet existe
                em.remove(entity);
            }
            tr.commit();

        }
        catch(Exception e) {
            tr.rollback();
            System.out.println(e);
        }

    }


    @Override
    public List<Service> getAll() {
        // TODO Auto-generated method stub
        Query query= em.createQuery("from Service");
        return query.getResultList();
    }


    @Override
    public Service findById(int id) {
        // TODO Auto-generated method stub
        return em.find(Service.class, id);
    }


    @Override
    public Service findByName(String nom) {
        TypedQuery<Service> query = em.createQuery("FROM Service WHERE nomService = :nom", Service.class);
        query.setParameter("nom", nom);
        try {
            return query.getSingleResult();
        } catch (NonUniqueResultException e) {
            return null;
        }
    }


	/*public int nombresLits(Service s) {

	}*/



}
