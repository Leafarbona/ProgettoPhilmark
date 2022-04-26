package it.philmark.docenza.services.impl;

import it.philmark.docenza.Converter.UserConverter;
import it.philmark.docenza.DTO.UserDTO;
import it.philmark.docenza.models.User;
import it.philmark.docenza.repository.UserRepository;
import it.philmark.docenza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//non dimentichiamo mai l'annotation Service
@Service
public class UserServiceImpl implements UserService {

    @Autowired //si usa per iniettare le dipendenze, quidni ora UserServiceImpl dipende da userrepository
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> listaUtenti = userRepository.findAll();
        List<UserDTO> dtoList = new ArrayList<>();

        for (User u : listaUtenti){
            dtoList.add(UserConverter.fromEntityToDTO(u));
        }
        return dtoList;
    }


        @Override
        public UserDTO saveUser(User utenteDaSalvare) {
            User utenteSalvato = userRepository.save(utenteDaSalvare);
            return UserConverter.fromEntityToDTO(utenteSalvato);
        }

    @Override
    public UserDTO updateUser(User utenteConModifiche) {
        if (utenteConModifiche.getId() != null){
            User utenteDaModificare = userRepository.getOne(utenteConModifiche.getId());
                    utenteDaModificare.setName(utenteConModifiche.getName());
                    utenteDaModificare.setEmail(utenteDaModificare.getEmail());
                    utenteDaModificare.setRoles(utenteConModifiche.getRoles());
                    User utenteModificato = userRepository.save(utenteDaModificare);
                    return UserConverter.fromEntityToDTO(utenteModificato);
        }
        return null;
    }

    @Override
    public void deleteUser(Long idUtenteDaEliminare) {
        User utenteDaEliminare = userRepository.getOne(idUtenteDaEliminare);
        userRepository.delete(utenteDaEliminare);
    }


}

