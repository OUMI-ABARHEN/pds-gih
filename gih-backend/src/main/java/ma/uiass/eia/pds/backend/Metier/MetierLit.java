package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.EspaceDaoImp;
import ma.uiass.eia.pds.backend.Dao.LitDaoImp;
import ma.uiass.eia.pds.backend.Entite.*;

import java.util.List;

public class MetierLit {
    private LitDaoImp daoL = new LitDaoImp();
    private EspaceDaoImp daoE = new EspaceDaoImp();
    public void addLit(TypeLit typeLit, String marque, int espace, EtatLit etat) {
        Lit lit = new Lit(typeLit, marque, daoE.findById(espace), etat);
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