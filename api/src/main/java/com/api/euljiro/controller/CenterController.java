package com.api.euljiro.controller;

import com.core.euljiro.domain.Center;
import com.core.euljiro.dto.CenterDTO;
import com.core.euljiro.repository.CenterRepository;
import com.core.euljiro.service.CenterService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Validated
@RestController
@RequestMapping("/center")
@RequiredArgsConstructor
public class CenterController {

    private final CenterService centerService;
    private final CenterRepository centerRepository;
    private final ModelMapper modelMapper;

    // 센터등록
    @PostMapping
    public ResponseEntity<CenterDTO> createCenter(@RequestBody @Valid CenterDTO centerDTO) {
        Center center = modelMapper.map(centerDTO, Center.class);
        Center newCenter = centerRepository.save(center);
        WebMvcLinkBuilder mvcLinkBuilder = linkTo(CenterController.class).slash(newCenter.getCenterId());

        return ResponseEntity.created(mvcLinkBuilder.toUri()).body(modelMapper.map(newCenter, CenterDTO.class));
    }

    // 센터리스트
    @GetMapping
    public ResponseEntity listCenter(Pageable pageable,
                                     PagedResourcesAssembler<Center> assembler) {
        Page<Center> page = centerRepository.findAll(pageable);
        PagedModel pagedModel = assembler.toModel(page, center -> new EntityModel<Center>(center)
                                            .add(linkTo(CenterController.class)
                                                .slash(center.getCenterId())
                                                    .withSelfRel()));

        return ResponseEntity.ok(pagedModel);
    }

    // 센터조회
    @GetMapping("/{id}")
   public ResponseEntity getCenter(@Valid @NotNull @PathVariable("id") Integer id) {
        Optional<Center> center = centerRepository.findById(id);

        if(!center.isPresent())
            return ResponseEntity.notFound().build();
        //EntityModel<Center> centerEntityModel = new EntityModel<Center>(center);

        return ResponseEntity.ok(center);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@Valid @NotNull @PathVariable("id") Integer id) {
        Optional<Center> center = centerRepository.findById(id);

        if(center.isPresent())
            centerService.delete(id);
        else
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(center);
    }


//    @Autowired
//    private CenterService centerService;
//
//    @PostMapping
//    public String save(@Valid @RequestBody CenterDTO vO) {
//        return centerService.save(vO).toString();
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
//        centerService.delete(id);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@Valid @NotNull @PathVariable("id") Integer id,
//                       @Valid @RequestBody CenterDTO vO) {
//        centerService.update(id, vO);
//    }
//
//    @GetMapping("/{id}")
//    public CenterDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
//        return centerService.getById(id);
//    }
//
//    @GetMapping
//    public Page<CenterDTO> query(@Valid CenterDTO vO) {
//        return centerService.query(vO);
//    }
}
