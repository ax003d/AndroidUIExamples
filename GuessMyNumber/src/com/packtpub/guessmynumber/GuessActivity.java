package com.packtpub.guessmynumber;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuessActivity extends Activity implements OnClickListener
{
	private int number;
	
	private static int random() {
		return (int)(Math.random() * 9 + 1);
	}
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        if ( savedInstanceState != null ) {
        	this.number = savedInstanceState.getInt("Number", random());
        } else {
        	this.number = random();
        }
        
        setContentView(R.layout.main);
        
        Button button = (Button)findViewById(R.id.guess);
        button.setOnClickListener(this);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	outState.putInt("Number", this.number);
    }

	@Override
	public void onClick(View v) {
		EditText input = (EditText)findViewById(R.id.number);
		int value = Integer.parseInt(input.getText().toString());
		if ( value < number ) {
			Toast.makeText(this, "Too low", Toast.LENGTH_SHORT).show();
		} else if ( value > number ) {
			Toast.makeText(this, "Too high", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, 
					"You got it! Try guess another one!", 
					Toast.LENGTH_SHORT).show();
			this.number = random();
		}
	}
}
