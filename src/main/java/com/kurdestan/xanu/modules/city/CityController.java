package com.kurdestan.xanu.modules.city;

import com.kurdestan.xanu.common.PagingData;
import com.kurdestan.xanu.common.SearchCriteria;
import com.kurdestan.xanu.modules.agency.Agency;
import com.kurdestan.xanu.modules.agency.AgencyDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/cities/")
@AllArgsConstructor
public class CityController {

    private final CityService service;
    private CityMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody CityDTO cityDTO) {
        City city = mapper.toCity(cityDTO);
        service.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody CityDTO cityDTO) {
        City city = mapper.toCity(cityDTO);
        service.update(city);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{name}")
    public ResponseEntity<CityDTO> getAllByName(@PathVariable String name) {
        City city = service.getByName(name);
        CityDTO cityDTO = mapper.toCityDTO(city);
        return ResponseEntity.ok(cityDTO);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable Long id) {
        City city = service.getById(id);
        CityDTO cityDTO = mapper.toCityDTO(city);
        return ResponseEntity.ok(cityDTO);
    }

    @GetMapping("/v1")
    public ResponseEntity<List<CityDTO>> getAll() {

        List<City> cityList = service.getAll();
        List<CityDTO> cityDTOS = mapper.toCityDTOList(cityList);

        return ResponseEntity.ok(cityDTOS);
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<CityDTO>> Paging(@PathVariable Integer page, @PathVariable Integer size) {
        Page<City> cityPage = service.paging(page, size);
        return getPagingDataResponseEntity(page, cityPage);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<CityDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<City> cityList = service.search(searchCriteria);
        List<CityDTO> cityDTOS = mapper.toCityDTOList(cityList);
        return ResponseEntity.ok(cityDTOS);
    }

    private ResponseEntity<PagingData<CityDTO>> getPagingDataResponseEntity(@PathVariable Integer page, Page<City> cityPage) {
        int totalPage = cityPage.getTotalPages();
        List<City> data = cityPage.getContent();
        List<CityDTO> cityDTOS = mapper.toCityDTOList(data);
        PagingData<CityDTO> pagingData = new PagingData<>(totalPage, page, cityDTOS);
        return ResponseEntity.ok(pagingData);
    }

}


