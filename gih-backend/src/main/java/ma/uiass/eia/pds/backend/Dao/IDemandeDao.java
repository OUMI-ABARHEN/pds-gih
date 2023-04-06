package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Demande;
import ma.uiass.eia.pds.backend.Entite.EtatDemande;

import java.util.List;

public interface IDemandeDao extends Dao<Demande> {
    Demande findByCode(String codeD);
    List<Demande> findByServie(int id);


    void updateEtat(Demande d, EtatDemande etat);


}
