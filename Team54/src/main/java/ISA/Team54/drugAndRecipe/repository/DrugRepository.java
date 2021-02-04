package ISA.Team54.drugAndRecipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ISA.Team54.drugAndRecipe.model.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {

}
