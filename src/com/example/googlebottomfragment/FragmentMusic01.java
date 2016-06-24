package com.example.googlebottomfragment;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentMusic01 extends Fragment {

	private MediaPlayer mp,mp01,mp02,mp03,mp04,mp05;//mediaPlayer对象
	private ImageButton play,play01,play02,play03,play05,play04,pause,stop;//播放 暂停/继续 停止 按钮
	private LinearLayout setTime;
	private ImageView hint;//显示当前音乐图片
	private Button Ds;
	private TextView hint1,tv;//显示当前音乐介绍
	private boolean isPause=false;//是否暂停
	public long zong1=15*60*1000,zong2=30*60*1000,zong3=60*60*1000;//时常
//	private long shengyu;
	public MyCountDownTimer mc;
    public long shengyu=zong1;  
    private ImageButton Dao15,Dao30,Dao60;
	int running=-1;
	boolean flagvi=false;
	@Override   
    public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.music, null);

		mc = new MyCountDownTimer(shengyu, 1000);
		Ds=(Button)view.findViewById(R.id.button4);
		
		setTime=(LinearLayout)view.findViewById(R.id.settime);
		setTime.setVisibility(View.GONE);
		play=(ImageButton) view.findViewById(R.id.ImageButton1);
		
		play01=(ImageButton) view.findViewById(R.id.ImageButton01);
		
		play02=(ImageButton) view.findViewById(R.id.ImageButton04);
		
		play03=(ImageButton) view.findViewById(R.id.ImageButton07);
		play04=(ImageButton) view.findViewById(R.id.ImageButton10);
		play05=(ImageButton) view.findViewById(R.id.ImageButton13);
		play.setBackgroundResource(R.drawable.bf);
		play01.setBackgroundResource(R.drawable.bf);
		play02.setBackgroundResource(R.drawable.bf);
		play03.setBackgroundResource(R.drawable.bf);
		play04.setBackgroundResource(R.drawable.bf);
		play05.setBackgroundResource(R.drawable.bf);
		pause=(ImageButton) view.findViewById(R.id.ImageButton2);
		stop=(ImageButton) view.findViewById(R.id.ImageButton3);
//		hint=(TextView) findViewById(R.id.hint);
//		hint.setTextSize(20);
		
		
		tv = (TextView) view.findViewById(R.id.show);     
		mc = new MyCountDownTimer(shengyu, 1000); 

		hint=(ImageView) view.findViewById(R.id.hint);
		hint1=(TextView) view.findViewById(R.id.hint1);
		
		mp=MediaPlayer.create(getActivity().getApplicationContext(), R.raw.clwm);//创建mediaplayer对象
		mp01=MediaPlayer.create(getActivity().getApplicationContext(), R.raw.slnm);//创建mediaplayer对象
		mp02=MediaPlayer.create(getActivity().getApplicationContext(), R.raw.nngh);//创建mediaplayer对象
		mp03=MediaPlayer.create(getActivity().getApplicationContext(), R.raw.xfhl);//创建mediaplayer对象
		mp04=MediaPlayer.create(getActivity().getApplicationContext(), R.raw.sjqc);//创建mediaplayer对象
		mp05=MediaPlayer.create(getActivity().getApplicationContext(), R.raw.yzly);//创建mediaplayer对象
		//////////////////////////////////////////////////////////////////
       Dao15=(ImageButton) view.findViewById(R.id.button1);
       Dao30=(ImageButton) view.findViewById(R.id.button2);
       Dao60=(ImageButton) view.findViewById(R.id.button3);
       Ds.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
/*				if(setTime.VISIBLE==View.VISIBLE)
				{
					setTime.setVisibility(View.GONE);
					Ds.setText("设置定时");
				}
				else if(setTime.VISIBLE==View.GONE)
				{*/
				if(!flagvi)
				{
				setTime.setVisibility(View.VISIBLE);
				Ds.setText("取消更改");
				flagvi=true;
				}
				else
				{
					setTime.setVisibility(View.GONE);
					Ds.setText("设置定时");
					flagvi=false;
				}

