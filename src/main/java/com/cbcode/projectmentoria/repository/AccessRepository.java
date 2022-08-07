package com.cbcode.projectmentoria.repository;

import com.cbcode.projectmentoria.model.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AccessRepository extends JpaRepository<Access, Long> {

    @Query("select a from Access a where upper(trim(a.description)) like %?1%")
    List<Access> findByDescription(String description);
}
