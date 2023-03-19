package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Service;

public interface IServiceDao extends Dao<Service> {


    Service findByName(String nom);
}
