package board.gui;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BoardWrite extends Page{
	JTextField t_author;
	JTextField t_title;
	JTextArea area;
	JScrollPane scroll;
	JButton bt;
	
	public BoardWrite(BoardMain boardMain) {
		super(boardMain);
		//����
		t_author = new JTextField();
		t_title = new JTextField();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bt = new JButton("���");
		
		//��Ÿ��
		t_author.setPreferredSize(new Dimension((int)this.getPreferredSize().getWidth()-10, 25));
		t_title.setPreferredSize(new Dimension((int)this.getPreferredSize().getWidth()-10, 25));
		scroll.setPreferredSize(new Dimension((int)this.getPreferredSize().getWidth()-10, 500));
		
		//���� 
		add(t_author);
		add(t_title);
		add(scroll);
		add(bt);
		
		//��� 
		bt.addActionListener((e)->{
			regist();
		});
	}
	
	//���뼺 ������� ���� swing ���� ���� �ۼ� 
	public void regist() {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		con= boardMain.dbManager.getConnection();
		
		String sql="insert into notice(author, title, content) values(?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, t_author.getText()); //�ۼ���
			pstmt.setString(2, t_title.getText()); //����
			pstmt.setString(3, area.getText()); //����
			
			int result=pstmt.executeUpdate();
			if(result==0) {
				JOptionPane.showMessageDialog(this, "��Ͻ���");
			}else {
				JOptionPane.showMessageDialog(this, "��ϼ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			boardMain.dbManager.release(con, pstmt);
		}		
	}
	
}















