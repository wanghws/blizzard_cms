<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>频道管理</title>
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
		<li class="active"><a href="${ctx}/cms/channel/">频道列表</a></li>
		<shiro:hasPermission name="channel:form"><li><a href="${ctx}/channel/form">频道添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="channel" action="${ctx}/channel/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>父级ID：</label>
			</li>
			<li><label>域ID：</label>
				<form:input path="domainId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>模板ID：</label>
				<form:input path="templateId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>路径：</label>
				<form:input path="path" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>html名称：</label>
				<form:input path="htmlName" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>display_status：</label>
				<form:input path="displayStatus" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>page_status：</label>
				<form:input path="pageStatus" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>状态 0:正常,1:禁用：</label>
				<form:input path="status" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>创建用户ID：</label>
				<form:input path="createUser" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${channel.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>父级ID</th>
				<th>域ID</th>
				<th>模板ID</th>
				<th>路径</th>
				<th>名称</th>
				<th>html名称</th>
				<th>display_status</th>
				<th>page_status</th>
				<th>状态 0:正常,1:禁用</th>
				<th>创建用户ID</th>
				<th>创建时间</th>
				<shiro:hasPermission name="channel:form"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="channel">
			<tr>
				<td><a href="${ctx}/cms/channel/form?id=${channel.id}">
					${channel.parentId}
				</a></td>
				<td>
					${channel.domainId}
				</td>
				<td>
					${channel.templateId}
				</td>
				<td>
					${channel.path}
				</td>
				<td>
					${channel.name}
				</td>
				<td>
					${channel.htmlName}
				</td>
				<td>
					${channel.displayStatus}
				</td>
				<td>
					${channel.pageStatus}
				</td>
				<td>
					${channel.status}
				</td>
				<td>
					${channel.createUser}
				</td>
				<td>
					<fmt:formatDate value="${channel.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<shiro:hasPermission name="channel:form">
    				<a href="${ctx}/channel/form?id=${channel.id}">修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="channel:delete">
    				<a href="${ctx}/channel/delete?id=${channel.id}" onclick="return confirmx('确认要删除该频道吗？', this.href)">删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>