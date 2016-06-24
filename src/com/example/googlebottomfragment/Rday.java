package com.example.googlebottomfragment;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Window;
import android.widget.TextView;

public class Rday extends Activity {
	private MyDataBase db = null;
	private TextView PfText = null;
	private TextView PjText1 = null;
	private TextView PjText2= null;
	private TextView PjText3= null;
	private TextView PjText4= null;
	String strSQL="";
	Time t=new Time();
	int sub=0;
	int keep=0;
	String Pj1,Pj2;
	double Pf;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.result2day);
		sub=getIntent().getIntExtra("tosub", 0);
		PfText = (TextView)findViewById(R.id.pingf);
		PjText1=(TextView)findViewById(R.id.pingj1);
		PjText2=(TextView)findViewById(R.id.pingj2);
		PjText3=(TextView)findViewById(R.id.pingj3);
		PjText4=(TextView)findViewById(R.id.pingj4);
		t.setToNow();
		strSQL = "select * from Sleep where Spday ="+(t.monthDay-sub);
		db = new MyDataBase(this);
		Cursor cursor = db.ExecQuery(strSQL);
	//	cursor.moveToFirst();
		
		if(cursor.getCount()!=0)
		{
			cursor.moveToFirst();
			keep+=cursor.getInt(12);
			while(cursor.moveToNext())
			{
				keep+=cursor.getInt(12);
			}
		
		PjText3.setText(""+keep);
		switch(keep/60)
		{
		case 11:
		case 10:
		case 9:
		case 8:Pf=10;Pj1="       ˯�߳��㣬��������֡�";Pj2="       ˯��ʱ�����յ��������Ҫ�ó�ֵľ���ȥ�ܶ�~Fighting����";break;
		case 7:Pf=8+((double)(keep%60))/60;Pj1="       ˯��ʱ���꣬��������֡�";Pj2="       �����ӱ�֤˯�߿�ʼ��������ʳ����Ҫ������֮�����˶����Ǳ�����ʢ��������ԴȪ����O��)��";break;
		case 6:Pf=6+((double)(keep%60))/60;Pj1="       ˯��ʱ��һ�㣬��ʱ����ȥ��Ӱ�콡�����뾡�����˯�ߡ�";Pj2="       �����ӱ�֤˯�߿�ʼ��������ʳ����Ҫ������֮�����˶����Ǳ�����ʢ��������ԴȪ����O��)��";break;
		case 5:Pf=5+((double)(keep%60))/60;Pj1="       ˯��ʱ��϶̣���ʱ����ȥ��Ӱ�콡�����뾡�����˯�ߡ�";Pj2="       ��ҹ������������Ŷ���й�Ĺؼ�����'�Ե�'ʱ��˯������������������һ����Ϣ��";break;
		case 4:Pf=3+((double)(keep%60))/60;Pj1="       ˯��ʱ����̣������ڹ����뽡�����뾡�첹��˯�ߡ�";Pj2="       ��ҹ������������Ŷ���й�Ĺؼ�����'�Ե�'ʱ��˯������������������һ����Ϣ��";break;
		case 3:Pf=2+((double)(keep%60))/60;Pj1="       ˯�����ز��㣬Ӱ�콡�����뾡�첹��˯�ߡ�";Pj2="       ���ڰ�ҹ����������ɱ������~ �����Ǹ����ı�Ǯ����Ҫ�ȵ�����͸֧�Żںް���";break;
		case 2:
		case 1:Pf=1+((double)(keep%60))/60;Pj1="       ˯�����ز��㣬����Ӱ�콡�����뾡�첹��˯�ߡ�";Pj2="       ����˯��û˯��ʲô����=_=������Ҫ����Ч�ʣ��г����˯�߲��ܾ�������Ĺ���Ŷ~";break;
		case 0:Pf=0;Pj1="       �����˻���Ҫ˯���ģ�����ôƴ��������֪����";break;
		default:Pf=8;Pj1="       ����˯����Ҳ���ã�������high��";Pj2="       ����˯��ô����Ҫ����(���n��*)��������ô����Ӧ��ȥ����~";

		}
		cursor.moveToLast();
		PfText.setText(String.format("%.1f", Pf));
		PjText1.setText("       ����"+cursor.getInt(3)+"��"+cursor.getInt(4)+"ʱ"+cursor.getInt(5)+"�ֿ�ʼ˯�ߣ���"+cursor.getInt(8)+"��"+cursor.getInt(9)+"ʱ"+cursor.getInt(10)+"�ֽ�����");
		PjText2.setText("       ˯��ʱ��"+cursor.getInt(12)/60+"Сʱ"+cursor.getInt(12)%60+"�֡�");
		PjText3.setText(Pj1);
		PjText4.setText(Pj2);
		}
		else
			PjText3.setText("�޼�¼��");
	}
}