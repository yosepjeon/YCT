    <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width,initial-scale=1">
            <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
            <meta name="author" content="Coderthemes">
            <%@include file="../include/header.jsp" %>
        
            <link rel="shortcut icon" href="assets/images/favicon.ico">

            <title>Minton - Responsive Admin Dashboard Template</title>

            <link href="${path }/resources/bootstrap-minton/plugins/switchery/switchery.min.css" rel="stylesheet" />

            <link href="${path }/resources/bootstrap-minton/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
            <link href="${path }/resources/bootstrap-minton/assets/css/icons.css" rel="stylesheet" type="text/css">
            <link href="${path }/resources/bootstrap-minton/assets/css/style.css" rel="stylesheet" type="text/css">

            <script src="${path }/resources/bootstrap-minton/assets/js/modernizr.min.js"></script>

        </head>
        <body>

            <div class="wrapper-page">

                <div class="text-center">
                    <a href="index.html" class="logo-lg"><i class="mdi mdi-radar"></i> <span>YCT</span> </a>
                </div>

                <form class="form-horizontal m-t-20" method="POST" action="${path}/user/loginCheck">

                    <div class="form-group row">
                        <div class="col-12">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="mdi mdi-account"></i></span>
                                </div>
                                <input name="userId" class="form-control" type="text" required="" placeholder="Username">
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-12">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="mdi mdi-key"></i></span>
                                </div>
                                <input name="userPassword" class="form-control" type="password" required="" placeholder="Password">
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-12">
                            <div class="checkbox checkbox-primary">
                                <input id="checkbox-signup" type="checkbox">
                                <label for="checkbox-signup">
                                    Remember me
                                </label>
                            </div>
                        </div>
                        
                        <c:if test="${login == 'fail'}">
                            <div class="col-12">
                            <h4 class="text-danger">아이디 혹은 비밀번호가 일치하지 않습니다.</h4>           
                            </div>
                        </c:if>
                    </div>

                    <div class="form-group text-right m-t-20">
                        <div class="col-xs-12">
                            <button class="btn btn-primary btn-custom w-md waves-effect waves-light" type="submit">Log In
                            </button>
                        </div>
                    </div>

                    <div class="form-group row m-t-30">
                        <div class="col-sm-7">
                            <a href="pages-recoverpw.html" class="text-muted"><i class="fa fa-lock m-r-5"></i> Forgot your
                                password?</a>
                        </div>
                        <div class="col-sm-5 text-right">
                            <a href="${path}/user/goToRegister" class="text-muted">Create an account</a>
                        </div>
                    </div>
                </form>
            </div>


            <script>
                var resizefunc = [];
            </script>

            <!-- Plugins  -->
            <script src="${path }/resources/bootstrap-minton/assets/js/jquery.min.js"></script>
            <script src="${path }/resources/bootstrap-minton/assets/js/popper.min.js"></script><!-- Popper for Bootstrap -->
            <script src="${path }/resources/bootstrap-minton/assets/js/bootstrap.min.js"></script>
            <script src="${path }/resources/bootstrap-minton/assets/js/detect.js"></script>
            <script src="${path }/resources/bootstrap-minton/assets/js/fastclick.js"></script>
            <script src="${path }/resources/bootstrap-minton/assets/js/jquery.slimscroll.js"></script>
            <script src="${path }/resources/bootstrap-minton/assets/js/jquery.blockUI.js"></script>
            <script src="${path }/resources/bootstrap-minton/assets/js/waves.js"></script>
            <script src="${path }/resources/bootstrap-minton/assets/js/wow.min.js"></script>
            <script src="${path }/resources/bootstrap-minton/assets/js/jquery.nicescroll.js"></script>
            <script src="${path }/resources/bootstrap-minton/assets/js/jquery.scrollTo.min.js"></script>
            <script src="${path }/resources/bootstrap-minton/plugins/switchery/switchery.min.js"></script>

            <!-- Custom main Js -->
            <script src="${path }/resources/bootstrap-minton/assets/js/jquery.core.js"></script>
            <script src="${path }/resources/bootstrap-minton/assets/js/jquery.app.js"></script>
        
        </body>
    </html>