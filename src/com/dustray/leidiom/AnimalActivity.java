package com.dustray.leidiom;

import java.util.List;

import com.dustray.leidiom.adapter.AnimalAdapter;
import com.dustray.leidiom.dao.AnimalDao;
import com.dustray.leidiom.entity.Animal;
import com.dustray.leidiom.util.DialogUtil;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class AnimalActivity extends Activity {
	private List<Animal> animalList;
	private AnimalDao animalDao;
	private ListView lvAnimalList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animal);
		initAnimals();
		lvAnimalList = (ListView) findViewById(R.id.lvAnimalList);
		AnimalAdapter animalAdapter = new AnimalAdapter(this,
				R.layout.animal_item, animalList);
		lvAnimalList.setAdapter(animalAdapter);
		// �������
		lvAnimalList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Animal animal = animalList.get(position);
				String result = animal.getName() + "\n" + animal.getPronounce()
						+ "\n�����͡���" + animal.getExplain() + "\n������ʡ���"
						+ animal.getHomoionym() + "\n������ʡ���"
						+ animal.getAntonym() + "\n����Դ����"
						+ animal.getDerivation() + "\n��ʾ������"
						+ animal.getExamples();
				DialogUtil.showDialog(result,AnimalActivity.this);
			}

		});
	}

	private void initAnimals() {
		// TODO Auto-generated method stub
		animalDao = AnimalDao.getInstance(this);
		animalList = animalDao.getAllAnimals();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.animal, menu);
		return true;
	}

}
