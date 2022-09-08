package br.com.springbootcrud.springbootrestapisample.repository;

import br.com.springbootcrud.springbootrestapisample.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Task SET isTaskComplete = :isComplete WHERE id = :idTask")
    void updateIsComplete(@Param(value = "idTask") long idTask, @Param(value = "isComplete") boolean isComplete);

    @Query(value = "SELECT t FROM Task t ORDER BY t.created_at ASC")
    List<Task> selectAllTasks();
}
