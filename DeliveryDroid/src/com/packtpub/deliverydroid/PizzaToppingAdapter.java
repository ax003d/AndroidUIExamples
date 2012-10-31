package com.packtpub.deliverydroid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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