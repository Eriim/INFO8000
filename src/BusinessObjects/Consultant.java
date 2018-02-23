package BusinessObjects;

public class Consultant {
	

		private int accountID;
		private String workPhone;
		private Boolean isAdmin;
		

		public Consultant(int accountID, String workPhone, Boolean isAdmin) {
			this.accountID = accountID;
			this.workPhone = workPhone;
			this.isAdmin = isAdmin;
			}

		public int getAccountID() {
			return accountID;
		}

		public void setAccountID(int accountID) {
			this.accountID = accountID;
		}

		public String getWorkPhone() {
			return workPhone;
		}

		public void setWorkPhone(String workPhone) {
			this.workPhone = workPhone;
		}

		public Boolean getIsAdmin() {
			return isAdmin;
		}

		public void setIsAdmin(Boolean isAdmin) {
			this.isAdmin = isAdmin;
		}
		

}
