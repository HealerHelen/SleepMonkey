package com.example.googlebottomfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;

import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost.TabSpec;

public class MainActivity extends FragmentActivity {

	private Fragment contentFragment;
	private RadioGroup myTabRg;
	private FragmentMusic01 music;
	private FragmentPic pic;
	private ResultFragment result;
	private FragmentSet me;
	private FragmentHome home;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
	}

	public void initView() {
		home = new FragmentHome();
		getSupportFragmentManager().beginTransaction().replace(R.id.main_content, home).commit();
		myTabRg = (RadioGroup) findViewById(R.id.tab_menu);
		
		myTabRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.rbChat:
					
					music = new FragmentMusic01();
					getSupportFragmentManager().beginTransaction().replace(R.id.main_content, music)
							.commit();
					break;
				case R.id.rbAddress:
					pic=new FragmentPic();
					getSupportFragmentManager().beginTransaction().replace(R.id.main_content, pic).commit();
					break;
				case R.id.rbHome:
					home = new FragmentHome();
					getSupportFragmentManager().beginTransaction().replace(R.id.main_content, home).commit();
							
					break;
				case R.id.rbFind:
					result = new ResultFragment();
					getSupportFragmentManager().beginTransaction().replace(R.id.main_content, result).commit();
					break;
				case R.id.rbMe:
					me = new FragmentSet();
					//me.getSupportFragmentManager().beginTransaction().commit();
					getSupportFragmentManager().beginTransaction().replace(R.id.main_content, me).commit();
					//replace(R.id.main_content, me)
						//	.commit();
					break;
				default:
					break;
				}

			}
		});
	}
    /*再按一次退出程序*/
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
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();  
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
    @Override  
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {  
        if (keyCode == KeyEvent.KEYCODE_BACK) 
        {  
            exit();  
            return false;  
        } 
        else 
        {  
            return super.onKeyDown(keyCode, event);  
        }  
    }  
}
