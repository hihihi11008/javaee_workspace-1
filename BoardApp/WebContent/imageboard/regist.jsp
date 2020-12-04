<%@page import="common.FileManager"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	String saveDir="D:/workspace/javaee_workspace/BoardApp/WebContent/data";
	int maxSize=3*1024*1024; //3M byte
%>
<%
	//실습햇던 예제보다 기능이 더 추가됨, db에 넣어야 함.. DAO이용
	
	//업로드컴포넌트에 대한 설정을 하기 위해 FileItemFactory객체를 이용해야 한다..
	DiskFileItemFactory itemFactory=new DiskFileItemFactory();
	itemFactory.setRepository(new File(saveDir));
	itemFactory.setSizeThreshold(maxSize);
	
	ServletFileUpload upload=new ServletFileUpload(itemFactory);
	
	//업로드된 정보 분석!!! 각각의 컴포넌트들을  FileItem 단위로 쪼갠다..
	List<FileItem> items=upload.parseRequest(request);
	
	for(FileItem item : items){
		if(item.isFormField()){ //textfield 라면...db에 넣어야지
			
		}else{ // textfield가 아니라면..업로드 처리
			String newName=System.currentTimeMillis()+"."+FileManager.getExtend(item.getName());
			String destFile = saveDir+"/"+newName;
			File file = new File(destFile);
			item.write(file);//물리적 저장 시점!!!	
			
			out.print("업로드 완료");
		}
	}
%>










