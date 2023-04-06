package com.example.azsserver.topology;

import com.example.azsserver.appuser.AppUser;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class Topology {
    @SequenceGenerator(
            name = "topologyIdSequenceGenerator",
            sequenceName = "topologyIdSequenceGenerator",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "topologyIdSequenceGenerator"
    )
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
    @Column(nullable = false)
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
