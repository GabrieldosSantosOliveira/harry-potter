package com.api.harrypotter.domain.entities;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public record House(UUID id, String name, String description) implements Serializable {
}