package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.service.*;
import java.util.*;

import com.example.demo.model.NoteFinale;
import com.example.demo.model.Parametre;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private NoteFinaleService noteFinaleService;

	@Autowired
	private ParametreService parametreService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// NoteFinale noteFinale = noteFinaleService.getNoteFinale(1L, 1L);
		// System.out.println(noteFinale.getValeur());

		List<Parametre> parametres = parametreService.getParametresPotentiels(1L, 1L);

		for (Parametre parametre : parametres) {
			System.out.println("Seuil: " + parametre.getSeuil());
		}
	}

}
