package br.com.luznovale.validators;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BuscaCEP {

	 public String getEndereco(String CEP) throws IOException {

	        // ***************************************************
	        try {

	            Document doc = Jsoup
	                    .connect("http://www.qualocep.com/busca-cep/" + CEP)
	                    .timeout(120000).get();
	            Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
	            for (Element urlEndereco : urlPesquisa) {
	                return urlEndereco.text();
	            }

	        } catch (SocketTimeoutException e) {

	        } catch (HttpStatusException w) {

	        }
	        return CEP;
	    }

	    public String getBairro(String CEP) throws IOException {

	        // ***************************************************
	        try {

	            Document doc = Jsoup
	                    .connect("http://www.qualocep.com/busca-cep/" + CEP)
	                    .timeout(120000).get();
	            Elements urlPesquisa = doc.select("td:gt(1)");
	            for (Element urlBairro : urlPesquisa) {
	                return urlBairro.text();
	            }

	        } catch (SocketTimeoutException e) {

	        } catch (HttpStatusException w) {

	        }
	        return CEP;
	    }

	    public String getCidade(String CEP) throws IOException {

	        // ***************************************************
	        try {

	            Document doc = Jsoup
	                    .connect("http://www.qualocep.com/busca-cep/" + CEP)
	                    .timeout(120000).get();
	            Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
	            for (Element urlCidade : urlPesquisa) {
	                return urlCidade.text();
	            }

	        } catch (SocketTimeoutException e) {

	        } catch (HttpStatusException w) {

	        }
	        return CEP;
	    }

	    public String getUF(String CEP) throws IOException {

	        // ***************************************************
	        try {

	            Document doc = Jsoup
	                    .connect("http://www.qualocep.com/busca-cep/" + CEP)
	                    .timeout(120000).get();
	            Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");
	            for (Element urlUF : urlPesquisa) {
	                return urlUF.text();
	            }

	        } catch (SocketTimeoutException e) {

	        } catch (HttpStatusException w) {

	        }
	        return CEP;
	    }

	    public String getLatLong(String CEP) throws IOException, ParseException {

	        // ***************************************************
	        try {

	            if (CEP.contains("-")) {
	                Document doc = Jsoup
	                        .connect(
	                                "http://maps.googleapis.com/maps/api/geocode/xml?address="
	                                        + CEP + "&language=pt-BR&sensor=true")
	                        .timeout(120000).get();
	                Elements lat = doc.select("geometry").select("location")
	                        .select("lat");
	                Elements lng = doc.select("geometry").select("location")
	                        .select("lng");
	                for (Element Latitude : lat) {
	                    for (Element Longitude : lng) {
	                        return Latitude.text() + "," + Longitude.text();
	                    }

	                }
	            } else {

	                StringBuilder cepHif = new StringBuilder(CEP);  
	                cepHif.insert(CEP.length() - 3, '-');

	                Document doc = Jsoup
	                        .connect(
	                                "http://maps.googleapis.com/maps/api/geocode/xml?address="
	                                        + cepHif + "&language=pt-BR&sensor=true")
	                        .timeout(120000).get();
	                Elements lat = doc.select("geometry").select("location")
	                        .select("lat");
	                Elements lng = doc.select("geometry").select("location")
	                        .select("lng");
	                for (Element Latitude : lat) {
	                    for (Element Longitude : lng) {
	                        return Latitude.text() + "," + Longitude.text();
	                    }

	                }
	            }

	        } catch (SocketTimeoutException e) {

	        } catch (HttpStatusException w) {

	        }
	        return CEP;
	    }
	    
	   public static void main(String[] args) throws IOException {
		BuscaCEP buscaCep = new BuscaCEP();
		String cep = "90000000";
		System.out.println("Bairro: "+buscaCep.getBairro(cep));
		System.out.println("Cidade: "+buscaCep.getCidade(cep));
		System.out.println("Endereco: "+buscaCep.getEndereco(cep));
		System.out.println("Estado: "+buscaCep.getUF(cep));
		try {
			System.out.println("Lat/lon: "+buscaCep.getLatLong(cep));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}