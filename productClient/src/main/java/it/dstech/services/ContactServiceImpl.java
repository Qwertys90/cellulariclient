package it.dstech.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ContactServiceImpl implements ContactService{
	private static final Logger logger = Logger.getLogger(ContactServiceImpl.class.getName());

		@Override
		public Contact saveContact(Contact contact, int id) {
			try {
				URL url = new URL("http://localhost:8082/contact/save/" +id);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");
				ObjectMapper mapper = new ObjectMapper();
				String jsonInString = mapper.writeValueAsString(contact);
				OutputStream os = conn.getOutputStream();
				os.write(jsonInString.getBytes());
				os.flush();

				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String output;
				StringBuffer response = new StringBuffer();
				while ((output = br.readLine()) != null) {
					logger.info(output);
					response.append(output);
				}
				String risposta = response.toString();
				ObjectMapper responseMapper = new ObjectMapper();
				return responseMapper.readValue(risposta, Contact.class);
			} catch (Exception e) {
				logger.warning(e.getMessage());
				return null;
			}
		}
	

	@Override
	public Contact getContactById(int id) {
		try {
			URL url = new URL("http://localhost:8082/contact/getbyid/" + id);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuffer response = new StringBuffer();
			while ((output = br.readLine()) != null) {
				logger.info(output);
				response.append(output);
			}
			String risposta = response.toString();
			ObjectMapper responseMapper = new ObjectMapper();
			return responseMapper.readValue(risposta, Contact.class);
		} catch (Exception e) {
			logger.warning(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Contact> getListContact() {
		try {
			URL url = new URL("http://localhost:8082/contact/getList");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuffer response = new StringBuffer();
			while ((output = br.readLine()) != null) {
				logger.info(output);
				response.append(output);
			}
			String risposta = response.toString();
			ObjectMapper responseMapper = new ObjectMapper();
			JavaType type = responseMapper.getTypeFactory().constructCollectionType(ArrayList.class, Contact.class);
			return responseMapper.readValue(risposta, type);
		} catch (Exception e) {
			logger.warning(e.getMessage());
			return null;
		}
	}
	
	@Override
	public Contact deleteContact(int id) {
		try {
			URL url = new URL("http://localhost:8082/contact/delete/" + id);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("DELETE");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuffer response = new StringBuffer();
			while ((output = br.readLine()) != null) {
				logger.info(output);
				response.append(output);
			}
			String risposta = response.toString();
			ObjectMapper responseMapper = new ObjectMapper();
			JavaType type = responseMapper.getTypeFactory().constructCollectionType(ArrayList.class, Contact.class);
			return responseMapper.readValue(risposta, type);
		} catch (Exception e) {
			logger.warning(e.getMessage());
			return null;
		}
	}
		
	@Override
	public Contact updateContact(Contact contact) {
		try {
			URL url = new URL("http://localhost:8082/contact/update");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("UPDATE");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuffer response = new StringBuffer();
			while ((output = br.readLine()) != null) {
				logger.info(output);
				response.append(output);
			}
			String risposta = response.toString();
			ObjectMapper responseMapper = new ObjectMapper();
			JavaType type = responseMapper.getTypeFactory().constructCollectionType(ArrayList.class, Contact.class);
			return responseMapper.readValue(risposta, type);
		} catch (Exception e) {
			logger.warning(e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<Contact> getListContactsByUserId(int id) {
		try {
			URL url = new URL("http://localhost:8082/contact/findByUser/" + id);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuffer response = new StringBuffer();
			while ((output = br.readLine()) != null) {
				logger.info(output);
				response.append(output);
			}
			String risposta = response.toString();
			ObjectMapper responseMapper = new ObjectMapper();
			JavaType type = responseMapper.getTypeFactory().constructCollectionType(List.class, Contact.class);
			return responseMapper.readValue(risposta, type);
		} catch (Exception e) {
			logger.warning(e.getMessage());
			return null;
		}
	}

}
