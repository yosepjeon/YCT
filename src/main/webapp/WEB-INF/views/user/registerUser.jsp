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
        
            <link rel="shortcut icon" href="${path }/resources/bootstrap-minton/assets/images/favicon.ico">

            <title>Minton - Responsive Admin Dashboard Template</title>

            <link href="${path }/resources/bootstrap-minton/plugins/switchery/switchery.min.css" rel="stylesheet" />
            <link rel="stylesheet" href="${path }/resources/bootstrap-minton/plugins/morris/morris.css">

            <link href="${path }/resources/bootstrap-minton/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
            <link href="${path }/resources/bootstrap-minton/assets/css/icons.css" rel="stylesheet" type="text/css">
            <link href="${path }/resources/bootstrap-minton/assets/css/style.css" rel="stylesheet" type="text/css">

            <script src="${path }/resources/bootstrap-minton/assets/js/modernizr.min.js"></script>
        </head>
        <body>

            <div class="wrapper-page">

                <div class="text-center">
                    <a href="index.html" class="logo-lg"><i class="mdi mdi-radar"></i> <span>Minton</span> </a>
                </div>

                <form id="registerForm" enctype="multipart/form-data" class="form-horizontal m-t-20" method="POST" action="${path}/user/registerUser">

                    <div class="form-group row">
                        <div class="col-8">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="mdi mdi-account"></i></span>
                                </div>
                                <input class="form-control" type="text" required="" id="userId" name="userId" placeholder="아이디">
                                <input id="isCheckId" type="hidden" value="unChecked">
                            </div>
                        </div>
                        <div class="col-4">
                                <button id="checkSameId" class="btn btn-primary btn-custom waves-effect waves-light w-md" type="button">중복 체크</button>
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-12">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="mdi mdi-key"></i></span>
                                </div>
                                <input class="form-control" type="password" required="" name="userPassword" placeholder="비밀번호">
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-12">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="mdi mdi-account"></i></span>
                                </div>
                                <input class="form-control" type="text" required="" name="userName" placeholder="이름">
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="col-12">
                            <div class="col-6">
                                    <div class="radio radio-primary">
                                            <input type="radio" name="gender" id="male" value="m">
                                            <label for="male">
                                                Male
                                            </label>
                                    </div>
                            </div>
                            <div class="col-6">
                                    <div class="radio radio-pink">
                                            <input type="radio" name="gender" id="female" value="f">
                                            <label for="female">
                                                Female
                                            </label>
                                    </div>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                            <div class="col-12">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="mdi mdi-cellphone-iphone"></i></span>
                                    </div>
                                    <input class="form-control" type="text" required="" name="phoneNum" placeholder="핸드폰 번호">
                                </div>
                            </div>
                        </div>

                    <div class="form-group row">
                        <div class="col-12">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="mdi mdi-email"></i></span>
                                </div>
                                <input class="form-control" type="email" required="" name="userEmail" placeholder="이메일">
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                            <div class="col-12">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="mdi mdi-home"></i></span>
                                    </div>
                                    <input class="form-control" type="text" required="" name="userAddr" placeholder="주소">
                                </div>
                            </div>
                        </div>
                    
                        <div class="form-group row">
                                <div class="col-12">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="mdi mdi-at"></i></span>
                                        </div>
                                        <input class="form-control" type="text" required="" name="deptName" placeholder="부서명">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group row">
                                    <div class="col-12">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="mdi mdi-account-edit"></i></span>
                                            </div>
                                            <input class="form-control" type="text" required="" name="position" placeholder="직급">
                                        </div>
                                    </div>
                                </div>
                            <div class="form-group row">
                                    <div class="col-12">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="mdi mdi-file-account"></i></span>
                                            </div>
                                            <input type="file" name="profileImg">
                                        </div>
                                </div>
                            </div>
                    <div class="form-group row">
                        <div class="col-12">
                            <div class="checkbox checkbox-primary">
                                <input id="checkbox-signup" type="checkbox" checked="checked">
                                <label for="checkbox-signup">
                                    I accept <a href="#">Terms and Conditions</a>
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group text-right m-t-20">
                        <div class="col-xs-12">
                            <button id="register" class="btn btn-primary btn-custom waves-effect waves-light w-md" type="submit">Register</button>
                        </div>
                    </div>

                    <div class="form-group row m-t-30">
                        <div class="col-12 text-center">
                            <a href="${path}/user/login" class="text-muted">Already have account?</a>
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

            <script type="text/javascript" src="${path }/resources/js/user/user.js"></script>

        </body>
    </html>