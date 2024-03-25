package nl.loahy_v3.record;

import lombok.Builder;

@Builder
public record ContactRemarkRequest(
        Long contactId,
        String contactName,
        String contactEmail,
        Long contactPhone,
        String contactOrganisation,
        String contactRemark) {
}
