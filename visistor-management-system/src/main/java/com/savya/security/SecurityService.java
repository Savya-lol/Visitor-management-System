package com.savya.security;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class SecurityService {
    // Constants for the PBKDF2 algorithm
    private static final int SALT_BYTES = 16;
    private static final int HASH_BYTES = 32;
    private static final int ITERATIONS = 10000;
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";

    // Method to generate a random salt
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_BYTES];
        random.nextBytes(salt);
        return salt;
    }

    // Method to hash password
    public static String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = generateSalt();
        byte[] hash = pbkdf2(password.toCharArray(), salt, ITERATIONS, HASH_BYTES);

        // Format: iterations:salt:hash
        return ITERATIONS + ":" + Base64.getEncoder().encodeToString(salt) + ":"
                + Base64.getEncoder().encodeToString(hash);
    }

    // Method to verify password
    public static boolean verifyPassword(String password, String hash)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        String[] parts = hash.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = Base64.getDecoder().decode(parts[1]);
        byte[] correctHash = Base64.getDecoder().decode(parts[2]);

        byte[] testHash = pbkdf2(password.toCharArray(), salt, iterations, correctHash.length);
        return MessageDigest.isEqual(correctHash, testHash);
    }

    // Core PBKDF2 function
    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int bytes)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, bytes * 8);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        return factory.generateSecret(spec).getEncoded();
    }
}
