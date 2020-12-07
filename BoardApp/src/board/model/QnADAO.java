package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import db.DBManager;

public class QnADAO {
	DBManager dbManager=new DBManager();
	
	//insert : ���� ���
	public int insert(QnA qna) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		String sql="insert into qna(writer, title ,content) values(?,?,?)";
		try {
			con=dbManager.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, qna.getWriter());
			pstmt.setString(2, qna.getTitle());
			pstmt.setString(3, qna.getContent());
			result=pstmt.executeUpdate();//����
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}
		return result;
	}
	
	/*	
	1.������ �������ۺ��� rank�� ū ���� rank�� ��� 1�� �����ǽÿ�!! (����Ȯ�� )
    update  qna  rank=rank+1 where rank > ������ rank and 
    team=����team

	2.�� ������ ���� ����!!(�亯)
	   insert  qna(~team, rank, depth) values(����team,����rank+1,����depth+1)
	 */   
	public int reply() {
		int result=0;		
		return result;
	}
	
	//selectAll
	public List selectAll() {
		return null;
	}
	
	//select
	public QnA select() {
		return null;
	}
	
	//update
	public int update() {
		int result=0;
		return result;
	}
	
	//delete
	public int delete() {
		int result=0;
		return result;
	}
	
}


