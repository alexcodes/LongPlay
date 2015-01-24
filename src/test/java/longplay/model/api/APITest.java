package longplay.model.api;

import longplay.Main;
import longplay.model.content.AudioResponse;
import longplay.model.content.User;
import longplay.model.content.VideoResponse;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class APITest {
    @Before
    public void before() {
        try {
            System.getProperties().load(Main.class.getResourceAsStream("properties.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(APIConstants.ACCESS_TOKEN, "69b8ed64de2d1777075d84cf771fde3d5fc07140342388baf8903e4053da9568e8d02179020e947af71d9");
        System.setProperty(APIConstants.USER_ID, "14138812");
    }

    @Test
    public void testGetUser() throws Exception {
        User user = API.getUser();
        assertEquals("Алексеев Алексей", user.toString());
    }

    @Test
    public void testGetAudios() throws Exception {
        AudioResponse response = API.getAudios("Арбенина+Шоколад");
        assertEquals("Арбенина - Шоколад\n" , response.toString());
    }

    @Test
    public void testGetVideos() throws Exception {
        VideoResponse response = API.getVideos("one");
        assertEquals("The Glam vs Coolio & Snoop Dogg - One Night In L.A." , response.getVideos().get(0).toString());
    }
}