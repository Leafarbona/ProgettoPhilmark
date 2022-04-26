package it.philmark.docenza.controllers;

import it.philmark.docenza.DTO.UserDTO;
import it.philmark.docenza.models.User;
import it.philmark.docenza.repository.UserRepository;
import it.philmark.docenza.services.UserService;
import it.philmark.docenza.services.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600) //definisce quali client possono chiamare queste API
// si utilizza '*' se non vogliamo mettere restrizioni
@RestController // definisce che questa dovra comportarsi da controller per chiamate REST
@RequestMapping("/api/users") // se messo qui, spinge un prefisso a tutte le API di questa classe
public class UserController {

  private static Logger logger = LoggerFactory.getLogger(UserController.class);

  // git add . (aggiunte tutto
  // git commit -m "user crud api" (serve per salvare sul git locale il vostro lavoro
  //git push origin <master> o <nomebranch> (serve per portare sul repository online, il vostro commit)
  //master è il nome del branch principale, si possono avere piu branch nel repository
  //git pull (se un vostro collega fa un push e voi volete importare le sue modifiche allora fate git pull
  //git checkout <nomebranch> (ci consente di spostarci tra un branch e l'altro)
  //git fetch(vi scarica tutti i nuovi branch)
  // git commit -m "provagit" poi git push origin <nomebranch> commento di prova per push

  // perche iniettiamo nel controller l'interfaccia userService e non direttamente userServiceImpl
  // per mantenere l'indipendenza di ogni singola classe (RestController, Service...)
  // questa pratica, viene definita Inversion Of Control -> IoC
  // L'IoC è un patter archittetturale che consiste nel tenere indipendenti i componenti tr  loro
  // Essendo indipendenti, tramite il Dependency Injection -> DI iniettiamo  un componente  in un altro
  //iniettando le interfacce tramite l'annotation @Aurowired
  //i componenti saranno "loose-coupled", disaccoppiati
  @Autowired
  UserService userService;

  //PROFESSIONALE
  @GetMapping("getAllUsers")
  public ResponseEntity<?> getAllUsers(){
    List<UserDTO> dtoList = userService.getAllUsers();
      return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping("saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User u){
    UserDTO dto = userService.saveUser(u);
    logger.info("utente salvato corretamente: " + dto.toString());
    return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("updateUser")
  public  ResponseEntity<?> updateUSer(@RequestBody User u){
    if (u.getId() != null){
      UserDTO dto = userService.updateUser(u);
      logger.info("Utente modificato correttamente: " + dto.toString());
      return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    logger.error("Inserisci il campo ID dell'utente per modificarlo!");
    return new ResponseEntity<>("Inserisci il campo ID dell'utente per modificarlo", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("deleteUser/{idUTenteDaEliminare}")
  public ResponseEntity<?> deleteUSer(@PathVariable Long idUtenteDaElminare){
    userService.deleteUser(idUtenteDaElminare);
    return  new ResponseEntity<>("Utente eliminato corretamente.", HttpStatus.OK);

    }




  /*IoC NOT FRIENDLY (spazzatura) I componenti erano "tight-coupled"
  private UserServiceImpl userServiceImpl = new UserServiceImpl();




   */
  //NON SI INIETTA REPOSITORI NEL CONTROLLER (quasi spazzatura)
/*  @Autowired
  UserRepository userRepository;*/

  //METODO POCO PROFESSIONALE (quasi spazzatura)
 /* @GetMapping("/getAllUsers")
  public List<User> getAllUsers() {
    return userRepository.getAllUsers();
  }
*/
}
