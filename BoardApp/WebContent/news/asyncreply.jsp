<%@page import="board.model.CommentsDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<%
	//여기서 쿼리실행할 것은 아니지만, 계획을 세우기 위해 ....
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="comments" class="board.model.Comments"/>
<jsp:setProperty property="*" name="comments"/>
<%
	if(new CommentsDAO().insert(comments)==0){
		out.print("코멘트 등록실패");
	}else{
		out.print("코멘트 등록성공");
	}
%>