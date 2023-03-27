package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.EspaceDaoImp;
import ma.uiass.eia.pds.backend.Dao.ServiceDaoImp;
import ma.uiass.eia.pds.backend.Entite.Espace;

import java.util.List;

public class MetierEspace {
    private EspaceDaoImp daoE = new EspaceDaoImp();
    private ServiceDaoImp daoS = new ServiceDaoImp();
    public MetierEspace(){};



    public void delete(int id) {
        daoE.delete(daoE.findById(id));
    }

    public List<Espace> getAll() {
        return daoE.getAll();
    }

    public Espace finfById(int id){ return daoE.findById(id);}


}



