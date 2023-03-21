package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.EmplacementDaoImp;
import ma.uiass.eia.pds.backend.Entite.Emplacement;
import java.util.*;

public class MetierEmplacement {
    private EmplacementDaoImp daoE = new EmplacementDaoImp();
    public void create(String code, String nomBatiment, String etage){
        daoE.add(new Emplacement(code,nomBatiment,etage));
    }
    public  void delete(int id){daoE.delete(daoE.findById(id));}
    public List<Emplacement> getAll(){return daoE.getAll();}



}
