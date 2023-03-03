package com.example.azsserver.topology;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TopologyController {
    private final TopologyService topologyService;

    @PostMapping(value="api/saveTopology", produces="application/json")
    public ResponseEntity<Topology> saveTopology(@RequestBody TopologyRequest request) {
        return ResponseEntity.ok(topologyService.saveTopology(request));
    }
    @PostMapping("api/getTopologyByName")
    public ResponseEntity<Topology> getTopologyByName(@RequestBody TopologyRequest request) {
        return ResponseEntity.ok(topologyService.getTopologyByName(request));
    }
    @PostMapping("api/getTopologiesByUser")
    public ResponseEntity<List<Topology>> getTopologiesByUser(@RequestBody TopologyRequest request) {
        return ResponseEntity.ok(topologyService.getTopologiesByUser(request));
    }
}
