/*
 * ������LinkCircle_module
 * ���ܣ�������������Panel����ʾ��ѯ���ݿ��ǰ����·�ı�������ģ��
 */
package ui.Add_link;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import ui.Share_bag.BBU_sql;


public class LinkCircle_module extends AbstractTableModel{
	//rowData������������� 
			//columNames�����������
			Vector rowData,columNames;
			Vector hang;
			int search_rownum;
			LinkCircle_module LinkCircle_table;
			//JTextField jtf1,jtf2,jtf3;
			/***************������·�������******************/	
			public LinkCircle_module()
			{
				columNames=new Vector<>();
				//��������
				columNames.add("��ID");//
				columNames.add("������");//
				columNames.add("X1����(m)");//
				columNames.add("Y1����(m)");//
				columNames.add("X2����(m)");//
				columNames.add("Y2����(m)");//
				columNames.add("���뾶(m)");//
				columNames.add("�̰뾶(m)");//
				columNames.add("��ѡ��������");//
				rowData=new Vector<>();
			}
			/***************��ѯ����õ���ʾÿ�ж�Ӧ���ݿ�����ĺ���******************/
			public void LinkCircle_search(String sql,String[]paras)
			{
				BBU_sql sqlh=null;
					try {
						sqlh=new BBU_sql();
						ResultSet rs=sqlh.search(sql, paras);
						while(rs.next())
						{
							//rowData���Դ�Ŷ���
							Vector hang=new Vector<>();
							hang.add(rs.getString(1));//LinkId
							if(rs.getString(2)==null)
							{
								hang.add(rs.getString(2));//��·����,0�����ͣ�1��������
							}else
							{
								if(rs.getString(2).equals("0"))//��·����LinkType,0�����ͣ�1��������
								{
									hang.add("����");
								}else if(rs.getString(2).equals("1"))
								{
									hang.add("������");
								}
							}
//							hang.add(rs.getString(2));//LinkType
							hang.add(rs.getString(3));//X1
							hang.add(rs.getString(4));//Y1
							hang.add(rs.getString(6));//X2
							hang.add(rs.getString(7));//Y2
							hang.add(rs.getString(9));//LongRadius
							hang.add(rs.getString(10));//ShortRadius
							hang.add(rs.getString(11));//AccesspointNum
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
			public Object getValueAt(int rowIndex, int columnIndex) {
				// TODO �Զ����ɵķ������
				return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);//��ת��stringҲû�й�ϵ
			}
			/**************���ñ��ڼ��еڼ�����ֵ ******************/
			@Override
			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
				// TODO �Զ����ɵķ������
				((Vector) rowData.get(rowIndex)).remove(columnIndex);
				  ((Vector) rowData.get(rowIndex)).add(columnIndex, aValue);
				  this.fireTableCellUpdated(rowIndex, columnIndex);
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
				}
				else 
				{
					return true;
				}
			}
			/**************������һ�� ******************/
			public void addRows(int LinkCircle_add_rownum) {
				// TODO �Զ����ɵķ������
				String sql="exec CircleRowMax";//��·�Ĳ������ID���ô˺���
				//String []paras={null};//LinkBbuPool2BbuPool
				LinkCircle_table=new LinkCircle_module();
				ResultSet LinkCircle_max_id=LinkCircle_table.RowMax_sql(sql);//BbuPool_Link_max_id����BbuPool_Link��ǰ���id��
				
				Vector hang=new Vector<>();
				try {
					LinkCircle_max_id.next();
						int temp=LinkCircle_max_id.getInt(1)+LinkCircle_add_rownum;
						String LinkCircle_id=Integer.toString(temp);
//					}
					hang.add(LinkCircle_id);//BbuPool_Link�ı��
				} catch (SQLException e) {
					e.printStackTrace();
				}		
				hang.add("");//LinkType
				hang.add("");//X1
				hang.add("");//Y1
				hang.add("");//X2
				hang.add("");//Y2
				hang.add("");//LongRadius
				hang.add("");//ShortRadius
				hang.add("");//AccesspointNum
				//���뵽rowData
				rowData.add(hang);
			}
			private ResultSet RowMax_sql(String sql) {
				// TODO �Զ����ɵķ������
				BBU_sql sqlh=new BBU_sql();
				return sqlh.search1(sql);
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
				return sqlh.search(sql,paras);
			}
			
}
