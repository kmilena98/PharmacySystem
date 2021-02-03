package ISA.Team54.Examination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ISA.Team54.Examination.enums.ExaminationStatus;
import ISA.Team54.Examination.model.Examination;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {
	public List<Examination> findAll();
	public List<Examination> findEmplyeedIdAndExaminationStatus(Long id,ExaminationStatus i);
}
