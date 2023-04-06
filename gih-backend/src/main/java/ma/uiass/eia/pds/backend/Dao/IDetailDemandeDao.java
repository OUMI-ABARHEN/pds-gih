package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Demande;
import ma.uiass.eia.pds.backend.Entite.DetailDemande;

public interface IDetailDemandeDao extends Dao<DetailDemande> {
    void update(DetailDemande d, Demande dem);
    DetailDemande findByCode(String code);
}
