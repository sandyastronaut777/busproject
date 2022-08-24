package com.busproject.busproject.BusService.impl;


import com.busproject.busproject.BusRepository.BusRepository;
import com.busproject.busproject.BusService.BusService;
import com.busproject.busproject.Entity.Bus;
import com.busproject.busproject.Entity.BusStatus;
import com.busproject.busproject.model.BusRequestDto;
import com.busproject.busproject.model.BusResponseDto;
import com.busproject.busproject.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    BusRepository busRepository;

    @Override
    public APIResponse create(BusRequestDto busRequestDto) {
        Bus bus = new Bus();
        bus = putDataInEntity(bus, busRequestDto);
        busRepository.save(bus);
        return new APIResponse(200, "success", "Successfully Created", null);
    }

    private Bus putDataInEntity(Bus bus, BusRequestDto busRequestDto) {

        bus.setName(busRequestDto.getName());
        bus.setType(busRequestDto.getType());
        bus.setNumber(busRequestDto.getNumber());
        return bus;
    }

    @Override
    public APIResponse update(BusRequestDto busRequestDto) {
        Bus bus = busRepository.findById(busRequestDto.getBusId());
        bus.setName(busRequestDto.getName());
        bus.setNumber(busRequestDto.getNumber());
        busRepository.save(bus);
        return new APIResponse(200, "success", "Successfuly update", null);
    }

    @Override
    public APIResponse get(int busId) {
        Bus bus = busRepository.findById(busId);
        
        return new APIResponse(200, "success", null, getDataFromEntity(bus));
    }

    @Override
    public List<Bus> getBuses() {
        List<Bus> list = new ArrayList<>();
        list = busRepository.findAll();
        return list;
    }

    private BusResponseDto getDataFromEntity(Bus bus) {
        BusResponseDto busResponseDto = new BusResponseDto();
        busResponseDto.setName(bus.getName());
        busResponseDto.setType(bus.getType());
        busResponseDto.setNumber(bus.getNumber());
        return busResponseDto;
    }

    @Override
    public APIResponse delete(int busId) {

        Bus bus = busRepository.findById(busId);
        busRepository.delete(bus);

        return new APIResponse(200, "success", "Successully Deleted", null);
    }

    @Override
    public APIResponse getBusData(BusRequestDto busRequestDto) {

        String name = busRequestDto.getName();
        if (name == null || name == "" || Objects.isNull(name)) {

            name = "0";
        }
        String type = busRequestDto.getType();
        if (type == null || type == "" || Objects.isNull(type)) {

            type = "0";
        }
        String number = busRequestDto.getNumber();
        if (number == null || number == "" || Objects.isNull(number)) {

            number = "0";
        }
        List<Bus> bus = busRepository.getData(name, type, number);
        List<BusResponseDto> busResponseDto = new ArrayList<>();
        if (!bus.isEmpty()) {
            busResponseDto = bus.stream().map(this::getDataFromEntity).collect(Collectors.toList());
            return  new APIResponse(200, "success", "success", busResponseDto);

        }

        else{
            return  new APIResponse(200, "success", "no match found", busResponseDto);
        }


    }

    @Override
    public APIResponse filterByStatus(BusRequestDto busRequestDto) {
        return null;
    }


}
