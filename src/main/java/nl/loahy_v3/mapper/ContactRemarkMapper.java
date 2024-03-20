package nl.loahy_v3.mapper;

import nl.loahy_v3.dto.ContactRemarkDto;
import nl.loahy_v3.model.ContactRemark;

public class ContactRemarkMapper {
    public static ContactRemarkDto fromContactRemark(ContactRemark contactRemark) {
        return new ContactRemarkDto(contactRemark);
    }
}
