package com.example.googlebottomfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LittleIntrod extends Activity{
	//����***********************************************************************
	
	//����***********************************************************************
		    @Override
		    protected void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        requestWindowFeature(Window.FEATURE_NO_TITLE);
		        setContentView(R.layout.introduction);//����ҳ�沼��
		        
		        Intent intent=getIntent();//���Intent
		        
		      //�����������桱ҳ����ת
/*		        Return.setOnClickListener(new View.OnClickListener() { 
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent();//����Intent����
						
						intent.setClass(LittleIntrod.this, ShowTime.class);//ָ�����ݶ���
						startActivity(intent);//��Intent���ݸ�Activity
					}
				});*/
		    }


}
