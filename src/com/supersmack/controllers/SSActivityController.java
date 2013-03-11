package com.supersmack.controllers;

import java.util.concurrent.RejectedExecutionException;

import android.app.Activity;
import android.view.KeyEvent;

import com.supersmack.common.SSBackgroundWorker;
import com.supersmack.common.SSLoaderControl;
import com.supersmack.common.SSOnLoaderListener;

public class SSActivityController {
	
	//***************************************
    // public class fields
    //***************************************	
	public boolean status;
	
	//***************************************
    // private class fields
    //***************************************	
	private SSBackgroundWorker mWorker;
	private Activity mActivity;
	private SSLoaderControl mView;
	private SSOnLoaderListener mLoadListener;
	
	//***************************************
    // class constructors
    //***************************************	
	public SSActivityController(Activity activity) {
		mActivity = activity;
		mView = (SSLoaderControl)activity;
	}
	
	//***************************************
    // public setters
    //***************************************	
	public void setOnLoadListener(SSOnLoaderListener listener) {
		mLoadListener = listener;
	}
	
	//***************************************
    // public methods
    //***************************************	
	public boolean keyDown(int keyCode, KeyEvent event) {	
		switch (keyCode) { 
            case KeyEvent.KEYCODE_BACK:
            	mActivity.finish();
            	return true;
            default :
            	return mView.onSuperKeyDown(keyCode, event);
        }
    }
	
	public void start(boolean async) {
		loadValuesFromMemory(async);
    }
	
	public void loadValuesFromMemory(boolean async) {
		try {
			if (async) {
				mWorker = new SSBackgroundWorker(mActivity, mView.getProgressStyle(), mView.getProgressResource());
				mWorker.setOnLoadListener(mLoadListener);
				mWorker.execute();
			} else {
				mLoadListener.onRequest();
				mLoadListener.onRequestCompleted();
			}
		} catch (RejectedExecutionException ex){}	
	}
	
	public void kill() {
		if (status) {
			try {
				mLoadListener.onCancel();			
				if (mWorker != null) {
		        	if (!mWorker.isCancelled()) {
		        		mWorker.cancel();
		        		mWorker = null;
		        	}
		        }
				status = false;
			} catch(Exception ex){}
		}
	}
}
