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

    @Column
    @Enumerated(EnumType.STRING)
    private EtatDemande etat;



    @OneToMany(mappedBy ="demande")
    private List<DetailDemande> detailDemande ;


    public List<DetailDemande> getDetailDemande() {
        return detailDemande;
    }

    public void setDetailDemande(List<DetailDemande> detailDemande) {
        this.detailDemande = detailDemande;
    }

    public Demande(String code, Date date, Service service, EtatDemande etat) {
        this.code = code;
        this.date = date;
        this.service = service;
        this.etat = etat;
    }

    public Demande() {
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


    public EtatDemande getEtat() {
        return etat;
    }

    public void setEtat(EtatDemande etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Demande{" +
                "demande_id=" + demande_id +
                ", code='" + code + '\'' +
                ", date=" + date +
                ", service=" + service +
                ", etat=" + etat +
                '}';
    }
}