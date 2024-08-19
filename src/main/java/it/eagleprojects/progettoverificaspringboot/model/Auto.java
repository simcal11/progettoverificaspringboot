package it.eagleprojects.progettoverificaspringboot.model;

//JPA - Entity

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

//@Table(name = "auto") //se nel caso la tabella ha un nome diversa rispetto alla classe che stiamo creando
@Entity
@DynamicInsert //Specifichiamo che ogni volta che creiamo una entity, hibernate deve fare autonomamente
@DynamicUpdate
//una insert o un update nel database persistente cambiando solo ciò che abbiamo definito nell'entità (ad esempio se modifichiamo solo il nome, va fatta una query che cambia il nome, così da rendere più veloce il tutto)
public class Auto {

    //Ci deve essere il wrapper perché JPA lavora con gli oggetti (è preferibile quindi usare sempre le classi e non i tipi primitivi)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gli diciamo che l'id è autoincrementato dal database
    private Long id;

    //@Column(name="targa") //Stessa cosa se una colonna ha un nome diverso
    private String targa;

    //@Column(name="marca") //Stessa cosa se una colonna ha un nome diverso
    private String marca;

    //@Column(name="modello") //Stessa cosa se una colonna ha un nome diverso
    private String modello;

    @OneToOne
    @MapsId
    @JoinColumn(name = "tassista_id")
    private Tassista tassista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Tassista getTassista() {
        return tassista;
    }

    public void setTassista(Tassista tassista) {
        this.tassista = tassista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(id, auto.id) && Objects.equals(targa, auto.targa) && Objects.equals(marca, auto.marca) && Objects.equals(modello, auto.modello) && Objects.equals(tassista, auto.tassista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, targa, marca, modello, tassista);
    }
}
