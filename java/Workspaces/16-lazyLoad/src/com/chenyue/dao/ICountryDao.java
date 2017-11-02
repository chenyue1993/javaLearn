package com.chenyue.dao;

import com.chenyue.beans.Country;

public interface ICountryDao {
	Country selectCountryById(int cid);
}
