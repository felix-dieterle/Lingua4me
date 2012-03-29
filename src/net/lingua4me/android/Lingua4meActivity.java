package net.lingua4me.android;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
// TODO: Check where this jar comes from and so on..
public class Lingua4meActivity extends ListActivity implements OnClickListener {
	
	final String PREF_FIRST_START = "firstStart";
	
	PopupWindow pw_;
	SharedPreferences sharedPreferences = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
//        boolean firstStart = (savedInstanceState == null) || savedInstanceState.getBoolean("firstStart", true);
        super.onCreate(savedInstanceState);
        sharedPreferences = getApplicationContext().getSharedPreferences("l4m_prefs.txt", MODE_PRIVATE);
        Editor editor = sharedPreferences.edit();
        
        boolean firstStart = sharedPreferences.getBoolean(PREF_FIRST_START, true);

        initPlaylist();

        if(!firstStart) {
		    editor.putBoolean(PREF_FIRST_START, true);
        } else {
        	
        	showWelcomePopup();
        	
        		    
        	
//        	setContentView(R.layout.language_setting);
//        	System.out.println("no more  first start ");
    		    editor.putBoolean(PREF_FIRST_START, false);
        }
	    editor.commit();
    }

	private void showWelcomePopup() {
    	String locale = this.getApplicationContext().getResources().getConfiguration().locale.getDisplayName();
		LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View pview = inflater.inflate(R.layout.welcome, (ViewGroup) findViewById(R.layout.playlist_layout) );
	    final PopupWindow pw = new PopupWindow(pview, WindowManager.LayoutParams.WRAP_CONTENT, 
	    	WindowManager.LayoutParams.WRAP_CONTENT,  true);
	    pw_ = pw;
	    final View popupLayout = this.getListView(); 
	    Button welcomeButton = (Button) pview.findViewById(R.id.welcomeButton);
	    if(welcomeButton == null) {
	    	System.out.println("welcomeButton is null!!");
	    	Log.e("editor", "welcomeButton is null!!");
	    } else {  
	    	welcomeButton.setOnClickListener(this);
	    }
	    EditText langView = (EditText) pview.findViewById(R.id.defLangEdit);
	    langView.setText(locale);
	    popupLayout.post(new Runnable() {
    	   public void run() {
    	     pw.showAtLocation(popupLayout, Gravity.CENTER, 0, 0);
    	   }
	    });
	}

	private void initPlaylist() {
        System.out.println("First start ");
        Track[] tracks = new Track[3];
//        TODO: Load tracklist from Database or stored preferences or..  
        tracks[0] = new Track("Titel1", "..   ", "",  "chemins_de_vie");
        tracks[1] = new Track("Titel11", "..   ", "",  "chemins_de_vie");
        tracks[2] = new Track("Titel111", "..   ", "",  "chemins_de_vie");
        PlaylistAdapter adapter = new PlaylistAdapter(this, R.layout.playlist_layout, tracks);
        setListAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		if(v instanceof Button) {
			Log.i("Lingua4meAct..", "button clicked->closing!");
			pw_.dismiss();
			showLanguageSettings();
		}
		Log.i("Lingua4meAct..", "not a button?" + v.getClass().getSimpleName());
		System.out.println();
	}

	private void showLanguageSettings() {
//    	String[] langs = new String[3];
////	TODO: load the available languages from web server if network is available
////	 load the selected language from local settings. 
//	langs[0] = "Deutsch";
//	langs[1] = "English";
//	langs[2] = "Francais";
//	LanguageAdapter adapter = new LanguageAdapter(this, R.layout.language_setting, langs);
//	setListAdapter(adapter);
	}
}