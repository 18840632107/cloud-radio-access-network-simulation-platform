/*
 * ������run1
 * ���ܣ������������ý���
 */
package ui.running;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;

import org.apache.poi.hssf.record.aggregates.ValueRecordsAggregate.MyIterator;

import ui.Add_bbu_rru_ue.Bbu_table_module;
import ui.Add_bbu_rru_ue.UE_table_module1;
import ui.Add_bbu_rru_ue.UE_table_module2;
import ui.CRAN_excel.ExcelOperate;
import ui.Share_bag.*;

public class run1 extends JDialog implements ActionListener{
	String path="image"+File.separator+"running"+File.separator+"running.png";
	Image image=new ImageIcon(path).getImage(); 
	private final JPanel contentPanel = new BackgroundPanel(image);
	JSplitPane splitPane;
	private JTextField textField_4,textField_5,textField_6,textField_7,
	textField_14,textField_15,textField_16,textField_17;
	JPanel panel,panel_1,panel_2,panel_3,panel_4,panel_5;
	JPanel panel_14_3_1,panel_14_3_2,panel_14_3_3,panel_14_3_4;
	JLabel label,label_1,label_2,label_3,label_4,label_5,label_6,label_7,label_8,label_9,label_10,label_11;
	private JPanel panel_6,panel_7,panel_8,panel_9,panel_10,panel_11,panel_12,panel_13,panel_14,panel_15,panel_16,
	panel_17,panel_18,panel_19,panel_20,panel_21,panel_22,panel_23,panel_24,panel_25,
	panel_26,pl6,pl7,pl8,pl9,pl10,pl1,pl2;
	JPanel Panel_South;
	CardLayout cl,cl1,cl2,clx;
	ActionListener ActionListener1,ActionListener2,ActionListener3,ActionListener4,ActionListener5,ActionListener6,
	ActionListener7,ActionListener8,ActionListener9,ActionListener_wireless1,ActionListener_wireless2
	,ActionListener_wireless3,ActionListener_wireless4,ActionListener_wireless5,ActionListener10;
	ActionListener ActionListener_RR,ActionListener_MaxCI,ActionListener_PF;
	JTextField jtk1,jtk2;
	WirelessLinkModel k_table;
	JRadioButton jr1,jr2,jr3,jr4,jr5,jr6,jr8;//��ѡ��
	ButtonGroup bg;
	JButton button_wireless1,button_wireless2,button_wireless3,button_wireless4,button_wireless5;
	JButton button_RR,button_MaxCI,button_PF;
	JPanel panel_14_1,panel_14_1_1,panel_14_2,panel_14_3,panel_14_4,panel_14_5,panel_14_6,panel_14_7,panel_14_8;
	JPanel panel_14_9,panel_14_10,panel_14_11;
	private JTextField textField_8,textField_9,textField_10,textField_11,textField_12;
	private JPanel panel_27,panel_28,panel_29,panel_30,panel_31,panel_32,panel_33,panel_34;
	JPanel panel_center,panel_center1,panel_center2;//
	private JButton button,button_1;
	private JPanel panel_35;
	private JTextField textField_13;
//	private JTextField textField_rru;
	private JTextField textField_f;
	JButton jb0,jb1,jb2;
	JButton jbf1,jbf2,jbf3;
	JButton jbHata231,jbHata231change;
	JButton cancelButton;
	JButton jb1_business_volume,jb2_business_volume;
	String Path_business_volume;
	JTextField jt_business_volume;
	JTextField textFieldv1,textFieldv2,textFieldM,textFieldS,textFieldDa,textFieldDb,textFieldVaMax,textFieldVbMin;
	JTextField textField1,textField2,textFieldT;//�ƶ���ģ��-ȫ���ģ��-�ٶȾ���ֲ�ʱ�������С�ٶ�,�����˶�ʱ��
	JTextField textField_BbuId,textField_BbuPoolId,textField_BandWidth,textField_BandCenter,
	textField_AllRes,textField_newf;
	JPanel panel_56;
	Bbu_table_module sql_allnum_model;
	SystemBandResModel f_table;
	int bbupool_num_total,bbu_num_total,ue_num_total,rru_num_total,LinkCircle_num_total;
	JComboBox jcb1,jcb2,jcb4,jcb5,jcb6,jcb7,jcb8,jcbid,jcbf;//�����б�
	public static JComboBox jcb9;
	static JComboBox jcb10;
	JComboBox jcb11;
	UEModifyModel ue_table,ue_table_judge,maxnum_model;
	String []jg1={"ȫ���ģ��","�������ģ��"};
	String []jg2={"��Ծ","����Ծ"};
	String []jg4={"���ɿռ�ģ��","����+˥��","Hata231","Hata231����"};
	String []jg8={"����"};
	String []jg5={"��ѯ","����ظɱ�","������ƽ"};//"RR","Max C/I","PF"
	String []jg6={"�Ǽȶ�ҵ����","�ȶ�ҵ����"};//"VoIP/��VoIP","�Զ���"//String []jg7={"Ԥ��ҵ����","����"};
	String []jg9={"��ͨ����","�ܼ�����"};
	String []jg10={"150MHz-1000MHz","1500MHz-2000MHz"};
	String []jg11={"����Ƶ��","�ǹ���Ƶ��"};
	Vector jgid=null;
	Vector jgf=null;
	JLabel lableBBUPool,lableBBU,lableRRU,lableUE,lableLink;
	int max_num;
	JButton jbvo_add,jbvo_change;
	JTextField jtvo_use,jtvo_v;
	UETrafficModel vo_table,vo_table_judge,judge_vo_table;
	WirelessLinkModel k_table_judge;
	private static String name = BBU_sql.name;
	private static String pswd = BBU_sql.pswd;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			run1 dialog = new run1();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**************************************
	 * ���ܣ��������ý���
	 ***************************************/
//	public run1() {
		public run1(Frame owner,String title,boolean modal) {
			super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
		setBounds(280, 100, 830, 500);
/***************************************�ϰ벿�֣�������************************************/
		//���ô�������
		setTitle("������������");
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
				label = new JLabel("������������");
				label.setFont(MyTools.f1);
				panel_title.add(label);
				panel.add(panel_title, BorderLayout.WEST);
			}
			JPanel panel_1 = new JPanel();
			panel_1.setOpaque(false);
			panel.add(panel_1, BorderLayout.EAST);
			panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			//BBU�ظ���
			String path_BBUPool="image"+File.separator+"public"+File.separator+"bbu�ظ�����ť.png";
			Icon icon_BBUPool=new ImageIcon(path_BBUPool);
			JLabel lblBbu_1 = new JLabel(icon_BBUPool);//����������������ʱ������bbupool_num
			lblBbu_1.setPreferredSize(new Dimension(icon_BBUPool.getIconWidth(), icon_BBUPool.getIconHeight()));
			panel_1.add(lblBbu_1);
			
