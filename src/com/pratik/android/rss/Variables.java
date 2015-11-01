package com.pratik.android.rss;

public interface Variables {
	
	String world ="http://timesofindia.feedsportal.com/c/33039/f/533917/index.rss";
	String india ="http://timesofindia.feedsportal.com/c/33039/f/533916/index.rss";
	String sports ="http://www.espnstar.com/headlines-rss/";
	String politics ="http://economictimes.feedsportal.com/c/33041/f/534036/index.rss";
	String business ="http://timesofindia.feedsportal.com/c/33039/f/533919/index.rss";
	String stock ="http://economictimes.feedsportal.com/c/33041/f/534037/index.rss";
	String enterten ="http://timesofindia.feedsportal.com/c/33039/f/533928/index.rss";
	String tech ="http://economictimes.indiatimes.com/rssfeeds/40274504.cms";
	
	public String get_world();
	public String get_india();
	public String get_sports();
	public String get_politics();
	public String get_business();
	public String get_stock();
	public String get_enterten();
	public String get_tech();

}
