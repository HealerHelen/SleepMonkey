package com.example.googlebottomfragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class AboutUs extends Activity{
	//����***********************************************************************
	
	//����***********************************************************************
	@Override
    protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.about_us);//����ҳ�沼��
        
        Intent intent=getIntent();//���Intent

        

	}

}
