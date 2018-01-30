<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>页面碎片管理</title>
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
		<li class="active"><a href="${ctx}/cms/pageFragment/">页面碎片列表</a></li>
		<shiro:hasPermission name="pageFragment:form"><li><a href="${ctx}/pageFragment/form">页面碎片添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="pageFragment" action="${ctx}/pageFragment/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>父ID：</label>
			</li>
			<li><label>页面ID：</label>
				<form:input path="pageId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>碎片ID：</label>
				<form:input path="fragmentId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>状态 0:正常,1:禁用：</label>
				<form:input path="status" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${pageFragment.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>父ID</th>
				<th>页面ID</th>
				<th>碎片ID</th>
				<th>状态 0:正常,1:禁用</th>
				<th>创建时间</th>
				<th>创建用户ID</th>
				<shiro:hasPermission name="pageFragment:form"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="pageFragment">
			<tr>
				<td><a href="${ctx}/cms/pageFragment/form?id=${pageFragment.id}">
					${pageFragment.parentId}
				</a></td>
				<td>
					${pageFragment.pageId}
				</td>
				<td>
					${pageFragment.fragmentId}
				</td>
				<td>
					${pageFragment.status}
				</td>
				<td>
					<fmt:formatDate value="${pageFragment.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${pageFragment.createUser}
				</td>
				<td>
					<shiro:hasPermission name="pageFragment:form">
    				<a href="${ctx}/pageFragment/form?id=${pageFragment.id}">修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="pageFragment:delete">
    				<a href="${ctx}/pageFragment/delete?id=${pageFragment.id}" onclick="return confirmx('确认要删除该页面碎片吗？', this.href)">删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>