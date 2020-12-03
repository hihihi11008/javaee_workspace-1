package board.gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class BoardMain extends JFrame{
	//����� ������ ���� 
	Page[] pageList=new Page[Pages.values().length]; //enum�� ��ϵ� ������ ��ŭ����
	
	public BoardMain() {
		//������ ���� 
		pageList[0] = new BoardList(this);
		pageList[1] = new BoardWrite(this);
		pageList[2] = new BoardContent(this);
		
		setLayout(new FlowLayout()); //�����ӿ� �������� ������Ʈ�� �����Ƿ��� �÷ο��~
		
		//�������� ���� 
		for(Page page: pageList) {
			add(page);
		}
		
		setSize(900,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BoardMain();
	}

}
