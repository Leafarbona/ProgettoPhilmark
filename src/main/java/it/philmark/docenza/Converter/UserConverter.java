package it.philmark.docenza.Converter;

import it.philmark.docenza.DTO.UserDTO;
import it.philmark.docenza.models.User;

public class UserConverter {
    //converte gli utenti
    public static UserDTO fromEntityToDTO(User u){
        UserDTO dto = new UserDTO();
        dto.setId(u.getId());
        dto.setName(u.getName());
        dto.setDateOfBirth(u.getDateOfBirth());
        dto.setSex(u.getSex());
        dto.setEmail(u.getEmail());
        return dto;
    }
}
