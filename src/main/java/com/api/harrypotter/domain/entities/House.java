package com.api.harrypotter.domain.entities;

import java.util.UUID;

public record House(UUID id, String name, String description) {
}