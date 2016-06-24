package com.example.googlebottomfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.KeyEvent;
import android.view.Menu;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class FragmentSet extends Fragment {

/*	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}*/

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.set, null);
		//Intent intent = new Intent(getActivity(),SetActivity.class);
		//startActivity(intent);
		final ListView setlist = (ListView)view.findViewById(R.id.lstV_set);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity().getApplicationContext(), R.array.ctype,android.R.layout.simple_list_item_1);
        setlist.setAdapter(adapter);
        
        
        
        
        //���ø����б���ļ�����
        setlist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1, int pos,long id) 
			{
				setlist.setBackgroundColor(Color.LTGRAY); 
				parent.getItemAtPosition(pos); // ��ȡѡ�����ֵ
				setlist.setBackgroundColor(Color.parseColor("#00000000"));
				if(pos==0)//�����С���
				{
					// ���Ƶ������������  
					ClipboardManager cmb = (ClipboardManager)getActivity().getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);  
					ClipData myClip;
					myClip = ClipData.newPlainText("text", "http://www.cnblogs.com/threemonkey/");
					cmb.setPrimaryClip(myClip);
					
					Toast.makeText(getActivity().getApplicationContext(), "�Ѹ������ص�ַ�����ļ����壬ȥ����ɣ�", Toast.LENGTH_SHORT).show();
				}
				else if(pos==1)//��ϵ������
				{
					Intent intent=new Intent();//����Intent����
					intent.setClass(getActivity().getApplicationContext(), ConnectUs.class);//ָ�����ݶ���
					startActivity(intent);//��Intent���ݸ�Activity
					
				}
				else if(pos==2)//���汾����
				{
					Toast.makeText(getActivity().getApplicationContext(), ":) ������ʹ�����°汾��˯�ߺ���  Beta 0.9", Toast.LENGTH_SHORT).show();
				}
				else if(pos==3)//����˯�ߺ���
				{
					Intent intent=new Intent();//����Intent����
					intent.setClass(getActivity().getApplicationContext(), AboutUs.class);//ָ�����ݶ���
					startActivity(intent);//��Intent���ݸ�Activity
					
				}
				
			}

		});
        Intent intent=getActivity().getIntent();//���Intent

		return view;
		//return super.onCreateView(inflater, container, savedInstanceState);
		//return inflater.inflate(R.layout.set, null);
	}

	
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	getActivity().getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
/*    //�ٰ�һ���˳�����
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
    
	

	*/
}
