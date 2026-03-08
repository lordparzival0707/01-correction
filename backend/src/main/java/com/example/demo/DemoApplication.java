package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.service.*;
import java.util.*;
import com.example.demo.model.Note;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private NoteService noteService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Utilise le service injecté par Spring
		List<Note> notes = noteService.findByMatiereIdAndEtudiantId(1L, 1L);
		// for(Note note : notes){
		// 	System.out.println(note.getValeur());
		// }
		System.out.println(noteService.getDifferenceNote(1L, 1L));
	}

}
