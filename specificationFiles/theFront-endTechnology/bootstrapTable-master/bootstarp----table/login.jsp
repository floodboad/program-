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
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>



    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">请登陆</h3>
                    </div>
                    <div class="panel-body">
                        <form id="accountform" role="form" action="/login/login"   method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="账号"   id="account" name="account" type="account" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="密码" id="password"  name="password" type="password" value="">
                                </div>
                                <div class="form-group">                               	
                                    <input class="form-control" placeholder="验证码" id="code"  name="code" type="code"   style="width: 100px;">
                                    <a  style="position: absolute; right:100px;bottom:100px;"  href="javascript:void(0);" onclick="VerificationCode()">
                                        <img id="randCodeImage"    alt="验证码"  src="/VerificationCode/generate" width="100" height="32"/>
                                    </a>
                                </div>
                                <a   id="login" class="btn btn-lg btn-success btn-block">登陆</a>
                            </fieldset>
                        </form>
                    </div>
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





    <!-- jQuery -->
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
    
    
    
    <script type="text/javascript">

    	function VerificationCode(){
       		 var rad = Math.floor(Math.random() * Math.pow(10, 8));
        	 $("#randCodeImage").attr("src", "/VerificationCode/generate?uuuy="+rad);
        }


   		 $("#login").bind("click",function () {
            var account= $("#account").val().trim();
            var password=$("#password").val().trim();
            var code= $("#code").val();
             if(account==""||password==""){
                 $("#remind").html("账号或密码为空")
                 $('#modalremind').modal('show');
                 return;
             }



             $.ajax({
                 type:'POST',
                 url:'/login/checkcode',
                 data:{"code":code},
                 async:false,
                 cache:false,
                 success:function(data){
                    if(data=="false"){
                        $("#remind").html("验证码错误")
                        $('#modalremind').modal('show');
                    }
                     if(data=="true"){

                         $.ajax({
                             type:'POST',
                             url:'/login/checkaccount',
                             data:{"account":account,"password":password},
                             async:false,
                             cache:false,
                             success:function(data){
                                 if(data=="false"){
                                     $("#remind").html("账号或密码错误")
                                     $('#modalremind').modal('show');
                                 }
                                 if(data=="true"){
                                     $("#accountform").submit();
                                 }
                             }
                         });
                     }
                 }
             });

         })


    </script>

</body>

</html>
