package ma.uiass.eia.pds.backend.Metier;

import java.util.List;

import ma.uiass.eia.pds.backend.Dao.EmplacementDaoImp;
import ma.uiass.eia.pds.backend.Dao.ServiceDaoImp;
import ma.uiass.eia.pds.backend.Entite.Emplacement;
import ma.uiass.eia.pds.backend.Entite.Service;

public class MetierService {


    private ServiceDaoImp daoS=new ServiceDaoImp();
    private EmplacementDaoImp daoE = new EmplacementDaoImp();



    public List<Service> showServices() {
        return daoS.getAll();

    }

    public Service showServiceById(int id) {
        return daoS.findById(id);
    }

    public void addService(String code,String Sname,String codeE) {
        Service s=new Service (code,Sname,daoE.findByCode(codeE));
        daoS.add(s);
    }
    public void deleteService(String Sname) {
        Service s= daoS.findByName(Sname);
        daoS.delete(s);

    }
    public Service findServiceByName(String name) {
        return daoS.findByName(name);
    }

}
