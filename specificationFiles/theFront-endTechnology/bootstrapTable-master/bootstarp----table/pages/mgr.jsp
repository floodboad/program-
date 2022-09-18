<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">

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

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link rel="stylesheet" type="text/css" href="../vendor/font-awesome/css/font-awesome.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script src="../echarts/echarts.common.min.js"></script>


    <style>
        #htable{
            text-align: center;
            width:100%;
            table-layout: fixed
        }
        #htable td{
            height: 83px;
            background: url('/pages/tdbg.png')no-repeat center top;
        }

        .value {
            display: inline-block;
            position: relative;
            left: -18px;
            top: -18px;


        }

        .sensor{
            display: inline-block;
            position: relative;
            left: 6px;
            top: 10px;
            font-weight:bold;

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
                            <!-- /input-group -->
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
                            <!-- /.nav-second-level -->

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
                    <h1 class="page-header">首页</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">

                <div class="col-lg-8" >

                    <div >
                        <table  id="htable">
                            <tr>
                                <td ><span id="n0" class="sensor"></span><span class="value" id="v0" style="left:-21px"></span></td>
                                <td ><span id="n1" class="sensor"></span><span class="value" id="v1"></span></td>
                                <td ><span id="n2" class="sensor"></span><span class="value" id="v2" style="left:-12px"></span></td>
                                <td ><span id="n3" class="sensor"></span><span class="value" id="v3"></span></td>
                                <td ><span id="n4" class="sensor"></span><span class="value" id="v4" style="left:-12px" ></span></td>
                                <td ><span id="n5" class="sensor"></span><span class="value" id="v5" style="left:-15px" ></span></td>
                            </tr>
                        </table>
                    </div>
                    <br><br>
                    <div>
                        <i class="fa  fa-map-marker fa-fw"></i>取样监测点 &nbsp; <a href ="javascript:void(0)"  id="achange" >换一批</a>
                        <small style="display: inline-block;position: relative;top: 5px" class="pull-right">数值单位：mg/m3（PM2.5、PM10 为 μg/m3）</small>
                    </div>
                    <br>

                    <div class="table-responsive">
                        <table class="table table-bordered table-hover table-striped">
                            <thead>
                            <tr>
                                <th>监测点</th>
                                <th>PM 2.5</th>
                                <th>PM 10</th>
                                <th>CO</th>
                                <th>NO2</th>
                                <th>O3</th>
                                <th>SO2</th>
                            </tr>
                            </thead>
                            <tbody id="randpoint"></tbody>
                        </table>
                    </div>
                    <div>
                    <a href="/pointdata" class="btn btn-default btn-block">查看更多监测点<i class="fa fa-angle-double-right fa-fw"></i></a>
                    </div>
                </div>

                <div class="col-lg-4 ">
                    <div  id="equtotal" style="position: absolute;top: 180px;right: 19px"></div>
                    <div style="margin-top:130px;height: 400px" id="onandoff"></div>
                </div>

            </div>
            <br><br><br>
            <div class="row">
                <div class="col-lg-6">
                    <div  style="height:500px" id="top10"></div>
                </div>
                <div class="col-lg-6">
                    <div  style="height:500px" id="last10"></div>
                </div>
            </div>

            <br><br><br><br><br><br>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-arrow-up   fa-fw"></i>监测点空气质量前100
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">

                            <div  style="margin-top: 10px" class="table-responsive">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                    <tr>
                                        <th>排名</th>
                                        <th>监测点</th>
                                        <th>PM 2.5</th>
                                        <th>PM 10</th>
                                        <th>CO</th>
                                        <th>NO2</th>
                                        <th>O3</th>
                                        <th>SO2</th>
                                    </tr>
                                    </thead>
                                    <tbody id="toppoint"></tbody>
                                </table>
                            </div>


                        </div>
                        <!-- /.panel-body -->
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>


    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="../vendor/raphael/raphael.min.js"></script>
    <script src="../vendor/morrisjs/morris.min.js"></script>


    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

    <script>




        $(function(){

          function randpoint(){
            $.ajax({
                type:'GET',
                url:'/randpoint',
                contentType: "application/json;charset=UTF-8",
                dataType:'json',
                async:true,
                cache:false,
                success:function(data){
                    $("#randpoint").html("");

                    var points=data.data;
                    var avg   = data.avg;

                    var sensor=new Array('PM2.5','PM10','CO','NO2','O3','SO2');

                    for(var i=0;i<avg.length;i++){
                        var ids="v"+i;
                        $("#"+ids).html(avg[i]);
                        var idns="n"+i;
                        $("#"+idns).html(sensor[i]);
                    }

                    for(var i=0;i<points.length;i++){
                        var name=points[i].name;
                        var pm25=points[i].pm25;
                        var pm10=points[i].pm10;
                        var co=points[i].co;
                        var no2=points[i].no2;
                        var o3=points[i].o3;
                        var so2=points[i].so2;
                        $("#randpoint").append("<tr> <td>"+name+"</td>  <td>"+pm25+"</td> <td>"+pm10+"</td> <td>"+co+"</td> <td>"+no2+"</td> <td>"+o3+"</td><td>"+so2+"</td></tr>");
                    }
                }
            });
        }


            randpoint();


            $("#achange").bind("click",function(){
                randpoint();
            })


            //在线离线比
            var pie = echarts.init(document.getElementById('onandoff'));

            pieoption = {
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c} ({d}%)"
                },
                color:['green', 'gray'],
                legend: {
                    orient: 'vertical',
                    x: 'right',
                    data:['在线设备','离线设备']
                },
                series: [
                    {
                        name:"",
                        type:'pie',
                        radius: ['50%', '70%'],
                        avoidLabelOverlap: false,
                        label: {
                            normal: {
                                show: false,
                                position: 'center'
                            },
                            emphasis: {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'bold'
                                }
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            }
                        },
                        data:[
                            {value:0, name:'在线设备'},
                            {value:0, name:'离线设备'}
                        ]
                    }
                ]
            };


            $.ajax({
                type:'GET',
                url:'/screen/equcount',
                data:{area:""},
                dataType:'json',
                async:true,
                cache:false,
                success:function(data){
                    var o=JSON.parse(data.data);
                    var on=o.ok+o.warn;
                    var off=o.offline;
                    var total=on+off;

                    pieoption.series[0].name='设备总数: '+total;
                    pieoption.series[0].data[0].value=on;
                    pieoption.series[0].data[1].value=off;
                    pie.setOption(pieoption);

                    $("#equtotal").html("");
                    $("#equtotal").html("<strong>设备总数："+total+"台</strong>");


                }
            });




            // 基于准备好的dom，初始化echarts实例
            var top = echarts.init(document.getElementById('top10'));
            var last = echarts.init(document.getElementById('last10'));


            // 指定图表的配置项和数据
            topoption ={
                 color: ['#3398DB'],
                 title: {
                 text: '监测点即时空气质量前十名',
                 subtext: '据PM2.5排序',
                 x:"center"
                 },
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        data : ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun','Mon', 'Tue', 'Wed'],
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        axisLabel: {
                            formatter:'{value}'+'ug/m3'
                        }
                    }
                ],
                series : [
                    {
                        name:'PM2.5值',
                        type:'bar',
                        barWidth: '50%',
                        data:[10, 52, 200, 334, 390, 330, 220,200,100,600]
                    }
                ]
            };


            // 指定图表的配置项和数据
            lastoption = {
                color: ['#3398DB'],
                title: {
                    text: '监测点即时空气质量后十名',
                    subtext: '据PM2.5排序',
                    x:"center"
                },
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {      // 坐标轴指示器，坐标轴触发有效
                        type : 'line'    // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        data : ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun','Mon', 'Tue', 'Wed'],
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        axisLabel: {
                            formatter:'{value}'+'ug/m3'
                        }
                    }
                ],
                series : [
                    {
                        name:'PM2.5值',
                        type:'bar',
                        barWidth: '50%',
                        data:[10, 52, 200, 334, 390, 330, 220,200,100,600]
                    }
                ]
            };



            $.ajax({
                type:'GET',
                url:'/top100',
                contentType: "application/json;charset=UTF-8",
                dataType:'json',
                async:true,
                cache:false,
                success:function(data){
                   var top100= data.top100;
                   var top10=  data.top10;
                   var last10= data.last10;

                   var j= JSON.parse(data);

                   var top100=j.top100;
                   var top10=j.top10;
                   var last10=j.last10;

                   var top10name=  new  Array();
                   var top10pm25=  new  Array();

                   for(var i=0;i<top10.length;i++){
                      var name= top10[i].name;
                      var pm25= top10[i].pm25;

                      top10name.push(name)
                      top10pm25.push(pm25)
                   }

                    topoption.xAxis[0].data=top10name;
                    topoption.series[0].data=top10pm25;


                    var last10name=  new  Array();
                    var last10pm25=  new  Array();

                    for(var i=0;i<top10.length;i++){
                        var name= last10[i].name;
                        var pm25= last10[i].pm25;

                        last10name.push(name)
                        last10pm25.push(pm25)
                    }

                    lastoption.xAxis[0].data=last10name;
                    lastoption.series[0].data=last10pm25;

                    $("#toppoint").html("");

                    for(var i=0;i<top100.length;i++){
                        var name=top100[i].name
                        var pm25=top100[i].pm25
                        var pm10=top100[i].pm10
                        var co=top100[i].co
                        var no2=top100[i].no2
                        var o3=top100[i].o3
                        var so2=top100[i].so2

                        var n=i+1;

                        $("#toppoint").append("<tr><td>"+n+"</td> <td>"+name+"</td>  <td>"+pm25+"</td> <td>"+pm10+"</td> <td>"+co+"</td> <td>"+no2+"</td> <td>"+o3+"</td><td>"+so2+"</td></tr>");

                    }


                    top.setOption(topoption);
                    last.setOption(lastoption);

                }
            });






            $("#logouts").bind("click",function () {
                $.ajax({
                    type:'GET',
                    url:'/login/logout',
                    async:true,
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
