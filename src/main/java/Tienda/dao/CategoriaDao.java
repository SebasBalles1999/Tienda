package Tienda.dao;

import Tienda.domain.Categoria;
import org.springframework.data.repository.CrudRepository;


public interface CategoriaDao extends CrudRepository<Categoria, Long>{
    
}
