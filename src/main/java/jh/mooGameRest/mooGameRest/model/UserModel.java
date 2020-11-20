package jh.mooGameRest.mooGameRest.model;

public class UserModel {

	 private String name;
	    private long id;
	    private String contactNumber;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "UserModel [name=" + name + ", id=" + id + ", contactNumber=" + contactNumber + "]";
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
	    
	    
	
}
