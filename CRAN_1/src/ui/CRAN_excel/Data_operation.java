/**
 * ����һ�������ݿ���в�������
 */
package ui.CRAN_excel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Data_operation {

	//����������ݿ���Ҫ�Ķ���
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
	//��ѯ���ݿ�Ĳ���
	public ResultSet search(String sql,String []paras)
		{
		try {
				Class.forName(driver);//��������
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=DATA","sa","zhangtao");//�õ�����
				ps=ct.prepareStatement(sql);//����ps
				//��ps�ģ���ֵ
				for(int i=0;i<paras.length;i++)
				{ 
					ps.setString(i+1, paras[i]);
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
	

//����ɾ�ĺ���һ��
		//���ѧ��(��ɾ��)
		public boolean add_delete_change(String sql,String []paras)//�����û�гɹ�����һ������ֵ
		{
			 boolean b=true;

			try {
				Class.forName(driver);//��������
				ct=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=DATA","sa","zhangtao");//�õ�����
				ps=ct.prepareStatement(sql);//����ps
				//��ps�ģ���ֵ
				for(int i=0;i<paras.length;i++)
				{ 
					ps.setString(i+1, paras[i]);
				}
				//ִ�в���
				ps.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally
			{
				this.close();
			}
			return b;

		}
}

	
