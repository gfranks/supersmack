package com.supersmack.common;

import com.supersmack.dialogs.ProgressDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.util.Log;

public class SSBackgroundWorker extends AsyncTask<Object, Object, Object> implements OnCancelListener {
	
	private String tag = "BackgroundWorker";
	
	private ProgressDialog mDialog;
	private SSOnLoaderListener mLoader;
	
	public SSBackgroundWorker(Context context, int mStyle_ID, int mResource_ID) {
		mDialog = new ProgressDialog(context, mStyle_ID, mResource_ID);
		mDialog.setCancelable(true);
		mDialog.setOnCancelListener(this);		
		mDialog.show();	
	}
	
	@Override
	public Object doInBackground(Object... params) {
		try {
			mLoader.onRequest();
		} catch (Exception ex) {
			mDialog.dismiss();
		}
		return null;
	}

	@Override
	public void onPostExecute(Object result) {
		try {
			mDialog.dismiss();
			mLoader.onRequestCompleted();
			mDialog = null;
		} catch (Exception ex) {
			Log.w(tag, "Caught exception in mLoader.onRequestCompleted()");
			
		}
	}
	
	public void cancel() {		
		onCancel(mDialog);
		mDialog = null;
	}
	
	public void onCancel(DialogInterface arg0) {
		try {
			arg0.dismiss();			
			super.cancel(true);
			mLoader.onCancel();			
		} catch (Exception ex) { }
	}
	
	public void setOnLoadListener(SSOnLoaderListener listener) {
		mLoader = listener;
	}
}
