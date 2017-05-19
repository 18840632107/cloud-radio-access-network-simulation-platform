/*
 * ������pic_line
 * ���ܣ�run3����������ͼģ����
 * 
 */
package ui.running;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class pic_line {
	ChartPanel frame1;  
	String TitleName;//ͼ�����
	String Xname;//X������
	String Yname;//Y������
	DefaultCategoryDataset dataset;
	JFreeChart jfreechart;
	public pic_line(String TitleNames,String Xnames,String Ynames,DefaultCategoryDataset datasets){ 
	    	TitleName=TitleNames;
			Xname=Xnames;
			Yname=Ynames;
			dataset=datasets;
	        jfreechart =  ChartFactory.createLineChart(TitleName,Xname, Yname, dataset, PlotOrientation.VERTICAL, true, true,true);   
	        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
	        categoryplot.setBackgroundPaint(SystemColor.WHITE); //���ñ�����ɫ
	        categoryplot.setRangeGridlinesVisible(true);//���ú����߿ɼ�    
	        categoryplot.setRangeGridlinePaint(Color.gray);//����ɫ�� 
	        categoryplot.setNoDataMessage("��������ʾ");
	        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();  
	        CategoryAxis domainAxis = categoryplot.getDomainAxis();  
	      //���������������(�ؼ�) 
	        TextTitle textTitle = jfreechart.getTitle();
	        textTitle.setFont(new Font("����", Font.PLAIN, 20));      
	        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
	        domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));  
	        numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
	        numberaxis.setLabelFont(new Font("����", Font.PLAIN, 12));  
	        jfreechart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));
//            // ����ʾ��������  
            LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot.getRenderer();  
            lineandshaperenderer.setBaseShapesVisible(true);  
            lineandshaperenderer.setDrawOutlines(true);  
            lineandshaperenderer.setUseFillPaint(true);  
            lineandshaperenderer.setBaseFillPaint(Color.white);  
            // �������߼Ӵ�  
            lineandshaperenderer.setSeriesStroke(0, new BasicStroke(2F));  
            lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(1.0F));  
            // �������߹յ�  
            lineandshaperenderer.setSeriesShape(0,new java.awt.geom.Ellipse2D.Double(-1D, -1D, 3D, 3D));  

	        frame1=new ChartPanel(jfreechart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame  
	        frame1.setPreferredSize(new Dimension(440,300));
	  
	    }   
	      public ChartPanel getChartPanel(){  
	            return frame1;  
	              
	        }  

}
