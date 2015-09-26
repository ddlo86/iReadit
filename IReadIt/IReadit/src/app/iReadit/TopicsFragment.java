package app.iReadit;

import java.util.ArrayList;
import java.util.List;





import org.json.JSONObject;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson; 

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import app.iReadit.data.TopicsJSON.Topic;
import app.iReadit.data.TopicsJSON.TopicsJSON;
import app.iReadit.util.VolleySingleton;


public class TopicsFragment extends ListFragment implements OnItemClickListener, OnScrollListener {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

	// TODO: Rename and change types of parameters
	//TODO: Make number of topics per page modular(more or less than 5) and let them shift
	
	//TODO: Do I have too many method-scope variables here?
	String tag_json_obj = "json_obj_req";
	
	private OnTopicSelectedListener mListener;
	
	private ListView entriesList;
	private int topicsPosition = 0;
	private List<Topic> topicList = new ArrayList<Topic>();
	private TopicsListAdapter topicAdapter;
	private ProgressDialog pDialog;
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;
    private Topic topicJSON;
    private TopicsJSON redditJSON;
    
    private ViewConfiguration vc;
//    private int SWIPE_MIN_DISTANCE;
//    private int SWIPE_THRESHOLD_VELOCITY;
//    private int SWIPE_MAX_OFF_PATH;
    
    final static String DEFAULT_URL = "http://www.reddit.com/.json";
    
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("TopicsFragment", "Topics Fragment Started");
		
		Bundle bundle = this.getArguments();
		String url = bundle.getString("url", DEFAULT_URL);
        pDialog = new ProgressDialog(getActivity());
		pDialog.setMessage("Loading...");
		pDialog.show();     
		         
		// Adding request to request queue
		VolleySingleton.getInstance().addToRequestQueue(loadNewPage(url), tag_json_obj);

	}
	
	public JsonObjectRequest loadNewPage(String URL) {
		
		topicsPosition = 0;
		
		JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
                URL, null,
                new Response.Listener<JSONObject>() {
 
                    @Override
                    public void onResponse(JSONObject response) {
                        
                        
                        redditJSON = new Gson().fromJson(response.toString(), TopicsJSON.class);


                        
                        for (int i = 0; i < (redditJSON.getData().getChildren().size() - 1); i++) {
                        	
        					topicsPosition++;
        					topicJSON = redditJSON.getData().getChildren().get(topicsPosition).getData(); //25 index!!!!!!!!!!!!!!!!!!

        					topicList.add(topicJSON);
        					topicAdapter.add(topicJSON);
        				}
                        

                        topicAdapter.notifyDataSetChanged();
                		if(pDialog != null) {
                			pDialog.cancel();
                		}
                        
                        
                        
                    }
                }, new Response.ErrorListener() {
 
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("TopicsFragment", "Error: " + error.getMessage());
                        // hide the progress dialog
                		if(pDialog != null) {
                			pDialog.cancel();
                		}
                       
                    }
                });
		return jsonObjReq;
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		

		View view = inflater.inflate(R.layout.fragment_topic_list, null, false);		
		
		entriesList = (ListView) view.findViewById(android.R.id.list);
		
		//Set Gesture variables
        vc = ViewConfiguration.get(getActivity());
//        SWIPE_MIN_DISTANCE = vc.getScaledPagingTouchSlop();
//        SWIPE_THRESHOLD_VELOCITY = vc.getScaledMinimumFlingVelocity();
//        SWIPE_MAX_OFF_PATH = vc.getScaledTouchSlop();

		
        topicAdapter = new TopicsListAdapter(getActivity(), R.layout.topics_list_adapter, topicList );
        setListAdapter(topicAdapter);
        
		//Gesture Detection
        //gestureDetector = new GestureDetector(getActivity(), new MyGestureDetector());
        
        
        //TODO: Perform onClick instead onTouch
//        gestureListener = new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                return gestureDetector.onTouchEvent(event);
//            }
//        };

		return view;
	}
	
	@Override
	public void onViewCreated(View v, Bundle savedInstanceState) {

		super.onViewCreated(v, savedInstanceState);
		
		//entriesList.setOnItemClickListener(TopicsFragment.this); //TopicsFragment.this
		getListView().setOnScrollListener(this);
		getListView().setOnItemClickListener(this);
        entriesList.setOnTouchListener(gestureListener);  
	  
	}
	
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {}
	
	private boolean loading = true;
	private int previousTotal = 0;
	
	@Override
	public void onScroll(AbsListView lw, final int firstVisibleItem,
	                 final int visibleItemCount, final int totalItemCount) {

        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
            }
        }
		
		if (!loading && ((totalItemCount - visibleItemCount) <= (firstVisibleItem + 5))) {
			topicsPosition = 0;
			loading = true;
			VolleySingleton.getInstance().addToRequestQueue(loadNewPage("http://www.reddit.com/r/DotA2/.json?count=25&after=t3_2o27mf"), tag_json_obj);
			
		}
	    }
	
	//Left/Right gesture detection
	
//    class MyGestureDetector extends SimpleOnGestureListener {
//        @Override
//        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//            try {
//                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
//                    return false;
//                // right to left swipe
//                if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
//                	Log.d("TopicsFragment", "swiped Left");
//                	//nextTopics();
//                }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
//                    Log.d("TopicsFragment", "swiped Right");
//                }
//            } catch (Exception e) {
//                // nothing
//            }
//            return false;
//        }
//
//            @Override
//        public boolean onDown(MotionEvent e) {
//              return true;
//        }
//    }

	@Override
	public void onResume() {
		super.onResume();
	}
	
	// TODO: Rename method, update argument and hook method into UI event

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnTopicSelectedListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if(pDialog != null) {
			pDialog.cancel();
		} 
	}
	
	
	@Override
	public void onStop() {
		super.onStop();
		if(pDialog != null) {
			pDialog.cancel();
		} 
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if(pDialog != null) {
			pDialog.cancel();
		} 
	}
	


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		//TODO: Create a display entry class

		mListener.onTopicSelected("http://www.reddit.com" + topicList.get(position).getPermalink() + ".json");

	}
	
    public interface OnTopicSelectedListener {
        public void onTopicSelected(String url);
    }
	
}
