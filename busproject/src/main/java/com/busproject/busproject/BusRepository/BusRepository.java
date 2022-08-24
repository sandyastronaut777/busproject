package com.busproject.busproject.BusRepository;


import com.busproject.busproject.Entity.Bus;
import com.busproject.busproject.Entity.BusStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository<INTEGER> extends JpaRepository<Bus, INTEGER> {

    Bus findById(int busId);

    List<Bus> findAll();

    @Query(value = "select * from bus.bus where (Case when '0'=?1 then name is not null else name=?1 End)" +
            "AND (Case when '0'=?2 then type is not null else type=?2 End)"+
            "AND (Case when '0'=?3 then number is not null else number=?3 End)",
            nativeQuery = true)

    List<Bus> getData(String name, String type, String number);

    List<Bus> filterByStatus(BusStatus busStatus);



}
