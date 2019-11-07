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

            <link href="${path }/resources/bootstrap-minton/plugins/custombox/dist/custombox.min.css" rel="stylesheet">
            <link rel="stylesheet" href="${path }/resources/bootstrap-minton/plugins/morris/morris.css">

                    <!-- DataTables -->
            <link href="${path }/resources/bootstrap-minton/plugins/datatables/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
            <link href="${path }/resources/bootstrap-minton/plugins/datatables/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
    
            <link href="${path }/resources/bootstrap-minton/plugins/switchery/switchery.min.css" rel="stylesheet" />
            <link href="${path }/resources/bootstrap-minton/plugins/jquery-circliful/css/jquery.circliful.css" rel="stylesheet" type="text/css" />
    
            <link href="${path }/resources/bootstrap-minton/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
            <link href="${path }/resources/bootstrap-minton/assets/css/icons.css" rel="stylesheet" type="text/css">
            <link href="${path }/resources/bootstrap-minton/assets/css/style.css" rel="stylesheet" type="text/css">
    
            <script src="${path }/resources/bootstrap-minton/assets/js/modernizr.min.js"></script>
    
            
        </head>
    
    
        <body class="fixed-left">
            
            <!-- Begin page -->
            <div id="wrapper">
    
                <!-- Top Bar Start -->
                <div class="topbar">
    
                    <!-- LOGO -->
                    <div class="topbar-left">
                        <div class="text-center">
                            <a href="index.html" class="logo"><i class="mdi mdi-radar"></i> <span>YCT</span></a>
                        </div>
                    </div>
    
                    <!-- Button mobile view to collapse sidebar menu -->
                    <nav class="navbar-custom">
    
                        <ul class="list-inline float-right mb-0">
    
                            <li class="list-inline-item dropdown notification-list">
                                <a class="nav-link dropdown-toggle arrow-none waves-light waves-effect" data-toggle="dropdown" href="#" role="button"
                                   aria-haspopup="false" aria-expanded="false">
                                    <i class="mdi mdi-bell noti-icon"></i>
                                    <span class="badge badge-pink noti-icon-badge">4</span>
                                </a>
                                <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-menu-lg" aria-labelledby="Preview">
                                    <!-- item-->
                                    <div class="dropdown-item noti-title">
                                        <h5 class="font-16"><span class="badge badge-danger float-right">5</span>Notification</h5>
                                    </div>
    
                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon bg-success"><i class="mdi mdi-comment-account"></i></div>
                                        <p class="notify-details">Robert S. Taylor commented on Admin<small class="text-muted">1 min ago</small></p>
                                    </a>
    
                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon bg-info"><i class="mdi mdi-account"></i></div>
                                        <p class="notify-details">New user registered.<small class="text-muted">1 min ago</small></p>
                                    </a>
    
                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <div class="notify-icon bg-danger"><i class="mdi mdi-airplane"></i></div>
                                        <p class="notify-details">Carlos Crouch liked <b>Admin</b><small class="text-muted">1 min ago</small></p>
                                    </a>
    
                                    <!-- All-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item notify-all">
                                        View All
                                    </a>
    
                                </div>
                            </li>
    
                            <li class="list-inline-item dropdown notification-list">
                                <a class="nav-link dropdown-toggle waves-effect waves-light nav-user" data-toggle="dropdown" href="#" role="button"
                                   aria-haspopup="false" aria-expanded="false">
                                    <img src="${path}/user/profile/${elements.userDTO.userId}/${elements.userDTO.profileUrl}" alt="user" class="rounded-circle">
                                </a>
                                <div class="dropdown-menu dropdown-menu-right profile-dropdown " aria-labelledby="Preview">
                                    <!-- item-->
                                    <div class="dropdown-item noti-title">
                                        <h5 class="text-overflow"><small>Welcome ! John</small> </h5>
                                    </div>
    
                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <i class="mdi mdi-account"></i> <span>Profile</span>
                                    </a>
    
                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <i class="mdi mdi-settings"></i> <span>Settings</span>
                                    </a>
    
                                    <!-- item-->
                                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                                        <i class="mdi mdi-lock-open"></i> <span>Lock Screen</span>
                                    </a>
    
                                    <!-- item-->
                                    <a href="${path}/user/logout" class="dropdown-item notify-item">
                                        <i class="mdi mdi-logout"></i> <span>Logout</span>
                                    </a>
    
                                </div>
                            </li>
    
                        </ul>
    
                        <ul class="list-inline menu-left mb-0">
                            <li class="float-left">
                                <button class="button-menu-mobile open-left waves-light waves-effect">
                                    <i class="mdi mdi-menu"></i>
                                </button>
                            </li>
                            <li class="hide-phone app-search">
                                <form role="search" method="GET" action ="">
                                    <input type="text" placeholder="Search..." class="form-control">
                                    <a href=""><i class="fa fa-search"></i></a>
                                </form>
                            </li>
                        </ul>
    
                    </nav>
    
                </div>
                <!-- Top Bar End -->
    
    
                <!-- ========== Left Sidebar Start ========== -->
    
                <div class="left side-menu">
                    <div class="sidebar-inner slimscrollleft">
                        <!--- Divider -->
                        <div id="sidebar-menu">
                            <ul>
                                <li class="menu-title">Main</li>
    
                                <li>
                                    <a href="index.html" class="waves-effect waves-primary">
                                        <i class="ti-home"></i><span> Dashboard </span>
                                    </a>
                                </li>
    
                                <li class="has_sub">
                                    <a href="javascript:void(0);" class="waves-effect waves-primary">
                                        <i class="ti-shine"></i><span> Projects </span> 
                                        <span class="menu-arrow"></span>
                                        <!-- <span class="badge badge-pink pull-right">New</span>  -->
                                    </a>
                                    <ul class="list-unstyled">
                                        <c:forEach var="row" items="${elements.projectList}">
                                                <li><a href="#">- ${row.projectName}</a></li>
                                        </c:forEach>
                                    </ul>
                                </li>
    
                                
                            </ul>
    
    
                            <div class="clearfix"></div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <!-- Left Sidebar End -->
    
    
    
    
                <!-- ============================================================== -->
                <!-- Start right Content here -->
                <!-- ============================================================== -->                      
                <div class="content-page">
                    <!-- Start content -->
                    <div class="content">
                        <div class="container-fluid">
    
                            <!-- Page-Title -->
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="page-title-box">
                                        <h4 class="page-title">Welcome !</h4>
                                        <ol class="breadcrumb float-right">
                                            <li class="breadcrumb-item"><a href="#">Minton</a></li>
                                            <li class="breadcrumb-item active">Dashboard</li>
                                        </ol>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                    <div class="col-lg-12">
                                        <div class="card-box">
                                            <div class="row">
                                                <div class="col-sm-5">
                                                    <div class="row">
                                                        <div class="col-6 text-center">
                                                            <c:if test="${weather.list[0].weather[0].main eq 'Clear'}">
                                                                <canvas id="clear-day" width="100" height="100"></canvas>
                                                            </c:if>
                                                            <c:if test="${weather.list[0].weather[0].main eq 'Snow'}">
                                                                    <canvas id="snow" width="100" height="100"></canvas>
                                                            </c:if>
                                                            <c:if test="${weather.list[0].weather[0].main eq 'Rain'}">
                                                                    <canvas id="sleet" width="100" height="100"></canvas>
                                                            </c:if>
                                                            <c:if test="${weather.list[0].weather[0].main eq 'Mist'}">
                                                                    <canvas id="fog" width="100" height="100"></canvas>
                                                            </c:if>
                                                            <c:if test="${weather.list[0].weather[0].main eq 'Clouds'}">
                                                                    <canvas id="cloudy" width="100" height="100"></canvas>
                                                            </c:if>
                                                        </div>
                                                        <div class="col-6">
                                                            <h2 class="m-t-0 text-muted"><b><fmt:formatNumber value="${weather.list[0].main.temp - 273.15}" pattern=".00"/><i class="wi wi-degrees"></i></b></h2>
                                                            <p class="text-muted">${weather.list[0].weather[0].description}</p>
                                                            <p class="text-muted mb-0">${weather.list[0].dt_txt}</p>
                                                        </div>
                                                    </div><!-- End row -->
                                                </div>
                                                <div class="col-sm-7">
                                                    <div class="row">
                                                        <div class="col-4 text-center">
                                                            <h4 class="text-muted m-t-0">${weather.list[8].dt_txt}</h4>
                                                            <h4 class="text-muted"><b><fmt:formatNumber value="${weather.list[8].main.temp - 273.15}" pattern=".00"/><i class="wi wi-degrees"></i></b></h4>
                                                            <h4 class="text-muted">${weather.list[8].weather[0].description}</h4>
                                                        </div>
                                                        <div class="col-4 text-center">
                                                                <h4 class="text-muted m-t-0">${weather.list[16].dt_txt}</h4>
                                                                <h4 class="text-muted"><b><fmt:formatNumber value="${weather.list[16].main.temp - 273.15}" pattern=".00"/><i class="wi wi-degrees"></i></b></h4>
                                                                <h4 class="text-muted">${weather.list[16].weather[0].description}</h4>
                                                        </div>
                                                        <div class="col-4 text-center">
                                                                <h4 class="text-muted m-t-0">${weather.list[24].dt_txt}</h4>
                                                                <h4 class="text-muted"><b><fmt:formatNumber value="${weather.list[24].main.temp - 273.15}" pattern=".00"/><i class="wi wi-degrees"></i></b></h4>
                                                                <h4 class="text-muted">${weather.list[24].weather[0].description}</h4>
                                                        </div>
                                                    </div><!-- end row -->
                                                </div>
                                            </div><!-- end row -->
                                        </div>
                                    </div> <!-- end col -->
                            </div>
                            <!--end row/ WEATHER -->
    
                            <div class="row">
                                    <div class="col-12">
                                        <div class="card-box table-responsive">
                                            <div class="row">
                                                    <div class="col-8">
                                                        <h4 class="m-t-0 header-title">프로젝트 목록</h4>
                                                    </div>
                                                    <div class="col-4 text-right">
                                                            <button type="button" class="btn btn-secondary btn-rounded w-md waves-effect m-b-5" data-toggle="modal" data-target="#projectCreateModal">프로젝트 생성</button>
                                                    </div>
                                            </div>
                                            <p class="text-muted font-14 m-b-30">
                                                프로젝트 목록들입니다.
                                            </p>
        
                                            <table id="datatable" class="table table-bordered">
                                                <thead>
                                                <tr>
                                                    <th>프로젝트 이름</th>
                                                    <th>책임자</th>
                                                    <th>프로젝트 시작일</th>
                                                </tr>
                                                </thead>
        
                                                <tbody>
                                                    <c:forEach var="row" items="${elements.projectList}">
                                                        <tr>
                                                            <td><a href="${path}/project/viewBackLog/${row.projectId}">${row.projectName}</a></td>
                                                            <td>${row.supervisor}</td>
                                                            <td>${row.regDate}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div> <!-- end row -->
    
    
                            <div class="row">
                                <div class="col-lg-8">
                                    <div class="card-box">
                                        <h4 class="header-title m-t-0">Latest Projects</h4>
                                        <p class="text-muted m-b-25 font-13">
                                            Your awesome text goes here.
                                        </p>
    
                                        <div class="table-responsive">
                                            <table class="table mb-0">
                                                <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Project Name</th>
                                                    <th>Start Date</th>
                                                    <th>Due Date</th>
                                                    <th>Status</th>
                                                    <th>Assign</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Minton Admin v1</td>
                                                    <td>01/01/2017</td>
                                                    <td>26/04/2017</td>
                                                    <td><span class="badge badge-info">Released</span></td>
                                                    <td>Coderthemes</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Minton Frontend v1</td>
                                                    <td>01/01/2017</td>
                                                    <td>26/04/2017</td>
                                                    <td><span class="badge badge-success">Released</span></td>
                                                    <td>Minton admin</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Minton Admin v1.1</td>
                                                    <td>01/05/2017</td>
                                                    <td>10/05/2017</td>
                                                    <td><span class="badge badge-pink">Pending</span></td>
                                                    <td>Coderthemes</td>
                                                </tr>
                                                <tr>
                                                    <td>4</td>
                                                    <td>Minton Frontend v1.1</td>
                                                    <td>01/01/2017</td>
                                                    <td>31/05/2017</td>
                                                    <td><span class="badge badge-purple">Work in Progress</span>
                                                    </td>
                                                    <td>Minton admin</td>
                                                </tr>
                                                <tr>
                                                    <td>5</td>
                                                    <td>Minton Admin v1.3</td>
                                                    <td>01/01/2017</td>
                                                    <td>31/05/2017</td>
                                                    <td><span class="badge badge-warning">Coming soon</span></td>
                                                    <td>Coderthemes</td>
                                                </tr>
        
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <!-- end col -8 -->
    
                                <div class="col-lg-4">
                                    <div class="card-box widget-user">
                                        <div>
                                            <img src="${path}/resources/bootstrap-minton/assets/images/users/avatar-1.jpg" class="img-responsive rounded-circle" alt="user">
                                            <div class="wid-u-info">
                                                <h5 class="mt-0 m-b-5 font-16">Chadengle</h5>
                                                <p class="text-muted m-b-5 font-13">coderthemes@gmail.com</p>
                                                <small class="text-warning"><b>Admin</b></small>
                                            </div>
                                        </div>
                                    </div>
    
                                    <div class="card-box widget-user">
                                        <div>
                                            <img src="${path}/resources/bootstrap-minton/assets/images/users/avatar-2.jpg" class="img-responsive rounded-circle" alt="user">
                                            <div class="wid-u-info">
                                                <h5 class="mt-0 m-b-5 font-16">Tomaslau</h5>
                                                <p class="text-muted m-b-5 font-13">coderthemes@gmail.com</p>
                                                <small class="text-success"><b>User</b></small>
                                            </div>
                                        </div>
                                    </div>
    
                                    <div class="card-box widget-user">
                                        <div>
                                            <img src="${path}/resources/bootstrap-minton/assets/images/users/avatar-7.jpg" class="img-responsive rounded-circle" alt="user">
                                            <div class="wid-u-info">
                                                <h5 class="mt-0 m-b-5 font-16">Ok</h5>
                                                <p class="text-muted m-b-5 font-13">coderthemes@gmail.com</p>
                                                <small class="text-pink"><b>Admin</b></small>
                                            </div>
                                        </div>
                                    </div>
    
                                </div>
    
                            </div>
                            <!-- end row -->
    
    
                        </div>
                        <!-- end container -->
                    </div>
                    <!-- end content -->
    
                    <footer class="footer">
                        2016 - 2018 © Minton <span class="hide-phone">- Coderthemes.com</span>
                    </footer>
    
                </div>
                <!-- ============================================================== -->
                <!-- End Right content here -->
                <!-- ============================================================== -->
    
    
                <!-- Right Sidebar -->
                <div class="side-bar right-bar">
                    <div class="">
                        <ul class="nav nav-tabs tabs-bordered nav-justified">
                            <li class="nav-item">
                                <a href="#home-2" class="nav-link active" data-toggle="tab" aria-expanded="false">
                                    Activity
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="#messages-2" class="nav-link" data-toggle="tab" aria-expanded="true">
                                    Settings
                                </a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane fade show active" id="home-2">
                                <div class="timeline-2">
                                    <div class="time-item">
                                        <div class="item-info">
                                            <small class="text-muted">5 minutes ago</small>
                                            <p><strong><a href="#" class="text-info">John Doe</a></strong> Uploaded a photo <strong>"DSC000586.jpg"</strong></p>
                                        </div>
                                    </div>
    
                                    <div class="time-item">
                                        <div class="item-info">
                                            <small class="text-muted">30 minutes ago</small>
                                            <p><a href="" class="text-info">Lorem</a> commented your post.</p>
                                            <p><em>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet tellus ut tincidunt euismod. "</em></p>
                                        </div>
                                    </div>
    
                                    <div class="time-item">
                                        <div class="item-info">
                                            <small class="text-muted">59 minutes ago</small>
                                            <p><a href="" class="text-info">Jessi</a> attended a meeting with<a href="#" class="text-success">John Doe</a>.</p>
                                            <p><em>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet tellus ut tincidunt euismod. "</em></p>
                                        </div>
                                    </div>
    
                                    <div class="time-item">
                                        <div class="item-info">
                                            <small class="text-muted">1 hour ago</small>
                                            <p><strong><a href="#" class="text-info">John Doe</a></strong>Uploaded 2 new photos</p>
                                        </div>
                                    </div>
    
                                    <div class="time-item">
                                        <div class="item-info">
                                            <small class="text-muted">3 hours ago</small>
                                            <p><a href="" class="text-info">Lorem</a> commented your post.</p>
                                            <p><em>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet tellus ut tincidunt euismod. "</em></p>
                                        </div>
                                    </div>
    
                                    <div class="time-item">
                                        <div class="item-info">
                                            <small class="text-muted">5 hours ago</small>
                                            <p><a href="" class="text-info">Jessi</a> attended a meeting with<a href="#" class="text-success">John Doe</a>.</p>
                                            <p><em>"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam laoreet tellus ut tincidunt euismod. "</em></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
    
    
                            <div class="tab-pane" id="messages-2">
    
                                <div class="row m-t-20">
                                    <div class="col-8">
                                        <h5 class="m-0 font-15">Notifications</h5>
                                        <p class="text-muted m-b-0"><small>Do you need them?</small></p>
                                    </div>
                                    <div class="col-4 text-right">
                                        <input type="checkbox" checked data-plugin="switchery" data-color="#3bafda" data-size="small"/>
                                    </div>
                                </div>
    
                                <div class="row m-t-20">
                                    <div class="col-8">
                                        <h5 class="m-0 font-15">API Access</h5>
                                        <p class="m-b-0 text-muted"><small>Enable/Disable access</small></p>
                                    </div>
                                    <div class="col-4 text-right">
                                        <input type="checkbox" checked data-plugin="switchery" data-color="#3bafda" data-size="small"/>
                                    </div>
                                </div>
    
                                <div class="row m-t-20">
                                    <div class="col-8">
                                        <h5 class="m-0 font-15">Auto Updates</h5>
                                        <p class="m-b-0 text-muted"><small>Keep up to date</small></p>
                                    </div>
                                    <div class="col-4 text-right">
                                        <input type="checkbox" checked data-plugin="switchery" data-color="#3bafda" data-size="small"/>
                                    </div>
                                </div>
    
                                <div class="row m-t-20">
                                    <div class="col-8">
                                        <h5 class="m-0 font-15">Online Status</h5>
                                        <p class="m-b-0 text-muted"><small>Show your status to all</small></p>
                                    </div>
                                    <div class="col-4 text-right">
                                        <input type="checkbox" checked data-plugin="switchery" data-color="#3bafda" data-size="small"/>
                                    </div>
                                </div>
    
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Right-bar -->
    
            </div>
            <!-- END wrapper -->

            <!-- 프로젝트 생성 모달관련 코드 -->
            <div id="projectCreateModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h4 class="modal-title" id="myModalLabel">프로젝트 생성</h4>
                            </div>
                                    <div class="card-box">
                                            <!-- <h4 class="header-title m-t-0">프로젝트 생성</h4> -->
        
                                            <form id="registerProjectForm" enctype="multipart/form-data" action="${path}/project/createProject" method="POST">
                                                <div class="form-group">
                                                    <label for="projectName">프로젝트 이름<span class="text-danger">*</span></label>
                                                    <input type="text" name="projectName" parsley-trigger="change" required
                                                           placeholder="프로젝트 이름을 입력하세요." class="form-control" id="projectName">
                                                </div>

                                                <div class="form-group">
                                                    <label for="projectFiles">프로젝트 파일 업로드<span class="text-danger">*</span></label>
                                                    <input type="file" multiple="multiple" name="projectFiles" class="form-control" id="projectFiles">
                                                </div>

                                                <div class="form-group">
                                                        <label for="description">프로젝트 설명<span class="text-danger">*</span></label>
                                                        <textarea name="description" class="form-control" rows="5" id="description"></textarea>
                                                </div>
        
                                                <div class="form-group text-right m-b-0">
                                                    <button class="btn btn-secondary waves-effect waves-light" type="submit">
                                                        Submit
                                                    </button>
                                                </div>
        
                                            </form>
                                        </div> <!-- end card-box -->
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
    
    
        
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
    
            <!-- Required datatable js -->
            <script src="${path }/resources/bootstrap-minton/plugins/datatables/jquery.dataTables.min.js"></script>
            <script src="${path }/resources/bootstrap-minton/plugins/datatables/dataTables.bootstrap4.min.js"></script>
            
            <!-- Counter Up  -->
            <script src="${path }/resources/bootstrap-minton/plugins/waypoints/lib/jquery.waypoints.min.js"></script>
            <script src="${path }/resources/bootstrap-minton/plugins/counterup/jquery.counterup.min.js"></script>
    
            <!-- circliful Chart -->
            <script src="${path }/resources/bootstrap-minton/plugins/jquery-circliful/js/jquery.circliful.min.js"></script>
            <script src="${path }/resources/bootstrap-minton/plugins/jquery-sparkline/jquery.sparkline.min.js"></script>
    
            <!-- skycons -->
            <script src="${path }/resources/bootstrap-minton/plugins/skyicons/skycons.min.js" type="text/javascript"></script>
    
            <!-- Page js  -->
            <script src="${path }/resources/bootstrap-minton/assets/pages/jquery.dashboard.js"></script>
    
            <!-- Modal-Effect -->
            <script src="${path }/resources/bootstrap-minton/plugins/custombox/dist/custombox.min.js"></script>
            <script src="${path }/resources/bootstrap-minton/plugins/custombox/dist/legacy.min.js"></script>
            
            <!-- Custom main Js -->
            <script src="${path }/resources/bootstrap-minton/assets/js/jquery.core.js"></script>
            <script src="${path }/resources/bootstrap-minton/assets/js/jquery.app.js"></script>
    
            <script type="text/javascript">
                jQuery(document).ready(function($) {
                    $('.counter').counterUp({
                        delay: 100,
                        time: 1200
                    });
                    $('.circliful-chart').circliful();
                });
    
                // BEGIN SVG WEATHER ICON
                if (typeof Skycons !== 'undefined'){
                    var icons = new Skycons(
                            {"color": "#3bafda"},
                            {"resizeClear": true}
                            ),
                            list  = [
                                "clear-day", "clear-night", "partly-cloudy-day",
                                "partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
                                "fog"
                            ],
                            i;
    
                    for(i = list.length; i--; )
                        icons.set(list[i], list[i]);
                    icons.play();
                };
    
            </script>

            <script type="text/javascript">
                $(document).ready(function() {

                    // Default Datatable
                    $('#datatable').DataTable();
                } );
            </script>
    
    
        </body>
    </html>