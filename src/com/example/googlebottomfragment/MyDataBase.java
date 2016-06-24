package com.example.googlebottomfragment;

import android.R.string;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBase extends SQLiteOpenHelper
{
	// 变量 *********************************************************************
	public static String mstrDataBaseName = "mydb.db";
	public static int mintDataBaseVersion = 1;
	
	private SQLiteDatabase db = null;
	
	// 函数 *********************************************************************
	// 构造
	public MyDataBase(Context context)
	{
		super(context,mstrDataBaseName,null,mintDataBaseVersion);
		
		db = getWritableDatabase();
	}
	
	// 执行创建 插入 删除 更新等操作
	public Boolean ExecSql(String strSql)
	{
		try
		{
			db.execSQL(strSql);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	// 执行查询
	public Cursor ExecQuery(String strSql)
	{
		return db.rawQuery(strSql, null);
	}
	
	// 创建数据库
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// TODO Auto-generated method stub
		
	}
	
	// 升级数据库
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// TODO Auto-generated method stub
		
	}
	
	// 获取数据库路径
	public String GetDBPath()
	{
		return db.getPath();
	}
	
}
