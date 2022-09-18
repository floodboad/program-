<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>大屏系统后台任务数据</title>

		<!-- Bootstrap Core CSS -->
		<link rel="stylesheet" type="text/css" href="../vendor/bootstrap/css/bootstrap.min.css">

		<!-- MetisMenu CSS -->
		<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

		<!-- DataTables CSS -->
		<link href="../vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

		<!-- DataTables Responsive CSS -->
		<link href="../vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

		<!-- Custom CSS -->
		<link href="../dist/css/sb-admin-2.css" rel="stylesheet">

		<!-- Custom Fonts -->
		<link rel="stylesheet" type="text/css" href="../vendor/font-awesome/css/font-awesome.min.css">

		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

		<link rel="stylesheet" type="text/css" href="../bootstrap-table/bootstrap-table.min.css">
			
		<link rel="stylesheet" type="text/css" href="../multiple/bootstrap-multiselect.css"/>
			
			
			<style type="text/css">

				#equtable {
					margin: auto;
					margin-top: 30px;
					margin-bottom: 30px;

					width: 800px;
				}

				#equtable td {
					vertical-align: middle;
				}

				select{
					border-radius: 4px;
					border: 1px solid #cccccc;
				}

 	  			#table_user {				
				margin: auto;
				border: 0px;
				width: 500px;
			}
			



			#table_user td {
				border: 0px ;
				vertical-align: middle;	
			}
			
			
			.tdleft{
				text-align: right;    
			}
			
			
			#name,#mobile,#password,#confirmpw,#email,#weixin,#organization,#nickname,#user_type{
				width: 200px;				
			} 




		</style>
			

	</head>

	<body>

		<div id="wrapper">

			<!-- Navigation -->
			<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/mgr">大屏系统后台任务数据</a>
				</div>
				<!-- /.navbar-header -->
				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
							欢迎您  ${username} &nbsp;<i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
						</a>
						<ul class="dropdown-menu dropdown-user">
							<li><a  id="logouts"><i class="fa fa-sign-out fa-fw"></i> 注销</a></li>
						</ul>
						<!-- /.dropdown-user -->
					</li>
					<!-- /.dropdown -->
				</ul>
				<!-- /.navbar-top-links -->

				<div class="navbar-default sidebar" role="navigation">
					<div class="sidebar-nav navbar-collapse">
						<ul class="nav" id="side-menu">
						<li class="sidebar-search">
								<div class="input-group custom-search-form">
									<input type="text" class="form-control" placeholder="Search...">
									<span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
								</div>
							</li>


							<li>
								<a href="/mgr"><i class="fa   fa-home fa-fw"></i> 首页</a>
							</li>

							 <li>
							<a href="index.html"><i class="fa   fa-gear   fa-fw"></i> 系统管理<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li>
									<a href="/equ">设备管理</a>
								</li>
								<li>
									<a href="/monitorpoint">监测点管理 </a>
								</li>
								<li>
								</li>
							</ul>
							</li>


							<li>
								<a href="index.html"><i class="fa   fa-search   fa-fw"></i> 数据查询<span class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li>
										<a href="/pointdata">监测点数据</a>
									</li>
									<li>
										<a href="/history">历史数据</a>
									</li>
									<li>
									</li>
								</ul>
							</li>

							<li>
								<a href="index.html"><i class="fa  fa-bar-chart-o  fa-fw"></i> 报表系统<span class="fa arrow"></span></a>
								<ul class="nav nav-second-level">
									<li>
										<a href="/sensor">传感器</a>
									</li>
									<li>
									</li>
								</ul>
							</li>


						</ul>
					</div>
					<!-- /.sidebar-collapse -->
				</div>
				<!-- /.navbar-static-side -->
			</nav>

			<div id="page-wrapper">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">监测点数据</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								Equipment Management
							</div>
							<!-- /.panel-heading -->
		
							<div class="panel-body">

						<div id="toolbar" class="btn-group">


						</div>


 						<div id="searchtoolbar" style="position: absolute;top: 68px;left: 31px; width:200px;" class="input-group" >
                            <input id="pointname" type="text" class="form-control col-xs-1" style="height:34px;"placeholder="请输入监测点名称">
                            <span id="btn_search"   class="input-group-addon btn btn-primary">搜索</span>
                        </div>
		
								<table width="100%" id="allpoint"></table>
							</div>
							<!-- /.panel-body -->
						</div>
					</div>
				</div>
				<!-- /#page-wrapper -->
			</div>
			
			
			
		
		

		
		
		
		

		

		
		
		</div>
		<!-- /#wrapper -->

		<!-- jQuery -->
		<script src="../vendor/jquery/jquery.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

		<!-- Metis Menu Plugin JavaScript -->
		<script src="../vendor/metisMenu/metisMenu.min.js"></script>

		<!-- Custom Theme JavaScript -->
		<script src="../dist/js/sb-admin-2.js"></script>

		<script src="../bootstrap-table/bootstrap-table.min.js"></script>
		<script src="../bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
		
		
		<script src="../multiple/bootstrap-multiselect.js" type="text/javascript" charset="utf-8"></script>
		
		<script src="../bootbox/bootbox.min.js" type="text/javascript" charset="utf-8"></script>


		<script src="../distpicker/distpicker.js" type="text/javascript" charset="utf-8"></script>

		<!-- Page-Level Demo Scripts - Tables - Use for reference -->
		<script type="text/javascript">

			function initTable() {
                $('#allpoint').bootstrapTable('destroy');
				$('#allpoint').bootstrapTable({
					url: '/allPointInstantData',
					toolbar: '#toolbar', 
					toolbarAlign:"left",
					method: 'post',
					showExport: false,
					search: false,
					exportDataType: "all",
					pagination: true,
					sidePagination: "server",
					pageNumber: 1,
					pageSize: 10,
					pageList: [10, 25, 50, 100],
					queryParamsType: "limit",
					queryParams: function queryParams(params) {
						var param = {
							limit: params.limit,
							offset: params.offset,
					     	search: $('#pointname').val()
						};
						return param;
					},
					columns: [
					{
                checkbox: true
           			},
            		{
						field: 'id',
						title: 'id'
					},
					{
						field: 'name',
						title: '监测点',
                        formatter:function(value,row,index){

                            return '<a href="/mgr" target="_blank">'+value+'</a>';
                        }
					},

                    {
                        field: 'equcount',
                        title: '设备数量'
                    } ,
                        {
                            field: 'address',
                            title: '监测地址'
                        } ,
					{
						field: 'pm25',
						title: 'PM 2.5'
					}, {
						field: 'pm10',
						title: 'PM 10'
					}, {
						field: 'co',
						title: 'CO'
					}, {
						field: 'no2',
						title: 'NO2'
					}, 
					
					{
						field: 'o3',
						title: 'O3'
					},
					{
						field: 'so2',
						title: 'SO2'
					}

					]
				});
			}




			$(function() {
                initTable();
				$('#allpoint').bootstrapTable('hideColumn',"id");
				$('#btn_search').bind("click", initTable)
				$('#pointname').bind('keypress', function(event) {
					if(event.keyCode == 13) {
						initTable();
                        $('#allpoint').bootstrapTable('hideColumn',"id");
                    }
				});
				
				$('#btn_refresh').bind("click", function() {
					window.location.reload();
				})




                    $("#logouts").bind("click",function () {
                    $.ajax({
                        type:'GET',
                        url:'/login/logout',
                        async:false,
                        cache:false,
                        success:function(data){
                            if(data=="true"){
                                window.location.href='/login'

                            }
                        }
                    });

                })



			})
		</script>

	</body>

</html>