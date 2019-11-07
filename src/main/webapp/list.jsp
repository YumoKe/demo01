<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index_work.css">
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.js"></script>
</head>
<a href="toAdd">添加</a>
<body>
	<table>
		<thead>
			<tr>
				<th>商品ID</th>
				<th>商品名称</th>
				<th>品牌</th>
				<th>种类</th>
				<th id="weight" onclick="weightSort()">尺寸</th>
				<th id="price" onclick="priceSort()">单价</th>
				<th id="cot" onclick="cotSort()">数量</th>
				<th>标签</th>
				<th>上传</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="g">
				<tr>
					<td>${g.gid}</td>
					<td>${g.gname}</td>
					<td>${g.bname}</td>
					<td>${g.gsname}</td>
					<td>${g.weight} <input type="hidden" name="weight" value="${(mysort.weight).contains('asc')?1:0 }"></td>
					<td>${g.price} <input type="hidden" name="price" value="${(mysort.price).contains('asc')?1:0 }"></td>
					<td>${g.cot} <input type="hidden" name="cot" value="${(mysort.cot).contains('asc')?1:0 }"></td>
					<td>${g.message }</td>
					<td><img style="width: 100px;height: 100px" src="<%=path%>looking?path=${g.imgurl}"></td>
					<td><input type="button" value="删除" onclick="del('${g.gid}')"/>
					<input type="button" value="修改" onclick="upd('${g.gid}')"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" value="首页" onclick="page(1)">
	<input type="button" value="下一页" onclick="page('${page.pageNum +1 > page.pages?page.pageNum:page.pageNum+1}')">
	<input type="button" value="上一页" onclick="page('${page.pageNum - 1 < 1?1:page.pageNum-1}')">
	<input type="button" value="尾页" onclick="page('${page.pages}')">
</body>
<script type="text/javascript">
function del(gid) {
	location = "<%=path%>/del?gid="+gid;
}

function upd(gid) {
	location = "<%=path%>/update.jsp?gid="+gid;
}

function page(pageNum){
	location = "list?pageNum="+pageNum;
}

function weightSort(){
	if ($("[name=weight]").val() == 1) {
		location = "list?weight=desc";
	} else {
		location = "list?weight=asc";
	}
}

function priceSort(){
	if ($("[name=price]").val() == 1) {
		location = "list?price=desc";
	} else {
		location = "list?price=asc";
	}
}

function cotSort(){
	if ($("[name=cot]").val() == 1) {
		location = "list?cot=desc";
	} else {
		location = "list?cot=asc";
	}
}

</script>
</html>