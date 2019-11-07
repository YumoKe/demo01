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
<body>
	<form:form action="add" method="post" modelAttribute="goods" enctype="multipart/form-data">
		商品名称：<form:input path="gname"/><br><br>
		英文名称：<form:input path="gename"/><br><br>
		商品品牌：<select name="bid">
			<option></option>
		</select><br><br>
		商品种类：<select name="gsid">
			<option></option>
		</select><br><br>
		尺寸：<form:input path="weight"/><br><br>
		单价<form:input path="price"/><br><br>
		数量：<form:input path="cot"/><br><br>
		标签<form:textarea path="message"/><br><br>
		图片：<input type="file" name="img"><br><br>
		<form:button>保存</form:button>
	</form:form>
</body>

<script type="text/javascript">

$.post(
		"<%=path%>/brand",
		function (obj){
			var opt = "";
			$.each(obj,function(index,date){
				opt += "<option value='"+date.bid+"'>"+date.bname+"</option>"
				
			});
			$("[name=bid]").append(opt);
		},
		"json"
	)

	$.post(
		"<%=path%>/kind",
		function (obj){
			var opt = "";
			$.each(obj,function(index,date){
				opt += "<option value='"+date.gsid+"'>"+date.gsname+"</option>"
				
			});
			$("[name=gsid]").append(opt);
		},
		"json"
	)
</script>
</html>