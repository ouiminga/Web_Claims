/**
 * 
 */
package org.bank.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * @author OuimingaLT
 *
 */
public class Bank {

	private static long nbrBank;

	private String name = "";
	private String adress = "";
	private Map furtherInfo = new HashMap<>();
	/**
	 * @return the nbrBank
	 */
	public static long getNbrBank() {
		return nbrBank;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * @return the furtherInfo
	 */
	public Map getFurtherInfo() {
		return furtherInfo;
	}
	/**
	 * @param furtherInfo the furtherInfo to set
	 */
	public void setFurtherInfo(Map furtherInfo) {
		this.furtherInfo = furtherInfo;
	}
	/**
	 * 
	 */
	public Bank() {
		// TODO Auto-generated constructor stub
		nbrBank++;
	}

}
