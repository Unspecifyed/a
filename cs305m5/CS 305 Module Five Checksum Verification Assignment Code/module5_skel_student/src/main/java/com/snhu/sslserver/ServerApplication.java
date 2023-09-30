package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// mine
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}

@RestController
class ServerController{
@RequestMapping("/hash")
    public String myHash() {
        String data = "Francis Cottrell-Eshaghi";
        
        try {
            // Create a MessageDigest object with the chosen algorithm (e.g., SHA-256) this is ii
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            
            // Update the MessageDigest with the data (your name) this is i
            messageDigest.update(data.getBytes());
            
            // Generate the hash value as an array of bytes
            byte[] hashBytes = messageDigest.digest();
            
            // Convert the byte array to a hexadecimal string
            String hashedData = bytesToHex(hashBytes);
            
            return "<p>Data: " + data + "<br>Hash Value: " + hashedData + "</p>";
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception if the algorithm is not available
            e.printStackTrace();
            return "Error: Algorithm not available";
        }
    }

    // Helper function to convert a byte array to a hexadecimal string
    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
