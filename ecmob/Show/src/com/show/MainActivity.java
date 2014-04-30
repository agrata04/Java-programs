package com.show;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button b = (Button)findViewById(R.id.button1);
		final TextView tv = (TextView)findViewById(R.id.textView1);
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try{
				ContentResolver cur = getContentResolver();
				Cursor cr = cur.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
				//String name = cr.getString(cr.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				
				if(cr.getCount()>0)
				{
					String name = cr.getString(cr.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				tv.setText(name);
				}
				else
				{
					tv.setText("No data");
				}
			}catch(Exception e)
			{
				tv.setText(e.getMessage());
			}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
