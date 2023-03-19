package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Espace;

import java.util.List;

public interface IEspaceDao<T> extends Dao<T> {
    List<T> getService(String nom);
}
