package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class PokemonParser {

	// ポケモンのデータ１匹分取得
	public Pokemon getPokemon(int id) {
		String urlString = "https://pokeapi.co/api/v2/pokemon/" + id;
		Pokemon pokemon = null;

		JsonObject root = this.getRoot(urlString);
		if (root != null) {
			pokemon = new Pokemon();
			// 図鑑番号の設定
			pokemon.setId(id);
			// 高さ、体重の取得
			double height = root.get("height").getAsDouble() / 10;
			double weight = root.get("weight").getAsDouble() / 10;
			pokemon.setHeight(height);
			pokemon.setWeight(weight);
			// 画像の取得
			JsonObject sprites = root.get("sprites").getAsJsonObject();
			JsonObject other = sprites.get("other").getAsJsonObject();
			JsonObject officialArtWork = other.get("official-artwork").getAsJsonObject();
			String sprite = officialArtWork.get("front_default").getAsString();
			pokemon.setSprite(sprite);
			
			// 名前とテキストの取得
			this.setSpecies(pokemon, id);
		}

		return pokemon;
	}


	private void setSpecies(Pokemon pokemon, int id) {
		String urlString = "https://pokeapi.co/api/v2/pokemon-species/" + id;
		JsonObject root = getRoot(urlString);

		
		JsonArray names = root.get("names").getAsJsonArray();
		for(JsonElement element : names) {
			JsonObject object = element.getAsJsonObject();
			JsonObject language = object.get("language").getAsJsonObject();
			String languageName = language.get("name").getAsString();
			
			if (languageName.equals("ja")) {
				String name = object.get("name").getAsString();
				pokemon.setName(name);
				break;
			}
		}

	
		JsonArray flavorTextEntries = root.get("flavor_text_entries").getAsJsonArray();
		for (JsonElement element : flavorTextEntries) {
			JsonObject object = element.getAsJsonObject();
			JsonObject language = object.get("language").getAsJsonObject();
			String languageName = language.get("name").getAsString();
			
			if (languageName.equals("ja")) {
				String text = object.get("flavor_text").getAsString();
				text = text.replace("\n", "<br>");// 改行コードをhtmlの<br>タグに変更
				pokemon.setText(text);
				break;
			}
		}
	}


	private JsonObject getRoot(String urlString) {
		JsonReader reader = null;
		HttpURLConnection con = null;
		JsonObject root = null;
		try {
			
			URL url = new URL(urlString);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			InputStream is = con.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			
			reader = new JsonReader(isr);
			
			root = new Gson().fromJson(reader, JsonObject.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				con.disconnect();
			}
		}
		return root;
	}
}
