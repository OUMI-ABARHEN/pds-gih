package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Chambre;
import ma.uiass.eia.pds.backend.Entite.Salle;

import java.util.List;

public interface IChambreDao extends IEspaceDao<Chambre> {
    List<Chambre> getAllChambre();
}
