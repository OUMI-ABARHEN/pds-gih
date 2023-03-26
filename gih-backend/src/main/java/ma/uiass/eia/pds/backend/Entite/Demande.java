package ma.uiass.eia.pds.backend.Entite;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Demande")
public class Demande implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int demande_id;

    @Column(name="codeDemande")
    private String code;

    @Column(name="dateDemande")
    private Date date;

    @JoinColumn(name = "service_id",referencedColumnName = "Id")
    @ManyToOne
    private Service service;

    @Column(name="Description")
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private EtatDemande etat;

    @JsonIgnore
    @OneToMany(mappedBy ="demande")
    private List<DetailDemande> detailDemande ;



    public Demande(String code, Date date,  String description, EtatDemande etat) {
        this.code = code;
        this.date = date;
        this.service = service;
        this.description = description;
        this.etat = etat;
    }

    public int getDemande_id() {
        return demande_id;
    }

    public void setDemande_id(int demande_id) {
        this.demande_id = demande_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EtatDemande getEtat() {
        return etat;
    }

    public void setEtat(EtatDemande etat) {
        this.etat = etat;
    }
}
