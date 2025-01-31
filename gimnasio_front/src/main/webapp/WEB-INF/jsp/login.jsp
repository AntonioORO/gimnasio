<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <title>GOLD Temper</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="description" content="#">
    <meta name="keywords"
        content="Admin , Responsive, Landing, Bootstrap, App, Template, Mobile, iOS, Android, apple, creative app">
    <meta name="author" content="#">
    <!-- Favicon icon -->
     <!-- Required Fremwork -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- themify-icons line icon -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/icon/themify-icons/themify-icons.css">
    <!-- ico font -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/icon/ico-font/css/icofont.css">
    <!-- Style.css -->
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/css/style.css">
</head>

    <section class="login-block">
        <!-- Container-fluid starts -->
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <!-- Authentication card start -->

                    <form  method="POST" action="${contextPath}/iniciarSesion" class="md-float-material form-material">
                        
                        <div class="auth-box card">
                            <div class="card-block">
                            
                                <div class="row m-b-20">
                                    <div class="col-md-12">
                                      <h3 class="text-center">Login</h3>
                                    </div>
                                </div>
                                <div class="mb-3 form-primary">
                                    <input type="text" name="nick" class="form-control" required=""
                                        placeholder="Nick">
                                    <span class="form-bar"></span>
                                </div>
                                <div class="mb-3 form-primary">
                                    <input type="password" name="password" class="form-control" required=""
                                        placeholder="Password">
                                    <span class="form-bar"></span>
                                </div>
                                <div class="row m-t-25 text-start">
                                </div>
                                <div class="row m-t-30">
                                    <div class="col-md-12">
                                        <div class="d-grid">
                                            <button type="submit" class="btn btn-primary btn-md waves-effect waves-light text-center m-b-20">
                                                Iniciar sesión
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>
                        </div>
                    </form>
                    <!-- end of form -->
                </div>
                <!-- end of col-sm-12 -->
            </div>
            <!-- end of row -->
        </div>
        <!-- end of container-fluid -->
    </section>
  
    <script type="text/javascript" src="${contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="${contextPath}/bower_components/jquery-ui/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${contextPath}/bower_components/popper.js/dist/umd/popper.min.js"></script>
    <script type="text/javascript" src="${contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- jquery slimscroll js -->
    <script type="text/javascript" src="${contextPath}/bower_components/jquery-slimscroll/jquery.slimscroll.js"></script>
    <!-- modernizr js -->
    <script type="text/javascript" src="${contextPath}/bower_components/modernizr/modernizr.js"></script>
    <script type="text/javascript" src="${contextPath}/bower_components/modernizr/feature-detects/css-scrollbars.js"></script>
    <!-- i18next.min.js -->
    <script type="text/javascript" src="${contextPath}/bower_components/i18next/i18next.min.js"></script>
    <script type="text/javascript"
        src="${contextPath}/bower_components/i18next-xhr-backend/i18nextXHRBackend.min.js"></script>
    <script type="text/javascript"
        src="${contextPath}/bower_components/i18next-browser-languagedetector/i18nextBrowserLanguageDetector.min.js"></script>
    <script type="text/javascript" src="${contextPath}/bower_components/jquery-i18next/jquery-i18next.min.js"></script>
    <script type="text/javascript" src="${contextPath}/assets/js/common-pages.js"></script>
</body>

</html>