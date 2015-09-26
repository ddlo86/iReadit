package app.iReadit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.graphics.Color;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.iReadit.data.TopicsJSON.Topic;

public class TopicsListAdapter extends ArrayAdapter<Topic>  {
	
	private int TITLE_MAX_LENGTH = 60;

	private List<Topic> redditTopics;

	public TopicsListAdapter(Context context, int textViewResourceId, List<Topic> topicList) {
		super(context, textViewResourceId);
		this.redditTopics = topicList;
	}
	
	public TopicsListAdapter(Context context, int textViewResourceId ) {
		super(context, textViewResourceId );
	}
	
	
	public void add() {
		
	}
	
	
	public View getView(int position, View convertView, ViewGroup parent){
		
		// assign the view we are converting to a local variable
		View v = convertView;

		// first check to see if the view is null. if so, we have to inflate it.
		// to inflate it basically means to render, or show, the view.
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			
			v = inflater.inflate(R.layout.topics_list_adapter, null);
			
			
		}

		/*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 * 
		 * Therefore, i refers to the current Item object.
		 */
		
		if (redditTopics != null) {
			
			// This is how you obtain a reference to the TextViews.
			// These TextViews are created in the XML files we defined.

			TextView title = (TextView) v.findViewById(R.id.textTitle);
			TextView author = (TextView) v.findViewById(R.id.textAuthor);
			TextView age = (TextView) v.findViewById(R.id.textAge);
			TextView score = (TextView) v.findViewById(R.id.textScore);
			TextView comments = (TextView) v.findViewById(R.id.textComment);
			ImageView up = (ImageView) v.findViewById(R.id.imageUpArrow);
			ImageView down = (ImageView) v.findViewById(R.id.imageDownArrow);
			ImageView sourceURL = (ImageView) v.findViewById(R.id.sourceURL);
			
			Topic entry = redditTopics.get(position);
			
			// TODO: check to see if each individual textview is null.
			// if not, assign some text
			if (entry.getTitle().length() > TITLE_MAX_LENGTH) {
				title.setText(entry.getTitle().substring(0, 59) + "..."); //TODO: vary length on screen size
			} else {
			title.setText(entry.getTitle());
			}
			//convert date from long to readable Date 
			age.setText(new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.CANADA).format(new Date(entry.getCreated()))); 
			author.setText("to r/" + entry.getSubreddit() + " by " + entry.getAuthor());

			comments.setText(String.valueOf(entry.getNumComments() + " Comments"));
			score.setText(String.valueOf(entry.getScore()));
			
			up.setVisibility(android.view.View.INVISIBLE); //for user implementation
			down.setVisibility(android.view.View.INVISIBLE); //for user implementation
			
			sourceURL.setImageResource(R.drawable.ic_launcher);
			
		}

		// the view must be returned to our activity
		return v;

	}
	

}
