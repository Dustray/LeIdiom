package com.dustray.leidiom.test;

import com.dustray.leidiom.db.DBOpenHelper;

import android.test.AndroidTestCase;

public class DBOpenHelperTest extends AndroidTestCase {
	/**
	 * ²âÊÔ¸´ÖÆÊý¾Ý¿â
	 */
	public void testDBCopy(){
		DBOpenHelper dbOpenHelper = new DBOpenHelper(getContext());
		dbOpenHelper.openDatabase();
	}
}
