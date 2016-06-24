package com.example.googlebottomfragment;

import java.util.Date;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentHome extends Fragment{
	/*int hour,minute;*/
    //����***********************************************************************
	boolean judge=true;
	private TextView STime = null ;//�ı���ʾ���
	private static final int SET = 1 ;//�̱߳��
	Time t=new Time();
	Time t2=new Time();
	boolean nothing=true;
	int ID=0;
	int keep=0;
	MyDataBase db = null;
	String[] result=new String[7];
	
	String loadthis=null;
	/*����Handle����*/
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what) {
			case SET ://�жϱ�־λ
				FragmentHome.this.STime.setText(msg.obj.toString());//������ʾ��Ϣ����ǰʱ��Ϊ����
				break ;
			}
		}
	} ;
	
	/*��ʾʱ����߳���*/
	private class ClockThread implements Runnable {

		@Override
		public void run() {//��дrun()����
			while(true) {	// ��������
				Message msg = FragmentHome.this.handler.obtainMessage(FragmentHome.SET,new SimpleDateFormat("HH:mm").format(new Date()));
				FragmentHome.this.handler.sendMessage(msg);//������Ϣ
				try {
					Thread.sleep(1000);//�ӳ�1��
				} catch (InterruptedException e) {
				}
			}
		}
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.homepage, null);
		db = new MyDataBase(getActivity().getApplicationContext());
		nothing=db.ExecSql("create table if not exists Sleep(ID int PRIMARY KEY,Styear int not null,Stmonth int not null,Stday int not null,Sthour int not null,Stminute int not null,Spyear int not null,Spmonth int not null,Spday int not null,Sphour int not null,Spminute int not null,Finish bit not null,Keep int not null)");
		db.ExecSql("insert into Sleep values( 0,2016,6,12,23,3,2016,6,13,6,47,1,464)");
		db.ExecSql("insert into Sleep values( 1,2016,6,13,23,22,2016,6,14,6,31,1,429)");
		db.ExecSql("insert into Sleep values( 2,2016,6,14,22,48,2016,6,15,7,6,1,498)");
		db.ExecSql("insert into Sleep values( 3,2016,6,15,23,58,2016,6,16,5,52,1,414)");
		db.ExecSql("insert into Sleep values( 4,2016,6,16,23,11,2016,6,17,6,43,1,452)");
		db.ExecSql("insert into Sleep values( 5,2016,6,18,2,36,2016,6,18,7,20,1,284)");
		db.ExecSql("insert into Sleep values( 6,2016,6,18,23,31,2016,6,19,8,7,1,516)");
