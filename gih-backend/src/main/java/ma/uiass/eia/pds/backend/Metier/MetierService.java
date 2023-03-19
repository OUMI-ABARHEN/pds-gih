package ma.uiass.eia.pds.backend.Metier;

import java.util.List;

import ma.uiass.eia.pds.backend.Dao.ServiceDaoImp;
import ma.uiass.eia.pds.backend.Entite.Service;

public class MetierService {


    private ServiceDaoImp daoS=new ServiceDaoImp();



    public List<Service> showServices() {
        return daoS.getAll();

    }

    public Service showServiceById(int id) {
        return daoS.findById(id);
    }

    public void addService(String code,String Sname) {
        Service s=new Service (code,Sname);
        daoS.add(s);
    }
    public void deleteService(String code,String Sname) {
        Service s=new Service (code,Sname);
        daoS.delete(s);

    }
    public Service findServiceByName(String name) {
        return daoS.findByName(name);
    }

}
