package ui.CRAN_excel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import ui.Share_bag.BBU_sql;

public class ExcelOperate {
	private static String name = BBU_sql.name;
	private static String pswd = BBU_sql.pswd;
	public static void LinkCircleImport(String PathLinkCircle) throws Exception {
		//------�������ݿ�-------
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			//������ƣ��������ݿ�Driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//System.out.println("���ݿ����ӳɹ�");
			conn = java.sql.DriverManager.getConnection(  
	                "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, pswd); //���ݿ�database--test,username--root��password--root 
			conn.setAutoCommit(false); 
			//Dictionary_Geology -- ������ 
			pst = (PreparedStatement) conn.prepareStatement("insert into Link (LinkId,LinkType,X1,Y1,Z1,X2,Y2,Z2,LongRadius,ShortRadius,AccesspointNum,Cost) values (?,?,?,?,?,?,?,?,?,?,?,?)" );
			
			
			File file = new File(PathLinkCircle);//"D:/game/new.xls"
			String[][] result = getData(file, 1);
			int rowLength = result.length;
			for (int i = 0; i < rowLength; i++) {
						//�������ݿ���ֶεĲ�ͬ�������޸�
						pst.setString(1, result[i][0]);
						pst.setString(2, result[i][1]);
						pst.setString(3, result[i][2]);
						pst.setString(4, result[i][3]);
						pst.setString(5, result[i][4]);
						pst.setString(6, result[i][5]);
						pst.setString(7, result[i][6]);
						pst.setString(8, result[i][7]);
						pst.setString(9, result[i][8]);
						pst.setString(10, result[i][9]);
						pst.setString(11, result[i][10]);
						pst.setString(12, result[i][11]);
						pst.addBatch(); //�����������
			}
			//���������ύ
			pst.executeBatch(); 
			conn.commit(); 
			//System.out.println("���ݿ�д��ɹ�"); 
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ɹ�!");
		} catch (Exception e) {
			//e.printStackTrace();
//			JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�","ERROR",JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�");
			return;// Ҳ����return null;���忴��ú����ķ������Ϳ���
		} finally{
			//�ر�PreparedStatement
			if(pst != null) {
				pst.close();
				pst = null;
			}
			//�ر�Connection
			if(conn != null) {
				conn.close();
				pst = null;
			}
		}
		
	}
	/**zt
	 * Link��������
	 */
	public static void LinkImport(String tableName,String PathLink) throws Exception {
		//------�������ݿ�-------
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			//������ƣ��������ݿ�Driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//System.out.println("���ݿ����ӳɹ�");
			conn = java.sql.DriverManager.getConnection(  
	                "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, pswd); //���ݿ�database--test,username--root��password--root 
			conn.setAutoCommit(false); 
			//Dictionary_Geology -- ������ 
			pst = (PreparedStatement) conn.prepareStatement("insert into "+tableName+"(LinkPathId,LinkEnd1,LinkEnd2,RealLength,LinkType,MaxTransRate,Attenuation,Delay,ErrorRate,Cost,LinkCircleId,FibersNum) values (?,?,?,?,?,?,?,?,?,?,?,?)" );
			
			
			File file = new File(PathLink);//"D:/game/new.xls"
			String[][] result = getData(file, 1);
			int rowLength = result.length;
			for (int i = 0; i < rowLength; i++) {
						//�������ݿ���ֶεĲ�ͬ�������޸�
						pst.setString(1, result[i][0]);
						pst.setString(2, result[i][1]);
						pst.setString(3, result[i][2]);
						pst.setString(4, result[i][3]);
						pst.setString(5, result[i][4]);
						pst.setString(6, result[i][5]);
						pst.setString(7, result[i][6]);
						pst.setString(8, result[i][7]);
						pst.setString(9, result[i][8]);
						pst.setString(10, result[i][9]);
						pst.setString(11, result[i][10]);
						pst.setString(12, result[i][11]);
						pst.addBatch(); //�����������
			}
			//���������ύ
			pst.executeBatch(); 
			conn.commit(); 
			//System.out.println("���ݿ�д��ɹ�"); 
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ɹ�!");
		} catch (Exception e) {
			//e.printStackTrace();
//			JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�","ERROR",JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�");
			return;// Ҳ����return null;���忴��ú����ķ������Ϳ���
		} finally{
			//�ر�PreparedStatement
			if(pst != null) {
				pst.close();
				pst = null;
			}
			//�ر�Connection
			if(conn != null) {
				conn.close();
				pst = null;
			}
		}
		
	}
	/**zt
	 * Bbu��������
	 */
	public static void BbuImport(String Pathbbu) throws Exception {
		//-----���ÿ�ʼʱ���Լ�ʱ���ʽ----
		//------�������ݿ�-------
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			//������ƣ��������ݿ�Driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//System.out.println("���ݿ����ӳɹ�");
			conn = java.sql.DriverManager.getConnection(  
	                "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, pswd); //���ݿ�database--test,username--root��password--root 
			conn.setAutoCommit(false); 
			//Dictionary_Geology -- ������ 
			pst = (PreparedStatement) conn.prepareStatement("insert into Bbu(BbuId, BbuPoolId,X,Y,Z,RruNum,SchedualRruMode,TransPower,EquipPower,IsActivity,Res,LinkId,Optime) values (?,?,?,?,?,?,?,?,?,?,?,?,?)" );
			
			
			File file = new File(Pathbbu);
			String[][] result = getData(file, 1);
			int rowLength = result.length;
			for (int i = 0; i < rowLength; i++) {
						//�������ݿ���ֶεĲ�ͬ�������޸�
						pst.setString(1, result[i][0]);//BbuId
						pst.setString(2, result[i][1]);//BbuPoolId
						pst.setString(3, result[i][2]);//x
						pst.setString(4, result[i][3]);//y
						pst.setString(5, result[i][4]);//z
						pst.setString(6, result[i][5]);//RruNum
						pst.setString(7, result[i][6]);//srm
						pst.setString(8, result[i][7]);//transpower
						pst.setString(9, result[i][8]);//ep
						pst.setString(10, result[i][9]);//ia
						pst.setString(11, result[i][10]);//res
						pst.setString(12, result[i][11]);//lk
						pst.setString(13, result[i][12]);//op
//						pst.setString(14, result[i][13]);//Eff
//						pst.setString(15, result[i][14]);//res
//						pst.setString(16, result[i][15]);//cons
						pst.addBatch(); //�����������
			}
			//���������ύ
			pst.executeBatch(); 
			conn.commit(); 
			//System.out.println("���ݿ�д��ɹ�"); 
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ɹ�!");
		} catch (Exception e) {
			//e.printStackTrace();
//			JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�","ERROR",JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ��");
			return;// Ҳ����return null;���忴��ú����ķ������Ϳ���
		} finally{
			//�ر�PreparedStatement
			if(pst != null) {
				pst.close();
				pst = null;
			}
			//�ر�Connection
			if(conn != null) {
				conn.close();
				pst = null;
			}
		}
		
//		//-----����ʱ��------
//		Long endTime = System.currentTimeMillis(); 
//		System.out.println("��ʱ��" + sdf.format(new Date(endTime - startTime))); 	
	}
	/**
	 * Bbu����������
	 */
	public static void BbuPoolImport(String PathBbuPool) throws Exception {
		//-----���ÿ�ʼʱ���Լ�ʱ���ʽ----
		//------�������ݿ�-------
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			//������ƣ��������ݿ�Driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("���ݿ����ӳɹ�");
			conn = java.sql.DriverManager.getConnection(  
	                "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, pswd); //���ݿ�database--test,username--root��password--root 
			conn.setAutoCommit(false); 
			//Dictionary_Geology -- ������ 
			pst = (PreparedStatement) conn.prepareStatement("INSERT INTO BbuPool(BbuPoolId,X,Y,Z,AllRes,ResLeft,DynamicEnengy,StaticEnengy,BbuPoolInfo)VALUES(?,?,?,?,?,?,?,?,?)" );
			File file = new File(PathBbuPool);//"D:/game/BbuPool.xls"
			String[][] result = getData(file, 1);
			int rowLength = result.length;
			for (int i = 0; i < rowLength; i++) {
						//�������ݿ���ֶεĲ�ͬ�������޸�
						pst.setString(1, result[i][0]);//BbuPoolId
						pst.setString(2, result[i][1]);//X
						pst.setString(3, result[i][2]);//Y
						pst.setString(4, result[i][3]);//Z
						pst.setString(5, result[i][4]);//AllRes
						pst.setString(6, result[i][5]);//ResLeft
						pst.setString(7, result[i][6]);//DynamicEnengy
						pst.setString(8, result[i][7]);//StaticEnengy
						pst.setString(9, result[i][8]);//BbuPoolInfo
						pst.addBatch(); //�����������
			}
			//���������ύ
			pst.executeBatch(); 
			conn.commit(); 
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ɹ�!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�");
		} finally{
			//�ر�PreparedStatement
			if(pst != null) {
				pst.close();
				pst = null;
			}
			//�ر�Connection
			if(conn != null) {
				conn.close();
				pst = null;
			}
		}
		
//		//-----����ʱ��------
//		Long endTime = System.currentTimeMillis(); 
//		System.out.println("��ʱ��" + sdf.format(new Date(endTime - startTime))); 	
	}
	/**
	 * Rru��������
	 */
	public static void RruImport(String Pathrru) throws Exception {
		//-----���ÿ�ʼʱ���Լ�ʱ���ʽ----
		//------�������ݿ�-------
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			//������ƣ��������ݿ�Driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//System.out.println("���ݿ����ӳɹ�");
			conn = java.sql.DriverManager.getConnection(  
	                "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, pswd); //���ݿ�database--test,username--root��password--root 
			conn.setAutoCommit(false); 
			//Dictionary_Geology -- ������ 
			pst = (PreparedStatement) conn.prepareStatement("INSERT INTO Rru(RruId,ServiceBbuId,Radius,X,Y,Z,RruTransPower,RruBandwidth,UeNum,IsActivity,CarrierFrequent,RruAntennaId,EquipPower,Optime,Rate)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );
			File file = new File(Pathrru);//"D:/game/Rru.xls"
			String[][] result = getData(file, 1);
			int rowLength = result.length;
			for (int i = 0; i < rowLength; i++) {
						//�������ݿ���ֶεĲ�ͬ�������޸�
						pst.setString(1, result[i][0]);//RruId
						pst.setString(2, result[i][1]);//ServiceBbuId
						pst.setString(3, result[i][2]);//Radius
						pst.setString(4, result[i][3]);//X
						pst.setString(5, result[i][4]);//Y
						pst.setString(6, result[i][5]);//Z
						pst.setString(7, result[i][6]);//RruTransPower
						pst.setString(8, result[i][7]);//RruBandWith
						pst.setString(9, result[i][8]);//UeNum
						pst.setString(10, result[i][9]);//IsActivity
						pst.setString(11, result[i][10]);//CarrierFrequent
						pst.setString(12, result[i][11]);//RruAntennaId
						pst.setString(13, result[i][12]);//EquipPower
						pst.setString(14, result[i][13]);//op
						pst.setString(15, result[i][14]);//rate
						pst.addBatch(); //�����������
			}
			//���������ύ
			pst.executeBatch(); 
			conn.commit(); 
			//System.out.println("���ݿ�д��ɹ�"); 
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ɹ�!");
		} catch (Exception e) {
			//e.printStackTrace();
//			JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�","ERROR",JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�");
			return;// Ҳ����return null;���忴��ú����ķ������Ϳ���
		} finally{
			//�ر�PreparedStatement
			if(pst != null) {
				pst.close();
				pst = null;
			}
			//�ر�Connection
			if(conn != null) {
				conn.close();
				pst = null;
			}
		}
//		
//		//-----����ʱ��------
//		Long endTime = System.currentTimeMillis(); 
//		System.out.println("��ʱ��" + sdf.format(new Date(endTime - startTime))); 	
	}
	
	/**
	 * Ue��������
	 */
	public static void UeImport(String Pathue) throws Exception {
		//-----���ÿ�ʼʱ���Լ�ʱ���ʽ----
		//------�������ݿ�-------
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			//������ƣ��������ݿ�Driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("���ݿ����ӳɹ�");
			conn = java.sql.DriverManager.getConnection(  
	                "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, pswd); //���ݿ�database--test,username--root��password--root 
			conn.setAutoCommit(false); 
			//Dictionary_Geology -- ������ 
			pst = (PreparedStatement) conn.prepareStatement("INSERT INTO Ue(UeId,UeType,X,Y,Z,ServiceRruId,RbNum,UeTransPower,UeAntennaId,IsActivity,UeGroupId,ModelType,SNR,TotalBit,TTISent,AverageRate)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );
			File file = new File(Pathue);//"D:/game/Ue.xls"
			String[][] result = getData(file, 1);
			int rowLength = result.length;
			for (int i = 0; i < rowLength; i++) {
						//�������ݿ���ֶεĲ�ͬ�������޸�
						pst.setString(1, result[i][0]);//UeId
						pst.setString(2, result[i][1]);//UeType
						pst.setString(3, result[i][2]);//X
						pst.setString(4, result[i][3]);//Y
						pst.setString(5, result[i][4]);//Z
						pst.setString(6, result[i][5]);//ServiceRruId
						pst.setString(7, result[i][6]);//RbNum
						pst.setString(8, result[i][7]);//UeTransPower
						pst.setString(9, result[i][8]);//UeAntennaId
						pst.setString(10, result[i][9]);//IsActivity
						pst.setString(11, result[i][10]);//UeGroupId
						pst.setString(12, result[i][11]);//ModelType
						pst.setString(13, result[i][12]);//SNR
						pst.setString(14, result[i][13]);//TotalBit
						pst.setString(15, result[i][14]);//TTIsent
						pst.setString(16, result[i][15]);//AverageRate
						pst.addBatch(); //�����������
						//System.out.println( result[i][10]);
						
			}
			//���������ύ
			pst.executeBatch(); 
			conn.commit(); 
			//System.out.println("���ݿ�д��ɹ�"); 
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ɹ�!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�","ERROR",JOptionPane.ERROR_MESSAGE);
			//JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�",,JOptionPane.ERROR_MESSAGE);
			return;// Ҳ����return null;���忴��ú����ķ������Ϳ���
		}finally{
			//�ر�PreparedStatement
			if(pst != null) {
				pst.close();
				pst = null;
			}
			//�ر�Connection
			if(conn != null) {
				conn.close();
				pst = null;
			}
		}
		
//		//-----����ʱ��------
//		Long endTime = System.currentTimeMillis(); 
//		System.out.println("��ʱ��" + sdf.format(new Date(endTime - startTime))); 	
	}
	/**
	 * ������������
	 */
	
	public static void EstBusinessImport(String PathEstBusiness) throws Exception {
		//-----���ÿ�ʼʱ���Լ�ʱ���ʽ----
		//------�������ݿ�-------
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			//������ƣ��������ݿ�Driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("���ݿ����ӳɹ�");
			conn = java.sql.DriverManager.getConnection(  
	                "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, pswd); //���ݿ�database--test,username--root��password--root 
			conn.setAutoCommit(false); 
			//Dictionary_Geology -- ������ 
			pst = (PreparedStatement) conn.prepareStatement("INSERT INTO EstBusiness(TTI,RruId,Business)VALUES(?,?,?)" );
			File file = new File(PathEstBusiness);//"D:/game/Antenna.xls"
			String[][] result = getData(file, 1);
			int rowLength = result.length;
			for (int i = 0; i < rowLength; i++) {
						//�������ݿ���ֶεĲ�ͬ�������޸�
						pst.setString(1, result[i][0]);//AntennaId
						pst.setString(2, result[i][1]);//AngleCoverages
						pst.setString(3, result[i][2]);//m
						pst.addBatch(); //�����������
						//System.out.println( result[i][10]);
			}
			//���������ύ
			pst.executeBatch(); 
			conn.commit(); 
			//System.out.println("���ݿ�д��ɹ�"); 
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ɹ�!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();			
			System.out.println("���ݿ�����ʧ��");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�","ERROR",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally{
			//�ر�PreparedStatement
			if(pst != null) {
				pst.close();
				pst = null;
			}
			//�ر�Connection
			if(conn != null) {
				conn.close();
				pst = null;
				
			}
		}
	}
	
	public static void AntennaImport(String PathAntenna) throws Exception {
		//-----���ÿ�ʼʱ���Լ�ʱ���ʽ----
		//------�������ݿ�-------
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			//������ƣ��������ݿ�Driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("���ݿ����ӳɹ�");
			conn = java.sql.DriverManager.getConnection(  
	                "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, pswd); //���ݿ�database--test,username--root��password--root 
			conn.setAutoCommit(false); 
			//Dictionary_Geology -- ������ 
			pst = (PreparedStatement) conn.prepareStatement("INSERT INTO Antenna(AntennaId,AngleCoverages,M,N,DisHori,DisVert,AntennaMode,VertGain,HoriGain,RadiationLobe,TiltAngle)VALUES(?,?,?,?,?,?,?,?,?,?,?)" );
			File file = new File(PathAntenna);//"D:/game/Antenna.xls"
			String[][] result = getData(file, 1);
			int rowLength = result.length;
			for (int i = 0; i < rowLength; i++) {
						//�������ݿ���ֶεĲ�ͬ�������޸�
						pst.setString(1, result[i][0]);//AntennaId
						pst.setString(2, result[i][1]);//AngleCoverages
						pst.setString(3, result[i][2]);//m
						pst.setString(4, result[i][3]);//n
						pst.setString(5, result[i][4]);//DisHori
						pst.setString(6, result[i][5]);//DisVert
						pst.setString(7, result[i][6]);//AntennaMode
						pst.setString(8, result[i][7]);//VertGain
						pst.setString(9, result[i][8]);//HoriGain
						pst.setString(10, result[i][9]);//RadiationLobe
						pst.setString(11, result[i][10]);//TiltAngle
						pst.addBatch(); //�����������
						//System.out.println( result[i][10]);
			}
			//���������ύ
			pst.executeBatch(); 
			conn.commit(); 
			//System.out.println("���ݿ�д��ɹ�"); 
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ɹ�!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();			
			System.out.println("���ݿ�����ʧ��");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�","ERROR",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally{
			//�ر�PreparedStatement
			if(pst != null) {
				pst.close();
				pst = null;
			}
			//�ر�Connection
			if(conn != null) {
				conn.close();
				pst = null;
				
			}
		}
	}
		/**
		 * case��������
		 */
		public static void caseImport(String Pathcase) throws Exception {
			//-----���ÿ�ʼʱ���Լ�ʱ���ʽ----
			//------�������ݿ�-------
			Connection conn = null;
			PreparedStatement pst = null;
			try {
				//������ƣ��������ݿ�Driver
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//System.out.println("���ݿ����ӳɹ�");
				conn = java.sql.DriverManager.getConnection(  
		                "jdbc:sqlserver://localhost:1433; DatabaseName=C-RAN", name, pswd); //���ݿ�database--test,username--root��password--root 
				conn.setAutoCommit(false); 
				//Dictionary_Geology -- ������ 
				pst = (PreparedStatement) conn.prepareStatement("INSERT INTO PCase(caseName,caseRemark)VALUES(?,?)" );
				File file = new File(Pathcase);//"D:/game/case.xls"
				if(file.exists())//����ļ�case.xlsʵ��������,��Ϊ��ע����û�������ʵ�����
				{
					String[][] result = getData(file, 1);
					int rowLength = result.length;
					for (int i = 0; i < rowLength; i++) {
								//�������ݿ���ֶεĲ�ͬ�������޸�
								pst.setString(1, result[i][0]);//caseName
								pst.setString(2, result[i][1]);//caseRemark
								pst.addBatch(); //�����������
					}
					//���������ύ
					pst.executeBatch(); 
					conn.commit(); 
					JOptionPane.showMessageDialog(null,"���ݿ⵼��ɹ�!");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"���ݿ⵼��ʧ�ܣ�ID�ظ�");
				return;// Ҳ����return null;���忴��ú����ķ������Ϳ���
			} finally{
				//�ر�PreparedStatement
				if(pst != null) {
					pst.close();
					pst = null;
				}
				//�ر�Connection
				if(conn != null) {
					conn.close();
					pst = null;
				}
			}	
	}
	/**
	 * ��ȡExcel�����ݣ���һά����洢����һ���и��е�ֵ����ά����洢���Ƕ��ٸ���
	 * 
	 * @param file
	 *            ��ȡ���ݵ�ԴExcel
	 * @param ignoreRows
	 *            ��ȡ���ݺ��Ե�������������ͷ����Ҫ���� ���Ե�����Ϊ1
	 * @return ������Excel�����ݵ�����
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	public static String[][] getData(File file, int ignoreRows)
			throws FileNotFoundException, IOException {
		List<String[]> result = new ArrayList<String[]>();
		int rowSize = 0;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				file));
		// ��HSSFWorkbook
		POIFSFileSystem fs = new POIFSFileSystem(in);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFCell cell = null;
		for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
			HSSFSheet st = wb.getSheetAt(sheetIndex);
			
			// ��һ��Ϊ���⣬��ȡ
			System.out.println("<=lastrow"+st.getLastRowNum()); 
			for (int rowIndex = ignoreRows; rowIndex <= st.getLastRowNum(); rowIndex++) {
				HSSFRow row = st.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				int tempRowSize = row.getPhysicalNumberOfCells();
				if (tempRowSize > rowSize) {
					rowSize = tempRowSize;
				}
				//System.out.println(rowSize); 
				String[] values = new String[rowSize];
				Arrays.fill(values, "");
				boolean hasValue = false;
				//System.out.println("rowindex"+rowIndex); 
				System.out.println("<lastcolumn"+row.getPhysicalNumberOfCells()); 
				for (short columnIndex = 0; columnIndex < row.getPhysicalNumberOfCells(); columnIndex++) {
					//System.out.println(columnIndex); 
					String value = "";
					cell = row.getCell(columnIndex);
					if (cell != null) {
						// ע�⣺һ��Ҫ��������������ܻ��������
						cell.setEncoding(HSSFCell.ENCODING_UTF_16);
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								Date date = cell.getDateCellValue();
								if (date != null) {
									value = new SimpleDateFormat("yyyy-MM-dd")
											.format(date);
								} else {
									value = "";
								}
							} else {
								value = new DecimalFormat("0").format(cell
										.getNumericCellValue());
							}
							break;
						case HSSFCell.CELL_TYPE_FORMULA:
							// ����ʱ���Ϊ��ʽ���ɵ���������ֵ
							if (!cell.getStringCellValue().equals("")) {
								value = cell.getStringCellValue();
							} else {
								value = cell.getNumericCellValue() + "";
							}
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = "";
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = (cell.getBooleanCellValue() == true ? "Y"
									: "N");
							break;
						default:
							value = "";
						}
					}
					if (columnIndex == 0 && value.trim().equals("")) {
						break;
					}
					values[columnIndex] = rightTrim(value);
					hasValue = true;
				}

				if (hasValue) {
					result.add(values);
					//System.out.println(values);
				}
			}
		}
		in.close();
		String[][] returnArray = new String[result.size()][rowSize];
		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = (String[]) result.get(i);
		}
		return returnArray;
	}

	/**
	 * ȥ���ַ����ұߵĿո�
	 * 
	 * @param str
	 *            Ҫ������ַ���
	 * @return �������ַ���
	 */
	public static String rightTrim(String str) {
		if (str == null) {
			return "";
		}
		int length = str.length();
		for (int i = length - 1; i >= 0; i--) {
			if (str.charAt(i) != 0x20) {
				break;
			}
			length--;
		}
		return str.substring(0, length);
	}
}
