package com.dir.Test;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.dir.Catalog.Organization;
import com.dir.Model.Model;
import com.dir.Parameters.ParametersDb;

public class ModelTest {

    private Map<ParametersDb, String> testData;

    @Before
    public void createTestData() {
	testData = new HashMap<>();
	testData.put(ParametersDb.NAME, "ИП Тест");
	testData.put(ParametersDb.INN, "1234567890");
	testData.put(ParametersDb.OGRN, "0987654321");
	testData.put(ParametersDb.ADRESS, "Тест, ул. Тестовая, д.01");
    }

    @Test
    public void ModelsTest() {
	Organization organization = Organization.newBuilder()
		.setName(testData.get(ParametersDb.NAME))
		.setINN(testData.get(ParametersDb.INN))
		.setOGRN(testData.get(ParametersDb.OGRN))
		.setAdress(testData.get(ParametersDb.ADRESS))
		.build();
	assertNotNull(organization);
	Model modelTest = Model.getInstance();
	assertNotNull(modelTest);
	modelTest.add(organization);
	assertNotNull(modelTest.show());
    }
}
