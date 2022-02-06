package com.ttl.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO {
    @Builder.Default
    private Integer Id = -1;
    private String Login;
    private String Name;
}
