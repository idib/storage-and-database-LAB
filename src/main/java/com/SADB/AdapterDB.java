package com.SADB;

import java.util.List;

public interface AdapterDB {
	List<Object> pull();

	void push(List<Object> updates);
}
