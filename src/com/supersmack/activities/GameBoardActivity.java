package com.supersmack.activities;

import android.os.Bundle;

import com.supersmack.R;
import com.supersmack.base.SSActivity;

public class GameBoardActivity extends SSActivity {
	
	@Override
	public void onRequest() {
		
	}

	@Override
	public void onRequestCompleted() {
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

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
}
