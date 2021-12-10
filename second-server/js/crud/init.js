function init(data) {
    $("#name").focus(function () {
        $(this).empty();
        for (let i = 0; i < data.length; i++) {
            $(this).append(`<option id="` + data[i].groups + `" value="` + data[i].course_id + `">` + data[i].name + `</option>`)
        }
    });
    $("#name").change(function () {
        $("#group").empty();
    })
    $("#group").focus(function () {
        $(this).empty();
        let groups = $("#name").children(":selected").attr("id");
        groups = parseInt(groups);
        for (let j = 1; j <= groups; j++) {
            $("#group").append(`<option value="` + j + `">` + j + `</option>`)
        }
    })

}