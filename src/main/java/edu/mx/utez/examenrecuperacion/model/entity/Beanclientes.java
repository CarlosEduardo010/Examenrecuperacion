package edu.mx.utez.examenrecuperacion.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Beanclientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id_cliente;
    @Column(name = "username")
    private String username;
    @Column(name = "ap1")
    private String ap1;
    @Column(name = "ap2")
    private String ap2;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
}