			//BBU�ظ���
			String sql="exec RowNum ?";
			String []paras={"BbuPool"};
			sql_allnum_model=new Bbu_table_module();
			ResultSet Bbupool_allnum_sql=sql_allnum_model.total_num_sql(sql, paras);
			try {
				Bbupool_allnum_sql.next();
				bbupool_num_total=Bbupool_allnum_sql.getInt(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			int temp_bbupool_num=bbupool_num_total;
			String string_bbupool_num=Integer.toString(temp_bbupool_num);//���ݿ���bbupool����
			lableBBUPool = new JLabel(string_bbupool_num);
			lableBBUPool.setFont(MyTools.f15);
			panel_1.add(lableBBUPool);	

			JLabel lable_blank=new JLabel(" ");//�ո�
			panel_1.add(lable_blank);
			//BBU����
			String path_BBU="image"+File.separator+"public"+File.separator+"bbu������ť.png";
			Icon icon_BBU=new ImageIcon(path_BBU);
			JLabel lblBbu_2 = new JLabel(icon_BBU);//����������������ʱ������bbupool_num
			lblBbu_2.setPreferredSize(new Dimension(icon_BBU.getIconWidth(), icon_BBU.getIconHeight()));
			panel_1.add(lblBbu_2);
			
			String sql2="exec RowNum ?";
			String []paras2={"Bbu"};
			sql_allnum_model=new Bbu_table_module();
			ResultSet Bbu_allnum_sql=sql_allnum_model.total_num_sql(sql2, paras2);
			try {
				Bbu_allnum_sql.next();
				bbu_num_total=Bbu_allnum_sql.getInt(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			int temp_bbu_num=bbu_num_total;
			String string_bbu_num=Integer.toString(temp_bbu_num);//���ݿ���bbu����
			lableBBU = new JLabel(string_bbu_num);
			lableBBU.setFont(MyTools.f15);
			panel_1.add(lableBBU);

			JLabel lable_blank1=new JLabel(" ");//�ո�
			panel_1.add(lable_blank1);
			//RRU����
			String path_RRU="image"+File.separator+"public"+File.separator+"rru������ť.png";
			Icon icon_RRU=new ImageIcon(path_RRU);
			JLabel lblRru = new JLabel(icon_RRU);//����������������ʱ������bbupool_num
			lblRru.setPreferredSize(new Dimension(icon_RRU.getIconWidth(), icon_RRU.getIconHeight()));
			panel_1.add(lblRru);		
			
			String sql4="exec RowNum ?";
			String []paras4={"Rru"};
			sql_allnum_model=new Bbu_table_module();
			ResultSet Rru_allnum_sql=sql_allnum_model.total_num_sql(sql4, paras4);
			try {
				Rru_allnum_sql.next();
				rru_num_total=Rru_allnum_sql.getInt(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			int temp_rru_num=rru_num_total;
			String string_rru_num=Integer.toString(temp_rru_num);//���ݿ���rru����
			lableRRU = new JLabel(string_rru_num);
			lableRRU.setFont(MyTools.f15);
			panel_1.add(lableRRU);

			JLabel lable_blank2=new JLabel(" ");//�ո�
			panel_1.add(lable_blank2);
			//UE����
			String path_UE="image"+File.separator+"public"+File.separator+"ue������ť.png";
			Icon icon_UE=new ImageIcon(path_UE);
			JLabel lblUe = new JLabel(icon_UE);//����������������ʱ������bbupool_num
			lblUe.setPreferredSize(new Dimension(icon_UE.getIconWidth(), icon_UE.getIconHeight()));
			panel_1.add(lblUe);		
			
			String sql3="exec RowNum ?";
			String []paras3={"Ue"};
			sql_allnum_model=new Bbu_table_module();
			ResultSet Ue_allnum_sql=sql_allnum_model.total_num_sql(sql3, paras3);
			try {
				Ue_allnum_sql.next();
				ue_num_total=Ue_allnum_sql.getInt(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			int temp_ue_num=ue_num_total;
			String string_ue_num=Integer.toString(temp_ue_num);
			lableUE = new JLabel(string_ue_num);
			lableUE.setFont(MyTools.f15);
			panel_1.add(lableUE);

			JLabel lable_blank3=new JLabel(" ");//�ո�
			panel_1.add(lable_blank3);
			//������
			String path_link="image"+File.separator+"public"+File.separator+"��������ť.png";
			Icon icon_link=new ImageIcon(path_link);
			JLabel lblink = new JLabel(icon_link);//����������������ʱ������bbupool_num
			lblUe.setPreferredSize(new Dimension(icon_link.getIconWidth(), icon_link.getIconHeight()));
			panel_1.add(lblink);	
			
			String sql5="exec RowNum ?";
			String []paras5={"LinkCircle"};
			sql_allnum_model=new Bbu_table_module();
			ResultSet LinkCircle_allnum_sql=sql_allnum_model.total_num_sql(sql5, paras5);
			try {
				LinkCircle_allnum_sql.next();
				LinkCircle_num_total=LinkCircle_allnum_sql.getInt(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			int temp_LinkCircle_num=LinkCircle_num_total;
			String string_LinkCircle_num=Integer.toString(temp_LinkCircle_num);
			lableLink = new JLabel(string_LinkCircle_num);
			lableLink.setFont(MyTools.f15);
			panel_1.add(lableLink);
		}
		jr1=new JRadioButton();
		jr1.setOpaque(false);
		jr1.addActionListener(this);
		jr2=new JRadioButton();
		jr2.setOpaque(false);
		jr2.addActionListener(this);
		jr3=new JRadioButton();
		jr3.setOpaque(false);
		jr3.addActionListener(this);		
		jr4=new JRadioButton();
		jr4.setOpaque(false);
		jr4.addActionListener(this);
		jr5=new JRadioButton();
		jr5.setOpaque(false);
		jr5.addActionListener(this);
		jr6=new JRadioButton();
		jr6.setOpaque(false);
		jr6.addActionListener(this);
		jr8=new JRadioButton();
		jr8.setOpaque(false);
		jr8.addActionListener(this);
		bg=new ButtonGroup();
		bg.add(jr1);
		bg.add(jr2);
		bg.add(jr3);
		bg.add(jr4);
		bg.add(jr5);
		bg.add(jr6);
		bg.add(jr8);
/***************************************�°벿�֣������************************************/
		splitPane = new JSplitPane();
		splitPane.setBackground(Color.white);
		splitPane.setDividerLocation(380);
		contentPanel.add(splitPane, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
//		panel_2.add(panel_3);
		splitPane.setLeftComponent(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_3.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		
		panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_3.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
					

		button = new JButton("��");
		button.setFont(MyTools.f14);
		panel_7.add(button);		
		button_1 = new JButton("����");
		button_1.setFont(MyTools.f14);
		panel_7.add(button_1);		
		panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_3.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new GridLayout(8, 1, 0, 0));	
		panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_8.add(panel_12);
		panel_12.setLayout(new GridLayout(1, 2, 0, 0));	
		panel_17 = new JPanel();	
		panel_17.setOpaque(false);
		panel_17.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_12.add(panel_17);	
		panel_17.add(jr1);
		label_3 = new JLabel("�û��ƶ�ģ�ͣ�");
		label_3.setFont(MyTools.f15);
		panel_17.add(label_3);
		
		panel_18 = new JPanel();
		panel_18.setOpaque(false);
		panel_18.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_12.add(panel_18);		
		jcb1=new JComboBox<>(jg1);
		jcb1.setFont(MyTools.f14);
		jcb1.setBackground(Color.white);
		jcb1.addActionListener(this);//�ƶ�ģ��
		jcb1.setPreferredSize(new Dimension(113,20));
		panel_18.add(jcb1);	
		panel_13 = new JPanel();
		panel_13.setOpaque(false);
		panel_8.add(panel_13);
		panel_13.setLayout(new GridLayout(1, 2, 0, 0));		
		panel_19 = new JPanel();
		panel_19.setOpaque(false);
		panel_19.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_13.add(panel_19);	
		panel_19.add(jr2);
		label_4 = new JLabel("�û�״̬��");
		label_4.setFont(MyTools.f15);
		panel_19.add(label_4);		
		panel_20 = new JPanel();
		panel_20.setOpaque(false);
		panel_20.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_13.add(panel_20);
		
		textField_13 = new JTextField();
		textField_13.setText("��Ծ");
		textField_13.setFont(MyTools.f15);
		panel_20.add(textField_13);
		textField_13.setColumns(8);
		panel_14 = new JPanel();
		panel_14.setOpaque(false);
		panel_8.add(panel_14);
		panel_14.setLayout(new GridLayout(1, 2, 0, 0));		
		panel_21 = new JPanel();
		panel_21.setOpaque(false);
		panel_21.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_21.add(jr3);
		panel_14.add(panel_21);	
		label_5 = new JLabel("ϵͳƵ����Դ��");
		label_5.setFont(MyTools.f15);
		panel_21.add(label_5);	
		panel_22 = new JPanel();
		panel_22.setOpaque(false);
		panel_22.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_14.add(panel_22);		
		textField_f=new JTextField("Ƶ������");
		textField_f.setFont(MyTools.f15);
		textField_f.setColumns(8);
		panel_22.add(textField_f);
		panel_15 = new JPanel();
		panel_15.setOpaque(false);
		panel_8.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 2, 0, 0));		
		panel_23 = new JPanel();
		panel_23.setOpaque(false);
		panel_23.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_23.add(jr4);
		panel_15.add(panel_23);
		
		label_6 = new JLabel("������·ģ�ͣ�");
		label_6.setFont(MyTools.f15);
		panel_23.add(label_6);
		
		panel_24 = new JPanel();
		panel_24.setOpaque(false);
		panel_24.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_15.add(panel_24);
		
		jcb4=new JComboBox<>(jg4);
		jcb4.addActionListener(this);
		jcb4.setFont(MyTools.f14);
		jcb4.setBackground(Color.white);
		jcb4.setPreferredSize(new Dimension(113,20));
		panel_24.add(jcb4);
		
		panel_16 = new JPanel();
		panel_16.setOpaque(false);
		panel_8.add(panel_16);
		panel_16.setLayout(new GridLayout(1, 2, 0, 0));
		
		panel_25 = new JPanel();
		panel_25.setOpaque(false);
		panel_25.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_25.add(jr5);
		panel_16.add(panel_25);
		
		label_7 = new JLabel("��Դ����ģ�ͣ�");
		label_7.setFont(MyTools.f15);
		panel_25.add(label_7);
		
		panel_26 = new JPanel();
		panel_26.setOpaque(false);
		panel_26.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_16.add(panel_26);
		
		jcb5=new JComboBox<>(jg5);
		jcb5.setFont(MyTools.f14);
		jcb5.setBackground(Color.white);
		jcb5.setPreferredSize(new Dimension(113,20));
		panel_26.add(jcb5);
		
		panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_8.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 2, 0, 0));
		
		panel_27 = new JPanel();
		panel_27.setOpaque(false);
		panel_27.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_27.add(jr6);
		panel_9.add(panel_27);
		
		label_8 = new JLabel("ҵ����ģ��:");
		label_8.setFont(MyTools.f15);
		panel_27.add(label_8);
		
		panel_28 = new JPanel();
		panel_28.setOpaque(false);
		panel_28.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_9.add(panel_28);
		
		jcb6=new JComboBox<>(jg6);
		jcb6.addActionListener(this);
		jcb6.setFont(MyTools.f14);
		jcb6.setBackground(Color.white);
		jcb6.setPreferredSize(new Dimension(113,20));
		panel_28.add(jcb6);
		
//		panel_10 = new JPanel();
//		panel_10.setOpaque(false);
//		panel_8.add(panel_10);
//		panel_10.setLayout(new GridLayout(1, 2, 0, 0));
		
//		panel_29 = new JPanel();
//		panel_29.setOpaque(false);
//		panel_29.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
//		panel_29.add(jr7);
//		panel_10.add(panel_29);
		
//		label_9 = new JLabel("����ҵ����ģ�ͣ�");
//		label_9.setFont(MyTools.f15);
//		panel_29.add(label_9);
//		
//		panel_30 = new JPanel();
//		panel_30.setOpaque(false);
//		panel_30.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
//		panel_10.add(panel_30);
//		
//		jcb7=new JComboBox<>(jg7);
//		jcb7.setFont(MyTools.f14);
//		jcb7.setBackground(Color.white);
//		jcb7.setPreferredSize(new Dimension(113,20));
//		panel_30.add(jcb7);
////		
		panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_8.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 2, 0, 0));
		
		panel_31 = new JPanel();
		panel_31.setOpaque(false);
		panel_31.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_31.add(jr8);
		panel_11.add(panel_31);
		
		label_10 = new JLabel("������·ģ�ͣ�");
		label_10.setFont(MyTools.f15);
		panel_31.add(label_10);
		
		panel_32 = new JPanel();
		panel_32.setOpaque(false);
		panel_32.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_11.add(panel_32);
		
		jcb8=new JComboBox<>(jg8);
		jcb8.setFont(MyTools.f14);
		jcb8.setBackground(Color.white);
		jcb8.setPreferredSize(new Dimension(113,20));
		panel_32.add(jcb8);
		//�����ļ�
		panel_10= new JPanel();
		panel_10.setOpaque(false);
		panel_8.add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_29 = new JPanel();
		panel_29.setOpaque(false);
		panel_29.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_10.add(panel_29);		
		label_9 = new JLabel("�����ļ���");
		label_9.setFont(MyTools.f15);
		label_9.setFont(MyTools.f15);
		panel_29.add(label_9);
		panel_30 = new JPanel();
		panel_30.setOpaque(false);
		panel_30.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_10.add(panel_30);		
		textField_12 = new JTextField();
		panel_30.add(textField_12);
		textField_12.setColumns(23);
		
		panel_4 = new JPanel();
		panel_4.setOpaque(false);
//		panel_2.add(panel_4);
		splitPane.setRightComponent(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_4.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		/***************************************�°벿�֣��ұ���************************************/		
		cl=new CardLayout();
		panel_35 = new JPanel(cl);
		panel_35.setOpaque(false);
		panel_4.add(panel_35, BorderLayout.CENTER);
			
			panel_14_1 = new JPanel();//�ƶ���ģ��-ȫ���ģ��
			panel_14_1.setOpaque(false);
			
		
		
		panel_14_1_1 = new JPanel();//�ƶ���ģ��-�������ģ��
		panel_14_1_1.setOpaque(false);
		panel_14_4 = new JPanel();//�û�״̬
		panel_14_4.setOpaque(false);
		panel_14_5 = new JPanel();//Ƶ����Դ
		panel_14_5.setOpaque(false);
		panel_14_3 = new JPanel();//������·ģ�� Hata231
		panel_14_3.setOpaque(false);
		panel_14_3_1 = new JPanel();//������·ģ��:���ɿռ�ģ��
		panel_14_3_1.setOpaque(false);
		panel_14_3_2 = new JPanel();//������·ģ�ͣ�����+˥��
		panel_14_3_2.setOpaque(false);
		panel_14_3_3 = new JPanel();//������·ģ��:Hata231����
		panel_14_3_3.setOpaque(false);
		panel_14_3_4 = new JPanel();//������·ģ��:�Զ���ģ��
		panel_14_3_4.setOpaque(false);
		panel_14_6 = new JPanel();//��Դ����ģ��
		panel_14_6.setOpaque(false);
		panel_14_7 = new JPanel();//��Դ����ģ��
		panel_14_7.setOpaque(false);
		panel_14_8 = new JPanel();//��Դ����ģ��
		panel_14_8.setOpaque(false);
		panel_14_9 = new JPanel();//VoIP/��VoIP
		panel_14_9.setOpaque(false);
		panel_14_10 = new JPanel();//����ҵ����ģ��
		panel_14_10.setOpaque(false);
		// ��Ƭ���Ͳ���
		panel_35.add("1",panel_14_1);//�ƶ���ģ��-ȫ���ģ��
		panel_35.add("2",panel_14_1_1);//�ƶ���ģ��-�������ģ��
		panel_35.add("3",panel_14_3);//������·ģ��:Hata231
		panel_35.add("4",panel_14_3_1);//������·ģ��:���ɿռ�ģ��
		panel_35.add("5",panel_14_3_2);//������·ģ��:����+˥��
		panel_35.add("6",panel_14_3_3);//������·ģ��:Hata231����
		panel_35.add("7",panel_14_4);//�û�״̬
		panel_35.add("8",panel_14_5);//Ƶ������
		panel_35.add("9",panel_14_6);//RR
		panel_35.add("10",panel_14_7);//Max C/I
		panel_35.add("11",panel_14_8);//PF
		panel_35.add("12",panel_14_9);//�Ǽȶ�ҵ������VoIP�û�ռ��/��VoIP
		panel_35.add("13",panel_14_10);//�ȶ�ҵ����������ҵ����ģ��

	Panel_South = new JPanel();
	Panel_South.setOpaque(false);
	Panel_South.setLayout(new FlowLayout(FlowLayout.RIGHT));
	contentPanel.add(Panel_South, BorderLayout.SOUTH);		
	cancelButton = new JButton("�˳�");
	cancelButton.setFont(MyTools.f14);
	cancelButton.setActionCommand("�˳�");
	cancelButton.addActionListener(this);
	Panel_South.add(cancelButton);
	}
		/**************************************
		 * ���ܣ������ϸ�����ť�ļ�����Ӧ����
		 ***************************************/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		/***********�ƶ���ģ�ͣ�ȫ���ģ��/�������ģ��**********/
		if(arg0.getSource()==jr1)
		{
			//��Ч��
			useless();
			ActionListener1=new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO �Զ����ɵķ������
					
					if(arg0.getSource()==jcb1)
					{
						if(jcb1.getSelectedIndex()==0)//�ƶ���ģ��-ȫ���ģ��
						{
							RandomWalkModel();
						}
						if(jcb1.getSelectedIndex()==1)//�ƶ���ģ��-�������ģ��
						{
							PartRandomWalkModel();
						}
					}
				}
			};
			jcb1.addActionListener(ActionListener1);

		}
		/***********�û�״̬**********/
		else if(arg0.getSource()==jr2)
		{
			panel_14_4.removeAll();
			//��Ч��
			useless();	
			JLabel jl=new JLabel("��");
			jl.setFont(MyTools.f15);
			panel_14_4.add(jl);
			cl.show(panel_35,"7");  
			panel_35.validate(); 
		}
		/***********Ƶ������**********/
		else if(arg0.getSource()==jr3)
		{
			panel_14_5.removeAll();
			//��Ч��
			useless();
			
			panel_14_5.setLayout(new GridLayout(6, 2, 0, 0));
			{
				JPanel panel_55 = new JPanel();
				panel_55.setOpaque(false);
				panel_14_5.add(panel_55);
				
				JLabel label_23 = new JLabel("   �ܴ���");
				label_23.setFont(MyTools.f15);
				panel_55.add(label_23);
				
				textField_AllRes = new JTextField();
				panel_55.add(textField_AllRes);
				textField_AllRes.setColumns(8);
				textField_AllRes.setFont(MyTools.f15);
				
				panel_56 = new JPanel();
				panel_56.setOpaque(false);
				panel_14_5.add(panel_56);
				
				JLabel label_24 = new JLabel("   Ƶ���ţ�");
				label_24.setFont(MyTools.f15);
				panel_56.add(label_24);
				
				//������
				jgf=new Vector<>();
				jgf.add("��ӻ�ѡ��");
				String sql2="select * from SystemBandResModel where 1=?";//	
				String []paras2={"1"};//
				BBU_sql f_sql=new BBU_sql();
				ResultSet f_rs=f_sql.search(sql2, paras2);
				try {
					while(f_rs.next())
					{
						jgf.add(f_rs.getString(1));//ueȺidһ������Щ
					}
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}finally
				{
					//�ر�
					f_sql.close();
				}				
				jcbf=new JComboBox<>(jgf);
				jcbf.setFont(MyTools.f14);
				jcbf.setBackground(Color.white);
				jcbf.setPreferredSize(new Dimension(113,20));
				jcbf.setEditable(false);
				jcbf.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						if(e.getSource()==jcbf)
						{
							search_bandname();
						}
					}

				});
				panel_56.add(jcbf);
				
				JPanel panel_61 = new JPanel();
				panel_61.setOpaque(false);
				panel_14_5.add(panel_61);
				
				JLabel label_25 = new JLabel("����Ƶ�ʣ�");
				label_25.setFont(MyTools.f15);
				panel_61.add(label_25);
				
				textField_BandCenter = new JTextField();
				panel_61.add(textField_BandCenter);
				textField_BandCenter.setColumns(8);
				textField_BandCenter.setFont(MyTools.f15);
				
				JPanel panel_59 = new JPanel();
				panel_59.setOpaque(false);
				panel_14_5.add(panel_59);
				
				JLabel label_26 = new JLabel("Ƶ����ȣ�");
				label_26.setFont(MyTools.f15);
				panel_59.add(label_26);
				
				textField_BandWidth = new JTextField();
				panel_59.add(textField_BandWidth);
				textField_BandWidth.setColumns(8);
				textField_BandWidth.setFont(MyTools.f15);
				JPanel panel_58 = new JPanel();
				panel_58.setOpaque(false);
				panel_58.setLayout(new FlowLayout(FlowLayout.RIGHT));
				panel_14_5.add(panel_58);
				
				JLabel label_27 = new JLabel("�Ƿ񹫹�Ƶ����");
				label_27.setFont(MyTools.f15);
				panel_58.add(label_27);
				
				
				JPanel panel_57 = new JPanel();//�Ƿ񹫹�Ƶ��
				panel_57.setOpaque(false);
				panel_57.setLayout(new FlowLayout(FlowLayout.LEFT));
				panel_14_5.add(panel_57);
				jcb11=new JComboBox<>(jg11);
				jcb11.setFont(MyTools.f14);
				jcb11.setBackground(Color.white);
				jcb11.setPreferredSize(new Dimension(113,20));
				panel_57.add(jcb11);
				
				JPanel pl1=new JPanel();
				pl1.setOpaque(false);
				JLabel bbupoolid=new JLabel("Bbupool ID:");
				bbupoolid.setFont(MyTools.f15);
				pl1.add(bbupoolid);
				textField_BbuPoolId=new JTextField();
				textField_BbuPoolId.setColumns(8);
				textField_BbuPoolId.setFont(MyTools.f15);
				pl1.add(textField_BbuPoolId);
				panel_14_5.add(pl1);
				
				JPanel pl2=new JPanel();
				pl2.setOpaque(false);
				JLabel bbuid=new JLabel("Bbu ID:");
				bbuid.setFont(MyTools.f15);
				pl2.add(bbuid);
				textField_BbuId=new JTextField();
				textField_BbuId.setColumns(8);
				textField_BbuId.setFont(MyTools.f15);
				pl2.add(textField_BbuId);
				panel_14_5.add(pl2);
				
				JPanel pl3=new JPanel();
				pl3.setOpaque(false);
				pl3.setLayout(new FlowLayout(FlowLayout.RIGHT));
				JLabel attention=new JLabel("ע�⣺��ѡ�񹫹�Ƶ��");
				attention.setFont(MyTools.f15);
				pl3.add(attention);
				panel_14_5.add(pl3);
				JPanel pl4=new JPanel();
				pl4.setOpaque(false);
				pl4.setLayout(new FlowLayout(FlowLayout.LEFT));
				JLabel attention2=new JLabel("����ҪBBUPoolID,BBUID");
				attention2.setFont(MyTools.f15);
				pl4.add(attention2);
				panel_14_5.add(pl4);
				
				ActionListener7=new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						if(arg0.getSource()==jbf2)//�޸�
						{
							//System.out.println("ok");
							if(jcbf.getSelectedIndex()==0)//��ӻ�ѡ��
							{
								JOptionPane.showMessageDialog(null, "��ѡ��һ��Ƶ����");//�����Ի���
							}
							else
							{
								String public_band=String.valueOf(jcb11.getSelectedIndex());
								String sql="update SystemBandResModel set AllRes=?,PublicBand=?,BandCenter=?,BandWidth=?,BbuPoolId=?,BbuId=? where BandName=?";
								String []paras={textField_AllRes.getText(),public_band,textField_BandCenter.getText(),
										textField_BandWidth.getText(),textField_BbuPoolId.getText(),textField_BbuId.getText(),(String) jcbf.getSelectedItem()};
								f_table=new SystemBandResModel();
								f_table.add_delete_change_to_sql(sql, paras);
								search_bandname();
								JOptionPane.showMessageDialog(null, "�޸ĳɹ�");//�����Ի���
							}	
						}
						else if(arg0.getSource()==jbf1)//���
						{
							if(jcbf.getSelectedIndex()==0)//���Ƶ����
							{
								if(textField_newf.getText().equals(""))
								{
									JOptionPane.showMessageDialog(null, "����д��Ƶ����,ע�ⲻ���ظ���");//�����Ի���
								}
								else{
									//�õ������
									String sql0="exec ModelRowMax ?";
									String []paras0={"SystemBandResModel"};
									maxnum_model=new UEModifyModel();
									ResultSet maxnum_sql=maxnum_model.total_num_sql(sql0, paras0);
									try {
										maxnum_sql.next();
										max_num=maxnum_sql.getInt(1);
									} catch (Exception e) {
										// TODO: handle exception
									}
									int temp_max_num=max_num+1;
									String string_max_num=Integer.toString(temp_max_num);//���ݿ���bbu����
									String public_band=String.valueOf(jcb11.getSelectedIndex());
									String sql="insert into SystemBandResModel values(?,?,?,?,?,?,?,?,?,?,?)";
									String []paras={string_max_num,"1","1",textField_AllRes.getText(),"1",
											textField_newf.getText(),public_band,textField_BandCenter.getText(),
											textField_BandWidth.getText(),textField_BbuPoolId.getText(),textField_BbuId.getText(),};
									f_table=new SystemBandResModel();
									f_table.add_delete_change_to_sql(sql, paras);
									//ˢ��
									jcbf.addItem(textField_newf.getText());
									update_bandname();
									JOptionPane.showMessageDialog(null, "����ɹ�");//�����Ի���
								}		
							}
							else
							{
								JOptionPane.showMessageDialog(null, "��ѡ�����Ƶ���š�");//�����Ի���
							}	
						}
						else if(arg0.getSource()==jbf3)//ɾ��
						{
							if(jcbf.getSelectedIndex()==0)//ѡ��ȫ���û�ʱ
							{
								JOptionPane.showMessageDialog(null, "��ѡ��Ƶ����");//�����Ի���
							}
							else
							{
								String sql="delete from SystemBandResModel where BandName=?";
								String []paras={(String) jcbf.getSelectedItem()};
								String item=(String) jcbf.getSelectedItem();
								f_table=new SystemBandResModel();
								f_table.add_delete_change_to_sql(sql, paras);
								//ˢ��
								jcbf.removeItem(item);
								update_bandname();
							}
						}
					}
				};
				
				JPanel jp3=new JPanel();
				jp3.setOpaque(false);
				jp3.setLayout(new FlowLayout(FlowLayout.LEFT));
				jbf1=new JButton("���");
				jbf1.setFont(MyTools.f14);
				jbf1.addActionListener(ActionListener7);
				JLabel jl=new JLabel("��Ƶ���ţ�");
				jl.setFont(MyTools.f15);
				textField_newf=new JTextField();
				textField_newf.setColumns(5);
				jp3.add(jbf1);
				jp3.add(jl);
				jp3.add(textField_newf);
				panel_14_5.add(jp3);

				JPanel jp4=new JPanel();
				jp4.setOpaque(false);
				jp4.setLayout(new FlowLayout(FlowLayout.RIGHT));
				jbf2=new JButton("�޸�");
				jbf2.setFont(MyTools.f14);
				jbf2.addActionListener(ActionListener7);
				jbf3=new JButton("ɾ��");
				jbf3.setFont(MyTools.f14);
				jbf3.addActionListener(ActionListener7);
				jp4.add(jbf2);
				jp4.add(jbf3);
				panel_14_5.add(jp4);
			}
			cl.show(panel_35,"8");  
			panel_35.validate();
		}
		/***********������·ģ��**********/
		else if(arg0.getSource()==jr4)
		{
			WirelessLinkModel();

		}
		/***********��Դ����ģ��**********/
		if(arg0.getSource()==jr5)
		{
			//��Ч��
			useless();
			
			ActionListener3=new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO �Զ����ɵķ������
					//�ƶ�ģ��
					if(arg0.getSource()==jcb5)
					{
						panel_14_6.removeAll();
						panel_14_7.removeAll();
						panel_14_8.removeAll();
						if(jcb5.getSelectedIndex()==0)//RR
						{
							panel_14_6.setLayout(new BorderLayout());
							JLabel jl=new JLabel("<html>ѭ���ص���ÿ���û����ͱ����ȵĸ��ʶ���,�� K���û�<br>"
													+ ",һ��ѭ����ÿ���û��ͱ����ȵĸ��ʶ����� 1/K��Ҳ����<br>"
													+ "˵,ÿ���û�����ͬ�ĸ���ռ�з����ʱ϶�͹��ʡ�</html>",JLabel.CENTER);
							jl.setFont(MyTools.f15);
							panel_14_6.add(jl);
							//���ȷ����ť
							JPanel panelx=new JPanel();
							panelx.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
							panel_14_6.add(panelx,BorderLayout.SOUTH);
							ActionListener_RR=new ActionListener(){
								public void actionPerformed(ActionEvent arg0) {
									if(arg0.getSource()==button_RR)//ȷ��
									{
										String sql="update ResSchedualModel set ModelType=? where CaseNum=?";
										String []paras={"0","0"};
										BBU_sql sqlh=new BBU_sql();
										Boolean b; 
										b=sqlh.add_delete_change(sql, paras);
										if(b==true)
										{
											//����ɹ�
											JOptionPane.showMessageDialog(null,"����ɹ�","",JOptionPane. INFORMATION_MESSAGE);//�����Ի���
										}
									}
								}
							};
							button_RR=new JButton("ȷ��");
							button_RR.setFont(MyTools.f14);
							button_RR.addActionListener(ActionListener_RR);
							panelx.add(button_RR);
							cl.show(panel_35,"9");  
							panel_35.validate();
						}
						if(jcb5.getSelectedIndex()==1)//Max C/I
						{
							panel_14_7.setLayout(new BorderLayout());
							JLabel jl=new JLabel("<html>ֻ���ǵ����ŵ�������õ��û���ʹϵͳ��Դһֱ����Щ<br>"
									+ "�û�����,ʹ���ŵ������õ��û�һֱ�õ����񣬵ȵ���<br>"
									+ "�û��ŵ�����������ѡ���ŵ��������õ��û����䣬<br>"
									+ "ϵͳ��ԶΪ�ŵ�������õ��û�����</html>",JLabel.CENTER);
							jl.setFont(MyTools.f15);
							panel_14_7.add(jl);
							//���ȷ����ť
							JPanel panelx=new JPanel();
							panelx.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
							panel_14_7.add(panelx,BorderLayout.SOUTH);
							ActionListener_MaxCI=new ActionListener(){
								public void actionPerformed(ActionEvent arg0) {
									if(arg0.getSource()==button_MaxCI)//ȷ��
									{
										String sql="update ResSchedualModel set ModelType=? where CaseNum=?";
										String []paras={"1","0"};
										BBU_sql sqlh=new BBU_sql();
										Boolean b; 
										b=sqlh.add_delete_change(sql, paras);
										if(b==true)
										{
											//����ɹ�
											JOptionPane.showMessageDialog(null,"����ɹ�","",JOptionPane. INFORMATION_MESSAGE);//�����Ի���
										}
									}
								}
							};
							button_MaxCI=new JButton("ȷ��");
							button_MaxCI.setFont(MyTools.f14);
							button_MaxCI.addActionListener(ActionListener_MaxCI);
							panelx.add(button_MaxCI);
							cl.show(panel_35,"10");  
							panel_35.validate();
						}
						if(jcb5.getSelectedIndex()==2)//PF
						{
							panel_14_8.setLayout(new BorderLayout());
							JLabel jl=new JLabel("<html>ÿ���û�������һ����Ӧ�����ȼ�������ʱ�̣�<br>"
									+ "С�������ȼ������û����ܷ���</html>",JLabel.CENTER);
							jl.setFont(MyTools.f15);
							panel_14_8.add(jl);
							//���ȷ����ť
							JPanel panelx=new JPanel();
							panelx.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
							panel_14_8.add(panelx,BorderLayout.SOUTH);
							ActionListener_PF=new ActionListener(){
								public void actionPerformed(ActionEvent arg0) {
									if(arg0.getSource()==button_PF)//ȷ��
									{
										String sql="update ResSchedualModel set ModelType=? where CaseNum=?";
										String []paras={"2","0"};
										BBU_sql sqlh=new BBU_sql();
										Boolean b; 
										b=sqlh.add_delete_change(sql, paras);
										if(b==true)
										{
											//����ɹ�
											JOptionPane.showMessageDialog(null,"����ɹ�","",JOptionPane. INFORMATION_MESSAGE);//�����Ի���
										}
									}
								}
							};
							button_PF=new JButton("ȷ��");
							button_PF.setFont(MyTools.f14);
							button_PF.addActionListener(ActionListener_PF);
							panelx.add(button_PF);
							cl.show(panel_35,"11");  
							panel_35.validate();
						}
					}
				}
			};
			jcb5.addActionListener(ActionListener3);
		}
		/***********ҵ����ģ�ͣ��ȶ�ҵ�������Ǽȶ�ҵ����**********/
		if(arg0.getSource()==jr6)
		{
			//��Ч��
			useless();
			ActionListener4=new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO �Զ����ɵķ������
					if(arg0.getSource()==jcb6)
					{
						//����
						String sql1="select * from UETrafficModel where 1=?";//�ٴ�UE�е�����ӵ�����	
						String []paras1={"1"};//������ʾ�����Ѿ���ӵ�UE
						vo_table=new UETrafficModel();
						vo_table.table_search(sql1,paras1);
						
						panel_14_9.removeAll();
						panel_14_10.removeAll();
						//�û�ҵ����ģ��VoIP����VoIP
						if(jcb6.getSelectedIndex()==0)//�Ǽȶ�ҵ����
						{
							ActionListener9=new ActionListener(){
								public void actionPerformed(ActionEvent arg0) {
									if(arg0.getSource()==jbvo_change)//ȷ��
									{
												
										String sql="update UETrafficModel set VoIPRatio=?,[NonVoIP Velocity]=? where CaseNum=?";
										String []paras={jtvo_use.getText(),jtvo_v.getText(),"0"};
										vo_table=new UETrafficModel();
										vo_table.add_delete_change_to_sql(sql, paras);
										JOptionPane.showMessageDialog(null, "����ɹ�");//�����Ի���
									}
								}
							};
							//�Ǽȶ�ҵ������ResSchedualModel���е�ModelType=2��
							String sql="update BusinessModel set BusinessType=?";
							String []paras={"0"};
							judge_vo_table=new UETrafficModel();
							judge_vo_table.add_delete_change_to_sql(sql, paras);
							
							panel_14_9.setLayout(new GridLayout(6, 2, 0, 0));
							{
								JPanel jp_1=new JPanel();
								jp_1.setOpaque(false);
								JLabel jl1=new JLabel("   VoIP�û�ռ�ȣ�");
								jl1.setFont(MyTools.f15);
								jtvo_use=new JTextField();
								jtvo_use.setFont(MyTools.f15);
								jtvo_use.setColumns(8);
								String sql0="select * from UETrafficModel where 1=?";//�ٴ�UE�е�����ӵ�����		
								String []paras0={"1"};
								vo_table_judge=new UETrafficModel();
								boolean a=vo_table_judge.judge_search(sql0, paras0);
								if(a)
								{
									jtvo_use.setText((String) vo_table.getValueAt(0, 3));
								}
								else
								{
									jtvo_use.setText("");
								}
								jtvo_use.setColumns(7);
								jp_1.add(jl1);
								jp_1.add(jtvo_use);
								panel_14_9.add(jp_1);
							}
							{
								JPanel jp_1=new JPanel();
								jp_1.setOpaque(false);
								JLabel jl1=new JLabel("��VoIP������ʣ�");
								jl1.setFont(MyTools.f15);
								jtvo_v=new JTextField();
								jtvo_v.setFont(MyTools.f15);
								jtvo_v.setColumns(8);
								String sql2="select * from UETrafficModel where 1=?";//�ٴ�UE�е�����ӵ�����		
								String []paras2={"1"};
								vo_table_judge=new UETrafficModel();
								boolean a=vo_table_judge.judge_search(sql2, paras2);
								if(a)
								{
									jtvo_v.setText((String) vo_table.getValueAt(0, 4));
								}
								else
								{
									jtvo_v.setText("");
								}
								
								jtvo_v.setColumns(7);
								jp_1.add(jl1);
								jp_1.add(jtvo_v);
								panel_14_9.add(jp_1);
							}
							{
								JPanel jp_1=new JPanel();
								jp_1.setOpaque(false);
								jp_1.setLayout(new FlowLayout(FlowLayout.RIGHT));
								jbvo_change=new JButton("ȷ��");
								jbvo_change.setFont(MyTools.f14);
								jbvo_change.addActionListener(ActionListener9);
								jp_1.add(jbvo_change);
								panel_14_9.add(jp_1);
							}
							cl.show(panel_35,"12");  
							panel_35.validate();
							
						}
						else if(jcb6.getSelectedIndex()==1)//�ȶ�ҵ����
						{
							ActionListener10=new ActionListener(){
								public void actionPerformed(ActionEvent arg0) {
									if(arg0.getSource()==jb1_business_volume)//���
									{
										JFileChooser filechooser=new JFileChooser();
										filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // ֻ��ʾĿ¼
										//��ʾ�ļ�ѡ��Ի���
										int i=filechooser.showOpenDialog(getContentPane());//this.getContentPane()�������ǳ�ʼ��һ�����������������������һЩ�ؼ�
										//�ж��û��������Ƿ�Ϊ�򿪰�ť
										if(i==JFileChooser.APPROVE_OPTION)
										{
											//���ѡ�е��ļ�����
											File selectedFile=filechooser.getSelectedFile();
											//��ʾѡ���ļ���·��
											Path_business_volume=selectedFile.getAbsolutePath();
											jt_business_volume.setText(Path_business_volume);//BBU��textField		
										}
									}
									if(arg0.getSource()==jb2_business_volume)//ȷ�ϵ���Excel
									{
										if(jt_business_volume.getText().length()==0)
										{
											JOptionPane.showMessageDialog(null, "����ѡ���ļ�");
										}
										else
										{
											String sql="Delete EstBusiness";
											String []paras={};
											BBU_sql sqlh=new BBU_sql();
											Boolean b; 
											b=sqlh.add_delete_change(sql, paras);
											
											ExcelOperate excel=new ExcelOperate();
											try {
												excel.EstBusinessImport(Path_business_volume);
											} catch (Exception e1) {
												// TODO �Զ����ɵ� catch ��
												//e1.printStackTrace();
											}
										}
									}
								}
							};
							//�ȶ�ҵ������ResSchedualModel���е�ModelType=1��
							String sql="update BusinessModel set BusinessType=?";
							String []paras={"1"};
							judge_vo_table=new UETrafficModel();
							judge_vo_table.add_delete_change_to_sql(sql, paras);
							
							panel_14_10.setLayout(new BorderLayout());
							JPanel TopPanel=new JPanel();
							TopPanel.setLayout(new GridLayout(2, 1, 0, 0));
							TopPanel.setOpaque(false);
							panel_14_10.add(TopPanel,BorderLayout.NORTH);
							
							JPanel TopPanel1=new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
							TopPanel1.setOpaque(false);
							TopPanel.add(TopPanel1);
							JPanel TopPanel2=new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
							TopPanel2.setOpaque(false);
							TopPanel.add(TopPanel2);
							
							JLabel jl=new JLabel("ҵ����:");
							jl.setFont(MyTools.f15);
							TopPanel1.add(jl);
							jt_business_volume=new JTextField();
							jt_business_volume.setColumns(28);
							TopPanel1.add(jt_business_volume);
							jb1_business_volume=new JButton("���");
							jb1_business_volume.addActionListener(ActionListener10);
							jb1_business_volume.setFont(MyTools.f14);
							TopPanel2.add(jb1_business_volume);
							jb2_business_volume=new JButton("ȷ�ϵ���Excel");
							jb2_business_volume.addActionListener(ActionListener10);
							jb2_business_volume.setFont(MyTools.f14);
							TopPanel2.add(jb2_business_volume);
							
							cl.show(panel_35,"13");  
							panel_35.validate();
						}
					}
				}
			};
			jcb6.addActionListener(ActionListener4);
		}
