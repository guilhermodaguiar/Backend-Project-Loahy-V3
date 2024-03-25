package nl.loahy_v3.record;

public record UserRequest(
        Long userId,
        String email,
        String password,
        String apikey,
        String firstName,
        String lastName) {
}
