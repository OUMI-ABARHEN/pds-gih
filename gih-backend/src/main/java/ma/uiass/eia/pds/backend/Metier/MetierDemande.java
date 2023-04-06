package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.DemandeDaoImp;
import ma.uiass.eia.pds.backend.Dao.DetailDemandeDaoImp;
import ma.uiass.eia.pds.backend.Dao.LitDaoImp;
import ma.uiass.eia.pds.backend.Dao.ServiceDaoImp;
import ma.uiass.eia.pds.backend.Entite.Demande;
import ma.uiass.eia.pds.backend.Entite.EtatDemande;

import java.util.Date;
import java.util.List;

public class MetierDemande {
    private DemandeDaoImp daoD = new DemandeDaoImp();
    private ServiceDaoImp daoS = new ServiceDaoImp();
    private LitDaoImp daoL = new LitDaoImp();
    private DetailDemandeDaoImp daoDD = new DetailDemandeDaoImp();
    public void addDemande( String code,String nomS, EtatDemande etat){
        Date currentDate = new Date();
        Demande d=new Demande(code,currentDate,daoS.findByName(nomS),etat);
        daoD.add(d);

    }
    public List<Demande> getAll(){return daoD.getAll();}
    public Demande findByCode(String code){return daoD.findByCode(code);}
    public List<Demande> getByService(String nomS){
        return daoD.findByServie(daoS.findByName(nomS).getService_id());
    }
    public void updateEtat(String code,EtatDemande etat){daoD.updateEtat(daoD.findByCode(code),etat);}
}