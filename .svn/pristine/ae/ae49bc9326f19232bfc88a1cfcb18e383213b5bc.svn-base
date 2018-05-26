$(function () {
    $("#myForm").validate({
        debug: true, // 取消表单的提交操作
        submitHandler: function (form) {
            form.submit(); // 提交表单
        },
        highlight: function (element, errorClass) {	// 定义高亮的显示处理
            eleId = $(element).attr("id"); // 获取出现错误的表单元素的id属性
            // 获得元素所在层的id属性，并且为层进行错误显示样式的设置
            $("#" + eleId + "Div").attr("class", "form-group has-error");
        },
        unhighlight: function (element, errorClass) {
            eleId = $(element).attr("id"); // 获取验证通过的元素ID
            // 获得元素所在层的id属性，并且为层进行正确显示样式的设置
            $("#" + eleId + "Div").attr("class", "form-group has-success");
        },
        errorPlacement: function (error, element) {	// 错误提示
            eleId = $(element).attr("id");
            spanObject = $("#" + eleId + "Msg"); // 获取span对象
            spanObject.empty(); // 清除已有的内容
            spanObject.append(error); // 追加错误提示信息
        },
        errorClass: "text-danger",
        rules: {
            "pwd": {
                required: true
            },
            "newpwd": {
                required: true
            },
            "conpwd": {
                required: true,
                equalTo: "#newpwd"
            },
        }
    });
});