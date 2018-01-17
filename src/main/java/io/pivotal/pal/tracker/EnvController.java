package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.HashMap;

@RestController
public class EnvController {

    private final String port;
    private final String memory;
    private final String index;
    private final String address;

    public EnvController(@Value("${PORT:NOT SET}") String port, @Value("${MEMORY_LIMIT:NOT SET}") String memoryLimit, @Value("${CF_INSTANCE_INDEX:NOT SET}") String index, @Value("${CF_INSTANCE_ADDR:NOT SET}") String address){
        this.port = port;
        this.memory = memoryLimit;
        this.index = index;
        this.address = address;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){

    Map<String, String> variables = new HashMap<>();
    variables.put("PORT", port);
    variables.put("MEMORY_LIMIT", memory);
    variables.put("CF_INSTANCE_INDEX", index);
    variables.put("CF_INSTANCE_ADDR", address);

    return variables;
    }
}
