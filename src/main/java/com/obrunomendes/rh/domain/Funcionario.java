package com.obrunomendes.rh.domain;

import com.obrunomendes.rh.domain.converters.TipoSexoConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    private String matricula;
    private String nome;

    private LocalDate dataNascimento;

    @Convert(converter = TipoSexoConverter.class)
    private TipoSexo sexo;

    @Embedded
    private Endereco endereco;
}