//		if(arg0.getSource()==jr7)//����ҵ����ģ��
//		{
//
//			//��Ч��
//			useless();
//			
//			ActionListener5=new ActionListener(){
//				@Override
//				public void actionPerformed(ActionEvent arg0) {
//					// TODO �Զ����ɵķ������
//					if(arg0.getSource()==jcb7)
//					{
//						panel_14_11.removeAll();
//						if(jcb7.getSelectedIndex()==0)//Ԥ��ҵ����
//						{
//							JLabel jl=new JLabel("ҵ����");
//							jl.setFont(MyTools.f15);
//							panel_14_11.add(jl);
//							JTextField jt=new JTextField();
//							jt.setColumns(15);
//							panel_14_11.add(jt);
//							JButton jb=new JButton("����");
//							jb.setFont(MyTools.f14);
//							panel_14_11.add(jb);
//							cl.show(panel_35,"11");  
//							panel_35.validate();
//						}
//						if(jcb7.getSelectedIndex()==1)//����
//						{
//							panel_14_11.removeAll();//û����дpanel����Ϊû�й��ܣ�ֱ��д��remove���ܡ�
//							panel_14_11.repaint();
//							cl.show(panel_35,"15");  
//							panel_35.validate();
//						}
//					}
//				}
//			};
//			jcb7.addActionListener(ActionListener5);
//		}
		else if(arg0.getSource()==cancelButton)//ȡ��//////////////////////////////////////////////////////////
		{
			this.dispose();//�رնԻ���
		}

}

	protected void search_bandname() {
		// TODO �Զ����ɵķ������
		if(jcbf.getSelectedIndex()==0)//��ӻ�ѡ��ʱ
		{
			//�����ˢ��
			textField_AllRes.setText("");
			textField_BandCenter.setText("");
			textField_BandWidth.setText("");
			textField_BbuPoolId.setText("");
			textField_BbuId.setText("");
			JOptionPane.showMessageDialog(null, "��ӻ�ѡ��һ��Ƶ����");//�����Ի���
		}
		else//ѡ��Ƶ����
		{
			//�����ˢ��
			textField_AllRes.setText("");
			textField_BandCenter.setText("");
			textField_BandWidth.setText("");
			textField_BbuPoolId.setText("");
			textField_BbuId.setText("");
			String sql1="select * from SystemBandResModel where BandName=?";//�ٴ�UE�е�����ӵ�����		
			String selected=(String) jcbf.getSelectedItem();
			String []paras1={selected};//������ʾ�����Ѿ���ӵ�UE
			f_table=new SystemBandResModel();
			f_table.table_search(sql1,paras1);
//			f_table_judge=new SystemBandResModel();
//			boolean a=f_table_judge.judge_search(sql1, paras1);
			textField_AllRes.setText((String) f_table.getValueAt(0, 3));
			textField_BandCenter.setText((String) f_table.getValueAt(0, 7));
			textField_BandWidth.setText((String) f_table.getValueAt(0, 8));
			textField_BbuPoolId.setText((String) f_table.getValueAt(0, 9));
			textField_BbuId.setText((String) f_table.getValueAt(0, 10));
			if((boolean) f_table.getValueAt(0, 6).equals("0"))//����Ƶ��
			{
				jcb11.setSelectedIndex(0);
				
				jcb11.repaint();
			}
			else if((boolean) f_table.getValueAt(0, 6).equals("1"))//�ǹ���Ƶ��
			{
				jcb11.setSelectedIndex(1);
				jcb11.repaint();
			}	
		
		}
	}
	/***************************************����ҵ����ģ����textfield����************************************/
	public void update_bandname()
	{
		textField_AllRes.setText("");
		textField_BandCenter.setText("");
		textField_BandWidth.setText("");
		textField_BbuPoolId.setText("");
		textField_BbuId.setText("");
		textField_newf.setText("");
	}
	/***************************************ȥ���ؼ�������Ӧ����************************************/
	private void useless() {
		// TODO �Զ����ɵķ������
		jcb1.removeActionListener(ActionListener1);
		jcb4.removeActionListener(ActionListener2);
		jcb5.removeActionListener(ActionListener3);
		jcb6.removeActionListener(ActionListener4);
	}
