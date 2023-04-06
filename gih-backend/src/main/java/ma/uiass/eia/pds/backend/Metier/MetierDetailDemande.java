package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.DemandeDaoImp;
import ma.uiass.eia.pds.backend.Dao.DetailDemandeDaoImp;
import ma.uiass.eia.pds.backend.Dao.LitDaoImp;
import ma.uiass.eia.pds.backend.Dao.ServiceDaoImp;
import ma.uiass.eia.pds.backend.Entite.*;

import java.util.*;

public class MetierDetailDemande {
    private DetailDemandeDaoImp daoDD= new DetailDemandeDaoImp();
    private ServiceDaoImp daoS = new ServiceDaoImp();
    private LitDaoImp daoL = new LitDaoImp();
    private DemandeDaoImp daoD = new DemandeDaoImp();

    public void add( String code, TypeLit type,  int quantite){
        DetailDemande d = new DetailDemande(code,type,quantite);
        daoDD.add(d);
    }
    public List<DetailDemande> getAll(){return daoDD.getAll();}

    public void update(String codeDD,String codeD){ daoDD.update(daoDD.findByCode(codeDD),daoD.findByCode(codeD));}
    public void delete(String code){daoDD.delete(daoDD.findByCode(code));}



}
