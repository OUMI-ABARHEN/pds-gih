package ma.uiass.eia.pds.backend.Metier;

import ma.uiass.eia.pds.backend.Dao.IdentifiantDaoImp;
import ma.uiass.eia.pds.backend.Dao.JobDaoImp;
import ma.uiass.eia.pds.backend.Entite.Identifiant;
import ma.uiass.eia.pds.backend.Entite.Sexe;

import java.util.List;

public class MetierIdentifiant {
    IdentifiantDaoImp daoI= new IdentifiantDaoImp();
    JobDaoImp daoJ = new JobDaoImp();
    public void add(String code, String nom, String prenom, String email, int tel, Sexe sexe, String password, int idJob){
        daoI.add(new Identifiant(code,nom,prenom,email,tel,sexe,password,daoJ.findById(idJob)));}
    public String getPassword(int id){
        return daoI.findById(id).getPassword();
    }

    public Identifiant finfByid(int id){ return daoI.findById(id);}
    public void deleteIdentifient(String codeIdentifiant){daoI.delete(daoI.findByCode(codeIdentifiant));}

    public void updatePass(int id,String pass){ daoI.update(daoI.findById(id),pass);}

    public List<Identifiant> getAll(){return daoI.getAll();}
    public Boolean isCorrect( int id  , String pass){

        if (this.getPassword(id).equals(pass)) {
            return true;
        }
        else
            return false;
    }
}
