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
    @Column(name="marque")
    private String marque;
    @JsonIgnore
    @JoinColumn(name = "espace_id",referencedColumnName = "Id")
    @ManyToOne
    private Espace espace;
    @JsonIgnore
    @OneToMany(mappedBy ="lit")
    private List<Sejour> list ;
    @Column
    @Enumerated(EnumType.STRING)
    private EtatLit etat;

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

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Espace getEspace() {
        return espace;
    }

    public void setEspace(Espace espace) {
        this.espace = espace;
    }

    public List<Sejour> getList() {
        return list;
    }

    public void setList(List<Sejour> list) {
        this.list = list;
    }

    public EtatLit getEtat() {
        return etat;
    }

    public void setEtat(EtatLit etat) {
        this.etat = etat;
    }

    public Lit(String code, TypeLit typeLit, String marque, Espace espace, EtatLit etat) {
        this.typeLit = typeLit;
        this.marque = marque;
        this.espace = espace;
        this.etat = etat;
        this.code=code;

    }
    public Lit() {
    }

    @Override
    public String toString() {
        return "Lit{" +
                "lit_id=" + lit_id +
                ", code='" + code + '\'' +
                ", typeLit=" + typeLit +
                ", marque='" + marque + '\'' +
                ", espace=" + espace +
                ", list=" + list +
                ", etat=" + etat +
                '}';
    }
}
