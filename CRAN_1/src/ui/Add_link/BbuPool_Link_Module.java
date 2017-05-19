/*
 * ������BbuPool_Link_Module
 * ���ܣ�������������Panel����ʾ��ѯ���ݿ��ǰBBU�ؼ���·�ı�������ģ��
 */
package ui.Add_link;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import ui.Share_bag.BBU_sql;


public class BbuPool_Link_Module extends AbstractTableModel{
	//rowData������������� 
		//columNames�����������
		Vector rowData,columNames;
		Vector hang;
		int search_rownum;
		BbuPool_Link_Module BbuPool_Link_table;
		JTextField jtf1,jtf2,jtf3;
		/***************������·�������******************/	
		public BbuPool_Link_Module()
		{
			columNames=new Vector<>();
			//��������
			columNames.add("������· ID");//LinkPathId
			columNames.add("�˵��ID");//LinkEnd1
			columNames.add("�˵��ID");//LinkEnd2
			columNames.add("������ٶ�(Mbps)");//MaxTransRate
			columNames.add("��·����");//LinkType
			rowData=new Vector<>();
		}
		/***************��ѯ����õ���ʾÿ�ж�Ӧ���ݿ�����ĺ���******************/
		public void BbuPool_Link_search(String sql,String[]paras)
		{
			BBU_sql sqlh=null;
				try {
					sqlh=new BBU_sql();
					ResultSet rs=sqlh.search(sql, paras);
					while(rs.next())
					{
						//rowData���Դ�Ŷ���
						Vector hang=new Vector<>();
						hang.add(rs.getString(1));//������· ID
						hang.add(rs.getString(2));//�˵��ID
						hang.add(rs.getString(3));//�˵��ID
						hang.add(rs.getString(6));//������ٶ�
						hang.add(rs.getString(5));//��·����

						//���뵽rowData
						rowData.add(hang);
						
					}
					search_rownum=this.getRowCount();
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}finally
				{
					//�ر�
					sqlh.close();
				}	
			}
		/***************�õ��������******************/
		@Override
		public int getColumnCount() {
			// TODO �Զ����ɵķ������
			return this.columNames.size();
		}
		/***************�õ�������� ******************/
		@Override
		public int getRowCount() {
			// TODO �Զ����ɵķ������
			return this.rowData.size();
		}
		/**************���ر��ڼ��еڼ�����ֵ ******************/
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
		/**************���ñ�������Ƿ�����޸� ******************/	
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			// TODO �Զ����ɵķ������
			if(rowIndex<search_rownum)
			{
				return false;
			}else
			{
				return true;
			}
		}
		/**************���ñ��ڼ��еڼ�����ֵ ******************/
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO �Զ����ɵķ������
			((Vector) rowData.get(rowIndex)).remove(columnIndex);
			  ((Vector) rowData.get(rowIndex)).add(columnIndex, aValue);
			  this.fireTableCellUpdated(rowIndex, columnIndex);
		}
		/**************������һ�� ******************/
		public void addRows(int bbuPool_Link_add_rownum) {
			// TODO �Զ����ɵķ������
			String sql="exec PathRowMax ?";
			String []paras={"LinkBbuPool2BbuPool"};//LinkBbuPool2BbuPool
			BbuPool_Link_table=new BbuPool_Link_Module();
			ResultSet BbuPool_Link_max_id=BbuPool_Link_table.total_num_sql(sql, paras);//BbuPool_Link_max_id����BbuPool_Link��ǰ���id��
			
			Vector hang=new Vector<>();
			try {
				BbuPool_Link_max_id.next();
					int temp=BbuPool_Link_max_id.getInt(1)+bbuPool_Link_add_rownum;
					String BbuPool_Link_id=Integer.toString(temp);
//				}
				hang.add(BbuPool_Link_id);//BbuPool_Link�ı��
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			hang.add(jtf1);//�˵��ID
			hang.add(jtf2);//�˵��ID
			hang.add(jtf3);//������ٶ�
			hang.add("");//��·����
			//���뵽rowData
			rowData.add(hang);
		}
		/**************�Ա�������� ɾ�� �޸Ĳ���******************/
		public boolean add_delete_change_to_sql(String sql,String []paras) {
			// TODO �Զ����ɵķ������
			BBU_sql sqlh=new BBU_sql();
			return sqlh.add_delete_change(sql, paras);
		}
		/**************�˺����������ݿ�ÿ���������������������Ŀ���ǵõ��������������Զ�����ID ******************/
		public ResultSet total_num_sql(String sql,String []paras)//�˺����������ݿ�ÿ���������������������Ŀ���ǵõ��������������Զ�����ID
		{
			BBU_sql sqlh=new BBU_sql();
			return sqlh.search(sql, paras);
		}
		
}
