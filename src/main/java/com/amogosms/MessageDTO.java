package com.amogosms;

import java.time.LocalDateTime;

public record MessageDTO(String message,
                         LocalDateTime createdAt) {
}
