package com.example.controller;

import com.example.model.Tag;
import com.example.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/API")
public class TagController {

    private TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/etiquetas")
    public List<Tag> retrieveAllTags() {
        return tagService.retrieveAllTags();
    }

    @GetMapping("/etiquetas/{id}")
    public ResponseEntity<Tag> retrieveTagById(@PathVariable Long id) {
        return ResponseEntity.ok().body(tagService.retrieveTagById(id));
    }

    @PostMapping("/etiquetas")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) throws URISyntaxException {
        if (tag.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Tag tagCreation = tagService.createTag(tag);
            return ResponseEntity.created(new URI("/API/tag" + tagCreation.getId())).body(tagCreation);
        }

    }
    @PutMapping("/etiquetas/{id}")
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag){
        if(tag.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return ResponseEntity.ok().body(tagService.updateTag(tag));
        }
    }

    @DeleteMapping("etiquetas/{id}")
    public void deleteTag(@PathVariable Long id){
        tagService.deleteTag(id);
    }


}