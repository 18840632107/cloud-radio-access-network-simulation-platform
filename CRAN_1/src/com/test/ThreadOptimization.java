package com.test;
import com.test.StreamToTextArea;

public class ThreadOptimization extends Thread {

	public ThreadOptimization() {
		// TODO Auto-generated constructor stub
		
	}

	public ThreadOptimization(ThreadGroup group, String name) {
		super(group, name);
		// TODO Auto-generated constructor stub
	}
	public void run() {
		StreamToTextArea blah = StreamToTextArea.getInstance();
		System.setOut(blah.getPs());
		System.out.println("�ж��Ƿ������Ż�");
		System.out.println("ϵͳ�Ż�����,�޸����ݿ���Ӧ�Ĵ���");
		//������Ϣ���࣬TTI��߶ȿ��ƣ�
	}
}
