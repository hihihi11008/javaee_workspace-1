/*�Խ��� ��� ������*/
package board.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BoardList extends Page{
	JTable table;
	JScrollPane scroll;
	JButton bt; //�۾��� �� �̵���ư
	
	public BoardList(BoardMain boardMain) {
		super(boardMain);
		//����
		table = new JTable(20, 5);
		scroll = new JScrollPane(table);
		bt = new JButton("�۵��");
		
		//��Ÿ��
		this.setBackground(Color.YELLOW);
		
		//����
		add(scroll);
		add(bt);
	}
	
}


