package com.projects.usermanagement.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 3710508851736804966L;

    private long userId;
    private String loginId;
    private String firstName;
    private String LastName;
}
