package Tienda.dao;

import Tienda.domain.Credito;
import org.springframework.data.repository.CrudRepository;


public interface CreditoDao extends CrudRepository<Credito, Long>{
    
}