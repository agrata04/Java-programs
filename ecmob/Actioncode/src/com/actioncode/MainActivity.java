package com.actioncode;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar ab = getActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		CreateMenu(menu);
		return true;
	}
	
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		
		return MenuChoice(item);
		
	}
	
	public void CreateMenu(Menu menu)
	{
		MenuItem m1 = menu.add(0,0,0,"Agrata");
		{
			m1.setAlphabeticShortcut('a');
			menu.addSubMenu("Agrata shukla");
		}
		
		
		MenuItem m2 = menu.add(0,1,1,"Chipra");
		
		{
			m2.setAlphabeticShortcut('b');
		}
	}
	
	public boolean MenuChoice(MenuItem item)
	{
	    int id = item.getItemId();
	    
	    switch(id)
	    {
	    case 0:
	    	Toast.makeText(this, "Hi,Agrata", 
	                Toast.LENGTH_LONG).show();
	    	break;
	    case 1:
	    	Toast.makeText(this, "Hi,Chipra", 
	                Toast.LENGTH_LONG).show();
	    break;
	    
	    	
	    }
		return false;
		
	}

}
