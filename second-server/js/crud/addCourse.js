$(function(){
    URL = 'http://localhost:8080/lessons/addLesson';
    URL_BACK = 'http://localhost:8080/admin';
    $("#form").on("submit", function (event) {
        event.preventDefault();
        let urlencoded = $("#form").serialize();
        console.log(urlencoded);
        let parsed = Object.fromEntries(
            urlencoded.split('&')
                .map(s => s.split('='))
                .map(pair => pair.map(decodeURIComponent)));
        console.log(parsed);
        console.log(JSON.stringify(parsed));
        fetch(URL, {
            method: "POST",
            mode:"cors",
            headers:{
                'Content-Type': 'application/json; charset=utf-8',
                'mode': 'cors',
                'Access-Control-Allow-Origin': '*',
                'Connection': 'keep-alive',
                'Keep-Alive': 'timeout=5'
            },
            body: JSON.stringify(parsed)
        }).then(function(resp){
            response = resp.status;
            console.log(response);
            if(response==200){
                alert("Success!");
                window.location.replace(URL_BACK);
            }
        })
    });
})