/*
 * ������BBU_sql
 * ���ܣ��������ݿ��ģ����
 */
package ui.Share_bag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class BBU_sql {
	//����������ݿ���Ҫ�Ķ���
	
		public static final String name = "sa";
		public static final String pswd = "zhangtao";
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//�ر����ݿ���Դ
		public void close()
		{
			//�ر�
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(ct!=null)ct.close();		
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception

			}
		}
		public ResultSet search(String sql,String []paras){
			try {
				Class.forName(driver);//��������
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=C-RAN",name,pswd);//�õ�����
				ps=ct.prepareStatement(sql);//����ps
				//��ps�ģ���ֵ
				if(paras!=null)
				{
					for(int i=0;i<paras.length;i++)
					{ 
						ps.setString(i+1, paras[i]);
						}
				}
				
				//ִ�в���
				rs=ps.executeQuery();
					
			} catch (Exception e) {
				e.printStackTrace();
					// TODO: handle exception
			}finally
			{
//					this.close();//�˴����ܹر���Դ����ΪrsҪ��������ģ�Ͳ�
			}
			return rs;
			
		}
		public ResultSet search1(String sql){//ר������û�в�����SQL���Ĳ�ѯ
			try {
				Class.forName(driver);//��������
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=C-RAN",name,pswd);//�õ�����
				ps=ct.prepareStatement(sql);//����ps
				
				rs=ps.executeQuery();
					
			} catch (Exception e) {
				e.printStackTrace();
					// TODO: handle exception
			}finally
			{
//					this.close();//�˴����ܹر���Դ����ΪrsҪ��������ģ�Ͳ�
			}
			return rs;
			
		}
		public boolean add_delete_change(String sql, String[] paras) {
			// TODO �Զ����ɵķ������
			boolean b=true;
			try {
				Class.forName(driver);//��������
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=C-RAN",name,pswd);//�õ�����
				ps=ct.prepareStatement(sql);//����ps
				//��ps�ģ���ֵ
				for(int i=0;i<paras.length;i++)
				{ 
					ps.setString(i+1, paras[i]);
				}
				//ִ�в���
				ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
//				JOptionPane.showMessageDialog(null,"�����ظ���ӵ���·�����������д��ں��֣�δ�ɹ����浽���ݿ⡣");
				b=false;
			}finally
			{
				this.close();
			}
			return b;
		}

}
