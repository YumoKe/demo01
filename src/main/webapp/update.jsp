<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form action="<%=path%>/upd" method="post">
			<input type="hidden" name="gid" value="${param.gid }">
		商品名称：<input type="text" name="gname"><br><br>
		英文名称：<input type="text" name="gename"><br><br>
		商品品牌：<select name="bid">
			<option></option>
		</select><br><br>
		商品种类：<select name="gsid">
			<option></option>
		</select><br><br>
		尺寸：<input type="text" name="weight"><br><br>
		单价<input type="text" name="price"><br><br>
		数量：<input type="text" name="cot"><br><br>
		标签<textarea rows="10px" cols="20px" name="message"></textarea><br><br>
		图片：<img style="width: 100px;height: 100px" name="img"><br><br>
		<input type="hidden" name="imgurl"><br><br>
		<input type="submit" value="修改">
	</form>
</body>
<script type="text/javascript">
	$(function(){
		var gid = $("[name=gid]").val();
		$.post(
				"<%=path%>/toUpd",
				{gid:gid},
				function(obj) {
					$("[name=gname]").val(obj.gname)
					$("[name=gename]").val(obj.gename)
					$.post(
						"<%=path%>/brand",
						function (obj1){
							var opt = "";
							$.each(obj1,function(index,date){
								if (date.bid == obj.bid) {
								opt += "<option value='"+date.bid+"' selected>"+date.bname+"</option>"
								} else {
									opt += "<option value='"+date.bid+"'>"+date.bname+"</option>"
								}
							});
							$("[name=bid]").append(opt);
						},
						"json"
					)
					$.post(
						"<%=path%>/kind",
						function (obj1){
							var opt = "";
							$.each(obj1,function(index,date){
								if (date.gsid==obj.gsid) {
								opt += "<option value='"+date.gsid+"' selected>"+date.gsname+"</option>"
								}else {
								opt += "<option value='"+date.gsid+"' >"+date.gsname+"</option>"
								}
							});
							$("[name=gsid]").append(opt);
						},
						"json"
					)
					$("[name=weight]").val(obj.weight)
					$("[name=price]").val(obj.price)
					$("[name=cot]").val(obj.cot)
					$("[name=message]").val(obj.message)
					$("[name=img]").attr("src","<%=path%>/looking?path="+obj.imgurl);
					$("[name=imgurl]").val(obj.imgurl);
				},
				"json"
				)
	})

</script>
</html>