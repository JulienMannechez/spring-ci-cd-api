package com.devops.spring_ci_cd_api.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PipelineController {
    
    @GetMapping("/pipelines/run")
    public ResponseEntity<String> runPipeline() {
        return ResponseEntity.ok("Pipeline triggered successfully!");
    }
}
