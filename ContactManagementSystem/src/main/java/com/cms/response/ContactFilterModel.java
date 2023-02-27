package com.cms.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactFilterModel {
    String firstName;
    String lastName;
    String email;
}
