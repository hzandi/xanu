package com.kurdestan.xanu.modules.image;

import com.kurdestan.xanu.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    @Caching(evict = {
            @CacheEvict(value = "imageCache", allEntries = true),
    })
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "imageCache", allEntries = true),
    })
    public Image update(Image image) {
        Image lastSavedImage = getById(image.getId());
        lastSavedImage.setName(image.getName());
        lastSavedImage.setIsPreview(image.getIsPreview());
        lastSavedImage.setOrderIndex(image.getOrderIndex());
        lastSavedImage.setProperty(image.getProperty());
        return imageRepository.save(lastSavedImage);
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "imageCache", allEntries = true),
    })
    public void delete(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "imageCache", key = "#id")
    public Image getById(Long id) {
        Optional<Image> optionalVehicle = imageRepository.findById(id);
        if (optionalVehicle.isEmpty()) {
            throw new NotFoundException("Image Not Found!");
        }
        return optionalVehicle.get();
    }

    @Override
    @Cacheable(value = "imageCache", key = "#name")
    public Image getByName(String name) {
        Optional<Image> optionalImage = imageRepository.findByName(name);
        if (optionalImage.isEmpty()) {
            throw new NotFoundException("Image Not Found!");
        }
        return optionalImage.get();
    }

    @Override
    @Cacheable(value = "imageCache")
    public List<Image> getAllByPropertyId(Long id) {
        return (List<Image>) imageRepository.findAllByProperty_Id(id);
    }

    @Override
    @Cacheable(value = "imageCache")
    public List<Image> getAll() {
        return (List<Image>) imageRepository.findAll();
    }

}



