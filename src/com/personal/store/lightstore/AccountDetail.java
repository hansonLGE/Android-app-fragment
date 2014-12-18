/**
 * 
 */
package com.personal.store.lightstore;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.TextView;

/**
 * @author wei.ren
 *
 */
public class AccountDetail extends Fragment {

	private String TAG = FragNavigation.class.getName();
	private Activity mActivity;
	private CheckBox check_show;
	private Button button_no, button_yes;
	private EditText edit_password, edit_re_password;
	private ExpandableListView expandableListView;
	private List<String> groupData;
	private List<List<String>> childrenData;
	
	@Override 
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		mActivity = activity;
	}
	
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
    		Bundle savedInstanceState) { 
    	
    	View view = inflater.inflate(R.layout.account_manage, container, false);
    	
    	edit_password = (EditText)view.findViewById(R.id.edit_password);
    	edit_re_password = (EditText)view.findViewById(R.id.edit_re_password);
    	check_show = (CheckBox)view.findViewById(R.id.check_show);
    	button_no = (Button)view.findViewById(R.id.button_no);
    	button_yes = (Button)view.findViewById(R.id.button_yes);
    	expandableListView = (ExpandableListView)view.findViewById(R.id.email_addr);
    	
    	return view;
    } 

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);
 
    	OnButtonClick onButtonClick = new OnButtonClick();
    	button_no.setOnClickListener(onButtonClick);
    	button_yes.setOnClickListener(onButtonClick);
    	
        check_show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override            
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub 
            	if(isChecked){ 
            		edit_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
            		edit_re_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);

            	}else{ 
            		edit_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            		edit_re_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            	}         	
            }
        	
        });
        
        loadListData();
        expandableListView.setAdapter(new ExpandableAdapter());
        expandableListView.setOnChildClickListener(new OnChildClickListener(){
        	public boolean onChildClick(ExpandableListView parent, View v,  
                                            int groupPosition, int childPosition, long id) {
        		Log.i(TAG, "expandableListView child");
        		return true;
        	}
        	
        });
        
    }
 
    public void loadListData() {
    	groupData = new ArrayList<String>();
    	groupData.add("address list");
    	
    	childrenData = new ArrayList<List<String>>();
    	List<String> child = new ArrayList<String>();
    	child.add("hotmail.com");
    	child.add("126.com");
    	child.add("163.com");
    	childrenData.add(child);    	
    }
    
    private class ExpandableAdapter extends BaseExpandableListAdapter {

        @Override  
        public Object getChild(int groupPosition, int childPosition) {  
            return childrenData.get(groupPosition).get(childPosition);  
        } 

        @Override  
        public long getChildId(int groupPosition, int childPosition) {  
            return 0;  
        } 

        @Override
        public View getChildView(int groupPosition, int childPosition,  
                boolean isLastChild, View convertView, ViewGroup parent) {
        	TextView myText = null;
        	if(convertView != null) {
                myText = (TextView)convertView;    
                myText.setText(childrenData.get(groupPosition).get(childPosition)); 
       		
        	}
        	else {
        		myText = createView(childrenData.get(groupPosition).get(childPosition));
        	}
        	
        	return myText;
        }

        @Override  
        public int getChildrenCount(int groupPosition) {  
            return childrenData.get(groupPosition).size();  
        } 

        @Override  
        public Object getGroup(int groupPosition) {  
            return groupData.get(groupPosition);  
        }  

        @Override  
        public int getGroupCount() {  
            return groupData.size();  
        }  

        @Override  
        public long getGroupId(int groupPosition) {  
            return 0;  
        }  

        @Override  
        public View getGroupView(int groupPosition, boolean isExpanded,  
                        View convertView, ViewGroup parent) {  
            TextView myText = null;    
            if (convertView != null) {    
                myText = (TextView)convertView;    
                myText.setText(groupData.get(groupPosition));    
               } else {    
                   myText = createView(groupData.get(groupPosition));    
               }    
            return myText;  
        } 

        @Override  
        public boolean hasStableIds() {  
            return false;  
        }  

        @Override  
        public boolean isChildSelectable(int groupPosition, int childPosition) {  
            return false;  
        } 
       
        private TextView createView(String content) {    
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(      
                ViewGroup.LayoutParams.WRAP_CONTENT, 40);      
            TextView myText = new TextView(mActivity);      
            myText.setLayoutParams(layoutParams);      
            myText.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);      
            myText.setPadding(40, 0, 0, 0);      
            myText.setText(content);    
            return myText;    
        } 


    }
    
    class OnButtonClick implements OnClickListener {
    	public void onClick(View v) {
    		switch(v.getId()) {
    		case R.id.button_no:
    			Log.i(TAG, "button_no");
    			break;
    		case R.id.button_yes:
    			Log.i(TAG, "button_yes");
    			break;
    		default:
    			break;
    		}
    	}
    	
    }
}
