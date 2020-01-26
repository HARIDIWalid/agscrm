package dz.ags.crm.agscrm.model.dto;

import dz.ags.crm.agscrm.model.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDTO {

	private String nomPrenom;

	public UserDTO(User user) {
		if (user != null)
			this.nomPrenom = user.getNom() + " " + user.getPrenom();
	}

	public String getNomPrenom() {
		return nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

}
