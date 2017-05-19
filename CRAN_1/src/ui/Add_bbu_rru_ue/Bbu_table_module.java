/*
 * ������Bbu_table_module
 * ���ܣ�������������Panel����ʾ��ѯ���ݿ��ǰBBU�ı�������ģ��
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
public class Bbu_table_module extends AbstractTableModel{
	//rowData������������� 
	//columNames�����������
	Vector rowData,columNames;
	Vector hang;
	JTextField jtf1,jtf5,jtf6;
	int search_rownum;
	Bbu_table_module bbu_table;
	/***************����BBU�������******************/	
	public Bbu_table_module()
	{
		columNames=new Vector<>();
		//��������
		//columNames.add("");��ѡ��Ԥ����
		columNames.add("BBU ID");
		columNames.add("X����(m)");
		columNames.add("Y����(m)");
		columNames.add("Z����(m)");
		columNames.add("���书��(dBm)");
		columNames.add("��Դ��");
		columNames.add("RRU�ĵ��ȷ�ʽ");
		columNames.add("���뻷");
		rowData=new Vector<>();
	}
	/***************��ѯ����õ���ʾÿ�ж�Ӧ���ݿ�����ĺ���******************/
	public void bbu_table_search(String sql,String[]paras)
	{
		BBU_sql sqlh=null;
			try {
				sqlh=new BBU_sql();
				ResultSet rs=sqlh.search(sql, paras);
				while(rs.next())
				{
					//rowData���Դ�Ŷ���
					Vector hang=new Vector<>();
					hang.add(rs.getString(1));//BBU�ı��
					hang.add(rs.getString(3));//X����
					hang.add(rs.getString(4));//Y����
					hang.add(rs.getString(5));//Z����
					hang.add(rs.getString(8));//���书��dbm��ʽ
					hang.add(rs.getString(11));//��Դ��
					if(rs.getString(7)==null)
					{
						hang.add(rs.getString(7));//RRU��Դ���ȵķ�ʽ
					}else
					{
						if(rs.getString(7).equals("0"))
						{
							hang.add("RRS");//RRU��Դ���ȵķ�ʽ:0��RRS 1:CIS 2:PFS
						}else if(rs.getString(7).equals("1"))
						{
							hang.add("CIS");//RRU��Դ���ȵķ�ʽ
						}else if(rs.getString(7).equals("2"))
						{
							hang.add("PFS");//RRU��Դ���ȵķ�ʽ
						}
					}
//					hang.add(rs.getString(7));//RRU��Դ���ȵķ�ʽ
					hang.add(rs.getString(12));//���뻷
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

	/***************��ձ��******************/
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
	/**************���ñ�������Ƿ�����޸� ******************/	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO �Զ����ɵķ������
		//return super.isCellEditable(rowIndex, columnIndex);
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
	/**************���ر������******************/
	@Override
	public String getColumnName(int column) {
		// TODO �Զ����ɵķ������
		return (String) this.columNames.get(column);
	}
	/**************������һ�� ******************/
	public void addRows(int bbu_add_rownum,String buuc_X,String buuc_Y,String buuc_Z) {
		// TODO �Զ����ɵķ������
		
		String sql="exec RowMax ?";
		String []paras={"Bbu"};
		bbu_table=new Bbu_table_module();
		ResultSet Bbu_max_id=bbu_table.total_num_sql(sql, paras);//Bbu_max_id����bbu��ǰ���id��
		
		Vector hang=new Vector<>();
		try {
			Bbu_max_id.next();
			int temp=Bbu_max_id.getInt(1)+bbu_add_rownum;
			String bbuid=Integer.toString(temp);
			hang.add(bbuid);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}//BBU�ı��
		hang.add(buuc_X);//X����
		
		hang.add(buuc_Y);//Y����
		
		hang.add(buuc_Z);//Z����
		
		hang.add(jtf5);//���书��dbm��ʽ
		hang.add(jtf6);//��Դ��
		hang.add("");//RRU��Դ���ȵķ�ʽ
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
	public ResultSet total_num_sql(String sql,String []paras)
	{
		BBU_sql sqlh=new BBU_sql();
		return sqlh.search(sql, paras);
	}


}