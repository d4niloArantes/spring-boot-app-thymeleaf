package danilo.si4p.repositorios;

import danilo.si4p.entidades.Aluno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlunoRepositorio extends CrudRepository<Aluno, Long>
{
	@Query("from Aluno order by nome")
	public List<Aluno> findAllOrderByNome();
}
