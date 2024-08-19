package it.eagleprojects.progettoverificaspringboot.model;




import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

//JPA - Entity

//@Table(name = "tassista") //se nel caso la tabella ha un nome diversa rispetto alla classe che stiamo creando
@Entity
@DynamicInsert //Specifichiamo che ogni volta che creiamo una entity, hibernate deve fare autonomamente
@DynamicUpdate //una insert o un update nel database persistente cambiando solo ciò che abbiamo definito nell'entità (ad esempio se modifichiamo solo il nome, va fatta una query che cambia il nome, così da rendere più veloce il tutto)
public class Tassista {

    //Ci deve essere il wrapper perché JPA lavora con gli oggetti (è preferibile quindi usare sempre le classi e non i tipi primitivi)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gli diciamo che l'id è autoincrementato dal database
    private Long id;

    //@Column(name="nome") //Stessa cosa se una colonna ha un nome diverso
    private String nome;

    //@Column(name="cognome")
    private String cognome;

    @OneToOne(mappedBy = "tassista", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Auto auto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tassista tassista = (Tassista) o;
        return Objects.equals(id, tassista.id) && Objects.equals(nome, tassista.nome) && Objects.equals(cognome, tassista.cognome) && Objects.equals(auto, tassista.auto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome, auto);
    }
}
