package com.SADB;

import java.util.ArrayList;
import java.util.List;

public class CollectionAdapterDB implements AdapterDB {
	private List<AdapterDB> child;

	public CollectionAdapterDB() {
		child = new ArrayList<>();
	}

	@Override
	public List<Object> pull() {
		List<Object> res = new ArrayList();
		for (AdapterDB adapterDB : child) {
			res.addAll(adapterDB.pull());
		}
		return res;
	}

	@Override
	public void push(List<Object> updates) {
		for (AdapterDB adapterDB : child) {
			adapterDB.push(updates);
		}
	}
}
