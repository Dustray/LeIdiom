package com.dustray.leidiom;

import java.util.ArrayList;
import java.util.List;

import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;
import net.youmi.android.spot.SpotManager;

import com.dustray.leidiom.adapter.CategoryAdapter;
import com.dustray.leidiom.entity.Category;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class StudyActivity extends Activity {
	private List<Category> categoryList;
	private String[] category_names;
	private int[] category_images;
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_study);

		initCategories();// 初始化类别
		CategoryAdapter adapter = new CategoryAdapter(this,
				R.layout.category_item, categoryList);
		
		// 有米广告
		mContext = this;
		SpotManager.getInstance(mContext).loadSpotAds();
		SpotManager.getInstance(mContext).setSpotOrientation(
				SpotManager.ANIM_ADVANCE);
		SpotManager.getInstance(mContext).showSpotAds(mContext);
		
		// 实例化广告条
		AdView adView = new AdView(mContext, AdSize.FIT_SCREEN);

		// 获取要嵌入广告条的布局
		LinearLayout adLayout=(LinearLayout)findViewById(R.id.adLayout);

		// 将广告条加入到布局中
		adLayout.addView(adView);

		ListView listView = (ListView) findViewById(R.id.IvCategories);
		listView.setAdapter(adapter);
		/** 实现点击 **/
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				// Category category = categoryList.get(position);
				// Toast.makeText(StudyActivity.this, category.getName(),
				// Toast.LENGTH_LONG).show();
				switch (position) {
				case 0:
					Intent intent = new Intent(StudyActivity.this,
							AnimalActivity.class);
					startActivity(intent);
					break;
				default:
					break;
				}
			}
		});

	}

	private void initCategories() {
		categoryList = new ArrayList<Category>();
		Resources resources = getResources();
		category_names = resources.getStringArray(R.array.category);
		category_images = new int[] { R.drawable.category_animal,
				R.drawable.category_nature, R.drawable.category_human,
				R.drawable.category_season, R.drawable.category_number,
				R.drawable.category_fable, R.drawable.category_other };
		for (int i = 0; i < category_names.length; i++) {
			categoryList
					.add(new Category(category_names[i], category_images[i]));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
