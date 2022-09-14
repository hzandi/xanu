package com.kurdestan.xanu.modules.region;

import com.kurdestan.xanu.common.PagingData;
import com.kurdestan.xanu.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/regions/")
@AllArgsConstructor
public class RegionController {

    private final RegionService service;
    private RegionMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<?> save(@RequestBody RegionDTO regionDTO) {
        Region region = mapper.toRegion(regionDTO);
        service.save(region);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<?> update(@RequestBody RegionDTO regionDTO) {
        Region region = mapper.toRegion(regionDTO);
        service.update(region);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{name}")
    public ResponseEntity<RegionDTO> getAllByName(@PathVariable String name) {
        Region region = service.getByName(name);
        RegionDTO regionDTO = mapper.toRegionDTO(region);
        return ResponseEntity.ok(regionDTO);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<RegionDTO> getById(@PathVariable Long id) {
        Region region = service.getById(id);
        RegionDTO regionDTO = mapper.toRegionDTO(region);
        return ResponseEntity.ok(regionDTO);
    }

    @GetMapping("/v1/city/{cityId}")
    public ResponseEntity<List<RegionDTO>> getAllByCityId(@PathVariable Long cityId) {
        List<Region> regionList = service.getAllByCityId(cityId);
        List<RegionDTO> regionDTOS = mapper.toRegionDTOList(regionList);
        return ResponseEntity.ok(regionDTOS);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<RegionDTO>> getAll() {
        List<Region> regionList = service.getAll();
        List<RegionDTO> regionDTOS = mapper.toRegionDTOList(regionList);
        return ResponseEntity.ok(regionDTOS);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<RegionDTO>> Paging(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Region> regionPage = service.paging(page, size);
        return getPagingDataResponseEntity(page, regionPage);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<RegionDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<Region> regionList = service.search(searchCriteria);
        List<RegionDTO> regionDTOS = mapper.toRegionDTOList(regionList);
        return ResponseEntity.ok(regionDTOS);
    }

    private ResponseEntity<PagingData<RegionDTO>> getPagingDataResponseEntity(@PathVariable Integer page, Page<Region> regionPage) {
        int totalPage = regionPage.getTotalPages();
        List<Region> data = regionPage.getContent();
        List<RegionDTO> regionDTOS = mapper.toRegionDTOList(data);
        PagingData<RegionDTO> pagingData = new PagingData<>(totalPage, page, regionDTOS);
        return ResponseEntity.ok(pagingData);
    }

}


