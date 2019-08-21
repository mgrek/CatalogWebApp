package com.dir.Catalog;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.dir.Parameters.ParametersDb;

public class Organization {
    
    private String name;
    private String inn;
    private String ogrn;
    private String adress;
        
    private Organization() {
    }
    
    public static Builder newBuilder() {
	return new Organization(). new Builder();
    }
    
    public String getName() {
	return name;
    }
    
    public String getINN() {
	return inn;
    }
    
    public String getOGRN() {
	return ogrn;
    }
    
    public String getAdress() {
	return adress;
    }
    
    public void setName(String name) {
	this.name = name;
    }
    
    public void setINN(String inn) {
	this.inn = inn;
    }
    
    public void setOGRN(String ogrn) {
	this.ogrn = ogrn;
    }
    
    public void setAdress(String adress) {
	this.adress = adress;
    }
    
    public Map<?,?> getOrganization() {
	Map<ParametersDb, String> organization = new LinkedHashMap<>();
	organization.put(ParametersDb.NAME, name);
	organization.put(ParametersDb.INN, inn);
	organization.put(ParametersDb.OGRN, ogrn);
	organization.put(ParametersDb.ADRESS, adress);
	return organization;
	
    }
    
    @Override
    public int hashCode() {
	final int primary = 31;
	int result = 1;
	result = primary * result + ((name == null) ? 0 
		: name.hashCode());
	result = primary * result + ((inn == null) ? 0 
		: inn.hashCode());
	result = primary * result + ((ogrn == null) ? 0 
		: ogrn.hashCode());
	result = primary * result + ((adress == null) ? 0
		: adress.hashCode());
	return result;
    }
    
    @Override
    public boolean equals(Object obj) {
	if (obj == null || 
		obj.getClass() != this.getClass())
	    return false;
	
	if (obj == this)
	    return true;
	
	Organization organization = (Organization) obj;
	return name == organization.name 
		&& inn == organization.inn 
		&& ogrn == organization.ogrn
		&& adress == organization.adress;
    }
    
    public class Builder {
	private Builder() {}
	
	public Builder setName(String name) {
	    Organization.this.name = name;
	    return this;
	}
	
	public Builder setINN(String inn) {
	    Organization.this.inn = inn;
	    return this;
	}
	
	public Builder setOGRN(String ogrn) {
	    Organization.this.ogrn = ogrn;
	    return this;
	}
	
	public Builder setAdress(String adress) {
	    Organization.this.adress = adress;
	    return this;
	}
	
	public Organization build() {
	    Objects.requireNonNull(Organization.this.name, "Name of organization is null!");
	    Objects.requireNonNull(Organization.this.inn, "INN of organization is null!");
	    Objects.requireNonNull(Organization.this.ogrn, "OGRN of organization is null!");
	    Objects.requireNonNull(Organization.this.adress, "Adress of organization is null!");
	    return Organization.this;
	}
    }

}
