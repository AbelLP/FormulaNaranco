package org.pspr.entrega_formula.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pspr.entrega_formula.model.Piloto;

@NoArgsConstructor
@Getter
@Setter
public class PilotoDTO {

    private Piloto piloto;

    private Long victorias;

    public PilotoDTO(Piloto piloto, Long victorias) {
        this.piloto = piloto;
        this.victorias = victorias;
    }
}
