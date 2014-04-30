package com.heaven1;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.ImageSwitcher;

public class MainActivity extends Activity {
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	/*final	VideoView v1 = (VideoView)findViewById(R.id.videoView1);
	v1.setClickable(true);
		
		Button b =(Button)findViewById(R.id.button1);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				try{
					
					
					
					
					MediaPlayer mp = new MediaPlayer();
				
					mp.setDataSource("video.flv");
					mp.prepare();
					mp.start();
					
					
					
				}catch(Exception e)
				{
					
				}
				
			}
		});
		*/
		
		
		final ImageSwitcher img = (ImageSwitcher)findViewById(R.id.imageSwitcher1);
		img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				//int c = img.getChildCount();
				if(img.isPressed())
				{
					
					Drawable d = new BitmapDrawable(getResources(),"b2.png");
				 img.setImageDrawable(d);	
			
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
