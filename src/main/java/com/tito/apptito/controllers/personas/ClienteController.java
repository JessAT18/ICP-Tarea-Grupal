package com.tito.apptito.controllers.personas;

import com.tito.apptito.entities.personas.Cliente;
import com.tito.apptito.services.IClienteService;
import com.tito.apptito.services.parametros.IEstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/personas/clientes")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @Autowired
    private IEstadoCivilService iEstadoCivilService;

    @GetMapping("/formClientes")
    public String formClientes (Model model){

        model.addAttribute("formClientes", new Cliente());
        //Se agrega este model attribute por la relacion entre cliente y estadocivil
        model.addAttribute("formEstadoCivil", iEstadoCivilService.listarTodosLosEstadosCiviles());

        return  "personas/form-cliente";

    }

    @GetMapping("/formListarClientes")
    public String formListaDeClientes (Model model){

        model.addAttribute("listaclientes", iClienteService.listarTodosLosClientes());
        model.addAttribute("formEstadoCivil", iEstadoCivilService.listarTodosLosEstadosCiviles());

        return  "personas/form-lista_cliente";

    }

    @PostMapping("/grabarClientes")
    public String grabarClientes(@Validated @ModelAttribute("formClientes") Cliente cliente,
                               BindingResult bindingResult, RedirectAttributes flash, Model model){
        if (bindingResult.hasErrors()){
            flash.addFlashAttribute("error", "Problemas al agregar al cliente");
            model.addAttribute("formEstadoCivil", iEstadoCivilService.listarTodosLosEstadosCiviles());
            return  "personas/form-cliente";
        } else {
            iClienteService.grabarCliente(cliente);
            flash.addFlashAttribute("success", "Cliente agregado con éxito");
            return "redirect:/personas/clientes/formClientes";
        }
    }

    @GetMapping("/delete_cliente/{id}")
    public String deleteClientes(@PathVariable("id") int id, RedirectAttributes flash){
        if (id > 0) {
            iClienteService.borrarClienteById(id);
            flash.addFlashAttribute("success", "El Cliente fue eliminado");

        } else {
            flash.addFlashAttribute("error", "Problemas al eliminar Cliente");
        }
        return "redirect:/personas/clientes/formListarClientes";
    }

    @GetMapping("/update_cliente/{id}")
    public String updateCliente(@PathVariable("id") int id, Model model) {

        Cliente cliente;

        cliente = iClienteService.encontrarUnCliente(id);
        
        model.addAttribute("formEstadoCivil", iEstadoCivilService.listarTodosLosEstadosCiviles());

        model.addAttribute("formClientes", cliente);

        return "personas/form-cliente";
    }

}
