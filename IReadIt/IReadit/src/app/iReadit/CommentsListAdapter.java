package app.iReadit;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.iReadit.data.CommentsJSON.Comments.Comment;
import app.iReadit.data.CommentsJSON.Topic.Topic;


//TODO: Develop for comments
public class CommentsListAdapter extends BaseAdapter  {

	
	private List<Comment> commentList;
	private final int INDENT_SPACE =  20;
	private LayoutInflater mInflater;
	private Context context;
	private Topic commentTopic;
	
	public CommentsListAdapter(Context context, int textViewResourceId, List<Comment> commentList, Topic commentTopic) {
		super();
		this.context = context;
		this.commentList = commentList;
		this.commentTopic = commentTopic;
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	
	@Override
	public int getCount() {
		return commentList.size();
	}

	@Override
	public Comment getItem(int position) {
		return commentList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	public void add(Comment comment) {
		commentList.add(comment);
	}

	//TODO: Investigate RecyclerView update (Android L)
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
		
		CommentViewHolder holder;
		
		// assign the view we are converting to a local variable
		View v = convertView;

		// first check to see if the view is null. if so, we have to inflate it.
		// to inflate it basically means to render, or show, the view.
		if (v == null) {
			//ayoutInflater inflater = LayoutInflater.from(context);
			v = mInflater.inflate(R.layout.comments_list_adapter, parent, false);
			
			holder = new CommentViewHolder();
			holder.body = (TextView) v.findViewById(R.id.commentSelfText); //body or selftext?
			holder.author = (TextView) v.findViewById(R.id.commentUser);
			holder.score = (TextView) v.findViewById(R.id.commentScore);
			holder.time = (TextView) v.findViewById(R.id.commentTime);
			
		} else {
			holder = (CommentViewHolder) v.getTag();
		}
		
		v.setTag(holder);

		if (commentList != null) {
			
			Comment comment = commentList.get(position);
			
			v.setPadding(INDENT_SPACE*comment.getIndentation(), 0, 0, 0);

			String date = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.CANADA).format(new Date((long)comment.getCreated() * 1000));

			holder.score.setText(String.valueOf(comment.getScore())); //Score is Int
			holder.time.setText(date);
			holder.body.setText(comment.getBody());
			holder.author.setText(comment.getAuthor());
			
		} 

		return v;

	}

	//TODO: Encapsulation and public?
	static class CommentViewHolder {
		
		public TextView body, author, score, time;
		
	}
	

}
