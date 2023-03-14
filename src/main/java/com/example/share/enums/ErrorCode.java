package com.example.share.enums;

public enum ErrorCode {
	
	A001(""), A002("compte n'existe pas"), P002("Le poste n'existe pas"),P003("Aucun Poste en bd"),
	PR002("Le profil n'existe pas"),PR003("Aucun Profil en bd"),PR004("Username existe déja"),
	A500("Une erreur système s'est produite"),AE100("Email exist déja !"), 
	Z001("Vous n'avez pas le droit d'accèder à cette ressource"),
	U001("Username ou mot de passe incorrecte !"), REF003("Champs obligatoires !"), A404("Saisie non valide !"),
	U002("Ancien mot de passe incorecte !"), U003("Les mots de passes ne se ressemblent pas !"), U004("User not found"),
	U005("Cette action n'est pas autorisée pour cet utilisateur !"), REF001("Inexistant !"),
	REF002("Vous n'êtes pas le propriétaire !"), REF004("Tâche déjà terminer"), F002("Le field n'existe pas");

	private String message = "";

	ErrorCode(String message) {
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}

	@Override
	public String toString() {
		return message;
	}

}
