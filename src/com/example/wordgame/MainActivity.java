package com.example.wordgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener
{
	Button b1 , b2 ;
	DatabaseHandler db = new DatabaseHandler(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		db.addWord("banana","Fruits and Vegetables");
		db.addWord("apple","Fruits and Vegetables");
		db.addWord("pineapple","Fruits and Vegetables");
		db.addWord("orange","Fruits and Vegetables");
		db.addWord("onion","Fruits and Vegetables");
		db.addWord("grapes","Fruits and Vegetables");
		db.addWord("mangoes","Fruits and Vegetables");
		db.addWord("coconut","Fruits and Vegetables");
		db.addWord("tomato","Fruits and Vegetables");
		db.addWord("brinjal","Fruits and Vegetables");
		db.addWord("chilli","Fruits and Vegetables");
		db.addWord("cucumber","Fruits and Vegetables");
		db.addWord("beetroot","Fruits and Vegetables");
		db.addWord("carrot","Fruits and Vegetables");
		db.addWord("cabbage","Fruits and Vegetables");
		db.addWord("cauliflower","Fruits and Vegetables");
		db.addWord("mushroom","Fruits and Vegetables");
		db.addWord("potato","Fruits and Vegetables");
		db.addWord("pumpkin","Fruits and Vegetables");
		db.addWord("radish","Fruits and Vegetables");
		db.addWord("jackfruit","Fruits and Vegetables");
		db.addWord("lemon","Fruits and Vegetables");
		db.addWord("papaya","Fruits and Vegetables");
		db.addWord("peach","Fruits and Vegetables");
		db.addWord("pomegrante","Fruits and Vegetables");
		db.addWord("watermelon","Fruits and Vegetables");
		db.addWord("date","Fruits and Vegetables");
		db.addWord("blueberry","Fruits and Vegetables");
		
		db.addWord("lion","Animals");
		db.addWord("tiger","Animals");
		db.addWord("horse","Animals");
		db.addWord("bear","Animals");
		db.addWord("elephant","Animals");
		db.addWord("alligator","Animals");
		db.addWord("camel","Animals");
		db.addWord("cheetah","Animals");
		db.addWord("crocodile","Animals");
		db.addWord("chimpanzee","Animals");
		db.addWord("cow","Animals");
		db.addWord("dog","Animals");
		db.addWord("fox","Animals");
		db.addWord("giraffe","Animals");
		db.addWord("hippopotamus","Animals");
		db.addWord("kangaroo","Animals");
		db.addWord("monkey","Animals");
		db.addWord("panda","Animals");
		db.addWord("zebra","Animals");
		db.addWord("wolf","Animals");
		
		db.addWord("BMW","Cars");
		db.addWord("Audi","Cars");
		db.addWord("bagatti","Cars");
		db.addWord("chevrolet","Cars");
		db.addWord("ferrari","Cars");
		db.addWord("ford","Cars");
		db.addWord("fiat","Cars");
		db.addWord("honda","Cars");
		db.addWord("hyundai","Cars");
		db.addWord("infiniti","Cars");
		db.addWord("jaguar","Cars");
		db.addWord("lexus","Cars");
		db.addWord("lamborghini","Cars");
		db.addWord("koenigsegg","Cars");
		db.addWord("mazda","Cars");
		db.addWord("mercedes","Cars");
		db.addWord("mitsubishi","Cars");
		db.addWord("nissan","Cars");
		db.addWord("tata","Cars");
		db.addWord("toyota","Cars");
		db.addWord("volvo","Cars");
		db.addWord("volkswagen","Cars");
		db.addWord("porsche","Cars");
		db.addWord("renault","Cars");
		db.addWord("rolls royce","Cars");
		
		db.addWord("india","Countries");
		db.addWord("pakistan","Countries");
		db.addWord("afganistan","Countries");
		db.addWord("argentina","Countries");
		db.addWord("australia","Countries");
		db.addWord("bangladesh","Countries");
		db.addWord("belgium","Countries");
		db.addWord("brazil","Countries");
		db.addWord("bolivia","Countries");
		db.addWord("bhutan","Countries");
		db.addWord("canada","Countries");
		db.addWord("america","Countries");
		db.addWord("china","Countries");
		db.addWord("denmark","Countries");
		db.addWord("cuba","Countries");
		db.addWord("finland","Countries");
		db.addWord("france","Countries");
		db.addWord("ghana","Countries");
		db.addWord("germany","Countries");
		db.addWord("greenland","Countries");
		db.addWord("hungary","Countries");
		db.addWord("iceland","Countries");
		db.addWord("italy","Countries");
		db.addWord("indonesia","Countries");
		db.addWord("japan","Countries");
		db.addWord("korea","Countries");
		db.addWord("macau","Countries");
		db.addWord("mexico","Countries");
		db.addWord("norway","Countries");
		db.addWord("oman","Countries");
		db.addWord("poland","Countries");
		db.addWord("russia","Countries");
		db.addWord("singapore","Countries");
		db.addWord("switzerland","Countries");
		db.addWord("sweden","Countries");
		db.addWord("thailand","Countries");
		db.addWord("turkey","Countries");
		db.addWord("vietnam","Countries");
		db.addWord("yemen","Countries");
		db.addWord("zimbabwe","Countries");
		db.addWord("zambia","Countries");
		
		b1 = (Button)findViewById(R.id.button1);
		b2 = (Button)findViewById(R.id.Button01);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) 
	{

		Intent ii = new Intent(this,Category.class);
		switch(v.getId())
		{
		case R.id.button1 :
			ii.putExtra("game",1);
			break ;
			
		case R.id.Button01 :
			ii.putExtra("game",2);
		}
		startActivity(ii);
	}
}