package cloud.masteroflie.tarefas.repository;

import cloud.masteroflie.tarefas.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface todoRepository extends JpaRepository<Todo, Long> {
}
