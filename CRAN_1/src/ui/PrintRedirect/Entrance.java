package ui.PrintRedirect;
import java.io.PrintStream;
import java.util.Timer;


public class Entrance {
	public Entrance(){}
	/**
	 * ʵ��һ���ӵ��Զ�ˢ�¹���
	 */
	public PrintStream work(){
		PrintRedirection a1=new PrintRedirection();
		PrintRedirection.call_back c1=a1.new call_back();//�����ص�����
		Timer aTimer=new Timer();//������ʱ��
		aTimer.schedule(new TimeKeeper(c1),1000,1000);//����task��������1000ms����һ��
		return a1.vNewPrintSteam;
	}
}
