package ui.Draft;
//��ȡ��������
import java.awt.GraphicsEnvironment;

public class test3 {
	public static void main(String[] args) {
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();//ȡ��ȫ�����õ�����
        String[] fornames=ge.getAvailableFontFamilyNames();
        for (int i = 0; i < fornames.length; i++) {
            System.out.println(fornames[i]);    
        }
    }

}