/***************************************ȫ���ģ��************************************/
public void RandomWalkModel()
	{
		panel_14_1.removeAll();	
		panel_14_1.setLayout(new BorderLayout(0, 0));
		{
			JPanel pl1= new JPanel();
			pl1.setOpaque(false);
			pl1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_14_1.add(pl1, BorderLayout.NORTH);
			{
				JLabel lblid = new JLabel("�ٶȷֲ�����:");
				lblid.setFont(MyTools.f15);
				//������
				jgid=new Vector<>();
				jgid.add("���ȷֲ�");
				jgid.add("��̫�ֲ�");
				jcbid=new JComboBox<>(jgid);
				jcbid.setPreferredSize(new Dimension(113,20));
				jcbid.setFont(MyTools.f14);
				jcbid.setBackground(Color.white);
				jcbid.setEditable(false);
				
				panel_center= new JPanel();
				panel_center.setOpaque(false);
				panel_center.setLayout(new BorderLayout(0, 0));
				panel_center1= new JPanel();//��һ��panel_center1  
				panel_center1.setOpaque(false);
				panel_center1.setLayout(new GridLayout(6, 1, 0, 0));
				panel_center2 = new JPanel();//�ڶ���panel_center2
				panel_center2.setOpaque(false);
				panel_center2.setLayout(new GridLayout(6, 1, 0, 0));
				panel_14_1.add(panel_center,BorderLayout.CENTER);

				jcbid.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						if(e.getSource()==jcbid)
						{
							if(jcbid.getSelectedIndex()==0)//���ȷֲ�
							{
								
								panel_center.removeAll();
								panel_center1.removeAll();
								{
									JPanel pl2= new JPanel();
									pl2.setOpaque(false);
									pl2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
									{
										JLabel lbv=new JLabel("�ٶȷ�Χ��    ");
										lbv.setFont(MyTools.f15);
										pl2.add(lbv);
										
										textField1 = new JTextField();
										textField1.setFont(MyTools.f15);
										pl2.add(textField1);
										textField1.setColumns(8);
										
										JLabel label_18 = new JLabel("����");
										label_18.setFont(MyTools.f15);
										pl2.add(label_18);
										
										textField2 = new JTextField();
										textField2.setFont(MyTools.f15);
										pl2.add(textField2);
										textField2.setColumns(8);
									}
									panel_center1.add(pl2);
								}
								{//��Ϊpl1,pl2,pl3,pl4���Ѿ�д���ˣ�������pl3��pl4֮�����pl5,pl6һ��������
									JPanel pl5= new JPanel();
									pl5.setOpaque(false);
									pl5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
									
									{
										JLabel label_19 = new JLabel("������X���䣺");
										label_19.setFont(MyTools.f15);
										pl5.add(label_19);
										
										textField_14 = new JTextField();
										textField_14.setFont(MyTools.f15);
										pl5.add(textField_14);
										textField_14.setColumns(8);
										
										JLabel label_20 = new JLabel("����");
										label_20.setFont(MyTools.f15);
										pl5.add(label_20);
										
										textField_15 = new JTextField();
										textField_15.setFont(MyTools.f15);
										pl5.add(textField_15);
										textField_15.setColumns(8);
									}
									panel_center1.add(pl5);
								}
								{//��Ϊpl1,pl2,pl3,pl4���Ѿ�д���ˣ�������pl3��pl4֮�����pl5,pl6һ��������
									JPanel pl6= new JPanel();
									pl6.setOpaque(false);
									pl6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
									
									{
										JLabel label_19 = new JLabel("������Y���䣺");
										label_19.setFont(MyTools.f15);
										pl6.add(label_19);
										
										textField_16 = new JTextField();
										textField_16.setFont(MyTools.f15);
										pl6.add(textField_16);
										textField_16.setColumns(8);
										
										JLabel label_20 = new JLabel("����");
										label_20.setFont(MyTools.f15);
										pl6.add(label_20);
										
										textField_17 = new JTextField();
										textField_17.setFont(MyTools.f15);
										pl6.add(textField_17);
										textField_17.setColumns(8);
									}
									panel_center1.add(pl6);
								}
								panel_center.add(panel_center1, BorderLayout.CENTER);
								panel_center.updateUI();
							}
							if(jcbid.getSelectedIndex()==1)//��̫�ֲ�
							{
								panel_center.removeAll();
								panel_center2.removeAll();
								{
									JPanel pl2= new JPanel();
									pl2.setOpaque(false);
									pl2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
									
									{
										JLabel lbv=new JLabel("�ٶȾ�ֵ��      ");
										lbv.setFont(MyTools.f15);
										pl2.add(lbv);
										
										textFieldM = new JTextField();
										textFieldM.setFont(MyTools.f15);
										pl2.add(textFieldM);
										textFieldM.setColumns(8);
									}
									panel_center2.add(pl2);
								}
								{
									JPanel pl2= new JPanel();
									pl2.setOpaque(false);
									pl2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
									
									{
										JLabel label_19=new JLabel("�ٶȷ��      ");
										label_19.setFont(MyTools.f15);
										pl2.add(label_19);
										
										textFieldS = new JTextField();
										textFieldS.setFont(MyTools.f15);
										pl2.add(textFieldS);
										textFieldS.setColumns(8);
									}
									panel_center2.add(pl2);
								}
								{//��Ϊpl1,pl2,pl3,pl4���Ѿ�д���ˣ�������pl3��pl4֮�����pl5,pl6һ��������
									JPanel pl5= new JPanel();
									pl5.setOpaque(false);
									pl5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
									
									{
										JLabel label_19 = new JLabel("������X���䣺");
										label_19.setFont(MyTools.f15);
										pl5.add(label_19);
										
										textField_14 = new JTextField();
										textField_14.setFont(MyTools.f15);
										pl5.add(textField_14);
										textField_14.setColumns(8);
										
										JLabel label_20 = new JLabel("����");
										label_20.setFont(MyTools.f15);
										pl5.add(label_20);
										
										textField_15 = new JTextField();
										textField_15.setFont(MyTools.f15);
										pl5.add(textField_15);
										textField_15.setColumns(8);
									}
									panel_center2.add(pl5);
								}
								{//��Ϊpl1,pl2,pl3,pl4���Ѿ�д���ˣ�������pl3��pl4֮�����pl5,pl6һ��������
									JPanel pl6= new JPanel();
									pl6.setOpaque(false);
									pl6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
									
									{
										JLabel label_19 = new JLabel("������Y���䣺");
										label_19.setFont(MyTools.f15);
										pl6.add(label_19);
										
										textField_16 = new JTextField();
										textField_16.setFont(MyTools.f15);
										pl6.add(textField_16);
										textField_16.setColumns(8);
										
										JLabel label_20 = new JLabel("����");
										label_20.setFont(MyTools.f15);
										pl6.add(label_20);
										
										textField_17 = new JTextField();
										textField_17.setFont(MyTools.f15);
										pl6.add(textField_17);
										textField_17.setColumns(8);
									}
									panel_center2.add(pl6);
								}
								panel_center.add(panel_center2, BorderLayout.CENTER);
								panel_center.updateUI();
							}
						}
					}
				});
				pl1.add(lblid);
				pl1.add(jcbid);
			}
		}
		{
			JPanel pl4= new JPanel();
			pl4.setOpaque(false);
			pl4.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			panel_14_1.add(pl4, BorderLayout.SOUTH);								
			{
				ActionListener6=new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						if(arg0.getSource()==jb1)//ȷ��
						{
							if(jcbid.getSelectedIndex()==0)//ȫ���ģ��-���ȷֲ�
							{
								String sql="update UEModifyModel set MoveKind=?,Type=?,VelocityUpper=?,VelocityLower=?,vM=?,vS=?,vVaMax=?,vVbMin=?,vDa=?,vDb=?,XUpper=?,XLower=?,YUpper=?,"
										+ "YLower=? where CaseNum=?";
								String []paras={"0","0",textField1.getText(),textField2.getText(),null,null,null,null,null,null,textField_14.getText(),textField_15.getText(),
										textField_16.getText(),textField_17.getText(),"0"};
								ue_table=new UEModifyModel();
								Boolean b; 
								b=ue_table.add_delete_change_to_sql(sql, paras);
								if(b==true)
								{
									//����ɹ�
									JOptionPane.showMessageDialog(null,"����ɹ�","",JOptionPane. INFORMATION_MESSAGE);//�����Ի���
								}
							}
							if(jcbid.getSelectedIndex()==1)//ȫ���ģ��-��̫�ֲ�
							{
								String sql="update UEModifyModel set MoveKind=?,Type=?,VelocityUpper=?,VelocityLower=?,vM=?,vS=?,vVaMax=?,vVbMin=?,vDa=?,vDb=?,XUpper=?,XLower=?,YUpper=?,"
										+ "YLower=? where CaseNum=?";
								String []paras={"0","1",null,null,textFieldM.getText(),textFieldS.getText(),null,null,null,null,textField_14.getText(),textField_15.getText(),
										textField_16.getText(),textField_17.getText(),"0"};
								ue_table=new UEModifyModel();
								Boolean b; 
								b=ue_table.add_delete_change_to_sql(sql, paras);
								if(b==true)
								{
									//����ɹ�
									JOptionPane.showMessageDialog(null,"����ɹ�","",JOptionPane. INFORMATION_MESSAGE);//�����Ի���
								}
								
							}	
						}

					}
				};

				jb1=new JButton("ȷ��");
				jb1.setFont(MyTools.f14);
				jb1.addActionListener(ActionListener6);
				pl4.add(jb1);
			}
		}
		cl.show(panel_35,"1");  
		panel_35.validate(); 
	}
