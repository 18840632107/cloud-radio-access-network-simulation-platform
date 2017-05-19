/*
 * ������Rru_Table_module
 * ���ܣ�������������Panel����ʾ��ѯ���ݿ��ǰRRU�ı�������ģ��
 */
package ui.Add_bbu_rru_ue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.*;

import ui.Share_bag.*;
import ui.CRAN_excel.*;
public class Rru_Table_module extends AbstractTableModel{
	//rowData������������� 
		//columNames�����������
		Vector rowData,columNames;
		Vector hang;
		JTextField jtf2,jtf3,jtf4,jtf5,jtf6,jtf7;
		int search_rownum;
		Rru_Table_module rru_table;
		/***************����RRU�������******************/
		public Rru_Table_module()
		{
			columNames=new Vector<>();
			//��������
			//columNames.add("");��ѡ��Ԥ����
			columNames.add("RRU ID");
			columNames.add("X����(m)");
			columNames.add("Y����(m)");
			columNames.add("Z����(m)");
			columNames.add("���书��(dBm)");
			columNames.add("����û���");
			columNames.add("��Ƶ(Hz)");
			columNames.add("RRU��״̬");
			columNames.add("��������");
			rowData=new Vector<>();
		}
		/***************����õ���ʾÿ�ж�Ӧ���ݿ�����ĺ���******************/
		public void table_search(String sql,String[]paras)
		{
			BBU_sql sqlh=null;
				try {
					sqlh=new BBU_sql();
					ResultSet rs=sqlh.search(sql, paras);
					while(rs.next())
					{
						//rowData���Դ�Ŷ���
						Vector hang=new Vector<>();
						hang.add(rs.getString(1));//RRU ID0
						hang.add(rs.getString(4));//X����1
						hang.add(rs.getString(5));//Y����2
						hang.add(rs.getString(6));//Z����3
						hang.add(rs.getString(7));//���书��4
						hang.add(rs.getString(9));//����û���5
						hang.add(rs.getString(11));//��Ƶ6
						if(rs.getString(10)==null)
						{
							hang.add(rs.getString(10));//RRU��Դ���ȵķ�ʽ
						}else
						{
							if(rs.getString(10).equals("0"))
							{
								hang.add("�ر�");//RRU��״̬����7,0���رգ�1����
							}else if(rs.getString(10).equals("1"))
							{
								hang.add("��");//RRU��״̬����7
							}
						}
						hang.add(rs.getString(12));//RRU������8
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

		//��ձ��
		public void  clean_all() {
			try {
				rowData.clear();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		/***************�õ��������******************/
		@Override
		public int getColumnCount() {
			// TODO �Զ����ɵķ������
			return this.columNames.size();
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
			//ʹ��jtable���޸ĺ󣬾Ϳ�����ʾ�����б��ˡ�
		}
		@Override
		public String getColumnName(int column) {
			// TODO �Զ����ɵķ������
			return (String) this.columNames.get(column);
		}
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO �Զ����ɵķ������
			 ((Vector) rowData.get(rowIndex)).remove(columnIndex);
			  ((Vector) rowData.get(rowIndex)).add(columnIndex, aValue);
			  this.fireTableCellUpdated(rowIndex, columnIndex);
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
		/**************������һ�� ******************/
		public void addRows(int rru_add_rownum) {
			// TODO �Զ����ɵķ������
			
			String sql="exec RowMax ?";
			String []paras={"Rru"};
			rru_table=new Rru_Table_module();
			ResultSet Rru_max_id=rru_table.total_num_sql(sql, paras);//Bbu_max_id����bbu��ǰ���id��
			
			Vector hang=new Vector<>();
			try {
				Rru_max_id.next();
				int temp=Rru_max_id.getInt(1)+rru_add_rownum;
				String rruid=Integer.toString(temp);
				hang.add(rruid);
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}//BBU�ı��
			hang.add(jtf2);//X����
			
			hang.add(jtf3);//Y����
			
			hang.add(jtf4);//Z����
			
			hang.add(jtf5);//���书��
			hang.add(jtf6);//����û���
			hang.add(jtf7);//��Ƶ
			hang.add("");//RRU��״̬����
			hang.add("");//RRU������
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
		public ResultSet total_num_sql(String sql,String []paras)
		{
			BBU_sql sqlh=new BBU_sql();
			return sqlh.search(sql, paras);
		}
}

	