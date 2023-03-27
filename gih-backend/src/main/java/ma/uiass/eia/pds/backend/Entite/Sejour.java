package ma.uiass.eia.pds.backend.Entite;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="Sejour")
public class Sejour implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int sejour_id;

    @Column(name="date_entree")
    private Date date_entre;

    @Column(name="date_sortie")
    private Date date_sortie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lit_id", referencedColumnName = "Id")
    private Lit lit;

    public Sejour(Date date_entre, Date date_sortie, Lit lit) {
        this.date_entre = date_entre;
        this.date_sortie = date_sortie;
        this.lit = lit;
    }

    public int getSejour_id() {
        return sejour_id;
    }

    public void setSejour_id(int sejour_id) {
        this.sejour_id = sejour_id;
    }

    public Date getDate_entre() {
        return date_entre;
    }

    public void setDate_entre(Date date_entre) {
        this.date_entre = date_entre;
    }

    public Date getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }

    public Lit getLit() {
        return lit;
    }

    public void setLit(Lit lit) {
        this.lit = lit;
    }

    public Sejour() {

    }

    @Override
    public String toString() {
        return "Sejour{" +
                "sejour_id=" + sejour_id +
                '}';
    }
}
