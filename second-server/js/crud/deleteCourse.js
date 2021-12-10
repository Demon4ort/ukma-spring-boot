$(function(){
    URL = 'http://localhost:8080/lessons/lesson/';
    URL_BACK = 'http://localhost:8080/admin';
    $("#form").on("submit", function (event) {
        event.preventDefault();
        let urlencoded = $("#form").serialize();
        console.log(urlencoded);
        let parsed = Object.fromEntries(
            urlencoded.split('&')
                .map(s => s.split('='))
                .map(pair => pair.map(decodeURIComponent)));
        fetch(URL+parsed.lessonId, {
            method: "DELETE",
            mode:"cors",
            headers:{
                'Content-Type': 'application/json; charset=utf-8',
                'mode': 'cors',
                'Access-Control-Allow-Origin': '*',
                'Connection': 'keep-alive',
                'Keep-Alive': 'timeout=5'
            }
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