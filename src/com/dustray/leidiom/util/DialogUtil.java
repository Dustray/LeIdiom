package com.dustray.leidiom.util;

import com.dustray.leidiom.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class DialogUtil {

	public static void showDialog(String result, Context context){
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		LayoutInflater layoutInflater = LayoutInflater.from(context);
		View view = layoutInflater.inflate(R.layout.dialog_info, null);
		builder.setView(view);
		TextView tvIdiomInfo = (TextView)view.findViewById(R.id.tvIdiomInfo);
		tvIdiomInfo.setText(result);
		builder.setPositiveButton("È·¶¨",new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
			
		
		});
		builder.create().show();
	}
}
