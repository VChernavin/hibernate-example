package hiberExample.models;

public enum PhoneTechnology {
	CDMA("CDMA"), GSM("GSM"), WIRED("WIRED"), NA("N/A");

	private String tecnology;

	PhoneTechnology(String tecnology) {
		this.tecnology = tecnology;
	}

	public String getTecnology() {
		return tecnology;
	}
}
