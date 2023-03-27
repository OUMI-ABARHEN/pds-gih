package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.DetailDemandeDaoImp;
import ma.uiass.eia.pds.backend.Dao.LitDaoImp;
import ma.uiass.eia.pds.backend.Dao.ServiceDaoImp;
import ma.uiass.eia.pds.backend.Entite.*;

import java.util.*;

public class MetierDetailDemande {
    private DetailDemandeDaoImp daoDD= new DetailDemandeDaoImp();
    private ServiceDaoImp daoS = new ServiceDaoImp();

    public void add(String code, String codeL, TypeLit type, String nameS, int quantite){
        Lit l = new Lit(codeL,type,null,EtatPhysique.BonEtat,null,null);
        daoDD.add(new DetailDemande(code,l,daoS.findByName(nameS),quantite));
    }
    public List<DetailDemande> getAll(){return daoDD.getAll();}


}
