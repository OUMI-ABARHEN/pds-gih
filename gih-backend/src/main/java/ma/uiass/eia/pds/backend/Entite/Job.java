package ma.uiass.eia.pds.backend.Entite;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Job")
public class Job implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int job_id;

    @Column(name = "codeJob")
    private String code;

    public Job() {

    }

    @Column
    private String nomJob;

    public Job( String code,String nom){
        this.nomJob=nom;
        this.code=code;
    }
    public Job (String nom) {
        this.nomJob=nom;
        this.code=code;
    }
    public int getIdJob(){
        return job_id;
    }
    public void setIdJob(int id){
        this.job_id=id;
    }
    public void setNomJob(String nom){
        this.nomJob=nom;
    }
    public String getNomJob(){
        return nomJob;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString(){
        return "nom= "+this.nomJob+"code:"+this.getCode()+"].";
    }
}

