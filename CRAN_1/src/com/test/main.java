package com.test;

import ui.PrintRedirect.Entrance;

import com.database.ReadConfig;

public class main extends Thread {
	/***/
	public static ThreadGroup vMyGroup=new ThreadGroup("main procedure group");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setOut(new Entrance().work());//��Ҫ��ConfigJavaControler������һ���ļ�·��������
		System.out.println("��ȡ���ò���");
		//ReadConfig vTest=new ReadConfig("C:/Users/tao/Desktop/input.xls");
		//ConfigJavaControler.setSamplingCustom(EnumSamplingInterval.vSecond, 3,vInput ,5);
		System.loadLibrary("NativeTestJni");//���ؿ�1
		System.loadLibrary("NativeProCase");//���ؿ�2
		//���������̣߳��������ɰ�ť֮ǰҪ�ж��߳��Ƿ����Ѵ��ڣ������ε���ᴴ������߳�
		ThreadTaskMain main_thread=new ThreadTaskMain(vMyGroup,"main procedure");
		main_thread.start();
		
		//�����߳�����
//		ThreadUi vUiThread=new ThreadUi(vMyGroup,"Ui");
//		vUiThread.start();
		System.out.println("--�߳�1----end-----");	
	}
}
