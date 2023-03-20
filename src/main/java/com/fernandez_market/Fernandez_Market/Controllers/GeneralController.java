package com.fernandez_market.Fernandez_Market.Controllers;

import com.fernandez_market.Fernandez_Market.Models.Productos;
import com.fernandez_market.Fernandez_Market.Models.Subcategorias;
import com.fernandez_market.Fernandez_Market.Models.Usuarios;
import com.fernandez_market.Fernandez_Market.Services.SubcategoriasService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class GeneralController {

    private final SubcategoriasService subcategoriasService;

    public GeneralController(SubcategoriasService subcategoriasService) {
        this.subcategoriasService = subcategoriasService;
    }

    public static Usuarios getUsuario(HttpServletRequest request) {
        if (request.getSession().getAttribute("IdUsuarioActivo") == null)
            return null;

        Long idUsuario = (Long) request.getSession().getAttribute("IdUsuarioActivo");
        String url = "http://localhost:8080/api/usuario/" + idUsuario;
        RestTemplate restTemplate = new RestTemplate();
        Usuarios result = restTemplate.getForObject(url, Usuarios.class);

        return result;
    }

    public static List<Subcategorias> getSubcategorias() throws InterruptedException {
        //TODO: QUITAR LO HARDCODEADO DE AQUI
        String url = "http://localhost:8080/api/subcategoria";
        RestTemplate restTemplate = new RestTemplate();
        List<Subcategorias> result = List.of(Objects.requireNonNull(restTemplate.getForObject(url, Subcategorias[].class)));

        return result;
    }

    public static int getCantidadProductosCarrito(HttpServletRequest request) {
        int cantidadProductosCarrito = 0;

        List<Productos> listaProductosCarrito = (List<Productos>)request.getSession().getAttribute("carritoProductos");

        if (listaProductosCarrito != null)
            cantidadProductosCarrito = listaProductosCarrito.size();

        return cantidadProductosCarrito;
    }
}
