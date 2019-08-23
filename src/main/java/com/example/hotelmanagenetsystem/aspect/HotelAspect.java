package com.example.hotelmanagenetsystem.aspect;

import com.example.hotelmanagenetsystem.exception.RoomNotFoundException;
import com.example.hotelmanagenetsystem.model.Rooms;
import com.example.hotelmanagenetsystem.repository.RoomRepostiory;
import com.example.hotelmanagenetsystem.service.RoomService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;



@Aspect
@Component
public class HotelAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final RoomService roomService;

    private final RoomRepostiory roomRepostiory;

    public HotelAspect(RoomService roomService,RoomRepostiory roomRepostiory) {
        this.roomService = roomService;
        this.roomRepostiory = roomRepostiory;
    }

    @Before("execution(* *.processRooms(..))")
    public void roomNumberAspect(JoinPoint joinPoint){
        Object [] args = joinPoint.getArgs();
        boolean roomNumberSame = false;

        Rooms room =(Rooms)args[0];
        logger.info("Room Number: " + room.getRoomsNumber());


           for (Rooms rooms:roomService.findAll()){
               if(rooms.getRoomsNumber().equals(room.getRoomsNumber())){
                   roomNumberSame=true;
               }
           }
           if(roomNumberSame){
              throw new IllegalArgumentException(room.getRoomsNumber()+"Rooms are already existed.");
           }
        }
        @Before("execution(* *.showRoomDetails(..))")
        public void roomNotFoundAspect(JoinPoint joinPoint){
            Object[] args = joinPoint.getArgs();
            Rooms rooms = roomService.findById((long)args[1]);
            if(rooms==null) {
                throw new EntityNotFoundException((long)args[1]+ "Not Found");
            }
        }
        @Before("execution(* *.findByRommsNumber(..))")
        public void roomNotFoundFindAspect(JoinPoint joinpoint){
        Object[] arg = joinpoint.getArgs();
        Rooms rooms = roomRepostiory.findByRoomsNumber(String.valueOf(arg[0]))
                .orElseThrow(()->new RoomNotFoundException(arg[0]+" Not Found."));

        }
}
