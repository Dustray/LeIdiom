package com.dustray.leidiom;

import java.util.Random;

import com.dustray.leidiom.dao.AnimalDao;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

	String idiomStr = "";
	private TextView game_str1, game_str2, game_str3, game_str4;
	private Button game_show_str1, game_show_str2, game_show_str3,
			game_show_str4;

	int nowPosition = 0;
	int score = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		game_str1 = (TextView) findViewById(R.id.game_str1);
		game_str2 = (TextView) findViewById(R.id.game_str2);
		game_str3 = (TextView) findViewById(R.id.game_str3);
		game_str4 = (TextView) findViewById(R.id.game_str4);

		game_show_str1 = (Button) findViewById(R.id.game_show_str1);
		game_show_str2 = (Button) findViewById(R.id.game_show_str2);
		game_show_str3 = (Button) findViewById(R.id.game_show_str3);
		game_show_str4 = (Button) findViewById(R.id.game_show_str4);
		MyButton listener = new MyButton();
		game_show_str1.setOnClickListener(listener);
		game_show_str2.setOnClickListener(listener);
		game_show_str3.setOnClickListener(listener);
		game_show_str4.setOnClickListener(listener);

	}

	class MyButton implements OnClickListener {// 匿名内部类

		public void onClick(View view) {
			switch (view.getId()) {
			case R.id.game_show_str1:
				showMyAnswer(game_show_str1.getText().toString());
				break;
			case R.id.game_show_str2:
				showMyAnswer(game_show_str2.getText().toString());
				break;
			case R.id.game_show_str3:
				showMyAnswer(game_show_str3.getText().toString());
				break;
			case R.id.game_show_str4:
				showMyAnswer(game_show_str4.getText().toString());
				break;
			}
		}
	}

	public void showMyAnswer(String str) {// 显示选中的文字

		switch (nowPosition) {
		case 0:
			game_str1.setText(str);
			nowPosition++;
			break;
		case 1:
			game_str2.setText(str);
			nowPosition++;
			break;
		case 2:
			game_str3.setText(str);
			nowPosition++;
			break;
		case 3:
			game_str4.setText(str);
			nowPosition++;
			break;
		}
		if (nowPosition > 3) {
			nowPosition = 0;
			
			judgeAnswer();
		}

	}

	public void judgeAnswer() {
		String myAnswer = game_str1.getText().toString()
				+ game_str2.getText().toString()
				+ game_str3.getText().toString()
				+ game_str4.getText().toString();
		Log.e("GameActivity", "name=" + myAnswer + "=" + idiomStr);
		// 模式1
		if (idiomStr.equals(myAnswer)) {// 将我的答案和标准答案比对
			// 成功
			score++;
			TextView textview = (TextView)findViewById(R.id.myscore);
			textview.setText("分数："+score);
		} else {
			// 失败

		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Toast.makeText(GameActivity.this, e.toString(),1).show();
		}
		game_str1.setText("·");
		game_str2.setText("·");
		game_str3.setText("·");
		game_str4.setText("·");
		getIdiom();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	public void test(View view) {
		getIdiom();

	}

	public void getIdiom() {// 在选项区显示随机的成语
		AnimalDao ad = AnimalDao.getInstance(this);
		/**
		 * 随机数
		 */
		idiomStr = ad.getOneRandomAnimal();
		char[] stringArr = idiomStr.toCharArray();
		Random random = new Random();
		int rs[] = new int[4];
		for (int i = 1; i < rs.length; i++) {
			rs[i] = random.nextInt(4);
			for (int j = 0; j < i; j++) {
				if (rs[i] == rs[j]) {
					i--;
				}
			}
		}
		// for (int i = 0; i < rs.length; i++) {
		// System.out.println(rs[i] + "  ");
		// }

		game_show_str1.setText(String.valueOf(stringArr[rs[0]]));
		game_show_str2.setText(String.valueOf(stringArr[rs[1]]));
		game_show_str3.setText(String.valueOf(stringArr[rs[2]]));
		game_show_str4.setText(String.valueOf(stringArr[rs[3]]));

	}

}
