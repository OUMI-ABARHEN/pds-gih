package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.EspaceDaoImp;
import ma.uiass.eia.pds.backend.Dao.LitDaoImp;
import ma.uiass.eia.pds.backend.Entite.EtatLit;
import ma.uiass.eia.pds.backend.Entite.EtatPhysique;
import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.backend.Entite.TypeLit;

import java.util.List;

public class MetierLit {
    private LitDaoImp daoL = new LitDaoImp();
    private EspaceDaoImp daoE = new EspaceDaoImp();
    public void addLit(String code, TypeLit typeLit, EtatLit etat, EtatPhysique etatPhysique,String codeS) {
        Lit lit = new Lit(code,typeLit, etat,etatPhysique, daoE.findByCode(codeS), null);
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
}