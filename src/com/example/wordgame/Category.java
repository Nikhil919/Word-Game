package com.example.wordgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Category extends Activity
{
	ListView list ;
	String[] category={"Animals","Fruits and Vegetables","Countries","Cars"} ;
	Intent i ;
	int x ;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		
		i = getIntent();
		x = i.getIntExtra("game",0);
		
		list = (ListView)findViewById(R.id.listView1);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,category);
		
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener(){
			public void onItemClick(AdapterView<?> args , View view ,int position , long id)
			{
				Log.d("Category",category[position]);
				
				showGameActivity(position);
				
			}
			
		});
		
	}
	
	public void showGameActivity(int position)
	{
		if(x==1)
		{
			Intent i1 = new Intent(this,FillBlanks.class);
			i1.putExtra("category",category[position]);
			startActivity(i1);
		}
		if(x==2)
		{
			Intent i1 = new Intent(this,Jumble.class);
			i1.putExtra("category",category[position]);
			startActivity(i1);
		}
	}
}
