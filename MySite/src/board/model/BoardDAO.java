package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.db.PoolManager;

public class BoardDAO {
	PoolManager pool = PoolManager.getInstance();//싱글턴 객체 호출
	
	public int insert(Board board) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		String sql="insert into board(board_id, title,writer,content,filename) values(seq_board.nextval,?,?,?,?)";
		
		con=pool.getConnection();//대여!!새로운 접속이 아니다!!(속도가 빠르다)
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getFilename());
			result=pstmt.executeUpdate(); //여기 추가요
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt);
		}
		return result;
	}
	
	//모든 글 가져오기
	public List selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList list = new ArrayList();
		String sql="select * from board order by board_id desc";
		
		con=pool.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoard_id(rs.getInt("board_id"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setHit(rs.getInt("hit"));
				board.setFilename(rs.getString("filename"));
				
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		return list;
	}
}












