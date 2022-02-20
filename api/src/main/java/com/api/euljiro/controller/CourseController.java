package com.api.euljiro.controller;

import com.core.euljiro.domain.Account;
import com.core.euljiro.domain.Course;
import com.core.euljiro.dto.AccountDTO;
import com.core.euljiro.dto.AdminDTO;
import com.core.euljiro.dto.CourseDTO;
import com.core.euljiro.service.AccountService;
import com.core.euljiro.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Validated
@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    ModelMapper modelMapper;

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("crsId") Long id,
                       @Valid @RequestBody CourseDTO vO) {
        courseService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CourseDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
        return courseService.getById(id);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@RequestBody CourseDTO courseDTO) {
        log.debug("######CourseDTO: " + courseDTO.toString());
        Course course = courseService.save(courseDTO);
        WebMvcLinkBuilder mvcLinkBuilder = linkTo(CourseController.class).slash(course.getCrsId());
        return ResponseEntity.created(mvcLinkBuilder.toUri()).body(modelMapper.map(course, CourseDTO.class));
    }

    @GetMapping
    public Page<CourseDTO> query(@Valid CourseDTO vo){ return courseService.query(vo); }

}
