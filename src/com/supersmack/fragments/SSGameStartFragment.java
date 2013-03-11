package com.supersmack.fragments;

import com.supersmack.R;
import com.supersmack.controllers.ui.SSBackgroundController;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SSGameStartFragment extends Fragment {

	private Context mContext;
	private SSBackgroundController mBackgroundController;
	
	public SSGameStartFragment() {
		
	}
	
	public SSGameStartFragment(Context context) {
		this.mContext = context;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_game_start, container, false);
		
		mBackgroundController = (SSBackgroundController) view.findViewById(R.id.gameStartBackgroundController);
		mBackgroundController.setBackgroundColor(getResources().getColor(R.color.translucent_black));
		
	    return view;
	}
}