$(function () {
    var btn = $("$btn");
    btn.click(function () {
        $.ajax({
            url: "/login.jsp",
            type: 'post',
            dataType: 'text',
            success:function (data) {

            }
        }
        )
    })
})