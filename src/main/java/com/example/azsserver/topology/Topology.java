package com.example.azsserver.topology;

import com.example.azsserver.appuser.AppUser;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class Topology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;
    @Column(nullable = false)
    @Lob
    private String topologyJSON;
    @Column(nullable = false, unique = true)
    private String topologyName;

    public AppUser getAppUser() {
        return appUser;
    }

    public String getTopologyJSON() {
        return topologyJSON;
    }

    public String getTopologyName() {
        return topologyName;
    }

    public void setTopologyJSON(String topologyJSON) {
        this.topologyJSON = topologyJSON;
    }

    public void setTopologyName(String topologyName) {
        this.topologyName = topologyName;
    }

    public Topology(AppUser appUser, String topologyJSON, String topologyName) {
        this.appUser = appUser;
        this.topologyJSON = topologyJSON;
        this.topologyName = topologyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topology topology = (Topology) o;
        return Objects.equals(id, topology.id) && Objects.equals(appUser, topology.appUser) && Objects.equals(topologyJSON, topology.topologyJSON) && Objects.equals(topologyName, topology.topologyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appUser, topologyJSON, topologyName);
    }
}
