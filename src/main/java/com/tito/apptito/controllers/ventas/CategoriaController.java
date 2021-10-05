package com.tito.apptito.controllers.ventas;

import com.tito.apptito.entities.ventas.Categoria;
import com.tito.apptito.services.ventas.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ventas/categorias")
public class CategoriaController {

    public static final String REDIRECT_FORMULARIO = "redirect:/ventas/categorias/formCategorias";
    public static final String DELETE_SUCCESS = "Éxito";
    public static final String DELETE_SUCCESS_MESSAGE = "La Categoria fue eliminada";
    public static final String DELETE_ERROR = "Error";
    public static final String DELETE_ERROR_MESSAGE = "Problemas al eliminar la categoria";

    @Autowired
    private ICategoriaService iCategoriaService;

    @GetMapping("/formCategorias")
    public String formCategorias(Model model){

        model.addAttribute("formCategorias", new Categoria());
        return  "ventas/form-categoria";

    }

    @GetMapping("/formListarCategorias")
    public String formListaDeCategorias (Model model){

        model.addAttribute("listacategorias", iCategoriaService.listarTodasLasCategorias());
        return  "ventas/form-lista_categoria";

    }

    @PostMapping("/grabarCategorias")
    public String grabarCategorias(@Validated @ModelAttribute("formCategorias") Categoria categoria,
                                   BindingResult bindingResult, RedirectAttributes flash){
        if (bindingResult.hasErrors()){
            flash.addFlashAttribute("Error", "Problemas al agregar la categoria");
            return "ventas/form-categoria";
        } else {
            iCategoriaService.grabarCategoria(categoria);
            flash.addFlashAttribute("success", "Categoria agregada con éxito");
            return REDIRECT_FORMULARIO;
        }
    }

    @GetMapping("/deleteCategorias/{id}")
    public String deleteCategorias(@PathVariable("id") int id, RedirectAttributes flash){
        if (id > 0) {
            iCategoriaService.borrarCategoriaById(id);
            flash.addFlashAttribute(DELETE_SUCCESS, DELETE_SUCCESS_MESSAGE);

        } else {
            flash.addFlashAttribute(DELETE_ERROR, DELETE_ERROR_MESSAGE);
        }
        return "redirect:/ventas/categorias/formListarCategorias";
    }

    @GetMapping("/updateCategorias/{id}")
    public String updateCategorias(@PathVariable("id") int id, Model model) {

        Categoria categoria;

        categoria = iCategoriaService.encontrarUnaCategoria(id);

        model.addAttribute("formCategorias", categoria);

        return "ventas/form-categoria";
    }

}
