package edu.mx.utez.examenrecuperacion.service;

import edu.mx.utez.examenrecuperacion.model.dao.Daoclientes;
import edu.mx.utez.examenrecuperacion.model.dto.Dtoclientes;
import edu.mx.utez.examenrecuperacion.model.entity.Beanclientes;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Iclientes {
    Beanclientes save(Dtoclientes dtocliente);

    Beanclientes findById(Integer id);
    void delete(Beanclientes beancliente);
    List<Beanclientes> findAll();
}
