package ma.uiass.eia.pds.backend.Metier;


import ma.uiass.eia.pds.backend.Dao.LitDaoImp;
import ma.uiass.eia.pds.backend.Dao.SejourDaoImp;
import ma.uiass.eia.pds.backend.Entite.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MetierSejour {
    private SejourDaoImp daoS = new SejourDaoImp();
    private LitDaoImp daoL = new LitDaoImp();
    public void addSejour(Date date_entre, Date date_sortie, int id) {
        Sejour s= new Sejour(date_entre, date_sortie,daoL.findById(id));
        daoS.add(s);
    }

    public void deleteSejour(int id) {
        daoS.delete(daoS.findById(id));
    }

    public List<Sejour> getSejours() {
        return daoS.getAll();
    }

}

