package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.JobDaoImp;
import ma.uiass.eia.pds.backend.Entite.Job;

public class MetierJob {
    JobDaoImp daoJ= new JobDaoImp();
    public void add(String code, String nom){daoJ.add(new Job(code,nom));}


    public Job finfByid(int id){ return daoJ.findById(id);}
}
