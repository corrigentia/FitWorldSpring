package org.corrigentia.fitrest.adal.domain.entity.security;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.corrigentia.fitrest.adal.domain.entity.MartialArtClassEntity;

import java.util.LinkedHashSet;
import java.util.Set;

//@EqualsAndHashCode(callSuper = true, of = {"id", "email", "role"})
@EqualsAndHashCode(callSuper = true)
@Entity(name = "Student")
// @Table(name = "student")
@Getter
@Setter
// java: The old-style 'exclude/of' parameter cannot be used together with the new-style @Include / @Exclude annotations.
//@ToString(of = {"id", "email", "role"})
@ToString(callSuper = true)
// java: The old-style 'exclude/of' parameter cannot be used together with the new-style @Include / @Exclude annotations.
@RequiredArgsConstructor
public class StudentEntity extends MartialArtistEntity {
    public static final String JOINTABLE_CLASSESTAKEN_NAME = "martial_artist_classes_taken";
    public static final String JOINCOLUMNS_JOINCOLUMN_CLASSESTAKEN_NAME = "student_id";
    public static final String INVERSEJOINCOLUMNS_JOINCOLUMN_CLASSESTAKEN_NAME = "martial_art_class_id";

    @ManyToMany
    @JoinTable(name = StudentEntity.JOINTABLE_CLASSESTAKEN_NAME, joinColumns = @JoinColumn(name = StudentEntity.JOINCOLUMNS_JOINCOLUMN_CLASSESTAKEN_NAME), inverseJoinColumns = @JoinColumn(name = StudentEntity.INVERSEJOINCOLUMNS_JOINCOLUMN_CLASSESTAKEN_NAME))
//    java: The old-style 'exclude/of' parameter cannot be used together with the new-style @Include / @Exclude annotations.
//    @ToString.Exclude
    private Set<MartialArtClassEntity> classesTaken = new LinkedHashSet<>();

    public Set<MartialArtClassEntity> getClassesTaken() {
        return Set.copyOf(this.classesTaken);
    }

    public void addClassTaken(MartialArtClassEntity combatClass) {
        this.classesTaken.add(combatClass);
    }

    public void removeClassTaken(MartialArtClassEntity combatClass) {
        this.classesTaken.remove(combatClass);
    }
}
