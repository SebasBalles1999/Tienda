package Tienda.controller;

import Tienda.dao.ClienteDao;
import Tienda.domain.Cliente;
import Tienda.service.ClienteService;
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
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Ahora se usa arquitectura MVC");
        
        /*String mensaje = "Estamos semana 4, saludos.";
        model.addAttribute("texto", mensaje);
        
        Cliente cliente = new Cliente("Sebastian","Ballesteros","sballesteroschaves@gmail.com","2123-2134");
        model.addAttribute("cliente",cliente);
        var clientes = Arrays.asList(cliente);*/
        
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return "modificarCliente";
    }
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }
    
}
