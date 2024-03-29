package com.fernandez_market.Fernandez_Market.Controllers;


import com.fernandez_market.Fernandez_Market.Models.Marcas;
import com.fernandez_market.Fernandez_Market.Models.Promociones;
import com.fernandez_market.Fernandez_Market.Models.Subcategorias;
import com.fernandez_market.Fernandez_Market.Projections.ProductosCardDTO;
import com.fernandez_market.Fernandez_Market.Services.MarcasService;
import com.fernandez_market.Fernandez_Market.Services.ProductosService;
import com.fernandez_market.Fernandez_Market.Services.PromocionesService;
import com.fernandez_market.Fernandez_Market.Services.SubcategoriasService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/inicio")
public class HomeController {

    private final MarcasService marcasService;
    private final PromocionesService promocionesService;
    private final SubcategoriasService subcategoriasService;
    private final ProductosService productosService;

    public HomeController(MarcasService marcasService, PromocionesService promocionesService, SubcategoriasService subcategoriasService, ProductosService productosService) {
        this.marcasService = marcasService;
        this.promocionesService = promocionesService;
        this.subcategoriasService = subcategoriasService;
        this.productosService = productosService;
    }

    @GetMapping()
    public String getHome(Model modelo, HttpServletRequest request){
        List<Marcas> marcas = this.marcasService.getMarcas();
        List<Promociones> promociones = this.promocionesService.getPromociones();
        List<Subcategorias> subcategorias = this.subcategoriasService.getSubcategorias();

        List<ProductosCardDTO> productosMasVendidos = this.productosService.getProductosMasVendidos();
        List<ProductosCardDTO> productosNuevos = this.productosService.getProductosNuevos();

        List<ProductosCardDTO> listaProductosInteres = null;
        if (request.getSession().getAttribute("IdUsuarioActivo") != null){
            long idUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");
            listaProductosInteres = this.productosService.getProductosDeTuInteres(idUsuarioActivo);
        }

        modelo.addAttribute("listaMarcas", marcas);
        modelo.addAttribute("listaPromociones", promociones);
        modelo.addAttribute("listaSubcategoria", subcategorias);
        modelo.addAttribute("listaProductosInteres", listaProductosInteres);
        modelo.addAttribute("listaProductosMasComprados", productosMasVendidos);
        modelo.addAttribute("listaProductosNuevos", productosNuevos);

        return "index";
    }

}
