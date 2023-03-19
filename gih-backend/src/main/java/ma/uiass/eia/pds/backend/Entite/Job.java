package ma.uiass.eia.pds.backend.Entite;


import javax.persistence.*;

@Entity
@Table(name="Job")
public class Job {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int job_id;

    public Job() {

    }

    @Column
    private String nomJob;

    public Job( String nom){

        this.nomJob=nom;
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
    public String toString(){
        return "nom= "+this.nomJob+"].";
    }
}