//				}

			}
		});	
		////*************************丛林蛙鸣*****************************//////////////
		//为mediaplayer对象添加完成时间监听器，用于当音乐播放完毕后重新开始播放音乐
				mp.setOnCompletionListener(new OnCompletionListener() {
					
					@Override
					public void onCompletion(MediaPlayer arg0) {
						// TODO Auto-generated method stub
						play();//重新开始播放
					}
				});
				
			//为播放按钮添加单击事件监听器
				play.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						switch(running)
						{
						case 0:mp.pause();play.setBackgroundResource(R.drawable.bf);running=-1;break;
						case 1:mp01.pause();play01.setBackgroundResource(R.drawable.bf);play.setBackgroundResource(R.drawable.zt);play();running=0;break;
						case 2:mp02.pause();play02.setBackgroundResource(R.drawable.bf);play.setBackgroundResource(R.drawable.zt);play();running=0;break;
						case 3:mp03.pause();play03.setBackgroundResource(R.drawable.bf);play.setBackgroundResource(R.drawable.zt);play();running=0;break;
						case 4:mp04.pause();play04.setBackgroundResource(R.drawable.bf);play.setBackgroundResource(R.drawable.zt);play();running=0;break;
						case 5:mp05.pause();play05.setBackgroundResource(R.drawable.bf);play.setBackgroundResource(R.drawable.zt);play();running=0;break;
						case -1:play.setBackgroundResource(R.drawable.zt);play();running=0;mc.start();break;
						}
						if(isPause) {mc.start();isPause=false;}


