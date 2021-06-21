package com.digitalinnovationone.personapi.service;

import com.digitalinnovationone.personapi.dto.message.MessageResponseDTO;
import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.entity.Person;
import com.digitalinnovationone.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private  PersonService personService;

    @Test
    void testPersonDTOSuppliedReturnSavedMessage() {
        PersonDTO pessoaDTO = createFakeDTO();
        Person personSavedExpected = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(personSavedExpected);

        MessageResponseDTO successMessageExpected = createExpectedMessageResponse(personSavedExpected.getId());
        MessageResponseDTO successMessageRetuned = personService.createPerson(pessoaDTO);

        assertEquals(successMessageExpected, successMessageRetuned);
    }
//vrf
    private Person createFakeEntity() {
        return null;
    }
//vrf
    private PersonDTO createFakeDTO() {
        return null;
    }
    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Foi criada uma pessoa com ID " + id + "!")
                .build();
    }
}