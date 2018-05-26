<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/include_javascript_head.jsp"/>
<%!
    static final String url = "change_password.action";
%>
<%
    if (session.getAttribute("eid") != null) {
%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <!-- 导入头部标题栏内容 -->
    <jsp:include page="/pages/plugins/back/include_title_head.jsp" />
    <!-- 导入左边菜单项 -->
    <jsp:include page="/pages/plugins/back/include_menu_item.jsp" />
    <script src="js/pages/back/admin/password_update.js"></script>
    <div class="content-wrapper text-center">
        <div class="content-wrapper text-center">
            <div class="row">
                <div class="col-md-9">
                    <form action="<%=url%>"  method="post" class="form-horizontal" id="myForm">
                        <fieldset>
                            <div class="form-group" id="pwdDiv">
                                <label class="col-md-2 control-label">原始密码：</label>
                                <div class="col-md-9">
                                    <input type="password" id="pwd" name="pwd" class="form-control"
                                           placeholder="请输入原始密码">
                                </div>
                                <div class="col-md-3">
                                    <span id="pwdMsg"></span>
                                </div>
                            </div>
                            <div class="form-group" id="newpwdDiv">
                                <label class="col-md-2 control-label">新的密码：</label>
                                <div class="col-md-9">
                                    <input type="password" id="newpwd" name="newpwd" class="form-control"
                                           placeholder="请输入新的密码">
                                </div>
                                <div class="col-md-3">
                                    <span id="newpwdMsg"></span>
                                </div>
                            </div>
                            <div class="form-group" id="conpwdDiv">
                                <label class="col-md-2 control-label">确认密码：</label>
                                <div class="col-md-9">
                                    <input type="password" id="conpwd" name="conpwd" class="form-control"
                                           placeholder="请重复输入新密码">
                                </div>
                                <div class="col-md-3">
                                    <span id="conpwdMsg" class="text-red"></span>
                                </div>
                            </div>
                            <div class="form-group" id="buttonDiv">
                                <div class="col-md-6 col-md-push-3">
                                    <input type="submit" id="submitBut" value="提交" class="btn btn-primary">
                                    <input type="reset" value="重置" class="btn btn-danger">
                                </div>
                            </div>
                            <span id="msg" class="text-red">${msg}</span>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- 导入公司尾部认证信息 -->
    <jsp:include page="/pages/plugins/back/include_title_foot.jsp" />
    <!-- 导入右边工具设置栏 -->
    <jsp:include page="/pages/plugins/back/include_menu_sidebar.jsp" />
    <div class="control-sidebar-bg"></div>
</div>
<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
</body>
<%} else {%>
<%
%>
<jsp:forward page="login_pre.action"/>
<%}%>
</html>
