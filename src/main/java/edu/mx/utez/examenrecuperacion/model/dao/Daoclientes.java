package edu.mx.utez.examenrecuperacion.model.dao;
import edu.mx.utez.examenrecuperacion.model.entity.Beanclientes;
import org.springframework.data.repository.CrudRepository;
public interface Daoclientes extends CrudRepository<Beanclientes, Integer> {
}
