package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.DemandeDaoImp;
import ma.uiass.eia.pds.backend.Entite.Demande;
import ma.uiass.eia.pds.backend.Entite.EtatDemande;

import java.util.Date;
import java.util.List;

public class MetierDemande {
    private DemandeDaoImp daoD = new DemandeDaoImp();
    public void addDemande(String code, Date date, String description, EtatDemande etat){
        daoD.add(new Demande(code,date,description,etat));
    }
    public List<Demande> getAll(){return daoD.getAll();}
}
