<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.fernandez_market.Fernandez_Market.Models.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fernandez_market.Fernandez_Market.Controllers.GeneralController"%>
<%@page import="com.fernandez_market.Fernandez_Market.Utils.PreciosUtils"%>
<%@page import ="java.math.BigDecimal" %>


<%

%>

<div class="row gx-0">
    <div class="carousel-productos-contenedor col-12 mx-auto">

        <div class="row gx-0">
            <div class="col-11 mx-auto pt-3 col-xl-10">
                <!--          d-flex align-items-stretch-->
                <div class="owl-carousel owl-theme carousel-productos" id="productos">

                    
                    <c:forEach var="iProducto" items="${listaProductosGenerales}">
            			<div class="carousel-producto-card">
                        	<a href="DetallesProducto?IdProducto=${iProducto.getIdProducto()}">
                            	<img src="/images/Producto/${iProducto.getIdProducto()}" class="carousel-producto-imagen" alt="...">
                        	</a>

                        	<div class="card-body card-producto-texto">

                            	<a class="carousel-producto-titulo" href="DetallesProducto?IdProducto=${iProducto.getIdProducto()}">${iProducto.getNombreProducto()}</a> 
                            	<br>
								 
                            
								<div class="carousel-producto-marca-contenedor">
                            		<p class="carousel-producto-marca-label">Marca: </p>
                            		<p class="carousel-producto-marca">${iProducto.getMarcaProductoTexto()}</p>
                            	</div>
								
								<div class="carousel-producto-precio">
                            		<c:if test="${iProducto.getDescuentoProducto().compareTo(BigDecimal.ZERO) == 1}">
                                		<h5 class="carousel-producto-precio-anterior">
                                			$ ${iProducto.getPrecioProducto()}
                                		</h5>
                                	</c:if>
                                	
                                	<h5 class="carousel-producto-precio-final">$ ${PreciosUtils.getPrecioFinalProducto(iProducto.getPrecioProducto(), iProducto.getDescuentoProducto())}</h5>
                                	
                                	<c:if test="${iProducto.getDescuentoProducto().compareTo(BigDecimal.ZERO) == 1}">
                                		<h5 class="carousel-producto-precio-rebajado">
                                			Ahorra ${PreciosUtils.getProcentajeDescuentoProducto(iProducto.getDescuentoProducto())}%
                                		</h5>
                                	</c:if>	
                                	
                            	</div>
                            
                    	    </div>
                    	</div>      	                    
					</c:forEach>
                    
                </div>

            </div>
        </div>


    </div>
</div>