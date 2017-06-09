package com.dustray.leidiom.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.R.integer;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dustray.leidiom.db.DBOpenHelper;
import com.dustray.leidiom.entity.Animal;

public class AnimalDao {

	private static AnimalDao animalDao;

	private SQLiteDatabase db;

	/**
	 * 构造方法私有化
	 */

	private AnimalDao(Context context) {
		DBOpenHelper dbHelper = new DBOpenHelper(context);
		db = dbHelper.openDatabase();
	}

	/**
	 * 获取AnimalDao的实例
	 */

	public synchronized static AnimalDao getInstance(Context context) {

		if (animalDao == null) {
			animalDao = new AnimalDao(context);
		}

		return animalDao;
	}

	/**
	 * 从数据库读取所有被的动物类成语
	 */

	public List<Animal> getAllAnimals() {

		List<Animal> list = new ArrayList<Animal>();
		Cursor cursor = db.query("animal", null, null, null, null, null, null);

		if (cursor.moveToFirst()) {
			do {
				Animal animal = new Animal();

				animal.setId(cursor.getInt(cursor.getColumnIndex("_id")));
				animal.setName(cursor.getString(cursor.getColumnIndex("name")));
				animal.setPronounce(cursor.getString(cursor
						.getColumnIndex("pronounce")));
				animal.setAntonym(cursor.getString(cursor
						.getColumnIndex("antonym")));
				animal.setHomoionym(cursor.getString(cursor
						.getColumnIndex("homoionym")));
				animal.setDerivation(cursor.getString(cursor
						.getColumnIndex("derivation")));
				animal.setExamples(cursor.getString(cursor
						.getColumnIndex("examples")));
				animal.setExplain(cursor.getString(cursor
						.getColumnIndex("explain")));
				list.add(animal);
			} while (cursor.moveToNext());
		}
		return list;
	}

	/**
	 * 从数据库读取一个随机动物类
	 */
	@SuppressWarnings("null")
	public String getOneRandomAnimal() {
		String str = "";
		int maxSize = getAllAnimals().size();
		Random r = new Random();
		String[] getNum = { "1" };

		getNum[0] = Integer.toString(r.nextInt(maxSize));
		Cursor cursor = db.query("animal", null, "_id=?", getNum, null, null,
				null);
		if (cursor.moveToFirst()) {
			do {
				str = cursor.getString(cursor.getColumnIndex("name"));
			} while (cursor.moveToNext());
		}
		return str;
	}
}
