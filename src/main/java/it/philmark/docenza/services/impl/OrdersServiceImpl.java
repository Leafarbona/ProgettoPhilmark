package it.philmark.docenza.services.impl;

import it.philmark.docenza.repository.OrdersRepository;
import it.philmark.docenza.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

}
