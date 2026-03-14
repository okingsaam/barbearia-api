package entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String telefone;;

    private String email;

    @Column( name = "data_cadastro")
    private String dataCadastro;

    public Cliente(){
    }
    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDateTime.now().toString();
    }
    public Long getId(){
        return id;
    }
}
