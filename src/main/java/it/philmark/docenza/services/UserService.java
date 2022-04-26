package it.philmark.docenza.services;

import it.philmark.docenza.DTO.UserDTO;
import it.philmark.docenza.models.User;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO saveUser(User utenteDaSalvare);

    UserDTO updateUser(User utenteConModifiche);

    void deleteUser(Long idUtenteDaEliminare);
}
