package ma.uiass.eia.pds.backend.Entite;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Service")
public class Service {
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

    public Service(String code, String nomService,Emplacement emp) {
        this.emplacement = emp;
        this.code = code;
        this.nomService = nomService;
    }
    public Service(){};

    public String getCode() {
        return code;
    }

    public String getNomService() {
        return nomService;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public List<Espace> getListBat() {
        return list;
    }

    public void setListBat(List<Espace> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Service{" +
                "code='" + code + '\'' +
                ", nomService='" + nomService + '\'' +
                '}';
    }
}

