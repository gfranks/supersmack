package com.supersmack.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class ProgressDialog extends Dialog {	
		
	private int mResource_ID;
	
	//***************************************
    // class constructors
    //***************************************
	public ProgressDialog(Context context, int mStyle_ID, int mResource_ID) {
		super(context, mStyle_ID);
		this.mResource_ID = mResource_ID;
	}
	
	//***************************************
    // public methods
    //***************************************
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(mResource_ID);
	}
}

