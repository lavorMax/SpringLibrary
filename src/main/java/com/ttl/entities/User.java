package com.ttl.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private Integer Id;
    private String Login;
    private String Password;
    private String Name;
}