package com.digitalinnovationone.personapi.dto.request;

import com.digitalinnovationone.personapi.enums.PhoneType;
import jdk.jshell.Snippet;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

    public static Snippet builder() {
    }
}
