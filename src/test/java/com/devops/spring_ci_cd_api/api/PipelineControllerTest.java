package com.devops.spring_ci_cd_api.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class PipelineControllerTest {

    @Test
    void testRunPipeline() {
        PipelineController controller = new PipelineController();
        ResponseEntity<String> response = controller.runPipeline();

        assertEquals(response.getStatusCode().value(), 200);
        assertEquals(response.getBody(), "Pipeline triggered successfully!");
    }
    
}
