package net.lingua4me.android;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LanguageAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] languages;

	public LanguageAdapter(Context context, int layout, String[] values) {
		super(context, R.layout.playlist_layout, new String[values.length]);
		this.context = context;
		this.languages = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context 
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.language_setting, parent, false);
		TextView langNameView = (TextView) rowView.findViewById(R.id.langName);
		langNameView.setText(languages[position]);
		return rowView;
	}
}