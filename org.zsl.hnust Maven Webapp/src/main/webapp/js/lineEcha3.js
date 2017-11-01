var myChart = echarts.init(document.getElementById('main3'));
        var myDate = new Date(); 
        var echartYear = myDate.getFullYear();
        var echartDate = myDate.getDate();
        var echartMonth = myDate.getMonth() + 1;
        var echartHours = myDate.getHours();
        var dateAdjust = function(myDate){
            var str = [];
            for(var i=1; i<25; i++){
                if(echartHours-i < 0)
                    str.unshift(echartHours-i+24);
                else
                    str.unshift(echartHours-i);
            }
            return str;
        }
option = {
    title: {
        text: '未来24小时PM2.5变化',
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
        name: echartMonth.toString()+'.'+echartDate.toString()+'日',
        nameLocation: 'end',
        boundaryGap: false,
        data: dateAdjust()
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
            data:[11, 11, 15, 13, 12, 13, 10,13,23,21,12,14,21,21,11,15,14,12,18,23,12,13,15,14],
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

        myChart.setOption(option);