package fr.syrql.hellsky.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.syrql.hellsky.spawners.data.PlayerSpawners;

public class IOUtil {

    private Gson gson;

    public IOUtil() {
        this.gson = createGsonInstance();
    }


    public Gson createGsonInstance() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();
    }

    public String serialize(PlayerSpawners playerData) {
        return this.gson.toJson(playerData);
    }

    public PlayerSpawners deserialize(String json) {
        return this.gson.fromJson(json, PlayerSpawners.class);
    }

}

