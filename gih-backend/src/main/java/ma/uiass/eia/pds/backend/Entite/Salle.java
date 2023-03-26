package ma.uiass.eia.pds.backend.Entite;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Salle")
public class Salle extends Espace implements Serializable {


    @Column(name="TypeSalle")
    @Enumerated(EnumType.STRING)
    private TypeSalle type;

    public Salle() {
        super();
    }

    public TypeSalle getType() {
        return type;
    }

    public void setType(TypeSalle type) {
        this.type = type;
    }


    public Salle(String code, int quantite, Service service, TypeSalle type) {
        super(code,quantite,service);
        this.type=type;

    }

    @Override
    public String toString() {
        return "Salle{" +super.toString()+
                "type=" + type +
                '}';
    }
}
