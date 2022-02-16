package com.ttl.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Author {
    private Integer Id;
    private String Name;
    private String Surname;
}