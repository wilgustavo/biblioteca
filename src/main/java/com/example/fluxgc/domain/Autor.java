package com.example.fluxgc.domain;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.firestore.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collectionName = "autor")
public class Autor {

    @DocumentId
    private String id;
    private String nombre;
}
