package ma.uiass.eia.pds.backend.Entite;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name="Chambre")
public class Chambre extends Espace implements Serializable {

    @Column(name = "codeChambre")
    private String code;

    @Column(name="TypeChambre")
    @Enumerated(EnumType.STRING)
    private TypeChambre type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TypeChambre getType() {
        return type;
    }

    public void setType(TypeChambre type) {
        this.type = type;
    }

    public Chambre(String code, int quantite, Service service, TypeChambre type) {
        super(quantite,service);
        this.type=type;
        this.code=code;
    }
    public Chambre() {

    }

    @Override
    public String toString() {
        return "Chambre{" +
                "code='" + code + '\'' +
                ", type=" + type +
                "id" + this.getEspace_id()+
                '}';
    }
}
