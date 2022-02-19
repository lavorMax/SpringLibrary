package com.ttl.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookDTO {
    @Builder.Default
    private Integer Id = -1;
    private String Title;
    private String Description;
    @Builder.Default
    private Integer AuthorId = -1;
}