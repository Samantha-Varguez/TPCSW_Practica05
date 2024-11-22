
package org.uv.tpcsw.demo.TPCSWPractica5;

public class LoginResponse {
    private String token;

    private long expiresIn;

    public String getToken() {
        return token;
    }

 // Getters and setters...

    public long getExpiresIn() {
        return expiresIn;
    }

    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
    
   public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }
    
    
}
