package com.ttl.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Book {
    private Integer Id;
    private String Title;
    private String Description;
    private Integer AuthorId;
}
