package edu.uw.covidsafe.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.uw.covidsafe.comms.NetworkConstant;

public class MessageRequest {

    MessageInfo[] RequestedQueries;

    public static MessageRequest parse(JSONObject obj) throws JSONException {
        MessageRequest messageRequest = new MessageRequest();
        if (obj.has("RequestedQueries")) {
            JSONArray arr = obj.getJSONArray("RequestedQueries");
            messageRequest.RequestedQueries = new MessageInfo[arr.length()];
            for (int i = 0; i < arr.length(); i++) {
                messageRequest.RequestedQueries[i] = MessageInfo.parse(arr.getJSONObject(i));
            }
        }
        return messageRequest;
    }

    public static JSONObject toJson(MessageInfo[] messageInfos) throws JSONException {
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        for (int i = 0; i < messageInfos.length; i++) {
            array.put(i, messageInfos[i].toJson());
        }
        obj.put("RequestedQueries", array);
        return obj;
    }

    public static String toHttpString() {
        return NetworkConstant.BASE_URL+"Message/";
    }
}
