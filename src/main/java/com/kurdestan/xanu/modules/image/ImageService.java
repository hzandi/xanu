package com.kurdestan.xanu.modules.image;

import java.util.List;


public interface ImageService {
    Image save(Image image);
    Image update(Image image);
    void delete(Long id);
    Image getById(Long id);
    Image getByName(String name);
    List<Image> getAllByHouseId(Long id);
    List<Image> getAll();
}