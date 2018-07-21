package library;

public class Member {
	
	private String id;
	private String name;
	private String address;
	private String dateOfMembership;
	private char membershipType; // V=VIP N=Normal
	
	public Member(String id, String name, String address,
			String dateOfMembership, char membershipType) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.dateOfMembership = dateOfMembership;
		this.membershipType = membershipType;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.id + "   " + this.name + "   " + this.address + "   " + this.dateOfMembership + "   " + this.membershipType;
	}

}
