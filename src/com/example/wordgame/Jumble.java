package com.example.wordgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Jumble extends Activity implements OnClickListener
{
	TextView t1 ;
	EditText e1 ;
	Button submit , next ;
	char[] word ;
	String ar , a ;
	int l , t , k ;
	int r = 0 , al = 1 ;
	String category="" ;
	DatabaseHandler db = new DatabaseHandler(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jumble);

		Intent i = getIntent();
		category = i.getStringExtra("category");
		category = "where category=\'"+category+"\'" ;
		
		
		t1 = (TextView)findViewById(R.id.textView2);
		e1 = (EditText)findViewById(R.id.editText1);
		submit = (Button)findViewById(R.id.button2);
		next = (Button)findViewById(R.id.button1);

		showword();

		submit.setOnClickListener(this);
		next.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
		case R.id.button2 :
			a = e1.getText().toString().toLowerCase();
			
			if(a.equals(ar))
			{
				r++ ;
			}
			Intent ii = new Intent(this,Result.class);
			ii.putExtra("all",al);
			ii.putExtra("r",r);
			startActivity(ii);
			
			break ;
			
		case R.id.button1 :
			a = e1.getText().toString().toLowerCase();
			
			if(a.equals(ar))
			{
				r++ ;
			}
			al++ ;
			showword();
		}
	}
	
	public void showword()
	{

		char ch ;
		String x ;
		ar = db.getWord(category);
		word = ar.toCharArray();
		for(int i=0 ; i<word.length ; i++)
		{
			l = (int) (Math.random()*word.length);
			t = (int) (Math.random()*word.length);
			ch = word[l];
			word[l] = word[t];
			word[t] = ch ;
		}
		x = new String(word);
		t1.setText(x);
		e1.setText("");
					
	}
}
