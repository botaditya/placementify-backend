package com.hashcode.placementify.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmailMessage {
    String subjectText;
    String emailBody;
    String recipientEmail;
}
