package com.pratik.android.rss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewSavedCats extends Activity {

	private Button addbutton;
	private TextView catlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.savedcats);
		setupviews();
	}

	private void setupviews() {
		addbutton = (Button)findViewById(R.id.add_button);
		catlist = (TextView)findViewById(R.id.cat_list_text);
		addbutton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ViewSavedCats.this,AddCategory.class);
				startActivity(intent);
			}
		});
		
	}

	
}
