package com.digitalinnovationone.personapi.service;

import com.digitalinnovationone.personapi.dto.message.MessageResponseDTO;
import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.entity.Person;
import com.digitalinnovationone.personapi.exceptions.PersonNotFoundException;
import com.digitalinnovationone.personapi.mapper.PersonMapper;
import com.digitalinnovationone.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
            return createMessageResponse(savedPerson.getId(), "Foi criada uma pessoa com o ID ");
        }
    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople
                .stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
        }
    public PersonDTO findById(Long id) throws PersonNotFoundException{

        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }
    public void delete(Long id) throws PersonNotFoundException{

        verifyIfExists(id);
        personRepository.deleteById(id);
    }
    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Atualização efetuada para a pessoa com o ID ");
    }
    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id + "!")
                .build();
    }
    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}