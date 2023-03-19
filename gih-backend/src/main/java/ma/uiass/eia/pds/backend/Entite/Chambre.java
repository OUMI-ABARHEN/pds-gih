package ma.uiass.eia.pds.backend.Entite;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="Chambre")
public class Chambre extends Espace{
    public Chambre(int quantite, Service service,TypeChambre type) {
        super(quantite,service);
        this.type=type;
    }

    @Column(name="TypeChambre")
    private TypeChambre type;

    public Chambre() {
    }


    public TypeChambre getType() {
        return type;
    }

    public void setType(TypeChambre type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Chambre" +super.toString()+
                "type=" + type +
                '}';
    }
}
