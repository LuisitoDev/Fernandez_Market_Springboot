<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.fernandez_market.Fernandez_Market.Models.*"%>
<%@page import="com.fernandez_market.Fernandez_Market.Projections.*"%>
<%@page import="java.util.*"%>

<%
String visualizarOnboarding = "true";
pageContext.setAttribute("visualizarOnboarding", visualizarOnboarding);
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>Fernandez Market</title>

    
    
    <link rel="stylesheet" href="/Bootstrap/css/bootstrap.min.css" crossorigin = "anonymous">
	<link rel="stylesheet" href="/css/introjs.css">
    <link rel="stylesheet" href="/css/Autocomplete/jquery-ui.css">
    <link rel="stylesheet" href="/css/Autocomplete/jquery-ui.structure.css">
    <link rel="stylesheet" href="/css/Autocomplete/jquery-ui.theme.css">
    
    

    <link rel="stylesheet" href="/css/owlcarousel/owl.carousel.min.css">
    <link rel="stylesheet" href="/css/owlcarousel/owl.theme.default.min.css">

    <link rel="stylesheet" href="/css/generalStyles.css">
    <link rel="stylesheet" href="/css/widthme.css">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/carouselProductos.css">



   
   
</head>

<body class="page">
   	<header data-position="left" data-intro="Bienvenido a la página de Fernandez Market, si deseas tomar una guia de la página da click en 'Next', si deseas omitir la guia da click en la 'x'"
            class="sticky-top" style="z-index: 10000000">
<!--	<div id="navbarPage" class="navbar-complete"></div> -->
		<c:set var="visualizarOnboarding" value="${visualizarOnboarding}" scope="request"/>
        <div  data-position="left" data-intro="Barra de navegacion, se encuentra en varias paginas para poder navegar más facilmente entre estas">
            <jsp:include page="v_navbar.jsp"></jsp:include>
        </div>
    </header>

	<section>
<!--         <div id = "v_subnavbar"></div> -->
        <jsp:include page="v_subnavbar.jsp"></jsp:include>
        
    </section>
    
    <main>
        <div class="container-fluid p-0">
            <div class="row gx-0 pb-4 linea-bottom">
                <div class="col-12 carousel-ofertas mx-xl-auto">

                    <div class="row gx-0 pt-4 pb-3 pb-xl-4 justify-content-center">

                        <div data-position="center" 
                        data-intro="Carousel de promociones, puedes dar click a los botones laterales para desplazarte, o dar click al centro de la imagen para ver las ofertas" 
                        	id="carouselExampleIndicators"
                             class="carousel carousel-dark carousel-ofertas-imagenes slide col-12 col-lg-9 mx-lg-auto col-xl-8 mx-xl-5"
                            data-bs-touch="false" data-bs-ride="carousel">
                            <div class="carousel-indicators">
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                                    class="bg-dark active" aria-current="true" aria-label="Slide 1">
                                </button>
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                                    class="bg-dark" aria-label="Slide 2"></button>
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                                    class="bg-dark" aria-label="Slide 3"></button>
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="3"
                                    class="bg-dark" aria-label="Slide 3"></button>
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="4"
                                    class="bg-dark" aria-label="Slide 4"></button>
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="5"
                                    class="bg-dark" aria-label="Slide 5"></button>
                                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="6"
                                    class="bg-dark" aria-label="Slide 6"></button>

                            </div>
                            <div class="carousel-inner">
								<c:forEach var="iPromocion" items="${listaPromociones}">
									<div class="carousel-item 
									
                                    <c:if test="${iPromocion.getIdPromocion() == 1}">
                                    active
                                    </c:if>
									" data-bs-interval="10000">
                                    
                                    <a href = "/subcategoria/${iPromocion.getSubcategoria().getTituloSubcategoriaURL()}/1">
                                        <img src="/images/Promocion/${iPromocion.getIdPromocion()}" class="d-block w-100"
                                            alt="...">
                                    </a>
                                </div>

								</c:forEach>

								
                            </div>
                            <button class="carousel-control-prev" type="button"
                                data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon carousel-ofertas-button w-50" aria-hidden="true"></span>
                            </button>
                            <button class="carousel-control-next" type="button"
                                data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                                <span class="carousel-control-next-icon carousel-ofertas-button w-50" aria-hidden="true"></span>
                            </button>
                        </div>

                    </div>
                </div>
            </div>

			<c:if test="${not empty listaProductosInteres}">
                <div data-position="left" 
                data-intro="Carousel de productos que te podrian interesar segun tus compras, puedes dar click en la imagen y el titulo para ver los detalles del producto.">
        	        <div class="row gx-0 mt-4 mb-3">
	                    <div class="carousel-productos-titulo-fondo col-12 py-2 col-md-6 col-lg-4 " align="center">
            	            <h1 class="index-barra-titulo">Te podrian interesar</h1>
                	    </div>
            	    </div>

    <!--             <div id="carouselProductos"></div> -->
	    			<c:set var="listaProductosGenerales" value="${listaProductosInteres}" scope="request"/>
                	<jsp:include page="v_carouselProductos.jsp"></jsp:include>
                </div>
			</c:if>
			
            <div  data-position="left"
                data-intro="Subcategorias de la tienda, puede dar click a las opciones para visualizar los productos de tal subcategoria">
                <div class="row gx-0 mt-4 mb-3">
                    <div class="index-carousel-categorias-titulo-fondo col-12 py-2 col-md-6 col-lg-4 " align="center">
                        <a href="SubcategoriaProductos?IdSubcategoria=0&numeroPagina=1" class="index-barra-titulo-enlace">Subcategorias</a>
                    </div>
                </div>


                <div class="row gx-0">
                    <div class="index-carousel-contenedor col-12 mx-auto pb-md-4">

                        <div class="row gx-0">
                            <div class="col-11 mx-auto pt-3 col-xl-10">
                            
                                <div class="owl-carousel owl-theme categorias-carousel">
                            
                                	<c:forEach var="iSubcategoria" items="${listaSubcategoria}">
            				    		<a href="/subcategoria/${iSubcategoria.getTituloSubcategoriaURL()}/1" class = "carousel-subcategoria-card">
                                        	<div class="card index-carousel-categoria carousel-subcategoria-card">
                                            	<img src="/images/Subcategoria/${iSubcategoria.getIdSubcategoria()}"
                                                	class="card-img-top mx-auto w-100" alt="...">
                                        	    <div class="card-body py-2 px-0 mx-1 py-auto  d-flex align-items-center justify-content-center" align = "center">
                                                	<p class="card-text d-inline my-auto ">${iSubcategoria.getTituloSubcategoria() }</p>
                                            	</div>
                                        	</div>
                                    	</a>        	                    
				    				</c:forEach>
    
                                </div>
            
                            </div>
                        </div>
            
            
                    </div>
                </div>    
            </div>

            <div data-position="left" 
            data-intro="Carousel de productos más comprados por los usuarios, puedes dar click en la imagen y el titulo para ver los detalles del producto.">

                <div class="row gx-0 mt-4 mb-3">
                    <div class="carousel-productos-titulo-fondo col-12 py-2 col-md-6 col-lg-4 " align="center">
                        <h1 class="index-barra-titulo">Productos más comprados</h1>
                    </div>
                </div>
            
