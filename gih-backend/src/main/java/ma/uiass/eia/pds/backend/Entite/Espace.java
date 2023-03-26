package ma.uiass.eia.pds.backend.Entite;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="Espace")
public class Espace implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private int espace_id;
    @Column(name = "codeChambre")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name="quantite")
    private int quantite;

    @JsonIgnore
    @OneToMany(mappedBy = "espace")
    private List<Lit> lits ;

    @JsonIgnore
    @JoinColumn(name = "Service_id",referencedColumnName = "Id")
    @ManyToOne
    private Service service;




    public int getEspace_id() {
        return espace_id;
    }

    public void setEspace_id(int espace_id) {
        this.espace_id = espace_id;
    }
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public List<Lit> getLits() {
        return lits;
    }

    public void setLits(List<Lit> lits) {
        this.lits = lits;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Espace(String code,int quantite, Service service) {
        this.code= code;
        this.quantite=quantite;
        this.service = service;
    }
    public Espace() {
    }

    @Override
    public String toString() {
        return "code='" + code + '\'' +
                ", quantite=" + quantite +
                ", service=" + service +
                '}';
    }
}
