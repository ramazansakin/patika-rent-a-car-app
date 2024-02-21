package com.patika.rsakin.patikarentacarservice.service;

import com.patika.rsakin.patikarentacarservice.model.entity.Brand;
import com.patika.rsakin.patikarentacarservice.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }

    public Brand updateBrand(Long id, Brand updatedBrand) {
        updatedBrand.setId(id);
        return brandRepository.save(updatedBrand);
    }

}