package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Salle;

import java.util.List;

public interface ISalleDao extends IEspaceDao<Salle>{
    List<Salle> getAllSalle();

}
