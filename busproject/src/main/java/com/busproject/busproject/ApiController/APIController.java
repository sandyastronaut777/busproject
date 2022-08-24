package com.busproject.busproject.ApiController;


import com.busproject.busproject.BusService.BusService;
import com.busproject.busproject.Entity.Bus;
import com.busproject.busproject.model.BusRequestDto;
import com.busproject.busproject.model.BusResponseDto;
import com.busproject.busproject.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class APIController {

    @Autowired
    BusService busService;

    @RequestMapping(value="/bus/create", method = RequestMethod.POST)
    public APIResponse create(@RequestBody BusRequestDto busRequestDto)
    {
        return busService.create(busRequestDto);
    }

    @RequestMapping(value = "/bus/update", method = RequestMethod.PUT)
    public APIResponse update(@RequestBody BusRequestDto busRequestDto)
    {
        return busService.update(busRequestDto);
    }


    @RequestMapping(value = "/bus/get/{busId}", method = RequestMethod.GET)
    public APIResponse get(@PathVariable int busId)
    {
        return busService.get(busId);
    }

    @RequestMapping(value = "/bus/delete/{busId}", method = RequestMethod.DELETE)
    public APIResponse delete(@PathVariable int busId)
    {
        return busService.delete(busId);
    }

    @RequestMapping(value = "/bus/get/", method = RequestMethod.GET)
    public List<Bus> getBuses(BusResponseDto busResponseDto)
    {
        return busService.getBuses();
    }

    @RequestMapping(value = "/bus/get/all", method = RequestMethod.POST)
    public APIResponse getBusData(@RequestBody BusRequestDto busRequestDto)
    {
        return busService.getBusData(busRequestDto);
    }

    @RequestMapping(value = "/bus/get/status/{busId}", method = RequestMethod.GET)
    public APIResponse filterByStatus(@PathVariable int busId){

        return null;



    }
}
