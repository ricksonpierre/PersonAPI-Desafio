package com.digitalinnovationone.personapi.Utils;

import com.digitalinnovationone.personapi.dto.request.PhoneDTO;
import com.digitalinnovationone.personapi.entity.Phone;
import com.digitalinnovationone.personapi.enums.PhoneType;

public class PhoneUtils {

    private static final Long PHONE_ID = 1L;
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final String PHONE_NUMBER="(21)99999-9999";

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
