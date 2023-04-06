package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.EspaceDaoImp;
import ma.uiass.eia.pds.backend.Dao.LitDaoImp;
import ma.uiass.eia.pds.backend.Dao.ServiceDaoImp;
import ma.uiass.eia.pds.backend.Entite.*;

import java.util.List;

public class MetierLit {
    private LitDaoImp daoL = new LitDaoImp();
    private EspaceDaoImp daoE = new EspaceDaoImp();
    private ServiceDaoImp daoS = new ServiceDaoImp();
    public void addLit( TypeLit typeLit, EtatLit etat, EtatPhysique etatPhysique,String nomS,String codeE) {
        Lit lit = new Lit(GenerateCode.generateCodeLit(),typeLit, etat,etatPhysique, daoE.findByCode(codeE), null,daoS.findByName(nomS));
        daoL.add(lit);
    }
    public void addLitStock(TypeLit  typeLit,String nomS){
        Lit lit = new Lit(GenerateCode.generateCodeLit(),typeLit, EtatLit.DISPONIBLE,EtatPhysique.BonEtat, null, null,daoS.findByName(nomS));
        daoL.add(lit);
    }

    public void deleteLit(int id) {
        daoL.delete(daoL.findById(id));
    }

    public List<Lit> getLits() {
        return daoL.getAll();
    }

    public Lit searchById(int id){ return daoL.findById(id);}
    public void updateEtat(int id, EtatLit etat){
        Lit l= daoL.findById(id);
        daoL.update(l,etat);

    }
    public Lit findbycode(String code){
        return daoL.findbyCode(code);
    }
}