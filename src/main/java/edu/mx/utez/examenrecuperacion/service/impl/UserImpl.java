package edu.mx.utez.examenrecuperacion.service.impl;
import java.security.SecureRandom;
import java.util.List;

import edu.mx.utez.examenrecuperacion.service.Iuser;
import edu.mx.utez.examenrecuperacion.model.dto.Dtouser;
import edu.mx.utez.examenrecuperacion.model.dao.Daouser;
import edu.mx.utez.examenrecuperacion.model.entity.Beanuser;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UserImpl implements Iuser {

    private final Daouser daouser;

    @Transactional
    @Override
    public Beanuser save(Dtouser dtouser) {
        Beanuser user = Beanuser.builder()
                .id_cliente(dtouser.getIduser())
                .username(dtouser.getUsername())
                .password(generarContrasena())
                .status(dtouser.getStatus())
                .build();
        return daouser.save(user);
    }
    @Transactional(readOnly = true)
    @Override
    public Beanuser findById(Integer id) {
        return daouser.findById(id).orElse(null);
    }

    @Override
    public void delete(Beanuser beanuser) { daouser.delete(beanuser);

    }

    @Override
    public List<Beanuser> findAll() {
        return (List<Beanuser>) daouser.findAll();
    }
    private static final String CARACTERES_MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String CARACTERES_MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String CARACTERES_NUMEROS = "0123456789";
    private static final String CARACTERES_ESPECIALES = "!@#$%^&*()-_=+";

    public static String generarContrasena() {
        String caracteresPosibles = CARACTERES_MINUSCULAS + CARACTERES_MAYUSCULAS + CARACTERES_NUMEROS + CARACTERES_ESPECIALES;
        SecureRandom random = new SecureRandom();
        StringBuilder contrasena = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int indice = random.nextInt(caracteresPosibles.length());
            contrasena.append(caracteresPosibles.charAt(indice));
        }

        return contrasena.toString();
    }
}

