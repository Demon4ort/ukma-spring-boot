function createGrid(data) {
    $("#jsGrid1").jsGrid({
        width: "100%",
        sorting: true,
        paging: true,
        editing: false,
        data: data,
        fields: [
            {name: "name", title: "Name", type: "text"},
            {name: "t_name", title: "Teacher`s name", type: "text"},
            {name: "time", title: "Time", type: "text"},
            {name: "link", title: "Link", type: "text"}
        ]
    });
}

$(function () {
    let data1 = [
        {name: "Monday", t_name: "Monday", time: "Monday", link: "Monday"}
    ];
    let data2 = [
        {name: "Tuesday", t_name: "Tuesday", time: "Tuesday", link: "Tuesday"}
    ];
    let data3 = [
        {name: "Wednesday", t_name: "Wednesday", time: "Wednesday", link: "Wednesday"}
    ];
    let data4 = [
        {name: "Thursday", t_name: "Thursday", time: "Thursday", link: "Thursday"}
    ];
    let data5 = [
        {name: "Friday", t_name: "Friday", time: "Friday", link: "Friday"}
    ];
    let data6 = [
        {name: "Saturday", t_name: "Saturday", time: "Saturday", link: "Saturday"}
    ];
    $("#monday").on('click', function () {
        $("#day").text("Monday");
        createGrid(data1);
    });
    $("#tuesday").on('click', function () {
        $("#day").text("Tuesday");
        createGrid(data2);
    });
    $("#wednesday").on('click', function () {
        $("#day").text("Wednesday");
        createGrid(data3);
    });
    $("#thursday").on('click', function () {
        $("#day").text("Thursday");
        createGrid(data4);
    });
    $("#friday").on('click', function () {
        $("#day").text("Friday");
        createGrid(data5);
    });
    $("#saturday").on('click', function () {
        $("#day").text("Saturday");
        createGrid(data6);
    });
})