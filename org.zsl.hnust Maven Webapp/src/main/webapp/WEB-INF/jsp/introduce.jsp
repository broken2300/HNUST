<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%
String path =request.getContextPath();
String basePath= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"  lang="zh-CN">
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

<title>说明及指南</title>
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
	  <li role="presentation" class="dropdown ">
		  <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
		  空气质量报告 <col-xs- class="caret"></col-xs->
		</a>
		<ul class="dropdown-menu">
		  <li role="presentation"><a href="/org.zsl.hnust/test/AQI">AQI实时报</a></li>
		  <li role="presentation"><a href="/org.zsl.hnust/test/pollution">污染物分类报告</a></li>
		</ul>
	  </li>
	    
	  <li role="presentation" class="dropdown">
		  <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
		  变化趋势及预测 <col-xs- class="caret"></col-xs->
		</a>
		<ul class="dropdown-menu">
		  <li role="presentation"><a href="/org.zsl.hnust/test/CT">过去15天</a></li>
		  <li role="presentation"><a href="/org.zsl.hnust/test/CT">未来一天</a></li>
		  <li role="presentation"><a href="/org.zsl.hnust/test/CT">未来一周</a></li>
		</ul>
	  </li>
	  
	  
	  <li role="presentation" class="active"><a href="/org.zsl.hnust/test/introduce">说明及指南</a></li>
		 
	  
	  </ul> 
	  </div>
	  </div>
 
  <div class="row" >
	  <div class="col-xs-12">  
	  
	  <!--空白填充上段-->
 <div class="row" >
	  <div class="col-xs-12" style="margin-top:-7px;margin-bottom:-15px">   	 
 <img src="../pic/bg-x.png"  >
 </div></div>
 <div class="row" >
	  <div class="col-xs-12" style="margin-top:-2px;margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
   <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row"  >
	  <div class="col-xs-12" style="margin-bottom:-5px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  
  



 <div class="row" >
	  <div class="col-xs-12" style="background:#FFF;width:1140px;margin-left:15px">
<div class="row" >
<div class="col-xs-2"></div>
<div class="col-xs-6">
 <!-- Button trigger modal -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target=".bs-example-modal-lg" style="width:190px">
 &nbsp;&nbsp;发&nbsp;&nbsp;布&nbsp;&nbsp;说&nbsp;&nbsp;明&nbsp;&nbsp;
</button>
<!-- Modal -->
<div class="modal fade bs-example-modal-lg" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
  <div class="modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel1">发布说明</h4>
      </div>
      <div class="modal-body">
	  
<p style="font-size:18px">  <b> 1.	发布依据：</b>  </p>

<p style="font-size:15px">根据《环境空气质量标准》（GB 3095-2012）和《环境空气质量指数（AQI）技术规定（试行）》（HJ633-2012）的有关规定，发布全国空气质量状况。</p>

<p style="font-size:18px"><b>2.	发布内容：</b></p>

<p style="font-size:15px">包括评价时段、监测点位名称及位置、各监测项目浓度、空气质量分数、空气质量指数、首要污染物及空气质量级别。</p>

<p style="font-size:18px"><b>3.	发布指标：</b></p>

<p style="font-size:15px">城市发布指标：城市日空气质量指数（AQI）、城市小时空气质量指数（AQI）以及相应的空气质量级别、首要污染物等。
点位发布指标：发布各点位二氧化硫（SO<sub>2</sub>）、二氧化氮（NO<sub>2</sub>）、臭氧（O<sub>3</sub>）、颗粒物（PM<sub>2.5</sub>/PM<sub>10</sub>）的一小时浓度平均值和空气质量指数（AQI）。</p>

<p  style="font-size:18px "><b>4.	数据来源：</b></p>
<p style="font-size:15px">来源于国家空气质量自动监测点位的空气质量自动监测结果及系统运算得出的预测结果。</p>

<p style="font-size:18px"><b>5.	其他说明：</b></p>
<p style="font-size:15px">发布结果主要显示全国空气质量总体状况，由于所采纳的监测点位数量和各城市不尽相同，与各城市发布的城市空气质量亦会有所差异；发布结果通常为每小时更新一次，由于数据传输需要一定的时间，发布的数据约有半小时的延滞。当遇到监测仪器校零、校标等日常维护行为，或出现通信故障、停电等情况，某些站点会出现一段时间内无数据的情况。
</p>

<p style="font-size:18px"><b>6.	特别说明：</b></p>

<p style="font-size:15px">根据《环境空气质量指数（AQI）技术规定（试行）》（HJ633-2012）的要求，实时发布数据由发布系统进行初步审核，所发布小时数据及日数据仅为当天参考值，用于向公众提供健康指引，不直接用于空气质量达标状况的评价。评价空气质量达标状况，应依据《环境空气质量标准》（GB 3095-2012）中的规定进行。
</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
</div>



