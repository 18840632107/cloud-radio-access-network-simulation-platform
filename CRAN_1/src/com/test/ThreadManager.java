package com.test;
import com.test.StreamToTextArea;
   public class ThreadManager implements Runnable{
       //�̶߳�������
       private Thread myThread;
       //���߼��
      private long interval=1000l;
      //��volatile��֤����ͬ��
      private volatile boolean threadSuspended;
  
      //��ʼ
      public void start(){
          myThread=new Thread(this,"myThread");
          myThread.start();
      }
      
      /**
 19      * �߳���(ִ������)��
 20      * ����̲߳���Ҫsleep֮�������������
 21      * ����ͨ��Thread.isInterrupted()����������ж�
 22      */
      @Override
      public void run() {
    	  StreamToTextArea blah = StreamToTextArea.getInstance();
  		  System.setOut(blah.getPs());
          Thread thisThread=Thread.currentThread();
          while(myThread==thisThread){
              try{
                  Thread.sleep(interval);
                  System.out.println(myThread.getName()+" is running.");
                  //��ifһ�£�����ÿ�ζ�����ͬ��������Ŀ���
                  if(threadSuspended&&myThread==thisThread){
                      synchronized(this){
                          /* ����߳���suspend״̬��stop����ômyThread==null
                           * ������һ��ѭ���Ϳ����˳������ٵȴ���
                           * ������˵��wait��������Ҳ�����ж��쳣��
                           * �����Ҿ�������ȥ��"myThread==thisThread"Ҳ��
                           * Ԫ��������ô����
 38                          * */
                          while(threadSuspended&&myThread==thisThread){
                              wait();
                          }
                      }
                  }
              }catch(InterruptedException e){
                  System.out.println(thisThread.getName()+
                          " is interrupted by InterruptedException.");
                  //������ﲻ���㴦����쳣,�����޷��׳�ȥ,�������¶����Լ�:
                  //Thread.currentThread().interrupt();
              }
          }
          System.out.println(thisThread.getName()+": I'm out, do you copy? ");
      }
      
      /**
       * ֹͣ�߳�:
 56      * �����sleep״̬����interrupt�����ã�
 57      * ���������״̬����myThread==null��ֹ��ѭ��
 58      */
     public synchronized void stop(){
          if(myThread==null){
              return;
          }
          Thread moribund=myThread;
          myThread=null;
          moribund.interrupt();
      }
      
      /**
       * �����̣߳�
 70      * ��ת��������֪ͨ�����ȴ��߳�
 71      */
      public synchronized void suspend(){
          threadSuspended=!threadSuspended;
          if(!threadSuspended){
              notify();
          }
      }
      
      //test
 }