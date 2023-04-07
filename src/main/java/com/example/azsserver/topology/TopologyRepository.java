package com.example.azsserver.topology;

import com.example.azsserver.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopologyRepository extends JpaRepository<Topology, Long> {
    Optional<List<Topology>> findTopologiesByAppUser(AppUser appUser);
    Optional<Topology> findTopologyByTopologyName(String topologyName);
}
