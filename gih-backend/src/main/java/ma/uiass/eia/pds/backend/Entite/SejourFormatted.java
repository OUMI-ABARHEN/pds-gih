package ma.uiass.eia.pds.backend.Entite;

public class SejourFormatted {
    private int sejour_id;
    private String date_entre;
    private String date_sortie;
    private Lit lit;

    public SejourFormatted(int sejour_id, String date_entre, String date_sortie, Lit lit) {
        this.sejour_id = sejour_id;
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

    public String getDate_entre() {
        return date_entre;
    }

    public void setDate_entre(String date_entre) {
        this.date_entre = date_entre;
    }

    public String getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }

    public Lit getLit() {
        return lit;
    }

    public void setLit(Lit lit) {
        this.lit = lit;
    }
}
