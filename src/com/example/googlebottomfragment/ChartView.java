package com.example.googlebottomfragment ;

import android.R.color;
import android.content.Context ;
import android.graphics.Canvas ;
import android.graphics.Color ;
import android.graphics.Paint ;
import android.view.View ;

public class ChartView extends View {

	private static double[] data_total ;
	private int margin ;

	private Chart chart ;
	private Paint paint ;
	int month=0;
	int day=0;
	int W=1;
	int H=1;
	public ChartView(Context context,double[] data,int month,int day,int W,int H) {
		super(context) ;
		margin = 0 ;
		chart = new Chart(H,W) ;

		//data_total = new double[] {5,5.5,6,6.5,7,7.5,8};
		data_total = data;
		this.month=month;
		this.day=day;
		this.W=W;
		this.H=H;
		paint = new Paint() ;
		paint.setAntiAlias(true) ;
	}

	public void drawAxis(Canvas canvas) {

		paint.setStrokeWidth(2) ;
		paint.setTextSize(32);
		paint.setColor(Color.WHITE) ;
		canvas.drawLine(160*W/1080, 800*H/1920, 1000*W/1080, 800*H/1920, paint) ;
		canvas.drawLine(990*W/1080, 790*H/1920, 1000*W/1080, 800*H/1920, paint) ;
		canvas.drawLine(990*W/1080, 810*H/1920, 1000*W/1080, 800*H/1920, paint) ;
		canvas.drawLine(160*W/1080, 200*H/1920, 160*W/1080, 800*H/1920, paint) ;
		canvas.drawLine(160*W/1080, 200*H/1920, 150*W/1080, 210*H/1920, paint) ;
		canvas.drawLine(160*W/1080, 200*H/1920, 170*W/1080, 210*H/1920, paint) ;
		int x = 200*W/1080 ;
		int y = 760*H/1920 ;


		for (int i = 0; i < 7; i++) {
			if(day+i-6<0)
			{
				if(month==4||month==6||month==9||month==11)
					canvas.drawText(day+i+24 + "ÈÕ", x, 840*H/1920, paint) ;
				else
					canvas.drawText(day+i+25 + "ÈÕ", x, 840*H/1920, paint) ;
			}
			else
			canvas.drawText(day+i-6 + "ÈÕ", x, 840*H/1920, paint) ;
			x += 120*W/1080 ;
		}
		for (int i = 0; i < 10; i++) {
			canvas.drawText( (i + 1) + "", 100*W/1080, y, paint) ;
			y -= 60*H/1920 ;
		}
		paint.setColor(Color.GRAY) ;
		y=690*H/1920;
		for(int i=0;i<9;i++){
			canvas.drawLine(162*W/1080, y, 1000*W/1080, y, paint) ;
			y-=60*H/1920;
		}
	}

	public void drawChart(Canvas canvas) {
			paint.setColor(Color.CYAN) ;
			int temp = 130 ;
			for (int i = 0; i < 7; i++) {
				chart.setH((int)(data_total[i]-10)*H/1920 );
				chart.setX((temp + 40*2  + margin)*W/1080) ;
				chart.drawSelf(canvas, paint) ;
				margin = 40 ;
				temp = chart.getX() ;
			}
	}

	@Override
	public void onDraw(Canvas canvas) {
		canvas.drawColor(Color.TRANSPARENT) ;
		drawAxis(canvas) ;
		drawChart(canvas) ;
	}
}
