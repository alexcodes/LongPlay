package longplay.view;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStageControllerTest {

    @Test
    public void testSearchToken() throws Exception {
        String url = "https://oauth.vk.com/blank.html#access_token=123abc&expires_in=0&user_id=123";
        assertTrue(new LoginStageController().containsToken(url));
        assertEquals("123abc", System.getProperty("access_token"));
    }
}