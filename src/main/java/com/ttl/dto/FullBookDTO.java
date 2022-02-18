package com.ttl.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class FullBookDTO {
    @Builder.Default
    private Integer Id = -1;
    private String Title;
    private String Description;

    private AuthorDTO Author;
}