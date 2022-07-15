package com.outshoes.servidor;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.outshoes.servidor.model.Categoria;
import com.outshoes.servidor.model.Coleccion;
import com.outshoes.servidor.model.Marca;
import com.outshoes.servidor.model.Producto;

@SpringBootTest
@AutoConfigureMockMvc
class ServidorApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void pruebaProductoPost() throws Exception {
		Producto p = new Producto();
		p.setNombre("Tenis Blancos Adidas");
		p.setDescripcion("Tenis blancos");
		p.setSku("ADD123");
		p.setImagen("./img/item/img.png");
		p.setPrecio(777);
		
		Marca m = new Marca();
		m.setId((long) 1);
		
		Categoria c = new Categoria();
		c.setId((long) 1);
		
		Coleccion co = new Coleccion();
		co.setId((long) 1);
		
		p.setMarca(m);
		p.setCategoria(c);
		p.setColeccion(co);
		
		this.mockMvc.perform( post("/api/producto/agregar")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(p) )
			)
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect( content().string(containsString("Tenis") ) );
	}
	
	@Test
	public void pruebaMarcaPost() throws Exception {
		Marca m = new Marca();
		m.setNombre("Marquita");		
		
		this.mockMvc.perform( post("/api/marca/agregar")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(m) )
			)
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect( content().string(containsString("Marquita") ) );
	}
	
	@Test
	public void pruebaCategoriaPost() throws Exception {
		Categoria cat = new Categoria();
		cat.setNombre("Categoria");		
		
		this.mockMvc.perform( post("/api/categoria/agregar")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(cat) )
			)
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect( content().string(containsString("Categoria") ) );
	}
	
	@Test
	public void pruebaColeccionPost() throws Exception {
		Coleccion col = new Coleccion();
		col.setNombre("Coleccion");		
		
		this.mockMvc.perform( post("/api/coleccion/agregar")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(col) )
			)
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect( content().string(containsString("Coleccion") ) );
	}
	
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
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
		.andExpect( content().string( containsString("Pantuflas") ));
	}
	
	@Test
	void pruebaUsuarioGET() throws Exception {
		this.mockMvc.perform( get("/api/usuario/2") )
		.andDo( print() )
		.andExpect( status().isOk() )
		.andExpect( content().string( containsString("Daniela") ));
	}
	

}
