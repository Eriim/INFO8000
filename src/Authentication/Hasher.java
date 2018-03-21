package Authentication;
import Authentication.BCrypt;

public class Hasher {

	
	public String HashedPassword(String password, String salt) {		
		
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
    

}
