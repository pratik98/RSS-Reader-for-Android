package com.pratik.android.rss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Start extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Thread logotimer = new Thread(){
        	public void run(){
        	try
        	{
        		int logotimer = 0;
        		while(logotimer<2000){
        			sleep(100);
        			logotimer = logotimer + 100;
        		}
        		startActivity(new Intent("com.pratik.android.rss.CLEARSCREEN"));
        	} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	finally{
        		finish();
        	}
        	
        	}
    };
    logotimer.start();
}
}