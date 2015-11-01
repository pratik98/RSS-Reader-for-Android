package com.pratik.android.rss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class News extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feeds);
        Intent intent = new Intent(News.this, AndroidRSSReader.class);
		startActivity(intent);
	}
}
