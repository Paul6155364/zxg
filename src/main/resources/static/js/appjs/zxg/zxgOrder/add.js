$().ready(function() {
	validateRule();
    $("#agentName").empty();
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
            $("#agentName").append("<option value='' >--请选择--</option>");
            for (var i = 0; i < data.length; i++) {
                $("#agentName").append("<option value='"+data[i].agent_id+"' >"+data[i].agent_name+"</option>");
            }
        }
    });
});
$("#orderCategories").bind("change", function () {
    var caValue = $("#orderCategories option:selected").val();
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
		save();
	}
});


function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/zxg/zxgOrder/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("连接错误");
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
            inDate : {
				required : true
			},
            orderId : {
                required : true
            },
            orderType : {
                required : true
            },
            orderBrand : {
                required : true
            },
            productName : {
                required : true
            },
            productSpecifications : {
                required : true
            },
            agentName : {
                required : true
            },
            agentAmount : {
                required : true
            },
            paymentName : {
                required : true
            },
            salesAmount : {
                required : true
            },
            buyName : {
                required : true
            },
            comment : {
                required : true
            }
		},
		messages : {
            inDate : {
				required : icon + "请选择创建日期"
			},
            orderId : {
                required : icon + "请填写订单ID"
            },
            orderType : {
                required : icon + "请填写订单类型"
            },
            orderBrand : {
                required : icon + "请填写订单品牌"
            },
            productName : {
                required : icon + "请填写产品名称"
            },
            productSpecifications : {
                required : icon + "请填写商品规格"
            },
            agentName : {
                required : icon + "请填写代理人"
            },
            agentAmount : {
                required : icon + "请填写代理价"
            },
            paymentName : {
                required : icon + "请填写货款人"
            },
            salesAmount : {
                required : icon + "请填写销售价格"
            },
            buyName : {
                required : icon + "请填写购买人"
            },
            comment : {
                required : icon + "请填写备注"
            }
		}
	})
}