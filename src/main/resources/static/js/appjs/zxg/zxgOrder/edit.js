$().ready(function() {
	validateRule();
    $("#agentName").empty();
    let agentNameEdit = $('#agentNameEdit').val();
    console.log(agentNameEdit);
    $.ajax({
        url : '/zxg/zxgAgent/zxgAgent',
        type : "post",
        async : false,
        dataType : "json",
        data: {},
        error : function(request) {
            parent.layer.alert("连接错误");
        },
        success : function(data) {
            console.log(data);
            $("#agentName").append("<option value='' >--请选择--</option>");
            for (var i = 0; i < data.length; i++) {
            	if(agentNameEdit==data[i].agent_id){
                    $("#agentName").append("<option selected value='"+data[i].agent_id+"' >"+data[i].agent_name+"</option>");
				}else{
                    $("#agentName").append("<option value='"+data[i].agent_id+"' >"+data[i].agent_name+"</option>");
				}

            }
        }
    });
});
$("#orderCategories").bind("change", function () {
	let caValue = $("#orderCategories option:selected").val();
	$("#orderStatus").empty();
	$('#orderStatus').attr("disabled",false);
	if(caValue==0){
		$("#orderStatus").append("<option value='0' >刷单</option>");
	}else if(caValue==1){
		$("#orderStatus").append("<option value='1' >待发货</option>");
		$("#orderStatus").append("<option value='2' >已发货</option>");
		$("#orderStatus").append("<option value='3' >已签收</option>");
	}else if(caValue==2){
		$("#orderStatus").append("<option value='4' >未发货退款</option>");
		$("#orderStatus").append("<option value='5' >发货退款</option>");
	}
});
$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/zxg/zxgOrder/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
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
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}