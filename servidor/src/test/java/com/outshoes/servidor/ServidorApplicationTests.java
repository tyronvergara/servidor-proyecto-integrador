package com.outshoes.servidor;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ServidorApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void pruebaProductoGET() throws Exception {
		this.mockMvc.perform( get("/api/producto/2") )
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect( content().string( containsString("Zapatillas") ));
	}
	
	@Test
	void pruebaMarcaGET() throws Exception {
		this.mockMvc.perform( get("/api/marca/2") )
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect( content().string( containsString("Converse") ));
	}
	
	@Test
	void pruebaCategoriaGET() throws Exception {
		this.mockMvc.perform( get("/api/categoria/2") )
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect( content().string( containsString("Mujer") ));
	}
	
	@Test
	void pruebaColeccionGET() throws Exception {
		this.mockMvc.perform( get("/api/coleccion/2") )
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect( content().string( containsString("Tenis") ));
	}
	
	@Test
	void pruebaUsuarioGET() throws Exception {
		this.mockMvc.perform( get("/api/usuario/2") )
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect( content().string( containsString("Tenis") ));
	}
	

}
