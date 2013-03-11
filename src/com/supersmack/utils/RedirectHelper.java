package com.supersmack.utils;

import java.util.HashMap;
import java.util.Map;

import com.supersmack.activities.HomeActivity;

import android.content.Context;
import android.content.Intent;

public class RedirectHelper {
	
	public static boolean redirect(Context context, Class<?> to) {
		return redirect(context, to, new Intent());
	}
	
	public static boolean redirect(Context context, Class<?> to, Intent intent) {
		try {
		    intent.setClass(context, to);
		    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		    intent.putExtra("previousContext", context.getClass().getName());
		    context.startActivity(intent);
			return true;
		} catch (NoClassDefFoundError e) {
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put("missing_class", e.getMessage());
			return redirectToHome(context);
		}
	}
	
	public static boolean redirectToHome(Context context) {
		return redirect(context, HomeActivity.class);
	}
}