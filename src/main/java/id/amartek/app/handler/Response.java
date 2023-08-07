package id.amartek.app.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Response {
    public static ResponseEntity<Object> generate(HttpStatus status, String message)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Status", status.value());
        map.put("Message", message);

        return new ResponseEntity<Object>(map, status);
    }

    public static ResponseEntity<Object> generate(HttpStatus status, String message, Object data)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Status", status.value());
        map.put("Message", message);
        map.put("Data", data);

        return new ResponseEntity<Object>(map, status);
    }
}
