<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.aoro.gimnasio.model.UsuarioVo" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<% UsuarioVo usuario =(UsuarioVo) session.getAttribute("user");%>
<html lang="en">

<head>
    <title>Gim Admin</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="description" content="#">
    <meta name="keywords"
        content="Admin , Responsive, Landing, Bootstrap, App, Template, Mobile, iOS, Android, apple, creative app">
    <meta name="author" content="#">
    <!-- Favicon icon -->
    <link rel="icon" href="${contextPath}/assets/images/favicon.ico" type="image/x-icon">
    <!-- Google font-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600" rel="stylesheet">
    <!-- Required Fremwork -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- feather Awesome -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/icon/feather/css/feather.css">
    <!-- Style.css -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/css/style.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/css/jquery.mCustomScrollbar.css">
     <!-- Chartlist chart css -->
    <link rel="stylesheet" href="${contextPath}/bower_components/chartist/dist/chartist.css" type="text/css" media="all">
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/icon/font-awesome/css/font-awesome.min.css">
   
     <!-- Data Table Css -->
    <!-- <link rel="stylesheet" type="text/css" href="${contextPath}/assets/pages/data-table/css/jquery.dataTables.min.css"> -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/bower_components/datatables.net-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/pages/data-table/css/buttons.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/bower_components/datatables.net-responsive-bs4/css/responsive.bootstrap4.min.css">



    <!-- themify-icons line icon -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/icon/themify-icons/themify-icons.css">

    <!-- ico font -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/icon/icofont/css/icofont.css">
    <!-- Style.css -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/css/style.css">
 	<!-- seetalert.css -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/css/sweetalert.css">
</head>

