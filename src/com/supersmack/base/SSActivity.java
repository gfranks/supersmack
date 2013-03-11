package com.supersmack.base;

import com.supersmack.common.SSLoaderControl;
import com.supersmack.common.SSOnLoaderListener;
import com.supersmack.controllers.SSActivityController;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

public abstract class SSActivity extends Activity implements SSOnLoaderListener, SSLoaderControl {
	
	private SSActivityController mController;
	
	protected SSActivity() {
		mController = new SSActivityController(this);
		mController.setOnLoadListener(this);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override 
	public boolean onKeyDown(int keyCode, KeyEvent event) { 
       return mController.keyDown(keyCode, event);
    }
	
	@Override
	protected void onRestart() {
		mController.status = true;
		super.onRestart();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	
	@Override  
	protected void onDestroy() { 
		mController.kill();
        super.onDestroy(); 
    } 
	
	@Override
    protected void onPause() {
		try {
			mController.kill();
			super.onPause();
		} catch (Exception ex) {}
    }
	
	@Override 
	protected void onSaveInstanceState(Bundle outState) {
		mController.kill();
		super.onSaveInstanceState(outState); 
    }
	
	@Override 
	public boolean onSearchRequested() {    
		return false; 
	}
	
	@Override 
	protected void onStart() {
		super.onStart();
	}
	
	@Override 
	protected void onStop() {
		super.onStop();
	}
	
	protected void startLoadRequest(boolean async) {
		mController.start(async);
    }
	
	public boolean onSuperKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}
}
