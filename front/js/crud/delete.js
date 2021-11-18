let data = [
    {course_id: "1", name: "name1", t_name: "t_name1", groups: "4", year: "3bp"},
    {course_id: "2", name: "name2", t_name: "t_name2", groups: "2", year: "3bp"}
]

$(function () {
    init(data);
    $("#form").on("submit", function (event) {
        event.preventDefault();
        let urlencoded = $("#form").serialize();
        console.log(urlencoded);
        let parsed = Object.fromEntries(
            urlencoded.split('&')
                .map(s => s.split('='))
                .map(pair => pair.map(decodeURIComponent)));
        console.log(parsed);
    });

})