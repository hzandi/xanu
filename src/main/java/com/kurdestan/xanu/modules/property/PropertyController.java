package com.kurdestan.xanu.modules.property;

import com.kurdestan.xanu.common.PagingData;
import com.kurdestan.xanu.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/properties")
@AllArgsConstructor
public class PropertyController {

    private final PropertyService service;
    private PropertyMapper mapper;

    @GetMapping("/v1/{id}")
    public ResponseEntity<PropertyDTO> getProperty(@PathVariable Long id) {
        Property property = service.getById(id);
        PropertyDTO propertyDTO = mapper.toPropertyDTO(property);
        return ResponseEntity.ok(propertyDTO);
    }

    @PostMapping("/v1")
    public ResponseEntity saveProperty(@RequestBody PropertyDTO propertyDTO) {
        Property property = mapper.toProperty(propertyDTO);
        service.save(property);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity updateProperty(@RequestBody PropertyDTO propertyDTO) {
        Property property = mapper.toProperty(propertyDTO);
        service.update(property);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity deleteProperty(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1")
    public ResponseEntity<List<PropertyDTO>> getAll() {
        List<Property> propertyList = service.getAll();
        List<PropertyDTO> propertyDTOS = mapper.toPropertyDTOList(propertyList);
        return ResponseEntity.ok(propertyDTOS);
    }

    @GetMapping("/v1/{title}")
    public ResponseEntity<PropertyDTO> filterByTitle(@PathVariable String title) {
        Property property = service.getByTitle(title);
        PropertyDTO propertyDTO = mapper.toPropertyDTO(property);
        return ResponseEntity.ok(propertyDTO);
    }

    @GetMapping("/v1/agency/{agencyId}/{page}/{size}")
    public ResponseEntity<PagingData<PropertyDTO>> getAllPagingByAgency(@PathVariable Long agencyId, @PathVariable Integer page, @PathVariable Integer size) {
        Page<Property> propertyPage = service.pagingByAgencyId(agencyId, page, size);
        return getPagingDataResponseEntity(page, propertyPage);
    }

    @GetMapping("/v1/region/{regionId}/{page}/{size}")
    public ResponseEntity<PagingData<PropertyDTO>> getAllPagingByRegion(@PathVariable Long regionId, @PathVariable Integer page, @PathVariable Integer size) {
        Page<Property> propertyPage = service.pagingByRegionId(regionId, page, size);
        return getPagingDataResponseEntity(page, propertyPage);
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<PropertyDTO>> getAllPaging(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Property> propertyPage = service.paging(page, size);
        return getPagingDataResponseEntity(page, propertyPage);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<PropertyDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<Property> propertyList = service.search(searchCriteria);
        List<PropertyDTO> propertyDTOS = mapper.toPropertyDTOList(propertyList);
        return ResponseEntity.ok(propertyDTOS);
    }

    private ResponseEntity<PagingData<PropertyDTO>> getPagingDataResponseEntity(@PathVariable Integer page, Page<Property> propertyPage) {
        int totalPage = propertyPage.getTotalPages();
        List<Property> data = propertyPage.getContent();
        List<PropertyDTO> propertyDTOS = mapper.toPropertyDTOList(data);
        PagingData<PropertyDTO> pagingData = new PagingData<>(totalPage, page, propertyDTOS);
        return ResponseEntity.ok(pagingData);
    }
}
