package com.packtpub.layouts;

import java.util.Arrays;
import java.util.Collections;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.TableLayout;
import android.widget.TableRow;

public class TableLayoutActivity extends Activity {
	
	private static final int[] CARD_RESOURSES = new int[] {
		R.drawable.apple,
		R.drawable.blackberry,
		R.drawable.coconut,
		R.drawable.grapes,
		R.drawable.kiwi,
		R.drawable.lime,
		R.drawable.orange,
		R.drawable.strawberry,
	};
	
	private final Handler handler = new Handler();
	
	private MemoryCard[] cards;
	private MemoryCard visible = null;
	private boolean touchEnalbed = true;
	
	private class MemoryCard implements OnClickListener {

		private ImageButton button;
		private int faceImage;
		private boolean faceVisible = false;
		
		MemoryCard(int faceImage) {
			this.faceImage = faceImage;
			this.button = new ImageButton(TableLayoutActivity.this);
			this.button.setLayoutParams(new TableRow.LayoutParams(64, 64));
			this.button.setScaleType(ScaleType.FIT_XY);
			this.button.setImageResource(R.drawable.line);
			this.button.setOnClickListener(this);
		}
		
		void setFaceVisible(boolean faceVisible) {
			this.faceVisible = faceVisible;
			button.setImageResource(faceVisible ? faceImage : R.drawable.line);
		}
		
		@Override
		public void onClick(View v) {
			if ( !faceVisible && touchEnalbed ) {
				onMemoryCardUncovered(this);
			}
		}		
		
	} // MemoryCard
	
	private MemoryCard[] createMemoryCells(int count) {
		MemoryCard[] array = new MemoryCard[count];
		for ( int i = 0; i < count; i++ ) {
			array[i] = new MemoryCard(CARD_RESOURSES[i / 2]);
		}
		return array;
	}	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TableLayout table = new TableLayout(this);
		int size = 4;
		cards = createMemoryCells(size * size);
		Collections.shuffle(Arrays.asList(cards));
		for ( int y = 0; y < size; y++ ) {
			TableRow row = new TableRow(this);
			for ( int x = 0; x < size; x++ ) {
				row.addView(cards[y * size + x].button);
			}
			table.addView(row);
		}
		setContentView(table);
	}
	
	private void onMemoryCardUncovered(final MemoryCard cell) {
		if ( visible == null ) {
			visible = cell;
			visible.setFaceVisible(true);
		} else if ( visible.faceImage == cell.faceImage ) {
			cell.setFaceVisible(true);
			cell.button.setEnabled(false);
			visible.button.setEnabled(false);
			visible = null;
		} else {
			cell.setFaceVisible(true);
			touchEnalbed = false;
			handler.postDelayed(new Runnable() {
				public void run() {
					cell.setFaceVisible(false);
					visible.setFaceVisible(false);
					visible = null;
					touchEnalbed = true;
				}
			}, 1000);
		}
	}	
	
} // TableLayoutActivity