<!--             <div id="carouselProductos2"></div> -->
    			<c:set var="listaProductosGenerales" value="${listaProductosMasComprados}" scope="request"/>
                <jsp:include page="v_carouselProductos.jsp"></jsp:include>

            </div>

             <div data-position="left"
                data-intro="Marcas manejadas, puedes dar click a las opciones para visualizar la página web de cada una">
                <div class="row gx-0 mt-4 mb-3">
                    <div class="index-carousel-marcas-titulo-fondo col-12 py-2 col-md-6 col-lg-4 " align="center">
                        <h1 class="index-barra-titulo">Marcas manejadas</h1>
                    </div>
                </div>

                <div class="row gx-0">
                    <div class="index-carousel-contenedor col-12 mx-auto pb-md-4">
            
                        <div class="row gx-0">
                            <div class="col-11 mx-auto pt-3 col-xl-10">
                            
                                <div class="owl-carousel owl-theme marcas-carousel">
            
            		    			<c:forEach var="iMarcas" items="${listaMarcas}">
            						
						    			<a href="${iMarcas.getPaginaMarca()}" class = "carousel-marca-card" target="_blank">
                                        	<div class="card index-carousel-marca carousel-marca-card">
                                            	<img src="/images/Marca/${iMarcas.getIdMarca()}"
                                                	class="card-img-top mx-auto w-100" alt="...">
                                            	<div class="card-body py-2 px-0 mx-auto d-flex align-items-center justify-content-center" align = "center">
	                                                <p class="card-text ">${iMarcas.getNombreMarca()}</p>
        	                                    </div>
            	                            </div>
                	                    </a>
            	                                	                    
			    					</c:forEach>
            
                                </div>
            
                            </div>
                        </div>
            
            
                    </div>
                </div>
            </div>

            
            <div data-position="left" 
            data-intro="Carousel de productos nuevos o que han sido recientemente agregados en almacen, puedes dar click en la imagen y el titulo para ver los detalles del producto.">
                <div class="row gx-0 mt-4 mb-3">
                    <div class="carousel-productos-titulo-fondo col-12 py-2 col-md-6 col-lg-4 " align="center">
                        <h1 class="index-barra-titulo">Productos nuevos</h1>
                    </div>
                </div>

<!--             <div id="carouselProductos3"></div> -->
                <c:set var="listaProductosGenerales" value="${listaProductosNuevos}" scope="request"/>
                <jsp:include page="v_carouselProductos.jsp"></jsp:include>
            </div>

        </div>



    </main>
	<footer>
<!--    <div id="footerPage"></div> -->
    	<jsp:include page="v_footer.jsp"></jsp:include>
	</footer>
</body>


    <%-- <script src="https://kit.fontawesome.com/d253da1760.js" crossorigin="anonymous"></script>
    <script src="/Bootstrap/js/popper.min.js"></script>
    <script src="/Bootstrap/js/bootstrap.min.js"></script>
    <script src="/js/jquery.js"></script>
    <script src="/js/owlcarousel/owl.carousel.min.js"></script>
    <script src="/js/jquery-ui.js"></script>
    <script src="/js/intro.js"></script>

    <script src="/js/mainjquery.js"></script> --%>

 <script src="https://kit.fontawesome.com/d253da1760.js" crossorigin="anonymous"></script>
    <script src = "Bootstrap/js/popper.min.js"></script>
    <script src = "Bootstrap/js/bootstrap.min.js"></script>
    
     <script src="/js/jquery.js"></script>
    <script src="/js/owlcarousel/owl.carousel.min.js"></script>
    <script src="/js/intro.js"></script>
    <script src="/js/owlJquery.js"></script>
    <script src="/js/jquery-ui.js"></script>
    

    <script src="/js/mainjquery.js"></script>
    <script src="/js/autocomplete.js"></script>
    	
</html>