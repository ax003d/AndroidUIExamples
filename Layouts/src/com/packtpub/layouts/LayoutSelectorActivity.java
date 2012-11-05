package com.packtpub.layouts;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LayoutSelectorActivity extends ListActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setListAdapter(new ArrayAdapter<String>(
        		this,
        		android.R.layout.simple_list_item_1,
        		getResources().getStringArray(R.array.layouts)));
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	switch (position) {
    	default:
    		Toast.makeText(this, "Example not yet implemented", Toast.LENGTH_SHORT).show();
    	}
    }
}