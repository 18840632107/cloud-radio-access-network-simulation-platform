/*
 * ������pic_column1
 * ���ܣ�run3�����е�һ������ͼģ����
 * ÿ��RRU������
 */
package ui.running;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class pic_column1{
	ChartPanel frame1;
	String TitleName;//ͼ�����
	String Xname;//X������
	String Yname;//Y������
	JFreeChart chart;
	DefaultCategoryDataset dataset;
	//��ȡһ�����ݼ�����
	public  pic_column1(String TitleNames,String Xnames,String Ynames,DefaultCategoryDataset datasets){ 
		TitleName=TitleNames;
		Xname=Xnames;
		Yname=Ynames;
		dataset=datasets;
        chart = ChartFactory.createBarChart3D( 
        					TitleName, // ͼ�����
        					Xname, // Ŀ¼�����ʾ��ǩX��
                            Yname, // ��ֵ�����ʾ��ǩY��
                            dataset, // ���ݼ�
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
                            true,  // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������ false)
                            false, // �Ƿ����ɹ���
                            false  // �Ƿ����� URL ����
                            ); //new Color(33,176,218)
        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        BarRenderer3D customBarRenderer = (BarRenderer3D) categoryplot.getRenderer();//Ϊ�˸�����״ͼ��ɫ
        customBarRenderer.setSeriesPaint(0, Color.decode("#7979FF")); //��ʽΪ��COLOR+��BBGGRR����BB��GG��RR��ʾ��ɫ����ɫ�ͺ�ɫ�ķ�����ÿ����ɫ��ȡֵ��Χ��00-FF��������16���ơ�
        categoryplot.setBackgroundPaint(SystemColor.white);//���ñ�����ɫ��ע�⣬ϵͳȡɫ��ʱ��Ҫʹ��16λ��ģʽ���鿴��ɫ���룬�����Ƚ�׼ȷ�� 
        customBarRenderer.setMaximumBarWidth(0.05);//�������ӿ��
        categoryplot.setBackgroundAlpha(0.8f);// ����ɫ͸����    
        categoryplot.setForegroundAlpha(0.8f);// ��������͸����    
        
        categoryplot.setRangeGridlinesVisible(true);//���ú����߿ɼ�    
        categoryplot.setRangeGridlinePaint(Color.gray);//����ɫ�� 

        categoryplot.setNoDataMessage("��������ʾ");
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();  
        CategoryAxis domainAxis = categoryplot.getDomainAxis(); 
        
     //���������������(�ؼ�)  
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
	public ChartPanel getChartPanel(){  
	    return frame1;  
	}  


}
