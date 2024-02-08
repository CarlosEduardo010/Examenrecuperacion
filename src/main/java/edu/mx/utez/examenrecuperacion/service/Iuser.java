package edu.mx.utez.examenrecuperacion.service;
import edu.mx.utez.examenrecuperacion.model.entity.Beanuser;
import edu.mx.utez.examenrecuperacion.model.dto.Dtouser;

import java.util.List;

public interface Iuser {
    Beanuser save(Dtouser dtocliente);
    Beanuser findById(Integer id);
    void delete(Beanuser beancliente);
    List<Beanuser> findAll();
}
