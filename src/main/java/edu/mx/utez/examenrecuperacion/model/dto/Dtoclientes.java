package edu.mx.utez.examenrecuperacion.model.dto;

import jakarta.persistence.Column;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dtoclientes {
    private Integer id_cliente;
    private String name;
    private String ap1;
    private String ap2;
    private String telefono;
    private String direccion;
}
