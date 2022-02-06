package com.ttl.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthorDTO {
    @Builder.Default
    private Integer Id = -1;
    private String Name;
    private String Surname;
}
