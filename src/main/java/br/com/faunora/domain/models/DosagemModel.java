package br.com.faunora.domain.models;

import br.com.faunora.domain.enums.DosagemTipo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tb_dosagens")
@Data
public class DosagemModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dosagem_id")
    private Long id;

    @JoinColumn(name = "pet_id", nullable = false)
    @ManyToOne
    private PetModel paciente;

    @Column(name = "dosagem_tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private DosagemTipo tipo;

    @Column(name = "dosagem_data", nullable = false)
    private LocalDate data;

    @Column(name = "dosagem_hora", nullable = false)
    private Instant hora;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private UserModel veterinario;
}
