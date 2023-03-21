package com.fernandez_market.Fernandez_Market.Controllers;

import com.fernandez_market.Fernandez_Market.Models.Subcategorias;
import com.fernandez_market.Fernandez_Market.Projections.ProductosCardDTO;
import com.fernandez_market.Fernandez_Market.Projections.SubcategoryCTO;
import com.fernandez_market.Fernandez_Market.Services.ProductosService;
import com.fernandez_market.Fernandez_Market.Services.SubcategoriasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/subcategoria")
public class SubcategoriaController {

    private final SubcategoriasService subcategoriasService;
    private final ProductosService productosService;

    public SubcategoriaController(SubcategoriasService subcategoriasService, ProductosService productosService) {
        this.subcategoriasService = subcategoriasService;
        this.productosService = productosService;
    }

    @GetMapping(value = {"/{nombreSubcategoria}/{pagina}", "/{nombreSubcategoria}/{pagina}/{nombreProducto}"} )
    public String getSubcategoryPage(Model modelo, @PathVariable("nombreSubcategoria") String nombreSubcategoria, @PathVariable("pagina") int numeroPagina, @PathVariable(value = "nombreProducto", required = false) String nombreProducto) throws Exception {

        nombreSubcategoria = nombreSubcategoria.replace('-', ' ');

        if (numeroPagina <= 0)
            numeroPagina = 0;

        int idSubcategoria = 0;

        List<Subcategorias> listaSubcategorias = this.subcategoriasService.getSubcategorias();
        Subcategorias subcategoriaElegida = null;
        if (!nombreSubcategoria.equals("General")) {
            for (Subcategorias iSubcategoria : listaSubcategorias) {
                if (Objects.equals(iSubcategoria.getTituloSubcategoria(), nombreSubcategoria)) {
                    subcategoriaElegida = iSubcategoria;
                    idSubcategoria = iSubcategoria.getIdSubcategoria();
                    break;
                }
            }

            if (subcategoriaElegida == null) {
                modelo.addAttribute("error", "Subcategoria no encontrada");
                return "error";
            }
        }



        List<ProductosCardDTO> listaProductos = this.productosService.getProductosBySubcategoriaNombrePagina(idSubcategoria, nombreProducto, numeroPagina, 12);


        modelo.addAttribute("listaSubcategorias", listaSubcategorias);
        modelo.addAttribute("subcategoriaElegida", subcategoriaElegida);
        modelo.addAttribute("listaProductos", listaProductos);


        SubcategoryCTO subcategoriasFiltro = this.subcategoriasService.getSubcategoriasByIdNombreProducto(idSubcategoria, nombreProducto);

        int CantidadProductos = 0;

        if (subcategoriasFiltro != null)
            CantidadProductos = subcategoriasFiltro.getCantidadProductos();

        int idBoton = 0;
        int paginaFinal = CantidadProductos/12;

        if (CantidadProductos % 12 != 0)
            paginaFinal+=1;

        int CantidadBotones = 4;

        if (CantidadBotones > paginaFinal) {
            CantidadBotones = paginaFinal;
        }

        if ((numeroPagina + CantidadBotones - 1) >= paginaFinal) {
            idBoton = paginaFinal - CantidadBotones + 1;
        }
        else {
            idBoton = numeroPagina;
        }

        modelo.addAttribute("paginaFinal", paginaFinal);
        modelo.addAttribute("idBoton", idBoton);
        modelo.addAttribute("CantidadBotones", CantidadBotones);
        modelo.addAttribute("numeroPagina", numeroPagina);
        modelo.addAttribute("nombreProducto", nombreProducto);

        if (nombreProducto != null)
            modelo.addAttribute("nombreProductoQuery", "/" + nombreProducto);


        return "subcategoryProducts";
    }


}
