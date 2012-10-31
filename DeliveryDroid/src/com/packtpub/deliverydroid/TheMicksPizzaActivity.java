package com.packtpub.deliverydroid;

import android.app.ExpandableListActivity;
import android.os.Bundle;

public class TheMicksPizzaActivity extends ExpandableListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new PizzaToppingAdapter(new ToppingCatagory("Fruit",
				new PizzaTopping("Apple"), new PizzaTopping("Pear")),
				new ToppingCatagory("Meat", new PizzaTopping("Beef"),
						new PizzaTopping("Chicken"))));
	}
}