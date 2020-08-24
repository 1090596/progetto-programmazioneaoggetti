package com.ric.fab.letturafile;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ric.fab.database.DataBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;*/

public class ClasseFile {

    public static void main(String[] args) {

        //String url = "https://api.dropboxapi.com/2/files/list_folder";
        String url = "https://api.dropboxapi.com/2/files/get_metadata";
        try {

            HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
            openConnection.setRequestMethod("POST");
            openConnection.setRequestProperty("Authorization",
                    "Bearer -VLBD1Cvt5UAAAAAAAAAAZXMyJ0knLSi8qnXozJyG6dcZ5JsHuifhTCE8ypMd1n_");
            openConnection.setRequestProperty("Content-Type", "application/json");
            openConnection.setRequestProperty("Accept", "application/json");
            openConnection.setDoOutput(true);
			/*String jsonBody = "{\r\n" + "    \"path\": \"\",\r\n" + "    \"recursive\": true,\r\n"
					+ "    \"include_media_info\": false,\r\n" + "    \"include_deleted\": false,\r\n"
					+ "    \"include_has_explicit_shared_members\": false,\r\n"
					+ "    \"include_mounted_folders\": true,\r\n" + "    \"include_non_downloadable_files\": true\r\n"
					+ "}";*/
            String jsonBody = "{\r\n" +
                    "    \"path\": \"/Photos/Sample Album/img001.jpg\",\r\n" +
                    "    \"include_media_info\": true,\r\n" +
                    "    \"include_deleted\": false,\r\n" +
                    "    \"include_has_explicit_shared_members\": false\r\n" +
                    "}";

            try (OutputStream os = openConnection.getOutputStream()) {
                byte[] input = jsonBody.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            InputStream in = openConnection.getInputStream();

            String data = "";
            String line = "";
            try {
                InputStreamReader inR = new InputStreamReader(in);
                BufferedReader buf = new BufferedReader(inR);

                while ((line = buf.readLine()) != null) {
                    data += line;
                    System.out.println(line);
                }

            JsonElement je1 = new JsonParser().parse(buf);
            JsonObject all = je1.getAsJsonObject();
            JsonElement je2 = all.get(".tag");
            JsonElement je9 = all.get("name");
            JsonElement je10 = all.get("client_modified");
                JsonElement je3 = all.get("size");
                JsonElement je4 = all.get("media_info");
                JsonObject media= je4.getAsJsonObject();
                JsonElement je8 = media.get("metadata");
                JsonObject metadata = je8.getAsJsonObject();
                JsonElement je5 = metadata.get(".tag");
                JsonElement je6 = metadata.get("dimensions");
                JsonObject dimensions = je6.getAsJsonObject();
                JsonElement je7 = dimensions.get("height");
                JsonElement je11 = dimensions.get("width");
                String tag = je2.getAsString();
                Long size = je3.getAsLong();
                String type = je5.getAsString();
                int height = je7.getAsInt();
                String name = je9.getAsString();
                String last_mod = je10.getAsString();
                int width = je11.getAsInt();
                DataBase.getDataBaseList().add(new DataBase(tag,name,last_mod,size, type,height, width));
             }finally {
                    in.close();
                }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
