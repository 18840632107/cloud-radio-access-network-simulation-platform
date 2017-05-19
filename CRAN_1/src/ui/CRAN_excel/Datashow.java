/**
 * ���firstpage�ϵ�UE�����Ե���excel���ݿ���ʾUE���ݿ���Ϣ�������в�ѯ
 */
package ui.CRAN_excel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.awt.event.*;//�¼���Ӧ

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;


public class Datashow extends JDialog implements ActionListener,TreeSelectionListener{
	//����һЩ�ؼ�
	JPanel jp1,jp2;
	JLabel jl1;
	JButton jb1,jb2,jb3,jb4;
	JTable jt;
	JScrollPane jsp;
	JTextField  jtf;
	Tablemodule tm;

	public Datashow(Frame owner,String title,boolean modal)
	{
		super(owner,title,modal);
		jp1=new JPanel();
		jl1=new JLabel("UE ID");
		jtf=new JTextField(10);
		jb1=new JButton("��ѯ");
		jb1.addActionListener(this);//ע�����
		//�Ѹ����ؼ����뵽jp1���Զ�������
		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2=new JPanel();
		jb2=new JButton("���");
		jb2.addActionListener(this);
		jb3=new JButton("�޸�");
		jb3.addActionListener(this);
		jb4=new JButton("ɾ��");
		jb4.addActionListener(this);
		//�Ѹ����ؼ�����jp2,�Զ�������
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);

		
		//����һ������ģ�Ͷ��󣬱�ģ�Ͷ���
		Tablemodule tm=new Tablemodule();
		String sql="select * from UE where 1=?";
		String []paras={"1"};
		tm.search(sql,paras);
		jt=new JTable(tm);
		//��ʼ��jsp
		jsp=new JScrollPane(jt);
		//��jsp���뵽JFrame��
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		this.setSize(500, 400);
		this.setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//��ѯ
		if(arg0.getSource()==jb1)
		{
			//��Ϊ�ѶԱ�����ݷ�װ��һ�����У����ǾͿ��ԱȽϼ򵥵���ɲ�ѯ
			String ID=this.jtf.getText().trim();
			System.out.print(ID);
			if("".equals(ID))//�������δ���textfildû���������ݣ���ѯ��ʾȫ����Ϣ������
			{	
				String sql="select * from UE where 1=?";
				String []paras={"1"};
				//System.out.print("null");
				//�����µ�����ģ���࣬������
				tm=new Tablemodule();
				tm.search(sql, paras);
			}
			else
			{
				//дһ��sql���
				String sql="select * from UE where ID=?";
				String []paras={ID};
				//System.out.print(paras.length);
				//�����µ�����ģ���࣬������
				tm=new Tablemodule();
				tm.search(sql, paras);

			}
			//����JTable
			jt.setModel(tm);
		}
		//���û�������ʱ
		else if(arg0.getSource()==jb2)
		{
			Dataadd dataadd=new Dataadd(this, "���UE����", true);//�ǵö�jb2ע�������TRUE ģʽ�Ի���
			//�����ٻ���µ�����ģ��
			//�����µ�����ģ���࣬������
			tm=new Tablemodule();
			//����JTable
			String sql="select * from UE where 1=?";
			String []paras={"1"};
			tm.search(sql,paras);
			jt.setModel(tm);
		}
//		else if(arg0.getSource()==jb3)
//		{
//			//�޸ļ�¼
//			int rowNum=this.jt.getSelectedRow();//�����û����е���
//			if(rowNum==-1)//����û�û��ѡ��ĳһ��
//			{
//				//��ʾ
//				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
//				return;
//			}
//			//��ʾ�޸ĶԻ���
//			new Modifystu(this, "�޸�", true, stm, rowNum);
//			//�����µ�����ģ���࣬������
//			stm=new StutableModule();
//			//����JTable
//			jt.setModel(stm);
//		}
		else if(arg0.getSource()==jb4)
		{
			//˵���û�ϣ��ɾ����¼
			//�õ�ѧ��ID��
			int rowNum=this.jt.getSelectedRow();//�����û����ӵ���
			if(rowNum==-1)//����û�û��ѡ��ĳһ��
			{
				//��ʾ
				JOptionPane.showMessageDialog(this,"��ѡ��һ��");
				return;
			}
			//�õ�ѧ�����
			String ID=(String) tm.getValueAt(rowNum,0);
			//�������ݿ����ɾ������
			//����һ��SQL���
			String sql="delete from UE where ID=?";
			String []paras={ID};
			Tablemodule temp=new Tablemodule();
			temp.change(sql, paras);
			
			//�������ݿ� 
			tm=new Tablemodule();
			String []paras2={"1"};
			tm.search("select * from UE where 1=?",paras2);
			jt.setModel(tm);
			
		}
	}
	@Override
	public void valueChanged(TreeSelectionEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}}

