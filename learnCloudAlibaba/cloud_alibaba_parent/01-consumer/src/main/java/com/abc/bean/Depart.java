package com.abc.bean;

import lombok.Data;

@Data//作用相当于：@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
public class Depart {
    private Integer id;
    private String name;
}
