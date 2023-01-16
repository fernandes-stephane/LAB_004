package com.testspringboot.gestionhospital.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import com.testspringboot.gestionhospital.models.Medecin;
import com.testspringboot.gestionhospital.service.MedecinService;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class MedecinControllerTest {

	
	@InjectMocks
	private MedecinController medecinController;
	
	@Mock
	private MedecinService medecinService;
	
	@Test
	public void getMedecin_withoutException() throws Exception {
		
		//Given état stable que l'on nous a laissé
		List<Medecin> list=new ArrayList<>();
		
		Medecin firstMedecin = new Medecin();
		Medecin secondMedecin = new Medecin();
		
		list.add(secondMedecin);
		list.add(firstMedecin);
		
		//When 
		Mockito.when(medecinService.getMedecins()).thenReturn(list);
		ResponseEntity<List<Medecin>> resultat=medecinController.getMedecins();
		
		//Then 
		assertEquals(2, resultat.getBody().size());
		assertEquals(HttpStatus.OK, resultat.getStatusCode());
	}
	
	@Test(expected = NullPointerException.class)
	public void getMedecin_withException() throws Exception {
		when(medecinService.getMedecins()).thenThrow(new NullPointerException("Error occured"));
		
		//Then
		assertTrue(medecinController.getMedecins().getStatusCode()==HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	public void getMedecinByIdTest_withoutException() throws Exception {
		//Given
		Medecin medecin=new Medecin();
		medecin.setId(2L);
		
		//when
		Mockito.when(medecinService.getMedecinByID(2L)).thenReturn(medecin);
		ResponseEntity<Medecin> response=medecinController.getMedecinByID(2L);
		
		//Then
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
		
		//tester la création d'un médecin
		@Test
		@Rollback(false)
	public void CreateMedecin_withoutException() throws Exception{
			
			//Given
		Medecin medecin=new Medecin();
		medecin.setId(2L);
		medecin.setFirstName("Moulin");
		medecin.setName("Jean");
		medecin.setNumTel("0613425677");
		medecin.setSpecialite("prison");
			
			// When
		Mockito.when(medecinService.saveMedecin(medecin)).thenReturn(medecin);
		ResponseEntity<Medecin> response=medecinController.saveMedecin(medecin);
			
			//Then
		assertThat(response.getBody().getId()).isGreaterThan(0);	
			
		}
		@Test
		public void deleteMedecinByid() throws Exception{
			Medecin medecin=new Medecin();
			medecin.setId(3L);
			medecin.setFirstName("Dupont");
			medecin.setName("André");
			medecin.setNumTel("235");
			medecin.setSpecialite("Cardiologie");
			
			medecinController.deleteByID(medecin.getId());
			ResponseEntity<Medecin> retrievedMedecin = medecinController.getMedecinByID(medecin.getId());
			
			//Then
			assertThat(retrievedMedecin.getBody()).isNull();
}			
			
			
			
			
			
		
		
		
}
