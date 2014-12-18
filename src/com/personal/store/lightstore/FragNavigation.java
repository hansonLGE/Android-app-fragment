/**
 * 
 */
package com.personal.store.lightstore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

/**
 * @author wei.ren
 *
 */
public class FragNavigation extends ListFragment {
 
	private String TAG = FragNavigation.class.getName();
    private SimpleAdapter adapter;
    
	private String[] value = new String[] {"my apps", "my count", "app store"};
	private int image = R.drawable.ic_carat_r;

	public interface OnNaviSelectedListener {
	    public void OnNavigationSelected(int type);	
	}

	private OnNaviSelectedListener mListener; 

	@Override 
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		try {
			mListener = (OnNaviSelectedListener)activity;
		} catch(ClassCastException e) {
			e.printStackTrace();
			Log.e(TAG, activity.toString()+"must implement OnNaviSelectedListener");
		}
		
	}
	
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
    		Bundle savedInstanceState) { 
    	return inflater.inflate(R.layout.navigation, container, false);
    } 

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  

        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();  
        for (int i = 0; i < value.length; i++) {  
            Map<String, Object> listItem = new HashMap<String, Object>();  
            listItem.put("value", value[i]);  
            listItem.put("image", image);  
            listItems.add(listItem);  
        }
 
        adapter = new SimpleAdapter(getActivity(), listItems,  
            R.layout.list_item, new String[] { "value", "image" },  
            new int[] { R.id.itemTitle, R.id.itemImage });  
        setListAdapter(adapter);    

    }
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    	
    	switch (position) {
    	case 0:
    		mListener.OnNavigationSelected(0);
    		break;
    	case 1:
    		mListener.OnNavigationSelected(1);
    		break;
    	case 2:
    		mListener.OnNavigationSelected(2);
    		break;
    	default:
    		break;
    	}
    }

}
