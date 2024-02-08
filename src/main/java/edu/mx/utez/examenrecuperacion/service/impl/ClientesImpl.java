package edu.mx.utez.examenrecuperacion.service.impl;
import java.util.List;


import edu.mx.utez.examenrecuperacion.model.dto.Dtoclientes;
import edu.mx.utez.examenrecuperacion.service.Iclientes;
import edu.mx.utez.examenrecuperacion.model.dao.Daoclientes;
import edu.mx.utez.examenrecuperacion.model.entity.Beanclientes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service

public class ClientesImpl implements Iclientes {
    private final Daoclientes daocliente;

    @Transactional
    @Override
    public Beanclientes save(Dtoclientes dtocliente) {
        Beanclientes cliente = Beanclientes.builder()
                .id_cliente(dtocliente.getId_cliente())
                .ap1(dtocliente.getAp1())
                .ap2(dtocliente.getAp2())
                .direccion(dtocliente.getDireccion())
                .direccion(dtocliente.getDireccion())
                .build();

        return daocliente.save(cliente);
    }



    @Transactional(readOnly = true)
    @Override
    public Beanclientes findById(Integer id) {
        return daocliente.findById(id).orElse(null);
    }

    @Override
    public void delete(Beanclientes Beanclientes) { daocliente.delete(Beanclientes);

    }

    @Override
    public List<Beanclientes> findAll() {
        return (List<Beanclientes>) daocliente.findAll();
    }
}
