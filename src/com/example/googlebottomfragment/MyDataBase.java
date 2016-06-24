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
	// ���� *********************************************************************
	public static String mstrDataBaseName = "mydb.db";
	public static int mintDataBaseVersion = 1;
	
	private SQLiteDatabase db = null;
	
	// ���� *********************************************************************
	// ����
	public MyDataBase(Context context)
	{
		super(context,mstrDataBaseName,null,mintDataBaseVersion);
		
		db = getWritableDatabase();
	}
	
	// ִ�д��� ���� ɾ�� ���µȲ���
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
	
	// ִ�в�ѯ
	public Cursor ExecQuery(String strSql)
	{
		return db.rawQuery(strSql, null);
	}
	
	// �������ݿ�
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// TODO Auto-generated method stub
		
	}
	
	// �������ݿ�
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// TODO Auto-generated method stub
		
	}
	
	// ��ȡ���ݿ�·��
	public String GetDBPath()
	{
		return db.getPath();
	}
	
}
