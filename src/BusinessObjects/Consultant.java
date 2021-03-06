package BusinessObjects;

public class Consultant {
	

		private Account account;
		private String workPhone;
		private Boolean isAdmin;
		

		public Consultant(Account account, String workPhone, Boolean isAdmin) {
			this.account = account;
			this.workPhone = workPhone;
			this.isAdmin = isAdmin;
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

		public Account getAccount() {
			return account;
		}

		public void setAccount(Account account) {
			this.account = account;
		}
		

}
