<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.fernandez_market.Fernandez_Market.Models.*"%>
<%@page import="java.util.*"%>
<%@page import="com.fernandez_market.Fernandez_Market.Controllers.GeneralController"%>
<%@page import ="java.math.BigDecimal" %>

<%
List<Subcategorias> listaSubcategorias = GeneralController.getSubcategorias();
%>


<div class="container-fluid p-0">
    <div class="offcanvas offcanvas-start sub-navbar"  style = "z-index: 10000001 !important;" tabindex="-1" id="offcanvasExample"
        aria-labelledby="offcanvasExampleLabel">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title sub-navbar-title" id="offcanvasExampleLabel">Fernandez Market</h5>
            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="offcanvas-body">
            <div class="row px-0">
                <div class="col-12 py-2 linea-top linea-bottom">
                    <a class="nav-link categories-text" href="/inicio">
                        Inicio 
                    </a>

                </div>
                <div class="col-12 py-2 linea-bottom">
                    <a class="nav-link categories-text" href="/nosotros">
                        Nosotros 
                    </a>
                </div>
                <div class="col-12 py-2 linea-bottom">
                    <a class="nav-link categories-text" href="/sucursales">
                        Sucursales 
                    </a>
                </div>
                <div class="col-12 py-2">
                    <a class="categories-text ps-3" type="button" id="dropdownMenuButton1"
                        data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="fas fa-bars"></i>
                        <p style="display: inline;">Categorias</p>
                    </a>

                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        
                        <c:forEach var="iSubcategoria" items="${listaSubcategorias}" begin = "0" end = "5">
							<li><a class="dropdown-item navbar-categoria-opcion" href="/subcategoria/${iSubcategoria.getTituloSubcategoriaURL()}/1">${iSubcategoria.getTituloSubcategoria()}</a></li>
						</c:forEach>
						<li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item navbar-categoria-opcion" href="/subcategoria/General/1">Ver más</a></li>
                    </ul>
                </div>


            </div>



        </div>


        <div class="row gx-0">
            <div class="col-10 mb-3 ms-3">
                <a class="navbar-brand" href="/inicio"> <img src="/img/Logo.png" alt=""
                        class="w-50">
                </a>
            </div>


        </div>

        <div class="row gx-0">
            <div class="col-2 ms-4 mb-3 col-lg-3 ms-lg-4">
                <a class="link-icon" href="https://www.facebook.com/FernandezCompany" target="_blank">
                    <i class="fab fa-facebook-square"></i>
                </a>
            </div>
            <div class="col-2 mb-3 col-lg-3">
                <a class="link-icon" href="https://twitter.com/FernandezMarket" target="_blank"> <i
                        class="fab fa-twitter-square"></i>
                </a>
            </div>
            <div class="col-2 mb-3 col-lg-3">
                <a class="link-icon" href="https://www.instagram.com/fernandezmarket/?hl=es-la" target="_blank"> <i
                        class="fab fa-instagram-square"></i>
                </a>
            </div>
        </div>

    </div>
</div>