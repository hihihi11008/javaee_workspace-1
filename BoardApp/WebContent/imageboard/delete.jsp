<%@page import="board.model.ImageBoardDAO"%>
<%@page import="java.io.File"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<%
	// 넘겨받은 board_id 를 이용하여 삭제 
	String board_id = request.getParameter("board_id");
	String filename = request.getParameter("filename");

	out.print("지우게될 게시물 board_id는 "+board_id);
	
	//삭제업무(DB삭제 + 파일삭제)
	
	//파일삭제(파일을 다룰 수 있는 클래스:  java.io.File) 
	File file = new File("D:/workspace/javaee_workspace/BoardApp/WebContent/data/"+filename);
	if(file.delete()){
		
		ImageBoardDAO dao = new ImageBoardDAO();
		dao.delete(Integer.parseInt(board_id));//db삭제
		out.print(getMsgURL("삭제처리되었습니다.", "/imageboard/list.jsp"));
	}else{
		out.print(getMsgBack("삭제되지 않았습니다."));
	}	
%>












