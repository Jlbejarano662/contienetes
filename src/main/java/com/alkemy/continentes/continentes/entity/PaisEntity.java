package com.alkemy.continentes.continentes.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pais")
@Getter
@Setter
@SQLDelete(sql = "UPDATE pais SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name = "cant_habitantes")
    private Long cantidadHabitantes;

    private Long superficie; //m2

    //Para buscar informacion
    @ManyToOne(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
    private ContinenteEntity continente;

    //Para guardar y actualizar
    @Column(name = "continente_id", nullable = false)
    private Long continenteId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "icon_pais",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private Set<IconEntity> icons = new HashSet<>();

    //Solo para SOFT DELETE:
    private boolean deleted = Boolean.FALSE;

    public void addIcon(IconEntity icon){this.icons.add(icon);}
    public void removeIcon(IconEntity icon){this.icons.remove(icon);}
}
