package com.fullstack.backend.utils.modeleEndPoint;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleUserFrom {
    private String email;
    private String roleName;
}
