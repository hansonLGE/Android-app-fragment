package com.personal.store.lightstore;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import com.personal.store.lightstore.AllAppsDetail.OnAllAppSelectedListener;
import com.personal.store.lightstore.FragNavigation.OnNaviSelectedListener;
import com.personal.store.lightstore.MyAppDetail.OnMyAppSelectedListener;

public class MainActivity extends Activity implements OnNaviSelectedListener, OnMyAppSelectedListener,
                                                      OnAllAppSelectedListener {

	private String TAG = MainActivity.class.getName();
	private MyAppDetail myAppDetail;
	private AllAppsDetail allAppDetail;
	private AccountDetail accountDetail;
    private FragmentManager manager;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		myAppDetail = new MyAppDetail();
		allAppDetail = new AllAppsDetail();
		accountDetail = new AccountDetail();

		manager = getFragmentManager();
		
		if (findViewById(R.id.details_container) != null) {
			manager.beginTransaction().add(R.id.details_container, myAppDetail, "details")
            .commit();			
		}

	}
	
	public void OnNavigationSelected(int type) {
    	switch (type) {
    	case 0:
		    manager.beginTransaction().replace(R.id.details_container, myAppDetail, "details")
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack(null) 
            .commit();
    		/*
		    manager.beginTransaction().replace(R.id.details_container, myAppDetail, "details")
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack(null) 
            .commit();*/
    		break;
    	case 1:
		    manager.beginTransaction().replace(R.id.details_container, accountDetail, "details")
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack(null) 
            .commit();
    		break;
    	case 2:
		    manager.beginTransaction().replace(R.id.details_container, allAppDetail, "details")
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .addToBackStack(null) 
            .commit();
    		break;
    	default:
    		break;
    	}
	}
	
	 public void OnMyAppSelected(int type) {
	    switch (type) {
	    case 0:
	    	Log.i(TAG, "my_app_111");
	    	break;
	    case 1:
	    	Log.i(TAG, "my_app_222");
	    	break;
	    case 2:
	    	Log.i(TAG, "my_app_333");
	    	break;
	    default:
	    	break;
	    } 
	 }
	 
	 public void OnAllAppSelected(int type) {
		switch (type) {
		case 0:
		    Log.i(TAG, "all_app_111");
		    break;
		case 1:
		    Log.i(TAG, "all_app_222");
		    break;
		case 2:
		    Log.i(TAG, "all_app_333");
		    break;
		default:
		    break;
		    } 	 
	 }


}
