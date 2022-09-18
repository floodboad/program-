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

					width: 950px;
				}

				#equtable td {
					vertical-align: middle;
				}

				select{
					border-radius: 4px;
					border: 1px solid #cccccc;
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
						<h1 class="page-header">设备管理</h1>
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
								<!--  <div id="toolbar" class="input-group" style="width: 280px;">
                            <input id="username" type="text" class="form-control" style="height:30px"
                                   placeholder="请输入用户名称">
                            <span id="search" class="input-group-addon btn btn-primary">搜索</span>
                            <span id="refresh" class="input-group-addon btn btn-primary">刷新</span>
                                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增

                            
                        </div>-->
                        
                        					
						<div id="toolbar" class="btn-group">
						<button id="btn_add" type="button" class="btn btn-default" >
               			 <span class="glyphicon glyphicon-plus" aria-hidden="true" ></span>新增
            			</button>
            			
						<button id="btn_edit" type="button" class="btn btn-default">
              			  <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
          				</button>        				 
          				
						<button id="btn_delete" type="button" class="btn btn-default">
                		<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            			</button>
            			
            			<button id="btn_refresh" type="button" class="btn btn-default">
                		<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>刷新
            			</button>
            	
						</div> 


 						<div id="searchtoolbar" style="position: absolute;top: 68px;right: 31px; width:200px;" class="input-group" >
                            <input id="username" type="text" class="form-control col-xs-1" style="height:34px;"placeholder="请输入设备名称">
                            <span id="btn_search"   class="input-group-addon btn btn-primary">搜索</span>
                        </div>

 
						
		
								<table width="100%" id="findAllEqu"></table>
							</div>
							<!-- /.panel-body -->
						</div>
					</div>
				</div>
				<!-- /#page-wrapper -->
			</div>
			
			
			
		
		
		
		     <div class="modal fade" id="modal_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog"  style="width:1050px;" >
                    <div class="modal-content"    >
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabeltitle">
                         		    增加XX
                            </h4>
                        </div>
                        <div class="modal-body">

							<form id="equedit">
							<table id="equtable" class="table table-bordered">

								<tr>
									<td  style="text-align: right; width: 100px ">设备名称</td>
									<td  style="text-align: right; width: 200px " ><input  id="equname"  type="text" class="form-control" style="width: 200px" ></td>
									<td  style="vertical-align: middle;text-align: right;width: 100px ">省、市、县</td>
									<td id="citycontext">

										<div  id="city">
											<select id="p"  style="height: 34px"></select>
											<select id="c"  style="height: 34px"></select>
											<select id="a"  style="height: 34px"></select>
										</div>

									</td>
								</tr>
								<tr>
									<td   style="text-align: right;"><span style="color: red;">*</span> MAC地址</td>
									<td><input  id="equmac" type="text" class="form-control" style="width: 200px" ></td>
									<td  style="text-align: right;">详细地址</td>
									<td><input  id="address" type="text" class="form-control" style="width: 200px" ></td>
								</tr>
								<tr>
									<td  style="text-align: right;">经度</td>
									<td><input id="x" type="number" class="form-control" style="width: 200px" ></td>
									<td  style="text-align: right;">纬度</td>
									<td><input id="y" type="number" class="form-control" style="width: 200px" ></td>
								</tr>

							<%--	<tr>
									<td >传感器模版类型</td>
									<td colspan="3" >在在在在在在在在在在在在在在在在在在在在在在在在在在在在在在在在在在在在</td>
								</tr>
--%>

							</table>

							</form>

                        </div>
                        
                        
                        
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭 </button>
                            <button id="modal_submit" type="button" class="btn btn-primary">提交</button>
                        </div>
                    </div>
                </div>
            </div>

		
		
		
		
		
		
		       <div class="modal fade" id="modalremind" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                                提示
                            </h4>
                        </div>
                        <div  id="remind" class="modal-body">
                                              
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                        </div>
                    </div>
                </div>
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
				$('#findAllEqu').bootstrapTable('destroy');
				$('#findAllEqu').bootstrapTable({
					url: '/findAllEqu', //请求后台的URL（*）
					toolbar: '#toolbar', 
					toolbarAlign:"left",
					method: 'post',
					showExport: false, //是否显示导出
					search: false,
					exportDataType: "all", //basic', 'all', 'selected'.
					pagination: true, //是否显示分页（*）
					sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
					pageNumber: 1, //初始化加载第一页，默认第一页
					pageSize: 10, //每页的记录行数（*）
					pageList: [10, 25, 50, 100], //可供选择的每页的行数（*）
					queryParamsType: "limit",
					queryParams: function queryParams(params) { //设置查询参数
						var param = {
							limit: params.limit,
							offset: params.offset,
					     	search: $('#username').val()
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
						title: '设备名称'
					}, {
						field: 'mac',
						title: 'mac地址'
					}, {
						field: 'province',
						title: '省'
					}, {
						field: 'city',
						title: '市'
					}, {
						field: 'area',
						title: '区县'
					}, 
					
					{
						field: 'address',
						title: '详细地址'
					},
					{
						field: 'longitude',
						title: '经度'
					},
					{
						field: 'latitude',
						title: '纬度'
                   },
					{
						field: 'state',
						title: '设备状态',
						formatter:function(value,row,index){
							var type;
							if (value==0) {
								type="离线";
							}else {
								type="在线";
							}
                            return type;
                    }
						
					},
					
					{
						field: 'time',
						title: '创建日期',
						formatter: function(value) {
							var date = new Date(value);
							var y = date.getFullYear();
							var m = date.getMonth() + 1;
							var d = date.getDate();
							var h = date.getHours();
							var i = date.getMinutes();
							var s = date.getSeconds();
							return y + '-' + (m < 10 ? '0' + m : m) + '-' + (d < 10 ? '0' + d : d) + ' ' + (h < 10 ? '0' + h : h) + ':' + (i < 10 ? '0' + i : i) + ':' + (s < 10 ? '0' + s : s);
						}
					}]
				});
			}







          

			$(function() {
                $("#city").distpicker();

                initTable();
				$('#findAllEqu').bootstrapTable('hideColumn',"id");
				$('#btn_search').bind("click", initTable)
				$('#username').bind('keypress', function(event) {
					if(event.keyCode == 13) {
						initTable();
					}
				});
				
				$('#btn_refresh').bind("click", function() {
					window.location.reload();
				})



				$('#btn_delete').bind("click", function() {
					
					
				bootbox.confirm({
    			title: "删除设备",
    			message: "确定要删除选中的设备吗？",
   			 	buttons: {
        		cancel: {
            			label: '<i class="fa fa-times"></i> 取消'
        		},
        		confirm: {
            		    label: '<i class="fa fa-check"></i> 确定'
        		}
    			},
    			callback: function (result) {
    			  
    			  if(result){
    			  var rows=$('#findAllEqu').bootstrapTable('getSelections');
				 if(rows.length==0){
					 return;
				}
	
			var ids=new Array();
			for (var i = 0; i < rows.length; i++) {	 
				ids.push(rows[i].id)
			}
					
		
					
			    $.ajax({
             	type:'POST',
                url:'/deleteEqu',
                data:{"ids":ids},
                async:false,
                cache:false,
                success:function(data){ 
                	
                	 $("#remind").html("删除成功")
                	 $('#modalremind').modal('show');
                	
                     $('#modalremind').on('hide.bs.modal', function () {                      	
                      $(this).off('hide.bs.modal');                                            
    	     		    window.location.reload();
					 })                                                   
                }
            });

    	  }
    			  
    			  
    			}
				});   
 	
			      		
					
					
			
												
			})






         
                
         
         
	       $('#btn_add').bind("click", function() {
 			  $("#myModalLabeltitle").html("新增设备")
      		  $('#modal_add').modal('show');
      		  //绑定增加用户时的提交事件      		   
      		  var url='/addequ'
      		   modalsubmit(url,"add","addequ");
           })   
      
      

      
        //提交动作         
        function modalsubmit(url,opt,id){
        	$('#modal_submit').bind("click", function() {

        	    var mac= $("#equmac").val();
                var m=$.trim(mac);

                if(""==m){
                    $("#remind").html("mac不能为空");
                    $('#modalremind').modal('show');
					return;
				 }

                var title;


             var message;
        	 if(opt=="edit"){
        	 	title="修改设备";
        	 	message="是否确定修改设备";
              }
        	 
        	 
        	 if(opt=="add"){
        	 	title="增加设备";
        	 	message="是否确定增加设备";
              }
        	 

                   bootbox.confirm({
                   title: title,
    		    	 message:message,
   				     buttons: {
       				 cancel: {
            		label: '<i class="fa fa-times"></i> 取消'
      	   			 },
       				 confirm: {
            		 label: '<i class="fa fa-check"></i> 确定'
      		 			   }
    				},
    				callback: function (result) {
    					
    					if(result){
    						
    				
    						 
    		var name=  $("#equname").val();
			var address=$("#address").val();
			var longitude= $("#x").val();
			var latitude= $("#y").val();
			var province=$("#p option:selected").val();
			var city=$("#c option:selected").val();
			var area=$("#a option:selected").val();


			var p;

		    if(id=="addequ"){
		    	 p={"name":name,"mac":mac,"address":address,"longitude":longitude,"latitude":latitude,"province":province,"city":city,"area":area};
		    }else{
                 p={"id":id,"name":name,"mac":mac,"address":address,"longitude":longitude, "latitude":latitude,"province":province,"city":city,"area":area};
		    }
		       
		   
		    var s=JSON.stringify(p);

			    $.ajax({
                type:'POST',
                url:url,
                contentType: "application/json;charset=UTF-8",
                dataType:'json',
                data:s,
                async:false,
                cache:false,
                success:function(data){
                	
                if(opt=="add"){               		               	        	
                	if (data=="true") {
                	
                	 $("#remind").html("增加成功") 
                	 $('#modalremind').modal('show');


	                 $('#equedit')[0].reset();
	                 $("#city").distpicker("reset")



                    } else{
                		$("#remind").html("增加失败,检查mac是否复重")
                		$('#modalremind').modal('show');
                	}
                	
                }
                   
                
                if(opt=="edit"){    
                	
                	 	if (data=="true") {
                	 		
                	    $("#remind").html("修改成功")
                		$('#modalremind').modal('show');
                		      				                  		
                	} else{
                		               		
                		$("#remind").html("修改失败")
                		$('#modalremind').modal('show');
                	}             	
                }
                                                           	
               }
                             
            });	
  						
    					}
 			  
   				  }
			});       	        				                   
		})
    	
      }
        
	

	 
	 

		 $('#modal_add').on('hide.bs.modal', function () {
     		 //清空所有输入值，取消所有所有选中          		 		
     	    /*$(':input','#equedit').val("");*/
     		 
     		 $('#equedit')[0].reset();

     		 window.location.reload();

     		 /*     		   
     		  $("input[type='radio']").removeAttr('checked');    		   
     		  $(":checked").removeAttr('checked');*/
		 })

  
  
  
  
  
  
  
  		 $('#btn_edit').on('click', function () {
  		 	
  		 	var rows=$('#findAllEqu').bootstrapTable('getSelections');
				if(rows.length==0){					
					   $("#remind").html("请选要修改的设备")
                		$('#modalremind').modal('show');
									  
					 return;
				}else if(rows.length>1){
				
					  $("#remind").html("一次只能修改一个设备")
                	$('#modalremind').modal('show');				 
					 return;					
				}
  
		       
     		 $("#equname").val(rows[0].name);
			 $("#equmac").val(rows[0].mac);
			 $("#address").val(rows[0].address);
			 $("#x").val(rows[0].longitude);
			 $("#y").val(rows[0].latitude);

             var province=rows[0].province;
             var city=rows[0].city;
             var area=rows[0].area;

             $("#citycontext").html('<div  id="city"> <select id="p" style="height: 34px" ></select> <select  id="c" style="height: 34px"	></select> <select  id="a" style="height: 34px" ></select> </div>')

             $("#city").distpicker({
                 province:province,
                 city:city,
                 district:area
             });

             $("#equmac").attr("disabled","disabled");

             $("#myModalLabeltitle").html("修改设备")
             $('#modal_add').modal('show');
   		   
     		 //修改用户界面的提交动作,在这里提交
     		 var url='/editequ';
      		 modalsubmit(url,"edit",rows[0].id);     		     		    		 
     		 
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