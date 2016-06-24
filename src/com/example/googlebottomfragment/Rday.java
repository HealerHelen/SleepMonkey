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
		case 8:Pf=10;Pj1="       睡眠充足，请继续保持。";Pj2="       睡眠时间掌握的真棒！你要用充分的精力去奋斗~Fighting！！";break;
		case 7:Pf=8+((double)(keep%60))/60;Pj1="       睡眠时间达标，请继续保持。";Pj2="       健康从保证睡眠开始，合理饮食是重要的养生之道，运动则是保持旺盛生命力的源泉！￣O￣)ノ";break;
		case 6:Pf=6+((double)(keep%60))/60;Pj1="       睡眠时间一般，长时间下去将影响健康，请尽快改善睡眠。";Pj2="       健康从保证睡眠开始，合理饮食是重要的养生之道，运动则是保持旺盛生命力的源泉！￣O￣)ノ";break;
		case 5:Pf=5+((double)(keep%60))/60;Pj1="       睡眠时间较短，长时间下去将影响健康，请尽快改善睡眠。";Pj2="       深夜是身体各器官排毒疏泄的关键，在'对的'时间睡觉才能让你的身体和你一起休息。";break;
		case 4:Pf=3+((double)(keep%60))/60;Pj1="       睡眠时间过短，不利于工作与健康，请尽快补充睡眠。";Pj2="       深夜是身体各器官排毒疏泄的关键，在'对的'时间睡觉才能让你的身体和你一起休息。";break;
		case 3:Pf=2+((double)(keep%60))/60;Pj1="       睡眠严重不足，影响健康，请尽快补充睡眠。";Pj2="       长期熬夜等于慢性自杀啊，亲~ 身体是革命的本钱，不要等到身体透支放悔恨啊！";break;
		case 2:
		case 1:Pf=1+((double)(keep%60))/60;Pj1="       睡眠严重不足，极大影响健康，请尽快补充睡眠。";Pj2="       您这睡跟没睡有什么区别=_=…做事要讲究效率，有充足的睡眠才能精力充沛的工作哦~";break;
		case 0:Pf=0;Pj1="       ……人还是要睡觉的，你这么拼，家里人知道吗？";break;
		default:Pf=8;Pj1="       ……睡多了也不好，快起来high！";Pj2="       ……睡那么久是要干嘛(。﹏。*)…世界那么大，你应该去看看~";

		}
		cursor.moveToLast();
		PfText.setText(String.format("%.1f", Pf));
		PjText1.setText("       您从"+cursor.getInt(3)+"日"+cursor.getInt(4)+"时"+cursor.getInt(5)+"分开始睡眠，到"+cursor.getInt(8)+"日"+cursor.getInt(9)+"时"+cursor.getInt(10)+"分结束。");
		PjText2.setText("       睡眠时长"+cursor.getInt(12)/60+"小时"+cursor.getInt(12)%60+"分。");
		PjText3.setText(Pj1);
		PjText4.setText(Pj2);
		}
		else
			PjText3.setText("无记录。");
	}
}