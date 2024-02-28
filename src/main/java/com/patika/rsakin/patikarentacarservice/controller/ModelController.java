package com.patika.rsakin.patikarentacarservice.controller;

import com.patika.rsakin.patikarentacarservice.model.entity.Model;
import com.patika.rsakin.patikarentacarservice.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping
    public Model createModel(@RequestBody Model model) {
        return modelService.createModel(model);
    }

    @GetMapping
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping("/{id}")
    public Model getModelById(@PathVariable Long id) {
        return modelService.getModelById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteModel(@PathVariable Long id) {
        modelService.deleteModel(id);
    }

    @PutMapping("/{id}")
    public Model updateModel(@PathVariable Long id, @RequestBody Model updatedModel) {
        return modelService.updateModel(id, updatedModel);
    }

}