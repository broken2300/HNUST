<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
String path =request.getContextPath();
String basePath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">


</style>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"> 
<link href="../css/style.css" rel="stylesheet" type="text/css"> 



<style type="text/css">
body {
font-size: 12px;
margin: 0px;
padding: 0px;
background-color:#F3F3F3
}
#pic{
margin:0 auto;
width:100%;
padding:0;
}
#pic img{
max-width:758px;
myimg:expression(
onload=changeSize(this, 758)
);
}

.container { width:1170px;max-width:none !important;}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>变化趋势</title>
</head>

<body >




<div class="container" >

  <div class="row">
  <div  class="col-xs-12">
  <img src="../pic/123.png">
  </div>
  
  </div>

<div class="row">
	  <div class="col-xs-12"> 
	  <ul class="nav nav-tabs bg-info">
	  <li role="presentation" ><a href="/org.zsl.hnust/test/index">首页</a></li>
	  <li role="presentation" class="dropdown">
		  <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
		  空气质量报告 <col-xs- class="caret"></col-xs->
		</a>
		<ul class="dropdown-menu">
		  <li role="presentation"><a href="/org.zsl.hnust/test/AQI">AQI实时报</a></li>
		  <li role="presentation"><a href="/org.zsl.hnust/test/pollution">污染物分类报告</a></li>
		</ul>
	  </li>
	    
	  <li role="presentation" class="dropdown active">
		  <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
		  变化趋势及预测 <col-xs- class="caret"></col-xs->
		</a>
		<ul class="dropdown-menu">
		  <li role="presentation"><a href="/org.zsl.hnust/test/CT">过去30天</a></li>
		  <li role="presentation"><a href="/org.zsl.hnust/test/CT">未来一天</a></li>
		  <li role="presentation"><a href="/org.zsl.hnust/test/CT">未来一周</a></li>
		</ul>
	  </li>
	  
	<li role="presentation" ><a href="/org.zsl.hnust/test/introduce">说明及指南</a></li>
	  </ul> 
	  </div>
	  </div>
 
 
 
 
  <div class="row" style="background:#FFF;margin-left:1px;;margin-right:1px">

  <div class="col-md-8"  style="margin-left:-16px">
<div class="btn-group" role="group" aria-label="...">
  <button type="button" class="btn btn-default" onclick="changeCategeryForLine('AQI')">AQI</button>
  <button type="button" class="btn btn-default" onclick="changeCategeryForLine('PM2.5')">PM<sub>2.5<sub></button>
  <button type="button" class="btn btn-default" onclick="changeCategeryForLine('PM10')">PM<sub>10<sub></button>
  <button type="button" class="btn btn-default" onclick="changeCategeryForLine('SO2')">SO<sub>2<sub></button>
  <button type="button" class="btn btn-default" onclick="changeCategeryForLine('NO')">NO<sub>2<sub></button>
  <button type="button" class="btn btn-default" onclick="changeCategeryForLine('CO')">CO</button>
  <button type="button" class="btn btn-default" onclick="changeCategeryForLine('O3')">O<sub>3<sub></button>
</div>
 </div>
 
  <div class="col-md-4">
  
<div class="btn-group">
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    省份选择 <span class="caret"></span>
  </button>
  <ul id="provinces" class="dropdown-menu">
    <div class="btn-group-vertical" role="group" aria-label="...">
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
      </div>
	 <div class="btn-group-vertical" role="group" aria-label="...">
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
      </div>
	
	 <div class="btn-group-vertical" role="group" aria-label="...">
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
      </div>
	
	 <div class="btn-group-vertical" role="group" aria-label="...">
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
      </div>
	
	 <div class="btn-group-vertical" role="group" aria-label="...">
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
      </div>
	 <div class="btn-group-vertical" role="group" aria-label="...">
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
  <button type="button" class="btn btn-default btn-xs">省份一</button>
      </div>
  </ul>
</div>

<div class="btn-group">
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    城市选择 <span class="caret"></span>
  </button>
  <ul class="dropdown-menu">
    <div class="btn-group-vertical" role="group" aria-label="...">
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
      </div>
	 <div class="btn-group-vertical" role="group" aria-label="...">
   <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
      </div>
	
	 <div class="btn-group-vertical" role="group" aria-label="...">
 <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
  <button type="button" class="btn btn-default btn-xs">城市一</button>
      </div>
	
  </ul>
