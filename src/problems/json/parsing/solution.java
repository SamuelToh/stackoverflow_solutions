/**
 * Created by tigerroarz on 16/06/16.
 */
import com.google.common.base.Objects;
import org.json.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class solution {

    public static final String JSON_DATA_FILE_PATH = "./data/source_37848106.json";

    private static boolean hasMoreFamilyName(JSONObject json) {
        return json.has("familyMembers") && json.get("familyMembers") != JSONObject.NULL;
    }

    private static void trackFirstName(Map<String, Integer> nameTracker, JSONObject json) {
        if (!nameTracker.containsKey(json.getString("firstName"))) {
            nameTracker.put(json.getString("firstName"), /*DUMMY VALUE =*/1);
        }
    }

    private static void getNames(Map<String,Integer> nameTracker, JSONArray jsonArr) {
        for (int i = 0; i< jsonArr.length(); i++) {
            JSONObject item = jsonArr.getJSONObject(i);
            if (hasMoreFamilyName(item)) {
                getNames(nameTracker, item.getJSONArray("familyMembers"));
            }
            trackFirstName(nameTracker, item);
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> nameTracker = new HashMap<String, Integer>();

        try {
            String text = Files.toString(new File(JSON_DATA_FILE_PATH), Charsets.UTF_8);
            JSONObject json = new JSONObject(text);
            getNames(nameTracker, json.getJSONArray("members"));
        }
        catch (Exception ex) {
            System.out.println("Something is wrong.");
        }

        for (Map.Entry<String,Integer> entry : nameTracker.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
