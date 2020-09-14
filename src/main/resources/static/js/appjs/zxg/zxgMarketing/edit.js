$().ready(function () {
    validateRule();
    $("#marketingName").empty();
    let marketingNameEdit = $('#marketingNameEdit').val();
    console.log(marketingNameEdit);
    $.ajax({
        url : '/zxg/zxgUser/zxgUser',
        type : "post",
        async : false,
        dataType : "json",
        data: {},
        error : function(request) {
            parent.layer.alert("连接错误");
        },
        success : function(data) {
            console.log(data);
            $("#marketingName").append("<option value='' >--请选择--</option>");
            for (var i = 0; i < data.length; i++) {
                if(marketingNameEdit==data[i].user_id){
                    $("#marketingName").append("<option selected value='"+data[i].user_id+"' >"+data[i].user_name+"</option>");
                }else{
                    $("#marketingName").append("<option value='"+data[i].user_id+"' >"+data[i].user_name+"</option>");
                }

            }
        }
    });
});

$.validator.setDefaults({
    submitHandler: function () {
        update();
    }
});
layui.use('laydate', function () {
    var laydate = layui.laydate;

    //执行一个laydate实例
    laydate.render({
        elem: '#inDate' //指定元素
    });
});
function update() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "/zxg/zxgMarketing/update",
        data: $('#signupForm').serialize(),// 你的formid
        async: false,
        error: function (request) {
            parent.layer.alert("Connection error");
        },
        success: function (data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);

            } else {
                parent.layer.alert(data.msg)
            }

        }
    });

}

function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules: {
            name: {
                required: true
            }
        },
        messages: {
            name: {
                required: icon + "请输入名字"
            }
        }
    })
}