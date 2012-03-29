package net.lingua4me.android;

public class Track {

	public Track(String _title, String _provider, String _creationTime, String _iconUri) {
		this.title = _title;
		this.provider = _provider;
		this.creationTime = _creationTime;
		this.iconName = _iconUri;
	}
	public String title = "";
	public String provider = "";
	public String creationTime = "";
	public String iconName = ""; 
}
