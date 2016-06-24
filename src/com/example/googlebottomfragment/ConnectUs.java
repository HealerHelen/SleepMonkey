package com.example.googlebottomfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ConnectUs extends Activity{
	//变量***********************************************************************
	
	//函数***********************************************************************
		@Override
	    protected void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.connect_us);//设置页面布局

		}

}
