package com.example.gerenciarpedidos.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "MovimentacaoEstoque")
public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @ManyToOne
    private Item item;

    private int quantidade;


}
