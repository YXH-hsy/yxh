package application;

import java.awt.*;
import javax.swing.*;

import com.MenuBars;

import action.RightMenu;


public class Main{
	/**
	 * 
	 * ��������������ڣ�ʹ�ø��ļ����ɵ��������ļ����¼�
	 * ���е�ע�����������Ķ�
	 * 
	 * */
	 // ʹ���Ҽ��˵��ĳ���Rp
	 private static final Component Rp = RightMenu.Rp;
	 // ������̬�Ҽ��˵�ʵ��	
	 protected static JPopupMenu pop = new JPopupMenu();
	 // ������̬�˵������������ļ�����
	 protected static JMenuBar mb = new JMenuBar();		
	 // ������̬�����ڷ��������ļ�����	
	 public static JFrame f = new JFrame("ģ����±� ");	
	 // ʹ��swing��ܵ��ı���awt�����������������
	 public static JTextArea ta = new JTextArea();  
	 
	 // ��Ӵ򿪺ͱ����ļ��ĶԻ���
	 public FileDialog openfile = new FileDialog(f,"ѡ��Ҫ�򿪵��ļ�",FileDialog.LOAD);
	 public FileDialog savefile = new FileDialog(f,"ѡ��Ҫ������ļ�",FileDialog.SAVE);
	
		
	// ���������
	public static void main(String[] args) {
		// ����Ҽ��˵�
		f.add(Rp);
		// ��������ʢװ���񲼾�
		JPanel p2 = new JPanel(new GridLayout(1,1));
			
		// ��ӹ���������
		ScrollPane sc = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		// �ڹ���������������ı���		
		sc.add(ta);
		// �ѹ���������׷�ӵ����񲼾ֵ���
		p2.add(sc);
		// �����񲼾�׷�ӵ�����		
		f.add(p2);		
		// ��Ӳ˵���
		f.setJMenuBar(mb);
	
		// ����ǵ���ȫ���ļ��Ĺؼ�����
		MenuBars aMenuBars = new MenuBars();
		aMenuBars.mbs();	// ���ò˵�������ķ������÷�������������������¼�		
		// �����Ҽ��˵�������Ҫ�¼���Ӧ
		ta.setComponentPopupMenu(pop);
		
		// ��ʾ����	
		f.setVisible(true);		
		// ���ִ�С�����ں�������ǰ������������ʾ
		f.setBounds(200,200,800,600);
		// ˢ������
		f.validate();
		// �رմ���
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
