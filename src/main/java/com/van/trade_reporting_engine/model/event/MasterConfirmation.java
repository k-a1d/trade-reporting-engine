package com.van.trade_reporting_engine.model.event;

import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@Data
@NoArgsConstructor
@XmlAccessorType(FIELD)
public final class MasterConfirmation {
    private String masterConfirmationType;
    private String masterConfirmationDate;
    private String masterConfirmationAnnexDate;
    private String masterConfirmationAnnexType;
}