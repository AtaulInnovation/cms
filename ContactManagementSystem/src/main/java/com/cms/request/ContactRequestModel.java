package com.cms.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestModel {
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;
}
