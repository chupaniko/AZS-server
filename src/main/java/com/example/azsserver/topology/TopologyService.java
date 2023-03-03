package com.example.azsserver.topology;

import com.example.azsserver.appuser.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TopologyService {
    private final TopologyRepository topologyRepository;
    private final UserService userService;

    public Topology saveTopology(TopologyRequest request) {
        String username = request.getUsername();
        String topologyName = request.getTopologyName();
        String topologyJSON = request.getTopologyJSON();
        Topology topology = new Topology(userService.getUserByUsername(username), topologyJSON, topologyName);
        topologyRepository.save(topology);

        return topology;
    }
    public Topology getTopologyByName(TopologyRequest request) {
        return topologyRepository.findTopologyByTopologyName(request.getTopologyName()).orElseThrow();
    }
    public List<Topology> getTopologiesByUser(TopologyRequest request) {
        return topologyRepository.findTopologiesByAppUser(userService.getUserByUsername(request.getUsername())).orElseThrow();
    }
}