/*						if(isPause){
							//pause.setText("暂停");
							isPause=false;
						}*/
					}
				});
				

				//为暂停按钮添加单击事件监听器
				pause.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						if(isPause){

						}else{
							
							//pause.setText("暂停");
							//hint.setText("继续播放丛林蛙鸣...");
							play.setBackgroundResource(R.drawable.bf);
							play01.setBackgroundResource(R.drawable.bf);
							play02.setBackgroundResource(R.drawable.bf);
							play03.setBackgroundResource(R.drawable.bf);
							play04.setBackgroundResource(R.drawable.bf);
							play05.setBackgroundResource(R.drawable.bf);
							running=-1;
							isPause=true;
							mc.cancel();
							mp.stop();
							mp01.stop();
							mp02.stop();
							mp03.stop();
							mp04.stop();
							mp05.stop(); 
							mc = new MyCountDownTimer(shengyu, 1000); 
						}							
						

					}
				});
				
				//为停止按钮添加单击事件监听器

				stop.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						mc.onFinish();
						mc.cancel();
					}
				});
			////*********************森林鸟鸣********************************//////////////
				//为mediaplayer对象添加完成时间监听器，用于当音乐播放完毕后重新开始播放音乐
				mp01.setOnCompletionListener(new OnCompletionListener() {
					
					@Override
					public void onCompletion(MediaPlayer arg0) {
						// TODO Auto-generated method stub
						play01();//重新开始播放
					}
				});
				
			//为播放按钮添加单击事件监听器
				play01.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						switch(running)
						{
						case 0:mp.pause();play.setBackgroundResource(R.drawable.bf);play01.setBackgroundResource(R.drawable.zt);play01();running=1;break;
						case 1:mp01.pause();play01.setBackgroundResource(R.drawable.bf);running=-1;break;
						case 2:mp02.pause();play02.setBackgroundResource(R.drawable.bf);play01.setBackgroundResource(R.drawable.zt);play01();running=1;break;
						case 3:mp03.pause();play03.setBackgroundResource(R.drawable.bf);play01.setBackgroundResource(R.drawable.zt);play01();running=1;break;
						case 4:mp04.pause();play04.setBackgroundResource(R.drawable.bf);play01.setBackgroundResource(R.drawable.zt);play01();running=1;break;
						case 5:mp05.pause();play05.setBackgroundResource(R.drawable.bf);play01.setBackgroundResource(R.drawable.zt);play01();running=1;break;
						case -1:play01.setBackgroundResource(R.drawable.zt);play01();running=1;mc.start();break;
						}
						if(isPause) {mc.start();isPause=false;}

					}
				});

			////********************暖暖篝火************************************//////////////
				//为mediaplayer对象添加完成时间监听器，用于当音乐播放完毕后重新开始播放音乐
				mp02.setOnCompletionListener(new OnCompletionListener() {
					
					@Override
					public void onCompletion(MediaPlayer arg0) {
						// TODO Auto-generated method stub
						play02();//重新开始播放
					}
				});
				
			//为播放按钮添加单击事件监听器
				play02.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						switch(running)
						{
						case 0:mp.pause();play.setBackgroundResource(R.drawable.bf);play02.setBackgroundResource(R.drawable.zt);play02();running=2;break;
						case 1:mp01.pause();play01.setBackgroundResource(R.drawable.bf);play02.setBackgroundResource(R.drawable.zt);play02();running=2;break;
						case 2:mp02.pause();play02.setBackgroundResource(R.drawable.bf);running=-1;break;
						case 3:mp03.pause();play03.setBackgroundResource(R.drawable.bf);play02.setBackgroundResource(R.drawable.zt);play02();running=2;break;
						case 4:mp04.pause();play04.setBackgroundResource(R.drawable.bf);play02.setBackgroundResource(R.drawable.zt);play02();running=2;break;
						case 5:mp05.pause();play05.setBackgroundResource(R.drawable.bf);play02.setBackgroundResource(R.drawable.zt);play02();running=2;break;
						case -1:play02.setBackgroundResource(R.drawable.zt);play02();running=2;mc.start();break;
						}
						if(isPause) {mc.start();isPause=false;}

					}
				});
				

			////*******************细风海浪***********************************//////////////
				//为mediaplayer对象添加完成时间监听器，用于当音乐播放完毕后重新开始播放音乐
				mp03.setOnCompletionListener(new OnCompletionListener() {
					
					@Override
					public void onCompletion(MediaPlayer arg0) {
						// TODO Auto-generated method stub
						play03();//重新开始播放
					}
				});
				
			//为播放按钮添加单击事件监听器
				play03.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						switch(running)
						{
						case 0:mp.pause();play.setBackgroundResource(R.drawable.bf);play03.setBackgroundResource(R.drawable.zt);play03();running=3;break;
						case 1:mp01.pause();play01.setBackgroundResource(R.drawable.bf);play03.setBackgroundResource(R.drawable.zt);play03();running=3;break;
						case 2:mp02.pause();play02.setBackgroundResource(R.drawable.bf);play03.setBackgroundResource(R.drawable.zt);play03();running=3;break;
						case 3:mp03.pause();play03.setBackgroundResource(R.drawable.bf);running=-1;break;
						case 4:mp04.pause();play04.setBackgroundResource(R.drawable.bf);play03.setBackgroundResource(R.drawable.zt);play03();running=3;break;
						case 5:mp05.pause();play05.setBackgroundResource(R.drawable.bf);play03.setBackgroundResource(R.drawable.zt);play03();running=3;break;
						case -1:play03.setBackgroundResource(R.drawable.zt);play03();running=3;mc.start();break;
						}
						if(isPause) {mc.start();isPause=false;}

					}
				});

			////**********************四季清晨*******************************/////////////	
				//为mediaplayer对象添加完成时间监听器，用于当音乐播放完毕后重新开始播放音乐
				mp04.setOnCompletionListener(new OnCompletionListener() {
					
					@Override
					public void onCompletion(MediaPlayer arg0) {
						// TODO Auto-generated method stub
						play04();//重新开始播放
					}
				});
				
			//为播放按钮添加单击事件监听器
				play04.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						switch(running)
						{
						case 0:mp.pause();play.setBackgroundResource(R.drawable.bf);play04.setBackgroundResource(R.drawable.zt);play04();running=4;break;
						case 1:mp01.pause();play01.setBackgroundResource(R.drawable.bf);play04.setBackgroundResource(R.drawable.zt);play04();running=4;break;
						case 2:mp02.pause();play02.setBackgroundResource(R.drawable.bf);play04.setBackgroundResource(R.drawable.zt);play04();running=4;break;
						case 3:mp03.pause();play03.setBackgroundResource(R.drawable.bf);play04.setBackgroundResource(R.drawable.zt);play04();running=4;break;
						case 4:mp04.pause();play04.setBackgroundResource(R.drawable.bf);running=-1;break;
						case 5:mp05.pause();play05.setBackgroundResource(R.drawable.bf);play04.setBackgroundResource(R.drawable.zt);play04();running=4;break;
						case -1:play04.setBackgroundResource(R.drawable.zt);play04();running=4;mc.start();break;
						}
						if(isPause) {mc.start();isPause=false;}

					}
				});
				
		
