package ma.uiass.eia.pds.backend.Entite;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Service")
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int service_id;
    @Column
    private String code;
    @Column
    private String nomService;
    @OneToMany(mappedBy ="service")
    private List<Espace> list ;

    @JoinColumn(name = "Emplacement_id",referencedColumnName = "Id")
    @ManyToOne

    private Emplacement emplacement;

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public List<Espace> getList() {
        return list;
    }

    public void setList(List<Espace> list) {
        this.list = list;
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }

    public Service(String code, String nomService, Emplacement emp) {
        this.emplacement = emp;
        this.code = code;
        this.nomService = nomService;
    }
    public Service(){};

    @Override
    public String toString() {
        return "Service{" +
                "code='" + code + '\'' +
                ", nomService='" + nomService + '\'' +
                "id" + service_id +
                '}';
    }
}

