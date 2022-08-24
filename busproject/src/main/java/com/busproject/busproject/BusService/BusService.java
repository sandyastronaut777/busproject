package com.busproject.busproject.BusService;

import com.busproject.busproject.Entity.Bus;
import com.busproject.busproject.model.BusRequestDto;
import com.busproject.busproject.model.BusResponseDto;
import com.busproject.busproject.util.APIResponse;

import java.util.List;

public interface BusService {

     APIResponse create(BusRequestDto busRequestDto);

     APIResponse update(BusRequestDto busRequestDto);

     APIResponse get(int busId);

     List<Bus> getBuses();

     APIResponse delete(int busId);

     APIResponse getBusData(BusRequestDto busRequestDto);

     APIResponse filterByStatus(BusRequestDto busRequestDto);


}
