var myChartTwo = echarts.init(document.getElementById('main2'));
	   	var myDate = new Date(); 
        echartYear = myDate.getFullYear();
        echartDate = myDate.getDate();
        echartMonth = myDate.getMonth() + 1;

        var weat1Data = [11, 11, 15, 13, 12, 13, 10];
        
        function selectFuDay(){
        	weat1Data = [11, 11, 15, 13, 12, 13, 10];
        	myChartTwo.setOption(option1);
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

    option1 = {
    title: {
        text: '未来一周PM2.5变化',
        subtext: '具体以实际情况为准'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['PM2.5']
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
        data: dateAdjust(myDate)
    },
    yAxis: {
        type: 'value',
        name: 'PM2.5(μg/m3)',
        nameLocation: 'end',
        scale: true,
        axisLabel: {
            formatter: '{value}'
        }
    },
    grid:{
    	left: '25%',
    	right: '20%',
    	top: '20%',
    	bottom: '20%'
    },
    series: [
        {
            name:'PM2.5',
            type:'line',
            data: weat1Data,
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
        }
    /*    {
            name:'最低气温',
            type:'line',
            data:[1, -2, 2, 5, 3, 2, 0],
            markPoint: {
                data: [
                    {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
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

    	 