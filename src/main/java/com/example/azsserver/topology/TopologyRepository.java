package com.example.azsserver.topology;

import com.example.azsserver.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TopologyRepository extends JpaRepository<Topology, Long> {
    @Transactional
    Optional<List<Topology>> findTopologiesByAppUser(AppUser appUser);
    @Transactional
    Optional<Topology> findTopologyByTopologyName(String topologyName);
}
