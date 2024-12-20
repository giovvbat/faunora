package br.com.faunora.domain.dto.users;

import jakarta.validation.constraints.NotBlank;

public record LoginResponseRecordDto(@NotBlank String message, @NotBlank String token) {
}
