$(function () {
    $("#regForm").on("submit", function (event) {
        let urlencoded = $("#regForm").serialize();
        console.log(urlencoded);
        let parsed = Object.fromEntries(
            urlencoded.split('&')
                .map(s => s.split('='))
                .map(pair => pair.map(decodeURIComponent)));
        console.log(parsed);
        console.log($("#role").find(":selected").val());

        alert(1);
    });
})