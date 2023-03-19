package ma.uiass.eia.pds.backend.Entite;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Emplacement")
public class Emplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int emplacement_id;
    private String nomBatiment,etage;
    @OneToMany(mappedBy ="emplacement")
    private List<Service> list ;

    public Emplacement(String nomBatiment, String etage) {
        this.nomBatiment = nomBatiment;
        this.etage = etage;
    }
    public Emplacement(){};

    public int getEmplacement_id() {
        return emplacement_id;
    }

    public void setEmplacement_id(int emplacement_id) {
        this.emplacement_id = emplacement_id;
    }

    public String getNomBatiment() {
        return nomBatiment;
    }

    public void setNomBatiment(String nomBatiment) {
        this.nomBatiment = nomBatiment;
    }

    public String getEtage() {
        return etage;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public List<Service> getList() {
        return list;
    }

    public void setList(List<Service> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Emplacement{" +
                "nomBatiment='" + nomBatiment + '\'' +
                ", etage='" + etage + '\'' +
                '}';
    }
}
