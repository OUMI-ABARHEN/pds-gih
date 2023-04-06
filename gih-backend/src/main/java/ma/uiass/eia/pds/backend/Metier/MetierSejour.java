package ma.uiass.eia.pds.backend.Metier;


import ma.uiass.eia.pds.backend.Dao.LitDaoImp;
import ma.uiass.eia.pds.backend.Dao.SejourDaoImp;
import ma.uiass.eia.pds.backend.Entite.Lit;
import ma.uiass.eia.pds.backend.Entite.Sejour;
import ma.uiass.eia.pds.backend.Entite.SejourFormatted;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MetierSejour {
    private SejourDaoImp daoS = new SejourDaoImp();
    private LitDaoImp daoL = new LitDaoImp();
    public void addSejour(Date date_entre, Date date_sortie, String code) {
        Lit l=daoL.findbyCode(code);
        if (l.getSejour()==null){
            Sejour s= new Sejour(date_entre, date_sortie,daoL.findbyCode(code));
            daoS.add(s);
        }else{
            System.out.println("Lit est deja occupe");
        }

    }

    public void deleteSejour(int id) {
        daoS.delete(daoS.findById(id));
    }

    public List<Sejour> getSejours() {
        return daoS.getAll();
    }
    public void checkExpiredSejours() {
        Calendar twoPm = Calendar.getInstance();
        twoPm.set(Calendar.HOUR_OF_DAY, 14);
        twoPm.set(Calendar.MINUTE, 0);
        twoPm.set(Calendar.SECOND, 0);
        twoPm.set(Calendar.MILLISECOND, 0);

        Date now = new Date();
        if (now.after(twoPm.getTime())) {
            // Only execute this code after 2:00 pm
            List<SejourFormatted> sejoursFormatted = new ArrayList<>();
            List<Sejour> sejours = this.getSejours();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (Sejour sejour : sejours) {
                String dateEntree = sdf.format(sejour.getDate_entre());
                String dateSortie = sdf.format(sejour.getDate_sortie());
                SejourFormatted sejourFormatted = new SejourFormatted(sejour.getSejour_id(), dateEntree, dateSortie, sejour.getLit());
                sejoursFormatted.add(sejourFormatted);
            }
            for (SejourFormatted sejour : sejoursFormatted) {
                try {
                    Date date_sortie = sdf.parse(sejour.getDate_sortie());
                    if (date_sortie.before(now)) {
                        Lit lit = sejour.getLit();
                        lit.setSejour(null);
                    }
                } catch (ParseException e) {
                    // Handle the exception if the date format is invalid
                    e.printStackTrace();
                }
            }
        }
    }


}

