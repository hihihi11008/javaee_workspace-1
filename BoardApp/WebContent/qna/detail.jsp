<%@page import="board.model.QnA"%>
<%@page import="board.model.QnADAO"%>
<%@page import="board.model.Notice"%>
<%@page import="board.model.NoticeDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%
	String qna_id = request.getParameter("qna_id");
	QnADAO qnADAO = new QnADAO();
	QnA qna = qnADAO.select(Integer.parseInt(qna_id));
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
textarea{
	background-color:yellow;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>
<script>
$(function(){
	CKEDITOR.replace("subject");
	
	$($("input[type='button']")[0]).click(function(){ //목록으로
		location.href="/qna/list.jsp";
	});

	$($("input[type='button']")[1]).click(function(){//수정요청
		if(confirm("수정하시겠어요?")){
			$("form").attr({
				method:"post",
				action:"/qna/edit.jsp"
			});
			$("form").submit(); //전송행위!!!
		}
	});

	$($("input[type='button']")[2]).click(function(){//삭제요청
		if(confirm("삭제하시겠습니까?")){
			$("form").attr({
				method:"post",
				action:"/qna/delete.jsp"
			});
			$("form").submit(); //전송행위!!!
		}
	});
	
	$($("input[type='button']")[3]).click(function(){//답글 폼요청
		$("form").attr({
			method:"get",
			action:"/qna/reply_form.jsp"
		});
		$("form").submit(); //전송행위!!!
	});

});
</script>
</head>
<body>

<div class="container">
  <form>
	<input type="hidden" name="notice_id" value="<%=qna.getQna_id()%>">

    <label for="fname">First Name</label>
    <input type="text" id="fname" name="author" value="<%=qna.getWriter()%>">

    <label for="lname">title</label>
    <input type="text" id="lname" name="title" value="<%=qna.getTitle()%>">

	<label for="subject">Content</label>
    <textarea id="subject" name="content" placeholder="Write something.." style="height:200px"><%=qna.getContent()%></textarea>

    <input type="button" value="목록으로">
	<input type="button" value="수정하기">
	<input type="button" value="삭제하기">
	<input type="button" value="답변달기">
	
  </form>
</div>
<div style="text-align:center">
	<%@ include file="/inc/footer.jsp"%>
</div>
</body>
</html>




