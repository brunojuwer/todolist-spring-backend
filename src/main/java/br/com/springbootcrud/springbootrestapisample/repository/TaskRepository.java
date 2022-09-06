package br.com.springbootcrud.springbootrestapisample.repository;

import br.com.springbootcrud.springbootrestapisample.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
