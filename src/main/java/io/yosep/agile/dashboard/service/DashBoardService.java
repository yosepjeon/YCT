package io.yosep.agile.dashboard.service;

import javax.servlet.http.HttpSession;

import io.yosep.agile.dashboard.model.dto.DashBoardDTO;

public interface DashBoardService {
	// 01. 대시보드 요소들 가져오기
	public void getDashBoardElements(String projectId, DashBoardDTO dashBoardDTO,HttpSession session);
}
