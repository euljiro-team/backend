package com.api.euljiro.controller;

import com.core.euljiro.domain.CourseReservation;
import com.core.euljiro.dto.CourseDTO;
import com.core.euljiro.dto.CourseReservationDto;
import com.core.euljiro.service.CourseReservationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Validated
@RestController
@RequestMapping("/reservation")
@Slf4j
public class CourseReservationController {

    @Autowired
    CourseReservationService courseReservationService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{mmbrshpId}")
    public List<CourseDTO> getCourseList(
            @PathVariable("mmbrshpId") int mmbrshpId,
            @RequestParam("userId") int userId,
            @RequestParam("cntrId") int cntrId,
            @RequestParam("baseDt") String baseDt
    ){
        return courseReservationService.getCourseList(mmbrshpId, userId, cntrId,baseDt);
    }

    @PostMapping("/{mmbrshpId}")
    public ResponseEntity<CourseReservationDto> reserveOneCourse(
            @RequestBody CourseReservationDto courseReservationDto){
        CourseReservation courseReservation =  courseReservationService.saveCrsSrv(courseReservationDto);
        WebMvcLinkBuilder mvcLinkBuilder = linkTo(CourseReservationController.class).slash(courseReservation.getCrsId());
        return ResponseEntity.created(mvcLinkBuilder.toUri()).body(modelMapper.map(courseReservation, CourseReservationDto.class));
    }

    @DeleteMapping("/{mmbrshpId}")
    public void deleteReservation(@RequestBody CourseReservationDto courseReservationDto){
        courseReservationService.delReservation(courseReservationDto);
    }
}



