package com.springboot.wecare.service;

import java.util.List;

public interface IClientScheduleService {

	List<Long> getClientSchedule(Long clientId);

}
