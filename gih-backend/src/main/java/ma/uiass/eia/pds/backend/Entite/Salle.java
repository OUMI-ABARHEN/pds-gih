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

    @Column(name = "codeSalle")
    private String code;

    public Salle() {
        super();
    }

    public TypeSalle getType() {
        return type;
    }

    public void setType(TypeSalle type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Salle(String code, int quantite, Service service, TypeSalle type) {
        super(quantite,service);
        this.type=type;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Salle{" +super.toString()+
                "type=" + type +
                '}';
    }
}
