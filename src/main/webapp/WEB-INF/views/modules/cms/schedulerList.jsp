<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>计划管理</title>
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
		<li class="active"><a href="${ctx}/cms/scheduler/">计划列表</a></li>
		<shiro:hasPermission name="scheduler:form"><li><a href="${ctx}/scheduler/form">计划添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="scheduler" action="${ctx}/scheduler/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>表达式：</label>
				<form:input path="expression" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>状态 0:正常,1:禁用：</label>
				<form:input path="status" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>更新时间：</label>
				<input name="updateTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${scheduler.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</li>
			<li><label>更新用户ID：</label>
				<form:input path="updateUser" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${scheduler.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>名称</th>
				<th>标题</th>
				<th>表达式</th>
				<th>状态 0:正常,1:禁用</th>
				<th>更新时间</th>
				<th>更新用户ID</th>
				<th>创建时间</th>
				<th>创建用户ID</th>
				<shiro:hasPermission name="scheduler:form"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="scheduler">
			<tr>
				<td><a href="${ctx}/cms/scheduler/form?id=${scheduler.id}">
					${scheduler.name}
				</a></td>
				<td>
					${scheduler.title}
				</td>
				<td>
					${scheduler.expression}
				</td>
				<td>
					${scheduler.status}
				</td>
				<td>
					<fmt:formatDate value="${scheduler.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${scheduler.updateUser}
				</td>
				<td>
					<fmt:formatDate value="${scheduler.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${scheduler.createUser}
				</td>
				<td>
					<shiro:hasPermission name="scheduler:form">
    				<a href="${ctx}/scheduler/form?id=${scheduler.id}">修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="scheduler:delete">
    				<a href="${ctx}/scheduler/delete?id=${scheduler.id}" onclick="return confirmx('确认要删除该计划吗？', this.href)">删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>