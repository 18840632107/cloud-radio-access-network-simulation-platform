/*
 * ������Num_search_module
 * ���ܣ���ѯ,ͳ��bbuc,bbu,rru,ue������ģ����
 */
package ui.Share_bag;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class Num_search_module extends AbstractTableModel{
	//rowData������������� 
		//columNames�����������
		Vector rowData,columNames;
	//��ѯ,Ϊ����ͳ��bbuc,bbu,rru,ue������
				public void search_num(String sql,String[]paras,int num)//numΪ������������Ҫ���е�����
				{
					BBU_sql sqlh=null;
					rowData=new Vector<>();
					try {
						sqlh=new BBU_sql();
						ResultSet rs=sqlh.search(sql, paras);
						while(rs.next())
						{
							//rowData���Դ�Ŷ���
							Vector hang=new Vector<>();
							for(int i=1;i<=num;i++)
							{
								hang.add(rs.getString(i));//rs.getString(i)�Ǵ�1��ʼ��
							}
							//���뵽rowData
							rowData.add(hang);
							
						}
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}finally
					{
						//�ر�
						sqlh.close();
					}	
				}

	//�����ʱ���
				public void  clean_all() {
//					columNames.clear();
					try {
						rowData.clear();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
	@Override
	public int getColumnCount() {
		// TODO �Զ����ɵķ������
		return this.columNames.size();
	}

	@Override
	public int getRowCount() {
		// TODO �Զ����ɵķ������
		return this.rowData.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO �Զ����ɵķ������
		return ((Vector)this.rowData.get(row)).get(col);//��ת��stringҲû�й�ϵ
	}

	@Override
	public String getColumnName(int column) {
		// TODO �Զ����ɵķ������
		return (String) this.columNames.get(column);
	}

}
