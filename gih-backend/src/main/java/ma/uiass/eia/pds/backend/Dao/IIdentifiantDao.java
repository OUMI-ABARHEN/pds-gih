package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Identifiant;

public interface IIdentifiantDao extends Dao<Identifiant> {
    void update(Identifiant i,String pass);
}
