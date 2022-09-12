package com.kurdestan.xanu.modules.house;

import com.kurdestan.xanu.common.PagingData;
import com.kurdestan.xanu.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/houses")
@AllArgsConstructor
public class HouseController {

    private final HouseService service;
    private HouseMapper mapper;

    @GetMapping("/v1/{id}")
    public ResponseEntity<HouseDTO> getHouse(@PathVariable Long id) {
        House house = service.getById(id);
        HouseDTO houseDTO = mapper.toHouseDTO(house);
        return ResponseEntity.ok(houseDTO);
    }

    @PostMapping("/v1")
    public ResponseEntity saveHouse(@RequestBody HouseDTO houseDTO) {
        House house = mapper.toHouse(houseDTO);
        service.save(house);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity updateHouse(@RequestBody HouseDTO houseDTO) {
        House house = mapper.toHouse(houseDTO);
        service.update(house);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity deleteHouse(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1")
    public ResponseEntity<List<HouseDTO>> getAll() {
        List<House> houseList = service.getAll();
        List<HouseDTO> houseDTOS = mapper.toHouseDTOList(houseList);
        return ResponseEntity.ok(houseDTOS);
    }

    @GetMapping("/v1/{title}")
    public ResponseEntity<HouseDTO> filterByTitle(@PathVariable String title) {
        House house = service.getByTitle(title);
        HouseDTO houseDTO = mapper.toHouseDTO(house);
        return ResponseEntity.ok(houseDTO);
    }

    @GetMapping("/v1/agency/{agencyId}/{page}/{size}")
    public ResponseEntity<PagingData<HouseDTO>> getAllPagingByAgency(@PathVariable Long agencyId, @PathVariable Integer page, @PathVariable Integer size) {
        Page<House> HousePage = service.pagingByAgencyId(agencyId, page, size);
        return getPagingDataResponseEntity(page, HousePage);
    }

    @GetMapping("/v1/region/{regionId}/{page}/{size}")
    public ResponseEntity<PagingData<HouseDTO>> getAllPagingByRegion(@PathVariable Long regionId, @PathVariable Integer page, @PathVariable Integer size) {
        Page<House> HousePage = service.pagingByRegionId(regionId, page, size);
        return getPagingDataResponseEntity(page, HousePage);
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<HouseDTO>> getAllPaging(@PathVariable Integer page, @PathVariable Integer size) {
        Page<House> HousePage = service.paging(page, size);
        return getPagingDataResponseEntity(page, HousePage);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<HouseDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<House> houseList = service.search(searchCriteria);
        List<HouseDTO> houseDTOS = mapper.toHouseDTOList(houseList);
        return ResponseEntity.ok(houseDTOS);
    }

    private ResponseEntity<PagingData<HouseDTO>> getPagingDataResponseEntity(@PathVariable Integer page, Page<House> HousePage) {
        int totalPage = HousePage.getTotalPages();
        List<House> data = HousePage.getContent();
        List<HouseDTO> houseDTOS = mapper.toHouseDTOList(data);
        PagingData<HouseDTO> pagingData = new PagingData<>(totalPage, page, houseDTOS);
        return ResponseEntity.ok(pagingData);
    }
}
