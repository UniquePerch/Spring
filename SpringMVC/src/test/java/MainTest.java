import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MainTest {
    @Test
    public void test(){
        User user = new User();
        user.setPassword("123");
        user.setUsername("321");
        System.out.println(JSON.toJSON(user));
    }
}
