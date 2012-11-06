package com.packtpub.selector;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater.Filter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListItemSelectionActivity extends Activity
{
	
	private ListAdapter adapter;
	private Filter filter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ListView list = (ListView)findViewById(R.id.list);
        EditText input = (EditText)findViewById(R.id.input);
    }
}
