package ma.uiass.eia.pds.backend.Entite;

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

    @JoinColumn(name = "Demande_id",referencedColumnName = "Id")
    @ManyToOne
    private Demande demande;

    @Column(name="quantite")
    private int quantite;


    private Lit lit;
    private Service service;

    public DetailDemande(String code,  Lit lit, Service service,int quantite) {
        this.code = code;
        this.quantite = quantite;
        this.lit = lit;
        this.service = service;
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

    public Lit getLit() {
        return lit;
    }

    public void setLit(Lit lit) {
        this.lit = lit;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
