package com.tito.apptito.controllers.ventas;

import com.tito.apptito.entities.ventas.Producto;
import com.tito.apptito.services.ventas.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/ventas/productos")
public class ProductoController {

    public static final String REDIRECT_FORMULARIO = "redirect:/ventas/productos/formProductos";
    public static final String DELETE_SUCCESS = "Éxito";
    public static final String DELETE_SUCCESS_MESSAGE = "El producto fue eliminado";
    public static final String DELETE_ERROR = "Error";
    public static final String DELETE_ERROR_MESSAGE = "Problemas al eliminar el producto";

    @Autowired
    private IProductoService iProductoService;

    @GetMapping("/formProductos")
    public String formProductos(Model model){

        model.addAttribute("formProductos", new Producto());
        return  "ventas/form-producto";

    }

    @GetMapping("/formListarProductos")
    public String formListaDeProductos (Model model){

        model.addAttribute("listaproductos", iProductoService.listarTodosLosProductos());
        return  "ventas/form-lista_producto";

    }

    @PostMapping("/grabarProductos")
    public String grabarProductos(@Validated @ModelAttribute("formProductos") Producto producto,
                                   BindingResult bindingResult, RedirectAttributes flash){
        if (bindingResult.hasErrors()){
            flash.addFlashAttribute("Error", "Problemas al agregar el producto");
            return "ventas/form-producto";
        } else {
            iProductoService.grabarProducto(producto);
            flash.addFlashAttribute("success", "Producto agregado con éxito");
            return REDIRECT_FORMULARIO;
        }
    }

    @GetMapping("/deleteProductos/{id}")
    public String deleteProductos(@PathVariable("id") int id, RedirectAttributes flash){
        if (id > 0) {
            iProductoService.borrarProductoById(id);
            flash.addFlashAttribute(DELETE_SUCCESS, DELETE_SUCCESS_MESSAGE);

        } else {
            flash.addFlashAttribute(DELETE_ERROR, DELETE_ERROR_MESSAGE);
        }
        return "redirect:/ventas/productos/formListarProductos";
    }

    @GetMapping("/updateProductos/{id}")
    public String updateProductos(@PathVariable("id") int id, Model model) {

        Producto producto;

        producto = iProductoService.encontrarUnProducto(id);

        model.addAttribute("formProductos", producto);

        return "ventas/form-producto";
    }
}
