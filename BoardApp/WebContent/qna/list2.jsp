<%@ page contentType="text/html;charset=utf-8"%>
<%	
	int totalRecord=3926; //총 레코드 수 
	int pageSize=10; //한 페이지당 보여질 레코드 수
	int totalPage =(int)Math.ceil((float)totalRecord/pageSize);// 총 페이지수
	int blockSize=10; //한 블럭당 보여질 페이지 수
	int currentPage=1; //현재 페이지
	currentPage = Integer.parseInt(request.getParameter("currentPage"));
	int firstPage=currentPage - (currentPage-1)%blockSize; //반복문의 시작 값 
	int lastPage=firstPage + (blockSize-1); //반복문의 끝값
%>
<%="totalRecord "+totalRecord+"<br>"%>
<%="pageSize "+pageSize+"<br>"%>
<%="totalPage "+totalPage+"<br>"%>
<%="blockSize "+blockSize+"<br>"%>
<%="currentPage "+currentPage+"<br>"%>
<%="firstPage "+firstPage+"<br>"%>
<%="lastPage "+lastPage+"<br>"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
img{
	box-sizing:border-box;
}
a{
	text-decoration:none;
}

.pageNum{
	font-size:20pt;
	color:red;
	font-weight:bold;
}
</style>
<script>
</script>
</head>
<body>
<table>
  <tr>
    <th>No</th>
    <th>제목</th>
    <th>작성자</th>
	<th>등록일</th>
	<th>조회수</th>
  </tr>

	<%for(int i=1;i<=pageSize;i++){ %>
  <tr>
    <td>26</td>
    <td>제목입니다</td>
    <td></td>
	<td></td>
	<td></td>
  </tr>
	<%} %>  
 <tr>
	<td colspan="5" style="text-align:center"> 
		<a href="/qna/list2.jsp?currentPage=<%=firstPage-1%>">◀</a>
		<%for(int i=firstPage;i<=lastPage;i++){%>
		<a href="/qna/list2.jsp?currentPage=<%=i %>"   <%if(currentPage==i){%>class="pageNum"<%}%> >[<%=i %>]</a>
		<%} %>
		<a href="/qna/list2.jsp?currentPage=<%=lastPage+1%>">▶</a>							
	</td>
   </tr>
	
	<tr>	
	<td colspan="5" > 
		<button>글등록</button>
	</td>
  </tr>
  <tr>
	<td colspan="5" style="text-align:center"> 
		<%@ include file="/inc/footer.jsp"%>
	</td>
  </tr>

</table>
</body>
</html>