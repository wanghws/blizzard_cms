<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>域名管理</title>
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
		<li class="active"><a href="${ctx}/cms/domain/">域名列表</a></li>
		<shiro:hasPermission name="domain:form"><li><a href="${ctx}/domain/form">域名添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="domain" action="${ctx}/domain/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>路径：</label>
				<form:input path="path" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>域名：</label>
				<form:input path="domain" htmlEscape="false" maxlength="256" class="input-medium"/>
			</li>
			<li><label>状态 0:正常,1:禁用：</label>
				<form:input path="status" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>创建用户ID：</label>
				<form:input path="createUser" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${domain.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>路径</th>
				<th>域名</th>
				<th>状态 0:正常,1:禁用</th>
				<th>创建用户ID</th>
				<th>创建时间</th>
				<shiro:hasPermission name="domain:form"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="domain">
			<tr>
				<td><a href="${ctx}/cms/domain/form?id=${domain.id}">
					${domain.path}
				</a></td>
				<td>
					${domain.domain}
				</td>
				<td>
					${domain.status}
				</td>
				<td>
					${domain.createUser}
				</td>
				<td>
					<fmt:formatDate value="${domain.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<shiro:hasPermission name="domain:form">
    				<a href="${ctx}/domain/form?id=${domain.id}">修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="domain:delete">
    				<a href="${ctx}/domain/delete?id=${domain.id}" onclick="return confirmx('确认要删除该域名吗？', this.href)">删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>