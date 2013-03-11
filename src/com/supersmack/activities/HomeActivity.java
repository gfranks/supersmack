package com.supersmack.activities;

import com.supersmack.R;
import com.supersmack.adapters.SSPagerAdapter;
import com.supersmack.base.SSFragmentActivity;
import com.supersmack.controllers.ui.SSBackgroundController;
import com.supersmack.controllers.ui.SSViewPagerIndicator;
import com.supersmack.controllers.ui.SSViewPagerIndicator.PageInfoProvider;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class HomeActivity extends SSFragmentActivity implements OnPageChangeListener {
	
	private SSBackgroundController mBackgroundController;
	private ViewPager mViewPager;
	private SSViewPagerIndicator mViewPagerIndicator;

	@Override
	public void onRequest() {
		// load background and animation
		setupViews();
	}

	@Override
	public void onRequestCompleted() {
		
	}
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        startLoadRequest(true);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}

	public void setupViews() {
		mBackgroundController = (SSBackgroundController) findViewById(R.id.homeBackgroundController);
		mBackgroundController.setBackgroundResource(R.drawable.gradient_bg);
		
		mViewPager = (ViewPager) findViewById(R.id.homeViewPager);
		SSPagerAdapter pagerAdapter = new SSPagerAdapter(getSupportFragmentManager(), this);
		mViewPager.setAdapter(pagerAdapter);
		
		mViewPager.setOnPageChangeListener(this);

		setOnClickListenerForTab(R.id.column1, 0, R.id.column1text, getString(R.string.fragment_game_start));
		setOnClickListenerForTab(R.id.column2, 1, R.id.column2text, getString(R.string.fragment_options));
		
//		mViewPagerIndicator = (SSViewPagerIndicator) findViewById(R.id.viewpager_indicator);
//		mViewPagerIndicator.init(0, pagerAdapter.getCount(), new PageInfoProvider() {
//			@Override
//			public String getTitle(int pos) {
//				String s = "";
//				switch (pos) {
//				case 0:
//					s = getString(R.string.fragment_game_start);
//					break;
//				case 1:
//					s = getString(R.string.fragment_options);
//					break;
//				}
//				
//				return s;
//			}
//		});
//		
//		mViewPager.setOnPageChangeListener(mViewPagerIndicator);
	}
	
	public void setOnClickListenerForTab(int tabID, final int tabPosition, int textFieldID, String text) {
		((TextView)findViewById(textFieldID)).setText(text);
		findViewById(tabID).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mViewPager.setCurrentItem(tabPosition, true);
			}
		});
	}
	
	@Override
	public void onCancel() {
	}

	@Override
	public int getProgressResource() {
		return R.layout.dialog_progress;
	}

	@Override
	public int getProgressStyle() {
		return R.style.Dialog;
	}

	@Override
	public void onPageScrollStateChanged(int position) {
	}

	@Override
	public void onPageScrolled(int position, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int position) {
		switch (position) {
		case 0:
			findViewById(R.id.tab1).setVisibility(View.VISIBLE);
			findViewById(R.id.tab2)
					.setVisibility(View.INVISIBLE);
			break;

		case 1:
			findViewById(R.id.tab1).setVisibility(View.INVISIBLE);
			findViewById(R.id.tab2).setVisibility(View.VISIBLE);
			break;
		}
	}
}
