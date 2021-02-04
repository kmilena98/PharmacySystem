package ISA.Team54.users.mappers;

import ISA.Team54.users.dto.PharmacyDTO;
import ISA.Team54.users.dto.UserRequestDTO;
import ISA.Team54.users.model.Pharmacy;
import ISA.Team54.users.model.User;

public class PharmacyMapper {
		
	public static Pharmacy PharmacyDTOToPharmacy(PharmacyDTO pharmacyDTO) {
		Pharmacy pharmacy = new Pharmacy();
		pharmacy.setAddress(pharmacyDTO.getAddress());
		pharmacy.setDescription(pharmacyDTO.getDescription());
		pharmacy.setName(pharmacyDTO.getName());	
		return pharmacy;						
	}
}
