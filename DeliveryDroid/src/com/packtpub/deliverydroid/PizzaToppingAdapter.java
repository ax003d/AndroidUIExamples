package com.packtpub.deliverydroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

class PizzaToppingAdapter extends BaseExpandableListAdapter {
    private final ToppingCatagory[] catagories;

    PizzaToppingAdapter(ToppingCatagory... catagories) {
        this.catagories = catagories;
    }

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return catagories[groupPosition].getToppings()[childPosition];
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		ViewGroup view;
        if (convertView instanceof ViewGroup) {
            view = (ViewGroup)convertView;
        } else {
            final Context context = parent.getContext();
            final LayoutInflater inflater = LayoutInflater.from(context);
            view = (ViewGroup)inflater.inflate(R.layout.pizza_item, null);	
        }
        
        TextView text1 = (TextView)view.findViewById(R.id.status);
        TextView text2 = (TextView)view.findViewById(R.id.text);
        PizzaTopping topping = (PizzaTopping)getChild(groupPosition, childPosition);
        text1.setVisibility(View.INVISIBLE);
        text2.setText(topping.name);
		return view;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return catagories[groupPosition].getToppings().length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return catagories[groupPosition];
	}

	@Override
	public int getGroupCount() {
		return catagories.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		TextView view;
        if (convertView instanceof TextView) {
            view = (TextView)convertView;
        } else {
            final Context context = parent.getContext();
            final LayoutInflater inflater = LayoutInflater.from(context);
            view = (TextView)inflater.inflate(android.R.layout.simple_expandable_list_item_1, null);
        }
        
		view.setText(catagories[groupPosition].name);
		return view;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}
}