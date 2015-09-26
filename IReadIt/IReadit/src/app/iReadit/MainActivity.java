package app.iReadit;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;




@SuppressLint("ClickableViewAccessibility")
public class MainActivity extends AppCompatActivity implements TopicsFragment.OnTopicSelectedListener,
	CommentsFragment.OnCommentsSelectedListener {

	
	private String url = "http://www.reddit.com/r/.json";
	EditText urlInput;
	MenuItem logIn;
	boolean isDualPane;
	private TopicsFragment topicsFragment;
	private CommentsFragment commentsFragment;
	final static String REDDIT_URL = "http://www.reddit.com/r/";
	final static String JSON_PREFIX = ".json";
	final String DEBUG_TAG = "Intro Activity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//TODO: Industry Standard Coding for dual pane.
//		 View portraitView = findViewById(R.id.portraitContainer);
//	     isDualPane = !(portraitView != null && (portraitView.getVisibility() == View.VISIBLE));
		
		Configuration config = getResources().getConfiguration();
       if (config.smallestScreenWidthDp >= 600) {
           isDualPane = true;
       } else {
           isDualPane = false;
       }
       
	     Log.d("app.iReadit", "is Dual Pane: " + isDualPane);
	     
		if (savedInstanceState == null) {
			setSubReddit(url);
		}

	}
	
	public void setSubReddit(String subRedditURL) {
		
		
		topicsFragment = new TopicsFragment();
		Bundle bundle = new Bundle();
		bundle.putString("url", subRedditURL);
		Log.d(this.getClass().getName(), bundle.getString("url"));
		topicsFragment.setArguments(bundle);
		
		final FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction(); 
		fTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		
		if(isDualPane) {
	        Log.d("app.iReadit", "Application is Dual Pane");
	        fTransaction.replace(R.id.topicsContainer, topicsFragment );
		} else {
			
			fTransaction.replace(R.id.portraitContainer, topicsFragment);
		}
		
		fTransaction.commit();
		
	}
	

	@Override
	public void onTopicSelected(String topicURL) {
		
			Log.v("MainActivity", "URL selected is: " + topicURL);
			CommentsFragment commentContainer = (CommentsFragment) getSupportFragmentManager().findFragmentById(R.id.commentsContainer);
		    	
			if(commentContainer == null) {
			    
				
	        	FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction(); 
		        fTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		        commentsFragment = new CommentsFragment(topicURL);
		        
				if (isDualPane) {
					findViewById(R.id.commentsContainer).setVisibility(View.VISIBLE);
					fTransaction.replace(R.id.commentsContainer, commentsFragment);
				    
				} else {
			    	fTransaction.replace(R.id.portraitContainer, commentsFragment);
			    }
			    fTransaction.addToBackStack(null);
			    fTransaction.show(commentsFragment);
				fTransaction.commit();
			} else {
				commentsFragment.updateComments(topicURL);
			}
	}
	
	@Override
	public void onCommentsSelected(String URL) {
		//TODO: User Comment interaction implementation
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity, menu);
	    MenuItem menuSearch = menu.findItem(R.id.action_searching);
	    SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuSearch);
	    
	    final SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {


	    	@Override
	        public boolean onQueryTextChange(String newText) {
	        //inherited required method    
	            return true;
	        }

	        @Override
	        public boolean onQueryTextSubmit(String query) {
	            
	        	url = REDDIT_URL + query + JSON_PREFIX;
	        	Log.d(this.getClass().getName(), "Going to Subreddit: " + url);
	        	setSubReddit(url);
	            return true;
	        }
	    };

	    searchView.setOnQueryTextListener(queryTextListener);
	    return super.onCreateOptionsMenu(menu);
	}
	
}


//TODO: Add close menu option.
//
//@Override
//public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//    inflater.inflate(R.menu.menu_layout, menu);
//    MenuItem add = menu.getItem(0);
//    //Set the show as action value here at runtime
//    MenuItemCompat.setShowAsAction(add, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
//}