<div class="col-xs-2">
 <!-- Button trigger modal -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal2" style="width:190px">
  空气质量标准
</button>
<!-- Modal -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">空气质量标准</h4>
      </div>
      <div class="modal-body">
       <img src="../pic/bz.png" style="margin-left:-15px">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
</div>
<div class="col-xs-2"></div>
</div>

</div>
 </div>
 
 <!--空白填充中段-->
<div class="row" >
	  <div class="col-xs-12" style="margin-top:-7px;margin-bottom:-15px">   	 
 <img src="../pic/bg-x.png"  >
 </div></div>
 <div class="row" >
	  <div class="col-xs-12" style="margin-top:-2px;margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
   <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row"  >
	  <div class="col-xs-12" style="margin-bottom:-5px"> 
 <img src="../pic/bg-x.png" >
  </div></div><div class="row" >
	  <div class="col-xs-12" style="margin-top:-7px;margin-bottom:-15px">   	 
 <img src="../pic/bg-x.png"  >
 </div></div>
 <div class="row" >
	  <div class="col-xs-12" style="margin-top:-2px;margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
   <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row"  >
	  <div class="col-xs-12" style="margin-bottom:-5px"> 
 <img src="../pic/bg-x.png" >
  </div></div><div class="row" >
	  <div class="col-xs-12" style="margin-top:-7px;margin-bottom:-15px">   	 
 <img src="../pic/bg-x.png"  >
 </div></div>
 <div class="row" >
	  <div class="col-xs-12" style="margin-top:-2px;margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
   <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row"  >
	  <div class="col-xs-12" style="margin-bottom:-5px"> 
 <img src="../pic/bg-x.png" >
  </div></div> 
 
 
  <div class="row" >
	  <div class="col-xs-12" style="background:#FFF;width:1140px;margin-left:15px">
<div class="row" >
<div class="col-xs-2"></div>
<div class="col-xs-6">
 <!-- Button trigger modal -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal3" style="width:190px">
 &nbsp;&nbsp;术&nbsp;&nbsp;语&nbsp;&nbsp;说&nbsp;&nbsp;明&nbsp;&nbsp;
</button>
<!-- Modal -->
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel3">术语说明</h4>
      </div>
      <div class="modal-body">
<p style="font-size:18px">  <b> 1.	AQI：</b>  </p>
<p style="font-size:15px">空气质量指数，定量描述空气质量状况的无量纲指数</p>
<p style="font-size:18px">  <b> 2.	IAQI：</b>  </p>
<p style="font-size:15px">空气质量分指数单项污染物的空气质量指数</p>
<p style="font-size:18px">  <b> 3.	首要污染物：</b>  </p>
<p style="font-size:15px">AQI大于50时IAQI最大的空气污染物</p>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
</div>
<div class="col-xs-2">
 <!-- Button trigger modal -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" style="width:190px">
&nbsp;&nbsp;健&nbsp;&nbsp;康&nbsp;&nbsp;指&nbsp;&nbsp;南&nbsp;&nbsp;
</button>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">健康指南</h4>
      </div>
      <div class="modal-body">
        <img src="../pic/jk.png" style="margin-left:-15px">
		<p style="font-size:15px;margin-left:20px">以上指南仅供参考，数据以实时AQI播报为准</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>
    </div>
  </div>
</div>
</div>
<div class="col-xs-2"></div>
</div>

</div>
 </div>
 
 <!--空白填充尾端-->
 <div class="row" >
	  <div class="col-xs-12" style="margin-top:-7px;margin-bottom:-15px">   	 
 <img src="../pic/bg-x.png"  >
 </div></div>
 <div class="row" >
	  <div class="col-xs-12" style="margin-top:-2px;margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
   <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row"  >
	  <div class="col-xs-12" style="margin-bottom:-5px"> 
 <img src="../pic/bg-x.png" >
  </div></div><div class="row" >
	  <div class="col-xs-12" style="margin-top:-7px;margin-bottom:-15px">   	 
 <img src="../pic/bg-x.png"  >
 </div></div>
 <div class="row" >
	  <div class="col-xs-12" style="margin-top:-2px;margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
   <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row"  >
	  <div class="col-xs-12" style="margin-bottom:-5px"> 
 <img src="../pic/bg-x.png" >
  </div></div><div class="row" >
	  <div class="col-xs-12" style="margin-top:-7px;margin-bottom:-15px">   	 
 <img src="../pic/bg-x.png"  >
 </div></div>
 <div class="row" >
	  <div class="col-xs-12" style="margin-top:-2px;margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
   <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row" >
	  <div class="col-xs-12" style="margin-bottom:-15px"> 
 <img src="../pic/bg-x.png" >
  </div></div>
  <div class="row"  >
	  <div class="col-xs-12" style="margin-bottom:-5px"> 
 <img src="../pic/bg-x.png" >
  </div></div> 
  
</div>
 </div>

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




</body>
</html>
