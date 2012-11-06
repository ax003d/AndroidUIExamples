package com.packtpub.selector;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListItemSelectionActivity extends Activity implements TextWatcher, OnItemClickListener
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
        adapter = createListAdapter();
        filter = ((Filterable)adapter).getFilter();
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        input.addTextChangedListener(this);
    }
    
    private ListAdapter createArrayAdapter(Intent intent) {
    	Object[] data = (Object[])intent.getSerializableExtra("data");
    	if ( data != null && data.length > 0 ) {
    		return new ArrayAdapter<Object>(
    				this,
    				android.R.layout.simple_list_item_1,
    				data);
    	} else {
    		throw new IllegalArgumentException("no list data specified in Intent: " + intent);
    	}
    }
    
    private String getColumnName(final Intent intent, String primary, String secondary, String def) {
    	String col = intent.getStringExtra(primary);
    	if ( col == null ) {
    		col = intent.getStringExtra(secondary);
    	}
    	if ( col == null ) {
    		col = def;
    	}
    	return col;
    }
    
    private ListAdapter createCursorAdapter(final Intent intent) {
    	final String line1 = getColumnName(intent, "name", "line1", "name");
    	String line2 = getColumnName(intent, "description", "line2", null);
    	int listItemResource;
    	final String[] columns;
    	String[] displayColumns;
    	int[] textIds;
    	
    	if ( line2 != null ) {
    		listItemResource = android.R.layout.two_line_list_item;
    		columns = new String[] { "_id", line1, line2 };
    		displayColumns = new String[] { line1, line2 };
    		textIds = new int[] { android.R.id.text1, android.R.id.text2 };
    	} else {
    		listItemResource = android.R.layout.simple_list_item_1;
    		columns = new String[] { "_id", line1 };
    		displayColumns = new String[] { line1 };
    		textIds = null;
    	}

    	Cursor cursor = managedQuery(intent.getData(), columns, null, null, line1);
    	CursorAdapter cursorAdapter = new SimpleCursorAdapter(
    			this,
    			listItemResource,
    			cursor,
    			displayColumns,
    			textIds);
    	cursorAdapter.setFilterQueryProvider(new FilterQueryProvider() {

			@Override
			public Cursor runQuery(CharSequence constraint) {
				return managedQuery(intent.getData(), 
						columns, 
						line1 + " LIKE ?",
						new String[] { constraint.toString() + '%' },
						line1 );
			}    		
    	});
    	return cursorAdapter;
    }

    private ListAdapter createListAdapter() {
    	Intent intent = getIntent();
    	if ( intent.getData() != null ) {
    		return createCursorAdapter(intent);
    	} else {
    		return createArrayAdapter(intent);
    	}
    }

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterTextChanged(Editable s) {
		filter.filter(s);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent data = new Intent();
		if ( adapter instanceof CursorAdapter ) {
			data.putExtra("selection", id);
		} else {
			data.putExtra("selection", (Serializable)parent.getItemAtPosition(position));
		}
		setResult(RESULT_OK, data);
		finish();
	}
}
