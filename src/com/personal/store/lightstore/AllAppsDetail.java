/**
 * 
 */
package com.personal.store.lightstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;

/**
 * @author wei.ren
 *
 */
public class AllAppsDetail extends Fragment {
	
	private String TAG = FragNavigation.class.getName();
    private SimpleAdapter adapter;
    
	private String[] value = new String[] {"SanGuoSha", "222", "333", "444", "555", "666", "777", "888", "999", "1000", "1001", "1002", "1003"};
	private int image = R.drawable.ic_example_app;
    private GridView gridview;
    private List<Map<String, Object>> listItems;  
    private Button button_latest, button_hot, button_game, button_educ, button_tool, button_life, button_sociality;

	public interface OnAllAppSelectedListener {
	    public void OnAllAppSelected(int type);	
	}

	private OnAllAppSelectedListener mListener;

	@Override 
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		try {
			mListener = (OnAllAppSelectedListener)activity;
		} catch(ClassCastException e) {
			e.printStackTrace();
			Log.e(TAG, activity.toString()+"must implement OnAllAppSelectedListener");
		}
		
	}

    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
    	View view = inflater.inflate(R.layout.all_apps_detail, container,false);

    	button_latest=(Button)view.findViewById(R.id.button_latest);
    	button_hot=(Button)view.findViewById(R.id.button_hot);
    	button_game=(Button)view.findViewById(R.id.button_game);
    	button_educ=(Button)view.findViewById(R.id.button_educ);
    	button_tool=(Button)view.findViewById(R.id.button_tool);
    	button_life=(Button)view.findViewById(R.id.button_life);
    	button_sociality=(Button)view.findViewById(R.id.button_sociality);

    	gridview = (GridView) view.findViewById(R.id.gridAllApps);  
 
        return view;
    }
 
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);
      
        button_latest.setFocusable(true);
        button_latest.setFocusableInTouchMode(true);
        button_latest.requestFocus();
 //       button_latest.setBackgroundColor(0x660000);

    	OnButtonClick onButtonClick = new OnButtonClick();
    	button_latest.setOnClickListener(onButtonClick);
    	button_hot.setOnClickListener(onButtonClick);
    	button_game.setOnClickListener(onButtonClick);
    	button_educ.setOnClickListener(onButtonClick);
    	button_tool.setOnClickListener(onButtonClick);
    	button_life.setOnClickListener(onButtonClick);
    	button_sociality.setOnClickListener(onButtonClick);     
    }
    
    class OnButtonClick implements OnClickListener {
    	public void onClick(View v) {
    		switch(v.getId()) {
    		case R.id.button_latest:
    			Log.i(TAG, "button_latest");
    			updateGrid();
    			break;
    		case R.id.button_hot:
    			Log.i(TAG, "button_hot");
    			listItems.clear();
    			adapter.notifyDataSetChanged();
    			break;
    		case R.id.button_game:
    			Log.i(TAG, "button_game");
    			break;
    		case R.id.button_educ:
    			Log.i(TAG, "button_educ");
    			break;
    		case R.id.button_tool:
    			Log.i(TAG, "button_tool");
    			break;
    		case R.id.button_life:
    			Log.i(TAG, "button_life");
    			break;
    		case R.id.button_sociality:
    			Log.i(TAG, "button_sociality");
    			break;
    		default:
    			break;
    		}
    	}
    	
    	public void updateGrid() {

        	listItems = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < value.length; i++) {  
                Map<String, Object> listItem = new HashMap<String, Object>();  
                listItem.put("image", image);
                listItem.put("title", value[i]);
                listItem.put("type", "life");
                listItem.put("charge", "free");
                listItems.add(listItem);
            }
            
            adapter = new SimpleAdapter(getActivity(), listItems,  
                    R.layout.grid_item, new String[] { "image", "title", "type", "charge"},  
                    new int[] { R.id.gridItemImage, R.id.gridItemTitle, R.id.gridItemType, R.id.gridItemCharge});  
            gridview.setAdapter(adapter);
            gridview.setOnItemClickListener(new ItemClickListener());
    	}
    	
    	
    }
    
    class ItemClickListener implements OnItemClickListener {
    	public void onItemClick(AdapterView<?> parent, View view, int position, long rowid) {
    		switch (position) {
    		case 0:
    			mListener.OnAllAppSelected(0);
    			break;
    		case 1:
    			mListener.OnAllAppSelected(1);
    			break;
    		case 2:
    			mListener.OnAllAppSelected(2);
    			break;
    		case 3:
 
    			break;
    		}
    	}
    }

}
