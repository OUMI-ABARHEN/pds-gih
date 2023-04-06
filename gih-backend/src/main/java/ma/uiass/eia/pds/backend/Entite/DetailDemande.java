package ma.uiass.eia.pds.backend.Entite;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="DetailDemande")
public class DetailDemande implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int detail_id;

    @Column(name="codeDetail")
    private String code;
    @JsonIgnore
    @JoinColumn(name = "Demande_id",referencedColumnName = "Id")
    @ManyToOne
    private Demande demande;

    @Column(name="quantite")
    private int quantite;

    @Column(name="TypeLit")
    @Enumerated(EnumType.STRING)
    private TypeLit type;

    public DetailDemande(String code,  TypeLit type, int quantite) {
        this.code = code;
        this.quantite = quantite;
        this.type= type;

    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public TypeLit getType() {
        return type;
    }

    public void setType(TypeLit type) {
        this.type = type;
    }

    public DetailDemande() {
    }

    @Override
    public String toString() {
        return "DetailDemande{" +
                "detail_id=" + detail_id +
                ", code='" + code + '\'' +
                ", quantite=" + quantite +
                ", type=" + type +
                '}';
    }
}
