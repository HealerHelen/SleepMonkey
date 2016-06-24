package com.example.googlebottomfragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ListDateActivity extends Activity {

	private List<Fruit> fruitList = new ArrayList<Fruit>();
	Time t=new Time();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.rusult1list);
		initFruits();

		FruitAdapter adapter = new FruitAdapter(ListDateActivity.this,
				R.layout.fruit_item, fruitList);
		ListView listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Fruit fruit = fruitList.get(position);
				//Toast.makeText(MainActivity.this, fruit.getName(),
						//Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(ListDateActivity.this, Rday.class);
				intent.putExtra("tosub",position);
				startActivity(intent);
			}
		});
	}
//ÈÕÆÚ´óBUG
	private void initFruits() {
		t.setToNow();
		Fruit apple = new Fruit(t.year+"-"+(t.month+1)+"-"+t.monthDay, R.drawable.tbiao);
		fruitList.add(apple);
		Fruit banana = new Fruit(t.year+"-"+(t.month+1)+"-"+(t.monthDay-1), R.drawable.tbiao);
		fruitList.add(banana);
		Fruit orange = new Fruit(t.year+"-"+(t.month+1)+"-"+(t.monthDay-2), R.drawable.tbiao);
		fruitList.add(orange);
		Fruit watermelon = new Fruit(t.year+"-"+(t.month+1)+"-"+(t.monthDay-3), R.drawable.tbiao);
		fruitList.add(watermelon);
		Fruit pear = new Fruit(t.year+"-"+(t.month+1)+"-"+(t.monthDay-4), R.drawable.tbiao);
		fruitList.add(pear);
		Fruit grape = new Fruit(t.year+"-"+(t.month+1)+"-"+(t.monthDay-5), R.drawable.tbiao);
		fruitList.add(grape);
		Fruit pineapple = new Fruit(t.year+"-"+(t.month+1)+"-"+(t.monthDay-6), R.drawable.tbiao);
		fruitList.add(pineapple);
	
	}

}