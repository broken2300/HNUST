       var myChart = echarts.init(document.getElementById('main2'));
        var myDate = new Date(); 
        var echartYear = myDate.getFullYear();
        var echartDate = myDate.getDate();
        var echartMonth = myDate.getMonth() + 1;
        var weatMonth = [];
        lineType = "recent15"
        selectForLine = "AQI";
/*        AQIDate = [];
        PM2_5Date =[];
        PM10Date = [];
        SO2Date =[];
        NO2Date = [];
        CODate = [];
        O3Date = [];*/
        function setWeatMonth(valueSelect){
        	if(valueSelect == "AQI"){
       		 	//weatMonth = AQIDate;  //演示用
        		weatMonth=[44,54,47,58,46,28,36,39,29,26,41,56,62,41,43];
	       	}else if(valueSelect == "PM2.5"){
	       		//weatMonth = PM2_5Date;
	       		weatMonth=[28.2,37.3,26,37.5,28.4,18.4,23.4,21.5,15.3,14.9,27.1,32.3,39.4,19.5,21.2];
	       	}else if(valueSelect == "PM10"){
	       		//weatMonth = PM10Date;
	       		weatMonth = [31.3,47.9,48.2,61.8,49.8,16.8,33.5,35.4,27.7,22.9,36.8,62.3,70.4,42.6,44.2];
	       	}else if(valueSelect == "SO2"){
	       		//weatMonth = SO2Date;
	       		weatMonth=[7.5,11.8,13.5,12.5,14.2,5.5,11.2,10.3,9.5,9.7,8.9,12.8,14.1,7.6,11.8];
	       	}else if(valueSelect == "NO2"){
	       		//weatMonth = NO2Date;
	       		weatMonth=[52.2,45.6,34.3,33.6,28.9,12.8,22.1,25.8,20.1,28.8,19.7,22.3,30.1,20.4,24.3];
	       	}else if(valueSelect == "CO"){
	       		//weatMonth = CODate;
	       		weatMonth=[0.949,0.965,0.746,0.723,0.551,0.464,0.555,0.512,0.457,0.528,0.834,0.644,0.682,0.471,0.474];
	       	}else if(valueSelect == "O3"){
	       		//weatMonth = O3Date;
	       		weatMonth=[72,80,100,94,48,47,74,54,48,54,93,100,101,71,71];
	       	}
        	 selectForLine = valueSelect;
        	 option.yAxis.name = selectForLine;
        }
        
        function selectDay(value){
        	console.log(value);
        	 if(value == "futureDay"){
        		 alert("敬请期待！");
        	 }
        	 else if(value =="futureWeek"){
        		 
        		 lineType = value;
        		weatMonth = [25.21,25.11,33.8,29.46,29.52,28.51]
        		lineAdjust();
              	option.series[0].data = weatMonth; 
              	option.series.splice(1,1);
              	console.log(option.series);
              	myChart.setOption(option,true,false);
          
        	 }
        	 else{
        		 lineType = value;
        		 option.series.push( {
        				 name:'历史预测数据',
        		            type:'line',
        		            //data:[10, 23, 33, 12, 45, 32, 33,5, 23, 33, 12, 45, 32, 33,36],
        		            data:[36.42,31.74,28.27,28.41,27.27,26.32,24.82,25.6,23.72,23.97,22.26,30.63,27.99,20.92,26.16],
        		          //  data:[1, -2, 2, 5, 3, 2, 0],
        		            markPoint: {
        		                data: [
        		                    {type: 'max', name: '最大值'},
        		                    {type: 'min', name: '最小值'}
        		                ]
        		            },
        		            markLine: {
        		                data: [
        		                    {type: 'average', name: '平均值'}
        		                ]
        		            }
        		 });
        		 myChart.setOption(option,true,false);
        		 console.log(lineType);
             	setct("厦门","AQI");
        	 }
        
        }
       
        setct = function(citym,pollutionType){
        	AQIDate = [];
	        PM2_5Date =[];
	        PM10Date = [];
	        SO2Date =[];
	        NO2Date = [];
	        CODate = [];
	        O3Date = [];
        	
        	 $.ajax({
                 type:"POST",
                 url:"/org.zsl.hnust/test/testCT",
                 data:{"city":citym,"type":lineType},
                 async:false,
                 dataType:"json",
                 success:function(param){
                 	/*weatMonth = param;*/
                 //	console.log(param);
                 	// value数组顺序：AQI,pm2.5,PM10,SO2,NO2,CO,O3
                	 if(param == null)
                		 return;
                	 if(lineType == "futureWeek"){
                		 weatMonth = param;
                	 }
                	 else{
                		 $.each(param,function(i,value){
                      		
                      		AQIDate.push(value[0]);
                      		PM2_5Date.push(value[1]);
                      		PM10Date.push(value[2]);
                              SO2Date.push(value[3]);
                              NO2Date.push(value[4]);
                              CODate.push(value[5]);
                              O3Date.push(value[6]);
                              
                      	/*	if(value.monitor == null||value.monitor=="null")
                      			cityData.push(value);
                      		else monitorData.push(value);*/
                      	});
                		 setWeatMonth(pollutionType);
                	 }
              
                 	
                	//weatMonth = PM2_5Date;
                 	lineAdjust();
                 	option.series[0].data = weatMonth;
                 	myChart.setOption(option);
//                 	console.log("cityData:");
//                 	console.log(cityData);
//                 	console.log("monitorDat:");
//                 	console.log(monitorData);
                     },
                     error:function(){
                    	 alert('ajax failed');
                     }
                 });
        }
        
        setct("厦门","AQI");
        
        function lineAdjust(){
        	if(lineType == "recent15"){
        		option.xAxis.data = monthAdjust();
        		option.title.text = '过去 ' + selectForLine + ' 15天变化';
        	}
        	else if(lineType == "futureDay"){
        		option.xAxis.data = monthAdjust();//未改
        		option.title.text = '未来 ' + selectForLine + ' 1天变化';
        	}else {
        		option.xAxis.data = dateAdjust();
        		option.title.text = '未来 ' + selectForLine + ' 一周变化';
        	}
        }
        
        function changeCategeryForLine(valueSelect){
        	
        	
        	setWeatMonth(valueSelect);
        	option.series[0].data = weatMonth;
        	myChart.setOption(option);
        }
        
        function monthAdjust(myDate){
            var str1 = [];
            var str2 = [];
            var str = [];
            for(var i=1; i < 31; i++){
                if(echartDate-i > 0){//未超出本月
                    str2.push(echartDate-i);
                    str1.push(echartMonth);
                }
                else if(echartMonth == 2 || echartMonth == 4 || echartMonth == 6 || echartMonth == 8 || echartMonth == 9 || echartMonth == 11 || echartMonth == 1){//超出本月且上月为闰月
                        str2.push(echartDate-i+31);
                        if(echartMonth == 1)//c            
                            str1.push(12);//超出一月,则上月为12月
                        else
                            str1.push(echartMonth-1);
                    }
                    else if(echartMonth == 3){
                            if((echartYear%4 == 0 && echartYear%100 != 0) || echartYear%400){
                                if(echartDate-i+29 == 0){
                                    str2.push(31);
                                    str1.push(1);
                                }
                                else{
                                    str2.push(echartDate-i+29)
                                    str1.push(2);
                                }
                            }
                            else{
                                if(echartDate-i+28 == 0 || echartd-i+28 < 0){
                                    str2.push(echartDate-i+28+31);
                                    str1.push(1);
                                }
                                else{
                                    str2.push(echartDate-i+28)
                                    str1.push(2);
                                }
                            }
                        }
                        else{
                            str2.push(echartDate-i+30);
                            str1.push(echartMonth-1);
                        }        
            }
            for(var j=0; j<15; j++)
                str.unshift(str1[j].toString()+'.'+str2[j].toString());
            return str;
        }

        function dateAdjust(myDate){
            
            var str1 = [];
            var str2 = [];
            var str = [];
            if(echartMonth == 1 || echartMonth == 3 || echartMonth == 5 || echartMonth == 7 || echartMonth == 8 || echartMonth == 10 ||echartMonth == 12){
                for(var i=1; i < 8; i++){
                    if(echartDate+i < 32){
                        str2.push(echartDate+i);
                        str1.push(echartMonth);
                    }
                    else{
                        str2.push(echartDate+i-31);
                        str1.push(echartMonth+1);
                    }
                }
            }
            else if(echartMonth == 2){
                if((echartYear%4 == 0 && echartYear%100 != 0) || echartYear%400){
                    for(var i=1; i < 8; i++){
                        if(echartDate+i < 30){
                            str2.push(echartDate+i);
                            str1.push(echartMonth);
                        }
                        else{
                            str2.push(echartDate+i-29);
                            str1.push(echartMonth+1);
                        }
                    }
                }
                else{
                    for(var i=1; i < 8; i++){
                        if(echartDate+i < 29){
                            str2.push(echartDate+i);
                            str1.push(echartMonth);
                        }
                        else{
                            str2.push(echartDate+i-28);
                            str1.push(echartMonth+1);
                        }
                    }
                }
            }
            else{
                for(var i=1; i < 8; i++){
                    if(echartDate+i < 31){
                        str2.push(echartDate+i);
                        str1.push(echartMonth);
                    }
                    else{
                        str2.push(echartDate+i-30);
                        str1.push(echartMonth+1);
                    }
                }
            }
            for(var j=0; j<7; j++)
                str.push(str1[j].toString()+'.'+str2[j].toString());
            return str;
        }
        
