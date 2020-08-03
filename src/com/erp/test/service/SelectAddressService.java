package com.erp.test.service;

import java.util.List;

public interface SelectAddressService
{
	List<String> selectSidoList(String sido);
	List<String> selectGugunList(String sido);
	List<String> selectDongList(String sido, String gugun);
}
