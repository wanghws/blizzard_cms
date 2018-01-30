<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>碎片管理</title>
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
		<li class="active"><a href="${ctx}/cms/fragment/">碎片列表</a></li>
		<shiro:hasPermission name="fragment:form"><li><a href="${ctx}/fragment/form">碎片添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="fragment" action="${ctx}/fragment/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>父级ID：</label>
			</li>
			<li><label>分类ID：</label>
				<form:input path="categoryId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>域ID：</label>
				<form:input path="domainId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>type：</label>
				<form:input path="type" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>内容：</label>
				<form:input path="content" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>文件名称：</label>
				<form:input path="fileName" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>include_url：</label>
				<form:input path="includeUrl" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>sum_pages：</label>
				<form:input path="sumPages" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>page_status：</label>
				<form:input path="pageStatus" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>file_type：</label>
				<form:input path="fileType" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>状态 0:正常,1:禁用：</label>
				<form:input path="status" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>更新时间：</label>
				<input name="updateTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${fragment.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</li>
			<li><label>更新用户ID：</label>
				<form:input path="updateUser" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${fragment.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>父级ID</th>
				<th>分类ID</th>
				<th>域ID</th>
				<th>标题</th>
				<th>名称</th>
				<th>type</th>
				<th>内容</th>
				<th>文件名称</th>
				<th>include_url</th>
				<th>sum_pages</th>
				<th>page_status</th>
				<th>file_type</th>
				<th>状态 0:正常,1:禁用</th>
				<th>更新时间</th>
				<th>更新用户ID</th>
				<th>创建时间</th>
				<th>创建用户ID</th>
				<shiro:hasPermission name="fragment:form"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="fragment">
			<tr>
				<td><a href="${ctx}/cms/fragment/form?id=${fragment.id}">
					${fragment.parentId}
				</a></td>
				<td>
					${fragment.categoryId}
				</td>
				<td>
					${fragment.domainId}
				</td>
				<td>
					${fragment.title}
				</td>
				<td>
					${fragment.name}
				</td>
				<td>
					${fragment.type}
				</td>
				<td>
					${fragment.content}
				</td>
				<td>
					${fragment.fileName}
				</td>
				<td>
					${fragment.includeUrl}
				</td>
				<td>
					${fragment.sumPages}
				</td>
				<td>
					${fragment.pageStatus}
				</td>
				<td>
					${fragment.fileType}
				</td>
				<td>
					${fragment.status}
				</td>
				<td>
					<fmt:formatDate value="${fragment.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fragment.updateUser}
				</td>
				<td>
					<fmt:formatDate value="${fragment.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fragment.createUser}
				</td>
				<td>
					<shiro:hasPermission name="fragment:form">
    				<a href="${ctx}/fragment/form?id=${fragment.id}">修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="fragment:delete">
    				<a href="${ctx}/fragment/delete?id=${fragment.id}" onclick="return confirmx('确认要删除该碎片吗？', this.href)">删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>