<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>三级警报数据展示</title>
    <script type="application/javascript" src="easyui/jquery.min.js"></script>
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0
        }

        ul, li, h2, h3 {
            padding: 0;
            margin: 0;
            list-style: none;
            font-weight: normal
        }

        h2 {
            line-height: 42px;
            font-size: 18px;
            color: #444;
            padding: 0 10px;
            border-top: 1px solid #eee;
            background: -webkit-linear-gradient(top, #fbfbfb, #ccc)
        }

        .list {
            padding: 10px;
            font-size: 14px;
            color: #666
        }

        .list li {
            line-height: 28px
        }

        .list li span {
            padding: 5px 8px;
            border-radius: 5px
        }

        .list li .grade00 {
            background-color: #25d9d2;
            color: #fff
        }

        .list li .grade01 {
            background-color: #fdf24a;
            color: #555
        }

        .list li .grade02 {
            background-color: #fe926f;
            color: #fff
        }

        .list li .grade03 {
            background-color: #fd416e;
            color: #fff
        }
    </style>

</head>

<body>

<jsp:useBean id="myDate" class="java.util.Date"/>
<c:set target="${myDate}" property="time" value="${time}"/>

<h2>警报信息</h2>
<ul class="list">
    <li>MAC： ${equipment.mac}</li>
    <li>名称：${equipment.name}</li>
    <li>地点：${equipment.address}</li>
    <li>时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${myDate}" type="both"/></li>

    <c:if test="${level==3}" var="aaa" scope="page">
        <li>级别：<span class="grade03">三级</span></li>
    </c:if>
    <c:if test="${level==2}" var="aaa" scope="page">
        <li>级别：<span class="grade02">二级</span></li>
    </c:if>
    <c:if test="${level==1}" var="aaa" scope="page">
        <li>级别：<span class="grade01">一级</span></li>
    </c:if>
</ul>

<h2>坐标位置</h2>
<ul class="list">
    <li>经度：${equipment.longitude}</li>
    <li>纬度：${equipment.latitude}</li>
</ul>


<h2>详细数据</h2>
<ul class="list">
    <c:forEach var="wx" items="${wxmap}">
        <li>${wx.key}: ${wx.value}</li>
    </c:forEach>
</ul>



</body>
</html>