<body>

    <div id="preloader" style="display:none;background-color: black;opacity: 0.6;width:100%;height:100%;position:absolute;z-index:100 !important;margin-left:0px;margin-top:0px">
            <div class="loader-block" style="position:absolute;top:30%;left:52%">
                <svg id="loader2" viewBox="0 0 100 100">
                 <circle id="circle-loader2" cx="50" cy="50" r="45"></circle>
                </svg>
            </div>
     </div>
     
    <!-- Pre-loader start -->
    <div class="theme-loader">
        <div class="ball-scale">
            <div class='contain'>
                <div class="ring">
                    <div class="frame"></div>
                </div>
                <div class="ring">
                    <div class="frame"></div>
                </div>
                <div class="ring">
                    <div class="frame"></div>
                </div>
                <div class="ring">
                    <div class="frame"></div>
                </div>
                <div class="ring">
                    <div class="frame"></div>
                </div>
                <div class="ring">
                    <div class="frame"></div>
                </div>
                <div class="ring">
                    <div class="frame"></div>
                </div>
                <div class="ring">
                    <div class="frame"></div>
                </div>
                <div class="ring">
                    <div class="frame"></div>
                </div>
                <div class="ring">
                    <div class="frame"></div>
                </div>
            </div>
        </div>
    </div>
    <!-- Pre-loader end -->
    <div id="pcoded" class="pcoded">
        <div class="pcoded-overlay-box"></div>
        <div class="pcoded-container navbar-wrapper">

            <nav class="navbar header-navbar pcoded-header">
                <div class="navbar-wrapper">

                    <div class="navbar-logo">
                        <a class="mobile-menu" id="mobile-collapse" href="#!">
                            <i class="feather icon-menu"></i>
                        </a>
                        <a href="index.html">
                            <img class="img-fluid" src="${contextPath}/assets/images/logo.jpeg" alt="Theme-Logo"  width="50" height="50" />   <label class="text-muted m-b-0">Gold Temper Gym</label>
                        </a>
                        <a class="mobile-options">
                            <i class="feather icon-more-horizontal"></i>
                        </a>
                    </div>

                    <div class="navbar-container">
                        <ul class="nav-left">
                            <li class="header-search">
                                <div class="main-search morphsearch-search">
                                    <div class="input-group">
                                        <span class="input-group-prepend search-close">
                                        <i class="feather icon-x input-group-text"></i>
                                    </span>
                                        <input type="text" class="form-control" placeholder="Enter Keyword">
                                        <span class="input-group-append search-btn">
                                        <i class="feather icon-search input-group-text"></i>
                                    </span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <a href="#!" onclick="javascript:toggleFullScreen()" class="waves-effect waves-light">
                                <i class="full-screen feather icon-maximize"></i>
                            </a>
                            </li>
                        </ul>
                        <ul class="nav-right">
                            <li class="header-notification">
                                <div class="dropdown-primary dropdown">
                                    <div class="dropdown-toggle" data-bs-toggle="dropdown">
                                        <i class="feather icon-bell"></i>
                                        <span class="badge bg-c-pink">1</span>
                                    </div>
                                    <ul class="show-notification notification-view dropdown-menu"
                                        data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">
                                        <li>
                                            <h6>Notificaciones</h6>
                                            <label class="form-label label label-danger">New</label>
                                        </li>
                                       
                                       
                                        <li>
                                            <div class="d-flex">
                                                <div class="flex-shrink-0">
                                                    <img class="d-flex align-self-center img-radius"
                                                        src="${contextPath}/assets/images/avatar-3.jpg"
                                                        alt="Generic placeholder image">
                                                </div>
                                                <div class="flex-grow-1">
                                                    <h5 class="notification-user">Sistema</h5>
                                                    <p class="notification-msg">Tiene productos a vencer, adquiera mas</p>
                                                    <span class="notification-time">30 minutes ago</span>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                           
                            <li class="user-profile header-notification">
                                <div class="dropdown-primary dropdown">
                                    <div class="dropdown-toggle" data-bs-toggle="dropdown">
                                        <img src="<%= usuario.getImg() %>" class="img-radius"
                                            alt="User-Profile-Image">
                                        <span><%= usuario.getNombre()+" "+usuario.getApaterno()+" "+usuario.getAmaterno()%></span>
                                        <i class="feather icon-chevron-down"></i>
                                    </div>
                                    <ul class="show-notification profile-notification dropdown-menu"
                                        data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">
                                        <li>
                                            <a href="#!">
                                                <i class="feather icon-settings"></i> Configuración
                                            </a>
                                        </li>
                                        <li>
                                            <a href="user-profile.html">
                                                <i class="feather icon-user"></i> Perfil
                                            </a>
                                        </li>
                                        <li>
                                            <a href="email-inbox.html">
                                                <i class="feather icon-mail"></i> Mis mensajes
                                            </a>
                                        </li>
                                        <li>
                                            <a href="auth-lock-screen.html">
                                                <i class="feather icon-lock"></i> Bloquear pantalla
                                            </a>
                                        </li>
                                        <li>
                                           <a href="/cerrarSession">
                                                <i class="feather icon-log-out"></i> Salir
                                            </a>
                                        </li>
                                    </ul>

                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

           
            <!-- Sidebar inner chat start-->
            <div class="showChat_inner">
                <div class="media chat-inner-header">
                    <a class="back_chatBox">
                        <i class="feather icon-chevron-left"></i> Josephin Doe
                    </a>
                </div>
                <div class="d-flex chat-messages">
                    <div class="flex-shrink-0">
                        <a class="media-left photo-table" href="#!">
                            <img class="media-object img-radius img-radius m-t-5" src="${contextPath}/assets/images/avatar-3.jpg"
                                alt="Generic placeholder image">
                        </a>
                    </div>
                    <div class="flex-grow-1 chat-menu-content">
                        <div class="">
                            <p class="chat-cont">I'm just looking around. Will you tell me something about yourself?</p>
                            <p class="chat-time">8:20 a.m.</p>
                        </div>
                    </div>
                </div>
                <div class="d-flex chat-messages">
                    <div class="flex-grow-1 chat-menu-reply">
                        <div class="">
                            <p class="chat-cont">I'm just looking around. Will you tell me something about yourself?</p>
                            <p class="chat-time">8:20 a.m.</p>
                        </div>
                    </div>
                    <div class="flex-shrink-0">
                        <div class="media-right photo-table">
                            <a href="#!">
                                <img class="media-object img-radius img-radius m-t-5"
                                    src="${contextPath}/assets/images/avatar-4.jpg" alt="Generic placeholder image">
                            </a>
                        </div>
                    </div>
                </div>
                <div class="chat-reply-box p-b-20">
                    <div class="right-icon-control">
                        <input type="text" class="form-control search-text" placeholder="Share Your Thoughts">
                        <div class="form-icon">
                            <i class="feather icon-navigation"></i>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Sidebar inner chat end-->
            <div class="pcoded-main-container">
                <div class="pcoded-wrapper">
                    <nav class="pcoded-navbar">
                        <div class="pcoded-inner-navbar main-menu">
                            <div class="pcoded-navigatio-lavel">Navigation</div>
                            <ul class="pcoded-item pcoded-left-item">
                                <li class="pcoded-hasmenu active pcoded-trigger">
                                    <a href="javascript:void(0)">
                                        <span class="pcoded-micon"><i class="feather icon-home"></i></span>
                                        <span class="pcoded-mtext">Dashboard</span>
                                    </a>
                                    <ul class="pcoded-submenu">
                                        <li class="active">
                                            <a href="index.html">
                                                <span class="pcoded-mtext">Administrador</span>
                                            </a>
                                        </li>
                                        <li class="">
                                            <a href="venta.html">
                                                <span class="pcoded-mtext">Venta</span>
                                            </a>
                                        </li>
                                        
                                    </ul>
                                </li>
                            </ul>
                              <ul class="pcoded-item pcoded-left-item">
                                <li class="pcoded-hasmenu">
                                    <a href="javascript:void(0)">
                                        <span class="pcoded-micon"><i class="feather icon-box"></i></span>
                                        <span class="pcoded-mtext">Catálogos</span>
                                    </a>
                                    <ul class="pcoded-submenu">
                                        <li class=" ">
                                            <a href="mensualidad.html">
                                                <span class="pcoded-mtext">Mebresia</span>
                                            </a>
                                        </li>
                                         <li class=" ">
                                            <a onclick="catalogoProductosIndex()">
                                                <span class="pcoded-mtext">Productos</span>
                                            </a>
                                        </li>
                                        <li class=" ">
                                            <a href="socios.html">
                                                <span class="pcoded-mtext">Socios</span>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                
                                
                            </ul>
                           
                        </div>
                    </nav>
                    <div class="pcoded-content">
                        <div class="pcoded-inner-content">
                            <div class="main-body">
                            <div class="alert alert-dismissible alert-danger background-danger" style="position:absolute;width:99%; height:60px;display:none" id="alertError">
						               <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						               <strong>Atención!</strong> <span id="msgDialogError">Los campos marcados con * son obligatorios.</span>
						     </div>
                                <div class="page-wrapper" id="contDinamico">
                                 
                                </div>
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
  
     <!-- Warning Section Ends -->
    <!-- Required Jquery -->
    <script type="text/javascript" src="${contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="${contextPath}/bower_components/jquery-ui/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${contextPath}/bower_components/popper.js/dist/umd/popper.min.js"></script>
    <script type="text/javascript" src="${contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- jquery slimscroll js -->
    <script type="text/javascript" src="${contextPath}/bower_components/jquery-slimscroll/jquery.slimscroll.js"></script>
    <!-- modernizr js -->
    <script type="text/javascript" src="${contextPath}/bower_components/modernizr/modernizr.js"></script>
    <script type="text/javascript" src="${contextPath}/bower_components/modernizr/feature-detects/css-scrollbars.js"></script>

    <!-- data-table js -->
    <script src="${contextPath}/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="${contextPath}/bower_components/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="${contextPath}/bower_components/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="${contextPath}/bower_components/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="${contextPath}/assets/pages/data-table/js/dataTables.bootstrap4.min.js"></script>
    <script src="${contextPath}/bower_components/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="${contextPath}/bower_components/datatables.net-responsive-bs4/js/responsive.bootstrap4.min.js"></script>
    <!-- i18next.min.js -->
    <script type="text/javascript" src="${contextPath}/bower_components/i18next/i18next.min.js"></script>
    </script>
    <script type="text/javascript"
        src="${contextPath}/bower_components/i18next-xhr-backend/i18nextXHRBackend.min.js"></script>
    <script type="text/javascript"
        src="${contextPath}/bower_components/i18next-browser-languagedetector/i18nextBrowserLanguageDetector.min.js"></script>
    <script type="text/javascript" src="${contextPath}/bower_components/jquery-i18next/jquery-i18next.min.js"></script>
    <!-- Custom js -->
    <script src="${contextPath}/assets/pages/data-table/js/data-table-custom.js"></script>

    <script src="${contextPath}/assets/js/pcoded.min.js"></script>
    <script src="${contextPath}/assets/js/vartical-layout.min.js"></script>
    <script src="${contextPath}/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="${contextPath}/assets/js/sweetalert.js"></script>
    
    <script type="text/javascript" src="${contextPath}/assets/js/script.js"></script>

    <script>
 
    
    if (this.current = this.imgsLen - 1) {
        $(':button:contains("previous")').attr('disabled', 'disabled');
    }
    
    function catalogoProductosIndex(){
        preload();
        $.ajax({
            url: '${contextPath}/catalogoProductos',
            type: 'GET',
            dataType: "html",
            success: function (response) {
                 $("#contDinamico").html(response);
                 postload();
            },
            error: function () {
                postload();
            }
        }); 
        
    }
    
    
    function preload(){
         $("#preloader").show();
       }
    function postload(){
         $("#preloader").hide();
       }
    
    function onlyNumbers(evt) {
    	  var theEvent = evt || window.event;

    	  // Handle paste
    	  if (theEvent.type === 'paste') {
    	      key = event.clipboardData.getData('text/plain');
    	  } else {
    	  // Handle key press
    	      var key = theEvent.keyCode || theEvent.which;
    	      key = String.fromCharCode(key);
    	  }
    	  var regex = /[0-9]/;
    	  if( !regex.test(key) ) {
    	    theEvent.returnValue = false;
    	    if(theEvent.preventDefault) theEvent.preventDefault();
    	  }
    	}
    function precios(evt) {
    	  var theEvent = evt || window.event;

    	  // Handle paste
    	  if (theEvent.type === 'paste') {
    	      key = event.clipboardData.getData('text/plain');
    	  } else {
    	  // Handle key press
    	      var key = theEvent.keyCode || theEvent.which;
    	      key = String.fromCharCode(key);
    	  }
    	  var regex = /[0-9]|\./;
    	  if( !regex.test(key) ) {
    	    theEvent.returnValue = false;
    	    if(theEvent.preventDefault) theEvent.preventDefault();
    	  }
    	}
    function alertError(texto){
    	$('#alertError').show();
    	$('#alertError').fadeOut(5000);
    	$('#msgDialogError').text(texto);
    	
    }
    
    document.body.style.zoom="90%";
       
    </script>

</body>

</html>