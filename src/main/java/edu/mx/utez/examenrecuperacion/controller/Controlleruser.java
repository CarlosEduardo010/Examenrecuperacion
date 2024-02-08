package edu.mx.utez.examenrecuperacion.controller;
import edu.mx.utez.examenrecuperacion.service.impl.UserImpl;
import edu.mx.utez.examenrecuperacion.model.dto.Dtouser;
import edu.mx.utez.examenrecuperacion.model.entity.Beanuser;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v2")
public class Controlleruser {
    private final UserImpl usuarioService;

    @PostMapping("/usuario")
    public Dtouser create(@RequestBody Dtouser dtocliente){
        Beanuser clienteSave = usuarioService.save(dtocliente);
        return dtocliente.builder()
                .iduser(clienteSave.getId_cliente())
                .Username(clienteSave.getUsername())
                .Password(clienteSave.getPassword())
                .status(clienteSave.getStatus())
                .build();
    }
    @PutMapping("/usuario")
    public Dtouser update(@RequestBody Dtouser dtocliente){
        Beanuser clienteupdate = usuarioService.save(dtocliente);
        return dtocliente.builder()
                .iduser(clienteupdate.getId_cliente())
                .Username(clienteupdate.getUsername())
                .Password(clienteupdate.getPassword())
                .status(clienteupdate.getStatus())
                .build();
    }
    @GetMapping("/usuario/{id}")
    public Beanuser showById(@PathVariable Integer id){
        try{
            return usuarioService.findById(id);
        } catch (DataAccessException dae){
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex){
            throw new RuntimeException("Error al obtener la persona: ", ex);
        }
    }
    @GetMapping("/usuario")
    public List<Beanuser> findAll(){
        try{
            return usuarioService.findAll();
        } catch (DataAccessException dae){
            throw new RuntimeException("Error en la base de datos: ", dae);
        } catch (Exception ex){
            throw new RuntimeException("Error al obtener la persona: ", ex);
        }

    }



}
