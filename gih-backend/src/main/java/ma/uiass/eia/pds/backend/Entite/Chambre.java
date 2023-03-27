package ma.uiass.eia.pds.backend.Entite;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Chambre")
public class Chambre extends Espace implements Serializable {

    @Column(name="TypeChambre")
    @Enumerated(EnumType.STRING)
    private TypeChambre type;


    public TypeChambre getType() {
        return type;
    }

    public void setType(TypeChambre type) {
        this.type = type;
    }

    public Chambre(String code, int quantite, Service service, TypeChambre type) {
        super(code,quantite,service);
        this.type=type;
    }
    public Chambre() {

    }

    @Override
    public String toString() {
        return "Chambre{" +super.toString()+
                "type=" + type +
                '}';
    }
}
