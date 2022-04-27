package it.philmark.docenza.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity //crea la tabella
@Table(	name = "users", //definisce il nome della tabella da creare
		uniqueConstraints = { // ci obbliga ad avere utenti tutti con email diverse
			@UniqueConstraint(columnNames = "email")
		})
@Getter
@Setter
public class User {

	@Id // mi genera la primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank //non puo essere vuoto
	@Size(max = 20) //lunghezza massima
	private String name;

	@NotBlank
	@Size(max = 50)
	@Email // se il pattern mail è scritto corretto
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	private Date dateOfBirth;

	@Enumerated(EnumType.ORDINAL) // interpreta nel database gli ENUM come un numero: ad es. Male -> 0
	private ESex sex;

	// le many to many si realizzano con una terza tabella
	@ManyToMany(fetch = FetchType.LAZY)// EAGER-LAZY...indica il tipo di caricamento del dato
	@JoinTable(	name = "user_roles", // nome della terza tabella
				joinColumns = @JoinColumn(name = "user_id"), // nome della foreign key che si reiferisce all'ID utente
				inverseJoinColumns = @JoinColumn(name = "role_id"))// nome della foreign key che si riferisce all'ID ruolo
	private Set<Role> roles = new HashSet<>(); // set per un ruolo solamente

	public User() {
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

}
