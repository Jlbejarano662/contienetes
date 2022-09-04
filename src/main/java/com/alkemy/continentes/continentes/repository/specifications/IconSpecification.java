package com.alkemy.continentes.continentes.repository.specifications;

import com.alkemy.continentes.continentes.dto.IconFiltersDTO;
import com.alkemy.continentes.continentes.entity.IconEntity;
import com.alkemy.continentes.continentes.entity.PaisEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Predicates;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class IconSpecification {

    public LocalDate string2LocalDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }

    public Specification<IconEntity> getByFilters(IconFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denominacion")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"
                        )
                );
            }

            if (StringUtils.hasLength(filtersDTO.getDate())) {
                predicates.add(
                        criteriaBuilder.equal(root.<LocalDate>get("fechaCreacion"), string2LocalDate(filtersDTO.getDate()))
                );
            }

            if (!CollectionUtils.isEmpty(filtersDTO.getCities())) {
                Join<PaisEntity, IconEntity> join = root.join("paises", JoinType.INNER);
                Expression<String> citiesId = join.get("id");
                predicates.add(
                        citiesId.in(filtersDTO.getCities())
                );
            }

            //Remove duplicates
            query.distinct(true);

            //Order resolver
            String orderByField  = "denominacion";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }
}
