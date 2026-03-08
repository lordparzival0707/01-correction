package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.service.*;
import java.util.*;

import com.example.demo.model.Difference;
import com.example.demo.model.Note;
import com.example.demo.model.Parametre;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private NoteService noteService;

	@Autowired
	private DifferenceService differenceService;

	@Autowired
	private ParametreService parametreService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Parametre parametre = parametreService.getParametreByDifferenceNote(1L, 1L);
		System.out.println(parametre.getOperateur().getLibelle());
	}

}
