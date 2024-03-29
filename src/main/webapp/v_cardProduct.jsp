<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.fernandez_market.Fernandez_Market.Models.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fernandez_market.Fernandez_Market.Controllers.GeneralController"%>
<%@page import ="java.math.BigDecimal" %>
<%@page import="com.fernandez_market.Fernandez_Market.Utils.PreciosUtils"%>

<%
%>

<div class="subcategorias-producto-card mx-3">

    
    <a href="/producto/${iProducto.getIdProducto()}" class = "subcategorias-producto-enlace">
        <div class="row gx-0 subcategorias-producto-imagen_precio">
            <div class="col-6">
                <img src="/images/Producto/${iProducto.getIdProducto()}" class="w-100" alt="...">
            </div>


            <div class="col-5">
                <div class="row">
                    <div class="col-12">
                    	<c:if test="${iProducto.getDescuentoProducto().compareTo(BigDecimal.ZERO) == 1}">
                        	<h5 class="subcategorias-producto-precio-anterior">$ ${iProducto.getPrecioProducto()}</h5>
                        </c:if>
                        
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <h5 class="subcategorias-producto-precio-final" descuento = "${iProducto.getDescuentoProducto()}">$ ${PreciosUtils.getPrecioFinalProducto(iProducto.getPrecioProducto(), iProducto.getDescuentoProducto())}</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                    	<c:if test="${iProducto.getDescuentoProducto().compareTo(BigDecimal.ZERO) == 1}">
                        	<h5 class="subcategorias-producto-precio-rebajado">Ahorra ${PreciosUtils.getProcentajeDescuentoProducto(iProducto.getDescuentoProducto())}%</h5>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </a>

    <div class="row">
        <div class="col-12">
            <div class="card-body subcategorias-card-producto-texto">

                <a class="subcategorias-producto-titulo" href="/producto/${iProducto.getIdProducto()}">${iProducto.getNombreProducto()}</a>
                <br>
                <div class="subcategorias-producto-marca-container">
                    <p class="subcategorias-producto-marca-label">Marca: </p>
                    <p class="subcategorias-producto-marca">${iProducto.getMarcaProductoTexto()}</p>
                </div>

            </div>
        </div>
    </div>

</div>