var option = {
    title: {
        text: '过去 ' + /*selectForLine +*/ ' 15天变化',
        subtext: '具体以实际情况为准'
    }, 
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:["历史数据","历史预测数据"]
    },
    toolbox: {
        show: true,
        feature: {
            dataZoom: {},
            dataView: {readOnly: false},
            magicType: {type: ['line', 'bar']},
            restore: {},
            saveAsImage: {}
        }
    },
    xAxis:  {
        type: 'category',
        name: echartYear+'年',
        nameLocation: 'end',
        boundaryGap: false,
        data: monthAdjust()
    },
    yAxis: {
        type: 'value',
        name: selectForLine,//(μg/m3)',
        nameLocation: 'end',
        scale: true,
        axisLabel: {
            formatter: '{value}'
        }
    },
    grid:{
        left: '7%',
        right: '7%',
        top: '25%',
        bottom: '20%'
    },
    series: [
        {
            name:'历史数据',
            type:'line',
            data:weatMonth,    //演示用
            //data:[28.2,],
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            }
        },
       /* {
            name:'历史预测数据',
            type:'line',
            //data:[10, 23, 33, 12, 45, 32, 33,5, 23, 33, 12, 45, 32, 33,36],
            data:[36.42,31.74,28.27,28.41,27.27,26.32,24.82,25.6,23.72,23.97,22.26,30.63,27.99,20.92,26.16],
          //  data:[1, -2, 2, 5, 3, 2, 0],
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            }
        }*/
    ]
};

       //   myChart.setOption(option);