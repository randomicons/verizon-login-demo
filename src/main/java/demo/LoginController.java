package demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    private static Map<String, String> fakeDb = new HashMap<>();

    static {
        fakeDb.put("java", "java");
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> checkAuth(@RequestBody UserDetails details) {
        if (fakeDb.containsKey(details.userId) && fakeDb.get(details.userId).equals(details.password)) {
            return new ResponseEntity<>("Authentication Success", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }

    static class UserDetails {
        String userId;
        String password;

        public UserDetails(String userId, String password) {
            this.userId = userId;
            this.password = password;
        }
    }
}

