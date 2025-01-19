package com.example.javaBlog.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    
    @Id
    private long id;
    private String username;
    private String password;

}
