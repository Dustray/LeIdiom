package com.dustray.leidiom;

import android.os.Bundle;
import net.youmi.android.AdManager;
import net.youmi.android.spot.SpotManager;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
	private TabHost tabHost;
	private Context mContext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);//取消标题栏（已取消）
		setContentView(R.layout.activity_main);
		tabHost = getTabHost();
//		addTab("study", R.string.title_study, R.drawable.study, R.id.tab1);
//		addTab("search", R.string.title_search, R.drawable.search, R.id.tab2);
//		addTab("game", R.string.title_game, R.drawable.game, R.id.tab3);
//		addTab("save", R.string.title_save, R.drawable.save, R.id.tab4);
//		addTab("help", R.string.title_help, R.drawable.help, R.id.tab5);
		addTab("study", R.string.title_study, R.drawable.study, StudyActivity.class);
		addTab("search", R.string.title_search, R.drawable.search, TempActivity.class);
		addTab("game", R.string.title_game, R.drawable.game, GameActivity.class);
		addTab("save", R.string.title_save, R.drawable.save, TempActivity.class);
		addTab("help", R.string.title_help, R.drawable.help, AboutActivity.class);
		//有米广告
		mContext=this;
		AdManager.getInstance(mContext).init("c48f91800c2ba155", "fb36e4acb897cad8", true);
		SpotManager.getInstance(mContext).loadSpotAds();
		SpotManager.getInstance(mContext).setSpotOrientation(SpotManager.ANIM_ADVANCE);
		SpotManager.getInstance(mContext).showSpotAds(mContext);
		
	}

//	private void addTab(String tag, int title_introduction, int title_icon,
//			int content) {
//		// TODO Auto-generated method stub
//		tabHost.addTab(tabHost
//				.newTabSpec(tag)
//				.setIndicator(getString(title_introduction),
//						getResources().getDrawable(title_icon))
//				.setContent(content));
//	}
	private void addTab(String tag, int title_introduction, int title_icon,
			Class ActivityClass) {
		// TODO Auto-generated method stub
		tabHost.addTab(tabHost
				.newTabSpec(tag)
				.setIndicator(getString(title_introduction),
						getResources().getDrawable(title_icon))
				.setContent(new Intent(this,ActivityClass)));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
