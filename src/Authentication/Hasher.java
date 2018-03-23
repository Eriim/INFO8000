package Authentication;
import java.util.UUID;

import Authentication.BCrypt;

public class Hasher {

	
	public String hashedPassword(String password, String salt) {		
		
		String hash = BCrypt.hashpw(password, salt);
		return hash;
	}    
	
	public String genSalt() {
		String salt = BCrypt.gensalt() ;
		
		return salt;
	}
    
    public boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
    
    public String generatedPassword() {
    	String gennedPass = "";
    	
    	
    	return gennedPass;
    }
    
 
    public String generateString() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        String genStr = uuid.substring(0,6);
        
        return genStr;
    }
    
}
