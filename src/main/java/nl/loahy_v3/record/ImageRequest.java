package nl.loahy_v3.record;

import lombok.Builder;

@Builder
public record ImageRequest(
        Long id,
        String fileName,
        String contentType,
        String url
) {
}
