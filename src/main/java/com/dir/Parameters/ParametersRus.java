package com.dir.Parameters;

public enum ParametersRus {

    NAME("Наименование организации"),
    INN("ИНН организации"),
    OGRN("ОГРН организации"),
    ADRESS("Адрес организации");
    
    private String description;
    
    private ParametersRus(String description) {
	this.description = description;
    }
    
    public String getDescription() {
	return description;
    }
    
    @Override
    public String toString() {
	return description;
	
    }
}
