package it.philmark.docenza.DTO;

import it.philmark.docenza.models.ESex;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private Date dateOfBirth;
    private ESex sex;

}
