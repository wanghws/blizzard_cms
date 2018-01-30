<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>模板历史管理</title>
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
		<li class="active"><a href="${ctx}/cms/templateHistory/">模板历史列表</a></li>
		<shiro:hasPermission name="templateHistory:form"><li><a href="${ctx}/templateHistory/form">模板历史添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="templateHistory" action="${ctx}/templateHistory/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>模板ID：</label>
				<form:input path="templateId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>状态 0:正常,1:禁用：</label>
				<form:input path="status" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${templateHistory.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</li>
			<li><label>创建用户ID：</label>
				<form:input path="createUser" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>模板ID</th>
				<th>内容</th>
				<th>状态 0:正常,1:禁用</th>
				<th>创建时间</th>
				<th>创建用户ID</th>
				<shiro:hasPermission name="templateHistory:form"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="templateHistory">
			<tr>
				<td><a href="${ctx}/cms/templateHistory/form?id=${templateHistory.id}">
					${templateHistory.templateId}
				</a></td>
				<td>
					${templateHistory.content}
				</td>
				<td>
					${templateHistory.status}
				</td>
				<td>
					<fmt:formatDate value="${templateHistory.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${templateHistory.createUser}
				</td>
				<td>
					<shiro:hasPermission name="templateHistory:form">
    				<a href="${ctx}/templateHistory/form?id=${templateHistory.id}">修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="templateHistory:delete">
    				<a href="${ctx}/templateHistory/delete?id=${templateHistory.id}" onclick="return confirmx('确认要删除该模板历史吗？', this.href)">删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>