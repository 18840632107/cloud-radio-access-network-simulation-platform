package com.test;

import map.network.GraphDemo;
import ui.CRAN1.tuoputu;

import com.config.ConfigJavaControler;
import com.config.ConfigTti;

public class ThreadBackGround extends Thread {
	
	
	public ThreadBackGround() {
		// TODO Auto-generated constructor stub
	}

	public ThreadBackGround(Runnable target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	public ThreadBackGround(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public ThreadBackGround(ThreadGroup group, Runnable target) {
		super(group, target);
		// TODO Auto-generated constructor stub
	}

	public ThreadBackGround(ThreadGroup group, String name) {
		super(group, name);
		// TODO Auto-generated constructor stub
	}

	public ThreadBackGround(Runnable target, String name) {
		super(target, name);
		// TODO Auto-generated constructor stub
	}

	public ThreadBackGround(ThreadGroup group, Runnable target, String name) {
		super(group, target, name);
		// TODO Auto-generated constructor stub
	}

	public ThreadBackGround(ThreadGroup group, Runnable target, String name,
			long stackSize) {
		super(group, target, name, stackSize);
	}
	public void run() {
		StreamToTextArea blah = StreamToTextArea.getInstance();
		System.setOut(blah.getPs());
		System.out.println("׼�������̨C++��������");

		/**cpp ģ���Ѿ���ʼ����*/
		try {
			System.out.println("��������ģ��"+ConfigTti.vEnumNetworkTrafficModel.name());
			System.out.println("��Դ����ģ��"+ConfigTti.vEnumResourceSheldual.name());
			System.out.println("�û�ҵ��������ģ��"+ConfigTti.vEnumUeTrafficModel.name());
			System.out.println("�û��ƶ���ģ��"+ConfigTti.vMov.name());
			System.out.println("·��ģ��"+ConfigTti.vPathLossModel.name());
			System.out.println("Ƶ��ģ��"+ConfigTti.vBandwidthResourceModel.name());
			System.out.println("������·ģ��"+ConfigTti.vWirePathModel.name());
			Thread.sleep(2000);

	        CppEntrance nativeCode=new CppEntrance();
//	        nativeCode.BackGroundPrograme();
//			System.out.println(System.getProperty("java.library.path"));  

			CppConfig aConfig=new CppConfig();
			/** test only**/
			int a[]={2,3,4};//��ֵ����̬������
			int speed[]={2,33};
			double angle[]={12.3};
			Object vSample[]=new Object[3];
			String vTstring="Random";
			vSample[0]=vTstring;
			vSample[1]=speed;//���ȷֲ�
			vSample[2]=angle;//�ƶ��ķ���Ƕ�
			ConfigTti.vConfigMovM=vSample;
			System.out.println(vSample[0]);
			
			switch (ConfigJavaControler.vCaseVersion) {
			/**����Ĭ��װ���case*/
			case vDefaultDemo:
//				System.out.println("����Ĭ��װ���case");
				//nativeCode.BackGroundPrograme();

				aConfig.setConfiguration();     //��ʱע�ͣ�������C++ģ��,����C++
				System.out.println("C++���óɹ���");
//				tuoputu.fpaint.clear();
//				ConfigTti tttConfigTti=new ConfigTti(a);
//				aConfig.setConfigCase0(tttConfigTti);
				break;
//			case vDefaultDemo1:
//				aConfig.setConfigCase1(new ConfigTti(ConfigJavaControler.vSamplingTime),1);
//				ConfigTti tttConfigTti=new ConfigTti(a);
//				aConfig.setConfigCase0(tttConfigTti);
//			case vDefaultDemo2:
//				aConfig.setConfigCase2(new ConfigTti(ConfigJavaControler.vSamplingTime),ConfigJavaControler.vSoftName);
			default:
				System.out.println("�ù���Ŀǰδʵ��");
				break;
			}
		} catch (Exception e) {
			System.out.println("look here"+e.toString());
			// TODO: handle exception
		}

        /**cpp ģ���Ѿ�����*/
		System.out.println("cpp_����TTi�߳� ���������ݽ���������ݿ�");
	}

}
