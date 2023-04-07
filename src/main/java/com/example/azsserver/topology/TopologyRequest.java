package com.example.azsserver.topology;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TopologyRequest {
    private final String username;
    private final String topologyName;
    private final String topologyJSON;
}
