package com.tito.apptito.controllers.parametros;

import com.tito.apptito.entities.parametros.EstadoCivil;
import com.tito.apptito.services.parametros.IEstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/parametros/estadosciviles")
public class EstadoCivilController {
    public static final String VISTA_FORMULARIO = "parametros/estado_civil/form-eciviles";
    public static final String VISTA_LISTA = "parametros/estado_civil/form-lista_eciviles";
    public static final String REDIRECT_FORMULARIO = "redirect:/parametros/estadosciviles/formEstadoCivil";
    public static final String DELETE_SUCCESS = "Éxito";
    public static final String DELETE_SUCCESS_MESSAGE = "El estado civil fue eliminado";
    public static final String DELETE_ERROR = "Error";
    public static final String DELETE_ERROR_MESSAGE = "Problemas al eliminar el estado civil";
    public static final String REDIRECT_LISTA = "redirect:/parametros/estadosciviles/formListarEstadosCiviles";

    @Autowired
    private IEstadoCivilService iEstadoCivilService;

    @GetMapping("/formEstadoCivil")
    public String formEstadoCivil (Model model){

        model.addAttribute("formEstadoCivil", new EstadoCivil());

        return VISTA_FORMULARIO;

    }

    @GetMapping("/formListarEstadosCiviles")
    public String formListaDeEstadosCiviles (Model model){

        model.addAttribute("listaestadosciviles", iEstadoCivilService.listarTodosLosEstadosCiviles());

        return VISTA_LISTA;

    }

    @PostMapping("/grabarEstadosCiviles")
    public String grabarEstadosCiviles(@Validated @ModelAttribute("formEstadoCivil") EstadoCivil estadoCivil,
                                 BindingResult bindingResult, RedirectAttributes flash){
        if (bindingResult.hasErrors()){
            flash.addFlashAttribute("Error", "Problemas al agregar el estado civil");
            return VISTA_FORMULARIO;
        } else {
            iEstadoCivilService.grabarEstadoCivil(estadoCivil);
            flash.addFlashAttribute("success", "Estado Civil agregado con éxito");
            return REDIRECT_FORMULARIO;
        }
    }

    @GetMapping("/deleteEstadosCiviles/{id}")
    public String deleteEstadosCiviles(@PathVariable("id") int id, RedirectAttributes flash){
        if (id > 0) {
            iEstadoCivilService.borrarEstadoCivilById(id);
            flash.addFlashAttribute(DELETE_SUCCESS, DELETE_SUCCESS_MESSAGE);

        } else {
            flash.addFlashAttribute(DELETE_ERROR, DELETE_ERROR_MESSAGE);
        }
        return REDIRECT_LISTA;
    }

    @GetMapping("/updateEstadosCiviles/{id}")
    public String updateEstadosCiviles(@PathVariable("id") int id, Model model) {

        EstadoCivil estadoCivil;

        estadoCivil = iEstadoCivilService.encontrarUnEstadoCivil(id);

        model.addAttribute("formEstadoCivil", estadoCivil);

        return VISTA_FORMULARIO;
    }

}