db.ExecSql("insert into Sleep values( 7,2016,6,19,23,37,2016,6,20,7,10,1,450)");
db.ExecSql("insert into Sleep values( 8,2016,6,21,0,21,2016,6,21,6,16,1,355)");
		Cursor cursor = db.ExecQuery("select * from Sleep");
		if(cursor.getCount()!=0)
		{
			cursor.moveToLast();
			ID=cursor.getInt(0)+1;
		}

        this.STime = (TextView) view.findViewById(R.id.tvTime) ;
		new Thread(new ClockThread()).start() ;
        final ImageButton Sleep=(ImageButton)view.findViewById(R.id.imbtv_Sleep);//��ʼ˯����ť
        ImageButton monkey=(ImageButton) view.findViewById(R.id.imbtv_Introd);//С˵����ť
        
		//Ϊ����ʼ����˯�߰�ť����ӵ����¼�������
		Sleep.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(judge==true)
				{
					Sleep.setBackgroundResource(R.drawable.stoppppp);   //���İ���״̬ͼ��
					Sleep.setEnabled(true);//��ť����
					
				    Toast toast =Toast.makeText(getActivity().getApplicationContext(), "(��o��) . z Z�����Ѿ���ʼ��¼����˯�ߡ�", Toast.LENGTH_SHORT);
				    toast.setGravity(Gravity.BOTTOM, 0, 150);
				    toast.show();
				   
				    t.setToNow();
				    db.ExecSql("insert into Sleep values(" + ID + ","+ t.year + "," + (t.month+1) + "," + t.monthDay +"," + t.hour +"," + t.minute +",0,0,0,0,0,0,0)");

				    ID+=1;
                    judge=false;
				}
				else if(judge==false)
				{
					Sleep.setBackgroundResource(R.drawable.starttttt);   //���İ���״̬ͼ��
					Sleep.setEnabled(true);//��ť����
					
					Toast toast =Toast.makeText(getActivity().getApplicationContext(), "=���أ�=˯�߼�¼�ѱ��棬���ע����������", Toast.LENGTH_SHORT);
					toast.setGravity(Gravity.BOTTOM, 0, 150);
					toast.show();
					
					t2.setToNow();
					if(t2.minute<t.minute) keep+=60+t2.minute-t.minute;
					else keep+=t2.minute-t.minute;
					if(t2.hour<t.hour) keep+=(24-t.hour+t2.hour)*60;
					else keep+=(t2.hour-t.hour)*60;
					db.ExecSql("update Sleep set Spyear = "+t2.year+",Spmonth ="+(t2.month+1)+",Spday ="+t2.monthDay+",Sphour ="+t2.hour+",Spminute ="+t2.minute+",Finish = 1,Keep="+keep+" where Finish = 0");


					//result=FromEndRF.READend7("data");
					//result=test("data");
				    //loadthis=load();
					//loadthis=result[0];
/*					toast =Toast.makeText(ShowTime.this, loadthis, Toast.LENGTH_SHORT);
					toast.setGravity(Gravity.BOTTOM, 0, 150);
					toast.show();*/	
					judge=true;
				}
			}
        	
        });
		
		//��С���ܡ�ҳ����ת	
        monkey.setOnClickListener(new View.OnClickListener() { 
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();//����Intent����
				
				intent.setClass(getActivity().getApplicationContext(), LittleIntrod.class);//ָ�����ݶ���
				startActivity(intent);//��Intent���ݸ�Activity
			}
		});
		
        Intent intent=getActivity().getIntent();//���Intent
        
        return view;
    }


	public String[] test(String filename) {
		String[] string=new String[7]; 
		RandomAccessFile rf=null;
		int sline=0;
		try{
			rf=new RandomAccessFile(filename,"r");

		}
		catch(FileNotFoundException e)
		{e.printStackTrace();}
		catch (IOException e) {
			e.printStackTrace();
			}
		finally{
			try {
				rf.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
			}
/*		try {

			rf=new RandomAccessFile(filename,"r");
			long len=rf.length();
			long start=rf.getFilePointer();
			long nextend=start+len-1;
			String line;
			rf.seek(nextend);
			int c=-1;
			Toast toast =Toast.makeText(ShowTime.this, "try�ˡ�", Toast.LENGTH_SHORT);//
			toast.setGravity(Gravity.BOTTOM, 0, 150);//
			toast.show();//
			while(nextend>start&&sline<7){
				c=rf.read();
				if(c=='\n'||c=='\r'){
					line=rf.readLine();
					if(line==null){//�����ļ�ĩβ�ǿ����������
						nextend--;
						rf.seek(nextend);

					continue;}
					//System.out.println(line);
					string[sline]=line;
					toast =Toast.makeText(ShowTime.this, line, Toast.LENGTH_SHORT);//
					toast.setGravity(Gravity.BOTTOM, 0, 150);//
					toast.show();//
					sline++;
					nextend--;
					}
				nextend--;
				rf.seek(nextend);
				if(nextend==0){//���ļ�ָ�������ļ���ʼ���������һ��
					//System.out.println(rf.readLine());
					string[sline]=rf.readLine();
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
					}
		finally{
			try {
				rf.close();
				} catch (IOException e) {
					e.printStackTrace();
					}
			}*/
		return string;
	}
   

    /*�ٰ�һ���˳�����*/
    boolean isExit;
    Handler mHandler = new Handler() 
    {    	  
        @Override  
        public void handleMessage(Message msg) {  
            // TODO Auto-generated method stub   
            super.handleMessage(msg);  
            isExit = false;  
        }    
    };  
    
    public void exit()
    {  
        if (!isExit) 
        {  
            isExit = true;  
            Toast.makeText(getActivity().getApplicationContext(), "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();  
            mHandler.sendEmptyMessageDelayed(0, 2000);  
        } 
        else 
        {  
            Intent intent = new Intent(Intent.ACTION_MAIN);  
            intent.addCategory(Intent.CATEGORY_HOME);  
            startActivity(intent);  
            //System.exit(0);  
        }  
    }  
    
}
