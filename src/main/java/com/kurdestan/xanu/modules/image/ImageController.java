package com.kurdestan.xanu.modules.image;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/images/")
@AllArgsConstructor
public class ImageController {

    private final ImageService service;
    private ImageMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody ImageDTO imageDTO) {
        Image image = mapper.toImage(imageDTO);
        service.save(image);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody ImageDTO imageDTO) {
        Image image = mapper.toImage(imageDTO);
        service.update(image);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{name}")
    public ResponseEntity<ImageDTO> getAllByName(@PathVariable String name) {
        Image image = service.getByName(name);
        ImageDTO imageDTO = mapper.toImageDTO(image);
        return ResponseEntity.ok(imageDTO);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<ImageDTO> getById(@PathVariable Long id) {
        Image image = service.getById(id);
        ImageDTO imageDTO = mapper.toImageDTO(image);
        return ResponseEntity.ok(imageDTO);
    }

    @GetMapping("/v1/property/{propertyId}")
    public ResponseEntity<List<ImageDTO>> getAllByPropertyId(@PathVariable Long propertyId) {
        List<Image> imageList = service.getAllByPropertyId(propertyId);
        List<ImageDTO> imageDTOS = mapper.toImageDTOList(imageList);
        return ResponseEntity.ok(imageDTOS);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<ImageDTO>> getAll() {
        List<Image> imageList = service.getAll();
        List<ImageDTO> imageDTOS = mapper.toImageDTOList(imageList);
        return ResponseEntity.ok(imageDTOS);
    }

}



