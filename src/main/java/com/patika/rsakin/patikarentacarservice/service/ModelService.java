package com.patika.rsakin.patikarentacarservice.service;

import com.patika.rsakin.patikarentacarservice.model.entity.Model;
import com.patika.rsakin.patikarentacarservice.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public Model createModel(Model model) {
        return modelRepository.save(model);
    }

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Model getModelById(Long id) {
        return modelRepository.findById(id).orElse(null);
    }

    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    public Model updateModel(Long id, Model updatedModel) {
        updatedModel.setId(id);
        return modelRepository.save(updatedModel);
    }

}