/**
 * Created by DAM on 16/12/16.
 */
public class Medalla {
    private long id;
    private TipoMedalla tipoMedalla;
    private String especialidad;
    private String competicion;
    private Atleta atleta;

    public Medalla(long id, TipoMedalla tipoMedalla, String especialidad, String competicion, Atleta atleta) {
        this.id = id;
        this.tipoMedalla = tipoMedalla;
        this.especialidad = especialidad;
        this.competicion = competicion;
        this.atleta = atleta;
    }
    public Medalla() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoMedalla getTipoMedalla() {
        return tipoMedalla;
    }

    public void setTipoMedalla(TipoMedalla tipoMedalla) {
        this.tipoMedalla = tipoMedalla;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    @Override
    public String toString() {
        return "Medalla{" +
                "id=" + id +
                ", tipoMedalla=" + tipoMedalla +
                ", especialidad='" + especialidad + '\'' +
                ", competicion='" + competicion + '\'' +
                ", atleta=" + atleta +
                '}';
    }
}
