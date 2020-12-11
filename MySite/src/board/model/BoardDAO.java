package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.db.PoolManager;

public class BoardDAO {
	PoolManager pool = new PoolManager();
	
	public int insert(Board board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		String sql="insert into board(board_id, title,writer,content,filename) values(seq_board.nextval,?,?,?,?)";
		
		con=pool.getConnection();//�뿩!!���ο� ������ �ƴϴ�!!(�ӵ��� ������)
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getFilename());
			result=pstmt.executeUpdate(); //���� �߰���
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
}









