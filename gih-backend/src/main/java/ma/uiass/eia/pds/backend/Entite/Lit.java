package ma.uiass.eia.pds.backend.Entite;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Lit")
public class Lit implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int lit_id;
    @Column(name="codeLit")
    private String code;
    @Column
    @Enumerated(EnumType.STRING)
    private TypeLit typeLit;

    @Column
    @Enumerated(EnumType.STRING)
    private EtatLit etat;

    @Column
    @Enumerated(EnumType.STRING)
    private EtatPhysique etatPhysique;

    @JoinColumn(name = "espace_id",referencedColumnName = "Id")
    @ManyToOne
    private Espace espace;
    @OneToOne(mappedBy = "lit")
    private Sejour sejour;
    @JoinColumn(name = "service_id",referencedColumnName = "Id")
    @ManyToOne
    private Service service;

    public int getLit_id() {
        return lit_id;
    }

    public void setLit_id(int lit_id) {
        this.lit_id = lit_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TypeLit getTypeLit() {
        return typeLit;
    }

    public void setTypeLit(TypeLit typeLit) {
        this.typeLit = typeLit;
    }

    public EtatLit getEtat() {
        return etat;
    }

    public void setEtat(EtatLit etat) {
        this.etat = etat;
    }

    public EtatPhysique getEtatPhysique() {
        return etatPhysique;
    }

    public void setEtatPhysique(EtatPhysique etatPhysique) {
        this.etatPhysique = etatPhysique;
    }

    public Espace getEspace() {
        return espace;
    }

    public void setEspace(Espace espace) {
        this.espace = espace;
    }

    public Sejour getSejour() {
        return sejour;
    }

    public void setSejour(Sejour sejour) {
        this.sejour = sejour;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Lit(String code, TypeLit typeLit, EtatLit etat, EtatPhysique etatPhysique, Espace espace, Sejour sejour) {
        this.code = code;
        this.typeLit = typeLit;
        this.etat = etat;
        this.etatPhysique = etatPhysique;
        this.espace = espace;
        this.sejour = sejour;
    }
}
