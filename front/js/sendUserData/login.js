$(function () {
    $("#loginForm").on("submit", function (event) {
        event.preventDefault();
        let urlencoded = $("#loginForm").serialize();
        console.log(urlencoded);
        let parsed = Object.fromEntries(
            urlencoded.split('&')
                .map(s => s.split('='))
                .map(pair => pair.map(decodeURIComponent)));
        console.log(parsed);
    });
})