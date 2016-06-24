package com.example.googlebottomfragment ;

import android.graphics.Canvas ;
import android.graphics.Paint ;

public class Chart {

	private int w = 30 ;
	private int h ;
	private int total_y = 800 ;
	private int x ;

	public Chart(int H,int W)
	{
		total_y=total_y*H/1920;
		w=w*W/1080;
	}
	
	public int getX() {
		return x ;
	}

	public void setX(int x) {
		this.x = x ;
	}

	public int getH() {
		return h ;
	}

	public void setH(int h) {
		this.h = h ;
	}

	public void drawSelf(Canvas canvas, Paint paint) {
		canvas.drawRect(x, total_y - h, w + x, total_y - 1, paint) ;
	}

}
