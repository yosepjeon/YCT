<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta name="description"
	content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
<meta name="author" content="Coderthemes">
<%@include file="../include/header.jsp"%>

<link rel="shortcut icon"
	href="${path }/resources/bootstrap-minton/assets/images/favicon.ico">

<title>Minton - Responsive Admin Dashboard Template</title>

<link
	href="${path }/resources/bootstrap-minton/plugins/custombox/dist/custombox.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${path }/resources/bootstrap-minton/plugins/morris/morris.css">

	        <!-- Plugins css-->
			<link href="${path }/resources/bootstrap-minton/plugins/bootstrap-tagsinput/dist/bootstrap-tagsinput.css" rel="stylesheet" />
			<link href="${path }/resources/bootstrap-minton/plugins/multiselect/css/multi-select.css"  rel="stylesheet" type="text/css" />
			<link href="${path }/resources/bootstrap-minton/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
			<link href="${path }/resources/bootstrap-minton/plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.css" rel="stylesheet" />
			<link href="${path }/resources/bootstrap-minton/plugins/mjolnic-bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css" rel="stylesheet">
			<link href="${path }/resources/bootstrap-minton/plugins/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css" rel="stylesheet">
			<link href="${path }/resources/bootstrap-minton/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
	
<!--Footable-->
<link
	href="${path}/resources/bootstrap-minton/plugins/footable/css/footable.core.css"
	rel="stylesheet">

<link
	href="${path }/resources/bootstrap-minton/plugins/switchery/switchery.min.css"
	rel="stylesheet" />

<link
	href="${path }/resources/bootstrap-minton/assets/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="${path }/resources/bootstrap-minton/assets/css/icons.css"
	rel="stylesheet" type="text/css">
<link href="${path }/resources/bootstrap-minton/assets/css/style.css"
	rel="stylesheet" type="text/css">

<script
	src="${path }/resources/bootstrap-minton/assets/js/modernizr.min.js"></script>
<!-- Dropzone css -->
<link href="${path }/resources/bootstrap-minton/plugins/dropzone/dropzone.css" rel="stylesheet" />
<!-- <link href='${path}/resources/js/dragula/dragula.css' rel='stylesheet'
	type='text/css' /> -->
        <!-- Sweet Alert css -->
        <link href="${path}/resources/bootstrap-minton/plugins/sweet-alert/sweetalert2.min.css" rel="stylesheet" type="text/css" />

</head>


