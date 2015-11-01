package com.pratik.android.rss;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class quicknews extends Activity {

	String feedUrl;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addsite);
		
		// get textview from our layout.xml
		final TextView rssURLTV = (TextView) findViewById(R.id.rssURL);

		// get button from layout.xml
		Button fetchRss = (Button) findViewById(R.id.fetchRss);

		// define the action that will be executed when the button is clicked.
		fetchRss.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				 
				// feedUrl = rssURLTV.getText().toString();
				feedUrl = rssURLTV.getText().toString();
				Intent intent = new Intent(quicknews.this, AndroidRSSReader.class);
				intent.putExtra("com.pratik.android.rss.URL", rssURLTV.getText().toString());
				startActivity(intent);
				
			}
		});

		
		
	}
	

}
