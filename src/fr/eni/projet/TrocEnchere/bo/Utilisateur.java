package fr.eni.projet.TrocEnchere.bo;

public class Utilisateur {

	private int noUser;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String noTel;
	private String rue;
	private String cpo;
	private String ville;
	private String mdp;
	private int credit = 100;
	private byte admin = 0;
	
	
	public Utilisateur() {
		super();
	}
	public Utilisateur(String pseudo, String email, String mdp) {
		super();
		this.pseudo = pseudo;
		this.mdp = mdp;
	}

	public Utilisateur(String pseudo, String nom, String prenom, String email, String noTel, String rue, String cpo,
			String ville, String mdp) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.noTel = noTel;
		this.rue = rue;
		this.cpo = cpo;
		this.ville = ville;
		this.mdp = mdp;
	}
	public Utilisateur(int noUser, String pseudo, String nom, String prenom, String email, String noTel, String rue,
			String cpo, String ville, String mdp, int credit, byte admin) {
		super();
		this.noUser = noUser;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.noTel = noTel;
		this.rue = rue;
		this.cpo = cpo;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
		this.admin = admin;
	}
	public Utilisateur(String nom, String prenom, int credit) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.credit = credit;
	}
	public int getNoUser() {
		return noUser;
	}
	public String getPseudo() {
		return pseudo;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getEmail() {
		return email;
	}
	public String getNoTel() {
		return noTel;
	}
	public String getRue() {
		return rue;
	}
	public String getCpo() {
		return cpo;
	}
	public String getVille() {
		return ville;
	}
	public String getMdp() {
		return mdp;
	}
	public int getCredit() {
		return credit;
	}
	public byte getAdmin() {
		return admin;
	}
	
	
	public void setNoUser(int noUser) {
		this.noUser = noUser;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNoTel(String noTel) {
		this.noTel = noTel;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public void setCpo(String cpo) {
		this.cpo = cpo;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public void setAdmin(byte admin) {
		this.admin = admin;
	}
}
