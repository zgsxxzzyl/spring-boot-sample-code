$(function () {
    loadAll();
    $('#submit').click(function () {
            add();
        }
    );
});

function loadAll() {
    $.ajax({
        //请求方式
        type: "GET",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url: "/user/list",
        //数据，json字符串
        // data : JSON.stringify(list),
        //请求成功
        success: function (a) {
            let html = '';
            for (let i = 0; i < a.length; i++) {
                html += '<tr>';
                html += '<td>' + a[i].id + '<td>';
                html += '<td>' + a[i].username + '<td>';
                html += '<td><input type="button" value="删除" del="' + a[i].id + '" onclick="del(this)"><td> ';
                html += '</tr>';
            }
            $('#list').html(html);
        },
        //请求失败，包含具体的错误信息
        error: function (e) {
            console.log(e.status);
            console.log(e.responseText);
        }
    });
}

function add() {
    let username = $('#username').val();
    $.ajax({
        //请求方式
        type: "POST",
        //请求的媒体类型
        // contentType: "application/json;charset=UTF-8",
        //请求地址
        url: "/user/add",
        //数据，json字符串
        data: {
            "username": username
        },
        //请求成功
        success: function (result) {
            loadAll();
        },
        //请求失败，包含具体的错误信息
        /*error: function (e) {
            console.log(e.status);
            console.log(e.responseText);
        }*/
    });
}

function del(e) {
    let id = $(e).attr("del");
    $.ajax({
        type: "DELETE",
        url: "/user/del",
        data: {
            "id": id
        },
        success: function (result) {
            loadAll();
        },
    });
}