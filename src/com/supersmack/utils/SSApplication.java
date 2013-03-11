package com.supersmack.utils;

import com.supersmack.R;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

public class SSApplication extends Application implements ActivityLifecycleCallbacks {
	
	public static boolean DEVELOPMENT_MODE;
	
	@Override
    public void onCreate() {
        setValues();
        super.onCreate();
    }

	private void setValues() {
		DEVELOPMENT_MODE = true; //Set this for releasing to the google play store.
		
		if (DEVELOPMENT_MODE) {
			
			
		}
		
		registerActivityLifecycleCallbacks(this);
	}
	
	public static boolean isTablet(Context ctx) {
		boolean tabletSize = ctx.getResources().getBoolean(R.bool.isTablet);
		if (tabletSize) {
			Log.d("AptgApplication", "This device is a tablet.");
			return true;
		} else {
			Log.d("AptgApplication", "This device is NOT a tablet.");
		    return false;
		}
	}

	@Override
	public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
		
	}

	@Override
	public void onActivityDestroyed(Activity activity) {
		
	}

	@Override
	public void onActivityPaused(Activity activity) {
		
	}

	@Override
	public void onActivityResumed(Activity activity) {
		
	}

	@Override
	public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
		
	}

	@Override
	public void onActivityStarted(Activity activity) {
		
	}

	@Override
	public void onActivityStopped(Activity activity) {
		
	}
}