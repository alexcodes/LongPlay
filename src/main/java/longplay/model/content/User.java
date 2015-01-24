package longplay.model.content;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class User implements ContentConstants {
    private String firstName;
    private String lastName;

    public User() {}

    public User(String json) throws JSONException {
        JSONObject response = new JSONObject(json);
        JSONArray array = response.getJSONArray(RESPONSE);
        JSONObject user = array.getJSONObject(0);
        firstName = user.getString(FIRST_NAME);
        lastName = user.getString(LAST_NAME);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}
