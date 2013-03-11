package com.supersmack.common;

import android.view.KeyEvent;

public interface SSLoaderControl {
	int getProgressResource();
	int getProgressStyle();
	boolean onSuperKeyDown(int keyCode, KeyEvent event);
}
