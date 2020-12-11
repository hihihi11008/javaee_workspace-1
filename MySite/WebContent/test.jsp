<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
<%@ page import="java.sql.*,
javax.sql.*,
java.io.*,
javax.naming.InitialContext,
javax.naming.Context" %>
</head>
<body>
<h1>JDBC JNDI Resource Test</h1>

<%
InitialContext initCtx = new InitialContext();
DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/myoracle");
Connection conn = ds.getConnection();
Statement stmt = conn.createStatement();
ResultSet rset = stmt.executeQuery("select * from board");
while (rset.next()) {
	out.println("title=="+rset.getString("title")+"<br>");
}
rset.close();
stmt.close();
conn.close();
initCtx.close();
%>
</body>
</html>