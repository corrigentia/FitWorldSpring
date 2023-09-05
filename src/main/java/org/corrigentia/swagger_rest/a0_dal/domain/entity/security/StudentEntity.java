package org.corrigentia.swagger_rest.a0_dal.domain.entity.security;

import java.util.LinkedHashSet;
import java.util.Set;

import org.corrigentia.swagger_rest.a0_dal.domain.entity.MartialArtClassEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity(name = "Student")
// @Table(name = "student")
@Data
public class StudentEntity extends MartialArtistEntity {
    public static final String JOINTABLE_CLASSESTAKEN_NAME = "martial_artist_classes_taken";
    public static final String JOINCOLUMNS_JOINCOLUMN_CLASSESTAKEN_NAME = "student_id";
    public static final String INVERSEJOINCOLUMNS_JOINCOLUMN_CLASSESTAKEN_NAME = "classes_id";
    
    @ManyToMany
    @JoinTable(name = StudentEntity.JOINTABLE_CLASSESTAKEN_NAME, joinColumns = @JoinColumn(name = StudentEntity.JOINCOLUMNS_JOINCOLUMN_CLASSESTAKEN_NAME), inverseJoinColumns = @JoinColumn(name = StudentEntity.INVERSEJOINCOLUMNS_JOINCOLUMN_CLASSESTAKEN_NAME))
    private Set<MartialArtClassEntity> classesTaken = new LinkedHashSet<>(20);

}