</div>

<div class="btn-group">
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    站点选择 <span class="caret"></span>
  </button>
  <ul class="dropdown-menu">
    <div class="btn-group-vertical" role="group" aria-label="...">
  <button type="button" class="btn btn-default btn-xs">站点一</button>
  <button type="button" class="btn btn-default btn-xs">站点一</button>
  <button type="button" class="btn btn-default btn-xs">站点一</button>
  <button type="button" class="btn btn-default btn-xs">站点一</button>
  <button type="button" class="btn btn-default btn-xs">站点一</button>
      </div>
	  <div class="btn-group-vertical" role="group" aria-label="...">
  <button type="button" class="btn btn-default btn-xs">站点一</button>
  <button type="button" class="btn btn-default btn-xs">站点一</button>
  <button type="button" class="btn btn-default btn-xs">站点一</button>
  <button type="button" class="btn btn-default btn-xs">站点一</button>
  <button type="button" class="btn btn-default btn-xs">站点一</button>
      </div>
	  <div class="btn-group-vertical" role="group" aria-label="...">
  <button type="button" class="btn btn-default btn-xs">站点一</button>
  <button type="button" class="btn btn-default btn-xs">站点一</button>
  <button type="button" class="btn btn-default btn-xs">站点一</button>
  <button type="button" class="btn btn-default btn-xs">站点一</button>
  <button type="button" class="btn btn-default btn-xs">站点一</button>
      </div>

	
  </ul>
</div>
    
  </div>
 </div>

  
 
 
 

  <div class="row">
  <div class="col-xs-12" >
  
  <div class="panel panel-default" >
    <div class="panel-heading">
	<h4>城市/站点&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<small>数据类型</small></h4>
	</div>
    
  </div>
  </div>
  </div>
  
  <div class="row" style="margin-left:2px;margin-right:2px">
  <div class="col-xs-12" style="background:#FFF;margin-top:-20px">
  <div id="main2" style="width: 100%; height: 400px;  float: left"></div>
</div>
  </div>


</div>




</body>

<script language="javascript" src="../js/jquery-2.2.1.min.js"></script>
<script language="javascript" src="../js/bootstrap.min.js"></script>

<script type="text/javascript" src="../js/echarts.js"></script>
    <script type="text/javascript" src="../js/china.js"></script>

    <!--23个省 -->
    <script type="text/javascript" src="../js/fujian.js"></script>
    <script type="text/javascript" src="../js/guangdong.js"></script>
    <script type="text/javascript" src="../js/qinghai.js"></script>
    <script type="text/javascript" src="../js/sichuan.js"></script>
    <script type="text/javascript" src="../js/hainan.js"></script>
    <script type="text/javascript" src="../js/shanxi.js"></script>
    <script type="text/javascript" src="../js/gansu.js"></script>
    <script type="text/javascript" src="../js/yunnan.js"></script>
    <script type="text/javascript" src="../js/hunan.js"></script>
    <script type="text/javascript" src="../js/hubei.js"></script>
    <script type="text/javascript" src="../js/heilongjiang.js"></script>
    <script type="text/javascript" src="../js/guizhou.js"></script>
    <script type="text/javascript" src="../js/shandong.js"></script>
    <script type="text/javascript" src="../js/jiangxi.js"></script>
    <script type="text/javascript" src="../js/henan.js"></script>
    <script type="text/javascript" src="../js/hebei.js"></script>
    <script type="text/javascript" src="../js/shanxi1.js"></script>
    <script type="text/javascript" src="../js/anhui.js"></script>
    <script type="text/javascript" src="../js/zhejiang.js"></script>
    <script type="text/javascript" src="../js/jiangsu.js"></script>
    <script type="text/javascript" src="../js/jilin.js"></script>
    <script type="text/javascript" src="../js/liaoning.js"></script>
    <script type="text/javascript" src="../js/taiwan.js"></script>

    <!-- 五个自治区 -->
    <script type="text/javascript" src="../js/xinjiang.js"></script>
    <script type="text/javascript" src="../js/guangxi.js"></script>
    <script type="text/javascript" src="../js/ningxia.js"></script>
    <script type="text/javascript" src="../js/neimenggu.js"></script>
    <script type="text/javascript" src="../js/xizang.js"></script>

    <!-- 四个直辖市 -->
    <script type="text/javascript" src="../js/beijing.js"></script>
    <script type="text/javascript" src="../js/tianjin.js"></script>
    <script type="text/javascript" src="../js/shanghai.js"></script>
    <script type="text/javascript" src="../js/chongqing.js"></script>

    <!-- 2个特别行政区 -->
    <script type="text/javascript" src="../js/xianggang.js"></script>
    <script type="text/javascript" src="../js/aomen.js"></script>

    <script type="text/javascript" src="../js/mapEcha.js"></script>
    <script type="text/javascript" src="../js/lineEcha2.js"></script>	

