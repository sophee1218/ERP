package com.erp.test.dao;

import java.util.List;

public interface SelectAddressDAO
{
	List<String> selectSidoList(String sido);
	List<String> selectGugunList(String sido);
	List<String> selectDongList(String sido, String gugun);
}
