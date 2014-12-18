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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

/**
 * @author wei.ren
 *
 */
public class MyAppDetail extends Fragment {
	private String TAG = FragNavigation.class.getName();
    private GridView gridview;
    
	private String[] value = new String[] {"SanGuoSha", "222", "333", "444", "555", "666", "777"};
	private int image = R.drawable.ic_example_app;

	public interface OnMyAppSelectedListener {
	    public void OnMyAppSelected(int type);	
	}

	private OnMyAppSelectedListener mListener;

	@Override 
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		try {
			mListener = (OnMyAppSelectedListener)activity;
		} catch(ClassCastException e) {
			e.printStackTrace();
			Log.e(TAG, activity.toString()+"must implement OnMyAppSelectedListener");
		}
		
	}

    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
    	View view = inflater.inflate(R.layout.my_apps_detail, container,false);
    	gridview = (GridView) view.findViewById(R.id.gridMyApps);
    	
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  

    	List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < value.length; i++) {  
            Map<String, Object> listItem = new HashMap<String, Object>();  
            listItem.put("image", image);
            listItem.put("title", value[i]);
            listItem.put("type", "life");
            listItem.put("charge", "free");
            listItems.add(listItem);
        }
        
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), listItems,  
                R.layout.grid_item, new String[] { "image", "title", "type", "charge"},  
                new int[] { R.id.gridItemImage, R.id.gridItemTitle, R.id.gridItemType, R.id.gridItemCharge});  
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new ItemClickListener());       
    }
    
    class ItemClickListener implements OnItemClickListener {
    	public void onItemClick(AdapterView<?> parent, View view, int position, long rowid) {
    		switch (position) {
    		case 0:
    			mListener.OnMyAppSelected(0);
    			break;
    		case 1:
    			mListener.OnMyAppSelected(1);
    			break;
    		case 2:
    			mListener.OnMyAppSelected(2);
    			break;
    		case 3:
 
    			break;
    		}
    	}
    }
}