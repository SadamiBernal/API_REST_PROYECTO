package mx.unam.aragon.ico.ia.luchadoresapi.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "luchadores")
public class Luchador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO INCREMENT
    private Long clave;

    @Column(name ="nombre_luchador",  nullable = false, length = 50)
    @NotBlank(message = "No se pueden meter datos vacios")
    @NotNull(message = "No se pueden meter nulos")
    private String nombre;

    @Column(name = "edad_luchador", nullable = false)
    @NotBlank(message = "No se pueden meter datos vacios")
    @NotNull(message = "No se pueden meter nulos")
    private Integer edad;

    @Column(name = "foto_luchador", insertable = false, columnDefinition = "VARCHAR(250) DEFAULT 'https://medisave.store/public/img/comingsoon-square.png'")
    private String foto;

    @Column(nullable = false)
    @NotBlank(message = "No se pueden meter datos vacios")
    @NotNull(message = "No se pueden meter nulos")
    private String marca;

    public Luchador() {
    }

    public Luchador(Long clave, String nombre, Integer edad, String foto, String marca) {
        this.clave = clave;
        this.nombre = nombre;
        this.edad = edad;
        this.foto = foto;
        this.marca = marca;
    }

    public Long getId() {
        return clave;
    }

    public void setId(Long id) {
        this.clave = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Luchador{" +
                "clave=" + clave +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", foto='" + foto + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
