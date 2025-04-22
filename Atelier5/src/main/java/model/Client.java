package model;

import java.io.Serializable;

public class Client extends Personne implements Serializable {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 8385933644361683319L;
	private long idClient;
	public Client() {
		super();
		idClient = 0;
	}
	public Client(long idClient, String nom, String prenom) {
		super(nom, prenom);
		this.idClient = idClient;
	}
	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (idClient ^ (idClient >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (idClient != other.idClient)
			return false;
		return true;
	}
	
}
