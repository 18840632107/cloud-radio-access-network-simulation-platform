/*
 * ������Bbu2Bbu_Link_module
 * ���ܣ�������������Panel����ʾ��ѯ���ݿ��ǰ����BBU����·�ı�������ģ��
 */
package ui.Add_link;

import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import ui.Share_bag.BBU_sql;



public class Bbu2Bbu_Link_module extends AbstractTableModel{
		//rowData������������� 
		//columNames�����������
		Vector rowData,columNames;
		Vector hang;
		int search_rownum;
		Bbu2Bbu_Link_module Bbu2Bbu_Link_table;
		JTextField jtf1,jtf2,jtf3;
		/***************������·�������******************/	
		public Bbu2Bbu_Link_module()
		{
			columNames=new Vector<>();
			//��������
			columNames.add("������· ID");//LinkPathId
			columNames.add("�˵�BBU ID");//LinkEnd1
			columNames.add("�˵�BBU ID");//LinkEnd2
			columNames.add("������ٶ�(Mbps)");//MaxTransRate
			columNames.add("��·����");//LinkType
			columNames.add("���뻷");//
			rowData=new Vector<>();
		}
		/***************��ѯ����õ���ʾÿ�ж�Ӧ���ݿ�����ĺ���******************/
		public void Bbu2Bbu_Link_search(String sql,String[]paras)
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
						if(rs.getString(5)==null)
						{
							hang.add(rs.getString(5));//��·����,0�����ͣ�1��������
						}else
						{
							if(rs.getString(5).equals("0"))//��·����,0�����ͣ�1��������
							{
								hang.add("����");
							}else if(rs.getString(5).equals("1"))
							{
								hang.add("������");
							}
						}
//						hang.add(rs.getString(5));//��·����
						hang.add(rs.getString(11));//���뻷
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
		/**************���ñ��ڼ��еڼ�����ֵ ******************/
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO �Զ����ɵķ������
			((Vector) rowData.get(rowIndex)).remove(columnIndex);
			  ((Vector) rowData.get(rowIndex)).add(columnIndex, aValue);
			  this.fireTableCellUpdated(rowIndex, columnIndex);
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
		/**************������һ�� ******************/
		public void addRows(int Bbu2Bbu_Link_add_rownum) {
			// TODO �Զ����ɵķ������
			String sql="exec PathRowMax ?";//��·�Ĳ������ID���ô˺���
			String []paras={"LinkBbu2Bbu"};//LinkBbuPool2BbuPool
			Bbu2Bbu_Link_table=new Bbu2Bbu_Link_module();
			ResultSet Bbu2Bbu_Link_max_id=Bbu2Bbu_Link_table.total_num_sql(sql, paras);//BbuPool_Link_max_id����BbuPool_Link��ǰ���id��
			
			Vector hang=new Vector<>();
			try {
				Bbu2Bbu_Link_max_id.next();
					int temp=Bbu2Bbu_Link_max_id.getInt(1)+Bbu2Bbu_Link_add_rownum;
					String Bbu2Bbu_Link_id=Integer.toString(temp);
//				}
				hang.add(Bbu2Bbu_Link_id);//BbuPool_Link�ı��
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			hang.add(jtf1);//�˵��ID
			hang.add(jtf2);//�˵��ID
			hang.add(jtf3);//������ٶ�
			hang.add("");//��·����
			hang.add("");//���뻷
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
