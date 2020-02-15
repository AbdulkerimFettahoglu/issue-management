package com.kerimfettahoglu.issuemanagementkerim.api;

import com.kerimfettahoglu.issuemanagementkerim.dto.PersonalDto;
import com.kerimfettahoglu.issuemanagementkerim.service.impl.PersonalServiveImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personal")
public class PersonalController {

    private final PersonalServiveImpl personalServiveImpl;

    public PersonalController(PersonalServiveImpl personalServiveImpl) {
        this.personalServiveImpl = personalServiveImpl;
    }

    @GetMapping
    @RequestMapping("/get/{id}")
    public ResponseEntity<PersonalDto> getPersonal(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(personalServiveImpl.getAPersonal(id));
    }

    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity<PersonalDto> savePersonal(@RequestBody PersonalDto personalDto) {
        return ResponseEntity.ok(personalServiveImpl.save(personalDto));
    }

    @PutMapping
    @RequestMapping("/put")
    public ResponseEntity<PersonalDto> updatePersonal(@RequestBody PersonalDto personalDto) {
        return ResponseEntity.ok(personalServiveImpl.updatePersonal(personalDto));
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePersonal(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(personalServiveImpl.delete(id));
    }
}
