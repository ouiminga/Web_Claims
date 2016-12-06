/**
 * 
 */
package org.bank.beans;

/**
 * @author OuimingaLT
 *
 */
public class pers_Officer extends pers_Actor {

    private static long nbrOfficer;

    private long        numOfficer;
    private Bank        officerOf;

    /**
     * @return the officerOf
     */
    public Bank getOfficerOf() {
        return officerOf;
    }

    /**
     * @param officerOf
     *            the officerOf to set
     */
    public void setOfficerOf( Bank officerOf ) {
        this.officerOf = officerOf;
    }

    /**
     * @return the nbrOfficer
     */
    public static long getNbrOfficer() {
        return nbrOfficer;
    }

    /**
     * @return the numOfficer
     */
    public long getNumOfficer() {
        return numOfficer;
    }

    /**
     * @param numOfficer
     *            the numOfficer to set
     */
    public void setNumOfficer( long numOfficer ) {
        this.numOfficer = numOfficer;
    }

    /**
     * 
     */
    public pers_Officer() {
        // TODO Auto-generated constructor stub
        nbrOfficer++;
    }

}
