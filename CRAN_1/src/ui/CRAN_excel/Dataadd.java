package ui.CRAN_excel;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
public class Dataadd extends JDialog implements ActionListener{
	//��������Ҫ�Ŀؼ�
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2,jl3,jl4,jl5;
	JButton jb1,jb2;
	JTextField  jtf1, jtf2, jtf3, jtf4, jtf5;
	//owner���ĸ�����
	//title������
	//modalָ��ģ̬���ڣ����Ƿ�ģ̬����
	public Dataadd(Dialog owner,String title,boolean modal)
	
	{
		super(owner,title,modal);//���ø���JDialog���췽�����ﵽģʽ�Ի���Ч��
		jl1=new JLabel("ID");
		jl2=new JLabel("3D message");
		jl3=new JLabel("door");
		jl4=new JLabel("wireless");
		
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();

		
		jb1=new JButton("���");
		jb1.addActionListener(this);//�����û��Ӧ��ע�����
		jb2=new JButton("ȡ��");
		jb2.addActionListener(this);//��ȡ��û��Ӧ��ע�����
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		//���ò���
		jp1.setLayout(new GridLayout(5,1));
		jp2.setLayout(new GridLayout(5,1));
		//������
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);

		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);

		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);

		//չ��
		this.setSize(400, 300);
		
		this.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		if(arg0.getSource()==jb1)
		{
//			//��ֲ��module�г�Ϊһ��������moduleʵ����ɾ�Ĳ顣
//			//�������ݿ�
//			//���û������Ӱ�ť�����Ӧ����
			boolean s=true;
			//ϣ�����
			Tablemodule tm=new Tablemodule();
			String sql="insert into UE values(?,?,?,?)";
			String []paras={jtf1.getText(), jtf2.getText(), jtf3.getText(), jtf4.getText()};
			for(int i=0;i<paras.length;i++)//���ʱÿ�����Զ�������Ϊ��
			{ 
				boolean t=paras[i].equals(""); //�пգ�b=true;ȫ��b=false
				if(t)
				 {
					 System.out.println(paras[i]);
					 System.out.println(paras[i].equals(""));
					 s=false;
					 JOptionPane.showMessageDialog(this, "���ʧ��");//�����Ի���
					 break;
				 }
			}
				if(s==true)
				{
				tm.change(sql, paras);//��Ϊ����ʱ����ֵ
				this.dispose();//�رնԻ���
			}

	}
		if(arg0.getSource()==jb2)
		{
			this.dispose();//�رնԻ���
		}
	}}