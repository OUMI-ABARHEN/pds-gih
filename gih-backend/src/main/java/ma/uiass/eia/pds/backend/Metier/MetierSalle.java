package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.EspaceDaoImp;
import ma.uiass.eia.pds.backend.Dao.SalleDaoImp;
import ma.uiass.eia.pds.backend.Dao.ServiceDaoImp;
import ma.uiass.eia.pds.backend.Entite.Salle;
import ma.uiass.eia.pds.backend.Entite.Service;
import ma.uiass.eia.pds.backend.Entite.TypeSalle;

import java.util.List;

public class MetierSalle extends MetierEspace{

    private SalleDaoImp daoS = new SalleDaoImp();
    private ServiceDaoImp daoSer = new ServiceDaoImp();

    public void addSalle(String code,int quantite, String nomS, TypeSalle type) {
        Salle s = new Salle(code,quantite,daoSer.findByName(nomS),type);
        daoS.add(s);
    }
    public void delete(int id) {
        daoS.delete(daoS.findById(id));
    }


    public List<Salle> getAllSalle() {
        return daoS.getAllSalle();
    }


}
