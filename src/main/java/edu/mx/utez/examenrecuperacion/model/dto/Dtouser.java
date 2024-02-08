package edu.mx.utez.examenrecuperacion.model.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dtouser {
    private Integer iduser;
    private String Username;
    private String Password;
    private Boolean status;
}
