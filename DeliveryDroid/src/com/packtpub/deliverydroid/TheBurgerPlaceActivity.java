package com.packtpub.deliverydroid;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class TheBurgerPlaceActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new BurgerAdapter(new Burger("Plain old Burger"),
				new Burger("Cheese Burger"), new Burger("Chicken Burger"),
				new Burger("Breakfast Burger"), new Burger("Hawaiian Burger"),
				new Burger("Fish Burger"), new Burger("Vegatarian Burger"),
				new Burger("Lamb Burger"), new Burger("Rare Tuna Steak Burger")));

	}

	protected void onListItemClick(ListView parent, View item, int index,
			long id) {
		BurgerAdapter burgers = (BurgerAdapter) parent.getAdapter();
		Burger burger = (Burger) burgers.getItem(index);
		burger.count++;
		burgers.notifyDataSetInvalidated();
	}

}