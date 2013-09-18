package ru.jeasy.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/*
TODO search commas
 */
public class JsonObject {
    private Map map;

    public JsonObject(String object) throws JsonException {
        tryParse(object);
    }

    private void tryParse(String object) throws JsonException {
        object = object.trim();
        if (object.charAt(0) != '{' && object.charAt(object.length() - 1) != '}') {
            throw new JsonException("Wrong format exception");
        }
        try {
            List<JsonPair> pairs = new ArrayList<JsonPair>();
            JsonPair[] temp;
        } catch (Exception je) {
            //
        }
    }
}