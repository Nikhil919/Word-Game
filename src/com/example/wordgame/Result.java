package com.example.wordgame;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Result extends Activity implements OnClickListener
{	
	TextView score , total ;
	Button b1 ;
	int all , right ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		score = (TextView)findViewById(R.id.textView2);
		total = (TextView)findViewById(R.id.textView3);
		
		Intent ii = getIntent();
		all = ii.getIntExtra("all",0);
		right = ii.getIntExtra("r",0);
		
		score.setText("No. of correct answer is : "+right);
		total.setText("Total no. of question : "+all);
		
		b1 = (Button)findViewById(R.id.button1);
		b1.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) 
	{
		Intent ii = new Intent(this,MainActivity.class);
		startActivity(ii);
	}
}
