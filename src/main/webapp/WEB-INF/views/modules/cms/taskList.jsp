<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>任务管理</title>
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
		<li class="active"><a href="${ctx}/cms/task/">任务列表</a></li>
		<shiro:hasPermission name="task:form"><li><a href="${ctx}/task/form">任务添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="task" action="${ctx}/task/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>计划ID：</label>
				<form:input path="schedulerId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>页面ID：</label>
				<form:input path="pageId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>type：</label>
				<form:input path="type" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>scheduler_type：</label>
				<form:input path="schedulerType" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>状态 0:正常,1:禁用：</label>
				<form:input path="status" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>更新时间：</label>
				<input name="updateTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${task.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</li>
			<li><label>更新用户ID：</label>
				<form:input path="updateUser" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${task.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>计划ID</th>
				<th>页面ID</th>
				<th>type</th>
				<th>scheduler_type</th>
				<th>回调URL</th>
				<th>状态 0:正常,1:禁用</th>
				<th>更新时间</th>
				<th>更新用户ID</th>
				<th>创建时间</th>
				<th>创建用户ID</th>
				<shiro:hasPermission name="task:form"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="task">
			<tr>
				<td><a href="${ctx}/cms/task/form?id=${task.id}">
					${task.schedulerId}
				</a></td>
				<td>
					${task.pageId}
				</td>
				<td>
					${task.type}
				</td>
				<td>
					${task.schedulerType}
				</td>
				<td>
					${task.callbackUrl}
				</td>
				<td>
					${task.status}
				</td>
				<td>
					<fmt:formatDate value="${task.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${task.updateUser}
				</td>
				<td>
					<fmt:formatDate value="${task.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${task.createUser}
				</td>
				<td>
					<shiro:hasPermission name="task:form">
    				<a href="${ctx}/task/form?id=${task.id}">修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="task:delete">
    				<a href="${ctx}/task/delete?id=${task.id}" onclick="return confirmx('确认要删除该任务吗？', this.href)">删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>