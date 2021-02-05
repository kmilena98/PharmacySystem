package ISA.Team54.drugAndRecipe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ISA.Team54.drugAndRecipe.model.Drug;
import ISA.Team54.drugAndRecipe.service.IDrugService;

@RestController
@RequestMapping(value = "/drug", produces = MediaType.APPLICATION_JSON_VALUE)
public class DrugController {
	@Autowired
	private IDrugService drugService;
	
	@GetMapping("")
	public List<Drug> getAll(){
		return drugService.getAllDrugs();
	}

}
