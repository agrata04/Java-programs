package com.camerapro;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView mDisplay;
	  Uri mVideo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDisplay=(TextView) findViewById(R.id.eDisplay);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void onButtonClick(View v) {
	      Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	      try {
	        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.parse("file:///sdcard/Download/ba3tpCamera.jpg"));
	        startActivity(intent);
	      } catch (Exception e) {
	        display(e);
	      }
	    }
	    
	    public void onVideoClick(View v) {
	      Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
	      try {
	        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT,10); // Limit to 10 seconds
	        startActivityForResult(intent,99);
	      } catch (Exception e) {
	        display(e);
	      }
	    }

	    public void onPlayClick(View v) {
	      if (mVideo==null) display("Nothing recorded.");
	      else {
	        Intent intent = new Intent(Intent.ACTION_VIEW);
	        intent.setData(mVideo);
	        startActivity(intent);
	      }  
	    }
	    
	    @Override
	    public void onActivityResult(int requestCode, int resultCode, Intent data) {
	      if (requestCode==99) {
	        display(data.getData());
	        mVideo = data.getData();
	      }
	    }
	    // Show a message on the screen
	    public void display(Object msg) {
	      mDisplay.setText(msg!=null ? msg.toString(): "null");
	    }
	    
	    // Add a line to the existing message
	    public void addln(Object msg) {
	      String s=(String) mDisplay.getText();
	      if (s.equals("")) s=msg.toString();
	      else s+="\n"+msg.toString();
	      mDisplay.setText(s);
	    }
	}



