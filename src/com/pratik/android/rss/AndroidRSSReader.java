package com.pratik.android.rss;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class AndroidRSSReader extends Activity {

	String feedUrl;
	String gotUrl;
	int cat ;
	public static RssItem selectedRssItem = null;
	ListView rssListView = null;
	
	ArrayList<RssItem> rssItems = new ArrayList<RssItem>();
	ArrayAdapter<RssItem> aa = null;
	ProgressDialog dialog; 
	public static final int RssItemDialog = 1;
	// get
	
	
	
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feeds);
		
		Intent callingIntent = getIntent();
		 cat = callingIntent.getIntExtra("com.pratik.android.rss.TYPE", 1);
		 gotUrl = callingIntent.getStringExtra("com.pratik.android.rss.URL");
			
			
		// get textview from our layout.xml
		//final TextView rssURLTV = (TextView) findViewById(R.id.rssURL);

		// get button from layout.xml
		Button fetchRss = (Button) findViewById(R.id.fetchRss);
		

		// define the action that will be executed when the button is clicked.
		fetchRss.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				 
				//feedUrl = rssURLTV.getText().toString();
				
				if(cat == 5)
				{
					feedUrl ="http://timesofindia.feedsportal.com/c/33039/f/533916/index.rss";
				}
				else if(cat == 6)
				{
					feedUrl ="http://timesofindia.feedsportal.com/c/33039/f/533917/index.rss";
				}
				else if(cat == 7)
				{
					feedUrl ="http://www.espnstar.com/headlines-rss/";
				}
				else if(cat == 8)
				{
					feedUrl ="http://economictimes.feedsportal.com/c/33041/f/534037/index.rss";
				}
				else
				{
					feedUrl = gotUrl;
				}
				if(feedUrl == "")
				{
					Toast.makeText(AndroidRSSReader.this, "The category is ", Toast.LENGTH_LONG).show();
				}
				else{
				}
				refressRssList();

			}
		});
		
		// get the listview from layout.xml
		rssListView = (ListView) findViewById(R.id.rssListView);
		// here we specify what to execute when individual list items clicked
		rssListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> av, View view, int index,
					long arg3) {
				selectedRssItem = rssItems.get(index);

				// we call the other activity that shows a single rss item in
				// one page
				Intent intent = new Intent(
						"com.pratik.android.rss.displayRssItem");
				startActivity(intent);
			}
		});

		aa = new ArrayAdapter<RssItem>(this, R.layout.list_item, rssItems);
		rssListView.setAdapter(aa);

		refressRssList();
	}

	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		// TODO Auto-generated method stub
		switch (id) {
		case RssItemDialog: {
			LayoutInflater li = LayoutInflater.from(this);
			View rssDetails = li.inflate(R.layout.rss_details, null);

			AlertDialog.Builder rssDialog = new AlertDialog.Builder(this);
			rssDialog.setTitle("Rss Item");
			rssDialog.setView(rssDetails);

			return rssDialog.create();
		}
		}

		return null;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		// TODO Auto-generated method stub
		switch (id) {
		case RssItemDialog: {
			AlertDialog rssDialog = (AlertDialog) dialog;

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd - hh:mm:ss");
			rssDialog.setTitle(selectedRssItem.getTitle() + " : "
					+ sdf.format(selectedRssItem.getPubDate()));

			String text = selectedRssItem.getDescription() + " : "
					+ selectedRssItem.getLink();

			TextView tv = (TextView)findViewById(R.id.rssDetailsTextView);
			tv.setText(text);

		}
		}
	}

	private void refressRssList() {
		

		
		ArrayList<RssItem> newItems = RssItem.getRssItems(feedUrl);

		rssItems.clear();
		rssItems.addAll(newItems);

		aa.notifyDataSetChanged();
	}




	

}