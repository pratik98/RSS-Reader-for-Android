package com.pratik.android.rss;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;




public class categories extends Activity {
	String i = "false";  
	String in;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       Button world = (Button)findViewById(R.id.world); 
       Button india = (Button)findViewById(R.id.india); 
       Button sports = (Button)findViewById(R.id.sports); 
       Button stock = (Button)findViewById(R.id.stock);
       Button savecat = (Button)findViewById(R.id.savecat);
       Button viewsaved = (Button)findViewById(R.id.viewsaved);
       Button quicknews = (Button)findViewById(R.id.quicknews);
    // set
		
       india.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			 
			Intent intent = new Intent(categories.this, AndroidRSSReader.class);
			
			intent.putExtra("com.pratik.android.rss.TYPE",5);
			startActivity(intent);
			
		}
		
	});
      
       world.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent(categories.this, AndroidRSSReader.class);
			intent.putExtra("com.pratik.android.rss.TYPE",6);
			startActivity(intent);
			
		}
	});
       sports.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent intent = new Intent(categories.this, AndroidRSSReader.class);
			intent.putExtra("com.pratik.android.rss.TYPE",7);
			startActivity(intent);
			
		}
	});
       stock.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(categories.this, AndroidRSSReader.class);
			intent.putExtra("com.pratik.android.rss.TYPE",8);
			startActivity(intent);
			
		}
	});
       savecat.setOnClickListener(new OnClickListener() {
	
		@Override
		public void onClick(View arg0) {
			
			Intent intent = new Intent(categories.this, AddCategory.class);
		startActivity(intent);
		}
	});
        
        quicknews.setOnClickListener(new OnClickListener() {
        	
    		@Override
    		public void onClick(View arg0) {
    			
    			Intent intent = new Intent(categories.this, quicknews.class);
    		startActivity(intent);
    		}
    	});
 viewsaved.setOnClickListener(new OnClickListener() {
        	
    		@Override
    		public void onClick(View arg0) {
    			
    			Intent intent = new Intent(categories.this, ViewSavedCats.class);
    		startActivity(intent);
    		}
    	});
		
        	
        
    }
}