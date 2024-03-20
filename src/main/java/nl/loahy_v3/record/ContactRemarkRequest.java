package nl.loahy_v3.record;

public record ContactRemarkRequest(
        Long id,
        String contactName,
        String contactEmail,
        Long contactPhone,
        String contactOrganisation,
        String contactRemark) {
}
