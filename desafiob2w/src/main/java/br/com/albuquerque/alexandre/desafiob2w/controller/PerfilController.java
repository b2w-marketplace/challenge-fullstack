package br.com.albuquerque.alexandre.desafiob2w.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.albuquerque.alexandre.desafiob2w.model.Perfil;

@Controller
@RequestMapping("/")
public class PerfilController {

	RestTemplate restTemplate;
	
	Perfil perfil;
	
	@RequestMapping(value = "perfil", method = RequestMethod.GET)
	public String usuario(Model model)  {

		restTemplate = new RestTemplate();
		
		String urlCarreira = "http://www.mocky.io/v2/5a5f4b692e00002b180a839d";
		String carreiraJson = restTemplate.getForObject(urlCarreira, String.class);
		
		String urlHabilidades = "http://www.mocky.io/v2/5a5f4b682e00006d140a839c";
		String habilidadesJson = restTemplate.getForObject(urlHabilidades, String.class);

		String urlPerfil = "http://www.mocky.io/v2/5a5f4be42e0000c21b0a83a3";
		String perfilJson = restTemplate.getForObject(urlPerfil, String.class);
		
		StringBuilder experienciaJson = new StringBuilder("\"experience\":\n["); 
		StringBuilder estudosJson = new StringBuilder("\"education\":\n[");  
		
		for(String tipo : carreiraJson.split("},"))
		{
			String[] campos = tipo.split(",\n");
			
			if(tipo.contains("\"type\": \"experience\""))
			{
				experienciaJson.append("{");
				
				campos[0] = campos[0].replace("[\n  {\n", "");
				campos[0] = campos[0].replace("{\n", "");
				experienciaJson.append(campos[0] + ", ");
				
				if(campos[2].contains("\"dateEnd\": null"))
				{
					experienciaJson.append("\"date\": " + campos[1].replace("\"dateStart\":" , "") + ", ");
				}
				else
				{
					String date = "\"date\": " + campos[1].replace("\"dateStart\":" , "") +
							" - " + campos[2].replace("\"dateEnd\":" , "") + ", ";
					//date = date.replace("  ", " ");
					date = date.replace("\" -      \"", " - ");
					
					experienciaJson.append(date);
				}
				
				experienciaJson.append(campos[3]);
				experienciaJson.append("},");
			}
			else
			{
				estudosJson.append("{");
				
				campos[0] = campos[0].replace("[\n  {\n", "");
				campos[0] = campos[0].replace("{\n", "");
				estudosJson.append(campos[0] + ", ");
				
				if(campos[2].equals("\"dateEnd\": null"))
				{
					estudosJson.append("\"date\": " + campos[1].replace("\"dateStart\":" , "") + ", ");
				}
				else
				{
					String date = "\"date\": " + campos[1].replace("\"dateStart\":" , "") +
							" - " + campos[2].replace("\"dateEnd\":" , "") + ", ";
					//date = date.replace("  ", " ");
					date = date.replace("\" -      \"", " - ");
					
					estudosJson.append(date);
				}
				
				estudosJson.append(campos[3]);
				estudosJson.append("},");
			}
		}
		
		experienciaJson.delete(experienciaJson.length()-1, experienciaJson.length());
		estudosJson.delete(estudosJson.length()-1, estudosJson.length());
		
		experienciaJson.append("\n]");
		estudosJson.append("\n]");
		
		//String perfilCompletoJson = "{\"profile\":" + perfilJson.substring(0, perfilJson.length()-1) + ", " + "\"skills\": " + 
				//habilidadesJson + ", " + experienciaJson + ", " + estudosJson + "} }";
		
		String perfilCompletoJson = perfilJson.substring(0, perfilJson.length()-1) + ", " + "\"skills\": " + 
				habilidadesJson + ", " + experienciaJson + ", " + estudosJson + "}";
		
		Gson gson = new Gson();
		perfil = gson.fromJson(perfilCompletoJson, Perfil.class);
		
		System.out.println("\n\n");
		System.out.println(perfil);
		System.out.println("\n\n");
		
		model.addAttribute("perfil", perfil);
		
		return "perfil";
	}

}
