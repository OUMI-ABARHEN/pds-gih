package ma.uiass.eia.pds.backend.Entite;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Lit")
public class Lit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int lit_id;
    @Column
    @Enumerated(EnumType.STRING)
    private TypeLit typeLit;

    @Column(name="marque")
    private String marque;
    @JoinColumn(name = "espace_id",referencedColumnName = "Id")
    @ManyToOne
    private Espace espace;

    @OneToMany(mappedBy ="lit")
    private List<Sejour> list ;
    @Column
    @Enumerated(EnumType.STRING)
    private EtatLit etat;

    public Lit( TypeLit typeLit, String marque, Espace espace, EtatLit etat) {

        this.typeLit = typeLit;
        this.marque = marque;
        this.espace = espace;
        this.etat = etat;

    }

    public Lit() {

    }

    public EtatLit getEtat() {
        return etat;
    }

    public void setEtat(EtatLit etat) {
        this.etat = etat;
    }


    public int getId() {
        return lit_id;
    }

    public void setId(int id) {
        this.lit_id = id;
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

    public List<Sejour> getList() {
        return list;
    }

    public void setList(List<Sejour> list) {
        this.list = list;
    }

    public Espace getEspace() {
        return espace;
    }

    public void setEspace(Espace espace) {
        this.espace = espace;
    }

    @Override
    public String toString() {
        return "Lit{" +
                "lit_id=" + lit_id +
                '}';
    }
}
