package com.growhubsn.ghlink.dto;

import com.growhubsn.ghlink.model.Paragraphe;
import com.growhubsn.ghlink.model.Rubrique;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ParagrapheRequest{

    private Paragraphe paragraphe;

    private Rubrique rubrique;

}