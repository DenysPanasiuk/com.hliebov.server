package com.hliebov.server.orders.repository;

import com.hliebov.server.orders.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Denys Panasiuk, denys.panasiuk@media-sol.com, MEDIA SOLUTIONS
 */
public interface OrdersRepository extends MongoRepository<Order, String> {

}
