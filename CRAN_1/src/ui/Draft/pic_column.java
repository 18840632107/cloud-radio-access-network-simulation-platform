/*
 * ÿ��RRU������
 * ����BBU��Ƶ��Ч��
 * ����BBU���ܺ�
 */
package ui.Draft;

import java.awt.Dimension;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class pic_column{
	ChartPanel frame1;
	String TitleName;//ͼ�����
	public  pic_column(){  
		CategoryDataset dataset = getDataSet(); 
        JFreeChart chart = ChartFactory.createBarChart3D( 
                           "ˮ������ͼ", // ͼ�����
                           "ˮ��", // Ŀ¼�����ʾ��ǩ
                           "����", // ��ֵ�����ʾ��ǩ
                            dataset, // ���ݼ�
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                            true,  // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������ false)
                            false, // �Ƿ����ɹ���
                            false  // �Ƿ����� URL ����
                            ); 
        //��������
        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();  
        CategoryAxis domainAxis = categoryplot.getDomainAxis();  
        TextTitle textTitle = chart.getTitle();
        textTitle.setFont(new Font("����", Font.PLAIN, 20));      
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
        domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));  
        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
        numberaxis.setLabelFont(new Font("����", Font.PLAIN, 12));  
        chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));
        frame1=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame  
        frame1.setPreferredSize(new Dimension(440,300));
	}
	/** 
	 * ��ȡһ����ʾ�õļ����ݼ�����
	 * @return 
	 */ 
	 private static CategoryDataset getDataSet() { 
	     DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
	                dataset.addValue(100, "����", "ƻ��");  
	                dataset.addValue(100, "�Ϻ�", "ƻ��");  
	                dataset.addValue(100, "����", "ƻ��");  
	                dataset.addValue(200, "����", "����");  
	                dataset.addValue(200, "�Ϻ�", "����");  
	                dataset.addValue(200, "����", "����");  
	                dataset.addValue(300, "����", "����");  
	                dataset.addValue(300, "�Ϻ�", "����");  
	                dataset.addValue(300, "����", "����");  
	                dataset.addValue(400, "����", "�㽶");  
	                dataset.addValue(400, "�Ϻ�", "�㽶");  
	                dataset.addValue(400, "����", "�㽶");  
	                dataset.addValue(500, "����", "��֦");  
	                dataset.addValue(500, "�Ϻ�", "��֦");  
	               dataset.addValue(500, "����", "��֦");  
	               //
	               dataset.addValue(100, "����", "ƻ��1");  
	                dataset.addValue(100, "�Ϻ�", "ƻ��1");  
	                dataset.addValue(100, "����", "ƻ��1");  
	                dataset.addValue(200, "����", "����1");  
	                dataset.addValue(200, "�Ϻ�", "����1");  
	                dataset.addValue(200, "����", "����1");  
	                dataset.addValue(300, "����", "����1");  
	                dataset.addValue(300, "�Ϻ�", "����1");  
	                dataset.addValue(300, "����", "����1");  
	                dataset.addValue(400, "����", "�㽶1");  
	                dataset.addValue(400, "�Ϻ�", "�㽶1");  
	                dataset.addValue(400, "����", "�㽶1");  
	                dataset.addValue(500, "����", "��֦1");  
	                dataset.addValue(500, "�Ϻ�", "��֦1");  
	               dataset.addValue(500, "����", "��֦1");  
	               return dataset;  

	 } 
	 public ChartPanel getChartPanel(){  
		     return frame1;  
		 }  

}
