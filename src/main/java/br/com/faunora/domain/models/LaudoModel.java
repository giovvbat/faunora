package br.com.faunora.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_laudos")
@Data
public class LaudoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "laudo_id")
    private UUID id;

    @Column(name = "laudo_descricao", nullable = false)
    private String prescricao;

    @Column(name = "laudo_validade", nullable = false)
    private LocalDate validade;

    @JoinColumn(name = "exame_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private ExameModel exame;
}

