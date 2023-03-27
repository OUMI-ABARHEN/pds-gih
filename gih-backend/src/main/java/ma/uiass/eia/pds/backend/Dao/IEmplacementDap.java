package ma.uiass.eia.pds.backend.Dao;

import ma.uiass.eia.pds.backend.Entite.Emplacement;

public interface IEmplacementDap extends Dao<Emplacement> {
    Emplacement findByCode(String code);

}
