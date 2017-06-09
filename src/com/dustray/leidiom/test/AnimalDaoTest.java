package com.dustray.leidiom.test;

import java.util.List;

import com.dustray.leidiom.dao.AnimalDao;
import com.dustray.leidiom.entity.Animal;

import android.test.AndroidTestCase;

public class AnimalDaoTest extends AndroidTestCase {

	/**
	 * 获取所有动物
	 */
	
	public void testGetAllAnimals(){
		AnimalDao animalDao = AnimalDao.getInstance(getContext());
		List<Animal> animals = animalDao.getAllAnimals();
		System.out.println(animals.size());
		for(Animal animal:animals){
			System.out.println(animal.getName());
		}
	}
}