<body class="fixed-left">

	<!-- Begin page -->
	<div id="wrapper">

		<!-- Top Bar Start -->
		<div class="topbar">

			<!-- LOGO -->
			<div class="topbar-left">
				<div class="text-center">
					<a href="index.html" class="logo"><i class="mdi mdi-radar"></i>
						<span>YCT</span></a>
				</div>
			</div>

			<!-- Button mobile view to collapse sidebar menu -->
			<nav class="navbar-custom">

				<ul class="list-inline float-right mb-0">

					<li class="list-inline-item notification-list">
						<a class="nav-link right-bar-toggle waves-light waves-effect" href="#">
							<i class="mdi mdi-dots-horizontal noti-icon"></i>
						</a>
					</li>

					<li class="list-inline-item dropdown notification-list"><a
						class="nav-link dropdown-toggle arrow-none waves-light waves-effect"
						data-toggle="dropdown" href="#" role="button"
						aria-haspopup="false" aria-expanded="false"> <i
							class="mdi mdi-bell noti-icon"></i> <span
							class="badge badge-pink noti-icon-badge">4</span>
					</a>
						<div
							class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-menu-lg"
							aria-labelledby="Preview">
							<!-- item-->
							<div class="dropdown-item noti-title">
								<h5 class="font-16">
									<span class="badge badge-danger float-right">5</span>Notification
								</h5>
							</div>

							<!-- item-->
							<a href="javascript:void(0);" class="dropdown-item notify-item">
								<div class="notify-icon bg-success">
									<i class="mdi mdi-comment-account"></i>
								</div>
								<p class="notify-details">
									Robert S. Taylor commented on Admin<small class="text-muted">1
										min ago</small>
								</p>
							</a>

							<!-- item-->
							<a href="javascript:void(0);" class="dropdown-item notify-item">
								<div class="notify-icon bg-info">
									<i class="mdi mdi-account"></i>
								</div>
								<p class="notify-details">
									New user registered.<small class="text-muted">1 min ago</small>
								</p>
							</a>

							<!-- item-->
							<a href="javascript:void(0);" class="dropdown-item notify-item">
								<div class="notify-icon bg-danger">
									<i class="mdi mdi-airplane"></i>
								</div>
								<p class="notify-details">
									Carlos Crouch liked <b>Admin</b><small class="text-muted">1
										min ago</small>
								</p>
							</a>

							<!-- All-->
							<a href="javascript:void(0);"
								class="dropdown-item notify-item notify-all"> View All </a>

						</div></li>

					<li class="list-inline-item dropdown notification-list"><a
						class="nav-link dropdown-toggle waves-effect waves-light nav-user"
						data-toggle="dropdown" href="#" role="button"
						aria-haspopup="false" aria-expanded="false"> <img
							src="${path}/user/profile/${elements.userDTO.userId}/${elements.userDTO.profileUrl}"
							alt="user" class="rounded-circle">
					</a>
						<div class="dropdown-menu dropdown-menu-right profile-dropdown "
							aria-labelledby="Preview">
							<!-- item-->
							<div class="dropdown-item noti-title">
								<h5 class="text-overflow">
									<small>Welcome ! John</small>
								</h5>
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

						</div></li>

				</ul>

				<ul class="list-inline menu-left mb-0">
					<li class="float-left">
						<button
							class="button-menu-mobile open-left waves-light waves-effect">
							<i class="mdi mdi-menu"></i>
						</button>
					</li>
					<li class="hide-phone app-search">
						<form role="search" class="">
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

						<li><a href="${path}/dashboard/index"
							class="waves-effect waves-primary"> <i class="ti-home"></i><span>
									Dashboard </span>
						</a></li>

						<li class="has_sub"><a href="javascript:void(0);"
							class="waves-effect waves-primary"> <i class="ti-shine"></i><span>
									Projects </span> <span class="menu-arrow"></span> <!-- <span class="badge badge-pink pull-right">New</span>  -->
						</a>
							<ul class="list-unstyled">
								<c:forEach var="row" items="${elements.projectList}">
									<li><a href="#">- ${row.projectName}</a></li>
								</c:forEach>
							</ul></li>

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
					<div class="row">
							<div class="col-sm-12">
									<div class="card-box">
										<h4 class="m-t-0 header-title">BACKLOG LIST</h4>
										<p class="text-muted m-b-30 font-13">백로그 테이블입니다. 백로그를 추가하려면 아래 버튼을 클릭하세요..</p>
		
										<table id="backlog-foo-addrow"
											class="table table-striped table-bordered m-b-0 toggle-circle"
											data-page-size="7">
											<thead>
												<tr>
													<th data-sort-ignore="true" class="min-width"></th>
													<th>BackLog Name</th>
													<th>Task Id</th>
													<th>Priority</th>
													<th data-sort-ignore="true" class="min-width"></th>
													<!-- <th data-sort-ignore="true" class="min-width"></th> -->
												</tr>
											</thead>
											<div class="pad-btm form-inline">
												<div class="row">
													<div class="col-sm-6 text-xs-center">
														<div class="form-group">
															<button id="addBackLogBtn" class="btn btn-primary m-b-20" data-toggle="modal">
																<i class="fa fa-plus m-r-5"></i> Add BackLog
															</button>
														</div>
													</div>
													<div class="col-sm-6 text-xs-center text-right">
														<div class="form-group">
															<input id="backlog-input-search2" type="text"
																placeholder="Search" class="form-control"
																autocomplete="off">
														</div>
													</div>
												</div>
											</div>
											<tbody>
												<c:forEach var="task" items="${taskList}">
													<c:if test="${task.sprintId eq firstSprintId}">
														<tr id="${task.taskId}">
															<td class="text-center">
																<button
																	class="task-delete-row btn btn-danger btn-sm btn-icon" value=${task.taskId}>
																	<i class="fa fa-times"></i>
																</button>
															</td>
															<td>${task.taskName}</td>
															<td>${task.taskId}</td>
															<td>${task.taskPriority}</td>
															<td class="text-center">
																<button
																	class="moveBackLogBtn task-move-row btn btn-info btn-sm btn-icon" value=${task.taskId}>
																	<i class="fa fa-plus"></i>
																</button>
															</td>
														</tr>
													</c:if>
												</c:forEach>
												
											</tbody>
											<tfoot>
												<tr class="active">
													<td colspan="6">
														<div class="text-right">
															<ul
																class="pagination pagination-split justify-content-end footable-pagination m-t-10"></ul>
														</div>
													</td>
												</tr>
											</tfoot>
										</table>
									</div>
								</div>
						
								<div class="col-sm-12">
										<div class="card-box">
											<h4 class="m-t-0 header-title">SPRINT LIST</h4>
											<p class="text-muted m-b-30 font-13">스프린트 테이블입니다. 스프린트를 추가하려면 아래 버튼을 클릭하세요..</p>
			
											<table id="sprint-foo-addrow"
												class="table table-striped table-bordered m-b-0 toggle-circle"
												data-page-size="7">
												<thead>
														<tr>
															<th data-sort-ignore="true" class="min-width"></th>
															<th data-sort-ignore="true">Sprint Name</th>
															<th>StartDate</th>
															<th>EndDate</th>
															<th data-sort-ignore="true" class="min-width"></th>
															<!-- <th data-sort-ignore="true" class="min-width"></th> -->
														</tr>
												</thead>
												<div class="pad-btm form-inline">
													<div class="row">
														<div class="col-sm-6 text-xs-center">
															<div class="form-group">
																<button id="sprint-create-btn" class="btn btn-primary m-b-20">
																	<i class="fa fa-plus m-r-5"></i> Add Sprint
																</button>
															</div>
														</div>
														<div class="col-sm-6 text-xs-center text-right">
															<div class="form-group">
																<input id="sprint-input-search2" type="text"
																	placeholder="Search" class="form-control"
																	autocomplete="off">
															</div>
														</div>
													</div>
												</div>
												<tbody>
													<c:forEach var="sprint" items="${sprintList}" >
														<c:if test="${sprint.sprintId ne firstSprintId}">
															<tr id="${sprint.sprintId}">
																<td class="text-center">
																	<button
																		class="sprint-delete-row btn btn-danger btn-sm btn-icon" value=${sprint.sprintId}>
																		<i class="fa fa-times"></i>
																	</button>
																</td>
																<td>${sprint.sprintName}</td>
																<td>${sprint.startDate}</td>
																<td>${sprint.endDate}</td>
																<td class="text-center">
																		<button
																			class="startSprint sprint-move-row btn btn-info btn-sm btn-icon" value=${sprint.sprintId}>
																			<i class="fa fa-plus"></i>
																		</button>
																</td>
															</tr>
														</c:if>
													</c:forEach>
													
												</tbody>
												<tfoot>
													<tr class="active">
														<td colspan="6">
															<div class="text-right">
																<ul
																	class="pagination pagination-split justify-content-end footable-pagination m-t-10"></ul>
															</div>
														</td>
													</tr>
												</tfoot>
											</table>
										</div>
									</div>
					</div>
				</div>
				<!-- end row -->
			</div>
			<!-- end container -->
		</div>
		<!-- end content -->

	<!-- 백로그 생성 모달 코드 -->
	<div class="row">
			<div class="col-12">
					<div id="create-backlog-task-modal" class="modal fade nicescroll" tabindex="-1" role="dialog" aria-labelledby="backlogModal" aria-hidden="true" style="display: none;">
							<div class="modal-dialog modal-lg">
								<div class="modal-content card-box">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<!-- <h4 class="modal-title" id="backlogModal">백로그단계 테스크 생성</h4> -->
									</div>
									<div class="modal-body">
										<form>
										<div class="row">
											<div class="col-7">
												<div class="row">
													<div class="form-group col-12">
														<label for="taskName">백로그 이름</label>
														<input id="taskName" class="form-control" type="text" name="taskName">
													</div>
												</div>
												<div class="row">
													<!-- <div class="form-group">
														<label for="description"><a>Description</a></label>
														<textarea name="description" placeholder="Add a description..." ></textarea>
													</div> -->
													<div class="form-group col-12">
														<label for="description">설명</label>
														<form method="post">
															<textarea id="elm1" name="description"></textarea>
														</form>
													</div>
												</div>
												<div class="row">
														<div class="form-group col-12 portlets">
															<div class="m-b-30">
																<label for="Attachment">첨부파일</label>
																<!-- <form action="#" class="dropzone" id="dropzone" name="attachment"> -->
																<input id="taskAttachment" name="attachmentFiles[]" type="file" multiple />
																<!-- <div class="fileList"></div>	 -->
																<!-- </form> -->
															</div>
														</div>
												</div>
											</div>
											<div class="col-5">
													<div class="row">
														<div class="form-group col-12">
															<label for="status">상태</label>
															<form method="post" name="status">
																<div class="btn-group">
																	<button id="status" type="button" class="btn btn-secondary dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="false" value="">STATUS<span class="caret"></span></button>
																	<div class="dropdown-menu">
																		<a id="status-todo" class="dropdown-item">TODO</a>
																		<a id="status-inprogress" class="dropdown-item">INPROGRESS</a>
																		<a id="status-done" class="dropdown-item">DONE</a>
																	</div>
																</div>
															</form>
														</div>
													</div>
													<div class="row">
															<div class="form-group col-12">
																<label for="priority">우선순위</label>
																<form method="post" name="priority">
																	<div class="btn-group">
																		<button id="priority" type="button" class="btn btn-secondary dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="false" value="">PRIORITY<span class="caret"></span></button>
																		<div class="dropdown-menu">
																			<a id="priority-highest" class="dropdown-item">HIGHEST<input id="priority-highest-value" type="hidden" value="HIGHEST"></a>
																			<a id="priority-high" class="dropdown-item">HIGH<input id="priority-high-value" type="hidden" value="HIGH"></a>
																			<a id="priority-medium" class="dropdown-item">MEDIUM<input id="priority-medium-value" type="hidden" value="MEDIUM"></a>
																			<a id="priority-low" class="dropdown-item">LOW<input id="priority-low-value" type="hidden" value="LOW"></a>
																			<a id="priority-lowest" class="dropdown-item">LOWEST<input id="priority-lowest-value" type="hidden" value="LOWEST"></a>
																		</div>
																	</div>
																</form>
															</div>
														</div>
													<div class="row">
														<div class="form-group col-12">
															<label for="assignee">담당자</label>
															<form method="post" name="assignee">
																<div class="btn-group">
																	<button id="assignee" type="button" class="btn btn-secondary dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="false" value="">ASSIGNEE <span class="caret"></span></button>
																	<div id="assignee-dropdown"class="dropdown-menu">
																		
																	</div>
																</div>
															</form>
														</div>
													</div>
													<div class="row">
														<div class="form-group col-12">
															<label for="sprint">스프린트</label>
															<form method="post" name="sprint">
																<div class="btn-group">
																	<button id="sprint" type="button" class="btn btn-secondary dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="false" value="">SPRINT <span class="caret"></span></button>
																	<div id="sprint-dropdown" class="dropdown-menu nicescroll">
																	</div>
																</div>
																<input id="sprintId" type="hidden" value="">
															</form>
														</div>
													</div>
													<div class="row">
														<div class="form-group col-12">
															<label for="reporter">관리자</label>
															<form method="post" name="sprint">
																<div class="btn-group">
																	<button id="reporter" type="button" class="btn btn-secondary dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="false">REPORTER <span class="caret"></span></button>
																	<div class="dropdown-menu">
																		<a class="dropdown-item" href="#">Dropdown link</a>
																		<a class="dropdown-item" href="#">Dropdown link</a>
																	</div>
																</div>
															</form>
														</div>
													</div>
													<div class="row">
														<div class="form-group col-12">
															<label for="comments">댓글</label>
																<div class="card-box">
																	<form>
																	<div class="chat-conversation" name="comments">
																			<ul class="conversation-list nicescroll">
																				
																			</ul>
																			<div class="row">
																				<div class="col-sm-9 chat-inputbar">
																					<input type="text" class="form-control chat-input" placeholder="백로그를 저장한 이후부터 작성 가능." readonly>
																				</div>
																				<div class="col-sm-3 chat-send">
																					<!-- <button class="btn btn-md btn-primary btn-block waves-effect waves-light">Send</button> -->
																				</div>
																			</div>
																		</div>
																	</form>
																</div>
														</div>
													</div>
											</div>
										</div>
										<div class="row">
											<div class="col-12 text-right">
												<button id="createTaskButton" type="button" class="btn btn-success btn-rounded w-md waves-effect waves-light m-b-5">생성</button>
											</div>
										</div>
										</form>
									</div>
								</div><!-- /.modal-content -->
							</div><!-- /.modal-dialog -->
						</div><!-- /.modal -->

						<div id="view-backlog-task-modal" class="modal fade nicescroll" tabindex="-1" role="dialog" aria-labelledby="backlogModal" aria-hidden="true" style="display: none;">
							<div class="modal-dialog modal-lg">
								<div class="modal-content card-box">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
										<!-- <h4 class="modal-title" id="backlogModal">백로그단계 테스크 생성</h4> -->
									</div>
									<div class="modal-body">
										<form>
										<div class="row">
											<div class="col-7">
												<div class="row">
													<div class="form-group col-12">
														<label for="taskName">백로그 이름</label>
														<input id="taskNameView" class="form-control" type="text" name="taskName" readonly>
													</div>
												</div>
												<div class="row">
													<!-- <div class="form-group">
														<label for="description"><a>Description</a></label>
														<textarea name="description" placeholder="Add a description..." ></textarea>
													</div> -->
													<div class="form-group col-12">
														<label for="description">설명</label>
														<form method="post">
															<textarea id="elm1View" name="description" disabled></textarea>
														</form>
													</div>
												</div>
												<div class="row">
														<div class="form-group col-12 portlets">
															<div class="m-b-30">
																<label for="Attachment">첨부파일</label>
																<!-- <form action="#" class="dropzone" id="dropzone" name="attachment"> -->
																<input id="taskAttachmentView" name="attachmentFiles[]" type="file" multiple readonly/>
																<!-- <div class="fileList"></div>	 -->
																<!-- </form> -->
															</div>
														</div>
												</div>
											</div>
											<div class="col-5">
													<div class="row">
														<div class="form-group col-12">
															<label for="status">상태</label>
															<form method="post" name="status">
																<div class="btn-group">
																	<button id="statusView" type="button" class="btn btn-secondary dropdown-toggle waves-effect waves-light" aria-expanded="false" value="">STATUS<span class="caret"></span></button>
																</div>
															</form>
														</div>
													</div>
													<div class="row">
															<div class="form-group col-12">
																<label for="priorityView">우선순위</label>
																<form method="post" name="priorityView">
																	<div class="btn-group">
																		<button id="priorityView" type="button" class="btn btn-secondary dropdown-toggle waves-effect waves-light" aria-expanded="false" data-toggle="dropdown" value="">PRIORITY<span class="caret"></span></button>
																		<div class="dropdown-menu">
																			<a id="priority-highestView" class="dropdown-item">HIGHEST<input id="priority-highest-valueView" type="hidden" value="HIGHEST"></a>
																			<a id="priority-highView" class="dropdown-item">HIGH<input id="priority-high-valueView" type="hidden" value="HIGH"></a>
																			<a id="priority-mediumView" class="dropdown-item">MEDIUM<input id="priority-medium-valueView" type="hidden" value="MEDIUM"></a>
																			<a id="priority-lowView" class="dropdown-item">LOW<input id="priority-low-valueView" type="hidden" value="LOW"></a>
																			<a id="priority-lowestView" class="dropdown-item">LOWEST<input id="priority-lowest-valueView" type="hidden" value="LOWEST"></a>
																		</div>
																	</div>
																</form>
															</div>
														</div>
													<div class="row">
														<div class="form-group col-12">
															<label for="assignee">담당자</label>
															<form method="post" name="assignee">
																<div class="btn-group">
																	<button id="assigneeView" type="button" class="btn btn-secondary dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="false" value="">ASSIGNEE <span class="caret"></span></button>
																	<div id="assignee-dropdownView"class="dropdown-menu">
																		
																	</div>
																</div>
															</form>
														</div>
													</div>
													<div class="row">
														<div class="form-group col-12">
															<label for="sprint">스프린트</label>
															<form method="post" name="sprint">
																<div class="btn-group">
																	<button id="sprintView" type="button" class="btn btn-secondary dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="false" value="">SPRINT <span class="caret"></span></button>
																	<div id="sprint-dropdownView" class="dropdown-menu nicescroll">
																	</div>
																</div>
																<input id="sprintIdView" type="hidden" value="">
															</form>
														</div>
													</div>
													<div class="row">
														<div class="form-group col-12">
															<label for="reporter">관리자</label>
															<form method="post" name="sprint">
																<div class="btn-group">
																	<button id="reporterView" type="button" class="btn btn-secondary dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="false">REPORTER <span class="caret"></span></button>
																	<div class="dropdown-menu">
																		<a class="dropdown-item" href="#">Dropdown link</a>
																		<a class="dropdown-item" href="#">Dropdown link</a>
																	</div>
																</div>
															</form>
														</div>
													</div>
													<div class="row">
														<div class="form-group col-12">
															<label for="comments">댓글</label>
																<div class="card-box">
																	<form>
																	<div class="chat-conversation" name="comments">
																			<ul class="conversation-list nicescroll">
																				
																			</ul>
																			<div class="row">
																				<div class="col-sm-9 chat-inputbar">
																					<input type="text" class="form-control chat-input" placeholder="백로그를 저장한 이후부터 작성 가능." readonly>
																				</div>
																				<div class="col-sm-3 chat-send">
																					<!-- <button class="btn btn-md btn-primary btn-block waves-effect waves-light">Send</button> -->
																				</div>
																			</div>
																		</div>
																	</form>
																</div>
														</div>
													</div>
											</div>
										</div>
										<div class="row">
											<div class="col-12 text-right">
												<button id="updateTaskButton" type="button" class="btn btn-success btn-rounded w-md waves-effect waves-light m-b-5">수정</button>
											</div>
										</div>
										</form>
									</div>
								</div><!-- /.modal-content -->
							</div><!-- /.modal-dialog -->
						</div><!-- /.modal -->

				<!-- 스프린트 생성 모달 -->
				<div id="sprint-create-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="sprintModal" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h4 class="modal-title" id="sprintModal">Modal Heading</h4>								</div>
							<div class="modal-body">
								<div class="row">
									<form>
										<div class="form-group col-12">
											<label for="create-sprintName">스프린트 이름</label>
											<input id="create-sprintName" class="form-control" type="text" name="sprintName">
										</div>
									</form>
								</div>
								<div class="row">
									<form>
										<div class="form-group col-12">
											<label for="taskName">스프린트 시작/끝</label>
											<div class="input-daterange input-group" id="date-range">
												<input id="create-sprintStart" type="text" class="form-control" name="startSprint">
												<input id="create-sprintEnd" type="text" class="form-control" name="endSprint">
											</div>
										</div>
									</form>
								</div>
								<div class="row">
									<form>
										<div class="col-12 text-right">
											<button id="sprint-btn-addrow" type="button" class="btn btn-success btn-rounded w-md waves-effect waves-light m-b-5">생성</button>
										</div>
									</form>
								</div>
							</div>
							<!-- <div class="modal-footer">
								<button type="button" class="btn btn-secondary waves-effect" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary waves-effect waves-light">Save changes</button>
							</div> -->
						</div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
				</div>
				
				<!-- 백로그 스프린트로 이동 모달 코드 -->
				<div id="sprint-move-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="sprintModal" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h4 class="modal-title" id="sprintModal">Modal Heading</h4>								</div>
							<div class="modal-body">
								<div class="row">
									<div class="form-group col-12">
										<label for="taskName">스프린트 이름</label>
										<input id="sprintNameView" class="form-control" type="text" name="taskName" readonly>
									</div>
								</div>
								<div class="row">
									<div class="form-group col-12">
										<label for="taskName">스프린트 시작/끝</label>
										<div class="input-daterange input-group" id="date-range">
											<input id="create-sprintStartView" type="text" class="form-control" name="startSprint" readonly>
											<input id="create-sprintEndView" type="text" class="form-control" name="endSprint" readonly>
										</div>
									</div>
								</div>
								<div class="col-12 text-right">
									<button id="startSprintButton" type="button" class="btn btn-success btn-rounded w-md waves-effect waves-light m-b-5">시작</button>
								</div>
							</div>
						</div><!-- /.modal-content -->
					</div><!-- /.modal-dialog -->
				</div><!-- /.modal -->

			</div>
		</div>


		<footer class="footer">

				<button type="button" id="go_to_projectView"
					class="btn btn-success btn-sm waves-effect waves-light" value=${elements.startSprint.sprintId}>Project</button>
			
			<input id="startSprintCount" type="hidden" value="${elemets.startSprintCount}">
			<input id="projectId" type="hidden" value="${projectId}">
			<input id="sprintListSize" type="hidden" value="${sprintListSize}">	
			<input id="taskListSize" type="hidden" value="${taskListSize}">
			<input id="firstSprintId" type="hidden" value="${firstSprintId}">
		</footer>

	</div>

	<!-- ============================================================== -->
	<!-- End Right content here -->
	<!-- ============================================================== -->


	<!-- Right Sidebar -->
	<div class="side-bar right-bar">
		<div class="">
			<ul class="nav nav-tabs tabs-bordered nav-justified">
				<li class="nav-item"><a href="#home-2" class="nav-link active"
					data-toggle="tab" aria-expanded="false"> Activity </a></li>
				<li class="nav-item"><a href="#messages-2" class="nav-link"
					data-toggle="tab" aria-expanded="true"> Settings </a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane fade show active" id="home-2">
					<div class="timeline-2">
						<div class="time-item">
							<div class="item-info">
								<small class="text-muted">5 minutes ago</small>
								<p>
									<strong><a href="#" class="text-info">John Doe</a></strong>
									Uploaded a photo <strong>"DSC000586.jpg"</strong>
								</p>
							</div>
						</div>

						<div class="time-item">
							<div class="item-info">
								<small class="text-muted">30 minutes ago</small>
								<p>
									<a href="" class="text-info">Lorem</a> commented your post.
								</p>
								<p>
									<em>"Lorem ipsum dolor sit amet, consectetur adipiscing
										elit. Aliquam laoreet tellus ut tincidunt euismod. "</em>
								</p>
							</div>
						</div>

						<div class="time-item">
							<div class="item-info">
								<small class="text-muted">59 minutes ago</small>
								<p>
									<a href="" class="text-info">Jessi</a> attended a meeting with<a
										href="#" class="text-success">John Doe</a>.
								</p>
								<p>
									<em>"Lorem ipsum dolor sit amet, consectetur adipiscing
										elit. Aliquam laoreet tellus ut tincidunt euismod. "</em>
								</p>
							</div>
						</div>

						<div class="time-item">
							<div class="item-info">
								<small class="text-muted">1 hour ago</small>
								<p>
									<strong><a href="#" class="text-info">John Doe</a></strong>Uploaded
									2 new photos
								</p>
							</div>
						</div>

						<div class="time-item">
							<div class="item-info">
								<small class="text-muted">3 hours ago</small>
								<p>
									<a href="" class="text-info">Lorem</a> commented your post.
								</p>
								<p>
									<em>"Lorem ipsum dolor sit amet, consectetur adipiscing
										elit. Aliquam laoreet tellus ut tincidunt euismod. "</em>
								</p>
							</div>
						</div>

						<div class="time-item">
							<div class="item-info">
								<small class="text-muted">5 hours ago</small>
								<p>
									<a href="" class="text-info">Jessi</a> attended a meeting with<a
										href="#" class="text-success">John Doe</a>.
								</p>
								<p>
									<em>"Lorem ipsum dolor sit amet, consectetur adipiscing
										elit. Aliquam laoreet tellus ut tincidunt euismod. "</em>
								</p>
							</div>
						</div>
					</div>
				</div>


				<div class="tab-pane" id="messages-2">

					<div class="row m-t-20">
						<div class="col-8">
							<h5 class="m-0 font-15">Notifications</h5>
							<p class="text-muted m-b-0">
								<small>Do you need them?</small>
							</p>
						</div>
						<div class="col-4 text-right">
							<input type="checkbox" checked data-plugin="switchery"
								data-color="#3bafda" data-size="small" />
						</div>
					</div>

					<div class="row m-t-20">
						<div class="col-8">
							<h5 class="m-0 font-15">API Access</h5>
							<p class="m-b-0 text-muted">
								<small>Enable/Disable access</small>
							</p>
						</div>
						<div class="col-4 text-right">
							<input type="checkbox" checked data-plugin="switchery"
								data-color="#3bafda" data-size="small" />
						</div>
					</div>

					<div class="row m-t-20">
						<div class="col-8">
							<h5 class="m-0 font-15">Auto Updates</h5>
							<p class="m-b-0 text-muted">
								<small>Keep up to date</small>
							</p>
						</div>
						<div class="col-4 text-right">
							<input type="checkbox" checked data-plugin="switchery"
								data-color="#3bafda" data-size="small" />
						</div>
					</div>

					<div class="row m-t-20">
						<div class="col-8">
							<h5 class="m-0 font-15">Online Status</h5>
							<p class="m-b-0 text-muted">
								<small>Show your status to all</small>
							</p>
						</div>
						<div class="col-4 text-right">
							<input type="checkbox" checked data-plugin="switchery"
								data-color="#3bafda" data-size="small" />
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- /Right-bar -->

	</div>
	<!-- END wrapper -->

	
	

	<script>
		var resizefunc = [];
	</script>

	<!-- 커스텀으로 만든 스크립트 파일 -->
	<script src="${path }/resources/js/backlog/backlog.js"></script>

	<!-- Plugins  -->
	<script
		src="${path }/resources/bootstrap-minton/assets/js/jquery.min.js"></script>
	<script
		src="${path }/resources/bootstrap-minton/assets/js/popper.min.js"></script>
	<!-- Popper for Bootstrap -->
	<script
		src="${path }/resources/bootstrap-minton/assets/js/bootstrap.min.js"></script>
	<script src="${path }/resources/bootstrap-minton/assets/js/detect.js"></script>
	<script
		src="${path }/resources/bootstrap-minton/assets/js/fastclick.js"></script>
	<script
		src="${path }/resources/bootstrap-minton/assets/js/jquery.slimscroll.js"></script>
	<script
		src="${path }/resources/bootstrap-minton/assets/js/jquery.blockUI.js"></script>
	<script src="${path }/resources/bootstrap-minton/assets/js/waves.js"></script>
	<script src="${path }/resources/bootstrap-minton/assets/js/wow.min.js"></script>
	<script
		src="${path }/resources/bootstrap-minton/assets/js/jquery.nicescroll.js"></script>
	<script
		src="${path }/resources/bootstrap-minton/assets/js/jquery.scrollTo.min.js"></script>
	<script
		src="${path }/resources/bootstrap-minton/plugins/switchery/switchery.min.js"></script>

	<!-- Modal-Effect -->
	<script
		src="${path }/resources/bootstrap-minton/plugins/custombox/dist/custombox.min.js"></script>
	<script
		src="${path }/resources/bootstrap-minton/plugins/custombox/dist/legacy.min.js"></script>

	<!-- Custom main Js -->
	<script
		src="${path }/resources/bootstrap-minton/assets/js/jquery.core.js"></script>
	<script
		src="${path }/resources/bootstrap-minton/assets/js/jquery.app.js"></script>
		<script src="${path }/resources/js/sprint/sprint.js"></script>
	<!--FooTable-->
	<script
		src="${path}/resources/bootstrap-minton/plugins/footable/js/footable.all.min.js"></script>
	<!--FooTable Example-->
	<script
		src="${path}/resources/bootstrap-minton/assets/pages/jquery.footable.js"></script>
	<!-- commonJS -->
	<script src="${path}/resources/js/common/modal.js"></script>

	<script src="${path}/resources/bootstrap-minton/plugins/bootstrap-tagsinput/dist/bootstrap-tagsinput.min.js"></script>
	<script type="text/javascript" src="${path}/resources/bootstrap-minton/plugins/multiselect/js/jquery.multi-select.js"></script>
	<script type="text/javascript" src="${path}/resources/bootstrap-minton/plugins/jquery-quicksearch/jquery.quicksearch.js"></script>
	<script src="${path}/resources/bootstrap-minton/plugins/select2/js/select2.min.js" type="text/javascript"></script>
	<script src="${path}/resources/bootstrap-minton/plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js" type="text/javascript"></script>
	<script src="${path}/resources/bootstrap-minton/plugins/bootstrap-inputmask/bootstrap-inputmask.min.js" type="text/javascript"></script>
	<script src="${path}/resources/bootstrap-minton/plugins/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<script src="${path}/resources/bootstrap-minton/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script src="${path}/resources/bootstrap-minton/plugins/mjolnic-bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>

	<!--form wysiwig-->
	<script src="${path}/resources/bootstrap-minton/plugins/tinymce/tinymce.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			// if($("#elm1").length > 0){
				tinymce.init({
					selector: "textarea#elm1",
					theme: "modern",
					height:300,
					plugins: [
						"advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker",
						"searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
						"save table contextmenu directionality emoticons template paste textcolor"
					],
					toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | l      ink image | print preview media fullpage | forecolor backcolor emoticons",
					style_formats: [
						{title: 'Bold text', inline: 'b'},
						{title: 'Red text', inline: 'span', styles: {color: '#ff0000'}},
						{title: 'Red header', block: 'h1', styles: {color: '#ff0000'}},
						{title: 'Example 1', inline: 'span', classes: 'example1'},
						{title: 'Example 2', inline: 'span', classes: 'example2'},
						{title: 'Table styles'},
						{title: 'Table row 1', selector: 'tr', classes: 'tablerow1'}
					]
				});
			}
		// }
		);
	</script>
	<script type="text/javascript">
		$(document).ready(function () {
			// if($("#elm1").length > 0){
				tinymce.init({
					selector: "textarea#elm1View",
					theme: "modern",
					height:300,
					plugins: [
						"advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker",
						"searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
						"save table contextmenu directionality emoticons template paste textcolor"
					],
					toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | l      ink image | print preview media fullpage | forecolor backcolor emoticons",
					style_formats: [
						{title: 'Bold text', inline: 'b'},
						{title: 'Red text', inline: 'span', styles: {color: '#ff0000'}},
						{title: 'Red header', block: 'h1', styles: {color: '#ff0000'}},
						{title: 'Example 1', inline: 'span', classes: 'example1'},
						{title: 'Example 2', inline: 'span', classes: 'example2'},
						{title: 'Table styles'},
						{title: 'Table row 1', selector: 'tr', classes: 'tablerow1'}
					]
				});
			}
		// }
		);
	</script>
	<!-- DateRangePicker -->
	<script src="${path}/resources/bootstrap-minton/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- Dropzone js -->
	<script src="${path}/resources/bootstrap-minton/plugins/dropzone/dropzone.js"></script>
	<!-- chatjs  -->
	<script src="${path}/resources/bootstrap-minton/assets/pages/jquery.chat.js"></script>
	<!-- Moment  -->
	<script src="${path}/resources/bootstrap-minton/plugins/moment/moment.js"></script>

	<script src="${path }/resources/bootstrap-minton/assets/pages/jquery.form-advanced.init.js"></script>
</body>
</html>
