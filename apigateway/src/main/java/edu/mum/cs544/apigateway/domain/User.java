package edu.mum.cs544.apigateway.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class User {
    private long id;
    private String username;
    private String password;
    private String name;



}
