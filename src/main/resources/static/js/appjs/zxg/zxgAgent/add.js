$().ready(function () {
    validateRule();
});

$.validator.setDefaults({
    submitHandler: function () {
        save();
    }
});

function save() {
    $.ajax({
        cache: true,
        type: "POST",
        url: "/zxg/zxgAgent/save",
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
            agentName: {
                required: true
            },
            agentFee: {
                required: true
            },
            agentStar: {
                required: true
            },
            agentDocking: {
                required: true
            },
            agentSource: {
                required: true
            }
        },
        messages: {
            agentName: {
                required: icon + "请输入代理人姓名"
            },
            agentFee: {
                required: icon + "请输入代理费"
            },
            agentStar: {
                required: icon + "请输入代理星级（0~10数字表示）"
            },
            agentDocking: {
                required: icon + "请输入代理对接人"
            },
            agentSource: {
                required: icon + "请输入代理来源"
            },
        }
    })
}