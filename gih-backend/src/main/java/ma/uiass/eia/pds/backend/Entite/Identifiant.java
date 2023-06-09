package ma.uiass.eia.pds.backend.Entite;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Identifiant")
public class Identifiant implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int identifiant_id;

    @Column(name = "codeIdentifiant")
    private String code;

    @Column
    private String nom,prenom,email,password;
    private int tel;

    @JoinColumn(name = "job_id",referencedColumnName = "Id")
    @ManyToOne
    private Job job;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    public int getIdentifiant_id() {
        return identifiant_id;
    }

    public void setIdentifiant_id(int identifiant_id) {
        this.identifiant_id = identifiant_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public Identifiant() {

    }

    public Identifiant(String code, String nom, String prenom, String email, int tel, Sexe sexe, String password, Job job){
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.tel=tel;
        this.sexe=sexe;
        this.password=password;
        this.job=job;
        this.code=code;
    }



    @Override
    public String toString() {
        return "Identifiant{" +
                "identifiant_id=" + identifiant_id +
                ", code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tel=" + tel +

                ", sexe=" + sexe +
                '}';
    }
}

