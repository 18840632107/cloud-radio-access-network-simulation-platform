package com.test;
//����TTI
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import ui.running.run3;

import com.config.*;
import com.test.StreamToTextArea;
import ui.CRAN1.tuoputu;

public class ThreadTaskMain extends Thread {
	private volatile boolean vIsSuspend=false;
	public static int vUnitCounter=0;//����ʱ�̼�����
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS"); 
	TimeZone t = sdf.getTimeZone(); 
	public double fProgress = 0;
	long pauseTime = 0;
	long endTime = 0;
	public ThreadTaskMain() {
		// TODO Auto-generated constructor stub
		super();
	}

	public ThreadTaskMain(ThreadGroup tag, String aim) {
		super(tag, aim);
	}
	
	public synchronized void stopThread() {
		vIsSuspend=true;
	}

	@Override
	public void run() {
		t.setRawOffset(0); 
		sdf.setTimeZone(t); 
		StreamToTextArea blah = StreamToTextArea.getInstance();
		System.setOut(blah.getPs());
		System.out.println("����������");
		boolean vLargeScale=false;

		/**�жϴ�߶�*/
		if (ConfigJavaControler.vIntervalUnit!=EnumSamplingInterval.vTTI) {
			vLargeScale=true;	
			System.out.println("��߶�������");
		}
		
		
		/**��һ��ѭ�������Ƴ���ʱ�̣��ж�*/
		try{	
			System.out.print("------------------------"+ConfigJavaControler.vSamplingTime.length);
		}catch(Exception e){
			System.out.print(e.toString());
		}
		run3.bar.setValue(0);
		ConfigJavaControler.vFlagPause = true;//��ÿ���߳̿�ʼʱ������ͣ������ԭ��
		vUnitCounter = 0;
		fProgress = 0;
		BreakLabel: while (vUnitCounter<ConfigJavaControler.vSamplingTime.length && !vIsSuspend) {
			run3.textField_2.setText(Integer.toString(ConfigJavaControler.vSamplingTime[ThreadTaskMain.vUnitCounter]));
			int vSubUniteCounter=0;//����ʱ���ڼ�����
			
			boolean vOptimizationStart=false;//ÿһ������ʱ�̵��Ż�������־
			/**�ڶ���ѭ�������Ƴ���ʱ���ڲ���n�����������������ݴ洢*/
			Optimization:while (vSubUniteCounter<ConfigJavaControler.vSamplingNum && !vIsSuspend) {
				if (vIsSuspend) 
					continue BreakLabel;
				System.out.println(vIsSuspend+"1111111111111111111111111111");
				/**����ѭ������*/
				fProgress = (double)((vUnitCounter)*ConfigJavaControler.vSamplingNum +vSubUniteCounter+1)/(double)(ConfigJavaControler.vSamplingTime.length*(ConfigJavaControler.vSamplingNum));
				run3.bar.setValue((int)(fProgress*100));
				run3.textField_3.setText(Double.toString(fProgress));
				run3.textField_4.setText(Integer.toString(vSubUniteCounter));
				
				if(!ConfigJavaControler.vFlagPause)
				{
					pauseTime += System.currentTimeMillis()-endTime;
				}
				endTime = System.currentTimeMillis();
				
				
				
				System.out.println("ϵͳ������");
				
				if (ConfigJavaControler.vFlagPause) {
					run3.textField_3.setText(sdf.format(new Date(endTime - run3.startTime-pauseTime))); 
					try {
						/**����ѭ������*/
						if (vIsSuspend) 
							continue BreakLabel;
							
						/**��ʾ�����µ�һ��ѭ��*/
						if (vOptimizationStart) {
							System.out.println("--�Ż���Ľ��--����ǰʱ����Ϣ-------"+ConfigJavaControler.vSamplingTime[vUnitCounter]+"----��ǰ��ʱ��-----" + vSubUniteCounter);
						}else {
							System.out.println("--δ�Ż��Ľ��--����ǰʱ����Ϣ-------"+ConfigJavaControler.vSamplingTime[vUnitCounter]+"----��ǰ��ʱ��-----" + vSubUniteCounter
							);
						}
						/** ����������� */
						System.out.println("ÿ��TTI������Ϣ������");
//						/** �Ƿ����ݿ����ݸ��±�־ */
//						System.out.println("����������Ϣ");
						if (vSubUniteCounter==ConfigJavaControler.vSamplingNum-1 && ConfigJavaControler.vFlagOptiTriggle) {
							/**�˴�Ҫ���н����ж��Ƿ������Ż�*/
							ConfigJavaControler.vMeetOptimization=true;//ȷ���Ż������о���������(�о�����������)
							System.out.println("�ж��Ƿ������Ż�������"+ConfigJavaControler.vMeetOptimization);
							/**�������*/
							if (ConfigJavaControler.vMeetOptimization && !vOptimizationStart) {
								new ThreadOptimization(main.vMyGroup, "Optimization");
								ConfigJavaControler.vMeetOptimization=false;//
								vSubUniteCounter=0;//������0
								vOptimizationStart=true;//���µڶ���ѭ���ڵı�־��ֹ������ѭ����
								continue Optimization;
							}									
						}
						/**��������Ż����ص���Ϣ�������ȡδ�Ż���Ϣ����һ��Ӧ����cpp��ʵ��*/
						if (ConfigJavaControler.vMeetOptimization) {
							System.out.println("��ȡ�Ż�����û���Ϣ");
						}else {
							System.out.println("��ȡ�Ż�ǰ���û���Ϣ");
						}
						
						/**��������case����*/
							ThreadBackGround vBackGroundThread=new ThreadBackGround(main.vMyGroup,"back groud procedure");
							vBackGroundThread.start();
							
							/**�������̵߳ı��ֵȴ�������ÿ��ֻ��һ��TTI�߳�������*/
							while (vBackGroundThread.isAlive()) {
								//Thread.sleep(3000);//�����ͻȻ��ֻͣ�� ��break +lable�Ϳ���
								//tuoputu.fpaint.clear();	
							}
							
						/**�ж��Ƿ������Ż�Ҫ��*/
						/** �Ż�ָ���飬����������ǰ�Ż����� */
						//Thread.sleep(300);
					

						/**������**/
						vSubUniteCounter++;
					} catch (Exception e) {
						// TODO: handle exception
					}
				} else {
					System.out.println("�߳�TTI��ͣ��");
				}				
			}
			ConfigJavaControler.vMeetOptimization=false;//ÿһ��ʱ������ˢ�������Ż���־��Ϣ��
			
			vUnitCounter++;
		}
		System.out.println("���н���");
		
		//run3.bar.setValue(0);
		
	}

}
