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

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// NoteFinale noteFinale = noteFinaleService.getNoteFinale(1L, 1L);
		// System.out.println(noteFinale.getValeur());
	}

}
