
var chartDataStr = decodeHtml(chartData);
var chartJSONArray = JSON.parse(chartDataStr);

var arrayLength = chartJSONArray.length;

var numericData = [];
var labelData = [];

for (var i=0 ; i < arrayLength ; i++) {
    numericData[i] = chartJSONArray[i].value;
    labelData[i] = chartJSONArray[i].label;
}




var myChart = new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'Project Statuses',
            data: numericData,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        title: {
            display: true,
            text: 'Project Statuses'
        }
    }
});

function decodeHtml(html) {
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}