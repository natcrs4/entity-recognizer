package com.crs4.sem.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.crs4.sem.model.Term;

public class NERServiceTest {
	
	@Test
	public void tagSentencesTest() throws IOException {
		File file = new File("src/test/resources/icab.par");
		NERService nerservice = new NERService(file);
		String text="L’Africa, l’Europa e l’Italia. L’intervento di Sergio Mattarella";
		List<Term> taggedterms = nerservice.tagSentences(text);
		List<Term> entities = nerservice.listOfEntities(taggedterms);
		assertEquals(entities.get(1).content(),"Sergio Mattarella");
		text="Il discorso del Presidente Sergio Mattarella durante la sessione di apertura della prima Conferenza Ministeriale Italia-Africa";
		taggedterms = nerservice.tagSentences(text);
		 entities = nerservice.listOfEntities(taggedterms);
		 for (Term e:entities) {
			 System.out.println(e.content()+":"+e.tag());
		 }
	}
	
}
