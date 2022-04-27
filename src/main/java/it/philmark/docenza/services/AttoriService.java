package it.philmark.docenza.services;

import it.philmark.docenza.models.Attore;


import java.util.List;

public interface AttoriService {

    List<Attore> getAllAttori();

    Attore saveAttore(Attore attoreDaSalvare);

}
