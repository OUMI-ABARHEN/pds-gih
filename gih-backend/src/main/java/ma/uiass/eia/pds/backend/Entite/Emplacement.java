package ma.uiass.eia.pds.backend.Entite;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Emplacement")
public class Emplacement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int emplacement_id;

    @Column(name = "codeEmplacement")
    private String code;
    private String nomBatiment,etage;
    @JsonIgnore
    @OneToMany(mappedBy ="emplacement")
    private List<Service> list ;

    public int getEmplacement_id() {
        return emplacement_id;
    }

    public void setEmplacement_id(int emplacement_id) {
        this.emplacement_id = emplacement_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Emplacement(String code, String nomBatiment, String etage) {
        this.nomBatiment = nomBatiment;
        this.etage = etage;
        this.code=code;
    }
    public Emplacement(){};


    @Override
    public String toString() {
        return "Emplacement{" +
                "code='" + code + '\'' +
                ", nomBatiment='" + nomBatiment + '\'' +
                ", etage='" + etage + '\'' +
                '}';
    }
}
