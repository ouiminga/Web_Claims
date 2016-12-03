/**
 * 
 */
package org.bank.beans;

import java.io.Serializable;

import org.joda.time.DateTime;

/**
 * @author OuimingaLT
 *
 */
public class Claim implements Serializable{

	private static long nbrClaim;

	private pers_Client client;
	private pers_Officer agent;

	private long numCarte;
	private long numCompte;
	private long numReference;
	private long numAutorisation;
	private long numeroGAB;

	private long montantReclame;
	private Bank banqueAcquereur;
	private Bank banqueHostClaim;
	private DateTime dateTransaction;
	private DateTime dateClaim;
	private StatutClaim statutClaim;
	
	/**
	 * @return the agent
	 */
	public pers_Officer getAgent() {
		return agent;
	}

	/**
	 * @param agent the agent to set
	 */
	public void setAgent(pers_Officer agent) {
		this.agent = agent;
	}

	/**
	 * @return the banqueHostClaim
	 */
	public Bank getBanqueHostClaim() {
		return banqueHostClaim;
	}

	/**
	 * @param banqueHostClaim the banqueHostClaim to set
	 */
	public void setBanqueHostClaim(Bank banqueHostClaim) {
		this.banqueHostClaim = banqueHostClaim;
	}

	/**
	 * @return the dateClaim
	 */
	public DateTime getDateClaim() {
		return dateClaim;
	}

	/**
	 * @param dateClaim the dateClaim to set
	 */
	public void setDateClaim(DateTime dateClaim) {
		this.dateClaim = dateClaim;
	}

	/**
	 * @return the nbrClaim
	 */
	public static long getNbrClaim() {
		return nbrClaim;
	}

	/**
	 * @return the client
	 */
	public pers_Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(pers_Client client) {
		this.client = client;
	}

	/**
	 * @return the numCarte
	 */
	public long getNumCarte() {
		return numCarte;
	}

	/**
	 * @param numCarte the numCarte to set
	 */
	public void setNumCarte(long numCarte) {
		this.numCarte = numCarte;
	}

	/**
	 * @return the numCompte
	 */
	public long getNumCompte() {
		return numCompte;
	}

	/**
	 * @param numCompte the numCompte to set
	 */
	public void setNumCompte(long numCompte) {
		this.numCompte = numCompte;
	}

	/**
	 * @return the numReference
	 */
	public long getNumReference() {
		return numReference;
	}

	/**
	 * @param numReference the numReference to set
	 */
	public void setNumReference(long numReference) {
		this.numReference = numReference;
	}

	/**
	 * @return the numAutorisation
	 */
	public long getNumAutorisation() {
		return numAutorisation;
	}

	/**
	 * @param numAutorisation the numAutorisation to set
	 */
	public void setNumAutorisation(long numAutorisation) {
		this.numAutorisation = numAutorisation;
	}

	/**
	 * @return the numeroGAB
	 */
	public long getNumeroGAB() {
		return numeroGAB;
	}

	/**
	 * @param numeroGAB the numeroGAB to set
	 */
	public void setNumeroGAB(long numeroGAB) {
		this.numeroGAB = numeroGAB;
	}

	/**
	 * @return the montantReclame
	 */
	public long getMontantReclame() {
		return montantReclame;
	}

	/**
	 * @param montantReclame the montantReclame to set
	 */
	public void setMontantReclame(long montantReclame) {
		this.montantReclame = montantReclame;
	}

	/**
	 * @return the banqueAcquereur
	 */
	public Bank getBanqueAcquereur() {
		return banqueAcquereur;
	}

	/**
	 * @param banqueAcquereur the banqueAcquereur to set
	 */
	public void setBanqueAcquereur(Bank banqueAcquereur) {
		this.banqueAcquereur = banqueAcquereur;
	}

	/**
	 * @return the dateTransaction
	 */
	public DateTime getDateTransaction() {
		return dateTransaction;
	}

	/**
	 * @param dateTransaction the dateTransaction to set
	 */
	public void setDateTransaction(DateTime dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	/**
	 * @return the statutClaim
	 */
	public StatutClaim getStatutClaim() {
		return statutClaim;
	}

	/**
	 * @param statutClaim the statutClaim to set
	 */
	public void setStatutClaim(StatutClaim statutClaim) {
		this.statutClaim = statutClaim;
	}

	/**
	 * 
	 */
	public Claim() {
		// TODO Auto-generated constructor stub
		nbrClaim++;
	}

}
