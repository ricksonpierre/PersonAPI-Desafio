package com.digitalinnovationone.personapi.Utils;

import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.entity.Person;
import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {

    private static final Long PERSON_ID = 1L;
    private static final String FIRST_NAME="Rickson";
    private static final String LAST_NAME="Silva";
    private static final String CPF="123.456.789-10";
    private static final LocalDate BIRTH_DATE=LocalDate.of(1989,11,30);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(LocalDate.parse("06-05-1999"))
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }
    public static Person createFakeEntity() {
        return Person.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