//			////**********************雨之涟漪**********************************//////////////
				//为mediaplayer对象添加完成时间监听器，用于当音乐播放完毕后重新开始播放音乐
				mp05.setOnCompletionListener(new OnCompletionListener() {
					
					@Override
					public void onCompletion(MediaPlayer arg0) {
						// TODO Auto-generated method stub
						play05();//重新开始播放
					}
				});
				
			//为播放按钮添加单击事件监听器
				play05.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						switch(running)
						{
						case 0:mp.pause();play.setBackgroundResource(R.drawable.bf);play05.setBackgroundResource(R.drawable.zt);play05();running=5;break;
						case 1:mp01.pause();play01.setBackgroundResource(R.drawable.bf);play05.setBackgroundResource(R.drawable.zt);play05();running=5;break;
						case 2:mp02.pause();play02.setBackgroundResource(R.drawable.bf);play05.setBackgroundResource(R.drawable.zt);play05();running=5;break;
						case 3:mp03.pause();play03.setBackgroundResource(R.drawable.bf);play05.setBackgroundResource(R.drawable.zt);play05();running=5;break;
						case 4:mp04.pause();play04.setBackgroundResource(R.drawable.bf);play05.setBackgroundResource(R.drawable.zt);play05();running=5;break;
						case 5:mp05.pause();play05.setBackgroundResource(R.drawable.bf);running=-1;break;
						case -1:play05.setBackgroundResource(R.drawable.zt);play05();running=5;mc.start();break;
						}
						if(isPause) {mc.start();isPause=false;}
					}
				});
				
//			////**************************************************************//////////////
				Dao15.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					shengyu=15*60*1000;
					mc.cancel();
					mc=new MyCountDownTimer(15*60*1000, 1000);
					setTime.setVisibility(View.GONE);
					tv.setText("计时15分钟");
				}
			});	
				Dao30.setOnClickListener(new OnClickListener() {
					
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					shengyu=30*60*1000;
					mc.cancel();
					mc=new MyCountDownTimer(30*60*1000, 1000);
					setTime.setVisibility(View.GONE);
					tv.setText("计时30分钟");
				}
			});	
				Dao60.setOnClickListener(new OnClickListener() {
					
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					shengyu=60*60*1000;
					mc.cancel();
					mc=new MyCountDownTimer(60*60*1000, 1000);
					setTime.setVisibility(View.GONE);
					tv.setText("计时60分钟");
				}
			});	
				
				return view;
				
			////**************************************************************//////////////
	}
	//编写用于播放音乐的无返回值的play()方法。
	//在该方法中首先调用mediaplayer对象的reset()方法重置mediaplayer对象，
	//然后重新为其设置要播放的音频文件。
	//最后调用start()方法开始播放音频
///////////////////////////////////////////////////////
	
public class MyCountDownTimer extends CountDownTimer {     
	/**      *      * @param millisInFuture      *      表示以毫秒为单位 倒计时的总数      *      *      例如 millisInFuture=1000 表示1秒      *      * @param countDownInterval      *      表示 间隔 多少微秒 调用一次 onTick 方法      *      *      例如: countDownInterval =1000 ; 表示每1000毫秒调用一次onTick()      *      */    
	public MyCountDownTimer(long millisInFuture, long countDownInterval) {       
	super(millisInFuture, countDownInterval);     
	}       
	@Override   
	public void onFinish() {       
		tv.setText("done");   
		mp.stop();
		mp01.stop();
		mp02.stop();
		mp03.stop();
		mp04.stop();
		mp05.stop(); 
	}       
	@Override    
	public void onTick(long millisUntilFinished) {       
	//	Log.i("getActivity()", millisUntilFinished + "");       
		tv.setText("剩余" + millisUntilFinished / (60*1000) + "分"+(millisUntilFinished % (60*1000))/1000+"秒");
		shengyu=millisUntilFinished;
	}
}
/////////////////////////////////////////////////////////////////////////
//////////////////////////////


/*public void myClick1(View view)
{
	mc.cancel();
	mc = new MyCountDownTimer(zong1, 1000);
	mc.start();
	
}
public void myClick2(View view)
{
	mc.cancel();
	mc = new MyCountDownTimer(zong2, 1000);
	mc.start();
}
public void myClick3(View view)
{
	
	mc.cancel();
	mc = new MyCountDownTimer(zong3, 1000);
	mc.start();
}*/
/////////////////////////////////
	private void play(){
		try{
			mp.reset();
			mp=MediaPlayer.create(getActivity().getApplicationContext(), R.raw.clwm);//重新设置要播放的音频
			mp.setLooping(true);//循环
			mp.start();//开始播放
			hint1.setText("\t夜间静谧的丛林中\n \t传来阵阵蛙鸣︿\n \t请闭上眼睛～_～zZ\n \t感受它的声音...");
			hint.setImageResource(R.drawable.wm);


		}catch(Exception e){
			e.printStackTrace();//输出异常信息
		}		
	}
