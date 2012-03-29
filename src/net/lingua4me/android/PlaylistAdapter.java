package net.lingua4me.android;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaylistAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final Track[] tracks;

	public PlaylistAdapter(Context context, int layout, Track[] values) {
//		FIXME: does this work or do we need a real string array? 
		super(context, R.layout.playlist_layout, new String[values.length]);
		this.context = context;
		this.tracks = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context 
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.playlist_layout, parent, false);
		TextView titleView = (TextView) rowView.findViewById(R.id.soundTitle);
		TextView providerView = (TextView) rowView.findViewById(R.id.soundProvider);
		TextView creationTimeView = (TextView) rowView.findViewById(R.id.soundCreationTime);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
//		titleView.setText(tracks[position]);
		// Change the icon for Windows and iPhone
		String iconName = tracks[position].iconName;
		iconName = "chemins_de_vie";
		int imageResource = 0;
		imageResource = getContext().getResources().getIdentifier(iconName, "drawable", "net.lingua4me.android");
		if(imageResource != 0) {
			Drawable image = getContext().getResources().getDrawable(imageResource);
			imageView.setImageDrawable(image);
		} else
			System.out.println("Resource '" + iconName + "' not found! Using default image");
		return rowView;
	}
}