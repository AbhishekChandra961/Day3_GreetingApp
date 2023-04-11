package com.bridgelabz.AssignmentThree.repository;

import com.bridgelabz.AssignmentThree.model.Messages;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Messages,Long> {
}