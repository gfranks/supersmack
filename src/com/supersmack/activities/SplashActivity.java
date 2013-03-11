package com.supersmack.activities;

import com.supersmack.R;
import com.supersmack.utils.RedirectHelper;
import com.supersmack.utils.SSApplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity {
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        if(SSApplication.DEVELOPMENT_MODE == true) {
        	TextView dev = (TextView)findViewById(R.id.devModeLabel);
        	dev.setVisibility(View.VISIBLE);
        }
    }
    
    @Override
	protected void onResume() {
		super.onResume();

        // Load any services or utils

        Animation mAnim = AnimationUtils.loadAnimation(this, R.anim.simple);
		mAnim.setDuration(1000);    		
		mAnim.setAnimationListener(new AnimationListener(){
			public void onAnimationEnd(Animation animation) {
				onRedirect();
			}

			public void onAnimationRepeat(Animation animation) { }

			public void onAnimationStart(Animation animation) { }
		});

		ImageView logo = (ImageView)findViewById(R.id.splashLogo);
		logo.startAnimation(mAnim);
	}

	private void onRedirect() {
		RedirectHelper.redirect(this, HomeActivity.class);
		this.finish();
	}
}
