$(function () {
    // $('.hoverTest').hover(
    //     function() {
    //         $(this).removeClass('textRed');
    //         $(this).addClass('textBlue');
    //     },
    //     function() {
    //         $(this).removeClass('textBlue');
    //         $(this).addClass('textRed');
    //     })
    // $('.hoverLogo').hover(
    //     function() {
    //         $(this).removeClass('img-shadow');
    //     },
    //     function() {
    //         $(this).addClass('img-shadow');
    //     })
    $(".hoverLogin").hover(
        function () {
            $(this).css({
                transition: 'color 0.5s ease-in-out',
                "color": "#f2e9d8"
            });
        },
        function () {
            $(this).css({
                transition: 'color 0.5s ease-in-out',
                "color": "#1c2f40"
            });
        });
    $(".hoverButton").hover(
        function () {
            $(this).css({
                transition: 'background-color 0.5s ease-in-out',
                "background-color": "#f2e9d8"
            })
        },
        function () {
            $(this).css({
                transition: 'background-color 0.5s ease-in-out',
                "background-color": "#8094a6"
            })
        }
    );
    $(".hoverA").hover(
        function () {
            $(this).removeClass('font-lBrwn');
            $(this).css({
                transition: 'background-color 0.5s ease-in-out, color 0.5s ease-in-out ',
                "background-color": "#8094a6",
                "color": "#1c2f40"
            });
        },
        function () {
            $(this).css({
                transition: 'background-color 0.5s ease-in-out, color 0.5s ease-in-out',
                "background-color": "#1c2f40",
                "color": "#f2e9d8"
            });
        });
        $(".hoverB").hover(
            function () {
                $(this).removeClass('font-lBrwn');
                $(this).css({
                    transition: 'background-color 0.5s ease-in-out, color 0.5s ease-in-out ',
                    "background-color": "#8094a6",
                    "color": "#1c2f40"
                });
            },
            function () {
                $(this).css({
                    transition: 'background-color 0.5s ease-in-out, color 0.5s ease-in-out',
                    "background-color": "#1c2f40",
                    "color": "#f2e9d8"
                });
            });
})