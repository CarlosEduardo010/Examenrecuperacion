package edu.mx.utez.examenrecuperacion.controller;

import edu.mx.utez.examenrecuperacion.service.impl.ClientesImpl;
import edu.mx.utez.examenrecuperacion.model.dto.Dtoclientes;
import edu.mx.utez.examenrecuperacion.model.entity.Beanclientes;
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
public class Controllercliente {

    private final ClientesImpl clienteService;

    @PostMapping("/clientes")
    public Dtoclientes create(@RequestBody Dtoclientes dtocliente){
        Beanclientes clienteSave = clienteService.save(dtocliente);
        return dtocliente.builder()
                .id_cliente(dtocliente.getId_cliente())
                .name(dtocliente.getName())
                .ap1(dtocliente.getAp1())
                .ap2(dtocliente.getAp2())
                .telefono(dtocliente.getTelefono())
                .direccion(dtocliente.getDireccion())
                .build();
    }
    @PutMapping("/clientes")
    public Dtoclientes update(@RequestBody Dtoclientes dtocliente){
        Beanclientes clienteupdate = clienteService.save(dtocliente);
        return dtocliente.builder()
                .id_cliente(dtocliente.getId_cliente())
                .name(dtocliente.getName())
                .ap1(dtocliente.getAp1())
                .ap2(dtocliente.getAp2())
                .telefono(dtocliente.getTelefono())
                .direccion(dtocliente.getDireccion())
                .build();
    }
    @GetMapping("/clientes/{id}")
    public Beanclientes showById(@PathVariable Integer id){
        try{
            return clienteService.findById(id);
        } catch (DataAccessException dae){
            throw new RuntimeException("Error en Base de Datos: ", dae);
        } catch (Exception ex){
            throw new RuntimeException("Error al obtener la persona: ", ex);
        }
    }
    @GetMapping("/clientes")
    public List<Beanclientes> findAll(){
        try{
            return clienteService.findAll();
        } catch (DataAccessException dae){
            throw new RuntimeException("Error en la base de datos: ", dae);
        } catch (Exception ex){
            throw new RuntimeException("Error al obtener la persona: ", ex);
        }

    }
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try{
            Beanclientes user = clienteService.findById(id);
            clienteService.delete(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (DataAccessException ex){
            response.put("mensaje", ex.getMessage());
            response.put("Person", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
