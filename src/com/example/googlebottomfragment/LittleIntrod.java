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
	//变量***********************************************************************
	
	//函数***********************************************************************
		    @Override
		    protected void onCreate(Bundle savedInstanceState) {
		        super.onCreate(savedInstanceState);
		        requestWindowFeature(Window.FEATURE_NO_TITLE);
		        setContentView(R.layout.introduction);//设置页面布局
		        
		        Intent intent=getIntent();//获得Intent
		        
		      //“返回主界面”页面跳转
/*		        Return.setOnClickListener(new View.OnClickListener() { 
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent=new Intent();//创建Intent对象
						
						intent.setClass(LittleIntrod.this, ShowTime.class);//指定传递对象
						startActivity(intent);//将Intent传递给Activity
					}
				});*/
		    }


}