/***************************************�������ģ��************************************/
public void PartRandomWalkModel()
{
	panel_14_1_1.removeAll();
	panel_14_1_1.setLayout(new BorderLayout(0, 0));
	{
		JPanel pl1= new JPanel();
		pl1.setOpaque(false);
		pl1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_14_1_1.add(pl1, BorderLayout.NORTH);
		{
			JLabel lblid = new JLabel("�ٶȷֲ�����:");
			lblid.setFont(MyTools.f15);
			//������
			jgid=new Vector<>();
			jgid.add("���ȷֲ�");
			jgid.add("��̫�ֲ�");
			jcbid=new JComboBox<>(jgid);
			jcbid.setPreferredSize(new Dimension(113,20));
			jcbid.setFont(MyTools.f14);
			jcbid.setBackground(Color.white);
			jcbid.setEditable(false);
			
			panel_center= new JPanel();
			panel_center.setOpaque(false);
			panel_center.setLayout(new BorderLayout(0, 0));
			panel_center1= new JPanel();//��һ��panel_center1  
			panel_center1.setOpaque(false);
			panel_center1.setLayout(new GridLayout(6, 1, 0, 0));
			panel_center2 = new JPanel();//�ڶ���panel_center2
			panel_center2.setOpaque(false);
			panel_center2.setLayout(new GridLayout(6, 1, 0, 0));
			panel_14_1_1.add(panel_center,BorderLayout.CENTER);

			jcbid.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO �Զ����ɵķ������
					if(e.getSource()==jcbid)
					{
						if(jcbid.getSelectedIndex()==0)//���ȷֲ�
						{
							
							panel_center.removeAll();
							panel_center1.removeAll();
							{
								JPanel pl2= new JPanel();
								pl2.setOpaque(false);
								pl2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
								{
									JLabel lbv=new JLabel("�ٶȷ�Χ��    ");
									lbv.setFont(MyTools.f15);
									pl2.add(lbv);
									
									textField1 = new JTextField();
									textField1.setFont(MyTools.f15);
									pl2.add(textField1);
									textField1.setColumns(8);
									
									JLabel label_18 = new JLabel("����");
									label_18.setFont(MyTools.f15);
									pl2.add(label_18);
									
									textField2 = new JTextField();
									textField2.setFont(MyTools.f15);
									pl2.add(textField2);
									textField2.setColumns(8);
								}
								panel_center1.add(pl2);
							}
							{
								JPanel pl2= new JPanel();
								pl2.setOpaque(false);
								pl2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
								{
									JLabel lbv=new JLabel("�˶��Ƕȷ�Χ��    ");
									lbv.setFont(MyTools.f15);
									pl2.add(lbv);
									
									textFieldDa = new JTextField();
									textFieldDa.setFont(MyTools.f15);
									pl2.add(textFieldDa);
									textFieldDa.setColumns(8);
									
									JLabel label_18 = new JLabel("����");
									label_18.setFont(MyTools.f15);
									pl2.add(label_18);
									
									textFieldDb = new JTextField();
									textFieldDb.setFont(MyTools.f15);
									pl2.add(textFieldDb);
									textFieldDb.setColumns(8);
								}
								panel_center1.add(pl2);
							}
							{//��Ϊpl1,pl2,pl3,pl4���Ѿ�д���ˣ�������pl3��pl4֮�����pl5,pl6һ��������
								JPanel pl5= new JPanel();
								pl5.setOpaque(false);
								pl5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
								
								{
									JLabel label_19 = new JLabel("������X���䣺");
									label_19.setFont(MyTools.f15);
									pl5.add(label_19);
									
									textField_14 = new JTextField();
									textField_14.setFont(MyTools.f15);
									pl5.add(textField_14);
									textField_14.setColumns(8);
									
									JLabel label_20 = new JLabel("����");
									label_20.setFont(MyTools.f15);
									pl5.add(label_20);
									
									textField_15 = new JTextField();
									textField_15.setFont(MyTools.f15);
									pl5.add(textField_15);
									textField_15.setColumns(8);
								}
								panel_center1.add(pl5);
							}
							{//��Ϊpl1,pl2,pl3,pl4���Ѿ�д���ˣ�������pl3��pl4֮�����pl5,pl6һ��������
								JPanel pl6= new JPanel();
								pl6.setOpaque(false);
								pl6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
								
								{
									JLabel label_19 = new JLabel("������Y���䣺");
									label_19.setFont(MyTools.f15);
									pl6.add(label_19);
									
									textField_16 = new JTextField();
									textField_16.setFont(MyTools.f15);
									pl6.add(textField_16);
									textField_16.setColumns(8);
									
									JLabel label_20 = new JLabel("����");
									label_20.setFont(MyTools.f15);
									pl6.add(label_20);
									
									textField_17 = new JTextField();
									textField_17.setFont(MyTools.f15);
									pl6.add(textField_17);
									textField_17.setColumns(8);
								}
								panel_center1.add(pl6);
							}
							panel_center.add(panel_center1, BorderLayout.CENTER);
							panel_center.updateUI();
						}
						if(jcbid.getSelectedIndex()==1)//��̫�ֲ�
						{
							panel_center.removeAll();
							panel_center2.removeAll();
							{
								JPanel pl2= new JPanel();
								pl2.setOpaque(false);
								pl2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
								
								{
									JLabel lbv=new JLabel("�ٶȾ�ֵ��      ");
									lbv.setFont(MyTools.f15);
									pl2.add(lbv);
									
									textFieldM = new JTextField();
									textFieldM.setFont(MyTools.f15);
									pl2.add(textFieldM);
									textFieldM.setColumns(8);
								}
								panel_center2.add(pl2);
							}
							{
								JPanel pl2= new JPanel();
								pl2.setOpaque(false);
								pl2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
								
								{
									JLabel label_19=new JLabel("�ٶȷ��      ");
									label_19.setFont(MyTools.f15);
									pl2.add(label_19);
									
									textFieldS = new JTextField();
									textFieldS.setFont(MyTools.f15);
									pl2.add(textFieldS);
									textFieldS.setColumns(8);
								}
								panel_center2.add(pl2);
							}
							{
								JPanel pl2= new JPanel();
								pl2.setOpaque(false);
								pl2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
								{
									JLabel lbv=new JLabel("�ٶȷ�Χ���ƣ�  ");
									lbv.setFont(MyTools.f15);
									pl2.add(lbv);
									
									textFieldVaMax = new JTextField();
									textFieldVaMax.setFont(MyTools.f15);
									pl2.add(textFieldVaMax);
									textFieldVaMax.setColumns(8);
									
									JLabel label_18 = new JLabel("����");
									label_18.setFont(MyTools.f15);
									pl2.add(label_18);
									
									textFieldVbMin = new JTextField();
									textFieldVbMin.setFont(MyTools.f15);
									pl2.add(textFieldVbMin);
									textFieldVbMin.setColumns(8);
								}
								panel_center1.add(pl2);
							}
							{
								JPanel pl2= new JPanel();
								pl2.setOpaque(false);
								pl2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
								{
									JLabel lbv=new JLabel("�˶��Ƕȷ�Χ��    ");
									lbv.setFont(MyTools.f15);
									pl2.add(lbv);
									
									textFieldDa = new JTextField();
									textFieldDa.setFont(MyTools.f15);
									pl2.add(textFieldDa);
									textFieldDa.setColumns(8);
									
									JLabel label_18 = new JLabel("����");
									label_18.setFont(MyTools.f15);
									pl2.add(label_18);
									
									textFieldDb = new JTextField();
									textFieldDb.setFont(MyTools.f15);
									pl2.add(textFieldDb);
									textFieldDb.setColumns(8);
								}
								panel_center1.add(pl2);
							}
							{
								JPanel pl5= new JPanel();
								pl5.setOpaque(false);
								pl5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
								
								{
									JLabel label_19 = new JLabel("������X���䣺");
									label_19.setFont(MyTools.f15);
									pl5.add(label_19);
									
									textField_14 = new JTextField();
									textField_14.setFont(MyTools.f15);
									pl5.add(textField_14);
									textField_14.setColumns(8);
									
									JLabel label_20 = new JLabel("����");
									label_20.setFont(MyTools.f15);
									pl5.add(label_20);
									
									textField_15 = new JTextField();
									textField_15.setFont(MyTools.f15);
									pl5.add(textField_15);
									textField_15.setColumns(8);
								}
								panel_center2.add(pl5);
							}
							{//��Ϊpl1,pl2,pl3,pl4���Ѿ�д���ˣ�������pl3��pl4֮�����pl5,pl6һ��������
								JPanel pl6= new JPanel();
								pl6.setOpaque(false);
								pl6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
								
								{
									JLabel label_19 = new JLabel("������Y���䣺");
									label_19.setFont(MyTools.f15);
									pl6.add(label_19);
									
									textField_16 = new JTextField();
									textField_16.setFont(MyTools.f15);
									pl6.add(textField_16);
									textField_16.setColumns(8);
									
									JLabel label_20 = new JLabel("����");
									label_20.setFont(MyTools.f15);
									pl6.add(label_20);
									
									textField_17 = new JTextField();
									textField_17.setFont(MyTools.f15);
									pl6.add(textField_17);
									textField_17.setColumns(8);
								}
								panel_center2.add(pl6);
							}
							panel_center.add(panel_center2, BorderLayout.CENTER);
							panel_center.updateUI();
						}
					}
				}
			});
			pl1.add(lblid);
			pl1.add(jcbid);
		}
	}
	{
		JPanel pl4= new JPanel();
		pl4.setOpaque(false);
		pl4.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		panel_14_1_1.add(pl4, BorderLayout.SOUTH);								
		{
			ActionListener6=new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					if(arg0.getSource()==jb1)//ȷ��
					{
						if(jcbid.getSelectedIndex()==0)//�������ģ��-���ȷֲ�
						{
							String sql="update UEModifyModel set MoveKind=?,Type=?,VelocityUpper=?,VelocityLower=?,vM=?,vS=?,vVaMax=?,vVbMin=?,vDa=?,vDb=?,XUpper=?,XLower=?,YUpper=?,"
									+ "YLower=? where CaseNum=?";
							String []paras={"1","0",textField1.getText(),textField2.getText(),null,null,null,null,textFieldDa.getText(),textFieldDb.getText(),textField_14.getText(),textField_15.getText(),
									textField_16.getText(),textField_17.getText(),"0"};
							ue_table=new UEModifyModel();
							Boolean b; 
							b=ue_table.add_delete_change_to_sql(sql, paras);
							if(b==true)
							{
								//����ɹ�
								JOptionPane.showMessageDialog(null,"����ɹ�","",JOptionPane. INFORMATION_MESSAGE);//�����Ի���
							}
						}
						if(jcbid.getSelectedIndex()==1)//�������ģ��-��̫�ֲ�
						{
							String sql="update UEModifyModel set MoveKind=?,Type=?,VelocityUpper=?,VelocityLower=?,vM=?,vS=?,vVaMax=?,vVbMin=?,vDa=?,vDb=?,XUpper=?,XLower=?,YUpper=?,"
									+ "YLower=? where CaseNum=?";
							String []paras={"1","1",null,null,textFieldM.getText(),textFieldS.getText(),textFieldVaMax.getText(),textFieldVbMin.getText(),
									textFieldDa.getText(),textFieldDb.getText(),textField_14.getText(),textField_15.getText(),textField_16.getText(),textField_17.getText(),"0"};
							ue_table=new UEModifyModel();
							Boolean b; 
							b=ue_table.add_delete_change_to_sql(sql, paras);
							if(b==true)
							{
								//����ɹ�
								JOptionPane.showMessageDialog(null,"����ɹ�","",JOptionPane. INFORMATION_MESSAGE);//�����Ի���
							}
							
						}	
					}

				}
			};

			jb1=new JButton("ȷ��");
			jb1.setFont(MyTools.f14);
			jb1.addActionListener(ActionListener6);
			pl4.add(jb1);
		}
	}
	cl.show(panel_35,"2");  
	panel_35.validate(); 
}
/***************************************������·ģ��************************************/
public void WirelessLinkModel()
{
	panel_14_3.removeAll();
	panel_14_3_1.removeAll();//������·ģ��:���ɿռ�ģ��
	panel_14_3_2.removeAll();//������·ģ��:����+˥��
	panel_14_3_3.removeAll();//������·ģ��:Hata231����
	panel_14_3_4.removeAll();//������·ģ��:�Զ���ģ��
	//��Ч��
	useless();
	
	ActionListener2=new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO �Զ����ɵķ������
			//�ƶ�ģ��
			if(arg0.getSource()==jcb4)
			{
				if(jcb4.getSelectedIndex()==0)//���ɿռ�ģ��
				{
					panel_14_3_1.setLayout(new BorderLayout());
					JLabel jl=new JLabel("<html>���ɿռ�ģ��</html>",JLabel.CENTER);
					jl.setFont(MyTools.f15);
					panel_14_3_1.add(jl);
					//���ȷ����ť
					JPanel panelx=new JPanel();
					panelx.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
					panel_14_3_1.add(panelx,BorderLayout.SOUTH);
					ActionListener_wireless1=new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							if(arg0.getSource()==button_wireless1)//ȷ��
							{
								String sql="update WirelessLinkModel set ModelType=? where CaseNum=?";
								String []paras={"0","1"};
								BBU_sql sqlh=new BBU_sql();
								Boolean b; 
								b=sqlh.add_delete_change(sql, paras);
								if(b==true)
								{
									//����ɹ�
									JOptionPane.showMessageDialog(null,"����ɹ�","",JOptionPane. INFORMATION_MESSAGE);//�����Ի���
								}
							}
						}
					};
					button_wireless1=new JButton("ȷ��");
					button_wireless1.setFont(MyTools.f14);
					button_wireless1.addActionListener(ActionListener_wireless1);
					panelx.add(button_wireless1);
					cl.show(panel_35,"4");  
					panel_35.validate();
				}
				if(jcb4.getSelectedIndex()==1)//����+˥��
				{
					panel_14_3_2.setLayout(new BorderLayout());
					JLabel jl=new JLabel("<html>����+˥��</html>",JLabel.CENTER);
					jl.setFont(MyTools.f15);
					panel_14_3_2.add(jl);
					//���ȷ����ť
					JPanel panelx=new JPanel();
					panelx.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
					panel_14_3_2.add(panelx,BorderLayout.SOUTH);
					ActionListener_wireless2=new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							if(arg0.getSource()==button_wireless2)//ȷ��
							{
								String sql="update WirelessLinkModel set ModelType=? where CaseNum=?";
								String []paras={"1","1"};
								BBU_sql sqlh=new BBU_sql();
								Boolean b; 
								b=sqlh.add_delete_change(sql, paras);
								if(b==true)
								{
									//����ɹ�
									JOptionPane.showMessageDialog(null,"����ɹ�","",JOptionPane. INFORMATION_MESSAGE);//�����Ի���
								}
							}
						}
					};
					button_wireless2=new JButton("ȷ��");
					button_wireless2.setFont(MyTools.f14);
					button_wireless2.addActionListener(ActionListener_wireless2);
					panelx.add(button_wireless2);
					cl.show(panel_35,"5");  
					panel_35.validate();
				}
				if(jcb4.getSelectedIndex()==2)//������·ģ�� Hata231
				{
					panel_14_3.setLayout(new BorderLayout());
					JLabel jl=new JLabel("<html>ѭ���ص���ÿ���û����ͱ����ȵĸ��ʶ���,�� K���û�<br>"
							+ ",һ��ѭ����ÿ���û��ͱ����ȵĸ��ʶ����� 1/K��Ҳ����<br>"
							+ "˵,ÿ���û�����ͬ�ĸ���ռ�з����ʱ϶�͹��ʡ�</html>",JLabel.CENTER);
					jl.setFont(MyTools.f15);
					panel_14_3.add(jl);
					//���ȷ����ť
					JPanel panelx=new JPanel();
					panelx.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
					panel_14_3.add(panelx,BorderLayout.SOUTH);
					ActionListener_wireless3=new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							if(arg0.getSource()==button_wireless3)//ȷ��
							{
								String sql="update WirelessLinkModel set ModelType=? where CaseNum=?";
								String []paras={"2","1"};
								BBU_sql sqlh=new BBU_sql();
								Boolean b; 
								b=sqlh.add_delete_change(sql, paras);
								if(b==true)
								{
									//����ɹ�
									JOptionPane.showMessageDialog(null,"����ɹ�","",JOptionPane. INFORMATION_MESSAGE);//�����Ի���
								}
							}
						}
					};
					button_wireless3=new JButton("ȷ��");
					button_wireless3.setFont(MyTools.f14);
					button_wireless3.addActionListener(ActionListener_wireless3);
					panelx.add(button_wireless3);
					cl.show(panel_35,"3");  
					panel_35.validate();
				}
				if(jcb4.getSelectedIndex()==3)//������·ģ��:Hata231����
				{
					panel_14_3_3.setLayout(new BorderLayout());
					JLabel jl=new JLabel("<html>Hata231����</html>",JLabel.CENTER);
					jl.setFont(MyTools.f15);
					panel_14_3_3.add(jl);
					//���ȷ����ť
					JPanel panelx=new JPanel();
					panelx.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
					panel_14_3_3.add(panelx,BorderLayout.SOUTH);
					ActionListener_wireless4=new ActionListener(){
						public void actionPerformed(ActionEvent arg0) {
							if(arg0.getSource()==button_wireless4)//ȷ��
							{
								String sql="update WirelessLinkModel set ModelType=? where CaseNum=?";
								String []paras={"3","1"};
								BBU_sql sqlh=new BBU_sql();
								Boolean b; 
								b=sqlh.add_delete_change(sql, paras);
								if(b==true)
								{
									//����ɹ�
									JOptionPane.showMessageDialog(null,"����ɹ�","",JOptionPane. INFORMATION_MESSAGE);//�����Ի���
								}
							}
						}
					};
					button_wireless4=new JButton("ȷ��");
					button_wireless4.setFont(MyTools.f14);
					button_wireless4.addActionListener(ActionListener_wireless4);
					panelx.add(button_wireless4);
					cl.show(panel_35,"6");  
					panel_35.validate();
				}
			}
		}
	};
	jcb4.addActionListener(ActionListener2);
}
}