<script type="text/javascript">

	$(function(){
	
		var $provincesContainer = $("#provinces");
		var $citiesContainer = $('#cities');
		var $stationTable = $('#stations');
		globalPCMSs = "";
		var currentProvince = 0;
		var currentCity = 0;
		var endGroup = '</div>';
		var endButton = '</button>';
		var group = '<div class="btn-group" role="group" aria-label="...">';
		var provinceButton = '<button type="button" class="btn btn-link  btn-xs"  >';

		var stationTH = '<tr>'+
							'<td class="active" style="width:105px" >站点</td>'+
							'<td style="width:38px" >PM<sub>2.5</sub></td>'+
							'<td class="warning" style="width:38px" >PM<sub>10</sub></td>'+
							'<td class="danger" style="width:38px" >NO<sub>2</sub></td>'+
							'<td class="info" style="width:38px" >SO<sub>2</sub></td>'+
							'<td class="success" style="width:38px" >CO</td>'+
							'<td class="active" style="width:38px" >O<sub>3</sub></td>'+
						'</tr>';


	// init
		$.getJSON("<%=basePath%>json/PCMSs.json",function(PCMSs){ 
			//alert(PCMSs.provinces[1].name);
			globalPCMSs = PCMSs;
			update($provincesContainer,globalPCMSs,'provinces');
		});
		

		function update($container,datalist,buttonType){
			var contentHTML = '';
			var count = 0;
			var generalButton = provinceButton;

			$.each(datalist,function(n,value){

				if(n % 7 == 0){
        			contentHTML += group;
        		}
        		contentHTML += generalButton;
        		contentHTML += value.name;
        		contentHTML += endButton;

        		if((n + 1) % 7 == 0){
        			contentHTML += endGroup;
        		}
        		count = n;
        	});

        	if((count + 1) % 7 != 0)
        		contentHTML += endGroup;
        	$container.html(contentHTML);

        	
        		$container.find("button").click(function(){
        			var index = $($container.find("button")).index($(this));
        			if(buttonType == 'provinces'){    //  點擊省份事件
        				var provinceName = $(this).html();
        				currentProvince = index;

        				// 更新網頁
        				update($citiesContainer,globalPCMSs[currentProvince].cities,'cities');
                        
        				// 更新地圖等操作
        				setmt(provinceName);

        			}else if(buttonType == 'cities'){   //  點擊城市事件
        				var cityName = $(this).html();
        				
        				currentCity = index;
        				// 更新網頁
        				var stationHTML = stationTH;

        				$.each(globalPCMSs[currentProvince].cities[currentCity].stations,function(n,station){
        					

                                                //  此處添加數據，暫為‘-’
        					stationHTML += '<tr>';
        					stationHTML += '<td class="active" style="width:80px">'+station.name+'</td>';
							stationHTML += '<td  style="width:38px">'+'-'+'</td>';
        					stationHTML += '<td class="success" style="width:38px">'+'-'+'</td>';
        					stationHTML += '<td class="warning" style="width:38px">'+'-'+'</td>';
        					stationHTML += '<td class="danger" style="width:38px">'+'-'+'</td>';
        					stationHTML += '<td class="info" style="width:38px">'+'-'+'</td>';
							stationHTML += '<td class="active" style="width:38px">'+'-'+'</td>';
        					stationHTML += '</tr>';
        				});

        				$stationTable.html(stationHTML);
						
						
						//DITU
						
        			//	update($citiesContainer,globalPCMSs[currentProvince].cities[currentCity].stations,'stations');
        			}
        			
        		});
		}
		
	});

	</script>


</html>
