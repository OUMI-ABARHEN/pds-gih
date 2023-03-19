package ma.uiass.eia.pds.backend.Entite;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="Salle")
public class Salle extends Espace{
    public Salle(int quantite, Service service,TypeSalle type) {
        super(quantite,service);
        this.type=type;
    }


    private TypeSalle type;

    public Salle() {
    }

    public TypeSalle getType() {
        return type;
    }

    public void setType(TypeSalle type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString()+"Salle{" +
                "type=" + type +
                '}';
    }
}
