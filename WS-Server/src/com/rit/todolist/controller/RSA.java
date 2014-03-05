package com.rit.todolist.controller;
    
//package atnf.atoms.mon.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Properties;

/**
 * Simple RSA public key encryption algorithm implementation.
 * <P>
 * Taken from "Paj's" website:
 * <TT>http://pajhome.org.uk/crypt/rsa/implementation.html</TT>
 * <P>
 * Adapted by David Brodrick
 */
public class RSA {
  private BigInteger n, d, e;

  private int bitlen = 1024;

  /** Create an instance that can encrypt using someone elses public key. */
  public RSA() {
  
  }

  /** Create an instance that can both encrypt and decrypt. */
  public RSA(int bits) {
    bitlen = bits;
    SecureRandom r = new SecureRandom();
    BigInteger p = new BigInteger(bitlen / 2, 100, r);
    BigInteger q = new BigInteger(bitlen / 2, 100, r);
    n = p.multiply(q);
    BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q
        .subtract(BigInteger.ONE));
    e = new BigInteger("3");
    while (m.gcd(e).intValue() > 1) {
      e = e.add(new BigInteger("2"));
    }
    d = e.modInverse(m);
    System.out.println("ee  "+e+"  "+d);
  }

  /** Encrypt the given plaintext message. */
  public synchronized String encrypt(String message) {
    return (new BigInteger(message.getBytes())).modPow(e, n).toString();
  }

  /** Encrypt the given plaintext message. */
  public synchronized BigInteger encrypt(BigInteger message) {
    return message.modPow(e, n);
  }

  /** Decrypt the given ciphertext message. */
  public synchronized String decrypt(String message) {
    return new String((new BigInteger(message)).modPow(d, n).toByteArray());
  }

  /** Decrypt the given ciphertext message. */
  public synchronized BigInteger decrypt(BigInteger message) {
    return message.modPow(d, n);
  }

  /** Generate a new public and private key set. */
 /* public synchronized void generateKeys() {
    SecureRandom r = new SecureRandom();
    BigInteger p = new BigInteger(bitlen / 2, 100, r);
    BigInteger q = new BigInteger(bitlen / 2, 100, r);
    n = p.multiply(q);
    BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q
        .subtract(BigInteger.ONE));
    e = new BigInteger("3");
    while (m.gcd(e).intValue() > 1) {
      e = e.add(new BigInteger("2"));
    }
    d = e.modInverse(m);
  }*/

  /** Return the modulus. */
  public synchronized BigInteger getN() {
    return n;
  }

  /** Return the public key. */
  public synchronized BigInteger getE() {
    return e;
  }

  /** Trivial test program. 
 * @return */
  public  String decryptPassword(String passwordCypher) {
   
	  Properties prop = new Properties();
	    String privateKey=null;
	    String newN=null;
		try {
	           //load a properties file
			prop.load(new FileInputStream("config.properties"));
			privateKey=prop.getProperty("privateKey");
	         
	          newN=prop.getProperty("n");

		} catch (IOException ex) {
			ex.printStackTrace();
	    }
	  
	  
	  
	  
	 
    this.n=new BigInteger(newN);
  
    this.d=new BigInteger(privateKey);
	    
	    BigInteger passwordInt = this.decrypt(new BigInteger(passwordCypher));
	    return( new String(passwordInt.toByteArray()));
	   
	   
  }
}
