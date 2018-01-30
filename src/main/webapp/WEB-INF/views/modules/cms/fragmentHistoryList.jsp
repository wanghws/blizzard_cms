<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>碎片历史管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/cms/fragmentHistory/">碎片历史列表</a></li>
		<shiro:hasPermission name="fragmentHistory:form"><li><a href="${ctx}/fragmentHistory/form">碎片历史添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="fragmentHistory" action="${ctx}/fragmentHistory/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="fragmentHistory:form"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="fragmentHistory">
			<tr>
				<td>
					<shiro:hasPermission name="fragmentHistory:form">
    				<a href="${ctx}/fragmentHistory/form?id=${fragmentHistory.id}">修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="fragmentHistory:delete">
    				<a href="${ctx}/fragmentHistory/delete?id=${fragmentHistory.id}" onclick="return confirmx('确认要删除该碎片历史吗？', this.href)">删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>