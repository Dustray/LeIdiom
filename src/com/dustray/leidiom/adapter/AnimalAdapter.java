package com.dustray.leidiom.adapter;

import java.util.List;

import com.dustray.leidiom.R;
import com.dustray.leidiom.entity.Animal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class AnimalAdapter extends ArrayAdapter<Animal> {
	private int resourceId;
	private Context context;// 二次添加，事件处理

	public AnimalAdapter(Context context, int resource, List<Animal> objects) {
		super(context, resource, objects);
		resourceId = resource;
		this.context = context;// 二次添加，事件处理
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Animal animal = getItem(position);// 二次修改获取当前项的Animal实例

		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.tvName = (TextView) view.findViewById(R.id.tvName);
			viewHolder.btnSave = (ImageButton) view.findViewById(R.id.btnSave);
			viewHolder.btnSave.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View view) {
					// TODO Auto-generated method stub
					Toast.makeText(context, "你要收藏" + animal.getName() + "吗",
							Toast.LENGTH_SHORT).show();
				}
			});//二次添加，收藏事件处理
			view.setTag(viewHolder);// 将ViewHolder存储在View中
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();// 重新获取ViewHolder
		}
		viewHolder.tvName.setText(animal.getName());
		viewHolder.btnSave.setFocusable(false);
		viewHolder.btnSave.setFocusableInTouchMode(false);
		
		return view;
	}

	class ViewHolder {
		TextView tvName;
		ImageButton btnSave;
	}
}
