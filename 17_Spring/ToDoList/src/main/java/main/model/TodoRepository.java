package main.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//for new commit
@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
//for new commit