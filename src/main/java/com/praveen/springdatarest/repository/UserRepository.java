package com.praveen.springdatarest.repository;

import com.praveen.springdatarest.entity.ApplicationUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<ApplicationUser, Integer> {

    ApplicationUser findByEmail(@Param("email") String email);

}
