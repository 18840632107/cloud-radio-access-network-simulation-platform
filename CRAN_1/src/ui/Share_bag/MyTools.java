/*
 * ������MyTools
 * ���ܣ������װ��
 */
package ui.Share_bag;

import java.awt.*;
import java.io.*;

public class MyTools {
	 private static Font definedFont = null;  
	//����һ������
	public static Font f1=new Font("΢���ź�", Font.BOLD, 17);
//	public static Font f25=new Font("@Hiragino Sans GB W3", Font.BOLD, 25);
	public static Font f25=new Font("΢���ź�", Font.BOLD, 25);
	public static Font f15=new Font("΢���ź�", Font.PLAIN, 15) ;
	public static Font f14=new Font("΢���ź�", Font.PLAIN, 14) ;
	public static Font f12=new Font("΢���ź�", Font.PLAIN, 12); 
//	public static Font getDefinedFont() {  
//        if (definedFont == null) {  
//            InputStream is = null;  
//           BufferedInputStream bis = null;  
//           try {  
//                is = MyTools.class.getResourceAsStream("Font"+File.separator+"�������W3.otf");  
//                 bis = new BufferedInputStream(is);  
//                // createFont����һ��ʹ��ָ���������ͺ��������ݵ��� Font��<br>  
//                // �� Font��ֵΪ 1����ʽΪ PLAIN,ע�� �˷�������ر� InputStream  
//                definedFont = Font.createFont(Font.TRUETYPE_FONT, bis);  
//                // ���ƴ� Font����Ӧ������ʽ������һ��ָ����ֵ���� Font����  
//                definedFont = definedFont.deriveFont(Font.BOLD, 90);  
//            } catch (FontFormatException e) {  
//                e.printStackTrace();  
//            } catch (IOException e) {  
//                e.printStackTrace();  
//            } finally {  
//                try {  
//                    if (null != bis) {  
//                        bis.close();  
//                    }  
//                    if (null != is) {  
//                        is.close();  
//                    }  
//                } catch (IOException e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//        }  
//        return definedFont;  
//    }  

}
