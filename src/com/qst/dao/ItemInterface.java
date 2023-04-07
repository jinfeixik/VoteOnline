package com.qst.dao;

import com.qst.entity.Item;

public interface ItemInterface {
	public void addItem(Item item);
	public void deleteItem(int VS_ID);
	public int findItemVSID(int VS_ID);
}
