package com.example.googlebottomfragment;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ResultFragment extends Fragment{
	private LinearLayout layout_chart ;
	private ChartView chartView ;
	private TextView Text2;
	private TextView Text1;
	private MyDataBase db = null;
	Time t=new Time();
	String Pj;
	int m=0;
	double sum=0;
	double Pf;
	double [] day7=new double[7];
	@Override
    public View onCreateView( LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.result, null);
		DisplayMetrics mDisplayMetrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);

		db = new MyDataBase(getActivity().getApplicationContext());
		Cursor cursor = db.ExecQuery("select * from Sleep");
		cursor.moveToLast();
		t.setToNow();

		for ( m = 0; m < 7; m++) {
			if(t.monthDay-m<=0)
			{
				if(t.month==4||t.month==6||t.month==9||t.month==11)
					if(cursor.getInt(8)==30+t.monthDay-m) break;
					else day7[6-m]=0;
				else
					if(cursor.getInt(8)==31+t.monthDay-m) break;
					else day7[6-m]=0;
			}
			else
			{
				if(cursor.getInt(8)==(t.monthDay-m)) break;
				else day7[6-m]=0;
				
			}

		}
		for(int i=6-m;i>=0;i--)
		{
			day7[i]=cursor.getInt(12);
			sum+=day7[i];
			if(!cursor.moveToPrevious()) break;
		}
		sum=sum/(7-m);
		layout_chart = (LinearLayout) view.findViewById(R.id.chartArea) ;
		chartView = new ChartView(getActivity().getApplicationContext(),day7,t.month+1,t.monthDay,mDisplayMetrics.widthPixels,mDisplayMetrics.heightPixels) ;
		layout_chart.removeAllViews();
		layout_chart.addView(chartView);
		Text1=(TextView)view.findViewById(R.id.awords);
		
		switch((int)(sum/60))
		{
		case 11:
		case 10:
		case 9:
		case 8:Pf=10;Pj="       ˯�߳��㣬��������֡�";break;
		case 7:Pf=8+((double)(sum%60))/60;Pj="      ˯��ʱ���꣬��������֡�";break;
		case 6:Pf=6+((double)(sum%60))/60;Pj="      ˯��ʱ��һ�㣬��ʱ����ȥ��Ӱ�콡�����뾡�����˯�ߡ�";break;
		case 5:Pf=5+((double)(sum%60))/60;Pj="      ˯��ʱ��϶̣���ʱ����ȥ��Ӱ�콡�����뾡�����˯�ߡ�";break;
		case 4:Pf=3+((double)(sum%60))/60;Pj="      ˯��ʱ����̣������ڹ����뽡�����뾡�첹��˯�ߡ�";break;
		case 3:Pf=2+((double)(sum%60))/60;Pj="      ˯�����ز��㣬Ӱ�콡�����뾡�첹��˯�ߡ�";break;
		case 2:
		case 1:Pf=1+((double)(sum%60))/60;Pj="      ˯�����ز��㣬����Ӱ�콡�����뾡�첹��˯�ߡ�";break;
		case 0:Pf=0;Pj="      �����˻���Ҫ˯���ģ�����ôƴ��������֪����";break;
		default:Pf=8;Pj="      ����˯����Ҳ���ã�������high��";
		}
		Text1.setText("      ��7����Чƽ��˯��ʱ��Ϊ"+(int)(sum/60)+"Сʱ"+((int)sum)%60+"�֡�\n"+Pj);
		Text2=(TextView)view.findViewById(R.id.bwords);
		Text2.setText(String.format("%.1f", Pf));
		Button button1 = (Button) view.findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity().getApplicationContext(), ListDateActivity.class);
				startActivity(intent);
				}
			});
		return view;
		}
	}