////**********************森林鸟鸣*********************************//////////////
	private void play01(){
		try{
			mp01.reset();
			mp01=MediaPlayer.create(getActivity().getApplicationContext(), R.raw.slnm);//重新设置要播放的音频
			mp01.setLooping(true);//循环
			mp01.start();//开始播放
			hint1.setText("\t这是一片静谧的森林\n \t请在这里\n \t歇一歇脚(oﾟvﾟ)ノ\n \t听着悦耳的鸟鸣\n \t这些\n \t将会帮你进入梦乡...");
			hint.setImageResource(R.drawable.nm);


		}catch(Exception e){
			e.printStackTrace();//输出异常信息
		}		
	}
////**********************暖暖篝火********************************//////////////
	private void play02(){
		try{
			mp02.reset();
			mp02=MediaPlayer.create(getActivity().getApplicationContext(), R.raw.nngh);//重新设置要播放的音频
			mp02.setLooping(true);//循环
			mp02.start();//开始播放
			hint1.setText("\t夜里有些寒冷\n \t请闭上眼睛(‾◡◝)\n \t感受暖流\n \t它将带给你\n \t温暖的回忆...");
			hint.setImageResource(R.drawable.gh);


		}catch(Exception e){
			e.printStackTrace();//输出异常信息
		}		
	}
////******************细风海浪************************************//////////////
	private void play03(){
		try{
			mp03.reset();
			mp03=MediaPlayer.create(getActivity().getApplicationContext(), R.raw.xfhl);//重新设置要播放的音频
			mp03.setLooping(true);//循环
			mp03.start();//开始播放
			hint1.setText("\t现在海面平静￣︶￣↗\n \t请闭上眼睛\n \t聆听远处的海浪声\n \t它将为您消除疲劳\n \t进入梦乡...");
			hint.setImageResource(R.drawable.hl);


		}catch(Exception e){
			e.printStackTrace();//输出异常信息
		}		
	}
//////**********************四季清晨********************************//////////////
	private void play04(){
		try{
			mp04.reset();
			mp04=MediaPlayer.create(getActivity().getApplicationContext(), R.raw.sjqc);//重新设置要播放的音频
			mp04.setLooping(true);//循环
			mp04.start();//开始播放
			hint1.setText("\t天还未破晓\n \t也许你还需要\n \t睡个懒觉(￣▽￣) . z Z\n \t请聆听四季的清晨\n \t它将带给你 一个好梦...");
			hint.setImageResource(R.drawable.qc);

		}catch(Exception e){
			e.printStackTrace();//输出异常信息
		}		
	}
//////*********************雨之涟漪***********************************//////////////
	private void play05(){
		try{
			mp05.reset();
			mp05=MediaPlayer.create(getActivity().getApplicationContext(), R.raw.yzly);//重新设置要播放的音频
			mp05.setLooping(true);//循环
			mp05.start();//开始播放
			hint1.setText("\t窗外的小雨\n \t淅淅沥沥的下着(ˇˍˇ)\n \t请你安心的聆听雨声\n \t你将会有一个好梦...");
			hint.setImageResource(R.drawable.ly);

		}catch(Exception e){
			e.printStackTrace();//输出异常信息
		}		
	}
//////**************************************************************//////////////
	
////*************************destroy们↓***************************//////////////
	public void onDestroy() {
		// TODO Auto-generated method stub
		if(mp.isPlaying()){
			mp.stop();
		}
		mp.release();//释放资源
		super.onDestroy();
	}
	protected void onDestroy01() {
		// TODO Auto-generated method stub
		if(mp01.isPlaying()){
			mp01.stop();
		}
		mp01.release();//释放资源
		super.onDestroy();
	}
	protected void onDestroy02() {
		// TODO Auto-generated method stub
		if(mp02.isPlaying()){
			mp02.stop();
		}
		mp02.release();//释放资源
		super.onDestroy();
	}
	protected void onDestroy03() {
		// TODO Auto-generated method stub
		if(mp03.isPlaying()){
			mp03.stop();
		}
		mp03.release();//释放资源
		super.onDestroy();
	}
	protected void onDestroy04() {
		// TODO Auto-generated method stub
		if(mp04.isPlaying()){
			mp04.stop();
		}
		mp04.release();//释放资源
		super.onDestroy();
	}

	protected void onDestroy05() {
		// TODO Auto-generated method stub
		if(mp05.isPlaying()){
			mp05.stop();
		}
		mp05.release();//释放资源
		super.onDestroy();
	}
	
////*************************destroy们↑***************************//////////////
	
}
