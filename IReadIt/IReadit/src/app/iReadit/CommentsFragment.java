package app.iReadit;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import app.iReadit.data.CommentsJSON.Comments.Child;
import app.iReadit.data.CommentsJSON.Comments.Comment;
import app.iReadit.data.CommentsJSON.Comments.CommentsJSON;
import app.iReadit.data.CommentsJSON.Comments.Data;
import app.iReadit.data.CommentsJSON.Topic.Topic;
import app.iReadit.util.CommentDeserializer;
import app.iReadit.util.VolleySingleton;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment
 * must implement the {@link CommentsFragment.OnFragmentInteractionListener}
 * interface to handle interaction events. Use the
 * {@link CommentsFragment#newInstance} factory method to create an instance of
 * this fragment.
 *
 */
public class CommentsFragment extends ListFragment implements OnItemClickListener {

	private String topicURL;
	private Topic commentsTopic;
	private OnCommentsSelectedListener mListener;
	private CommentsListAdapter commentAdapter;

	private List<Comment> commentList = new ArrayList<Comment>();
	private ProgressDialog pDialog;
	public static final String VOLLEY_COMMENT_TAG = "commentFrag";
	private int indentNum = 0;

	private TextView author, domain, time, score, title, upvoted, selfText;

	public CommentsFragment(String topicURL) {
		this.topicURL = topicURL;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		commentAdapter = new CommentsListAdapter(getActivity(), R.layout.comments_list_adapter, 
												commentList, commentsTopic);
		
		
		
		return inflater.inflate(R.layout.fragment_comment_list, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		View headerView = (View) getActivity().getLayoutInflater().inflate(R.layout.comments_topic, null, false);
		this.getListView().addHeaderView(headerView);
		setListAdapter(commentAdapter);

		// Post Topic
		author = (TextView) getView().findViewById(R.id.topicAuthor);
		//domain = (TextView) getView().findViewById(R.id.topicDomain);
		time = (TextView) getView().findViewById(R.id.topicTime);
		score = (TextView) getView().findViewById(R.id.topicScore);
		title = (TextView) getView().findViewById(R.id.topicTitle);
		upvoted = (TextView) getView().findViewById(R.id.topicUpvoted);
		selfText = (TextView) getView().findViewById(R.id.topicSelfText);

		Log.d("TopicsFragment", "Topics Fragment Started");

		pDialog = new ProgressDialog(getActivity());
		pDialog.setMessage("Loading...");
		pDialog.show();

		// Adding request to request queue
		VolleySingleton.getInstance().addToRequestQueue(loadComments(topicURL), VOLLEY_COMMENT_TAG);

	}

	public void updateComments(String URL) {
		
		VolleySingleton.getInstance().addToRequestQueue(loadComments(URL), VOLLEY_COMMENT_TAG);
	}
	
	public JsonArrayRequest loadComments(String URL) {
		
		commentList.clear();
		commentAdapter.notifyDataSetChanged();

		JsonArrayRequest jsonArrayReq = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {

			@Override
			public void onResponse(JSONArray response) {
				Log.d(getActivity().getClass().toString(), response.toString());

				GsonBuilder gsonBuilder = new GsonBuilder();
				gsonBuilder.registerTypeAdapter(Comment.class, new CommentDeserializer()); //TODO: why doesn't this work?
				Gson gson = gsonBuilder.create();

				try {

				// Get and display the Topic of these Comments
					JSONObject dataTopic = (JSONObject) response.getJSONObject(0).get("data");
					JSONArray children = (JSONArray) dataTopic.get("children");
					JSONObject data2 = (JSONObject) children.get(0);

					commentsTopic = gson.fromJson(data2.get("data").toString(),
							app.iReadit.data.CommentsJSON.Topic.Topic.class);
					
					String date = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.CANADA).format(new Date(
							(long) commentsTopic.getCreated() * 1000));
					
					//TODO: Temp disable Topic
					author.setText(commentsTopic.getAuthor());
//					domain.setText(commentsTopic.getDomain());
					time.setText(date);
					score.setText(String.valueOf(commentsTopic.getScore()));
					title.setText(commentsTopic.getTitle());
					upvoted.setText(String.valueOf(commentsTopic.getUpvoteRatio()));
					selfText.setText(commentsTopic.getSelftext());


				// Get and display the comments
					JSONArray commentsJSON = (JSONArray) ((JSONObject) response.getJSONObject(1).get("data"))
							.get("children");
					Log.d(getActivity().getClass().toString(), commentsJSON.toString());

					Type listType = new TypeToken<ArrayList<Child>>() {}.getType(); //required for fromJson to work with List<Child>

					List<Child> commentsGSON = gson.fromJson(commentsJSON.toString(), listType);

					for (int i = 0; i < (commentsGSON.size()); i++) {

						displayComment(commentsGSON.get(i).getData());

					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					Log.d(this.getClass().getName(), "ERROR LOADING JSON");
					e.printStackTrace();
				}

				commentAdapter.notifyDataSetChanged();

				if (pDialog != null) {
					pDialog.hide();
				}

			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				VolleyLog.d("CommentsFragment", "Error: " + error.getMessage());
				// hide the progress dialog
        		if(pDialog != null) {
        			pDialog.cancel();
        		}

			}
		});
		return jsonArrayReq;

	}

	// Recursion to get all replies.
	// CommentJSON->Data->Child->Comment
	public void displayComment(Comment commentObject) {

		if (commentObject != null) {
			indentNum += 1;
			Comment comment = (Comment) commentObject;
			comment.setIndentation(indentNum);
			//commentList.add(comment);

			commentAdapter.add(comment);

			Log.d("Body Text", comment.getBody());

			if (comment.getReplies() != null) {

				CommentsJSON repliesJSON = comment.getReplies();
				Data repliesData = repliesJSON.getData();
				List<Child> repliesChildren = repliesData.getChildren();

				for (int i = 0; i < (repliesChildren.size()); i++) {
					displayComment(repliesChildren.get(i).getData());
				}

			}

			indentNum -= 1;
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnCommentsSelectedListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	@Override
	public void onDestroy() {
		
		 View portraitView = getActivity().findViewById(R.id.portraitContainer);
		 if (!(portraitView != null && (portraitView.getVisibility() == View.VISIBLE))) {
			 getActivity().findViewById(R.id.commentsContainer).setVisibility(View.GONE);
		 }
		 
		if (pDialog != null) {
			pDialog.cancel();
		}
		
		super.onDestroy();
		
		
	}

	// TODO: Change this name later
	public interface OnCommentsSelectedListener {
		// TODO: Update argument type and name
		public void onCommentsSelected(String URL);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub

	}

}
