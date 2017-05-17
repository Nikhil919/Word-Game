package com.example.wordgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
import android.widget.Toast;

public class FillBlanks extends Activity implements OnClickListener
{
	TextView t1 ;
	EditText e1 ;
	Button submit , next ;
	char[] word ;
	String temp="" , ar , a ;
	static int ct = 0 ;
	int l , k ;
	int r = 0 , al = 1 ;
	String category=" " ;
	DatabaseHandler db = new DatabaseHandler(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fill_blanks);
		
		Intent i = getIntent();
		category = i.getStringExtra("category");
		category = "where category=\'"+category+"\'" ;
		
		
		
		t1 = (TextView)findViewById(R.id.textView1);
		e1 = (EditText)findViewById(R.id.editText1);
		submit = (Button)findViewById(R.id.button1);
		next = (Button)findViewById(R.id.button2);

		showword();

		submit.setOnClickListener(this);
		next.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
		case R.id.button1 :
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
			
		case R.id.button2 :
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

		ar = db.getWord(category);
		word = ar.toCharArray();
		temp="";
		ct = 0 ;
		for(int i=0 ; i<word.length ; i++)
		{
			l = (int) (Math.random()*2);
			if(l==0&&ct<4)
			{
				temp = temp + "%";
				ct++ ;
			}
			else
			{
				temp = temp + word[i] ;
			}
		}
		t1.setText(temp);
		e1.setText("");
					
	}
}