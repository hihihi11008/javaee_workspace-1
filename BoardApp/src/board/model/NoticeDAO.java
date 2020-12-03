/*
  DAO�� ? 
  - Data Access Object�� �ǹ��ϴ� ���ø����̼��� ���� �о� ���
  - Data Access�� �����ͺ��̽����� Create(=insert) Read(=select) UD�۾��� �����Ѵٴ� �ǹ�  
 */
package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBManager;

public class NoticeDAO {
	DBManager dbManager=new DBManager();
	
	//���뼺 ������� ���� swing ���� ���� �ۼ� 
	//insert �� �� �Ѱ�~~  �ϳ��� VO
	public int regist(Notice notice) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0; //�� ��� �� �� ����� ����
		
		con=dbManager.getConnection();
		
		String sql="insert into notice(author, title, content) values(?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, notice.getAuthor()); //�ۼ���
			pstmt.setString(2, notice.getTitle()); //����
			pstmt.setString(3, notice.getContent()); //����
			
			result=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}	
		return result;
	}	
	
	
	//�Խù� 1�� ��������(�󼼺���)
	public ResultSet select(int notice_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from notice where notice_id=?";
		
		con=dbManager.getConnection(); //���Ӱ�ü ��� 
		try {
			pstmt=con.prepareStatement(sql); //�����غ�
			pstmt.setInt(1, notice_id); //���ε� ������ ����
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt, rs);
		}
		return rs;
	}
}























