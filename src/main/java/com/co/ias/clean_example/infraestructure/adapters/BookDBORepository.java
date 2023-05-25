package com.co.ias.clean_example.infraestructure.adapters;

import com.co.ias.clean_example.infraestructure.adapters.entity.BookDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookDBORepository extends CrudRepository<BookDBO, String> {
}
