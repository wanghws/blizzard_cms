<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>页面管理</title>
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
		<li class="active"><a href="${ctx}/cms/htmlPage/">页面列表</a></li>
		<shiro:hasPermission name="htmlPage:form"><li><a href="${ctx}/htmlPage/form">页面添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="htmlPage" action="${ctx}/htmlPage/list" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>父级ID：</label>
			</li>
			<li><label>分类ID：</label>
				<form:input path="categoryId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>模板ID：</label>
				<form:input path="templateId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>频道ID：</label>
				<form:input path="channelId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>关键字：</label>
				<form:input path="keyWord" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>说明：</label>
				<form:input path="description" htmlEscape="false" maxlength="256" class="input-medium"/>
			</li>
			<li><label>内容：</label>
				<form:input path="content" htmlEscape="false" class="input-medium"/>
			</li>
			<li><label>html名称：</label>
				<form:input path="htmlName" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>url：</label>
				<form:input path="showUrl" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>json_type：</label>
				<form:input path="jsonType" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>状态 0:正常,1:禁用：</label>
				<form:input path="status" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${htmlPage.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>模板ID</th>
				<th>频道ID</th>
				<th>名称</th>
				<th>标题</th>
				<th>关键字</th>
				<th>说明</th>
				<th>内容</th>
				<th>html名称</th>
				<th>url</th>
				<th>json_type</th>
				<th>状态 0:正常,1:禁用</th>
				<th>创建时间</th>
				<th>创建用户ID</th>
				<shiro:hasPermission name="htmlPage:form"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="htmlPage">
			<tr>
				<td><a href="${ctx}/cms/htmlPage/form?id=${htmlPage.id}">
					${htmlPage.parentId}
				</a></td>
				<td>
					${htmlPage.categoryId}
				</td>
				<td>
					${htmlPage.templateId}
				</td>
				<td>
					${htmlPage.channelId}
				</td>
				<td>
					${htmlPage.name}
				</td>
				<td>
					${htmlPage.title}
				</td>
				<td>
					${htmlPage.keyWord}
				</td>
				<td>
					${htmlPage.description}
				</td>
				<td>
					${htmlPage.content}
				</td>
				<td>
					${htmlPage.htmlName}
				</td>
				<td>
					${htmlPage.showUrl}
				</td>
				<td>
					${htmlPage.jsonType}
				</td>
				<td>
					${htmlPage.status}
				</td>
				<td>
					<fmt:formatDate value="${htmlPage.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${htmlPage.createUser}
				</td>
				<td>
					<shiro:hasPermission name="htmlPage:form">
    				<a href="${ctx}/htmlPage/form?id=${htmlPage.id}">修改</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="htmlPage:delete">
    				<a href="${ctx}/htmlPage/delete?id=${htmlPage.id}" onclick="return confirmx('确认要删除该页面吗？', this.href)">删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>