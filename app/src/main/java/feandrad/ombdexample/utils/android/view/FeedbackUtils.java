package feandrad.ombdexample.utils.android.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by feandrad on 07/07/16.
 */
@SuppressWarnings("unused")
public class FeedbackUtils {

	public static void alert(Activity activity, String title, String message) {
		alert(activity, title, message, 0, 0);
	}

	public static void alert(Activity activity, String message) {
		alert(activity, null, message, 0, 0);
	}
	
	public static void alert(Activity activity, String title, String message, int okButton, int icon) {
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
		if (icon > 0) {
			builder.setIcon(icon);
		}
		if (title != null) {
			builder.setTitle(title);
		}
		builder.setMessage(message);
		
		String okString = okButton > 0
				? activity.getString(okButton)
				: activity.getString(android.R.string.ok);
		
		AlertDialog dialog = builder.create();
		dialog.setButton(AlertDialog.BUTTON_POSITIVE, okString, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		dialog.show();
	}
	
	public static void alert(Context context, int title, int message, int okButton, final Runnable runnable) {
		android.support.v7.app.AlertDialog.Builder builder =
				new android.support.v7.app.AlertDialog.Builder(context);
		builder.setTitle(title).setMessage(message);
		String okString = okButton > 0
				? context.getString(okButton)
				: context.getString(android.R.string.ok);
		
		builder.setPositiveButton(okString, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				if (runnable != null) {
					runnable.run();
				}
			}
		});
		android.support.v7.app.AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	public static void confirm(Context context, String message,
			@Nullable final Runnable cancelAction, @Nullable final Runnable okAction) {
		confirm(context, message, null, null, cancelAction, null, okAction);
	}
	
	public static void confirm(Context context, String message, @Nullable String title,
			@Nullable String cancelBtnText, @Nullable final Runnable cancelAction,
			@Nullable String okBtnText, @Nullable final Runnable okAction) {
		android.support.v7.app.AlertDialog.Builder builder =
				new android.support.v7.app.AlertDialog.Builder(context);
		builder.setMessage(message);
		
		if (title != null) {
			builder.setTitle(title);
		}
		
		String okString = okBtnText != null
				? okBtnText
				: context.getResources().getString(android.R.string.ok);
		builder.setPositiveButton(okString, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				if (okAction != null) {
					okAction.run();
				}
			}
		});
		
		String cancelString = cancelBtnText != null
				? cancelBtnText
				: context.getResources().getString(android.R.string.cancel);
		builder.setNegativeButton(cancelString, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				if (cancelAction != null) {
					cancelAction.run();
				}
			}
		});
		
		android.support.v7.app.AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	public static void snack(Activity activity, String msg, String btnText, int lenght,
			final Runnable runnable, int actionTextColor, int textColor) {

		View view = activity.getWindow().getDecorView().findViewById(android.R.id.content);
		Snackbar snackbar = Snackbar.make(view, msg, lenght)
				.setAction(btnText, new View.OnClickListener() {
					public void onClick(View v) {
						if (runnable != null) {
							runnable.run();
						}
					}
				}).setActionTextColor(actionTextColor);
		
		TextView textView =
				(TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
		textView.setTextColor(textColor);
		
		snackbar.show();
	}
	
	public static ProgressDialog progress(Context context, String message, boolean cancelable) {
		final ProgressDialog progressDialog = new ProgressDialog(context);
		progressDialog.setMessage(message);
		progressDialog.setCancelable(false);
		
		return progressDialog;
	}
}

