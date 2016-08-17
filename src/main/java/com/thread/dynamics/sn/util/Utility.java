package com.thread.dynamics.sn.util;

import java.util.UUID;

/**
 * The Class Utility.
 */
public class Utility {

    /**
     * Generate random number.
     *
     * @return the string
     */
    public static String generateRandomNumber() {
        final UUID randomNumber = UUID.randomUUID();
        return randomNumber.toString();
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String args[]) {
        System.out.println(generateRandomNumber());
    }

}
