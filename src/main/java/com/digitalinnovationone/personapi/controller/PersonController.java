package com.digitalinnovationone.personapi.controller;

import com.digitalinnovationone.personapi.dto.message.MessageResponseDTO;
import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.exceptions.PersonNotFoundException;
import com.digitalinnovationone.personapi.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }
    @GetMapping
    public List<PersonDTO> listAllPeople(){
        return personService.listAll();
    }
    @GetMapping("/{id}")
    public PersonDTO findID(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id,
                                         @RequestBody
                                         @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }
}
