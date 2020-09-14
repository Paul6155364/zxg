var prefix = "/zxg/zxgOrder"
$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: true, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 10, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset
                        // name:$('#searchName').val(),
                        // username:$('#searchName').val()
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        checkbox: true
                    },
                    {
                        visible: false,
                        field: 'id',
                        title: '主键ID'
                    },
                    {
                        visible: false,
                        field: 'inRmk',
                        title: '创建者'
                    },
                    {
                        visible: false,
                        field: 'reRmk',
                        title: '修改者'
                    },
                    {
                        visible: false,
                        field: 'status',
                        title: '状态'
                    },
                    {
                        field: 'orderId',
                        title: '订单ID'
                    },
                    {
                        field: 'inDate',
                        title: '创建时间'
                    },
                    {

                        field: 'reDate',
                        title: '修改日期'
                    },
                    {
                        field : 'orderCategories',
                        title : '订单大类'
                    },
                    {
                        field : 'orderStatus',
                        title : '订单小类'
                    },
                    {
                        field : 'orderType',
                        title : '订单类型'
                    },
                    {
                        field : 'orderBrand',
                        title : '订单品牌'
                    },
                    {
                        field : 'productName',
                        title : '产品名称'
                    },
                    {
                        field : 'productSpecifications',
                        title : '商品规格'
                    },
                    {
                        field : 'buyName',
                        title : '购买人'
                    },
                    {
                        field : 'buyPhone',
                        title : '购买人电话'
                    },
                    {
                        field : 'buyAddress',
                        title : '购买人地址'
                    },
                    {
                        field : 'salesAmount',
                        title : '销售价格'
                    },
                    {
                        field : 'deliveryCourierFee',
                        title : '发货快递费'
                    },
                    {
                        field : 'returnCourierFee',
                        title : '退货快递费'
                    },
                    {
                        field : 'messageFee',
                        title : '技术服务费'
                    },
                    {
                        field : 'freightInsurance',
                        title : '运费险'
                    },
                    {
                        field : 'remitSmallMoney',
                        title : '小额打款'
                    },
                    {
                        field : 'remitSmallName',
                        title : '小额打款人'
                    },
                    {
                        field : 'remitSmallReason',
                        title : '小额打款原因'
                    },
                    {
                        field : 'paySmallMoney',
                        title : '小额收款'
                    },
                    {
                        field : 'paySmallName',
                        title : '小额收款人'
                    },
                    {
                        field : 'paySmallReason',
                        title : '小额收款原因'
                    },
                    {
                        field : 'manyFee',
                        title : '多多进宝'
                    },
                    {
                        field : 'manyFeeRatio',
                        title : '多多进宝比例'
                    },
                    {
                        field : 'otherSupport',
                        title : '其他支出费'
                    },
                    {
                        field : 'otherSupportReason',
                        title : '其他支出原因'
                    },
                    {
                        field : 'fine',
                        title : '罚款'
                    },
                    {
                        field : 'agentAmount',
                        title : '代理价'
                    },
                    {
                        field : 'agentName',
                        title : '代理人'
                    },
                    {
                        field : 'paymentName',
                        title : '货款人'
                    },
                    {
                        field : 'profits',
                        title : '订单利润'
                    },
                    {
                        field : 'settlementId',
                        title : '是否结算'
                    },
                    {
                        field : 'comment',
                        title : '备注'
                    },
                    {
                        title: '操作',
                        field: 'cz',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            return e + d;
                        }
                    }]
            });
}

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function changeOrderStatus(cellval) {
    var dateVal = "";
    if (cellval != null) {
        if(cellval==0){
            dateVal = "刷单";
        }else if(cellval==1){
            dateVal = "待发货";
        }else if(cellval==2){
            dateVal = "已发货";
        }else if(cellval==3){
            dateVal = "已签收";
        }else if(cellval==4){
            dateVal = "已退款";
        }
        return dateVal;
    }
}
function changeOrderType(cellval) {
    var dateVal = "";
    if (cellval != null) {
        if(cellval==0){
            dateVal = "乳清蛋白";
        }else if(cellval==1){
            dateVal = "支链氨基酸";
        }else if(cellval==2){
            dateVal = "左旋肉碱";
        }else if(cellval==3){
            dateVal = "氨基酸";
        }else if(cellval==4){
            dateVal = "谷氨酰胺";
        }else if(cellval==5){
            dateVal = "其他膳食营养补充剂";
        }
        return dateVal;
    }
    return dateVal;
}
function add() {
    layer.open({
        type: 2,
        title: '增加',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/add' // iframe的url
    });
}

function edit(id) {
    layer.open({
        type: 2,
        title: '编辑',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id // iframe的url
    });
}

function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/remove",
            type: "post",
            data: {
                'id': id
            },
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}

function resetPwd(id) {
}

function batchRemove() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn: ['确定', '取消']
        // 按钮
    }, function () {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function (i, row) {
            ids[i] = row['id'];
        });
        $.ajax({
            type: 'POST',
            data: {
                "ids": ids
            },
            url: prefix + '/batchRemove',
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function () {

    });
}