package ma.uiass.eia.pds.backend.Entite;


import java.util.List;

public class DemandeFormat {
    private int demande_id;
    private String code;
    private String date;

    private Service service;
    private EtatDemande etat;
    private List<DetailDemande> lst;


    public DemandeFormat(int demande_id, String code, String date, EtatDemande etat, Service service,  List<DetailDemande> lst) {
        this.demande_id = demande_id;
        this.code = code;
        this.date = date;
        this.etat = etat;
        this.service = service;
        this.lst = lst;
    }

    public DemandeFormat() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public List<DetailDemande> getLst() {
        return lst;
    }

    public void setLst(List<DetailDemande> lst) {
        this.lst = lst;
    }

    @Override
    public String toString() {
        return "DemandeFormat{" +
                "code='" + code + '\'' +
                ", date='" + date + '\'' +
                ", service=" + service +
                ", etat=" + etat +
                '}';
    }
}

