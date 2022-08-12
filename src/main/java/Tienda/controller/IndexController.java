package Tienda.controller;

import Tienda.dao.ClienteDao;
import Tienda.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {
    
    @Autowired
    private ClienteDao clienteDao;
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Ahora se usa arquitectura MVC");
        
        /*String mensaje = "Estamos semana 4, saludos.";
        model.addAttribute("texto", mensaje);
        
        Cliente cliente = new Cliente("Sebastian","Ballesteros","sballesteroschaves@gmail.com","2123-2134");
        model.addAttribute("cliente",cliente);
        var clientes = Arrays.asList(cliente);*/
        
        var clientes = clienteDao.findAll();
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
}
