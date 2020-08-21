package com.ric.fab;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

            JsonElement je = new JsonParser().parse(buf);
            JsonObject all = je.getAsJsonObject();
            JsonElement je2 = all.get("statuses");
            JsonElement je9 = all.get("search_metadata");
            JsonObject metadata = je9.getAsJsonObject();
            JsonElement je10 = metadata.get("count");
            int count = je10.getAsInt();
            JsonArray statuses = je2.getAsJsonArray();
            for (int i = 0; i < statuses.size(); i++) {
                JsonElement je3 = statuses.get(i);
                JsonObject singlePost = je3.getAsJsonObject();
                JsonElement je4 = singlePost.get("text");
                JsonElement je8 = singlePost.get("created_at");
                JsonElement je5 = singlePost.get("user");
                JsonObject user = je5.getAsJsonObject();
                JsonElement je6 = user.get("name");
                JsonElement je7 = user.get("screen_name");
                String message = je4.getAsString();
                String name = je6.getAsString();
                String screenName = je7.getAsString();
                String createdAt = je8.getAsString();
                String[] completeDate;
            } }finally {
                    in.close();
                }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
