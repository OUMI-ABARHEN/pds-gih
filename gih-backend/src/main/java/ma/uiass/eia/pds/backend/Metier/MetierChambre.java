package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.ChambreDaoImp;
import ma.uiass.eia.pds.backend.Dao.EspaceDaoImp;
import ma.uiass.eia.pds.backend.Dao.ServiceDaoImp;
import ma.uiass.eia.pds.backend.Entite.*;

import java.util.List;

public class MetierChambre extends MetierEspace{

    private ServiceDaoImp daoS = new ServiceDaoImp();
    private ChambreDaoImp daoC = new ChambreDaoImp();


    public void addChambre(int quantite, String nomS, TypeChambre type) {

        daoC.add(new Chambre(quantite,daoS.findByName(nomS),type));
    }

    public void delete(int id) {
        daoC.delete(daoC.findById(id));
    }

    public List<Chambre> getAllChambre() {
        return daoC.getAllChambre();
    }





}
