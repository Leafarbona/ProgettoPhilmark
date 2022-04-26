package it.philmark.docenza.DTO;

import it.philmark.docenza.models.ESex;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private Date dateOfBirth;
    private ESex sex;

}
