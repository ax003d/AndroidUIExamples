package com.packtpub.viewrecipe;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;

public class ViewRecipeActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);        
        
        WebView view = new WebView(this);
        view.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        Recipe recipe = new Recipe("Microwave Fudge", 
        		new Ingredient[] { 
        			new Ingredient("ingredient1", 1.0, "g"),
        			new Ingredient("ingredient2", 2.0, "g"),
        			}, 
        		new String[] { "instruction1", "instruction2"});
        view.loadData(recipe.toHtml(), "text/html", "UTF-8");
        
        setContentView(view);
    }
}
