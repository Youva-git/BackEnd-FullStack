package com.fullstack.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangerMdpUserDto {
    private String email;
    private String mdp;
    private String ConfirmationMpd;


}
