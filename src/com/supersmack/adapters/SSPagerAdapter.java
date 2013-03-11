package com.supersmack.adapters;

import com.supersmack.fragments.SSOptionsFragment;
import com.supersmack.fragments.SSGameStartFragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SSPagerAdapter extends FragmentPagerAdapter {
	
	private Context mContext;
	
	public SSPagerAdapter(FragmentManager fm, Context context) {
		super(fm);
		this.mContext = context;
	}

	@Override
	public Fragment getItem(int index) {
		Fragment f = null;
		switch (index) {
		case 0:
			f = new SSGameStartFragment(mContext);
			break;
		case 1:
			f = new SSOptionsFragment(mContext);
			break;
		}

		return f;
	}

	@Override
	public int getCount() {
		return 2;
	}
}