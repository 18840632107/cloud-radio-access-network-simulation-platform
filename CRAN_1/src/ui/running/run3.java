/*
 * ������run3
 * ���ܣ��������н���
 */
package ui.running;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;

import ui.Draft.pic_line1;
import ui.Draft.pic_pie1;
import ui.Share_bag.*;

import java.awt.FlowLayout;

import com.config.ConfigJavaControler;
import com.test.StreamToTextArea;
import com.test.ThreadTaskMain;
import com.test.main;

import java.awt.GridLayout;

import javax.swing.JRadioButton;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYSeries;

import java.util.Timer;
public class run3 extends JFrame implements ActionListener{
	public Timer timer;
	String path="image"+File.separator+"running"+File.separator+"running.png";
	Image image=new ImageIcon(path).getImage(); 
	private final JPanel contentPanel = new BackgroundPanel(image);
	JLabel label;
	JPanel x;
	JRadioButton jb1_1,jb1_2,jb2,jb3_1,jb3_2,jb4_1,jb4_2;
	ButtonGroup bg1,bg2,bg3,bg4;
	JButton button1,button2,button3,button4,button_out;
	public static Long startTime;
	public static Long endTime;
	public static  JTextField textField_2;
	public static  JTextField textField_3;
	JSplitPane splitPane;
	JPanel panel_chart_1,panel_chart_2,panel_chart_3,panel_chart_4;
	JPanel panel_pic1,panel_pic2,panel_pic3,panel_pic4;
	StreamToTextArea blah = StreamToTextArea.getInstance();//�ı����ӡ�������*****���õ���ģʽ
	public static JProgressBar bar;
	public static ThreadTaskMain main_thread = new ThreadTaskMain(com.test.main.vMyGroup,"main procedure");
	public static  JTextField textField_4;
	private JPanel panel_chart_1_change,panel_chart_2_change,panel_chart_3_change,panel_chart_4_change;
	private static String name = BBU_sql.name;
	private static String pswd = BBU_sql.pswd;
//	public static void main(String[] args) {
//		try {
//			run3 dialog = new run3();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
	/**************************************
	 * ���ܣ��������н���
	 ***************************************/
	public run3(Dialog owner,String title,boolean modal) {
	//super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
//	public run3() {
		System.setOut(blah.getPs());
		setTitle("���м����չʾ����");
		setBounds(50, 20,  1230, 700);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_title = new JPanel();
				panel_title.setOpaque(false);
				label = new JLabel("���м����չʾ");
				label.setFont(MyTools.f1);
				panel_title.add(label);
				panel.add(panel_title, BorderLayout.WEST);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setOpaque(false);
				panel.add(panel_1, BorderLayout.EAST);
				{
					JLabel label_1 = new JLabel("����״̬��");
					panel_1.add(label_1);
				}
				{
					textField_2 = new JTextField();
					panel_1.add(textField_2);
					textField_2.setColumns(10);
				}
				{
					textField_4 = new JTextField();
					panel_1.add(textField_4);
					textField_4.setColumns(10);
				}
				{
					JLabel label_1 = new JLabel("����ʱ�䣺");
					panel_1.add(label_1);
				}
				{
					textField_3 = new JTextField();
					panel_1.add(textField_3);
					textField_3.setColumns(10);
				}
			}
			
		}
		{
			JPanel panel = new JPanel();
			panel.setOpaque(false);
			contentPanel.add(panel, BorderLayout.SOUTH);
			panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			{
				button_out = new JButton("�˳�");
				button_out.addActionListener(this);
				button_out.setFont(MyTools.f14);
				panel.add(button_out);
			}
		}
		/***************************************��߽���************************************/
		{
			splitPane = new JSplitPane();
			splitPane.setBackground(Color.white);
			splitPane.setDividerLocation(880);//�������ҷ�����С�����岼�ֳߴ�����͹̶���
			contentPanel.add(splitPane, BorderLayout.CENTER);
			{
				JPanel panel = new JPanel();
				
				splitPane.setLeftComponent(panel);
				panel.setLayout(new GridLayout(2, 2, 0, 0));
				{
					panel_chart_1 = new JPanel();
					panel_chart_1.setLayout(new BorderLayout(0, 0));
					panel.add(panel_chart_1);
					{
						JPanel panel_2 = new JPanel();
						panel_chart_1.add(panel_2, BorderLayout.NORTH);
						{
							jb1_1 = new JRadioButton("ÿ��RRU������");
							jb1_1.addActionListener(this);
							panel_2.add(jb1_1);
						}
						{
							jb1_2 = new JRadioButton("���5%������");
							jb1_2.addActionListener(this);
							panel_2.add(jb1_2);
						}
						bg1 = new ButtonGroup();  
						bg1.add(jb1_1);  
						bg1.add(jb1_2);
					}
					{
						panel_chart_1_change = new JPanel();
						panel_chart_1_change.setLayout(new BorderLayout(0, 0));
//						panel_chart_1_change.add(new pic_line1().getChartPanel());
						panel_chart_1.add(panel_chart_1_change, BorderLayout.CENTER);
					}
				}
				{
					panel_chart_2 = new JPanel();
					panel_chart_2.setLayout(new BorderLayout(0, 0));
					panel.add(panel_chart_2);
					{
						JPanel panel_2 = new JPanel();
						panel_chart_2.add(panel_2, BorderLayout.NORTH);
						{
							jb2 = new JRadioButton("SINR");
							jb2.addActionListener(this);
							panel_2.add(jb2);
						}
						bg2 = new ButtonGroup();  
						bg2.add(jb2);
					}
					{
						panel_chart_2_change = new JPanel();
						panel_chart_2_change.setLayout(new BorderLayout(0, 0));
//						panel_chart_2_change.add(new pic_pie1().getChartPanel()); 
						panel_chart_2.add(panel_chart_2_change, BorderLayout.CENTER);
					}
					
				}
				{
					panel_chart_3 = new JPanel();
					panel_chart_3.setLayout(new BorderLayout(0, 0));
					panel.add(panel_chart_3);
					{
						JPanel panel_2 = new JPanel();
						panel_chart_3.add(panel_2, BorderLayout.NORTH);
						{
							jb3_1 = new JRadioButton("����BBUƵ��Ч��");
							jb3_1.addActionListener(this);
							panel_2.add(jb3_1);
						}
						{
							jb3_2 = new JRadioButton("ϵͳ�Ĺ�һ��Ƶ��Ч��");
							jb3_2.addActionListener(this);
							panel_2.add(jb3_2);
						}
						bg3 = new ButtonGroup();  
						bg3.add(jb3_1);  
						bg3.add(jb3_2);
					}
					{
						panel_chart_3_change = new JPanel();
						panel_chart_3_change.setLayout(new BorderLayout(0, 0));
						panel_chart_3.add(panel_chart_3_change, BorderLayout.CENTER);
					}
				}
				{
					panel_chart_4 = new JPanel();
					panel.add(panel_chart_4);
					panel_chart_4.setLayout(new BorderLayout(0, 0));
					{
						JPanel panel_2 = new JPanel();
						panel_chart_4.add(panel_2, BorderLayout.NORTH);
						{
							jb4_1 = new JRadioButton("����BBU��̬�����ܺ�");
							jb4_1.addActionListener(this);
							panel_2.add(jb4_1);
						}
						{
							jb4_2 = new JRadioButton("ϵͳ�����ܺ�");
							jb4_2.addActionListener(this);
							panel_2.add(jb4_2);
						}
						bg4 = new ButtonGroup();  
						bg4.add(jb4_1);  
						bg4.add(jb4_2);
					}
					{
						panel_chart_4_change = new JPanel();
						panel_chart_4_change.setLayout(new BorderLayout(0, 0));
						panel_chart_4.add(panel_chart_4_change, BorderLayout.CENTER);
					}
				}
			}
	/***************************************�ұ߽���************************************/
			{
				JPanel panel = new JPanel();
				splitPane.setRightComponent(panel);
				panel.setLayout(new BorderLayout(0, 0));
				{
					JPanel panel_1 = new JPanel();
					panel.add(panel_1, BorderLayout.NORTH);
					panel_1.setLayout(new GridLayout(2, 1, 0, 0));
					{
						JPanel panel_2 = new JPanel();
						panel_1.add(panel_2);
						bar = new JProgressBar();
						bar.setMinimum(0);
						bar.setMaximum(100);
						bar.setValue(0);
						bar.setStringPainted(true);
						bar.setPreferredSize(new Dimension(200, 30));
						panel_2.add(bar);
					}
					{
						JPanel panel_2 = new JPanel();
						panel_1.add(panel_2);
						{
							button1 = new JButton("��ʼ");
							button1.setFont(MyTools.f14);
							button1.addActionListener(this);
							panel_2.add(button1);
						}
						{
							button2 = new JButton("��ͣ");
							button2.setFont(MyTools.f14);
							button2.addActionListener(this);
							panel_2.add(button2);
						}
						{
							 button3 = new JButton("ֹͣ");
							 button3.setFont(MyTools.f14);
							 button3.addActionListener(this);
							panel_2.add(button3);
						}
					}
				}
				{
					JPanel panel_1 = new JPanel();
					panel.add(panel_1, BorderLayout.SOUTH);
					panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
					{
						button4 = new JButton("ˢ��ͼ��");
						button4.setFont(MyTools.f14);
						button4.addActionListener(this);
						panel_1.add(button4);
					}
				}
				{
					panel.add(blah, BorderLayout.CENTER);
				}
			}
		}
	}
	/**************************************
	 * ���ܣ������ϸ�����ť�ļ�����Ӧ����
	 ***************************************/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		if(arg0.getSource()==button1)//��ʼ
		{
			startTime = System.currentTimeMillis(); 
			//���������̣߳��������ɰ�ť֮ǰҪ�ж��߳��Ƿ����Ѵ��ڣ������ε���ᴴ������߳�
			
			if(!main_thread.isAlive())
			{
				System.loadLibrary("NativeTestJni");//���ؿ�1
				System.loadLibrary("NativeProCase");//���ؿ�2
				main_thread=new ThreadTaskMain(com.test.main.vMyGroup,"main procedure");
				main_thread.start();
				SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");//�������ڸ�ʽ
				ConfigJavaControler.vLogCppFile=ConfigJavaControler.vLogCppFile.substring(0, 11)+df.format(new Date())+".txt";
				System.out.println("�߳������ɹ�����������������");
			}
			timer = new Timer(true);
			timer.schedule(
				new java.util.TimerTask() { public void run()
					{ 
					//��һ��ͳ��ͼ��
					if(jb1_1.isSelected()==true)
					{
						Last5PercentRate_RRU();
					}
					else if(jb1_2.isSelected()==true)
					{
						Last5PercentRate_TTI();
					}
					//�ڶ���ͳ��ͼ��
					if(jb2.isSelected()==true)
					{
						SINR();
					}
					//������ͳ��ͼ��
					if(jb3_1.isSelected()==true)
					{
						Efficiency_BBU();
					}
					else if(jb3_2.isSelected()==true)
					{
						Efficiency_TTI();
					}
					//���ĸ�ͳ��ͼ��
					if(jb4_1.isSelected()==true)
					{
						ConsumeSum_BBU();
					}
					else if(jb4_2.isSelected()==true)
					{
						ConsumeSum_TTI();
					}
					} 
				}, 0, 1000);//�������1ms
		}
		if(arg0.getSource()==button3)
		{
			//ɾ���ȶ�ҵ�������ɵ��û�
			String sql="Drop_Business_Ue";
			String []paras={};
			BBU_sql sqlh=new BBU_sql();
			Boolean b; 
			b=sqlh.add_delete_change(sql, paras);
			
			Thread mythread[]=new Thread[main.vMyGroup.activeCount()];
			main.vMyGroup.enumerate(mythread);
			try {
				if (mythread.length>0) {
					for (int i = 0; i < mythread.length; i++) {
						if (mythread[i].getName().equals("main procedure")) {
							System.out.println("׼��ϵͳ��ͣ");
							//main.vMyGroup.interrupt();
							System.out.println("---------"+mythread[i].getState());
							synchronized(mythread[i]){
									((ThreadTaskMain)mythread[i]).stopThread();									
							}
						}
					}
				}
				else {
					System.out.println("�߳���Ϊ��");
				}
				
			} catch (Exception e2) {
				
				//System.out.println(e2.toString());// TODO: handle exception
			}
		
			System.out.println("ϵͳ��ͣ");
		}
		if(arg0.getSource()==button2)
		{
			ConfigJavaControler.vFlagPause=ConfigJavaControler.vFlagPause?false:true;// ������ͣ
			if(!ConfigJavaControler.vFlagPause)
			{
				button2.setText("����");
			}else{
				button2.setText("��ͣ");
			}
		}
		if(arg0.getSource()==button4)//ˢ��ͳ��ͼ��
		{
			//��һ��ͳ��ͼ��
			if(jb1_1.isSelected()==true)
			{
				Last5PercentRate_RRU();
			}
			else if(jb1_2.isSelected()==true)
			{
				Last5PercentRate_TTI();
			}
			//�ڶ���ͳ��ͼ��
			if(jb2.isSelected()==true)
			{
				SINR();
			}
			//������ͳ��ͼ��
			if(jb3_1.isSelected()==true)
			{
				Efficiency_BBU();
			}
			else if(jb3_2.isSelected()==true)
			{
				Efficiency_TTI();
			}
			//���ĸ�ͳ��ͼ��
			if(jb4_1.isSelected()==true)
			{
				ConsumeSum_BBU();
			}
			else if(jb4_2.isSelected()==true)
			{
				ConsumeSum_TTI();
			}
			
			
		}
		else if(arg0.getSource()==jb1_1)//����RRU������
		{
			Last5PercentRate_RRU();
		}
		else if(arg0.getSource()==jb1_2)//���5%������
		{
			Last5PercentRate_TTI();
		}
		else if(arg0.getSource()==jb2)//SINR
		{
			SINR();
		}
		else if(arg0.getSource()==jb3_1)//����BBUƵ��Ч��
		{
			Efficiency_BBU();
		}
		else if(arg0.getSource()==jb3_2)//ϵͳƵ��Ч��
		{
			Efficiency_TTI();
		}
		else if(arg0.getSource()==jb4_1)//����BBU�ܺ�
		{
			ConsumeSum_BBU();
		}
		else if(arg0.getSource()==jb4_2)//ϵͳ�ܺ�
		{
			ConsumeSum_TTI();
		}
		else if(arg0.getSource()==button_out)//�˳�//////////////////////////////////////////////////////////
		{
			this.dispose();//�رնԻ���
		}
	}
	/***************************************����RRU������************************************/
	public void Last5PercentRate_RRU() {
		//���������������
		String [] RRU_ID=new String[15];//��ʱ��ֻ����ʾ���ǰ15��RRU������������ͼ��̫��������ͼ��ʾ����
		Double []RRU_Rate=new Double[15];
		int num=0;
		String sql="select * from Rru where 1=?";//�ٴ�Rru�е�����ӵ�����	
		String []paras={"1"};//������ʾ���е�Rru  
		BBU_sql sqlh=null;
		try {
			sqlh=new BBU_sql();
			ResultSet rs=sqlh.search(sql, paras);
			while(rs.next())					
			{
				if(num<15)
				{
					RRU_ID[num]=rs.getString(1);//ID
					if (rs.getString(15).equals("0.0"))
					{
						RRU_Rate[num]=0.0;//������
					}
					else
					{
						RRU_Rate[num]=Double.parseDouble(rs.getString(15));//������
					}
					
					num=num+1;//num:0-14��ʾ����˼�������
				}
			}
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < num; i++) {
				dataset.addValue(RRU_Rate[i], "RRU", "RRU"+RRU_ID[i]);  
			}
			pic_column1 pic_column_module=new pic_column1("����RRU������","RRU","������",dataset);
			panel_pic1 =pic_column_module.getChartPanel();
			
			panel_chart_1_change.removeAll();
			panel_chart_1_change.add(panel_pic1, BorderLayout.CENTER);
			panel_chart_1_change.updateUI();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			//�ر�
			sqlh.close();
		}
	}
	/***************************************���5%������************************************/
	public void Last5PercentRate_TTI() {
		//��ȷ��Last5PercentRate�����ж��ٸ�TTI
		//��Ҫ�������ݿ�
		int TTI_number=0;
		String sql1="exec RowNum ?";
		String []paras1={"Last5PercentRate"};
		BBU_sql sqlh=null;
		try {
			sqlh=new BBU_sql();
			ResultSet TTI_num=sqlh.search(sql1, paras1);
			TTI_num.next();
			TTI_number=TTI_num.getInt(1);//TTI_numberȷ��Last5PercentRate�����ж��ٸ�TTI
		} catch (Exception e) {
			// TODO: handle exception
		}
		//���������������
		int [] TTI=new int[TTI_number];
		Double []TTI_Rate=new Double[TTI_number];
		int num=0;//0-TTI_number
		String sql="select * from Last5PercentRate where 1=?";//�ٴ�Last5PercentRate�е�����ӵ�����	
		String []paras={"1"};//������ʾ���е�Rru  
		BBU_sql sqlh2=null;
		try {
			sqlh2=new BBU_sql();
			ResultSet rs=sqlh2.search(sql, paras);
			while(rs.next())					
			{

				TTI[num]=Integer.parseInt(rs.getString(1));//TTI
				if (rs.getString(2).equals("0.0"))
					{
						TTI_Rate[num]=0.0;//������
					}
				else
				{
					TTI_Rate[num]=Double.parseDouble(rs.getString(2));//TTI��������	
				}				
				num=num+1;//num:��ʾ����˼�������
			}
			 DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();  
			for (int i = 0; i <num; i++) {
				int temp=TTI[i];
				defaultdataset.addValue(TTI_Rate[i],"TTI",String.valueOf(temp)); //TTI[i]
			}
			pic_line pic_line_module=new pic_line("���5%������","TTI","������",defaultdataset);
			panel_pic1 =pic_line_module.getChartPanel();
			
			panel_chart_1_change.removeAll();
			panel_chart_1_change.add(panel_pic1, BorderLayout.CENTER);
			panel_chart_1_change.updateUI();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			//�ر�
			sqlh.close();
		}
	}
	/***************************************SINR************************************/
	public void SINR() {
		//���������������
		String TTI;
		Double LN6DB=0.0;
		Double BN6L3DB=0.0;
		Double B3L20DB=0.0;
		Double B20DB=0.0;
		int num=0;
		String sql="Select Top 1 * From SNRCount Order by TTI Desc";//�ٴ�SNRCount�е�����ӵ�����	
		String []paras=null;//������ʾ���е�Bbu  
		BBU_sql sqlh=null;
		try {
			sqlh=new BBU_sql();
			ResultSet rs=sqlh.search(sql, paras);
			while(rs.next())					
			{
					TTI=rs.getString(1);//TTI
					LN6DB=Double.parseDouble(rs.getString(2));//Ƶ��Ч��
					BN6L3DB=Double.parseDouble(rs.getString(3));//Ƶ��Ч��
					B3L20DB=Double.parseDouble(rs.getString(4));//Ƶ��Ч��
					B20DB=Double.parseDouble(rs.getString(5));//Ƶ��Ч��
			}
			DefaultPieDataset dataset = new DefaultPieDataset();  
				dataset.setValue("LN6DB",LN6DB);  
				dataset.setValue("BN6L3DB",BN6L3DB);
				dataset.setValue("B3L20DB",B3L20DB);
				dataset.setValue("B20DB",B20DB);

			pic_pie pic_pie_module=new pic_pie("SINR",dataset);
			panel_pic2 =pic_pie_module.getChartPanel();
			panel_chart_2_change.removeAll();
			panel_chart_2_change.add(panel_pic2, BorderLayout.CENTER);
			panel_chart_2_change.updateUI();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			//�ر�
			sqlh.close();
		}
	}
	/***************************************����BBUƵ��Ч��************************************/
	public void Efficiency_BBU() {
		//���������������
		String [] BBU_ID=new String[15];//��ʱ��ֻ����ʾ���ǰ15��RRU������������ͼ��̫��������ͼ��ʾ����
		Double []BBU_Efficiency=new Double[15];
		int num=0;
		String sql="select * from Bbu where 1=?";//�ٴ�Bbu�е�����ӵ�����	
		String []paras={"1"};//������ʾ���е�Bbu  
		BBU_sql sqlh=null;
		try {
			sqlh=new BBU_sql();
			ResultSet rs=sqlh.search(sql, paras);
			while(rs.next())					
			{
				if(num<15)
				{
					BBU_ID[num]=rs.getString(1);//ID
					if (rs.getString(15).equals("0.0"))
					{
						BBU_Efficiency[num]=0.0;//������
					}
					else
					{
						BBU_Efficiency[num]=Double.parseDouble(rs.getString(14));//Ƶ��Ч��
					}
					
					num=num+1;//num:0-14��ʾ����˼�������
				}
			}
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < num; i++) {
				dataset.addValue(BBU_Efficiency[i], "BBU", "BBU"+BBU_ID[i]);  
			}
			pic_column2 pic_column_module=new pic_column2("����BBUƵ��Ч��","BBU","Ƶ��Ч��",dataset);
			panel_pic3 =pic_column_module.getChartPanel();
			
			panel_chart_3_change.removeAll();
			panel_chart_3_change.add(panel_pic3, BorderLayout.CENTER);
			panel_chart_3_change.updateUI();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			//�ر�
			sqlh.close();
		}	
	}
	/***************************************ϵͳƵ��Ч��************************************/
	public void Efficiency_TTI() {
		//��ȷ��Efficiency�����ж��ٸ�TTI
		//��Ҫ�������ݿ�
		int TTI_number=0;
		String sql1="exec RowNum ?";
		String []paras1={"Efficiency"};
		BBU_sql sqlh=null;
		try {
			sqlh=new BBU_sql();
			ResultSet TTI_num=sqlh.search(sql1, paras1);
			TTI_num.next();
			TTI_number=TTI_num.getInt(1);//TTI_numberȷ��Efficiency�����ж��ٸ�TTI
		} catch (Exception e) {
			// TODO: handle exception
		}
		//���������������
		int [] TTI=new int[TTI_number];
		Double []TTI_Efficiency=new Double[TTI_number];
		int num=0;//0-TTI_number
		String sql="select * from Efficiency where 1=?";//�ٴ�Last5PercentRate�е�����ӵ�����	
		String []paras={"1"};//������ʾ���е�Rru  
		BBU_sql sqlh2=null;
		try {
			sqlh2=new BBU_sql();
			ResultSet rs=sqlh2.search(sql, paras);
			while(rs.next())					
			{

				TTI[num]=Integer.parseInt(rs.getString(1));//TTI
				if (rs.getString(2).equals("0.0"))
					{
					TTI_Efficiency[num]=0.0;//������
					}
				else
				{
					TTI_Efficiency[num]=Double.parseDouble(rs.getString(2));//TTI��Ƶ��Ч��	
				}				
				num=num+1;//num:��ʾ����˼�������
			}
			 DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();  
			for (int i = 0; i <num; i++) {
				int temp=TTI[i];
				defaultdataset.addValue(TTI_Efficiency[i],"TTI",String.valueOf(temp)); 
			}
			pic_line pic_line_module=new pic_line("ϵͳƵ��Ч��","TTI","Ƶ��Ч��",defaultdataset);
			panel_pic3 =pic_line_module.getChartPanel();
			
			panel_chart_3_change.removeAll();
			panel_chart_3_change.add(panel_pic3, BorderLayout.CENTER);
			panel_chart_3_change.updateUI();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			//�ر�
			sqlh.close();
		}
	}
	/***************************************����BBU�ܺ�************************************/
	public void ConsumeSum_BBU() {
		//���������������
		String [] BBU_ID=new String[15];//��ʱ��ֻ����ʾ���ǰ15��RRU������������ͼ��̫��������ͼ��ʾ����
		Double []BBU_Consume=new Double[15];
		int num=0;
		String sql="select * from Bbu where 1=?";//�ٴ�Bbu�е�����ӵ�����	
		String []paras={"1"};//������ʾ���е�Bbu  
		BBU_sql sqlh=null;
		try {
			sqlh=new BBU_sql();
			ResultSet rs=sqlh.search(sql, paras);
			while(rs.next())					
			{
				if(num<15)
				{
					BBU_ID[num]=rs.getString(1);//ID
					if (rs.getString(15).equals("0.0"))
					{
						BBU_Consume[num]=0.0;//������
					}
					else
					{
						BBU_Consume[num]=Double.parseDouble(rs.getString(16));//�ܺ�
					}
					
					num=num+1;//num:0-14��ʾ����˼�������
				}
			}
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < num; i++) {
				dataset.addValue(BBU_Consume[i], "BBU", "BBU"+BBU_ID[i]);  
			}
			pic_column3 pic_column_module=new pic_column3("����BBU�ܺ�","BBU","�ܺ�",dataset);
			panel_pic4 =pic_column_module.getChartPanel();
			
			panel_chart_4_change.removeAll();
			panel_chart_4_change.add(panel_pic4, BorderLayout.CENTER);
			panel_chart_4_change.updateUI();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			//�ر�
			sqlh.close();
		}	
	}
	/***************************************ϵͳ�ܺ�************************************/
	public void ConsumeSum_TTI() {
		//��ȷ��ConsumeSum�����ж��ٸ�TTI
		//��Ҫ�������ݿ�
		int TTI_number=0;
		String sql1="exec RowNum ?";
		String []paras1={"ConsumeSum"};
		BBU_sql sqlh=null;
		try {
			sqlh=new BBU_sql();
			ResultSet TTI_num=sqlh.search(sql1, paras1);
			TTI_num.next();
			TTI_number=TTI_num.getInt(1);//TTI_numberȷ��Efficiency�����ж��ٸ�TTI
		} catch (Exception e) {
			// TODO: handle exception
		}
		//���������������
		int [] TTI=new int[TTI_number];
		Double []TTI_ConsumeSum=new Double[TTI_number];
		int num=0;//0-TTI_number
		String sql="select * from ConsumeSum where 1=?";//�ٴ�ConsumeSum�е�����ӵ�����	
		String []paras={"1"};//������ʾ���е�Rru  
		BBU_sql sqlh2=null;
		try {
			sqlh2=new BBU_sql();
			ResultSet rs=sqlh2.search(sql, paras);
			while(rs.next())					
			{

				TTI[num]=Integer.parseInt(rs.getString(1));//TTI
				if (rs.getString(2).equals("0.0"))
					{
					TTI_ConsumeSum[num]=0.0;//������
					}
				else
				{
					TTI_ConsumeSum[num]=Double.parseDouble(rs.getString(2));//TTI��Ƶ��Ч��	
				}				
				num=num+1;//num:��ʾ����˼�������
			}
			 DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();  
			for (int i = 0; i <num; i++) {
				int temp=TTI[i];
				defaultdataset.addValue(TTI_ConsumeSum[i],"TTI",String.valueOf(temp)); 
			}
			pic_line pic_line_module=new pic_line("ϵͳ�ܺ�","TTI","�ܺ�",defaultdataset);
			panel_pic4 =pic_line_module.getChartPanel();
			
			panel_chart_4_change.removeAll();
			panel_chart_4_change.add(panel_pic4, BorderLayout.CENTER);
			panel_chart_4_change.updateUI();
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally
		{
			//�ر�
			sqlh.close();
		}
	}
}
