/**
 * 
 */
package org.bank.beans;

/**
 * @author OuimingaLT
 *
 */
public class pers_Client extends pers_Actor {

	private static long nbrClient;

	private long numClient;
	private Bank customerOf;
	
	/**
	 * @return the nbrClient
	 */
	public static long getNbrClient() {
		return nbrClient;
	}

	/**
	 * @return the numClient
	 */
	public long getNumClient() {
		return numClient;
	}

	/**
	 * @param numClient the numClient to set
	 */
	public void setNumClient(long numClient) {
		this.numClient = numClient;
	}

	/**
	 * @return the customerOf
	 */
	public Bank getCustomerOf() {
		return customerOf;
	}

	/**
	 * @param customerOf the customerOf to set
	 */
	public void setCustomerOf(Bank customerOf) {
		this.customerOf = customerOf;
	}

	/**
	 * 
	 */
	public pers_Client() {
		// TODO Auto-generated constructor stub
		nbrClient++;
	}

}
