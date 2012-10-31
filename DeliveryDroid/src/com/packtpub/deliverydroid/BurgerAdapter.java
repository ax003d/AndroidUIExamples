package com.packtpub.deliverydroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

class BurgerAdapter extends BaseAdapter {
    private final Burger[] burgers;
    
    BurgerAdapter(Burger... burgers) {
        this.burgers = burgers;
    }

    public int getCount() {
        return burgers.length;
    }

    public Object getItem(int index) {
        return burgers[index];
    }

    public long getItemId(int index) {
        return index;
    }

    private ViewGroup getViewGroup(View reuse, ViewGroup parent) {
        if(reuse instanceof ViewGroup) {
            return (ViewGroup)reuse;
        }
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup item = (ViewGroup)inflater.inflate(R.layout.burger_item, null);
        return item;
    }

    public View getView(int index, View reuse, ViewGroup parent) {
        ViewGroup item = getViewGroup(reuse, parent);
        TextView counter = (TextView)item.findViewById(R.id.counter);
        TextView label = (TextView)item.findViewById(R.id.text);
        Burger burger = burgers[index];
        counter.setVisibility(burger.count == 0? View.INVISIBLE: View.VISIBLE);
        counter.setText(Integer.toString(burger.count));
        label.setText(burger.name);
        return item;
    }
}